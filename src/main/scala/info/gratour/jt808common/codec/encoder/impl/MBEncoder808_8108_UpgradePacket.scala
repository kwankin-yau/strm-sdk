/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.CodecError
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8108_UpgradePacket
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * 升级包(0x8108)消息体编码器
 */
object MBEncoder808_8108_UpgradePacket extends AbstractJT808MsgBodyEncoder[JT808Msg_8108_UpgradePacket] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 升级包消息
   * @param out 输出字节缓冲区
   */
  override def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8108_UpgradePacket, out: ByteBuf): Unit = {
    val data = m.getData
    if (data == null || data.isEmpty)
      throw new CodecError("data == null or empty")

    out.writeByte(m.getUpgradeType)
    out.writeFixedLenStr(m.getFactoryId, 5)
    out.writeByteLenPrefixedStr(m.getVersion)
    out.writeIntLenPrefixedBytes(data)
  }
}
