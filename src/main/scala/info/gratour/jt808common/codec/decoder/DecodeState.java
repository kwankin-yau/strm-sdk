package info.gratour.jt808common.codec.decoder;

/**
 * 解码状态
 */
public enum  DecodeState {

    /**
     * 未识别
     */
    UNRECOGNIZED,

    /**
     * 已识别，但未完整解释出消息
     */
    RECOGNIZED,

    /**
     * 已解码
     */
    DECODED;

    /**
     * 是否已识别或已解码
     * @return 是否已识别或已解码
     */
    public boolean ok() {
        return this != UNRECOGNIZED;
    }
}
