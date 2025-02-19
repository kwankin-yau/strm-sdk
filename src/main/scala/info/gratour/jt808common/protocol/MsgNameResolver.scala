/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.protocol

import java.util.{Locale, MissingResourceException, ResourceBundle}

import info.gratour.jtcommon.{JTMessages, JTUtils}

/**
 * 消息名称解析器 
 */
trait MsgNameResolver {

  /**
   * 获取消息名称
   * @param msgId 消息ID
   * @param locale 区域
   * @return 消息名称
   */
  def nameOf(msgId: Int, locale: Locale): String

  /**
   * 获取消息名称
   * @param msgId 消息ID
   * @param locale 区域
   * @return 消息名称
   */
  def nameOf(msgId: String, locale: Locale): String = nameOf(Integer.parseInt(msgId, 16), locale)
}

/**
 * 默认消息名称解析器
 */
object DefaultMsgNameResolver extends MsgNameResolver {

  private def jt808MsgNameBundle(locale: Locale): ResourceBundle = ResourceBundle.getBundle("info.gratour.jt808common.protocol.jt808-msg-names", if (locale != null) locale else Locale.getDefault)

  private def jt1078MsgNameBundle(locale: Locale): ResourceBundle = ResourceBundle.getBundle("info.gratour.jt808common.protocol.jt1078-msg-names", if (locale != null) locale else Locale.getDefault)

  override def nameOf(msgId: Int, locale: Locale): String = {
    val key = JTUtils.msgIdToHex(msgId)
    val bundle =
      if ((msgId & 0x9000) == 0x9000)
        jt1078MsgNameBundle(locale)
      else
        jt808MsgNameBundle(locale)

    if (bundle.containsKey(key))
      bundle.getString(key)
    else
      JTMessages.unknown(locale) + " (" + key + ")"
  }

}
