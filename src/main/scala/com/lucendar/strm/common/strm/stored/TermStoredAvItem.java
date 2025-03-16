package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

/**
 * 终端磁盘或SD卡中存储的媒体文件信息
 */
public class TermStoredAvItem implements Cloneable {

    /**
     * 媒体类型：音视频
     */
    public static final int MEDIA_TYP__AV = 0;

    /**
     * 媒体类型：音频
     */
    public static final int MEDIA_TYP__AUDIO = 1;

    /**
     * 媒体类型：视频
     */
    public static final int MEDIA_TYP__VIDEO = 2;

    /**
     * 码流类型：主码流
     */
    public static final int CODE_STRM__PRIMARY = 1;

    /**
     * 码流类型：子码流
     */
    public static final int CODE_STRM__SUB = 2;

    /**
     * 存储位置类型：主存储
     */
    public static final int STG_TYP___PRIMARY = 1;

    /**
     * 存储位置类型：灾备存储
     */
    public static final int STG_TYP___SECONDARY = 2;

    /**
     * 终端识别号
     */
    protected String simNo;

    /**
     * 通道号
     */
    protected int channel;

    /**
     * 录像的开始时间
     */
    protected String startTime;

    /**
     * 录像的结束时间
     */
    protected String endTime;

    /**
     * 报警状态
     */
    protected String almState;

    /** 
     * 音视频资源类型, 为 MEDIA_TYP__ 系列常量之一
     */
    protected int mediaType;

    /**
     * 码流类型, 为 CODE_STRM__ 系列常量之一
     */
    protected int codeStream;

    /**
     * 存储类型, 为 STG_TYP__ 系列常量之一
     */
    protected int storageType;

    /**
     * 文件大小
     */
    protected Long fileSz;

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
     * 取开始时间
     *
     * @return 开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取结束时间
     *
     * @return 结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取报警状态。
     *
     * @return 报警状态。为64位报警标志，以16进制值表示，如：`A0`表示十进制的160，二进制的`10100000`。
     * 位0-31定义请参考JT/T 808-2011表18报警标志位定义；位32-63定义请参考JT/T 1078-2016表14视频报警报警标志位定义。
     */
    public String getAlmState() {
        return almState;
    }

    /**
     * 设置报警状态
     *
     * @param almState 报警状态。64位报警标志，以16进制值表示，如：`A0`表示十进制的160，二进制的`10100000`。
     *                 位0-31定义请参考JT/T 808-2011表18报警标志位定义；位32-63定义请参考JT/T 1078-2016表14视频报警报警标志位定义。
     */
    public void setAlmState(String almState) {
        this.almState = almState;
    }

    /**
     * 取音视频资源类型
     *
     * @return 音视频资源类型，为 MEDIA_TYP__ 系列常量之一
     */
    public int getMediaType() {
        return mediaType;
    }

    /**
     * 设置音视频资源类型，为 MEDIA_TYP__ 系列常量之一
     *
     * @param mediaType 音视频资源类型，为 MEDIA_TYP__ 系列常量之一
     */
    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 取码流类型。
     *
     * @return 码流类型。为 CODE_STRM__ 系列常量之一
     */
    public int getCodeStream() {
        return codeStream;
    }

    /**
     * 设置码流类型。
     *
     * @param codeStream 码流类型。为 CODE_STRM__ 系列常量之一
     */
    public void setCodeStream(int codeStream) {
        this.codeStream = codeStream;
    }

    /**
     * 取存储类型
     *
     * @return 存储类型。为 STG_TYP__ 系列常量之一
     */
    public int getStorageType() {
        return storageType;
    }

    /**
     * 设置存储类型。
     *
     * @param storageType 存储类型。为 STG_TYP__ 系列常量之一
     */
    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    /**
     * 取文件大小，字节数
     *
     * @return 文件大小，字节数
     */
    public Long getFileSz() {
        return fileSz;
    }

    /**
     * 设置文件大小，字节数
     *
     * @param fileSz 文件大小，字节数
     */
    public void setFileSz(Long fileSz) {
        this.fileSz = fileSz;
    }


    /**
     * 将给定的 HEX格式的 `almState` 转换成 long 值，如 给定的 `almState` 为 null，则返回 0
     *
     * @param almState HEX格式的报警状态字符串
     * @return `almState`的长整数表示
     */
    public static long almStateOf(String almState) {
        if (almState != null)
            return Long.parseLong(almState, 16);
        else
            return 0L;
    }

    /**
     * 将自身的 `almState` 属性转换成长整型表示
     *
     * @return `almState` 属性的长整型表示
     */
    public long almStateToLong() {
        return almStateOf(almState);
    }

    /**
     * 将给定的 HEX格式的 `almState` 转换成 long 值后取低32位（即808报警位），如 给定的 `almState` 为 null，则返回 0
     *
     * @param almState HEX格式的报警状态字符串
     * @return `almState` 属性的低32位整型表示
     */
    public static int alm808Of(String almState) {
        if (almState != null) {
            long l = Long.parseLong(almState, 16);
            return (int) l;
        } else
            return 0;
    }

    /**
     * 将自身的 `almState` 属性转换成长整型后取低32位整数，即808报警状态位的整型表示
     *
     * @return `almState` 属性的低32位整型表示，808报警状态位
     */
    public int alm808() {
        return alm808Of(almState);
    }

    /**
     * 将给定的 HEX格式的 `almState` 转换成 long 值后取高32位（即1078报警位），如 给定的 `almState` 为 null，则返回 0
     *
     * @param almState HEX格式的报警状态字符串
     * @return `almState` 属性的高32位整型表示
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
     * 将自身的 `almState` 属性转换成长整型后取高32位整数，即1078报警状态位的整型表示
     *
     * @return `almState` 属性的高32位整型表示，1078报警状态位
     */
    public int alm1078() {
        return alm1078Of(almState);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", TermStoredAvItem.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("channel=" + channel)
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("almState='" + almState + "'")
                .add("mediaType=" + mediaType)
                .add("codeStream=" + codeStream)
                .add("storageType=" + storageType)
                .add("fileSz=" + fileSz)
                .toString();
    }

    @Override
    public TermStoredAvItem clone() {
        try {
            TermStoredAvItem clone = (TermStoredAvItem) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
