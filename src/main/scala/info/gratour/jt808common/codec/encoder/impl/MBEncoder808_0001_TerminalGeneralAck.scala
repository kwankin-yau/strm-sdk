/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0001_TerminalGeneralAck
import io.netty.buffer.ByteBuf

/**
 * 终端通用应答(0x0001)消息体编码器
 */
object MBEncoder808_0001_TerminalGeneralAck extends AbstractJT808MsgBodyEncoder[JT808Msg_0001_TerminalGeneralAck]{

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 终端通用应答消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0001_TerminalGeneralAck, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    out.writeShort(m.getAckMsgId)
    out.writeByte(m.getResult)
  }
}
