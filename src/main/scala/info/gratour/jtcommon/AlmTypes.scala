/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import java.util.{Locale, ResourceBundle}


/**
 * 报警/事件类型代码
 */
object AlmTypes {

  val TYP_0001_OVER_SPEED = "0001"
  val TYP_0002_FATIGUED = "0002"
  val TYP_0003_PANIC = "0003"
  val TYP_0004_ENTER_REGION = "0004"
  val TYP_0005_LEAVE_REGION = "0005"
  val TYP_0009_STEAL = "0009"
  val TYP_000B_STRAY_PATH = "000B"
  val TYP_000C_UNINTENDED_MOTION = "000C"
  val TYP_000D_DRIVE_OVERTIME = "000D"
  val TYP_0010_VIOLATED_2019 = "0010"
  val TYP_0013_ABNORMAL_TYRE_PRESS = "0013"
  val TYP_0101_VID_LOSS = "0101"
  val TYP_0102_VID_COVER = "0102"
  val TYP_0103_VID_STG_ALM = "0103"
  val TYP_0104_VID_OTHER_EQUIP_FAULT = "0104"
  val TYP_0105_PASSENGER_OVERLOAD = "0105"
  val TYP_0106_UNUSUAL_DRIVE_BEHAV = "0106"
  val TYP_0107_SPEICAL_REC_STG_RUN_OUT = "0107"

  /**
   * 前向碰撞报警
   */
  val TYP_0201_ADAS_FRONT_CRASH = "0201"

  /**
   * 车道偏离报警
   */
  val TYP_0202_ADAS_STRAY_PATH = "0202"

  /**
   * 车距过近报警
   */
  val TYP_0203_ADAS_VEH_TOO_CLOSE = "0203"

  /**
   * 行人碰撞报警
   */
  val TYP_0204_ADAS_PEDESTRIAN_HIT = "0204"

  /**
   * 频繁变道报警
   */
  val TYP_0205_ADAS_CHANGE_LANE_FREQUENTLY = "0205"

  /**
   * 道路标识超限报警
   */
  val TYP_0206_ADAS_ROAD_RECOG_OVERRUN = "0206"

  /**
   * 障碍物报警
   */
  val TYP_0207_ADAS_OBSTACLE = "0207"

  /**
   * 驾驶辅助功能失效报警
   */
  val TYP_0208_ADAS_DRIVING_ASSIST_FUNC_FAILURE = "0208"

  /**
   * 道路标志识别事件
   */
  val TYP_0209_ADAS_ROAD_SIGN_RECOG_EVENT = "0209"

  /**
   * 实线变道报警
   */
  val TYP_020A_ADAS_VIOLATED_CHANGE_PATH = "020A"

  /**
   * 车厢过道行人检测报警
   */
  val TYP_020B_ADAS_PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED = "020B"

  /**
   * 主动抓拍事件(驾驶辅助功能)
   */
  val TYP_020C_ADAS_DRIVING_ASSIST_ACTIVE_CAPTURE = "020C"



  /**
   * 疲劳驾驶报警
   */
  val TYP_0211_ADAS_FATIGUED = "0211"

  /**
   * 不目视前方报警
   */
  val TYP_0212_ADAS_NO_LOOK_AHEAD = "0212"

  /**
   * 抽烟报警
   */
  val TYP_0213_ADAS_SMOKE = "0213"

  /**
   * 接打手持电话报警
   */
  val TYP_0214_ADAS_PHONE_CALL = "0214"

  /**
   * 驾驶员异常报警
   */
  val TYP_0215_ADAS_DRIVER_NOT_DETECTED = "0215"

  /**
   * 双脱把报警
   */
  val TYP_0216_ADAS_STEERING_WHEEL_NOT_HOLDING = "0216"

  /**
   * 驾驶员行为监测功能失效报警
   */
  val TYP_0217_ADAS_DRIVER_BEHAV_ALM_FUNC_FAILURE = "0217"

  /**
   * 驾驶员身份异常
   */
  val TYP_0218_ADAS_INVALID_DRIVER_ID = "0218"

  /**
   * 驾驶员变更事件
   */
  val TYP_0219_ADAS_DRIVER_BEHAV_DRIVER_CHANGED_EVENT = "0219"

  /**
   * 夜间禁行报警
   */
  val TYP_021A_ADAS_NIGHT_DRIVE_PROHIBITED = "021A"

  /**
   * 超时驾驶报警
   */
  val TYP_021B_ADAS_DRIVE_OVERTIME = "021B"

  /**
   * 主动抓拍事件(驾驶员监测功能)
   */
  val TYP_021C_ADAS_DRIVER_BEHAV_AUTO_CAPTURE = "021C"

  /**
   * 未系安全带报警
   */
  val TYP_021D_ADAS_DRIVER_BEHAV_NOT_BELTING = "021D"

  /**
   * 红外墨镜失效报警
   */
  val TYP_021E_ADAS_ANTI_FACE_RECOG_DETECT_FUNC_FAILURE = "021E"

  /**
   * 点火抓拍事件
   */
  val TYP_021F_ADAS_DRIVER_BEHAV_IGNITED_CAPTURE = "021F"

  /**
   * 探头遮挡报警（粤标）
   */
  val TYP_021H_ADAS_DRIVER_BEHAV_CAMERA_COVERED = "021H" // do not use G, due to indistinguishable

  /**
   * 玩手机报警
   */
  val TYP_021J_ADAS_PLAY_SMART_PHONE = "021J" // do not use I, due to indistinguishable


  /**
   * 胎压过高报警
   */
  val TYP_0221_ADAS_TYRE_PRESS_TOO_HIGH = "0221"

  /**
   * 胎压过低报警
   */
  val TYP_0222_ADAS_TYRE_PRESS_TOO_LOW = "0222"

  /**
   * 轮胎温度过高报警
   */
  val TYP_0223_ADAS_TYRE_TEMP_TOO_HIGH = "0223"

  /**
   * 轮胎传感器异常报警
   */
  val TYP_0224_ADAS_TYRE_SENSOR_FAILURE = "0224"

  /**
   * 胎压不平衡报警
   */
  val TYP_0225_ADAS_TYRE_PRESS_DISBALANCE = "0225"

  /**
   * 轮胎慢漏气报警
   */
  val TYP_0226_ADAS_TYRE_AIR_LEAK_SLOWLY = "0226"

  /**
   * 电池电压低报警
   */
  val TYP_0227_ADAS_BATTERY_LOW = "0227"




  /**
   * 后方接近报警
   */
  val TYP_0231_ADAS_REAR_TOO_CLOSE = "0231"

  /**
   * 左侧后方接近报警
   */
  val TYP_0232_ADAS_LEFT_REAR_TOO_CLOSE = "0232"

  /**
   * 右侧后方接近报警
   */
  val TYP_0233_ADAS_RIGHT_REAR_TOO_CLOSE = "0233"


  /**
   * 急加速报警
   */
  val TYP_0241_ADAS_RAPID_ACCELERATE = "0241"

  /**
   * 急减速报警
   */
  val TYP_0242_ADAS_RAPID_DECELERATE = "0242"

  /**
   * 急转弯报警
   */
  val TYP_0243_ADAS_RAPID_TURN = "0243"

  /**
   * 怠速报警
   */
  val TYP_0244_ADAS_IDLING = "0244"

  /**
   * 异常熄火报警
   */
  val TYP_0245_ADAS_UNEXPECTED_FLAME_OUT = "0245"

  /**
   * 空挡滑行报警
   */
  val TYP_0246_ADAS_SLIDING_ON_N = "0246"

  /**
   * 发动机超转报警
   */
  val TYP_0247_ADAS_ENGINE_RPM_TOO_HIGH = "0247"


  /**
   * 超过阈值速度报警
   */
  val TYP_0251_ADAS_OVER_EQUIP_SPD_LIMIT = "0251"

  /**
   * 超过道路限速报警
   */
  val TYP_0252_ADAS_OVER_ROAD_SPD_LIMIT = "0252"




  /**
   * 超重报警
   */
  val TYP_0261_ADAS_OVERLOAD = "0261"



  /**
   * 限高报警
   */
  val TYP_0271_ADAS_OVER_HEIGHT = "0271"


  /***
   * 超员报警
   */
  val TYP_0281_ADAS_OVERCROWDED = "0281"

  /**
   * 未巡检乘客安全带事件
   */
  val TYP_0282_ADAS_BELTING_NOT_CHECKED = "0282"


//  val TYP_E002_ENTER_RGN_EVENT = "E002"

  //  val TYP_E101_VIOLATED_CHANGE_PATH = "E101"
  //  val TYP_E102_PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED = "E102"
  //  val TYP_E103_CAMERA_COVERED = "E103"
  //  val TYP_E104_ONE_TIME_DRIVE_OVERTIME = "E104"
  //  val TYP_E105_ANTI_FACE_RECOG_DETECT_FUNC_FAILURE = "E105"
  //  val TYP_E106_PLAY_SMART_PHONE = "E106"
  //  val TYP_E107_NOT_BELTING = "E107"

  val SUB_TYP__EMPTY = ""
  val SUB_TYP__TERM_NORMAL_OVER_SPD = "1"
  val SUB_TYP__TERM_ROAD_OVER_SPD = "2"


  val JT809Rev2011AlmTypes: Seq[String] = Seq(
    "0001",
    "0002",
    "0003",
    "0004",
    "0005",
    "0008",
    "0009",
    "000A",
    "000B",
    "000C",
    "000D",
    "0010",
    "00FF",
  )

  val JT809Rev2019AlmTypes: Seq[String] = JT809Rev2011AlmTypes ++ Seq(
    "0011",
    "0012",
    "0013",
    "0014",
    "A001",
    "A002",
    "A003",
    "A004",
    "A005",
    "A006",
    "A007",
    "A008",
    "A009",
    "A00A",
    "A0FF",
  )

  val JT1078AlmTypes: Seq[String] = Seq(
    "0101",
    "0102",
    "0103",
    "0104",
    "0105",
    "0106",
    "0107",
  )

  val CustomAlmTypes: Seq[String] = Seq(
    "E001",
    "E002",
    "E003",
    "E004"
  )

  val AdasAlmTypes: Seq[String] = Seq(
    TYP_0201_ADAS_FRONT_CRASH,
    TYP_0202_ADAS_STRAY_PATH,
    TYP_0203_ADAS_VEH_TOO_CLOSE,
    TYP_0204_ADAS_PEDESTRIAN_HIT,
    TYP_0205_ADAS_CHANGE_LANE_FREQUENTLY,
    TYP_0206_ADAS_ROAD_RECOG_OVERRUN,
    TYP_0207_ADAS_OBSTACLE,
    TYP_0208_ADAS_DRIVING_ASSIST_FUNC_FAILURE,
    TYP_0209_ADAS_ROAD_SIGN_RECOG_EVENT,
    TYP_020A_ADAS_VIOLATED_CHANGE_PATH,
    TYP_020B_ADAS_PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED,

    TYP_0211_ADAS_FATIGUED,
    TYP_0212_ADAS_NO_LOOK_AHEAD,
    TYP_0213_ADAS_SMOKE,
    TYP_0214_ADAS_PHONE_CALL,
    TYP_0215_ADAS_DRIVER_NOT_DETECTED,
    TYP_0216_ADAS_STEERING_WHEEL_NOT_HOLDING,
    TYP_0217_ADAS_DRIVER_BEHAV_ALM_FUNC_FAILURE,
    TYP_0218_ADAS_INVALID_DRIVER_ID,
    TYP_0219_ADAS_DRIVER_BEHAV_DRIVER_CHANGED_EVENT,
    TYP_021A_ADAS_NIGHT_DRIVE_PROHIBITED,
    TYP_021B_ADAS_DRIVE_OVERTIME,
    TYP_021C_ADAS_DRIVER_BEHAV_AUTO_CAPTURE,
    TYP_021D_ADAS_DRIVER_BEHAV_NOT_BELTING,
    TYP_021E_ADAS_ANTI_FACE_RECOG_DETECT_FUNC_FAILURE,
    TYP_021F_ADAS_DRIVER_BEHAV_IGNITED_CAPTURE,
    TYP_021H_ADAS_DRIVER_BEHAV_CAMERA_COVERED,


    TYP_0221_ADAS_TYRE_PRESS_TOO_HIGH,
    TYP_0222_ADAS_TYRE_PRESS_TOO_LOW,
    TYP_0223_ADAS_TYRE_TEMP_TOO_HIGH,
    TYP_0224_ADAS_TYRE_SENSOR_FAILURE,
    TYP_0225_ADAS_TYRE_PRESS_DISBALANCE,
    TYP_0226_ADAS_TYRE_AIR_LEAK_SLOWLY,
    TYP_0227_ADAS_BATTERY_LOW,

    TYP_0231_ADAS_REAR_TOO_CLOSE,
    TYP_0232_ADAS_LEFT_REAR_TOO_CLOSE,
    TYP_0233_ADAS_RIGHT_REAR_TOO_CLOSE,

    TYP_0241_ADAS_RAPID_ACCELERATE,
    TYP_0242_ADAS_RAPID_DECELERATE,
    TYP_0243_ADAS_RAPID_TURN,
    TYP_0244_ADAS_IDLING,
    TYP_0245_ADAS_UNEXPECTED_FLAME_OUT,
    TYP_0246_ADAS_SLIDING_ON_N,
    TYP_0247_ADAS_ENGINE_RPM_TOO_HIGH,

    TYP_0251_ADAS_OVER_EQUIP_SPD_LIMIT,
    TYP_0252_ADAS_OVER_ROAD_SPD_LIMIT,

    TYP_0261_ADAS_OVERLOAD,

    TYP_0271_ADAS_OVER_HEIGHT,
  )

  val AdasAlmTypeSet: Set[String] = AdasAlmTypes.toSet

  val AllAlmTypes: Seq[String] = JT809Rev2019AlmTypes ++ JT1078AlmTypes ++ AdasAlmTypes ++ CustomAlmTypes

  def almTypToStr(typ: Int): String = JTUtils.intToHex(typ, 4).toUpperCase

  def strToAlmTyp(typ: String): Int = Integer.parseInt(typ, 16)

  def resourceBundle(locale: Locale): ResourceBundle =
    ResourceBundle.getBundle(
      "info.gratour.jt808common.protocol.platform-alm-typ-names",
      if (locale != null) locale else Locale.getDefault
    )

  def almTypeName(almTypId: String, locale: Locale): String = {
    val key = "ALARM_TYPE_" + almTypId

    val bundle = resourceBundle(locale)

    if (bundle.containsKey(key))
      bundle.getString(key)
    else
      almTypId
  }

  def almTypeName(typ: Int, locale: Locale): String = {
    val almTypId = JTUtils.intToHex(typ, 4).toUpperCase
    almTypeName(almTypId, locale)
  }

  def almSubTypName(subTyp: String, locale: Locale): String = {
    subTyp match {
      case null | SUB_TYP__EMPTY =>
        ""

      case _ =>
        val key = "ALM_SUB_TYP_" + subTyp

        val bundle = resourceBundle(locale)

        if (bundle.containsKey(key))
          bundle.getString(key)
        else
          subTyp
    }
  }

}
