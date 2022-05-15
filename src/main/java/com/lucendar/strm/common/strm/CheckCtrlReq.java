package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class CheckCtrlReq {
    private String reqId;

    public CheckCtrlReq() {
    }

    public CheckCtrlReq(String reqId) {
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
        return new StringJoiner(", ", CheckCtrlReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .toString();
    }
}

