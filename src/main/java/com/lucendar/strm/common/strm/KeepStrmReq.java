package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.Arrays;
import java.util.StringJoiner;

public class KeepStrmReq implements StrmMsg {
    private String[] reqIds;
    private ServerHint strmServerHint;

    public KeepStrmReq() {
    }

    public KeepStrmReq(String reqId) {
        this.reqIds = new String[]{reqId};
    }

    public KeepStrmReq(String[] reqIds, ServerHint strmServerHint) {
        this.reqIds = reqIds;
        this.strmServerHint = strmServerHint;
    }

    public String[] getReqIds() {
        return reqIds;
    }

    public void setReqIds(String[] reqIds) {
        this.reqIds = reqIds;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public String toString() {
        if (strmServerHint != null)
            return new StringJoiner(", ", KeepStrmReq.class.getSimpleName() + "[", "]")
                    .add("reqIds=" + Arrays.toString(reqIds))
                    .add("strmServerHint=" + strmServerHint)
                    .toString();
        else
            return new StringJoiner(", ", KeepStrmReq.class.getSimpleName() + "[", "]")
                    .add("reqIds=" + Arrays.toString(reqIds))
                    .toString();

    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__KeepStrmReq;
    }
}
