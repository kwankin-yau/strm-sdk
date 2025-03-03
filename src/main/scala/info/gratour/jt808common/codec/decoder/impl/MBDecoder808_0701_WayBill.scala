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
import info.gratour.jt808common.protocol.msg.JT808Msg_0701_WayBill
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0701_WayBill
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * 电子运单(0x0701)消息体解码器
 */
object MBDecoder808_0701_WayBill extends JT808MsgBodyDecoder[JT808Msg_0701_WayBill] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0701_WayBill, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val wb = new MQEventAddt_0701_WayBill
    wb.setContent(body.readIntLenPrefixedStr())
    m.setInfo(wb)
  }
}
