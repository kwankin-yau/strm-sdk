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
import info.gratour.jt808common.protocol.msg.JT808Msg_0800_MultiMediaEvent
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0800_MultiMediaEvent
import io.netty.buffer.ByteBuf

/**
 * 多媒体事件上报(0x0800)消息体解码器
 */
object MBDecoder808_0800_MultiMediaEvent extends JT808MsgBodyDecoder[JT808Msg_0800_MultiMediaEvent] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0800_MultiMediaEvent, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val event = new MQEventAddt_0800_MultiMediaEvent
    event.setMediaId(body.readUnsignedInt())
    event.setTyp(body.readByte())
    event.setFmt(body.readByte())
    event.setEvtCode(body.readByte())
    event.setChan(body.readByte())

    m.setEvent(event)
  }
}
