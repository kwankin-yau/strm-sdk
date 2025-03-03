/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8107_QryAttrs
import io.netty.buffer.ByteBuf

/**
 * 查询属性(0x8107)消息体解码器
 */
object MBDecoder808_8107_QryAttrs extends JT808MsgBodyDecoder[JT808Msg_8107_QryAttrs] {
  
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
                              m: JT808Msg_8107_QryAttrs,
                              body: ByteBuf,
                              tempBuf: Array[Byte]
                            ): Unit = {
    // nop
  }
}
