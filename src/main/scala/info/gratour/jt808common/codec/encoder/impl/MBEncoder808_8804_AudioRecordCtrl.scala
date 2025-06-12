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
import info.gratour.jt808common.protocol.msg.JT808Msg_8804_AudioRecordCtrl
import io.netty.buffer.ByteBuf

/**
 * 音频记录控制(0x8804)消息体编码器
 */
object MBEncoder808_8804_AudioRecordCtrl extends AbstractJT808MsgBodyEncoder[JT808Msg_8804_AudioRecordCtrl] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 音频记录控制消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8804_AudioRecordCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getAction)
    out.writeShort(p.getRecordTime)
    out.writeByte(p.getSaveFlag)
    out.writeByte(p.getSampleFrequency)
  }
}
