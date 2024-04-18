package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class KeepStrmResult {

    private String reqId;
    private boolean keep;

    public KeepStrmResult() {
    }

    public KeepStrmResult(String reqId, boolean keep) {
        this.reqId = reqId;
        this.keep = keep;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public boolean isKeep() {
        return keep;
    }

    public void setKeep(boolean keep) {
        this.keep = keep;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KeepStrmResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("keep=" + keep)
                .toString();
    }
}
