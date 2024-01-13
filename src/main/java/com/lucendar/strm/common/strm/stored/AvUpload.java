/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.StreamingApi;

import java.util.StringJoiner;

/**
 * This class represent a terminal remote A/V file upload request and the state of the request.
 * The `AvUpload` used for supply to client, while `AvUpload2` used for internal storage.
 *
 * Note: the format of time properties in this class are `yyyy-MM-dd HH:mm:ss`.
 */
public class AvUpload implements Cloneable {

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

    public static boolean isAckOrEndingState(int st) {
        return st >= 2;
    }

    private String reqId;
    private String reqTm;
    private int st;
    private String appId;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public boolean endingState() {
        return isEndingState(st);
    }

    public boolean ackOrEndingState() {
        return isAckOrEndingState(st);
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

    public static String calcFileNameWithPath(String path, String fileName) {
        String s = path;
        if (s == null || s.isEmpty())
            s = "/";
        else if (!s.startsWith("/"))
            s = "/" + s;

        if (!s.endsWith("/"))
            s = s + "/";

        return s + fileName;
    }

    public String fileNameWithPath() {
        return calcFileNameWithPath(path, fileName);
    }

    public String getUploadTm() {
        return uploadTm;
    }

    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    /**
     * 文件的下载 URL。仅当 st == AvUpload2#STATE__UPLOADED 时有效。
     * 注意，这个 下载 URL 是有时效的：
     * 1. 查询获得的 url 在两小时后失效
     * 2. 两次查询同一个 AvUpload，返回的 url 可能不一样
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

    public AvUpload url(String value) {
        this.url = value;
        return this;
    }

    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    public void assignFrom(AvUpload2 avUpload2) {
        reqId = avUpload2.getReqId();
        reqTm = avUpload2.getReqTm();
        st = avUpload2.getSt();
        appId = avUpload2.getAppId();
        simNo = avUpload2.getSimNo();
        channel = avUpload2.getChan();
        startTime = avUpload2.getStartTm();
        endTime = avUpload2.getEndTm();
        almState = avUpload2.getAlmSt();
        mediaType = avUpload2.getMediaTyp();
        codeStream = avUpload2.getCodeStrm();
        storageType = avUpload2.getStgTyp();
        fileSz = avUpload2.getSz();
        path = avUpload2.getPath();
        fileName = avUpload2.getFn();
        uploadTm = avUpload2.getUploadTm();
    }

    @Override
    public AvUpload clone() {
        try {
            return (AvUpload) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUpload.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("reqTm='" + reqTm + "'")
                .add("st=" + st)
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("channel=" + channel)
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("almState='" + almState + "'")
                .add("mediaType=" + mediaType)
                .add("codeStream=" + codeStream)
                .add("storageType=" + storageType)
                .add("fileSz=" + fileSz)
                .add("path='" + path + "'")
                .add("fileName='" + fileName + "'")
                .add("uploadTm='" + uploadTm + "'")
                .add("url='" + url + "'")
                .toString();
    }
}
