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
import info.gratour.jt808common.protocol.msg.JT808Msg_8100_TerminalRegisterAck
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * 终端注册应答(0x8100)消息体编码器 
 */
object MBEncoder808_8100_TerminalRegisterAck extends AbstractJT808MsgBodyEncoder[JT808Msg_8100_TerminalRegisterAck] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 终端注册应答消息
   * @param out 输出字节缓冲区
   */
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8100_TerminalRegisterAck, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    out.writeByte(m.getResult)
    out.writeStr(m.getAuthCode)
  }
}
