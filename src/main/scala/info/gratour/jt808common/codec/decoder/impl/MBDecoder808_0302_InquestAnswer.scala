/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0302_InquestAnswer
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0302_InquestAnswer
import io.netty.buffer.ByteBuf

/**
 * 提问应答(0x0302)消息体解码器
 */
object MBDecoder808_0302_InquestAnswer extends JT808MsgBodyDecoder[JT808Msg_0302_InquestAnswer] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0302_InquestAnswer, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val ackParams = new JT808AckParams_0302_InquestAnswer
    ackParams.setCandidateId(body.readUnsignedByte())
    m.setAckParams(ackParams)
  }
}
