/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect

import java.time.OffsetDateTime
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8004_QryServerTimeAck
import info.gratour.jtcommon.{JTConsts, JTUtils}
import io.netty.buffer.ByteBuf

/**
 * 查询服务器时间应答(0x8004)消息体编码器
 */
object MBEncoder808_8004_QryServerTimeAck extends AbstractJT808MsgBodyEncoder[JT808Msg_8004_QryServerTimeAck]{

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 查询服务器时间应答消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8004_QryServerTimeAck, out: ByteBuf): Unit = {
    val ldt = OffsetDateTime.now(JTConsts.ZONE_ID_Z).toLocalDateTime
    val bytes = JTUtils.encodeBcdDateTime(ldt)
    out.writeBytes(bytes)
  }

}
