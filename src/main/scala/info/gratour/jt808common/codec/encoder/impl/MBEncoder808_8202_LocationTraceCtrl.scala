/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8202_LocationTraceCtrl
import io.netty.buffer.ByteBuf

/**
 * 位置跟踪控制(0x8202)消息体编码器
 */
object MBEncoder808_8202_LocationTraceCtrl extends AbstractJT808MsgBodyEncoder[JT808Msg_8202_LocationTraceCtrl] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 位置跟踪控制消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8202_LocationTraceCtrl, out: ByteBuf): Unit = {
    val params = m.getParams
    if (params == null)
      throw new CodecError("params == null")

    out.writeShort(params.getInterval)
    out.writeInt(params.getDuration)
  }
}
