package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9003_QryAvAttrs
import io.netty.buffer.ByteBuf

/**
 * JT/T 1078 查询音频视频属性(0x9003)消息体解码器
 */
object MBDecoder1078_9003_QryAvAttrs extends JT808MsgBodyDecoder[JT1078Msg_9003_QryAvAttrs]{

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
                              m: JT1078Msg_9003_QryAvAttrs,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    // nop
  }
}
