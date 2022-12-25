/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.microftp.model;

public class AVUpload {
    public static final byte STATE__REQUESTED = 1;
    public static final byte STATE__UPLOADING = 2;
    public static final byte STATE__UPLOADED = 3;
    public static final byte STATE__FAILED = 4;
    public static final byte STATE__CANCELED = 5;


    private String reqId;
    private String reqTm;
    private int st;
    private String simNo;
    private int chan;
    private String startTm;
    private String endTm;
    private int alm808;
    private int alm1078;
    private int mediaTyp;
    private int codeStrm;
    private int stgTyp;
    private long fileSz;
    private String path;
    private String fileName;
    private String uploadTm;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public int getChan() {
        return chan;
    }

    public void setChan(int chan) {
        this.chan = chan;
    }

    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public String getEndTm() {
        return endTm;
    }

    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    public int getAlm808() {
        return alm808;
    }

    public void setAlm808(int alm808) {
        this.alm808 = alm808;
    }

    public int getAlm1078() {
        return alm1078;
    }

    public void setAlm1078(int alm1078) {
        this.alm1078 = alm1078;
    }

    public int getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(int mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public int getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(int codeStrm) {
        this.codeStrm = codeStrm;
    }

    public int getStgTyp() {
        return stgTyp;
    }

    public void setStgTyp(int stgTyp) {
        this.stgTyp = stgTyp;
    }

    public long getFileSz() {
        return fileSz;
    }

    public void setFileSz(long fileSz) {
        this.fileSz = fileSz;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadTm() {
        return uploadTm;
    }

    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    @Override
    public String toString() {
        return "AVUpload{" +
                "reqId='" + reqId + '\'' +
                ", reqTm='" + reqTm + '\'' +
                ", st=" + st +
                ", simNo='" + simNo + '\'' +
                ", chan=" + chan +
                ", startTm='" + startTm + '\'' +
                ", endTm='" + endTm + '\'' +
                ", alm808=" + alm808 +
                ", alm1078=" + alm1078 +
                ", mediaTyp=" + mediaTyp +
                ", codeStrm=" + codeStrm +
                ", stgTyp=" + stgTyp +
                ", fileSz=" + fileSz +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadTm='" + uploadTm + '\'' +
                '}';
    }
}
