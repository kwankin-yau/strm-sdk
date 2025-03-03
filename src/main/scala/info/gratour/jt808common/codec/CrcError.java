/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec;

import info.gratour.jtcommon.LazyBytesProvider;

/**
 * CRC 校验错误异常
 */
public class CrcError extends CodecError {

    private LazyBytesProvider bytes;

    /**
     * 构造函数
     * @param message 异常消息
     */
    public CrcError(String message) {
        super(message);
    }

    /**
     * 构造函数
     * @param message 异常消息
     * @param bytes 惰性字节提供者
     */
    public CrcError(String message, LazyBytesProvider bytes) {
        super(message);
        this.bytes = bytes;
    }

    /**
     * 构造函数
     * @param message 异常消息
     * @param cause 异常原因
     */
    public CrcError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     * @param message 异常消息
     * @param bytes 惰性字节提供者
     * @param cause 异常原因
     */
    public CrcError(String message, LazyBytesProvider bytes, Throwable cause) {
        super(message, cause);
        this.bytes = bytes;
    }

    @Override
    public LazyBytesProvider getBytes() {
        return bytes;
    }
}
