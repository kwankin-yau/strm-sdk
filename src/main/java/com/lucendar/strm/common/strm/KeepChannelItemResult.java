package com.lucendar.strm.common.strm;

public class KeepChannelItemResult {
    private String reqId;
    private boolean keep;

    public KeepChannelItemResult() {
    }

    public KeepChannelItemResult(String reqId, boolean keep) {
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
        return "KeepChannelItemResult{" +
                "reqId='" + reqId + '\'' +
                ", keep=" + keep +
                '}';
    }
}
