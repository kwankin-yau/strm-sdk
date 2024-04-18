/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.strm.common.strm.stored;

import com.lucendar.common.utils.DateTimeUtils;

import java.time.Instant;
import java.util.StringJoiner;

/**
 * 查询终端远程录像文件请求
 */
public class QryTermSideStoredAvReq {

    private String simNo;
    private String startTime;
    private String endTime;
    private int channel;
    private String almState;
    private int mediaType;
    private int codeStream;
    private int storageType;


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
     * 取录像的开始时间
     *
     * @return 录像的开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置录像的开始时间
     *
     * @param startTime 录像的开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取录像的结束时间
     *
     * @return 录像的结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置录像的结束时间
     *
     * @param endTime 录像的结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取终端通道号
     *
     * @return 终端通道号
     */
    public int getChannel() {
        return channel;
    }

    /**
     * 设置终端通道号
     *
     * @param channel 终端通道号
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * 取64位报警标志，以16进制值表示，如：`A0`表示十进制的160，二进制的`10100000`。
     * 位0-31定义请参考JT/T 808-2011表18报警标志位定义；位32-63定义请参考JT/T 1078-2016表14视频报警报警标志位定义。不指定时，默认为`'0'`
     *
     * @return 64位报警标志
     */
    public String getAlmState() {
        return almState;
    }

    /**
     * 设置64位报警标志，以16进制值表示，如：`A0`表示十进制的160，二进制的`10100000`。
     * 位0-31定义请参考JT/T 808-2011表18报警标志位定义；位32-63定义请参考JT/T 1078-2016表14视频报警报警标志位定义。不指定时，默认为`'0'`
     *
     * @param almState 64位报警标志
     */
    public void setAlmState(String almState) {
        this.almState = almState;
    }

    /**
     * 取音视频资源类型，为 {@link AvUpload} 的 MEDIA_TYP__ 系列常量之一
     *
     * @return 音视频资源类型
     */
    public int getMediaType() {
        return mediaType;
    }

    /**
     * 设置音视频资源类型。不设置时，默认为 0
     *
     * @param mediaType 音视频资源类型，为 {@link AvUpload} 的 MEDIA_TYP__ 系列常量之一
     */
    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 取码流类型，为 {@link AvUpload} 的 CODE_STRM__ 系列常量之一
     *
     * @return 码流类型
     */
    public int getCodeStream() {
        return codeStream;
    }

    /**
     * 设置码流类型
     *
     * @param codeStream 码流类型，为 {@link AvUpload} 的 CODE_STRM__ 系列常量之一
     */
    public void setCodeStream(int codeStream) {
        this.codeStream = codeStream;
    }

    /**
     * 取存储器类型
     *
     * @return 存储器类型，为 {@link AvUpload} 的 STG_TYP__ 系列常量之一
     */
    public int getStorageType() {
        return storageType;
    }

    /**
     * 设置存储器类型
     *
     * @param storageType 存储器类型，为 {@link AvUpload} 的 STG_TYP__ 系列常量之一
     */
    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    /**
     * 将开始时间转换成 epoch millis
     *
     * @return 代表开始时刻的 epoch millis
     */
    public long startTimeMillis() {
        return DateTimeUtils.BeijingConv.stringToMillis(this.startTime);
    }

    /**
     * 将结束时间转换成 epoch millis，如果结束时间未设置，返回当前时间的 epoch millis
     *
     * @return 代表结束时刻的 epoch millis
     */
    public long endTimeMillisDefNow() {
        if (this.endTime == null || this.endTime.isEmpty())
            return Instant.now().toEpochMilli();
        else
            return DateTimeUtils.BeijingConv.stringToMillis(this.endTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryTermSideStoredAvReq.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("channel=" + channel)
                .add("almState='" + almState + "'")
                .add("mediaType=" + mediaType)
                .add("codeStream=" + codeStream)
                .add("storageType=" + storageType)
                .toString();
    }
}
