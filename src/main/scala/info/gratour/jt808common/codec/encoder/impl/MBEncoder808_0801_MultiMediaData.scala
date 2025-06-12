/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0801_MultiMediaData
import io.netty.buffer.ByteBuf

/**
 * 多媒体数据(0x0801)消息体编码器
 */
object MBEncoder808_0801_MultiMediaData extends AbstractJT808MsgBodyEncoder[JT808Msg_0801_MultiMediaData] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 多媒体数据消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(
                                     protoVer: Byte,
                                     adasDialect: AdasDialect,
                                     m: JT808Msg_0801_MultiMediaData,
                                     out: ByteBuf
                                   ): Unit = {
    val data = m.getData
    out.writeInt(data.getMediaId.toInt)
    out.writeByte(data.getTyp)
    out.writeByte(data.getFmt)
    out.writeByte(data.getEvtCode)
    out.writeByte(data.getChan)
    MBEncoder808_Track.encodeTrackBasicInfo(protoVer, data.getTrk, out)
    out.writeBytes(data.getData)
  }
}
