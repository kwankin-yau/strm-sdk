package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 查询媒体通知记录
 */
public class QryStrmMediaNotifRecReq {

    private String reqId;

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmMediaNotifRecReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .toString();
    }
}
