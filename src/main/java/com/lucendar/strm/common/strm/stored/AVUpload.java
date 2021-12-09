/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

public class AVUpload implements Cloneable {

    public static final byte STATE__REQUESTED = 1;
    public static final byte STATE__ACK = 2;
    public static final byte STATE__UPLOADING = 3;
    public static final byte STATE__UPLOADED = 4;
    public static final byte STATE__FAILED = 5;
    public static final byte STATE__CANCELED = 6;
    public static final byte STATE__TIMEOUT = 7;

    public static boolean isEndingState(int st) {
        return st > 3;
    }

    private String reqId;
    private String reqTm;
    private int st;
    private String simNo;
    private int channel;
    private String startTime;
    private String endTime;
    private String almState;
    private int mediaType;
    private int codeStream;
    private int storageType;
    private Long fileSz;
    private String path;
    private String fileName;
    private String uploadTm;
    private String url;

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

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAlmState() {
        return almState;
    }

    public void setAlmState(String almState) {
        this.almState = almState;
    }

    public void setAlmState(long almState) {
        this.almState = Long.toHexString(almState);
    }

    public static long almStateOf(String almState) {
        if (almState != null)
            return Long.parseLong(almState, 16);
        else
            return 0L;
    }

    public long almStateToLong() {
        return almStateOf(almState);
    }

    public static int alm808Of(String almState) {
        if (almState != null) {
            long l = Long.parseLong(almState, 16);
            return (int) l;
        } else
            return 0;
    }

    public int alm808() {
        return alm808Of(almState);
    }

    public static int alm1078Of(String almState) {
        if (almState != null) {
            long l = Long.parseLong(almState, 16);
            l >>= 32;
            return (int) l;
        } else {
            return 0;
        }
    }

    public int alm1078() {
        return alm1078Of(almState);
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(int codeStream) {
        this.codeStream = codeStream;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public Long getFileSz() {
        return fileSz;
    }

    public void setFileSz(Long fileSz) {
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

    public String fileNameWithPath() {
        String s = path;
        if (s == null || s.isEmpty())
            s = "/";
        else if (!s.startsWith("/"))
            s = "/" + s;

        if (!s.endsWith("/"))
            s = s  + "/";

        return s + fileName;
    }

    public String getUploadTm() {
        return uploadTm;
    }

    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public AVUpload clone() {
        try {
            return (AVUpload) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AVUpload{" +
                "reqId='" + reqId + '\'' +
                ", reqTm='" + reqTm + '\'' +
                ", st=" + st +
                ", simNo='" + simNo + '\'' +
                ", channel=" + channel +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", almState='" + almState + '\'' +
                ", mediaType=" + mediaType +
                ", codeStream=" + codeStream +
                ", storageType=" + storageType +
                ", fileSz=" + fileSz +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadTm='" + uploadTm + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
