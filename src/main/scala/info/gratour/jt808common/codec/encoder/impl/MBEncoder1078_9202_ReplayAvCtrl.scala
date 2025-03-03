/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9202_ReplayAvCtrl
import info.gratour.jtcommon.JTConsts
import io.netty.buffer.ByteBuf

/**
 * 音视频回放控制(0x9202)消息体编码器
 */
object MBEncoder1078_9202_ReplayAvCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9202_ReplayAvCtrl] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 音视频回放控制消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9202_ReplayAvCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getChan)
    val ctrl = p.getCtrl
    val factor = p.getFactor
    val time = p.getTm
    ctrl match {
      case 3 | 4 =>
        if (factor == null)
          throw new CodecError("factory == null")

      case 5 =>
        if (time == null)
          throw new CodecError("time == null")

      case _ =>
    }
    out.writeByte(ctrl)

    out.writeByte(if (factor != null) factor.byteValue() else 0)
    if (time != null)
      out.writeBytes(JT808Utils.timestampToBcd6(time))
    else
      out.writeBytes(JTConsts.ZERO_BYTE_ARRAY_32, 0, 6)
  }
}
