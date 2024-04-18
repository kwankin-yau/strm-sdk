/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

public class AvUploadStatus implements AbstractAvUpload, Cloneable {

    protected String reqId;
    protected String simNo;
    protected String startTm;
    protected Long sz;
    protected String cb;
    protected int st;
    protected Long uploaded;

    public AvUploadStatus() {
    }

    public AvUploadStatus(String reqId, String simNo, String startTm, Long sz, String cb, int st, Long uploaded) {
        this.reqId = reqId;
        this.simNo = simNo;
        this.startTm = startTm;
        this.sz = sz;
        this.cb = cb;
        this.st = st;
        this.uploaded = uploaded;
    }

    public static AvUploadStatus from(AbstractAvUpload avUpload, int st, Long uploaded) {
        return new AvUploadStatus(
                avUpload.getReqId(),
                avUpload.getSimNo(),
                avUpload.getStartTm(),
                avUpload.getSz(),
                avUpload.getCb(),
                st,
                uploaded);
    }

    @Override
    public String getReqId() {
        return reqId;
    }

    @Override
    public String getSimNo() {
        return simNo;
    }

    @Override
    public String getStartTm() {
        return startTm;
    }

    @Override
    public Long getSz() {
        return sz;
    }

    @Override
    public String getCb() {
        return cb;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public void setSz(Long sz) {
        this.sz = sz;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public Long getUploaded() {
        return uploaded;
    }

    public void setUploaded(Long uploaded) {
        this.uploaded = uploaded;
    }


    @Override
    public AvUploadStatus clone() {
        try {
            AvUploadStatus clone = (AvUploadStatus) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadStatus.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("startTm='" + startTm + "'")
                .add("sz=" + sz)
                .add("cb='" + cb + "'")
                .add("st=" + st)
                .add("uploaded=" + uploaded)
                .toString();
    }
}
