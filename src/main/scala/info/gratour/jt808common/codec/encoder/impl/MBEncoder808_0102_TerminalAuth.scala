/** *****************************************************************************
 * Copyright (c) 2019, 2022 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0102_TerminalAuth
import io.netty.buffer.ByteBuf

/**
 * 终端鉴权(0x0102)消息体编码器
 */
object MBEncoder808_0102_TerminalAuth extends AbstractJT808MsgBodyEncoder[JT808Msg_0102_TerminalAuth] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 终端鉴权消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0102_TerminalAuth, out: ByteBuf): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    if (protoVer == 0) {
      out.writeStr(m.getAuthCode)
    } else {
      out.writeByteLenPrefixedStr(m.getAuthCode)
      out.writeFixedLenStr(m.getImei, 15)
      out.writeFixedLenStr(m.getSoftwareVer, 20)
    }
  }
}
