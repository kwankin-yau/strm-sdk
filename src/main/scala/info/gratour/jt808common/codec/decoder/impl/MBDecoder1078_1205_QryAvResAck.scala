/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.decoder.JT808MsgBodyDecoder
import info.gratour.jt808common.protocol.msg.JT1078Msg_1205_QryAvResAck
import info.gratour.jt808common.protocol.msg.types.JT1078AvRes
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1205_QryAvResAck
import io.netty.buffer.ByteBuf

/**
 * JT/T 1078 查询音频视频资源应答解码器
 */
object MBDecoder1078_1205_QryAvResAck extends JT808MsgBodyDecoder[JT1078Msg_1205_QryAvResAck] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_1205_QryAvResAck, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    m.setAckSeqNo(body.readUnsignedShort())
    val cnt = body.readInt()
    val ackParams = new JT1078AckParams_1205_QryAvResAck
    val recList = new Array[JT1078AvRes](cnt)
    ackParams.setResList(recList)
    m.setAckParams(ackParams)

    for (i <- 0 until cnt) {
      val res = new JT1078AvRes
      res.setChan(body.readByte())
      res.setStartTm(JT808Utils.readBcd6Timestamp(body, tempBuf))
      res.setEndTm(JT808Utils.readBcd6Timestamp(body, tempBuf))
      res.setAlmSt1078(body.readInt())
      res.setAlmSt808(body.readInt())
      res.setMediaTyp(body.readByte())
      res.setCodeStrm(body.readByte())
      res.setStgTyp(body.readByte())
      res.setFileSz(body.readUnsignedInt())

      recList(i) = res
    }
  }
}
