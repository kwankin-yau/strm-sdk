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
import info.gratour.jt808common.protocol.msg.JT808Msg_8805_SingleStoredMediaReq
import io.netty.buffer.ByteBuf

/**
 * 单个多媒体数据请求(0x8805)消息体编码器
 */
object MBEncoder808_8805_SingleStoredMediaReq extends AbstractJT808MsgBodyEncoder[JT808Msg_8805_SingleStoredMediaReq] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 单个多媒体数据请求消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8805_SingleStoredMediaReq, out: ByteBuf): Unit = {
    val p = checkNotNull(m.getParams, "params")

    out.writeInt(p.getMediaId)
    out.writeByte(p.getDeleteFlag)
  }
}
