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
import info.gratour.jt808common.protocol.msg.JT808Msg_0201_QryLocationAck
import io.netty.buffer.ByteBuf

/**
 * 查询位置应答(0x0201)消息体编码器 
 */
object MBEncoder808_0201_QryLocationAck extends AbstractJT808MsgBodyEncoder[JT808Msg_0201_QryLocationAck]{

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 查询位置应答消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0201_QryLocationAck, out: ByteBuf): Unit = {
    out.writeShort(m.getAckSeqNo)
    MBEncoder808_Track.encodeTrack(protoVer, adasDialect, m.getAckParams.getTrk, out)
  }
}
