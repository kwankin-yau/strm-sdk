/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.msgtransform.jt808

import java.util.{Map => JMap}

import info.gratour.jt808common.msgtransform.{TerminalCmdToMsgTransformer, TerminalCmdToMsgTransformerRegistry}
import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jt808common.protocol.msg._
import info.gratour.jt808common.protocol.msg.types.cmdparams._
import info.gratour.jt808common.spi.model.TermCmd
import info.gratour.jtcommon.JTUtils

import scala.reflect.ClassTag


/**
 * 终端命令到 JT808 消息转换器
 * @tparam T 消息类型
 */
abstract class CmdToJT808MsgTransformers[T <: JT808Msg](implicit classTag: ClassTag[T]) extends TerminalCmdToMsgTransformer {

  /**
   * 获取所处理的消息的消息 ID
   * @return 消息 ID
   */
  protected[jt808] def msgId: Int =
    JTUtils.jtMsgIdOf(classTag.runtimeClass)

  /**
   * 设置消息参数
   * @param m 消息
   * @param cmd 终端命令
   */
  protected def setParams(m: T, cmd: TermCmd): Unit

  /**
   * 获取所处理的消息的类型参数类
   * @return 类型参数类
   */
  protected def getTypeParameterClass: Class[_] =
    classTag.runtimeClass

  /**
   * 将终端命令转换为消息
   * @param cmd 终端命令
   * @return 消息
   */
  override def toMsg(cmd: TermCmd): T = {
    val clzz = getTypeParameterClass

    val m = clzz.getDeclaredConstructor().newInstance().asInstanceOf[T]
    m.setSimNo(cmd.getSimNo)

    setParams(m, cmd)
    m
  }
}

/**
 * 非法的终端命令异常
 * @param message 异常消息
 */
class BadTerminalCmd(message: String) extends Exception(message)

/**
 * 终端命令参数
 */

trait CmdParams {

  /**
   * 获取参数映射
   * @return 参数映射
   */
  def getMap: JMap[String, Object]

  private def getParam(name: String): Object = {
    val o = getMap.get(name)
    if (o == null)
      throw new BadTerminalCmd(s"No property `$name`.")

    o
  }

  /**
   * 获取整数参数
   * @param name 参数名称
   * @return 整数参数
   */
  def getInt(name: String): Int = {
    val o = getParam(name)

    o match {
      case i: Integer =>
        i

      case s: String =>
        val i = JTUtils.tryParseInt(s)
        if (i == null)
          throw new BadTerminalCmd(s"No property ")

        i

      case _ =>
        throw new BadTerminalCmd(s"No property ")
    }
  }

  /**
   * 获取字符串参数
   * @param name 参数名称
   * @return 字符串参数
   */
  def getStr(name: String): String =
    getParam(name).toString
}

/**
 * 终端命令到 JT808 消息转换器注册表
 */
object CmdToJT808MsgTransformerRegistry extends TerminalCmdToMsgTransformerRegistry {
  private val map: Map[Int, TerminalCmdToMsgTransformer] = Seq(
    CTMT_8103_SetParam,
    CTMT_8104_QryAllParams,
    CTMT_8106_QrySpecialParams,
    CTMT_8105_TerminalCtrl,
    CTMT_8107_QryAttrs,
    CTMT_8201_QryLocation,
    CTMT_8202_LocationTraceCtrl,
    CTMT_8203_ManualConfirmAlarm,
    CTMT_8300_SendText,
    CTMT_8301_SetUpEvent,
    CTMT_8302_Inquest,
    CTMT_8303_SetUpInfoMenu,
    CTMT_8304_InfoService,
    CTMT_8400_PhoneCallback,
    CTMT_8401_SetUpPhoneBook,
    CTMT_8500_VehCtrl,
    CTMT_8600_SetCircleRegion,
    CTMT_8601_DelCircleRegion,
    CTMT_8602_SetRectRegion,
    CTMT_8603_DelRectRegion,
    CTMT_8604_SetPolygonRegion,
    CTMT_8605_DelPolygonRegion,
    CTMT_8606_SetRoute,
    CTMT_8607_DelRoute,
    CTMT_8700_VTDRDataCollectReq,
    CTMT_8701_VTDRSetParams,
    CTMT_8702_DriverIdentityReq,
    CTMT_8801_TakePhoto,
    CTMT_8802_StoredMediaSearch,
    CTMT_8803_StoredMediaReq,
    CTMT_8804_AudioRecordCtrl,
    CTMT_8805_SingleStoredMediaReq,

    // the following is 1078 command transformer
    CTMT_9003_QryAVAttrs,
    CTMT_9101_LiveAVReq,
    CTMT_9102_LiveAVCtrl,
    CTMT_9105_LiveAVStatus,
    CTMT_9201_ReplayAV,
    CTMT_9205_QryAVRes,
    CTMT_9202_ReplayAVCtrl,
    CTMT_9206_AVUploadReq,
    CTMT_9207_AVUploadCtrl,
    CTMT_9301_PTZTurn,
    CTMT_9302_PTZFocusing,
    CTMT_9303_PTZIrisCtrl,
    CTMT_9304_PTZWiperCtrl,
    CTMT_9305_PTZFillLightCtrl,
    CTMT_9306_PTZZoomCtrl,

    // the following is Si-Chuan command transformer
    CTMT_9208_AlarmAttUploadReq,
    CTMT_9212_AlarmAttFileItemCompleted,

  ).map(t => t.msgId -> t).toMap

  /**
   * 根据消息ID获取 JT808 消息转换器
   * @param msgId 消息 ID
   * @return JT808 消息转换器
   */
  override def get(msgId: Int): TerminalCmdToMsgTransformer = {
    map.get(msgId).orNull
  }
}

/**
 * 设置参数(0x8103)消息转换器
 */
object CTMT_8103_SetParam extends CmdToJT808MsgTransformers[JT808Msg_8103_SetParam] {
  override protected def setParams(m: JT808Msg_8103_SetParam, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8103_SetParams]
    m.setParams(cp)
  }
}

/**
 * 查询所有参数(0x8104)消息转换器
 */
object CTMT_8104_QryAllParams extends CmdToJT808MsgTransformers[JT808Msg_8104_QryAllParams] {

  override protected def setParams(m: JT808Msg_8104_QryAllParams, cmd: TermCmd): Unit = {
    // nop
  }
}

/**
 * 查询特殊参数(0x8106)消息转换器
 */
object CTMT_8106_QrySpecialParams extends CmdToJT808MsgTransformers[JT808Msg_8106_QrySpecialParams] {
  override protected def setParams(m: JT808Msg_8106_QrySpecialParams, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8106_QrySpecialParams]
    m.setParams(cp)
  }
}

/**
 * 终端控制(0x8105)消息转换器
 */
object CTMT_8105_TerminalCtrl extends CmdToJT808MsgTransformers[JT808Msg_8105_TerminalCtrl] {
  override protected def setParams(m: JT808Msg_8105_TerminalCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8105_TerminalCtrl]
    m.setParams(cp)
  }
}

/**
 * 查询属性(0x8107)消息转换器
 */
object CTMT_8107_QryAttrs extends CmdToJT808MsgTransformers[JT808Msg_8107_QryAttrs] {
  override protected def setParams(m: JT808Msg_8107_QryAttrs, cmd: TermCmd): Unit = {
    // nop
  }
}

/**
 * 查询位置(0x8201)消息转换器
 */
object CTMT_8201_QryLocation extends CmdToJT808MsgTransformers[JT808Msg_8201_QryLocation] {
  override protected def setParams(m: JT808Msg_8201_QryLocation, cmd: TermCmd): Unit = {
    // nop
  }
}

/**
 * 位置追踪控制(0x8202)消息转换器
 */
object CTMT_8202_LocationTraceCtrl extends CmdToJT808MsgTransformers[JT808Msg_8202_LocationTraceCtrl] {
  override protected def setParams(m: JT808Msg_8202_LocationTraceCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8202_LocationTraceCtrl]
    m.setParams(cp)
  }
}

/**
 * 手动确认报警(0x8203)消息转换器
 */
object CTMT_8203_ManualConfirmAlarm extends CmdToJT808MsgTransformers[JT808Msg_8203_ManualConfirmAlarm] {
  override protected def setParams(m: JT808Msg_8203_ManualConfirmAlarm, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8203_ManualConfirmAlarm]
    m.setParams(cp)
  }
}

/**
 * 发送文本(0x8300)消息转换器
 */
object CTMT_8300_SendText extends CmdToJT808MsgTransformers[JT808Msg_8300_SendText] {
  override protected def setParams(m: JT808Msg_8300_SendText, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8300_SendText]
    m.setParams(cp)
  }
}

/**
 * 设置事件(0x8301)消息转换器
 */
object CTMT_8301_SetUpEvent extends CmdToJT808MsgTransformers[JT808Msg_8301_SetUpEvent] {
  override protected def setParams(m: JT808Msg_8301_SetUpEvent, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8301_SetUpEvent]
    m.setParams(cp)
  }
}

/**
 * 提问下发(0x8302)消息转换器
 */
object CTMT_8302_Inquest extends CmdToJT808MsgTransformers[JT808Msg_8302_Inquest] {
  override protected def setParams(m: JT808Msg_8302_Inquest, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8302_Inquest]
    m.setParams(cp)
  }
}

/**
 * 设置信息服务(0x8303)消息转换器
 */
object CTMT_8303_SetUpInfoMenu extends CmdToJT808MsgTransformers[JT808Msg_8303_SetUpInfoMenu] {
  override protected def setParams(m: JT808Msg_8303_SetUpInfoMenu, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8303_SetUpInfoMenu]
    m.setParams(cp)
  }
}

/**
 * 信息服务(0x8304)消息转换器
 */
object CTMT_8304_InfoService extends CmdToJT808MsgTransformers[JT808Msg_8304_InfoService] {
  override protected def setParams(m: JT808Msg_8304_InfoService, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8304_InfoService]
    m.setParams(cp)
  }
}

/**
 * 电话回拨(0x8400)消息转换器
 */
object CTMT_8400_PhoneCallback extends CmdToJT808MsgTransformers[JT808Msg_8400_PhoneCallback] {
  override protected def setParams(m: JT808Msg_8400_PhoneCallback, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8400_PhoneCallback]
    m.setParams(cp)
  }
}

/**
 * 设置电话簿(0x8401)消息转换器
 */
object CTMT_8401_SetUpPhoneBook extends CmdToJT808MsgTransformers[JT808Msg_8401_SetUpPhoneBook] {
  override protected def setParams(m: JT808Msg_8401_SetUpPhoneBook, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8401_SetUpPhoneBook]
    m.setParams(cp)
  }
}

/**
 * 车辆控制(0x8500)消息转换器
 */
object CTMT_8500_VehCtrl extends CmdToJT808MsgTransformers[JT808Msg_8500_VehCtrl] {
  override protected def setParams(m: JT808Msg_8500_VehCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8500_VehCtrl]
    m.setParams(cp)
  }
}

/**
 * 设置圆形区域(0x8600)消息转换器
 */
object CTMT_8600_SetCircleRegion extends CmdToJT808MsgTransformers[JT808Msg_8600_SetCircleRegion] {
  override protected def setParams(m: JT808Msg_8600_SetCircleRegion, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8600_SetCircleRegion]
    m.setParams(cp)
  }
}

/**
 * 删除圆形区域(0x8601)消息转换器
 */
object CTMT_8601_DelCircleRegion extends CmdToJT808MsgTransformers[JT808Msg_8601_DelCircleRegion] {
  override protected def setParams(m: JT808Msg_8601_DelCircleRegion, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8601_DelCircleRegion]
    m.setParams(cp)
  }
}

/**
 * 设置矩形区域(0x8602)消息转换器
 */
object CTMT_8602_SetRectRegion extends CmdToJT808MsgTransformers[JT808Msg_8602_SetRectRegion] {
  override protected def setParams(m: JT808Msg_8602_SetRectRegion, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8602_SetRectRegion]
    m.setParams(cp)
  }
}

/**
 * 删除矩形区域(0x8603)消息转换器
 */
object CTMT_8603_DelRectRegion extends CmdToJT808MsgTransformers[JT808Msg_8603_DelRectRegion] {
  override protected def setParams(m: JT808Msg_8603_DelRectRegion, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8603_DelRectRegion]
    m.setParams(cp)
  }
}

/**
 * 设置多边形区域(0x8604)消息转换器
 */
object CTMT_8604_SetPolygonRegion extends CmdToJT808MsgTransformers[JT808Msg_8604_SetPolygonRegion] {
  override protected def setParams(m: JT808Msg_8604_SetPolygonRegion, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8604_SetPolygonRegion]
    m.setParams(cp)
  }
}

/**
 * 删除多边形区域(0x8605)消息转换器
 */
object CTMT_8605_DelPolygonRegion extends CmdToJT808MsgTransformers[JT808Msg_8605_DelPolygonRegion] {
  override protected def setParams(m: JT808Msg_8605_DelPolygonRegion, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8605_DelPolygonRegion]
    m.setParams(cp)
  }
}

/**
 * 设置路线(0x8606)消息转换器
 */
object CTMT_8606_SetRoute extends CmdToJT808MsgTransformers[JT808Msg_8606_SetRoute] {
  override protected def setParams(m: JT808Msg_8606_SetRoute, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8606_SetRoute]
    m.setParams(cp)
  }
}

/**
 * 删除路线(0x8607)消息转换器
 */
object CTMT_8607_DelRoute extends CmdToJT808MsgTransformers[JT808Msg_8607_DelRoute] {
  override protected def setParams(m: JT808Msg_8607_DelRoute, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8607_DelRoute]
    m.setParams(cp)
  }
}

/**
 * 车辆行驶记录仪数据采集请求(0x8700)消息转换器
 */
object CTMT_8700_VTDRDataCollectReq extends CmdToJT808MsgTransformers[JT808Msg_8700_VtdrDataCollectReq] {
  override protected def setParams(m: JT808Msg_8700_VtdrDataCollectReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8700_VtdrDataCollectReq]
    m.setParams(cp)
  }
}

/**
 * 车辆行驶记录仪参数设置(0x8701)消息转换器
 */
object CTMT_8701_VTDRSetParams extends CmdToJT808MsgTransformers[JT808Msg_8701_VtdrSetParams] {
  override protected def setParams(m: JT808Msg_8701_VtdrSetParams, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8701_VtdrSetParams]
    m.setParams(cp)
  }
}

/**
 * 驾驶员身份认证请求(0x8702)消息转换器
 */
object CTMT_8702_DriverIdentityReq extends CmdToJT808MsgTransformers[JT808Msg_8702_DriverIdentityReq] {
  override protected def setParams(m: JT808Msg_8702_DriverIdentityReq, cmd: TermCmd): Unit = {
    // nop
  }
}

/**
 * 拍照请求(0x8801)消息转换器
 */
object CTMT_8801_TakePhoto extends CmdToJT808MsgTransformers[JT808Msg_8801_TakePhoto] {
  override protected def setParams(m: JT808Msg_8801_TakePhoto, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8801_TakePhoto]
    m.setParams(cp)
  }
}

/**
 * 存储媒体搜索(0x8802)消息转换器
 */
object CTMT_8802_StoredMediaSearch extends CmdToJT808MsgTransformers[JT808Msg_8802_StoredMediaSearch] {
  override protected def setParams(m: JT808Msg_8802_StoredMediaSearch, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8802_StoredMediaSearch]
    m.setParams(cp)
  }
}

/**
 * 存储媒体请求(0x8803)消息转换器
 */
object CTMT_8803_StoredMediaReq extends CmdToJT808MsgTransformers[JT808Msg_8803_StoredMediaReq] {
  override protected def setParams(m: JT808Msg_8803_StoredMediaReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8803_StoredMediaReq]
    m.setParams(cp)
  }
}

/**
 * 音频记录控制(0x8804)消息转换器
 */
object CTMT_8804_AudioRecordCtrl extends CmdToJT808MsgTransformers[JT808Msg_8804_AudioRecordCtrl] {
  override protected def setParams(m: JT808Msg_8804_AudioRecordCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8804_AudioRecordCtrl]
    m.setParams(cp)
  }
}

/**
 * 单个存储媒体请求(0x8805)消息转换器
 */
object CTMT_8805_SingleStoredMediaReq extends CmdToJT808MsgTransformers[JT808Msg_8805_SingleStoredMediaReq] {
  override protected def setParams(m: JT808Msg_8805_SingleStoredMediaReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_8805_SingleStoredMediaReq]
    m.setParams(cp)
  }
}

/**
 * 查询音频记录参数(0x9003)消息转换器
 */
object CTMT_9003_QryAVAttrs extends CmdToJT808MsgTransformers[JT1078Msg_9003_QryAvAttrs] {
  override protected def setParams(m: JT1078Msg_9003_QryAvAttrs, cmd: TermCmd): Unit = {
    // nop
  }
}

/**
 * 实时音视频请求(0x9101)消息转换器
 */
object CTMT_9101_LiveAVReq extends CmdToJT808MsgTransformers[JT1078Msg_9101_LiveAvReq] {
  override protected def setParams(m: JT1078Msg_9101_LiveAvReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9101_LiveAvReq]
    m.setParams(cp)
  }
}

/**
 * 实时音视频控制(0x9102)消息转换器
 */
object CTMT_9102_LiveAVCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9102_LiveAvCtrl] {
  override protected def setParams(m: JT1078Msg_9102_LiveAvCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9102_LiveAvCtrl]
    m.setParams(cp)
  }
}

/**
 * 实时音视频状态(0x9105)消息转换器
 */
object CTMT_9105_LiveAVStatus extends CmdToJT808MsgTransformers[JT1078Msg_9105_LiveAvStatus] {
  override protected def setParams(m: JT1078Msg_9105_LiveAvStatus, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9105_LiveAvStatus]
    m.setParams(cp)
  }
}

/**
 * 查询音视频资源(0x9205)消息转换器
 */
object CTMT_9205_QryAVRes extends CmdToJT808MsgTransformers[JT1078Msg_9205_QryAvRes] {
  override protected def setParams(m: JT1078Msg_9205_QryAvRes, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9205_QryAvRes]
    m.setParams(cp)
  }
}

/**
 * 音视频回放请求(0x9201)消息转换器
 */
object CTMT_9201_ReplayAV extends CmdToJT808MsgTransformers[JT1078Msg_9201_ReplayAvReq] {
  override protected def setParams(m: JT1078Msg_9201_ReplayAvReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9201_ReplayAvReq]
    m.setParams(cp)
  }
}

/**
 * 音视频回放控制(0x9202)消息转换器
 */
object CTMT_9202_ReplayAVCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9202_ReplayAvCtrl] {
  override protected def setParams(m: JT1078Msg_9202_ReplayAvCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9202_ReplayAvCtrl]
    m.setParams(cp)
  }
}

/**
 * 音视频上传请求(0x9206)消息转换器
 */
object CTMT_9206_AVUploadReq extends CmdToJT808MsgTransformers[JT1078Msg_9206_AvUploadReq] {
  override protected def setParams(m: JT1078Msg_9206_AvUploadReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9206_AvUploadReq]
    m.setParams(cp)
  }
}

/**
 * 音视频上传控制(0x9207)消息转换器
 */
object CTMT_9207_AVUploadCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9207_AvUploadCtrl] {
  override protected def setParams(m: JT1078Msg_9207_AvUploadCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9207_AvUploadCtrl]
    m.setParams(cp)
  }
}

/**
 * 云台转动(0x9301)消息转换器
 */
object CTMT_9301_PTZTurn extends CmdToJT808MsgTransformers[JT1078Msg_9301_PtzTurn] {
  override protected def setParams(m: JT1078Msg_9301_PtzTurn, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9301_PtzTurn]
    m.setParams(cp)
  }
}

/**
 * 云台聚焦(0x9302)消息转换器
 */
object CTMT_9302_PTZFocusing extends CmdToJT808MsgTransformers[JT1078Msg_9302_PtzFocusing] {
  override protected def setParams(m: JT1078Msg_9302_PtzFocusing, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9302_PtzFocusing]
    m.setParams(cp)
  }
}

/**
 * 云台虹膜控制(0x9303)消息转换器
 */
object CTMT_9303_PTZIrisCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9303_PtzIrisCtrl] {
  override protected def setParams(m: JT1078Msg_9303_PtzIrisCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9303_PtzIrisCtrl]
    m.setParams(cp)
  }
}

/**
 * 云台雨刮控制(0x9304)消息转换器
 */
object CTMT_9304_PTZWiperCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9304_PtzWiperCtrl] {
  override protected def setParams(m: JT1078Msg_9304_PtzWiperCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9304_PtzWiperCtrl]
    m.setParams(cp)
  }
}

/**
 * 云台补光灯控制(0x9305)消息转换器
 */
object CTMT_9305_PTZFillLightCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9305_PtzFillLightCtrl] {
  override protected def setParams(m: JT1078Msg_9305_PtzFillLightCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9305_PtzFillLightCtrl]
    m.setParams(cp)
  }
}

/**
 * 云台变倍控制(0x9306)消息转换器
 */
object CTMT_9306_PTZZoomCtrl extends CmdToJT808MsgTransformers[JT1078Msg_9306_PtzZoomCtrl] {
  override protected def setParams(m: JT1078Msg_9306_PtzZoomCtrl, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9306_PtzZoomCtrl]
    m.setParams(cp)
  }
}

/**
 * ADAS报警附件上传请求(0x9208)消息转换器
 */
object CTMT_9208_AlarmAttUploadReq extends CmdToJT808MsgTransformers[JTAdasMsg_9208_AlmAttUploadReq] {
  override protected def setParams(m: JTAdasMsg_9208_AlmAttUploadReq, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9208_AlmAddtUploadReq]
    m.setParams(cp)
  }
}

/**
 * ADAS报警附件文件项完成(0x9212)消息转换器
 */
object CTMT_9212_AlarmAttFileItemCompleted extends CmdToJT808MsgTransformers[JTAdasMsg_9212_AlmAttFileItemCompleted] {
  override protected def setParams(m: JTAdasMsg_9212_AlmAttFileItemCompleted, cmd: TermCmd): Unit = {
    val cp = cmd.getParams.asInstanceOf[CP_9212_AlmAttFileItemCompleted]
    m.setParams(cp)
  }
}
