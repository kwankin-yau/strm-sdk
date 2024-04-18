/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.StreamingApi;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.StringJoiner;

/**
 * 上传终端远程录像请求
 */
public class AvUploadReq {

    @NonNull
    private String appId;

    @NonNull
    private String simNo;
    private int channel;

    @NonNull
    private String startTime;

    @NonNull
    private String endTime;

    @Nullable
    private String almState;
    private int mediaType;
    private int codeStream;
    private int storageType;
    private long fileSz;

    @Nullable
    private Integer when;

    /**
     * 取 AppId
     *
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppId
     *
     * @param appId AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
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
     * 取通道号
     *
     * @return 通道号
     */
    public int getChannel() {
        return channel;
    }

    /**
     * 设置通道号
     *
     * @param channel 通道号
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * 取录像的开始时间
     *
     * @return 录像的开始时间, yyyy-MM-dd HH:mm:ss 格式，北京时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置录像的开始时间
     *
     * @param startTime 录像的开始时间, yyyy-MM-dd HH:mm:ss 格式，北京时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取录像的结束时间
     *
     * @return 录像的结束时间, yyyy-MM-dd HH:mm:ss 格式，北京时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置录像的结束时间
     *
     * @param endTime 录像的结束时间, yyyy-MM-dd HH:mm:ss 格式，北京时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取报警状态，为查询终端远程录像时返回的录像的报警状态。请求上传时，要通过本属性带给服务端。
     *
     * @return 报警状态。为64位报警标志，以16进制值表示，如：`A0`表示十进制的160，二进制的`10100000`。
     * 位0-31定义请参考JT/T 808-2011表18报警标志位定义；位32-63定义请参考JT/T 1078-2016表14视频报警报警标志位定义。
     */
    public String getAlmState() {
        return almState;
    }

    /**
     * 设置报警状态，为查询终端远程录像时返回的录像的报警状态。请求上传时，要通过本属性带给服务端。
     *
     * @param almState 报警状态。为64位报警标志，以16进制值表示，如：`A0`表示十进制的160，二进制的`10100000`。
     *                 位0-31定义请参考JT/T 808-2011表18报警标志位定义；位32-63定义请参考JT/T 1078-2016表14视频报警报警标志位定义。
     */
    public void setAlmState(String almState) {
        this.almState = almState;
    }

    /**
     * 取音视频资源类型
     *
     * @return 音视频资源类型，为 AvUpload.MEDIA_TYP__ 系列常量之一
     */
    public int getMediaType() {
        return mediaType;
    }

    /**
     * 设置音视频资源类型
     *
     * @param mediaType 音视频资源类型，为 AvUpload.MEDIA_TYP__ 系列常量之一
     */
    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 取码流类型。
     *
     * @return 码流类型。为 AvUpload.CODE_STRM__ 系列常量之一
     */
    public int getCodeStream() {
        return codeStream;
    }

    /**
     * 设置码流类型。
     *
     * @param codeStream 码流类型。为 AvUpload.CODE_STRM__ 系列常量之一
     */
    public void setCodeStream(int codeStream) {
        this.codeStream = codeStream;
    }

    /**
     * 取存储类型
     *
     * @return 存储类型。为 AvUpload.STG_TYP__ 系列常量之一
     */
    public int getStorageType() {
        return storageType;
    }

    /**
     * 设置存储类型。
     *
     * @param storageType 存储类型。为 AvUpload.STG_TYP__ 系列常量之一
     */
    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    /**
     * 取文件大小，字节数
     *
     * @return 文件大小，字节数
     */
    public long getFileSz() {
        return fileSz;
    }

    /**
     * 设置文件大小，字节数
     *
     * @param fileSz 文件大小，字节数
     */
    public void setFileSz(long fileSz) {
        this.fileSz = fileSz;
    }

    /**
     * 取请求录像上传时的上传时机标志
     *
     * @return 请求录像上传时的上传时机标志
     */
    public Integer getWhen() {
        return when;
    }

    /**
     * 设置请求录像上传时的上传时机标志。参见：setWhen(boolean wifi, boolean lan, boolean mobile)。不设置时，为 7，即立即上传。
     *
     * @param when 请求录像上传时的上传时机标志
     */
    public void setWhen(Integer when) {
        this.when = when;
    }

    /**
     * 设置请求录像上传时的上传时机标志。
     *
     * @param wifi   是否当 wifi 可用时上传
     * @param lan    是否当有线网络可用时上传
     * @param mobile 是否当移动网络可用时上传
     */
    public void setWhen(boolean wifi, boolean lan, boolean mobile) {
        int r = 0;
        if (wifi)
            r |= 1;

        if (lan)
            r |= (1 << 1);

        if (mobile)
            r |= (1 << 2);

        this.when = r;
    }

    /**
     * 取 AppId
     *
     * @return AppId，如果 `appId` 属性为 null ，则返回 {@link StreamingApi#DEFAULT_APP_ID}
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 取请求录像上传时的上传时机标志
     *
     * @return 请求录像上传时的上传时机标志，如果为 null，则返回 7 (所有网络情况下上传)
     */
    public int whenDef() {
        if (when != null)
            return when;
        else
            return 7;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadReq.class.getSimpleName() + "[", "]")
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
                .add("when=" + when)
                .toString();
    }
}
