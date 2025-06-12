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
import info.gratour.jt808common.protocol.msg.JT808Msg_8003_Retransmit
import io.netty.buffer.ByteBuf

/**
 * 重发消息体编码器(0x8003)
 */
object MBEncoder808_8003_Retransmit extends AbstractJT808MsgBodyEncoder[JT808Msg_8003_Retransmit] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 重发消息
   * @param out 输出字节缓冲区
   */
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8003_Retransmit, out: ByteBuf): Unit = {
    out.writeShort(m.getOrigSeqNo)
    out.writeByte(m.getRetransmitPacketIds.length)
    for (id <- m.getRetransmitPacketIds) {
      out.writeShort(id)
    }
  }
}
