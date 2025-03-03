package info.gratour.jt808common.codec.decoder

import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.protocol.{JT808Frame, JT808Msg}

/**
 * JT808 消息解码器
 * @param adasDialect ADAS 方言
 * @param simplified 是否使用简化解码
 */
class JT808MsgDecoder(adasDialect: AdasDialect, simplified: Boolean) {

  private val registry: JT808MsgBodyDecoderRegistry =
    if (simplified)
      SimplifiedMsgBodyDecoderRegistry
    else
      DefaultMsgBodyDecoderRegistry

  /**
   * 解码消息
   * @param frame 要解码的帧
   * @param tempBuf 用于解码的临时缓冲区，应由 [[JT808MsgDecoder.allocDecodeTempBuf]] 分配
   * @return 解码后的消息。如果解码失败，返回 null
   */
  def decode(frame: JT808Frame, tempBuf: Array[Byte]): JT808Msg = {
    val bodyDecoder = registry.get(frame.getHeader.getMsgId)
    if (bodyDecoder != null)
      bodyDecoder.decodeMsgBody(adasDialect, frame.getHeader, frame.getBody, tempBuf).asInstanceOf[JT808Msg]
    else
      new JT808Msg(frame.getHeader)
  }
}

/**
 * JT808 消息解码器 Companion Object
 */
object JT808MsgDecoder {
  
  /**
   * 分配用于解码的临时缓冲区
   * @return 临时缓冲区
   */
  def allocDecodeTempBuf: Array[Byte] = JT808FrameDecoder.allocTempBuf()
}
