/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jt808common.codec.decoder.impl

import info.gratour.jt808common.protocol.msg.types.vtdr.Vtdr_SpdAndStatus
import info.gratour.jtcommon.{BcdUtils, JTConsts, JTUtils}
import io.netty.buffer.ByteBuf
import org.apache.commons.codec.binary.Hex

/**
 * VTDR 解码辅助类
 */
trait Vtdr_DecodeHelper {

  /**
   * 解码2位BCD数字
   * @param buf 输入字节缓冲区
   * @return 解码后的数值
   */
  def decode2DigitBcd(buf: ByteBuf): Int = {
    val b = buf.readByte()
    BcdUtils.decodeByte(b)
  }

  /**
   * 解码2位BCD字符串
   * @param buf 输入字节缓冲区
   * @return 解码后的字符串
   */
  def decode2DigitBcdStr(buf: ByteBuf): String = {
    val b = buf.readByte()
    BcdUtils.decodeByte(b).toString
  }

  /**
   * 解码8位BCD字符串
   * @param buf 输入字节缓冲区
   * @return 解码后的字符串
   */
  def decode8DigitBcdStr(buf: ByteBuf): String = {
    val temp = new Array[Byte](4)
    buf.readBytes(temp)
    Hex.encodeHexString(temp)
  }

  /**
   * 解码6字节BCD日期时间表示
   * @param buf 输入字节缓冲区
   * @return 解码后的字符串
   */
  def decodeDateTime(buf: ByteBuf): String = {
    val temp: Array[Byte] = new Array[Byte](6)
    buf.readBytes(temp)
    Hex.encodeHexString(temp)
  }

  /**
   * 读取固定长度字符串
   * @param buf 输入字节缓冲区
   * @param len 字符串长度
   * @return 解码后的字符串
   */
  def readFixedLenStr(buf: ByteBuf, len: Int): String = {
    val temp: Array[Byte] = new Array[Byte](len)
    buf.readBytes(temp)
    new String(temp, JTConsts.DEFAULT_CHARSET)
  }

  /**
   * 读取固定长度C字符串(0x00结尾，或达到指定长度)
   * @param buf 输入字节缓冲区
   * @param len 字符串长度
   * @return 解码后的字符串
   */
  def readFixedLenCStr(buf: ByteBuf, len: Int): String = {
    val temp: Array[Byte] = new Array[Byte](len)
    buf.readBytes(temp)
    JTUtils.cStr(temp, JTConsts.DEFAULT_CHARSET)
  }

  /**
   * 解码速度和状态
   * @param buf 输入字节缓冲区
   * @return 解码后的速度和状态
   */
  def decodeSpdAndStatus(buf: ByteBuf): Vtdr_SpdAndStatus = {
    val b = buf.readByte()
    if (b == -1) {
      buf.skipBytes(1)
      return null
    }

    val r = new Vtdr_SpdAndStatus
    r.setSpd((b & 0xFF).toShort)
    r.setStatus(buf.readByte())
    r
  }

}
