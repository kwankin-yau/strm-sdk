/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_9101_LiveAvReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9101_LiveAvReq
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * JT/T 1078 实时音视频请求(0x9101)消息体解码器
 */
object MBDecoder1078_9101_LiveAvReq extends JT808MsgBodyDecoder[JT1078Msg_9101_LiveAvReq]{

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9101_LiveAvReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    val cp = new CP_9101_LiveAvReq
    cp.setServerIp(body.readByteLenPrefixedStr())
    val tcpPort = body.readUnsignedShort()
    val udpPort = body.readUnsignedShort()

    if (protoVer > 0) {
      cp.setTcpPort2019(tcpPort)
      cp.setUdpPort2019(udpPort)
    } else {
      cp.setTcpPort(tcpPort)
      cp.setUdpPort(udpPort)
    }

    cp.setChan(body.readByte())
    cp.setDataTyp(body.readByte())
    cp.setCodeStrm(body.readByte())

    m.setParams(cp)
  }

}
