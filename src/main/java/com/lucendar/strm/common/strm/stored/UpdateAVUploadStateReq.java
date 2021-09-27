/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

public class UpdateAVUploadStateReq {
    private String startTime;
    private String reqId;
    private int st;
    private String fileName;
    private Long fileSz;
    private String uploadTm;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSz() {
        return fileSz;
    }

    public void setFileSz(Long fileSz) {
        this.fileSz = fileSz;
    }

    public String getUploadTm() {
        return uploadTm;
    }

    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    @Override
    public String toString() {
        return "UpdateAVUploadStateReq{" +
                "startTime='" + startTime + '\'' +
                ", reqId='" + reqId + '\'' +
                ", st=" + st +
                ", fileName='" + fileName + '\'' +
                ", fileSz=" + fileSz +
                ", uploadTm='" + uploadTm + '\'' +
                '}';
    }
}
