package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

/**
 * 查询聚合跟踪日志请求
 */
public class QryCombinedTraceLogReq {

    private String reqId;
    private Integer __limit;
    private Integer __page;

    /**
     * 取请求ID
     *
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     *
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取分页每页大小
     * @return 分页每页大小
     */
    public Integer get__limit() {
        return __limit;
    }

    /**
     * 设置分页每页大小
     * @param __limit 分页每页大小
     */
    public void set__limit(Integer __limit) {
        this.__limit = __limit;
    }

    /**
     * 取分页页号
     * @return 分页页号，从1开始
     */
    public Integer get__page() {
        return __page;
    }

    /**
     * 设置分页页号
     * @param __page 分页页号，从1开始
     */
    public void set__page(Integer __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryCombinedTraceLogReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
