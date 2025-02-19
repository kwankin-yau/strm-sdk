/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import info.gratour.jt808common.JT808Consts
import info.gratour.jt808common.codec.CodecError

/**
 * JT/T 编解码助手
 */
trait JTCodecHelper {

  /**
   * 2013 版本
   */
  val PROTO_VER__REV2013: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2013

  /**
   * 2019 版本
   */
  val PROTO_VER__REV2019: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2019


  /**
   * 创建不支持的数据类型异常
   * @param dataType 数据类型
   * @return 异常对象
   */
  def notSupportedDataType(dataType: Int): CodecError = new CodecError(s"Not supported data type: $dataType.")

  /**
   * 创建不支持的消息类型异常
   * @param msgType 消息类型
   * @return 异常对象
   */
  def notSupportedMsgType(msgType: Class[_]): CodecError = new CodecError(s"Not supported message type: ${msgType.getName}.")

  /**
   * 将轴值转换为双精度浮点数
   * @param axis 轴值
   * @return 双精度浮点数
  def intAxisToDouble(axis: Int): Double = JTUtils.intAxisToDouble(axis)

  /**
   * 将双精度浮点数转换为轴值
   * @param axis 双精度浮点数
   * @return 轴值
   */
  def doubleAxisToInt(axis: Double): Int = JTUtils.doubleAxisToInt(axis)

  protected def checkNotNull[A](o: A, propName: String): A = {
    if (o == null)
      throw new CodecError(s"`$propName` == null")

    o
  }

  protected def checkNotEmpty[A](o: Array[A], propName: String): Array[A] = {
    if (o == null)
      throw new CodecError(s"`$propName` == null")
    if (o.isEmpty)
      throw new CodecError(s"`$propName` is empty")

    o
  }



}
