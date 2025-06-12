package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.protocol.JT808Msg

/**
 * JT808 消息体解码器注册表
 */
trait JT808MsgBodyDecoderRegistry {

  /**
   * 获取消息体解码器
   * @param msgId 消息ID
   * @return 消息体解码器
   */
  def get(msgId: Int): JT808MsgBodyDecoder[_]

  /**
   * 将给定消息体解码器转换成 map 形式
   * @param decoders 消息体解码器序列
   * @return 消息体解码器 map
   */
  protected def mapOf(decoders: Seq[JT808MsgBodyDecoder[_ <: JT808Msg]]): Map[Int, JT808MsgBodyDecoder[_]] =
    decoders.map(d => d.msgId -> d).toMap
}

/**
 * 默认消息体解码器注册表
 */
object DefaultMsgBodyDecoderRegistry extends JT808MsgBodyDecoderRegistry {
  private final val Map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoders.ALL.map(d => d.msgId -> d).toMap
  override def get(msgId: Int): JT808MsgBodyDecoder[_] = Map.get(msgId).orNull
}

/**
 * 简化解码器注册表
 */
object SimplifiedMsgBodyDecoderRegistry extends JT808MsgBodyDecoderRegistry {
  private final val Map: Map[Int, JT808MsgBodyDecoder[_]] = JT808MsgBodyDecoders.ALL_SIMPLIFIED.map(d => d.msgId -> d).toMap
  override def get(msgId: Int): JT808MsgBodyDecoder[_] = Map.get(msgId).orNull
}
