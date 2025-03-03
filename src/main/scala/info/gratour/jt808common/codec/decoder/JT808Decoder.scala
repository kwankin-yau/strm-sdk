/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment
import info.gratour.jt808common.codec.{CodecError, CrcError}
import info.gratour.jt808common.protocol.{JT808Frame, JT808Msg}
import info.gratour.jt808common.{AdasDialect, TimerProvider}
import info.gratour.jtcommon.NettyUtils
import io.netty.buffer.{ByteBuf, ByteBufAllocator, Unpooled, UnpooledByteBufAllocator}
import org.apache.commons.codec.binary.Hex
import org.checkerframework.checker.nullness.qual.{NonNull, Nullable}

import java.util

/**
 * JT808 解码器抽象类
 * 
 * @param adasDialect ADAS 方言
 * @param alloc 字节缓冲区分配器
 * @param timerProvider 定时器提供者
 * @param ignoreDecodeFrameError 是否忽略解码帧错误
 * @param simplified 是否使用简化解码。简化解码可能会丢失一些信息，用于不严格要求消息完整性的场景。
 * @param verifyCrc 是否验证CRC
 */
abstract class AbstractJT808Decoder(
                                     adasDialect           : AdasDialect,
                                     alloc                 : ByteBufAllocator,
                                     timerProvider         : TimerProvider,
                                     ignoreDecodeFrameError: Boolean,
                                     simplified            : Boolean,
                                     verifyCrc             : Boolean
                                   ) extends AutoCloseable {

  private val frameDecoder = new JT808FrameDecoder(alloc)
  private val decodeTempBuf = JT808FrameDecoder.allocTempBuf()
  private val splitList = new util.ArrayList[ByteBuf]()
  private val msgDecoder = new JT808MsgDecoder(adasDialect, simplified)
  private val fragmentManager = new JT808PacketFragmentManager(alloc, timerProvider)
  private var protoVer: Option[Byte] = None
  private var simNo: String = _

  private val fragmentTimeoutCallback = new FragmentTimeoutCallback {
    override def onFragmentTimeout(collectedFragment: CollectedFragment): Unit = {
      throw new CodecError("Fragment collect timeout.")
    }
  }

  /**
   * 收到消息回调
   * @param m 解码后的消息
   * @param customData 自定义数据
   */
  def onMsgRecv(m: JT808Msg, customData: AnyRef): Unit

  override def close(): Unit = {
    frameDecoder.close()
    fragmentManager.close()
  }

  private def frameRecv(frame: JT808Frame, customData: AnyRef): Unit = {
    try {
      if (simNo == null) {
        simNo = frame.getHeader.getSimNo
        protoVer = Some(frame.getHeader.getProtoVer)
      }

      val m = msgDecoder.decode(frame, decodeTempBuf)
      onMsgRecv(m, customData)
    } finally {
      frame.release()
    }
  }

  /**
   * 解码字节缓冲区到 JT808Msg。解码后的消息将发送给 `receiver`。
   *
   * @param buf        ByteBuf 包含要解码的内容。
   * @param customData 可选的客户端数据，此对象将作为 `customData` 传递给 `receiver.onMsgRecv(msg, customData)`。
   * @throws CrcError   如果 CRC 验证失败。
   * @throws CodecError 其他解码错误。
   *
   */
  def decode(@NonNull buf: ByteBuf, @Nullable customData: AnyRef): Unit = {
    frameDecoder.splitAndUnescape(buf) match {
      case DecodeState.UNRECOGNIZED =>
        throw new CodecError("Unrecognized frame.")

      case DecodeState.DECODED =>
        splitList.clear()
        frameDecoder.getSplit(splitList)

        try {
          splitList.forEach(
            f => {
              val readerIndex = f.readerIndex()
              val frame = JT808FrameDecoder.decodeFrame(f, decodeTempBuf, verifyCrc)
              if (frame == null) {
                if (!ignoreDecodeFrameError) {
                  f.readerIndex(readerIndex)
                  throw new CodecError("Unable decode frame: " + NettyUtils.bufToHex(f))
                }
              } else {
                if (frame.getHeader.isSplit) {
                  val p = fragmentManager.collect(frame, fragmentTimeoutCallback)
                  if (p != null) {
                    frameRecv(p, customData)
                  }
                } else
                  frameRecv(frame, customData)
              }
            }
          )
        } finally {
          splitList.forEach(f => f.release())
          splitList.clear()
        }


      case DecodeState.RECOGNIZED =>

    }
  }

  /**
   * 获取终端识别号
   * @return 终端识别号
   */
  def getSimNo: String = simNo

  /**
   * 获取协议版本
   * @return 协议版本
   */
  def getProtoVer: Option[Byte] = protoVer
}

/**
 * JT808 消息接收器
 */
trait JT808MsgReceiver {

  /**
   * 收到消息回调
   * @param m 解码后的消息
   * @param customData 自定义数据
   */
  def onMsgRecv(@NonNull m: JT808Msg, @Nullable customData: AnyRef): Unit
}


/**
 * JT808 解码器
 * 
 * @param adasDialect ADAS 方言
 * @param alloc 字节缓冲区分配器
 * @param timerProvider 定时器提供者
 * @param receiver 消息接收器
 * @param ignoreDecodeFrameError 是否忽略解码帧错误
 * @param simplified 是否使用简化解码。简化解码可能会丢失一些信息，用于不严格要求消息完整性的场景。
 * @param verifyCrc 是否验证CRC
 */
class JT808Decoder(
                    adasDialect           : AdasDialect,
                    alloc                 : ByteBufAllocator,
                    timerProvider         : TimerProvider,
                    receiver              : JT808MsgReceiver,
                    ignoreDecodeFrameError: Boolean,
                    simplified            : Boolean,
                    verifyCrc             : Boolean
                  )
  extends AbstractJT808Decoder(
    adasDialect,
    alloc,
    timerProvider,
    ignoreDecodeFrameError,
    simplified,
    verifyCrc
  ) {
  override def onMsgRecv(m: JT808Msg, customData: AnyRef): Unit = receiver.onMsgRecv(m, customData)
}

//object JT808Decoder {
//  //  private final val EMPTY_RESULT: java.util.List[JT808Msg] = new util.ArrayList[JT808Msg]()
//
//  def decodeAndPrint(packetDataHex: String): Unit = {
//    val bytes = Hex.decodeHex(packetDataHex)
//    val buf = Unpooled.wrappedBuffer(bytes)
//    try {
//      val decoder = new JT808Decoder(
//        AdasDialect.GDRTA_2020, UnpooledByteBufAllocator.DEFAULT, null, new JT808MsgReceiver {
//          override def onMsgRecv(m: JT808Msg, data: AnyRef): Unit = {
//            println(s"Received : ${m}")
//          }
//        }, false, false, true
//      )
//
//      decoder.decode(buf, null)
//    } catch {
//      case t: Throwable =>
//        t.printStackTrace()
//    } finally {
//      buf.release()
//    }
//  }
//
//
//}

