package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.codec.decoder.impl.{MBDecoder1078_1003_QryAvAttrsAck, MBDecoder1078_1005_PassengerTraffic, MBDecoder1078_1205_QryAvResAck, MBDecoder1078_1206_AvUploadCompleted, MBDecoder1078_9003_QryAvAttrs, MBDecoder1078_9101_LiveAvReq, MBDecoder1078_9102_LiveAvCtrl, MBDecoder1078_9201_ReplayAvReq, MBDecoder1078_9202_ReplayAvCtrl, MBDecoder1078_9205_QryAvRes, MBDecoder1078_9206_AvUploadReq, MBDecoder1078_9207_AvUploadCtrl, MBDecoder808_0001_TerminalGeneralAck, MBDecoder808_0002_Heartbeat, MBDecoder808_0003_TerminalUnregister, MBDecoder808_0004_QryServerTime, MBDecoder808_0100_TerminalRegister, MBDecoder808_0102_TerminalAuth, MBDecoder808_0104_QryParamsAck, MBDecoder808_0107_QryAttrsAck, MBDecoder808_0108_UpgradeResult, MBDecoder808_0200_Location, MBDecoder808_0201_QryLocationAck, MBDecoder808_0301_EventReport, MBDecoder808_0302_InquestAnswer, MBDecoder808_0303_InfoDemand, MBDecoder808_0500_VehCtrlAck, MBDecoder808_0700_VtdrData, MBDecoder808_0701_WayBill, MBDecoder808_0702_DriverIdentity, MBDecoder808_0702_DriverIdentity_Simplified, MBDecoder808_0704_BatchLocation, MBDecoder808_0705_CanData, MBDecoder808_0800_MultiMediaEvent, MBDecoder808_0800_MultiMediaEvent_Simplified, MBDecoder808_0801_MultiMediaData, MBDecoder808_0801_MultiMediaData_Simplified, MBDecoder808_0802_StoredMediaSearchAck, MBDecoder808_0805_TakePhotoAck, MBDecoder808_0900_PassThroughUl, MBDecoder808_0901_CompressedDataUl, MBDecoder808_8001_PlatformGeneralAck, MBDecoder808_8004_QryServerTimeAck, MBDecoder808_8107_QryAttrs, MBDecoderAdas_9208_AlmAttUploadReq, MBDecoderAdas_9212_AlmAttFileItemCompleted}
import info.gratour.jt808common.protocol.{JT808FrameHeader, JT808Msg}
import info.gratour.jtcommon.{JTCodecHelper, JTUtils}
import io.netty.buffer.ByteBuf

import scala.reflect.ClassTag

/**
 * JT808 消息体解码器
 * @param T 消息类型
 * @param classTag 类标签
 */
abstract class JT808MsgBodyDecoder[T <: JT808Msg](implicit classTag: ClassTag[T]) extends JTCodecHelper {

  /**
   * 消息ID
   * @return 消息ID
   */
  def msgId: Int = JTUtils.jtMsgIdOf(classTag.runtimeClass.asSubclass(classOf[JT808Msg]))

  /**
   * 解码消息体
   * @param protoVer 协议版本
   * @param adasDialect ADAS 方言
   * @param m 消息对象
   * @param body 消息体
   * @param tempBuf 临时缓冲区
   */
  def decodeMsgBody(protoVer: Byte, adasDialect: AdasDialect, m: T, body: ByteBuf, tempBuf: Array[Byte]): Unit

  /**
   * 解码消息体
   * @param adasDialect ADAS 方言
   * @param header 帧头
   * @param body 消息体
   * @param tempBuf 临时缓冲区
   * @return 解码后的消息对象。如果解码失败，返回 null
   */
  def decodeMsgBody(adasDialect: AdasDialect, header: JT808FrameHeader, body: ByteBuf, tempBuf: Array[Byte]): T = {
    val m = classTag.runtimeClass.getDeclaredConstructor().newInstance().asInstanceOf[T]
    m.setMsgId(header.getMsgId)
    m.setSeqNo(header.getSeqNo)
    m.setSimNo(header.getSimNo)

    decodeMsgBody(header.getProtoVer, adasDialect, m, body, tempBuf)

    m
  }

}

/**
 * JT808 消息体解码器工厂
 */
object JT808MsgBodyDecoders {

  /**
   * 2013 版本解码器
   */
  val REV_2013: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]] = Seq(
    // 808 - terminal
    MBDecoder808_0001_TerminalGeneralAck,
    MBDecoder808_0002_Heartbeat,
    MBDecoder808_0003_TerminalUnregister,
    MBDecoder808_0100_TerminalRegister,
    MBDecoder808_0102_TerminalAuth,
    MBDecoder808_0104_QryParamsAck,
    MBDecoder808_0107_QryAttrsAck,
    MBDecoder808_0108_UpgradeResult,
    MBDecoder808_0200_Location,
    MBDecoder808_0201_QryLocationAck,
    MBDecoder808_0301_EventReport,
    MBDecoder808_0302_InquestAnswer,
    MBDecoder808_0303_InfoDemand,
    MBDecoder808_0500_VehCtrlAck,
    MBDecoder808_0700_VtdrData,
    MBDecoder808_0701_WayBill,
    MBDecoder808_0702_DriverIdentity,
    MBDecoder808_0704_BatchLocation,
    MBDecoder808_0705_CanData,
    MBDecoder808_0800_MultiMediaEvent,
    MBDecoder808_0801_MultiMediaData,
    MBDecoder808_0805_TakePhotoAck,
    MBDecoder808_0802_StoredMediaSearchAck,
    MBDecoder808_0900_PassThroughUl,
    MBDecoder808_0901_CompressedDataUl,

    // 808 - platform
    MBDecoder808_8001_PlatformGeneralAck,
    MBDecoder808_8107_QryAttrs,

    // 1078 - terminal

    MBDecoder1078_1003_QryAvAttrsAck,
    MBDecoder1078_1005_PassengerTraffic,
    MBDecoder1078_1205_QryAvResAck,
    MBDecoder1078_1206_AvUploadCompleted,

    // 1078 - platform
    MBDecoder1078_9003_QryAvAttrs,
    MBDecoder1078_9101_LiveAvReq,
    MBDecoder1078_9102_LiveAvCtrl,
    MBDecoder1078_9201_ReplayAvReq,
    MBDecoder1078_9202_ReplayAvCtrl,
    MBDecoder1078_9205_QryAvRes,
    MBDecoder1078_9206_AvUploadReq,
    MBDecoder1078_9207_AvUploadCtrl
  )

  /**
   * 2013 版本简化解码器
   */
  val REV_2013_SIMPLIFIED: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]] = Seq(
    // 808 - terminal
    MBDecoder808_0001_TerminalGeneralAck,
    MBDecoder808_0002_Heartbeat,
    MBDecoder808_0003_TerminalUnregister,
    MBDecoder808_0100_TerminalRegister,
    MBDecoder808_0102_TerminalAuth,
    MBDecoder808_0104_QryParamsAck,
    MBDecoder808_0107_QryAttrsAck,
    MBDecoder808_0108_UpgradeResult,
    MBDecoder808_0200_Location,
    MBDecoder808_0201_QryLocationAck,
    MBDecoder808_0301_EventReport,
    MBDecoder808_0302_InquestAnswer,
    MBDecoder808_0303_InfoDemand,
    MBDecoder808_0500_VehCtrlAck,
    MBDecoder808_0700_VtdrData,
    MBDecoder808_0701_WayBill,
    MBDecoder808_0702_DriverIdentity_Simplified,
    MBDecoder808_0704_BatchLocation,
    MBDecoder808_0705_CanData,
    MBDecoder808_0800_MultiMediaEvent_Simplified,
    MBDecoder808_0801_MultiMediaData_Simplified,
    MBDecoder808_0805_TakePhotoAck,
    MBDecoder808_0802_StoredMediaSearchAck,
    MBDecoder808_0900_PassThroughUl,
    MBDecoder808_0901_CompressedDataUl,

    // 808 - platform
    MBDecoder808_8001_PlatformGeneralAck,
    MBDecoder808_8107_QryAttrs,

    // 1078 - terminal

    MBDecoder1078_1003_QryAvAttrsAck,
    MBDecoder1078_1005_PassengerTraffic,
    MBDecoder1078_1205_QryAvResAck,
    MBDecoder1078_1206_AvUploadCompleted,

    // 1078 - platform
    MBDecoder1078_9003_QryAvAttrs,
    MBDecoder1078_9101_LiveAvReq,
    MBDecoder1078_9102_LiveAvCtrl,
    MBDecoder1078_9201_ReplayAvReq,
    MBDecoder1078_9202_ReplayAvCtrl,
    MBDecoder1078_9205_QryAvRes,
    MBDecoder1078_9206_AvUploadReq,
    MBDecoder1078_9207_AvUploadCtrl
  )

  /**
   * 2019 版本解码器
   */
  val REV_2019: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]] = Seq(
    MBDecoder808_0004_QryServerTime,
    MBDecoder808_8004_QryServerTimeAck
  )

  /**
   * ADAS 解码器
   */
  val ADAS: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]] = Seq(
    MBDecoderAdas_9208_AlmAttUploadReq,
    MBDecoderAdas_9212_AlmAttFileItemCompleted
  )

  /**
   * 所有解码器
   */
  val ALL: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]] = REV_2013 ++ REV_2019 ++ ADAS

  /**
   * 所有简化解码器
   */
  val ALL_SIMPLIFIED: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]] = REV_2013_SIMPLIFIED ++ REV_2019 ++ ADAS
}
