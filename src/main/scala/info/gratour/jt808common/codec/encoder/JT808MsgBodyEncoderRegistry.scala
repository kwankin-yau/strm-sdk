package info.gratour.jt808common.codec.encoder

/**
 * 808 消息体编码器注册表
 */
trait JT808MsgBodyEncoderRegistry {

  /**
   * 获取消息体编码器
   * @param msgId 消息 ID
   * @return 消息体编码器
   */
  def get(msgId: Int): JT808MsgBodyEncoder

  /**
   * 获取消息体编码器映射
   * @param encoders 消息体编码器序列
   * @return 消息体编码器映射
   */
  protected def mapOf(encoders: Seq[JT808MsgBodyEncoder]): Map[Int, JT808MsgBodyEncoder] =
    encoders.map(e => e.msgId -> e).toMap
}

/**
 * 默认 808 消息体编码器注册表
 */
object DefaultJT808MsgBodyEncoderRegistry extends JT808MsgBodyEncoderRegistry {
  private final val Map: Map[Int, JT808MsgBodyEncoder] = JT808MsgBodyEncoders.ALL.map(d => d.msgId -> d).toMap
  override def get(msgId: Int): JT808MsgBodyEncoder = Map.get(msgId).orNull
}
