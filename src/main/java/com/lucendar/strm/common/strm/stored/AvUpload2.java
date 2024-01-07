/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.StreamingApi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.StringJoiner;

/**
 * This class represent a terminal remote A/V file upload request and the state of the request.
 * The `AvUpload2` used for internal storage while `AvUpload` used for supply to client.
 *
 * @apiNote the format of time properties in this class are `yyyy-MM-dd HH:mm:ss`.
 */
public class AvUpload2 implements AbstractAvUpload, Cloneable {

    public static String avResPath(String simNo, long startTm, String reqId) {
        OffsetDateTime odt = OffsetDateTime.ofInstant(Instant.ofEpochMilli(startTm), StreamingApi.BEIJING_ZONE_OFFSET);
        LocalDate ld = odt.toLocalDate();
        int month = ld.getMonthValue();
        String monthS = month < 10 ? "0" + month : String.valueOf(month);
        return "/" + ld.getYear() + "/" + monthS + "/" + simNo + "/" + reqId;
    }

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
    private int chan;
    private String startTm;
    private String endTm;
    private String almSt;
    private int mediaTyp;
    private int codeStrm;
    private int stgTyp;
    private Long sz;
    private String path;
    private String fn;
    private String uploadTm;
    private String url;
    private String cb;

    private String strmInst;

    @Override
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

    public boolean endingState() {
        return isEndingState(st);
    }

    public boolean ackOrEndingState() {
        return isAckOrEndingState(st);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
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

    /**
     * Get the start time of the terminal stored AV file. Date time format: `yyyy-MM-dd HH:mm:ss`.
     *
     * @return start time of the terminal stored AV file.
     */
    @Override
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

    public String getAlmSt() {
        return almSt;
    }

    public void setAlmSt(String almSt) {
        this.almSt = almSt;
    }

    public void setAlmSt(long almSt) {
        this.almSt = Long.toHexString(almSt);
    }

    public static long almStOf(String almState) {
        if (almState != null)
            return Long.parseLong(almState, 16);
        else
            return 0L;
    }

    public long almStateToLong() {
        return almStOf(almSt);
    }

    public static int alm808Of(String almState) {
        if (almState != null) {
            long l = Long.parseLong(almState, 16);
            return (int) l;
        } else
            return 0;
    }

    public int alm808() {
        return alm808Of(almSt);
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
        return alm1078Of(almSt);
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

    /**
     * The claimed size of the A/V file.
     *
     * @return claimed size of the A/V file.
     */
    public Long getSz() {
        return sz;
    }

    public void setSz(Long sz) {
        this.sz = sz;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String fileNameWithPath() {
        return AvUpload.calcFileNameWithPath(path, fn);
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
    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    /**
     * 创建AvUpload任务时使用的媒体服务的实例ID
     *
     * @return
     */
    public String getStrmInst() {
        return strmInst;
    }

    public void setStrmInst(String strmInst) {
        this.strmInst = strmInst;
    }

    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    public String url() {
        return url;
    }

    public AvUpload2 url(String url) {
        this.url = url;
        return this;
    }

    public AvUpload toAvUpload() {
        AvUpload r = new AvUpload();
        r.assignFrom(this);
        return r;
    }

    @Override
    public AvUpload2 clone() {
        try {
            return (AvUpload2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUpload2.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("reqTm='" + reqTm + "'")
                .add("st=" + st)
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("startTm='" + startTm + "'")
                .add("endTm='" + endTm + "'")
                .add("almSt='" + almSt + "'")
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("sz=" + sz)
                .add("path='" + path + "'")
                .add("fn='" + fn + "'")
                .add("uploadTm='" + uploadTm + "'")
                .add("url='" + url + "'")
                .add("cb='" + cb + "'")
                .add("strmInst='" + strmInst + "'")
                .toString();
    }
}
