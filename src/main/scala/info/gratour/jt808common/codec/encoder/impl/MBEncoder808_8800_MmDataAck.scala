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
import info.gratour.jt808common.protocol.msg.JT808Msg_8800_MMDataAck
import io.netty.buffer.ByteBuf

/**
 * 多媒体数据应答(0x8800)消息体编码器
 */
object MBEncoder808_8800_MmDataAck extends AbstractJT808MsgBodyEncoder[JT808Msg_8800_MMDataAck] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 多媒体数据应答消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8800_MMDataAck, out: ByteBuf): Unit = {
    out.writeInt(m.getMediaId)
    val ids = m.getRetransmitPacketIds
    if (ids != null) {
      out.writeByte(ids.length)
      ids.foreach(id => out.writeShort(id))
    } else
      out.writeByte(0)
  }
}
