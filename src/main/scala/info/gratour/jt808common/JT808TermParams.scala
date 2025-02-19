/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common

import java.util.{Locale, ResourceBundle}

import info.gratour.jtcommon.{JTMessages, JTUtils}

/**
 * 终端参数类型
 */
sealed trait JT808TermParamType

/**
 * 字符串类型
 */
case object PARAM_STRING extends JT808TermParamType

/**
 * 双字类型
 */
case object PARAM_DWORD extends JT808TermParamType

/**
 * 字类型
 */
case object PARAM_WORD extends JT808TermParamType

/**
 * 字节类型
 */
case object PARAM_BYTE extends JT808TermParamType

/**
 * 二进制类型
 */
case object PARAM_BINARY extends JT808TermParamType

/**
 * 终端参数定义
 */
case class JT808TermParamDef(id: String, typ: JT808TermParamType, name: String)

/**
 * 终端参数操作
 */
object JT808TermParams {

  /**
   * 终端参数ID：服务器主机地址
   * @deprecated 使用 PARAM_PRIMARY_SERVER_HOST__REV2013 代替
   */
  val pHOST = "0013"

  /**
   * 终端参数ID：端口号
   * @deprecated 使用 PARAM_SERVER_PORT__REV2013 代替
   */
  val pPORT = "0018"

  /**
   * 取资源包
   * @param locale 区域
   * @return 资源包
   */
  def resourceBundle(locale: Locale): ResourceBundle =
    ResourceBundle.getBundle(
      "info.gratour.jt808common.protocol.term-param-names",
      if (locale != null) locale else Locale.getDefault
    )

  /**
   * 取字符串
   * @param locale 区域
   * @param key 字符串键
   * @return 字符串
   */
  def getOpt(locale: Locale, key: String): Option[String] = {
    val bundle = resourceBundle(locale)
    if (bundle.containsKey(key))
      Some(bundle.getString(key))
    else
      None
  }

  /**
   * 取终端参数名称
   * @param locale 区域
   * @param paramId 终端参数ID
   * @return 终端参数名称
   */
  def termParamNameOf(locale: Locale, paramId: String): String = {
    val key = "p" + paramId
    val bundle = resourceBundle(locale)

    if (bundle.containsKey(key))
      bundle.getString(key)
    else {
      val intId = Integer.parseInt(paramId, 16)
      if (intId >= 0x111 && intId <= 0x1FF) {
        val v = bundle.getString("p0110")
        return v + "(" + paramId + ")"
      }

      JTMessages.unknown(locale) + "(" + paramId + ")"
    }
  }

  /**
   * 转换为终端参数定义
   * @param tup 元组
   * @return 终端参数定义
   */
  private def toTermParamDef(tup: Tuple2[String, JT808TermParamType]): (String, JT808TermParamDef) = {
    val id = tup._1
    val typ = tup._2
    val name = termParamNameOf(null, id)
    id -> JT808TermParamDef(id, typ, name)
  }

  /**
   * 2011版本终端参数定义
   */
  val Rev2011: Map[String, JT808TermParamDef] =((0x110 to 0x1FF).map(id => {
    JTUtils.intToHex(id, 4).toUpperCase -> PARAM_BINARY
  }) ++ Seq(
    "0001" -> PARAM_DWORD,
    "0002" -> PARAM_DWORD,
    "0003" -> PARAM_DWORD,
    "0004" -> PARAM_DWORD,
    "0005" -> PARAM_DWORD,
    "0006" -> PARAM_DWORD,
    "0007" -> PARAM_DWORD,
    "0010" -> PARAM_STRING,
    "0011" -> PARAM_STRING,
    "0012" -> PARAM_STRING,
    "0013" -> PARAM_STRING,
    "0014" -> PARAM_STRING,
    "0015" -> PARAM_STRING,
    "0016" -> PARAM_STRING,
    "0017" -> PARAM_STRING,
    "0018" -> PARAM_DWORD,
    "0019" -> PARAM_DWORD,
    "001A" -> PARAM_STRING,
    "001B" -> PARAM_DWORD,
    "001C" -> PARAM_DWORD,
    "001D" -> PARAM_STRING,
    "0020" -> PARAM_DWORD,
    "0021" -> PARAM_DWORD,
    "0022" -> PARAM_DWORD,
    "0027" -> PARAM_DWORD,
    "0028" -> PARAM_DWORD,
    "0029" -> PARAM_DWORD,
    "002C" -> PARAM_DWORD,
    "002D" -> PARAM_DWORD,
    "002E" -> PARAM_DWORD,
    "002F" -> PARAM_DWORD,
    "0030" -> PARAM_DWORD,
    "0031" -> PARAM_WORD,
    "0040" -> PARAM_STRING,
    "0041" -> PARAM_STRING,
    "0042" -> PARAM_STRING,
    "0043" -> PARAM_STRING,
    "0044" -> PARAM_STRING,
    "0045" -> PARAM_DWORD,
    "0046" -> PARAM_DWORD,
    "0047" -> PARAM_DWORD,
    "0048" -> PARAM_STRING,
    "0049" -> PARAM_STRING,
    "0050" -> PARAM_DWORD,
    "0051" -> PARAM_DWORD,
    "0052" -> PARAM_DWORD,
    "0053" -> PARAM_DWORD,
    "0054" -> PARAM_DWORD,
    "0055" -> PARAM_DWORD,
    "0056" -> PARAM_DWORD,
    "0057" -> PARAM_DWORD,
    "0058" -> PARAM_DWORD,
    "0059" -> PARAM_DWORD,
    "005A" -> PARAM_DWORD,
    "005B" -> PARAM_WORD,
    "005C" -> PARAM_WORD,
    "005D" -> PARAM_WORD,
    "005E" -> PARAM_WORD,
    "0064" -> PARAM_DWORD,
    "0065" -> PARAM_DWORD,
    "0070" -> PARAM_DWORD,
    "0071" -> PARAM_DWORD,
    "0072" -> PARAM_DWORD,
    "0073" -> PARAM_DWORD,
    "0074" -> PARAM_DWORD,
    "0080" -> PARAM_DWORD,
    "0081" -> PARAM_WORD,
    "0082" -> PARAM_WORD,
    "0083" -> PARAM_STRING,
    "0084" -> PARAM_BYTE,
    "0090" -> PARAM_BYTE,
    "0091" -> PARAM_BYTE,
    "0092" -> PARAM_BYTE,
    "0093" -> PARAM_DWORD,
    "0094" -> PARAM_BYTE,
    "0095" -> PARAM_DWORD,
    "0100" -> PARAM_DWORD,
    "0101" -> PARAM_WORD,
    "0102" -> PARAM_DWORD,
    "0103" -> PARAM_WORD
  )).map(toTermParamDef).toMap

  val JT1078: Map[String, JT808TermParamDef] = Seq(
    "0075" -> PARAM_BINARY,
    "0076" -> PARAM_BINARY,
    "0077" -> PARAM_BINARY,
    "0078" -> PARAM_BINARY,
    "0079" -> PARAM_BINARY,
    "007A" -> PARAM_BINARY,
    "007B" -> PARAM_BINARY,
    "007C" -> PARAM_BINARY,
  ).map(toTermParamDef).toMap

  /**
   * 包含2011版和JT1078的终端参数定义
   */
  val WithJT1078: Map[String, JT808TermParamDef] = Rev2011 ++ JT1078

  /**
   * 四川ADAS终端参数定义
   */
  val SICHUAN: Map[String, JT808TermParamDef] = Seq(
    "F364" -> PARAM_BINARY,
    "F365" -> PARAM_BINARY,
    "F366" -> PARAM_BINARY,
    "F367" -> PARAM_BINARY,
    "F370" -> PARAM_BINARY
  ).map(toTermParamDef).toMap ++ WithJT1078

  /**
   * 终端参数ID：心跳间隔
   */
  val PARAM_HEARTBEAT_INTERVAL = "0001"

  /**
   * 终端参数ID：主服务器主机地址（2013版）
   */
  val PARAM_PRIMARY_SERVER_HOST__REV2013 = "0013"

  /**
   * 终端参数ID：主服务器端口号（2013版）
   */
  val PARAM_SERVER_PORT__REV2013 = "0018"

  /**
   * 终端参数ID：主服务器主机地址和端口号（2019版）
   */
  val PARAM_SERVER_HOST_AND_PORT__REV2019 = "0013"

  /**
   * 终端参数ID：默认位置报告间隔
   */
  val PARAM_DEFAULT_LOCATION_REPORT_INTV = "0029"

  /**
   * 终端参数ID：报警抑制掩码
   */
  val PARAM_ALM_SUPPRESS_MASK = "0050"

  /**
   * 终端参数ID：最大速度
   */
  val PARAM_MAX_SPEED = "0055"

  /**
   * 终端参数ID：行驶里程
   */
  val PARAM_MILE = "0080"

  /**
   * 终端参数ID：省份ID
   */
  val PARAM_PROVINCE_ID = "0081"

  /**
   * 终端参数ID：城市ID
   */
  val PARAM_CITY_ID = "0082"

  /**
   * 终端参数ID：车牌号
   */
  val PARAM_PLATE_NO = "0083"

  /**
   * 终端参数ID：车牌颜色
   */
  val PARAM_PLATE_COLOR = "0084"

  /**
   * 终端参数ID：车辆识别码
   */
}
