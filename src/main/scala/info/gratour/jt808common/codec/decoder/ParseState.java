package info.gratour.jt808common.codec.decoder;

/**
 * JT/T 808 解析状态
 */
public enum ParseState {

    /**
     * 初始状态
     */
    INIT, 

    /**
     * 等待开始的 0x7E
     */
    START_7E, 

    /**
     * 已经遇到 0x7D
     */
    ENCOUNTERED_7D, 

    /**
     * 等待结束的 0x7E
     */
    END_7E;
}
