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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9207_AvUploadCtrl
import io.netty.buffer.ByteBuf

/**
 * 音视频上传控制(0x9207)消息体编码器
 */
object MBEncoder1078_9207_AvUploadCtrl extends AbstractJT808MsgBodyEncoder[JT1078Msg_9207_AvUploadCtrl] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 音视频上传控制消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9207_AvUploadCtrl, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeShort(p.getOrigSeqNo)
    out.writeByte(p.getCtrl)
  }
}
