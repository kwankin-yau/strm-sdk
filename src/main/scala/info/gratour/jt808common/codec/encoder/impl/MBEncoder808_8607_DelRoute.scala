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
import info.gratour.jt808common.protocol.msg.JT808Msg_8607_DelRoute
import io.netty.buffer.ByteBuf

/**
 * 删除路线(0x8607)消息体编码器
 */
object MBEncoder808_8607_DelRoute extends AbstractJT808MsgBodyEncoder[JT808Msg_8607_DelRoute] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 删除路线消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8607_DelRoute, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")
    val routeIds = checkNotEmpty(p.getRouteIds, "routeIds")

    routeIds.foreach(id => out.writeInt(id))
  }
}
