package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

public class StrmReqStatus {
    private String reqId;
    private String userId;
    private long reqTm;
    private int fmt;
    private long lastKeepTm;
    private Long readyTm;
    private Long closeTm;
    private Integer closeCause;

    public StrmReqStatus() {
    }

    public StrmReqStatus(String reqId, String userId, long reqTm, int fmt, long lastKeepTm, Long readyTm, Long closeTm, Integer closeCause) {
        this.reqId = reqId;
        this.userId = userId;
        this.reqTm = reqTm;
        this.fmt = fmt;
        this.lastKeepTm = lastKeepTm;
        this.readyTm = readyTm;
        this.closeTm = closeTm;
        this.closeCause = closeCause;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getReqTm() {
        return reqTm;
    }

    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    public int getFmt() {
        return fmt;
    }

    public void setFmt(int fmt) {
        this.fmt = fmt;
    }

    public Integer getCloseCause() {
        return closeCause;
    }

    public void setCloseCause(Integer closeCause) {
        this.closeCause = closeCause;
    }

    public long getLastKeepTm() {
        return lastKeepTm;
    }

    public void setLastKeepTm(long lastKeepTm) {
        this.lastKeepTm = lastKeepTm;
    }

    public Long getReadyTm() {
        return readyTm;
    }

    public void setReadyTm(Long readyTm) {
        this.readyTm = readyTm;
    }

    public Long getCloseTm() {
        return closeTm;
    }

    public void setCloseTm(Long closeTm) {
        this.closeTm = closeTm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmReqStatus.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("userId='" + userId + "'")
                .add("reqTm=" + reqTm)
                .add("fmt=" + fmt)
                .add("lastKeepTm=" + lastKeepTm)
                .add("readyTm=" + readyTm)
                .add("closeTm=" + closeTm)
                .add("closeCause=" + closeCause)
                .toString();
    }
}
