package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0001_TerminalGeneralAck
import io.netty.buffer.ByteBuf

/**
 * 终端通用应答(0x0001)消息体解码器
 */
object MBDecoder808_0001_TerminalGeneralAck extends JT808MsgBodyDecoder[JT808Msg_0001_TerminalGeneralAck] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区 
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_0001_TerminalGeneralAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    m.setAckMsgId(body.readUnsignedShort())
    m.setResult(body.readByte())
  }
}


