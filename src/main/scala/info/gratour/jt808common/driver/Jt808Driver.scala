/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.driver

import com.lucendar.gnss.sdk.driver.{AbstractGnssDriver, GnssDriverContext, GnssDriverFactory}
import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment
import info.gratour.jt808common.codec.decoder.{DecodeState, FragmentTimeoutCallback, JT808FrameDecoder, JT808MsgDecoder, JT808PacketFragmentManager}
import info.gratour.jt808common.codec.encoder.{DefaultSeqNumAllocator, JT808MsgEncoder, SeqNumAllocator}
import info.gratour.jt808common.driver.Jt808Driver.LOGGER
import info.gratour.jt808common.protocol.msg.JT808Msg_8107_QryAttrs
import info.gratour.jt808common.protocol.{JT808Frame, JT808Msg}
import info.gratour.jtcommon.{ByteBufBackOffReader, LazyBytesProvider}
import io.netty.buffer.ByteBuf

import java.util


class Jt808Driver(
                   config           : util.Map[String, String],
                   verifyCrc        : Boolean,
                   simplifiedDecoder: Boolean,
                   ctx              : GnssDriverContext
                 )
  extends AbstractGnssDriver(config, verifyCrc, simplifiedDecoder, ctx) {

  private final val alloc = ctx.alloc()
  private final val adasDialect =
    AdasDialect.valueOfDefault(findStringAttr(GnssDriverFactory.CONFIG__ADAS_DIALECT))
  private var frameDecoder: JT808FrameDecoder = new JT808FrameDecoder(alloc)
  private val msgDecoder: JT808MsgDecoder = new JT808MsgDecoder(adasDialect, simplifiedDecoder)
  private val tempBuf: Array[Byte] = JT808MsgDecoder.allocDecodeTempBuf
  private var packetFragmentManager: JT808PacketFragmentManager =
    new JT808PacketFragmentManager(alloc, ctx.timerProvider())
  private val splittedBuf: java.util.List[ByteBuf] = new util.ArrayList[ByteBuf]()
  private val msgSeqNoSeed: SeqNumAllocator = new DefaultSeqNumAllocator
  private var msgEncoder: JT808MsgEncoder = _
  private var msgEncodeTempBuf: ByteBuf = alloc.buffer()
  private var protoVer: Option[Int] = None
  private var simNo: String = _

  override def reset(): Unit = {
    super.reset()

    if (frameDecoder != null)
      frameDecoder.close()
    frameDecoder = new JT808FrameDecoder(alloc)

    if (packetFragmentManager != null) {
      packetFragmentManager.close()
      packetFragmentManager = new JT808PacketFragmentManager(alloc, ctx.timerProvider())
    }

    while (!splittedBuf.isEmpty) {
      splittedBuf.remove(0).release()
    }
    if (msgEncodeTempBuf != null) {
      msgEncodeTempBuf.clear()
    }
  }

  override def close(): Unit = {
    if (frameDecoder != null) {
      frameDecoder.close()
      frameDecoder = null
    }

    if (packetFragmentManager != null) {
      packetFragmentManager.close()
      packetFragmentManager = null
    }

    while (!splittedBuf.isEmpty) {
      splittedBuf.remove(0).release()
    }

    if (msgEncodeTempBuf != null) {
      msgEncodeTempBuf.release()
      msgEncodeTempBuf = null
    }
  }

  private def protoVerGot(ver: Byte): Unit = {
    protoVer = Some(ver)
    msgEncoder = new JT808MsgEncoder(protoVer.getOrElse(0).toByte, adasDialect)
  }

  private final val fragmentTimeoutCallback = new FragmentTimeoutCallback {
    override def onFragmentTimeout(f: CollectedFragment): Unit = {
      LOGGER.whenDebugEnabled {
        val entries = f.getFrames.map(f => f.getHeader.getSplitInfo.getPacketSeqNo).mkString("[", ",", "]")
        LOGGER.debug(s"onFragmentTimeout: total=${f.getTotalCount}, recv=${f.getRecvCount}, entries=${entries}")
      }
      f.close()
    }
  }

  override def decode(buf: ByteBuf): Unit = {
    val dr = frameDecoder.splitAndUnescape(buf)
    if (dr == DecodeState.UNRECOGNIZED)
      throw new CodecError("Unrecognized packet")

    if (dr != DecodeState.DECODED)
      return

    frameDecoder.getSplit(splittedBuf)
    var continue = true

    try {
      def receiveFrame(frame: JT808Frame, bytes: LazyBytesProvider): Unit = {
        try {
          val msg = msgDecoder.decode(frame, tempBuf)
          if (msg == null) {
            ctx.onMsgDecodingFailed(bytes, null)
            continue = false
            return
          }
          ctx.onFrameDecoded(bytes)

          // before we decode the simNo and got onlineTerminal, cache the message
          if (simNo == null) {
            simNo = frame.getHeader.getSimNo
            ctx.onRecognized(simNo, frame.getHeader.getProtoVer.toString)
          }

          ctx.onMsgDecoded(msg)
        } finally {
          frame.close()
        }
      }

      for (i <- 0 until splittedBuf.size() if continue) {
        val splitted = splittedBuf.get(i)
        var frame: JT808Frame = null
        val backOff = new ByteBufBackOffReader(splitted)

        try {
          frame = JT808FrameDecoder.decodeFrame(splitted, tempBuf, verifyCrc)
          if (frame != null) {
            if (protoVer.isEmpty)
              protoVerGot(frame.getHeader.getProtoVer)

            if (frame.getHeader.isSplit) {
              val packet = packetFragmentManager.collect(frame, fragmentTimeoutCallback)
              if (packet != null)
                receiveFrame(packet, backOff)
            } else
              receiveFrame(frame, backOff)
          } else {
            // decode failed, close connection
            ctx.onFrameDecodingFailed(backOff, null)
          }
        } catch {
          case ex: Exception =>
            ctx.onFrameDecodingFailed(backOff, ex)
            continue = false
        }
      }
    } finally {
      splittedBuf.forEach(b => b.release())
      splittedBuf.clear()
    }
  }

  override def buildCheckAliveMsg(simNo: String): JT808Msg = {
    val r = new JT808Msg_8107_QryAttrs()
    r.setSimNo(simNo)

    r
  }

  override def encode(msg: JT808Msg, out: ByteBuf): Unit = {
    msg.setSeqNo(msgSeqNoSeed.nextSeqNo())

    if (msgEncoder == null) {
      val errMsg = "Try to send command before receive terminal message."
      LOGGER.error(errMsg)
      return
    }

    val bytes = new ByteBufBackOffReader(out)
    msgEncoder.encode(msgSeqNoSeed, msg, msgEncodeTempBuf, out)

    ctx.onSendMsg(msg, bytes)
  }
}

object Jt808Driver {
  private final val LOGGER = Logger("jt808.driver")
}
