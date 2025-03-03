/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8401_SetUpPhoneBook
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * 设置电话簿(0x8401)消息体编码器
 */
object MBEncoder808_8401_SetUpPhoneBook extends AbstractJT808MsgBodyEncoder[JT808Msg_8401_SetUpPhoneBook] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 设置电话簿消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8401_SetUpPhoneBook, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    val list = checkNotEmpty(params.getEntries, "entries")

    out.writeByte(params.getAction)
    out.writeByte(list.length)
    list.foreach(entry => {
      out.writeByte(entry.getTyp)
      out.writeByteLenPrefixedStr(checkNotNull(entry.getPhoneNo, "phoneNo"))
      out.writeByteLenPrefixedStr(checkNotNull(entry.getContacts, "contacts"))
    })
  }
}
