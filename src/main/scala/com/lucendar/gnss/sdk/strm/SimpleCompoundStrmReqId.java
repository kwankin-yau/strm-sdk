package com.lucendar.gnss.sdk.strm;

import java.util.StringJoiner;

/**
 * 简单的复合流请求ID
 */
public class SimpleCompoundStrmReqId implements CompoundStrmReqId {

    private final String reqId;
    private final long reqTm;

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param reqTm 请求时间, epoch millis
     */
    public SimpleCompoundStrmReqId(String reqId, long reqTm) {
        this.reqId = reqId;
        this.reqTm = reqTm;
    }

    @Override
    public String getReqId() {
        return reqId;
    }

    @Override
    public long getReqTm() {
        return reqTm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleCompoundStrmReqId.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("reqTm=" + reqTm)
                .toString();
    }
}
