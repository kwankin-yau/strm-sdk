/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8802_StoredMediaSearch
import io.netty.buffer.ByteBuf

/**
 * 多媒体数据检索(0x8802)消息体编码器
 */
object MBEncoder808_8802_StoredMediaSearch extends AbstractJT808MsgBodyEncoder[JT808Msg_8802_StoredMediaSearch] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 多媒体数据检索消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8802_StoredMediaSearch, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeByte(p.getMediaType)
    out.writeByte(p.getChannelId)
    out.writeByte(p.getEvent)
    out.writeBytes(JT808Utils.timestampToBcd6(p.getStartTime))
    out.writeBytes(JT808Utils.timestampToBcd6(p.getEndTime))
  }
}
