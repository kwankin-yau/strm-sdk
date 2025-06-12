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
import info.gratour.jt808common.protocol.msg.JT808Msg_0301_EventReport
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0301_EventReport
import io.netty.buffer.ByteBuf

/**
 * 事件报告(0x0301)消息体解码器
 */
object MBDecoder808_0301_EventReport extends JT808MsgBodyDecoder[JT808Msg_0301_EventReport] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0301_EventReport, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val info = new MQEventAddt_0301_EventReport
    info.setEventId(body.readUnsignedByte())

    m.setInfo(info)
  }
}
