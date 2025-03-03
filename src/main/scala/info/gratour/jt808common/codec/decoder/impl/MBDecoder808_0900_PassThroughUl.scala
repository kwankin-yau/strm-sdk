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
import info.gratour.jt808common.protocol.msg.JT808Msg_0900_PassThroughUL
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0900_PassThroughUl
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * 透传上行(0x0900)消息体解码器
 */
object MBDecoder808_0900_PassThroughUl extends JT808MsgBodyDecoder[JT808Msg_0900_PassThroughUL] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0900_PassThroughUL, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val data = new MQEventAddt_0900_PassThroughUl
    data.setTyp(body.readByte())
    data.setData(body.readRemainingAsBytes())
    m.setData(data)
  }

}
