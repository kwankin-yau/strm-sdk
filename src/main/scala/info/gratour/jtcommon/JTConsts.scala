package info.gratour.jtcommon

import java.nio.charset.Charset
import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZoneOffset}
import com.google.gson.{Gson, GsonBuilder}
import com.lucendar.gnss.sdk.GnssConsts
import info.gratour.jt808common.JT808Consts
import info.gratour.jt808common.mat.{TermCmdMaterializer, TermCmdStateChangedMaterializer}
import info.gratour.jt808common.spi.model.{TermCmd, TermCmdStateChanged}

object JTConsts {

  /**
   * @deprecated use [[JT808Consts.ProtocolVersions.PROTO_VER__REV2013]] instead
   */
  @Deprecated
  final val PROTO_VER__REV2013: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2013

  /**
   * @deprecated use [[JT808Consts.ProtocolVersions.PROTO_VER__REV2019]] instead
   */
  @Deprecated
  final val PROTO_VER__REV2019: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2019


  final val CHARSET_GBK: Charset = Charset.forName("GBK")
  final val DEFAULT_CHARSET: Charset = CHARSET_GBK

  final val ZONE_ID_Z: ZoneId = ZoneId.of("Z")

  final val ZONE_OFFSET_BEIJING: ZoneOffset = ZoneOffset.ofHours(8)

  final val ZERO_BYTE_ARRAY_32: Array[Byte] = Array.fill(32)(0)

  final val BCD_DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss")
  final val CONVENIENT_DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  final val SIMPLE_GSON: Gson = new Gson();

  /**
   * @deprecated use [[GnssConsts.GSON_BUILDER()]] instead
   * @return
   */
  @inline def GSON_BUILDER: GsonBuilder = GnssConsts.GSON_BUILDER

  final val GSON: Gson = GSON_BUILDER.create()
  final val GSON_PRETTY: Gson = GSON_BUILDER.setPrettyPrinting().create()
}
