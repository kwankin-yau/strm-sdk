package info.gratour.jt808common.codec.encoder

import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.protocol.JT808Msg
import info.gratour.jtcommon.{JTConsts, JTUtils}
import io.netty.buffer.ByteBuf

/**
 * 808 消息编码器
 * @param protoVer JT/T 808 协议版本, 0 表示 2013 版本, 1 表示 2019 版本, 见 [[JTConsts]] 中的 `PROTO_VER` 常量
 * @param adasDialect ADAS 方言
 */
class JT808MsgEncoder(protoVer: Byte, adasDialect: AdasDialect) {

  import JT808MsgEncoder.LOGGER

  /**
   * 808 消息体编码器注册表
   */
  final val MsgBodyEncoderRegistry: JT808MsgBodyEncoderRegistry = DefaultJT808MsgBodyEncoderRegistry

  /**
   * 将消息编码到 `out` 缓冲区。方法调用 JT808FrameEncoder 进行帧级编码。
   *
   * @param seqNumAllocator 消息序列号分配器
   * @param msg 需要编码的消息
   * @param tempBuf 用于编码的临时缓冲区
   * @param out 输出字节缓冲区
   *
   * @return 片段/包数量
   */
  def encode(seqNumAllocator: SeqNumAllocator, msg: JT808Msg, tempBuf: ByteBuf, out: ByteBuf): Int = {
    val msgId = msg.getMsgId
    val encoder = MsgBodyEncoderRegistry.get(msgId)
    if (encoder == null) {
      LOGGER.warn("No message body encoder registered for : `{}`.", JTUtils.msgIdToHex(msgId))
      return 0
    }

    JT808FrameEncoder.encode(protoVer, adasDialect, seqNumAllocator, msg, encoder, tempBuf, out)
  }
}

/**
 * 808 消息编码器 Companion Object
 */
object JT808MsgEncoder {
  final val LOGGER: Logger = Logger[JT808MsgEncoder]
}
