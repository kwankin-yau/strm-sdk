/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0801_MultiMediaData
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0801_MultiMediaData
import io.netty.buffer.ByteBuf

/**
 * 多媒体数据上报(0x0801)消息体解码器
 */
object MBDecoder808_0801_MultiMediaData extends JT808MsgBodyDecoder[JT808Msg_0801_MultiMediaData] {

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
                              m: JT808Msg_0801_MultiMediaData,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    val data = new MQEventAddt_0801_MultiMediaData
    data.setMediaId(body.readUnsignedInt())
    data.setTyp(body.readByte())
    data.setFmt(body.readByte())
    data.setEvtCode(body.readByte())
    data.setChan(body.readByte())

    val slice = body.slice(body.readerIndex(), 28)
    val t = MBDecoder808_Track.decodeTrack(
      protoVer,
      adasDialect,
      m,
      slice,
      tempBuf,
      System.currentTimeMillis(),
      retransmit = false
    )
    data.setTrk(t)
    body.skipBytes(28)

    val size = body.readableBytes()
    val bytes = new Array[Byte](size)
    body.readBytes(bytes)

    data.setData(bytes)

    m.setData(data)
  }
}
