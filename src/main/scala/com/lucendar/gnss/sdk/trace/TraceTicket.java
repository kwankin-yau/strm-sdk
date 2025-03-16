package com.lucendar.gnss.sdk.trace;

/**
 * 终端跟踪凭据，取消跟踪时，可调用此接口的 `untrace` 方法
 */
public interface TraceTicket {

    /**
     * 所属 appId
     * @return appId
     */
    String appId();

    /**
     * 终端识别号
     * @return 终端识别号
     */
    String simNo();

    /**
     * 取消跟踪
     */
    void untrace();
}
