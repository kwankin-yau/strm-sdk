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
import info.gratour.jt808common.protocol.msg.JT808Msg_8303_SetUpInfoMenu
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * 设置信息菜单(0x8303)消息体编码器
 */
object MBEncoder808_8303_SetUpInfoMenu extends AbstractJT808MsgBodyEncoder[JT808Msg_8303_SetUpInfoMenu] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 设置信息菜单消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8303_SetUpInfoMenu, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    val list = checkNotEmpty(params.getMenuItems, "menuItems")

    out.writeByte(params.getAction)
    out.writeByte(list.length)
    list.foreach(item => {
      out.writeByte(item.getInfoType)
      out.writeShortLenPrefixedStr(item.getInfoName)
    })
  }
}
