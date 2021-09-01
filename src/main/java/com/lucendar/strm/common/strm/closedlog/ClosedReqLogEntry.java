/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.closedlog;

public class ClosedReqLogEntry {

    private String reqId;
    private String userId;
    private long requestTm;
    private long lastKeepTm;
    private Long strmReadyTm;
    private int proto;
    private int closeCause;
    private long closeTm;

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

    public long getRequestTm() {
        return requestTm;
    }

    public void setRequestTm(long requestTm) {
        this.requestTm = requestTm;
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

    public int getProto() {
        return proto;
    }

    public void setProto(int proto) {
        this.proto = proto;
    }

    public int getCloseCause() {
        return closeCause;
    }

    public void setCloseCause(int closeCause) {
        this.closeCause = closeCause;
    }

    public long getCloseTm() {
        return closeTm;
    }

    public void setCloseTm(long closeTm) {
        this.closeTm = closeTm;
    }

    @Override
    public String toString() {
        return "ClosedReqLogEntry{" +
                "reqId='" + reqId + '\'' +
                ", userId='" + userId + '\'' +
                ", requestTm=" + requestTm +
                ", lastKeepTm=" + lastKeepTm +
                ", strmReadyTm=" + strmReadyTm +
                ", proto=" + proto +
                ", closeCause=" + closeCause +
                ", closeTm=" + closeTm +
                '}';
    }
}
