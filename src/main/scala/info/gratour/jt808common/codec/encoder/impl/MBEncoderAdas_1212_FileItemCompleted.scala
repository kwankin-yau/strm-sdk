/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JTAdasMsg_1212_FileItemCompleted
import io.netty.buffer.ByteBuf

/**
 * 文件项完成(0x1212)消息体编码器
 */
object MBEncoderAdas_1212_FileItemCompleted extends AbstractJT808MsgBodyEncoder[JTAdasMsg_1212_FileItemCompleted]{

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 文件项完成消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JTAdasMsg_1212_FileItemCompleted, out: ByteBuf): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    out.writeByteLenPrefixedStr(m.getItem.getFileName)
    out.writeByte(m.getItem.getFileType)
    out.writeInt(m.getItem.getFileSize)
  }
}
