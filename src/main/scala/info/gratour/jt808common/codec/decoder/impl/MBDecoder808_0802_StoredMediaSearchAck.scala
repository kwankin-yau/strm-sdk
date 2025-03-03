/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0802_StoredMediaSearchAck
import info.gratour.jt808common.protocol.msg.types.JT808MediaInfo
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0802_StoredMediaSearchAck
import io.netty.buffer.ByteBuf

/**
 * 多媒体数据检索应答(0x0802)消息体解码器
 */
object MBDecoder808_0802_StoredMediaSearchAck extends JT808MsgBodyDecoder[JT808Msg_0802_StoredMediaSearchAck] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(
                              protoVer: Byte,
                              adasDialect: AdasDialect,
                              m: JT808Msg_0802_StoredMediaSearchAck,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val cnt = body.readUnsignedShort()
    val ackParams = new JT808AckParams_0802_StoredMediaSearchAck
    val mediaInfos = new Array[JT808MediaInfo](cnt)
    ackParams.setMediaInfos(mediaInfos)
    m.setAckParams(ackParams)

    val recvTime = System.currentTimeMillis()

    for (i <- 0 until cnt) {
      val mediaInfo = new JT808MediaInfo
      mediaInfo.setMediaId(body.readUnsignedInt())
      mediaInfo.setTyp(body.readByte())
      mediaInfo.setChannel(body.readByte())
      mediaInfo.setEvtCode(body.readByte())

      val slice = body.slice(body.readerIndex(), 28)
      val t = MBDecoder808_Track.decodeTrack(
        protoVer,
        adasDialect,
        m,
        slice,
        tempBuf,
        recvTime,
        retransmit = false
      )
      mediaInfo.setTrk(t)
    }
  }

}
