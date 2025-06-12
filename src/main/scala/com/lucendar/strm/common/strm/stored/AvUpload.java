/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.types.RelativeFileNameProvider;
import com.lucendar.strm.common.utils.StrmUtils;

/**
 * 本类用于表示终端的远程录像上传请求以及这个上传的状态。与 `AvUpload2` 用于内部存储不同，本类用于客户端请求和返回信息给客户端（即用于与客户端
 * 相关的接口中）。
 * <p>
 * 注: 本类的时间属性的格式都是 `yyyy-MM-dd HH:mm:ss`，时区恒为北京时区
 */
public class AvUpload extends TermStoredAvItem implements Cloneable, RelativeFileNameProvider {

    /**
     * 远程录像上传的状态：已请求、已收到请求
     */
    public static final int STATE__REQUESTED = 1;

    /**
     * 远程录像上传的状态：终端已经应答
     */
    public static final int STATE__ACK = 2;

    /**
     * 远程录像上传的状态：上传中
     */
    public static final int STATE__UPLOADING = 3;

    /**
     * 远程录像上传的状态：已经上传完成
     */
    public static final int STATE__UPLOADED = 4;

    /**
     * 远程录像上传的状态：上传失败
     */
    public static final int STATE__FAILED = 5;

    /**
     * 远程录像上传的状态：已取消
     */
    public static final int STATE__CANCELED = 6;

    /**
     * 远程录像上传的状态：超时
     */
    public static final int STATE__TIMEOUT = 7;

    /**
     * 远程录像上传的状态：已经暂停
     */
    public static final int STATE__PAUSED = 8;

    /**
     * 媒体类型：音视频
     */
    public static final int MEDIA_TYP__AV = TermStoredAvItem.MEDIA_TYP__AV;

    /**
     * 媒体类型：音频
     */
    public static final int MEDIA_TYP__AUDIO = TermStoredAvItem.MEDIA_TYP__AUDIO;

    /**
     * 媒体类型：视频
     */
    public static final int MEDIA_TYP__VIDEO = TermStoredAvItem.MEDIA_TYP__VIDEO;

    /**
     * 码流类型：主码流
     */
    public static final int CODE_STRM__PRIMARY = TermStoredAvItem.CODE_STRM__PRIMARY;

    /**
     * 码流类型：子码流
     */
    public static final int CODE_STRM__SUB = TermStoredAvItem.CODE_STRM__SUB;

    /**
     * 存储位置类型：主存储
     */
    public static final int STG_TYP___PRIMARY = TermStoredAvItem.STG_TYP___PRIMARY;

    /**
     * 存储位置类型：灾备存储
     */
    public static final int STG_TYP___SECONDARY = TermStoredAvItem.STG_TYP___SECONDARY;

    /**
     * 返回给定的上传状态 `st` 是否一个终结状态（已经完成或已取消，或已经发生错误失败等）
     *
     * @param st 上传状态代码
     * @return 是否一个终结状态（已经完成或已取消，或已经发生错误失败等）
     */
    public static boolean isEndingState(int st) {
        return st > 3 && st != STATE__PAUSED;
    }

    /**
     * 返回给定的上传状态 `st` 是否一个已经应答或已终结状态（已经完成或已取消，或已经发生错误失败等）
     *
     * @param st 上传状态代码
     * @return 是否一个已经应答或已终结状态（已经完成或已取消，或已经发生错误失败等）
     */
    public static boolean isAckOrEndingState(int st) {
        return st == STATE__ACK || isEndingState(st);
    }

    private String reqId;
    private String reqTm;
    private int st;
    private String appId;
    private String path;
    private String fileName;
    private String uploadTm;
    private String url;

    /**
     * 取请求ID
     *
     * @return 请求ID
     */
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
     * 取请求时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 请求时间
     */
    public String getReqTm() {
        return reqTm;
    }

    /**
     * 设置请求时间
     *
     * @param reqTm 请求时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取上传状态代码，为 STATE__ 系列常量之一
     * @return 上传状态代码
     */
    public int getSt() {
        return st;
    }

    /**
     * 设置上传状态代码
     * @param st 上传状态代码，为 STATE__ 系列常量之一
     */
    public void setSt(int st) {
        this.st = st;
    }

    /**
     * 取 AppId
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppId
     * @param appId AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 返回是否处于终结状态（已经完成或已取消，或已经发生错误失败等）
     *
     * @return 是否处于终结状态（已经完成或已取消，或已经发生错误失败等）
     * @deprecated  Use TermStoredAvItem.endingState() instead
     */
    @Deprecated
    public boolean endingState() {
        return isEndingState(st);
    }

    /**
     * 返回是否处于已应答或已终结状态（已经完成或已取消，或已经发生错误失败等）
     * @return 是否处于已应答或已终结状态（已经完成或已取消，或已经发生错误失败等）
     * @deprecated  Use TermStoredAvItem.ackOrEndingState() instead
     */
    @Deprecated
    public boolean ackOrEndingState() {
        return isAckOrEndingState(st);
    }

    /**
     * 将给定的 HEX格式的 `almState` 转换成 long 值，如 给定的 `almState` 为 null，则返回 0
     *
     * @param almState HEX格式的报警状态字符串
     * @return `almState`的长整数表示
     * @deprecated Use TermStoredAvItem.almStateOf() instead
     */
    @Deprecated
    public static long almStateOf(String almState) {
        return TermStoredAvItem.almStateOf(almState);
    }

    /**
     * 将给定的 HEX格式的 `almState` 转换成 long 值后取低32位（即808报警位），如 给定的 `almState` 为 null，则返回 0
     *
     * @param almState HEX格式的报警状态字符串
     * @return `almState` 属性的低32位整型表示
     * @deprecated Use TermStoredAvItem.alm808Of() instead
     */
    @Deprecated
    public static int alm808Of(String almState) {
        return TermStoredAvItem.alm808Of(almState);
    }


    /**
     * 将给定的 HEX格式的 `almState` 转换成 long 值后取高32位（即1078报警位），如 给定的 `almState` 为 null，则返回 0
     *
     * @param almState HEX格式的报警状态字符串
     * @return `almState` 属性的高32位整型表示
     * @deprecated Use TermStoredAvItem.alm1078Of() instead
     */
    @Deprecated
    public static int alm1078Of(String almState) {
        return TermStoredAvItem.alm1078Of(almState);
    }

    /**
     * 取文件的所在路径。该路径采用 Linux 的路径分隔符 (`/`)
     *
     * @return 文件的所在路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件的所在路径
     * @param path 文件的所在路径。该路径采用 Linux 的路径分隔符 (`/`)
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取文件名
     *
     * @return 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     * 将本记录的文件名和文件路径拼接成一个带路径的文件名（并不是可直接访问的全文件名）
     *
     * @param withLeadingForwardSlash 是否需要文件路径前面包含 `/`
     * @return 带路径的文件名
     */
    public String fileNameWithPath(boolean withLeadingForwardSlash) {
        return StrmUtils.calcFileNameWithPath(path, fileName, withLeadingForwardSlash);
    }

    /**
     * 将文件名和文件路径拼接成一个带路径的文件名（并不是可直接访问的全文件名），文件路径前面包含 `/`
     *
     * @return 带路径的文件名
     */
    public String fileNameWithPath() {
        return fileNameWithPath(true);
    }

    /**
     * 取上传时间
     *
     * @return 上传时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getUploadTm() {
        return uploadTm;
    }

    /**
     * 设置上传时间
     * @param uploadTm 上传时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    /**
     * 文件的下载 URL。仅当 st == AvUpload2#STATE__UPLOADED 时有效。
     * 注意，这个 下载 URL 是有时效的：
     * 1. 查询获得的 url 在两小时后失效
     * 2. 两次查询同一个 AvUpload，返回的 url 可能不一样
     *
     * @return 文件的下载 URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件的下载 URL
     * @param url 文件的下载 URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 取文件的下载 URL
     * @return 文件的下载 URL
     */
    public String url() {
        return url;
    }

    /**
     * 设置文件的下载 URL
     * @param value 文件的下载 URL
     * @return 本对象自身
     */
    public AvUpload url(String value) {
        this.url = value;
        return this;
    }

    /**
     * 取 AppId
     * @return AppId，如果 `appId` 属性为 null ，则返回 {@link StreamingApi#DEFAULT_APP_ID}
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 从 AvUpload2 对象中复制属性
     *
     * @param avUpload2 源 AvUpload2 对象
     */
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
        return (AvUpload) super.clone();
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

    @Override
    public String relativeFileName() {
        return fileNameWithPath(false);
    }
}
