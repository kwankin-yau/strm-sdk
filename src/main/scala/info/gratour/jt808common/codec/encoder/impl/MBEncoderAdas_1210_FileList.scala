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
import info.gratour.jt808common.protocol.msg.JTAdasMsg_1210_FileList
import io.netty.buffer.ByteBuf

/**
 * 文件列表(0x1210)消息体编码器
 */
object MBEncoderAdas_1210_FileList extends AbstractJT808MsgBodyEncoder[JTAdasMsg_1210_FileList] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 文件列表消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JTAdasMsg_1210_FileList, out: ByteBuf): Unit = {
    import info.gratour.jtcommon.ByteBufHelper

    val (termIdLen, almNoLen) = if (protoVer > 0) (30, 40) else (7, 16)

    out.writeFixedLenStr(m.getTermId, termIdLen)
    out.writeFixedLenBytesHex(m.getAlmNo, almNoLen)
    out.writeFixedLenStr(m.getPlatformAlmId, 32)
    out.writeByte(m.getKind)

    val cnt = if (m.getFileList != null) m.getFileList.size() else 0
    out.writeByte(cnt)

    if (cnt > 0) {
      m.getFileList.forEach(item => {
        out.writeByteLenPrefixedStr(item.getFileName)
        out.writeInt(item.getFileSize)
      })
    }
  }
}
