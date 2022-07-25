package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

public class StrmReqStatus {
    private String reqId;
    private String userId;
    private long reqTm;
    private int proto;
    private long lastKeepTm;
    private Long strmReadyTm;
    private Long closeTm;
    private Integer closeCause;

    public StrmReqStatus() {
    }

    public StrmReqStatus(String reqId, String userId, long reqTm, int proto, long lastKeepTm, Long strmReadyTm, Long closeTm, Integer closeCause) {
        this.reqId = reqId;
        this.userId = userId;
        this.reqTm = reqTm;
        this.proto = proto;
        this.lastKeepTm = lastKeepTm;
        this.strmReadyTm = strmReadyTm;
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

    public int getProto() {
        return proto;
    }

    public void setProto(int proto) {
        this.proto = proto;
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

    public Long getStrmReadyTm() {
        return strmReadyTm;
    }

    public void setStrmReadyTm(Long strmReadyTm) {
        this.strmReadyTm = strmReadyTm;
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
                .add("proto=" + proto)
                .add("lastKeepTm=" + lastKeepTm)
                .add("strmReadyTm=" + strmReadyTm)
                .add("closeTm=" + closeTm)
                .add("closeCause=" + closeCause)
                .toString();
    }
}
