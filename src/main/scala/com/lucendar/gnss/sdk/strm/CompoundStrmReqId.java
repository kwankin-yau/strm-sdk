package com.lucendar.gnss.sdk.strm;

/**
 * 组合流请求ID抽象
 */
public interface CompoundStrmReqId {

    /**
     * 取流请求ID
     *
     * @return 流请求ID
     */
    String getReqId();

    /**
     * 取请求时间
     *
     * @return 请求时间, epoch millis
     */
    long getReqTm();
}
