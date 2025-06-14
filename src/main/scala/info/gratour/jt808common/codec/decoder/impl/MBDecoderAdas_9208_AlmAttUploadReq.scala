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
import info.gratour.jt808common.protocol.msg.JTAdasMsg_9208_AlmAttUploadReq
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9208_AlmAddtUploadReq
import io.netty.buffer.ByteBuf

/**
 * 报警附件上传请求(0x9208)消息体解码器
 */
object MBDecoderAdas_9208_AlmAttUploadReq extends JT808MsgBodyDecoder[JTAdasMsg_9208_AlmAttUploadReq] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JTAdasMsg_9208_AlmAttUploadReq, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9208_AlmAddtUploadReq
    cp.setServerIp(body.readByteLenPrefixedStr())
    cp.setTcpPort(body.readUnsignedShort())
    cp.setUdpPort(body.readUnsignedShort())


    val almNoLen =
      if (protoVer > 0) {
        if (adasDialect == AdasDialect.SI_CHUAN)
          39
        else
          40
      }else 16
    cp.setAlmNo(body.readBytesHex(almNoLen))
    cp.setAlmId(body.readCStr(32))

    body.skipBytes(16)

    m.setParams(cp)
  }

}
