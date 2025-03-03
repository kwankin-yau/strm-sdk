/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JTAdasMsg_9212_AlmAttFileItemCompleted
import info.gratour.jtcommon.ByteBufHelper
import io.netty.buffer.ByteBuf

/**
 * ADAS报警附件文件项完成(0x9212)消息体编码器
 */
object MBEncoderAdas_9212_AlmAttFileItemCompleted extends AbstractJT808MsgBodyEncoder[JTAdasMsg_9212_AlmAttFileItemCompleted]{

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m ADAS报警附件文件项完成消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JTAdasMsg_9212_AlmAttFileItemCompleted, out: ByteBuf): Unit = {
    val params = m.getParams
    out.writeByteLenPrefixedStr(params.getFileItem.getFileName)

    out.writeByte(params.getFileItem.getFileType) // file type

    if (params.getReTransFileBlocks == null || params.getReTransFileBlocks.isEmpty) {
      out.writeShort(0)
    } else {
      out.writeByte(1)
      out.writeByte(params.getReTransFileBlocks.size())

      for (i <- 0 until params.getReTransFileBlocks.size()) {
        val b = params.getReTransFileBlocks.get(i)
        out.writeInt(b.getOffset)
        out.writeInt(b.getSize)
      }
    }

  }
}
