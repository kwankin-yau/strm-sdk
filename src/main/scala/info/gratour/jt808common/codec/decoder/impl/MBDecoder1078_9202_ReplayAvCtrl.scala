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
import info.gratour.jt808common.protocol.msg.JT1078Msg_9202_ReplayAvCtrl
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9202_ReplayAvCtrl
import io.netty.buffer.ByteBuf

/**
 * JT/T 1078 回放音视频控制(0x9202)消息体解码器
 */
object MBDecoder1078_9202_ReplayAvCtrl extends JT808MsgBodyDecoder[JT1078Msg_9202_ReplayAvCtrl] {

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 解码后的消息体
   * @param body 消息体字节缓冲区
   * @param tempBuf 临时缓冲区
   */
  override def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: JT1078Msg_9202_ReplayAvCtrl, body: ByteBuf, tempBuf: Array[Byte]): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val cp = new CP_9202_ReplayAvCtrl
    cp.setChan(body.readByte())

    cp.setCtrl(body.readByte())

    cp.setFactor(body.readByte())

    if (cp.getCtrl == 5)
      cp.setTm(body.readBcd6Timestamp(tempBuf))
    else
      body.skipBytes(6)

    m.setParams(cp)
  }

}
