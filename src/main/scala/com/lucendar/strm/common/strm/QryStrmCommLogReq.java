package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 查询媒体服务通讯日志请求
 */
public class QryStrmCommLogReq {

    private String reqId;
    private int __limit;
    private int __page;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public int get__limit() {
        return __limit;
    }

    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    public int get__page() {
        return __page;
    }

    public void set__page(int __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmCommLogReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
