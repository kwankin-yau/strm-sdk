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
import info.gratour.jt808common.protocol.msg.JT808Msg_8106_QrySpecialParams
import io.netty.buffer.ByteBuf

/**
 * 查询特殊参数(0x8106)消息体编码器
 */
object MBEncoder808_8106_QrySpecialParams extends AbstractJT808MsgBodyEncoder[JT808Msg_8106_QrySpecialParams] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 查询特殊参数消息
   * @param out 输出字节缓冲区
   */
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8106_QrySpecialParams, out: ByteBuf): Unit = {
    val params = m.getParams
    if (params == null || params.getParamIds == null || params.getParamIds.isEmpty)
      throw new CodecError("params or params.paramIds is null/empty")

    out.writeByte(params.getParamIds.length)
    params.getParamIds.foreach(idHex => {
      val id = Integer.parseInt(idHex, 16)
      out.writeInt(id)
    })
  }
}
