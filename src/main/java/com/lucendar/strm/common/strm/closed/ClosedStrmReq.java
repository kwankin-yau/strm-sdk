/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.closed;

import java.util.StringJoiner;

public class ClosedStrmReq {

    private String reqId;
    private String userId;
    private long reqTm;
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

    public long getReqTm() {
        return reqTm;
    }

    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
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
        return new StringJoiner(", ", ClosedStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("userId='" + userId + "'")
                .add("reqTm=" + reqTm)
                .add("lastKeepTm=" + lastKeepTm)
                .add("strmReadyTm=" + strmReadyTm)
                .add("proto=" + proto)
                .add("closeCause=" + closeCause)
                .add("closeTm=" + closeTm)
                .toString();
    }
}
