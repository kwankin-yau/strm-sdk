package com.lucendar.gnss.sdk.strm;

import com.lucendar.common.utils.DateTimeUtils;
import com.lucendar.strm.common.strm.AudioConfig;
import com.lucendar.strm.common.strm.OpenStrmReq;
import com.lucendar.strm.common.strm.ServerHint;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.StringJoiner;

/**
 * 打开远程录像回放请求
 */
public class GnssOpenReplayStrmReq implements GnssOpenStrmReq {

    /**
     * 媒体类型：音视频
     */
    public static final int MEDIA_TYPE__AV = 0;

    /**
     * 媒体类型：音频
     */
    public static final int MEDIA_TYPE__AUDIO = 1;


    /**
     * 媒体类型：视频
     */
    public static final int MEDIA_TYPE__VIDEO = 2;


    /**
     * 媒体类型：音频或视频
     */
    public static final int MEDIA_TYPE__A_OR_V = 3;

    /**
     * 码流：全部
     */
    public static final byte CODE_STREAM__ALL = 0;
    /**
     * 码流：主码流
     */
    public static final byte CODE_STREAM__PRIMARY = 1;
    /**
     * 码流：子码流
     */
    public static final byte CODE_STREAM__SUB = 2;

    /**
     * 存储类型：全部
     */
    public static final byte STORAGE_TYPE__ALL = 0;

    /**
     * 存储类型：主存储器
     */
    public static final byte STORAGE_TYPE__PRIMARY = 1;

    /**
     * 存储类型：灾备存储器
     */
    public static final byte STORAGE_TYPE__SECONDARY = 2;

    /**
     * 回放方式：正常回放
     */
    public static final byte MODE__NORMAL = 0;

    /**
     * 回放方式：快进
     */
    public static final byte MODE__FAST_FORWARD = 1;

    /**
     * 回放方式：关键帧快退
     */
    public static final byte MODE__KEY_FRAME_BACKWARD = 2;

    /**
     * 回放方式：关键帧播放
     */
    public static final byte MODE__KEY_FRAME_PLAY = 3;

    /**
     * 回放方式：单帧上传
     */
    public static final byte MODE__UPLOAD_SINGLE_FRAME = 3;

    /**
     * 快进或快退的倍数：无效/不使用
     */
    public static final int FACTOR__INVALID = 0;

    /**
     * 快进或快退的倍数：原速
     */
    public static final int FACTOR__1X = 1;

    /**
     * 快进或快退的倍数：2倍速
     */
    public static final int FACTOR__2X = 2;

    /**
     * 快进或快退的倍数：4倍速
     */
    public static final int FACTOR__4X = 3;

    /**
     * 快进或快退的倍数：8倍速
     */
    public static final int FACTOR__8X = 4;

    /**
     * 快进或快退的倍数：16倍速
     */
    public static final int FACTOR__16X = 5;

    private String reqId;
    private boolean async = true;
    private String appId;
    private String simNo;
    private byte channel;
    private byte mediaType;
    private byte codeStream;
    private byte storageType;
    private byte mode;
    private byte factor;
    private String startTime;
    private String endTime;
    private int proto;
    private String subProto;
    private byte connIdx;
    private ServerHint strmServerHint;
    private Boolean detectMediaTyp;
    private Integer keepInterval;
    private AudioConfig inputAudioCfg;
    private AudioConfig audioCfg;
    private OpenStrmReq.RtspSource rtspSrc;
    private String timedToken;
    private Integer trace;
    private String scheme;
    private Boolean dontSendCloseIfInterrupt;

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    @Override
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置终端识别号
     * @param reqId 终端识别号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取是否异步调用
     *
     * @return 是否异步调用
     */
    @Override
    public boolean isAsync() {
        return async;
    }

    /**
     * 设置是否异步调用
     * @param async 是否异步调用
     */
    public void setAsync(boolean async) {
        this.async = async;
    }

    /**
     * 取是否实时音视频播放请求
     * @return 是否实时音视频播放请求。false 表回放请求
     */
    @Override
    public boolean isLiveReq() {
        return false;
    }

    /**
     * 取 App ID
     * @return App ID
     */
    @Override
    public String getAppId() {
        return appId;
    }

    /**
     * 设置App ID
     * @param appId App ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    @Override
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取逻辑通道号
     * @return 逻辑通道号
     */
    @Override
    public byte getChannel() {
        return channel;
    }

    /**
     * 设置逻辑通道号
     * @param channel 逻辑通道号
     */
    @Override
    public void setChannel(byte channel) {
        this.channel = channel;
    }

    /**
     * 取音视频类型，为 MEDIA_TYPE__xxx 常量之一
     * @return 音视频类型，为 MEDIA_TYPE__xxx 常量之一
     */
    public byte getMediaType() {
        return mediaType;
    }

    /**
     * 设置音视频类型，为 MEDIA_TYPE__xxx 常量之一
     * @param mediaType 音视频类型，为 MEDIA_TYPE__xxx 常量之一
     */
    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 取码流，为 CODE_STREAM__xxx 常量之一
     * @return 码流，为 CODE_STREAM__xxx 常量之一
     */
    public byte getCodeStream() {
        return codeStream;
    }

    /**
     * 设置码流，为 CODE_STREAM__xxx 常量之一
     * @param codeStream 码流，为 CODE_STREAM__xxx 常量之一
     */
    public void setCodeStream(byte codeStream) {
        this.codeStream = codeStream;
    }

    /**
     * 取码流，为 CODE_STREAM__xxx 常量之一
     * @return 码流，为 CODE_STREAM__xxx 常量之一
     */
    @Override
    public byte getCodeStrm() {
        return codeStream;
    }

    /**
     * 取存储类型，为 STORAGE_TYPE__xxx 常量之一
     * @return 存储类型，为 STORAGE_TYPE__xxx 常量之一
     */
    public byte getStorageType() {
        return storageType;
    }

    /**
     * 设置存储类型，为 STORAGE_TYPE__xxx 常量之一
     * @param storageType 存储类型，为 STORAGE_TYPE__xxx 常量之一
     */
    public void setStorageType(byte storageType) {
        this.storageType = storageType;
    }

    /**
     * 取回放方式，为 MODE__xxx 常量之一
     * @return 回放方式，为 MODE__xxx 常量之一
     */
    public byte getMode() {
        return mode;
    }

    /**
     * 设置回放方式，为 MODE__xxx 常量之一
     * @param mode 回放方式，为 MODE__xxx 常量之一
     */
    public void setMode(byte mode) {
        this.mode = mode;
    }

    /**
     * 取快进或快退的速度倍数，为 FACTOR__xxx 常量之一
     * @return 快进或快退的速度倍数，为 FACTOR__xxx 常量之一
     */
    public byte getFactor() {
        return factor;
    }

    /**
     * 设置快进或快退的速度倍数，为 FACTOR__xxx 常量之一
     * @param factor 快进或快退的速度倍数，为 FACTOR__xxx 常量之一
     */
    public void setFactor(byte factor) {
        this.factor = factor;
    }

    /**
     * 取录像播放的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     * @return 录像播放的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置录像播放的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     * @param startTime 录像播放的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取录像播放的开始时间，epoch millis
     * @return 录像播放的开始时间，epoch millis
     */
    @Nullable
    public Long startTimeEpoch() {
        if (startTime != null)
            return DateTimeUtils.BeijingConv.stringToMillis(startTime);
        else
            return null;
    }

    /**
     * 取录像播放的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss。null 时表不指定
     * @return 录像播放的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss。null 时表不指定
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置录像播放的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss。null 时表不指定
     * @param endTime 录像播放的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss。null 时表不指定
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取录像播放的结束时间，epoch millis
     * @return 录像播放的结束时间，epoch millis
     */
    @Nullable
    public Long endTimeEpoch() {
        if (endTime != null && !endTime.equals("00-00-00 00:00:00"))
            return DateTimeUtils.BeijingConv.stringToMillis(endTime);
        else
            return null;
    }

    /**
     * 取客户端的播放格式，为 {@link com.lucendar.strm.common.StreamingApi} 的 STRM_FORMAT__xxx 系列常量之一
     * @return 客户端的播放格式
     */
    @Override
    public int getProto() {
        return proto;
    }

    /**
     * 设置客户端的播放格式
     * @param proto 客户端的播放格式
     */
    public void setProto(int proto) {
        this.proto = proto;
    }

    /**
     * 取客户端播放子格式，为 {@link com.lucendar.strm.common.StreamingApi} 的 STRM_SUB_FORMAT__xxx 系列常量之一。目前只用于 HLS 播放格式。
     * 本参数为可选参数。
     * @return 客户端播放子格式
     */
    @Override
    public String getSubProto() {
        return subProto;
    }

    /**
     * 设置客户端播放子格式
     * @param subProto 客户端播放子格式
     */
    public void setSubProto(String subProto) {
        this.subProto = subProto;
    }

    @Deprecated
    @Override
    public byte getConnIdx() {
        return connIdx;
    }

    @Deprecated
    public void setConnIdx(byte connIdx) {
        this.connIdx = connIdx;
    }

    @Override
    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public int liveDataType() {
        return 0;
    }

    @Override
    public int replayMediaType() {
        return mediaType;
    }

    @Override
    public boolean isExclusive() {
        return true;
    }

    @Override
    public boolean isSaveOnServer() {
        return false;
    }

    @Override
    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    @Override
    public Integer getKeepInterval() {
        return keepInterval;
    }

    @Override
    public AudioConfig getInputAudioCfg() {
        return inputAudioCfg;
    }

    public void setInputAudioCfg(AudioConfig inputAudioCfg) {
        this.inputAudioCfg = inputAudioCfg;
    }

    @Override
    public AudioConfig getAudioCfg() {
        return audioCfg;
    }

    public void setAudioCfg(AudioConfig audioCfg) {
        this.audioCfg = audioCfg;
    }

    @Override
    public OpenStrmReq.RtspSource getRtspSrc() {
        return rtspSrc;
    }

    public void setKeepInterval(Integer keepInterval) {
        this.keepInterval = keepInterval;
    }

    public void setRtspSrc(OpenStrmReq.RtspSource rtspSrc) {
        this.rtspSrc = rtspSrc;
    }

    @Override
    public String getTimedToken() {
        return timedToken;
    }

    public void setTimedToken(String timedToken) {
        this.timedToken = timedToken;
    }

    @Override
    public Integer getTrace() {
        return trace;
    }

    public void setTrace(Integer trace) {
        this.trace = trace;
    }

    @Override
    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public Boolean getDontSendCloseIfInterrupt() {
        return dontSendCloseIfInterrupt;
    }

    public void setDontSendCloseIfInterrupt(Boolean dontSendCloseIfInterrupt) {
        this.dontSendCloseIfInterrupt = dontSendCloseIfInterrupt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssOpenReplayStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("async=" + async)
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("channel=" + channel)
                .add("mediaType=" + mediaType)
                .add("codeStream=" + codeStream)
                .add("storageType=" + storageType)
                .add("mode=" + mode)
                .add("factor=" + factor)
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("proto=" + proto)
                .add("subProto='" + subProto + "'")
                .add("connIdx=" + connIdx)
                .add("strmServerHint=" + strmServerHint)
                .add("detectMediaTyp=" + detectMediaTyp)
                .add("keepInterval=" + keepInterval)
                .add("inputAudioCfg=" + inputAudioCfg)
                .add("audioCfg=" + audioCfg)
                .add("rtspSrc=" + rtspSrc)
                .add("timedToken='" + timedToken + "'")
                .add("trace=" + trace)
                .add("scheme='" + scheme + "'")
                .add("dontSendCloseIfInterrupt=" + dontSendCloseIfInterrupt)
                .toString();
    }
}
