package info.gratour.jt808common.adas

import info.gratour.jt808common.protocol.msg.types.trk.{AdasDriverBehavAlmAddt, AdasDrivingAssistAlmAddt}
import info.gratour.jt808common.{AdasDialect, JT808Consts}
import info.gratour.jtcommon.JTUtils
import io.netty.buffer.ByteBuf

/**
 * ADAS 报警处理器
 */
trait AdasHandler {

  /**
   * 报警处理器适用的 ADAS 方言
   */
  def dialect: AdasDialect

  /**
   * 将 地方的ADAS 辅助驾驶报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 辅助驾驶报警类型
   * @return 平台统一ADAS报警类型
   */
  def mapDrivingAssistAlmTyp(typ: Short): Short

  /**
   * 将 地方的ADAS 驾驶员行为报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 驾驶员行为报警类型
   * @return 平台统一ADAS报警类型
   */
  def mapDriverBehavAlmTyp(typ: Short): Short

  /**
   * 获取ADAS报警ID（报警标识号）长度
   * @param protoVer 协议版本
   * @return ADAS报警ID（报警标识号）长度
   */
  def adasAlmIdLen(protoVer: Byte): Int

  /**
   * 读取ADAS报警ID（报警标识号）到给定的字节缓冲区
   * @param protoVer 协议版本
   * @param buf 字节缓冲区
   * @param tempBuf 临时字节缓冲区
   * @return 报警ID（报警标识号）
   */
  def readAdasAlmIdAsHex(
                          protoVer: Byte,
                          buf     : ByteBuf,
                          tempBuf : Array[Byte]
                        ): String = {
    val sz = adasAlmIdLen(protoVer)
    buf.readBytes(tempBuf, 0, sz)
    JTUtils.hex(tempBuf, 0, sz)
  }
}

/**
 * 川标ADAS 报警处理器
 */
object AdasHandler_SiChuan extends AdasHandler {

  /**
   * 获取ADAS 方言
   * @return ADAS 方言
   */
  override def dialect: AdasDialect = AdasDialect.SI_CHUAN

  /**
   * 将 地方的ADAS 辅助驾驶报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 辅助驾驶报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDrivingAssistAlmTyp(typ: Short): Short = {
    if (typ >= 0x09 && typ <= 0x0F || typ >= 0x12)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ
  }

  /**
   * 获取ADAS报警ID（报警标识号）长度
   * @param protoVer 协议版本
   * @return ADAS报警ID（报警标识号）长度
   */
  override def adasAlmIdLen(protoVer: Byte): Int =
    if (protoVer >= JT808Consts.ProtocolVersions.PROTO_VER__REV2019)
      39
    else
      16

  /**
   * 将 地方的ADAS 驾驶员行为报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 驾驶员行为报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDriverBehavAlmTyp(typ: Short): Short = {
    if (typ >= 0x09 && typ <= 0x0D || typ >= 0x13)
      AdasDriverBehavAlmAddt.TYP__CUSTOM
    else
      typ
  }
}

/**
 * 粤标ADAS 报警处理器
 */
object AdasHandler_GuangDong_2020 extends AdasHandler {

  /**
   * 获取ADAS 方言
   * @return ADAS 方言
   */
  override def dialect: AdasDialect = AdasDialect.GUANG_DONG

  /**
   * 将 地方的ADAS 辅助驾驶报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   */
  override def mapDrivingAssistAlmTyp(typ: Short): Short = {
    if (typ >= 0x08 && typ <= 0x0F || typ >= 0x14)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ
  }

  /**
   * 获取ADAS报警ID（报警标识号）长度
   * @param protoVer 协议版本
   * @return ADAS报警ID（报警标识号）长度
   */
  override def adasAlmIdLen(protoVer: Byte): Int = 40

  /**
   * 将 地方的ADAS 驾驶员行为报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 驾驶员行为报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDriverBehavAlmTyp(typ: Short): Short =
    if (typ == 0x07 || typ == 0x09 || (typ >= 0x0E && typ <= 0x0F) || typ >= 0x12)
      AdasDriverBehavAlmAddt.TYP__CUSTOM
    else
      typ match {
        case 0x06 => AdasDriverBehavAlmAddt.TYP__CAMERA_COVERED
        case 0x08 => AdasDriverBehavAlmAddt.TYP__DRIVE_OVERTIME
        case 0x0A => AdasDriverBehavAlmAddt.TYP__NOT_BELTING
        case 0x0B => AdasDriverBehavAlmAddt.TYP__ANTI_FACE_RECOG_DETECT_FUNC_FAILURE
        case 0x0C => AdasDriverBehavAlmAddt.TYP__STEERING_WHEEL_NOT_HOLDING
        case 0x0D => AdasDriverBehavAlmAddt.TYP__PLAY_SMART_PHONE
        case 0x11 => AdasDriverBehavAlmAddt.TYP__AUTO_CAPTURE
        case 0x12 => AdasDriverBehavAlmAddt.TYP__DRIVER_CHANGED_EVENT

        case _ =>
          typ
      }

}


/**
 * 苏标ADAS 报警处理器
 */
object AdasHandler_JiangSu extends AdasHandler {

  /**
   * 获取ADAS 方言
   * @return ADAS 方言
   */
  override def dialect: AdasDialect = AdasDialect.JIANG_SU

  /**
   * 将 地方的ADAS 辅助驾驶报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 辅助驾驶报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDrivingAssistAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDrivingAssistAlmTyp(typ)

  /**
   * 获取ADAS报警ID（报警标识号）长度
   * @param protoVer 协议版本
   * @return ADAS报警ID（报警标识号）长度
   */
  override def adasAlmIdLen(protoVer: Byte): Int = 16

  /**
   * 将 地方的ADAS 驾驶员行为报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 驾驶员行为报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDriverBehavAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDriverBehavAlmTyp(typ)
}

/**
 * 湘标ADAS 报警处理器
 */
object AdasHandler_HuNan extends AdasHandler {

  /**
   * 获取ADAS 方言
   * @return ADAS 方言
   */
  override def dialect: AdasDialect = AdasDialect.HU_NAN

  /**
   * 将 地方的ADAS 辅助驾驶报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 辅助驾驶报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDrivingAssistAlmTyp(typ: Short): Short =
    if (typ >= 0x05 && typ <= 0x0F || typ >= 0x13)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ match {
        case 0x12 => AdasDrivingAssistAlmAddt.TYP__DEVICE_FAILURE_hu_nan
        case _ => typ
      }

  /**
   * 将 地方的ADAS 驾驶员行为报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 驾驶员行为报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDriverBehavAlmTyp(typ: Short): Short =
    if (typ >= 0x0B && typ <= 0x0F || typ >= 0x15 && typ <= 0x1F)
      AdasDrivingAssistAlmAddt.TYP__CUSTOM
    else
      typ match {
        case 0x09 => AdasDriverBehavAlmAddt.TYP__PLAY_SMART_PHONE
        case 0x12 => AdasDriverBehavAlmAddt.TYP__ANTI_FACE_RECOG_DETECT_FUNC_FAILURE
        case 0x13 => AdasDriverBehavAlmAddt.TYP__CAMERA_COVERED
        case 0x14 => AdasDriverBehavAlmAddt.TYP__IGNITED_CAPTURE
        case _ => typ
      }

  /**
   * 获取ADAS报警ID（报警标识号）长度
   * @param protoVer 协议版本
   * @return ADAS报警ID（报警标识号）长度
   */
  override def adasAlmIdLen(protoVer: Byte): Int = 16
}

/**
 * 渝标ADAS 报警处理器
 */
object AdasHandler_ChongQing extends AdasHandler {

  /**
   * 获取ADAS 方言
   * @return ADAS 方言
   */
  override def dialect: AdasDialect = AdasDialect.CHONG_QING

  /**
   * 将 地方的ADAS 辅助驾驶报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 辅助驾驶报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDrivingAssistAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDrivingAssistAlmTyp(typ)

  /**
   * 将 地方的ADAS 驾驶员行为报警类型映射为平台统一ADAS报警类型（见 info.gratour.jt808common.adas.AdasAlmTypes中的各报警类型常量）
   * @param typ 地方的ADAS 驾驶员行为报警类型
   * @return 平台统一ADAS报警类型
   */
  override def mapDriverBehavAlmTyp(typ: Short): Short = AdasHandler_SiChuan.mapDriverBehavAlmTyp(typ)

  /**
   * 获取ADAS报警ID（报警标识号）长度
   * @param protoVer 协议版本
   * @return ADAS报警ID（报警标识号）长度
   */
  override def adasAlmIdLen(protoVer: Byte): Int = 16
}

/**
 * ADAS 报警处理器工厂
 */
object AdasHandlers {

  /**
   * 获取指定方言的ADAS 报警处理器
   * @param adasDialect ADAS 方言
   * @return ADAS 报警处理器
   */
  def get(adasDialect: AdasDialect): AdasHandler = {
    if (adasDialect == null)
      throw new IllegalArgumentException("adasDialect")

    adasDialect match {
      case AdasDialect.SI_CHUAN => AdasHandler_SiChuan
      case AdasDialect.GUANG_DONG => AdasHandler_GuangDong_2020
      case AdasDialect.HU_NAN => AdasHandler_HuNan
      case AdasDialect.JIANG_SU => AdasHandler_JiangSu
      case AdasDialect.CHONG_QING => AdasHandler_ChongQing

      case _ =>
        throw new RuntimeException(s"Unhandled ADAS dialect: $adasDialect")
    }
  }
}
