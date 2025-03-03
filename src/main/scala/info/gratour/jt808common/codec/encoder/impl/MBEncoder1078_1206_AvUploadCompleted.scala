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
import info.gratour.jt808common.protocol.msg.JT1078Msg_1206_AvUploadCompleted
import io.netty.buffer.ByteBuf

/**
 * 音视频上传完成(0x1206)消息体编码器
 */
object MBEncoder1078_1206_AvUploadCompleted extends AbstractJT808MsgBodyEncoder[JT1078Msg_1206_AvUploadCompleted] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 音视频上传完成消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_1206_AvUploadCompleted, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    out.writeByte(m.getResult)
  }

}
