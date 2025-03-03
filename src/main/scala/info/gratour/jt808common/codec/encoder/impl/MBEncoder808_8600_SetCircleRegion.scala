/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.encoder.impl

import info.gratour.jt808common.{AdasDialect, JT808Utils}
import info.gratour.jt808common.codec.encoder.AbstractJT808MsgBodyEncoder
import info.gratour.jt808common.protocol.msg.JT808Msg_8600_SetCircleRegion
import info.gratour.jtcommon.{ByteBufHelper, JTUtils}
import io.netty.buffer.ByteBuf

/**
 * 设置圆形区域(0x8600)消息体编码器
 */
object MBEncoder808_8600_SetCircleRegion extends AbstractJT808MsgBodyEncoder[JT808Msg_8600_SetCircleRegion] {

  /**
   * 编码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 设置圆形区域消息
   * @param out 输出字节缓冲区
   */
  override protected def encodeBody(protoVer: Byte, adasDialect: AdasDialect, m: JT808Msg_8600_SetCircleRegion, out: ByteBuf): Unit = {
    val params = checkNotNull(m.getParams, "params")
    val regions = checkNotEmpty(params.getRegions, "regions")

    out.writeByte(params.getAction)
    out.writeByte(regions.length)
    regions.foreach(r => {
      out.writeInt(r.getRegionId)
      out.writeShort(r.getAttrs)
      val center = checkNotNull(r.getCenter, "center")
      out.writeAxis(center.getLng)
      out.writeAxis(center.getLat)
      out.writeInt(r.getRadius)
      if (JTUtils.test(r.getAttrs, 0)) {
        if (r.getStartTm == null)
          throw new RuntimeException("Invalid parameter: `startTm`.")
        if (r.getEndTm == null)
          throw new RuntimeException("Invalid parameter: `endTm`.")

        var dt = JT808Utils.parseSixDigitsDateTime(r.getStartTm)
        out.writeBytes(dt.toBcd6)
        dt = JT808Utils.parseSixDigitsDateTime(r.getEndTm)
        out.writeBytes(dt.toBcd6)
      }

      if (JTUtils.test(r.getAttrs, 1)) {
        if (r.getSpdUpperLimit == null)
          throw new RuntimeException("Invalid parameter: `spdUpperLimit`.")
        if (r.getTimeThreshold == null)
          throw new RuntimeException("Invalid parameter: `timeThreshold`.")

        out.writeShort(r.getSpdUpperLimit.shortValue())
        out.writeByte(r.getTimeThreshold.byteValue())
      }
    })
  }
}
