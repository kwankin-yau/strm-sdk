package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class CheckChannelReq {

    private String reqId;

    public CheckChannelReq() {
    }

    public CheckChannelReq(String reqId) {
        this.reqId = reqId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckChannelReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .toString();
    }
}
