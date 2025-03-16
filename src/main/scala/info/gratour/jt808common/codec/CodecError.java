/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec;

import info.gratour.jtcommon.LazyBytesProvider;

/**
 * 编解码异常
 */
public class CodecError extends RuntimeException {

    /**
     * 惰性字节提供者
     */
    private LazyBytesProvider bytes;

    /**
     * 构造函数
     * @param message 异常消息
     */
    public CodecError(String message) {
        super(message);
    }

    /**
     * 构造函数
     * @param message 异常消息
     * @param bytes 惰性字节提供者
     */
    public CodecError(String message, LazyBytesProvider bytes) {
        super(message);
        this.bytes = bytes;
    }

    /**
     * 构造函数
     * @param message 异常消息
     * @param cause 异常原因
     */
    public CodecError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     * @param message 异常消息
     * @param bytes 惰性字节提供者
     * @param cause 异常原因
     */
    public CodecError(String message, LazyBytesProvider bytes, Throwable cause) {
        super(message, cause);
        this.bytes = bytes;
    }

    /** 
     * 获取惰性字节提供者
     * @return 惰性字节提供者
     */
    public LazyBytesProvider getBytes() {
        return bytes;
    }

}
