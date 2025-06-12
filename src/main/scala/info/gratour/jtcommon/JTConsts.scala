package info.gratour.jtcommon

import java.nio.charset.Charset
import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZoneOffset}
import com.google.gson.{Gson, GsonBuilder}
import com.lucendar.gnss.sdk.GnssConsts
import info.gratour.jt808common.JT808Consts
import info.gratour.jt808common.mat.{TermCmdMaterializer, TermCmdStateChangedMaterializer}
import info.gratour.jt808common.spi.model.{TermCmd, TermCmdStateChanged}

/**
 * JT/T 常量
 */
object JTConsts {

  /**
   * 2013 协议版本
   * @deprecated use [[JT808Consts.ProtocolVersions.PROTO_VER__REV2013]] instead
   */
  @Deprecated
  final val PROTO_VER__REV2013: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2013

  /**
   * 2019 协议版本
   * @deprecated use [[JT808Consts.ProtocolVersions.PROTO_VER__REV2019]] instead
   */
  @Deprecated
  final val PROTO_VER__REV2019: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2019

  /**
   * GBK 字符集
   */
  final val CHARSET_GBK: Charset = Charset.forName("GBK")

  /**
   * 默认字符集
   */
  final val DEFAULT_CHARSET: Charset = CHARSET_GBK

  /**
   * 零时区
   */
  final val ZONE_ID_Z: ZoneId = ZoneId.of("Z")

  /**
   * 北京时间时区偏移
   */
  final val ZONE_OFFSET_BEIJING: ZoneOffset = ZoneOffset.ofHours(8)

  /**
   * 32 字节的零数组
   */
  final val ZERO_BYTE_ARRAY_32: Array[Byte] = Array.fill(32)(0)

  /**
   * BCD 日期时间格式化器
   */
  final val BCD_DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss")

  /**
   * 通行的日期时间格式化器
   */
  final val CONVENIENT_DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  /**
   * 简单的 Gson 实例
   */
  final val SIMPLE_GSON: Gson = new Gson();

  /**
   * Gson 构建器   
   * @return Gson 构建器
   * @deprecated use [[GnssConsts.GSON_BUILDER()]] instead
   */
  @inline def GSON_BUILDER: GsonBuilder = GnssConsts.GSON_BUILDER

  /**
   * Gson 实例（紧凑格式输出）
   */
  final val GSON: Gson = GSON_BUILDER.create()

  /**
   * 换行缩进格式化输出的 Gson 实例
   */
  final val GSON_PRETTY: Gson = GSON_BUILDER.setPrettyPrinting().create()
}
