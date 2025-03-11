/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.types.RelativeFileNameProvider;
import com.lucendar.strm.common.utils.StrmUtils;

/**
 * This class represent a terminal remote A/V file upload request and the state of the request.
 * The `AvUpload2` used for internal storage while `AvUpload` used for supply to client.
 *
 * Note: the format of time properties in this class are `yyyy-MM-dd HH:mm:ss`.
 */
public class AvUpload2 implements AbstractAvUpload, Cloneable, RelativeFileNameProvider {

    /**
     * 计算AV文件的存储路径
     *
     * @param simNo 终端设备号
     * @param startTm 开始时间戳
     * @param reqId 请求ID
     * @return 存储路径
     */    
    public static String avResPath(String simNo, long startTm, String reqId) {
        OffsetDateTime odt = OffsetDateTime.ofInstant(Instant.ofEpochMilli(startTm), StreamingApi.BEIJING_ZONE_OFFSET);
        LocalDate ld = odt.toLocalDate();
        int month = ld.getMonthValue();
        String monthS = month < 10 ? "0" + month : String.valueOf(month);
        return "/" + ld.getYear() + "/" + monthS + "/" + simNo + "/" + reqId;
    }

    /**
     * 初始状态
     */
    public static final int STATE__REQUESTED = AvUpload.STATE__REQUESTED;

    /**
     * 已应答状态
     */
    public static final int STATE__ACK = AvUpload.STATE__ACK;

    /**
     * 上传中状态
     */
    public static final int STATE__UPLOADING = AvUpload.STATE__UPLOADING;

    /**
     * 已上传状态
     */
    public static final int STATE__UPLOADED = AvUpload.STATE__UPLOADED;

    /**
     * 失败状态
     */
    public static final int STATE__FAILED = AvUpload.STATE__FAILED;

    /**
     * 已取消状态
     */
    public static final int STATE__CANCELED = AvUpload.STATE__CANCELED;

    /**
     * 超时状态
     */
    public static final int STATE__TIMEOUT = AvUpload.STATE__TIMEOUT;

    /**
     * 暂停状态
     */
    public static final int STATE__PAUSED = AvUpload.STATE__PAUSED;

    /**
     * 音频和视频媒体类型
     */
    public static final int MEDIA_TYP__AV = AvUpload.MEDIA_TYP__AV;

    /**
     * 音频媒体类型
     */
    public static final int MEDIA_TYP__AUDIO = AvUpload.MEDIA_TYP__AUDIO;

    /**
     * 视频媒体类型
     */
    public static final int MEDIA_TYP__VIDEO = AvUpload.MEDIA_TYP__VIDEO;

    /**
     * 主码流
     */
    public static final int CODE_STRM__PRIMARY = AvUpload.CODE_STRM__PRIMARY;

    /**
     * 子码流
     */
    public static final int CODE_STRM__SUB = AvUpload.CODE_STRM__SUB;

    /**
     * 主存储类型
     */
    public static final int STG_TYP___PRIMARY = AvUpload.STG_TYP___PRIMARY;

    /**
     * 备份存储类型
     */
    public static final int STG_TYP___SECONDARY = AvUpload.STG_TYP___SECONDARY;

    /**
     * 判断请求是否结束状态
     *
     * @param st 请求状态
     * @return 是否结束状态
     */
    public static boolean isEndingState(int st) {
        return AvUpload.isEndingState(st);
    }

    /**
     * 判断请求是否已应答或结束状态
     *
     * @param st 请求状态
     * @return 是否已应答或结束状态
     */
    public static boolean isAckOrEndingState(int st) {
        return AvUpload.isAckOrEndingState(st);
    }

    /**
     * 请求ID
     */
    private String reqId;

    /**
     * 请求时间
     */
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

    /**
     * 设置请求ID
     *
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取请求时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 请求时间
     */
    public String getReqTm() {
        return reqTm;
    }

    /**
     * 设置请求时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param reqTm 请求时间
     */
    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 获取请求状态, 为 AvUpload2.STATE__* 常量之一
     *
     * @return 请求状态
     */
    public int getSt() {
        return st;
    }

    /**
     * 设置请求状态, 为 AvUpload2.STATE__* 常量之一
     *
     * @param st 请求状态
     */
    public void setSt(int st) {
        this.st = st;
    }

    /**
     * 判断请求是否结束状态
     *
     * @return 是否结束状态
     */
    public boolean endingState() {
        return isEndingState(st);
    }

    /**
     * 判断请求是否已应答或结束状态
     *
     * @return 是否已应答或结束状态
     */
    public boolean ackOrEndingState() {
        return isAckOrEndingState(st);
    }

    /**
     * 获取应用ID
     *
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     *
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 获取通道号
     *
     * @return 通道号
     */
    public int getChan() {
        return chan;
    }

    /**
     * 设置通道号
     *
     * @param chan 通道号
     */
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

    /**
     * 设置开始时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param startTm 开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 获取结束时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 结束时间
     */
    public String getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param endTm 结束时间
     */
    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    /**
     * 获取报警状态, 格式：十六进制字符串
     *
     * @return 报警状态
     */
    public String getAlmSt() {
        return almSt;
    }

    /**
     * 设置报警状态, 格式：十六进制字符串
     *
     * @param almSt 报警状态
     */
    public void setAlmSt(String almSt) {
        this.almSt = almSt;
    }

    /**
     * 设置报警状态
     *
     * @param almSt 报警状态
     */
    public void setAlmSt(long almSt) {
        this.almSt = Long.toHexString(almSt);
    }

    /**
     * 将告警状态转换为长整型
     *
     * @param almState 报警状态
     * @return 报警状态
     */
    public static long almStOf(String almState) {
        if (almState != null)
            return Long.parseLong(almState, 16);
        else
            return 0L;
    }

    /**
     * 将报警状态转换为长整型
     *
     * @return 报警状态
     */
    public long almStateToLong() {
        return almStOf(almSt);
    }

    /**
     * 从十六进制的报警状态字符串中取808的报警状态字
     *
     * @param almState 报警状态
     * @return 808的报警状态字
     */
    public static int alm808Of(String almState) {
        if (almState != null) {
            long l = Long.parseLong(almState, 16);
            return (int) l;
        } else
            return 0;
    }

    /**
     * 从十六进制的报警状态字符串中取808的报警状态字
     *
     * @return 808的报警状态字
     */
    public int alm808() {
        return alm808Of(almSt);
    }

    /**
     * 从十六进制的报警状态字符串中取1078的报警状态字
     *
     * @param almState 报警状态
     * @return 1078的报警状态字
     */
    public static int alm1078Of(String almState) {
        if (almState != null) {
            long l = Long.parseLong(almState, 16);
            l >>= 32;
            return (int) l;
        } else {
            return 0;
        }
    }

    /**
     * 从十六进制的报警状态字符串中取1078的报警状态字
     *
     * @return 1078的报警状态字
     */
    public int alm1078() {
        return alm1078Of(almSt);
    }

    /**
     * 获取媒体类型
     *
     * @return 媒体类型
     */
    public int getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置媒体类型
     *
     * @param mediaTyp 媒体类型
     */
    public void setMediaTyp(int mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 获取码流类型
     *
     * @return 码流类型
     */
    public int getCodeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流类型
     *
     * @param codeStrm 码流类型
     */
    public void setCodeStrm(int codeStrm) {
        this.codeStrm = codeStrm;
    }

    /**
     * 获取存储类型
     *
     * @return 存储类型
     */
    public int getStgTyp() {
        return stgTyp;
    }

    /**
     * 设置存储类型
     *
     * @param stgTyp 存储类型
     */
    public void setStgTyp(int stgTyp) {
        this.stgTyp = stgTyp;
    }

    /**
     * 取视频文件标称的文件大小
     *
     * @return 视频文件标称的文件大小
     */
    public Long getSz() {
        return sz;
    }

    /**
     * 设置视频文件标称的文件大小
     *
     * @param sz 视频文件标称的文件大小
     */
    public void setSz(Long sz) {
        this.sz = sz;
    }

    /**
     * 获取视频文件的存储路径
     *
     * @return 视频文件的存储路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置视频文件的存储路径
     *
     * @param path 视频文件的存储路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取视频文件的文件名
     *
     * @return 视频文件的文件名
     */
    public String getFn() {
        return fn;
    }

    /**
     * 设置视频文件的文件名
     *
     * @param fn 视频文件的文件名
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * 获取视频文件带路径的文件名
     *
     * @param withLeadingForwardSlash 是否添加前导斜杠
     * @return 视频文件带路径的文件名
     */
    public String fileNameWithPath(boolean withLeadingForwardSlash) {
        return StrmUtils.calcFileNameWithPath(path, fn, withLeadingForwardSlash);
    }

    /**
     * 获取视频文件带路径的文件名(URL编码)
     *
     * @param withLeadingForwardSlash 是否添加前导斜杠
     * @return 视频文件带路径的文件名(URL编码)
     */
    public String fileNameWithPathUrl(boolean withLeadingForwardSlash) {
        return StrmUtils.calcFileNameWithPath(path, URLEncoder.encode(fn, StandardCharsets.UTF_8), withLeadingForwardSlash);
    }

    /**
     * 获取视频文件的上传时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 视频文件的上传时间
     */
    public String getUploadTm() {
        return uploadTm;
    }

    /**
     * 设置视频文件的上传时间, 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param uploadTm 视频文件的上传时间
     */
    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    /**
     * 获取视频文件的下载URL
     *
     * @return 视频文件的下载URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置视频文件的下载URL
     *
     * @param url 视频文件的下载URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getCb() {
        return cb;
    }

    /**
     * 设置上传状态通知回调地址
     *
     * @param cb 上传状态通知回调地址
     */
    public void setCb(String cb) {
        this.cb = cb;
    }

    /**
     * 取创建AvUpload任务时使用的媒体服务的实例ID
     *
     * @return 媒体服务的实例ID
     */
    public String getStrmInst() {
        return strmInst;
    }

    /**
     * 设置媒体服务的实例ID
     *
     * @param strmInst 媒体服务的实例ID
     */
    public void setStrmInst(String strmInst) {
        this.strmInst = strmInst;
    }

    /**
     * 取应用ID, 如果为空, 则返回默认应用ID
     *
     * @return 应用ID
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 取视频文件的下载URL
     *
     * @return 视频文件的下载URL
     */
    public String url() {
        return url;
    }

    /**
     * 设置视频文件的下载URL
     *
     * @param url 视频文件的下载URL
     * @return 当前对象
     */
    public AvUpload2 url(String url) {
        this.url = url;
        return this;
    }

    /**
     * 将AvUpload2转换为AvUpload
     *
     * @return AvUpload对象
     */
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

    @Override
    public String relativeFileName() {
        return fileNameWithPath(false);
    }
}
