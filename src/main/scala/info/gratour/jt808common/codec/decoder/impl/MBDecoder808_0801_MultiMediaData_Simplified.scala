package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_0801_MultiMediaData_Simplified
import io.netty.buffer.ByteBuf

/**
 * 多媒体数据上报(0x0801)简化消息体解码器
 
object MBDecoder808_0801_MultiMediaData_Simplified extends JT808MsgBodyDecoder[JT808Msg_0801_MultiMediaData_Simplified] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(
                              protoVer: Byte,
                              adasDialect: AdasDialect,
                              m: JT808Msg_0801_MultiMediaData_Simplified,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    m.setMediaId(body.readUnsignedInt())
  }
}
