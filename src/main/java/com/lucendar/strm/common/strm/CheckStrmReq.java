package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

public class CheckStrmReq implements StrmMsg {

    private String reqId;

    public CheckStrmReq() {
    }

    public CheckStrmReq(String reqId) {
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
        return new StringJoiner(", ", CheckStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__CheckStrmReq;
    }
}
