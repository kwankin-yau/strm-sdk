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
import info.gratour.jt808common.protocol.msg.JT808Msg_8001_PlatformGeneralAck
import io.netty.buffer.ByteBuf

/**
 * 平台通用应答(0x8001)消息体编码器
 */
object MBEncoder808_8001_PlatformGeneralAck extends AbstractJT808MsgBodyEncoder[JT808Msg_8001_PlatformGeneralAck] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 平台通用应答消息
   * @param out 输出字节缓冲区
   */
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8001_PlatformGeneralAck, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    out.writeShort(m.getAckMsgId)
    out.writeByte(m.getResult)
  }
}
