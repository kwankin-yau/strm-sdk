package com.lucendar.gnss.sdk.strm;

import java.util.StringJoiner;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.lucendar.gnss.sdk.GnssConsts;
import com.lucendar.strm.common.strm.AudioConfig;
import com.lucendar.strm.common.strm.OpenStrmReq;
import com.lucendar.strm.common.strm.ServerHint;

/**
 * 打开实时音视频请求
 */
public class GnssOpenLiveStrmReq implements GnssOpenStrmReq {

    /**
     * 数据类型：音视频
     */
    public static final byte DATA_TYPE__AV = 0;

    /**
     * 数据类型：视频
     */
    public static final byte DATA_TYPE__VIDEO = 1;

    /**
     * 数据类型：对讲
     */
    public static final byte DATA_TYPE__TALK = 2;

    /**
     * 数据类型：监听
     */
    public static final byte DATA_TYPE__LISTEN = 3;

    /**
     * 码流：主码流
     */
    public static final byte CODE_STREAM__PRIMARY = 0;

    /**
     * 码流：子码流
     */
    public static final byte CODE_STREAM__SUB = 1;

    /**
     * 推流时使用的通讯协议: TCP
     */
    public static final int TERM_PROTO__TCP = 0;

    /**
     * 推流时使用的通讯协议: UDP
     */
    public static final int TERM_PROTO__UDP = 1;

    @Nullable
    private String reqId;

    private boolean async = true;
    private String appId = GnssConsts.DEFAULT_APP_ID;
    private String simNo;
    private byte channel;
    private Byte dataType;
    private byte codeStream;
    private int proto;
    private String subProto;
    private byte connIdx;
    private ServerHint strmServerHint;
    private int termProto;
    private boolean exclusive;
    private boolean saveOnServer;

    @Nullable
    private Boolean detectMediaTyp;
    private Integer keepInterval;
    private AudioConfig inputAudioCfg;
    private AudioConfig audioCfg;
    private OpenStrmReq.RtspSource rtspSrc;
    private String timedToken;
    private Integer trace;

    @Nullable
    private String scheme;

    @Nullable
    private Boolean dontSendCloseIfInterrupt;

    /**
     * 取流请求ID。此方法由服务内部使用，客户端不使用此属性。
     *
     * @return 流请求ID。
     */
    @Nullable
    @Override
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置流请求ID。此方法由服务内部使用。
     *
     * @param reqId 流请求ID
     */
    public void setReqId(@Nullable String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取是否异步请求。异步请求时，服务端将在进行必要的处理后返回请求ID，而不是等到终端开始推流才返回。
     *
     * @return 是否异步请求
     */
    @Override
    public boolean isAsync() {
        return async;
    }

    /**
     * 设置是否异步请求。异步请求时，服务端将在进行必要的处理后返回请求ID，而不是等到终端开始推流才返回。
     *
     * @param async 是否异步请求
     */
    public void setAsync(boolean async) {
        this.async = async;
    }

    /**
     * 取是否实时音视频请求。
     *
     * @return 是否实时音视频请求。为 `false` 时表示远程回放。
     */
    @Override
    public boolean isLiveReq() {
        return true;
    }

    /**
     * 取App ID
     *
     * @return App ID
     */
    @Override
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 App ID
     *
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
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取通道号。参见JT/T 1078标准定义的车载视频逻辑通道号定义表。对讲时，可以不指定通道号。其他情况，通道号为必填。
     *
     * @return 通道号
     */
    @Override
    public byte getChannel() {
        return channel;
    }

    /**
     * 设置通道号。
     *
     * @param channel 通道号。参见JT/T 1078标准定义的车载视频逻辑通道号定义表。对讲时，可以不指定通道号。其他情况，通道号为必填。
     */
    @Override
    public void setChannel(byte channel) {
        this.channel = channel;
    }

    /**
     * 取数据类型。
     *
     * @return 数据类型。为 DATA_TYPE__xxx 系列常量之一
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     * 设置数据类型。
     *
     * @param dataType 数据类型。为 DATA_TYPE__xxx 系列常量之一
     */
    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    /**
     * 取数据类型, 默认值为 0
     * @return 数据类型
     */
    public byte dataTypeDef() {
        if (dataType == null)
            return 0;
        else
            return dataType;
    }

    /**
     * 取码流类型
     *
     * @return 码流类型。为 CODE_STREAM__xxx 系列常量之一。
     */
    public byte getCodeStream() {
        return codeStream;
    }

    /**
     * 设置码流类型。
     *
     * @param codeStream 码流类型。为 CODE_STREAM__xxx 系列常量之一。
     */
    public void setCodeStream(byte codeStream) {
        this.codeStream = codeStream;
    }

    @Override
    public byte getCodeStrm() {
        return codeStream;
    }

    /**
     * 取请求的客户端协议类型
     *
     * @return 请求的客户端协议类型，为 StreamingApi.STRM_FORMAT__xxx 系列常量之一
     */
    @Override
    public int getProto() {
        return proto;
    }

    /**
     * 设置请求的客户端协议类型
     *
     * @param proto 请求的客户端协议类型，为 StreamingApi.STRM_FORMAT__xxx 系列常量之一
     */
    public void setProto(int proto) {
        this.proto = proto;
    }

    /**
     * 取子协议类型
     *
     * @return 子协议类型，为 StreamingApi.STRM_SUB_FORMAT__xxx 系列常量之一
     */
    @Override
    public String getSubProto() {
        return subProto;
    }

    /**
     * 设置子协议类型
     *
     * @param subProto 子协议类型，为 StreamingApi.STRM_SUB_FORMAT__xxx 系列常量之一
     */
    public void setSubProto(String subProto) {
        this.subProto = subProto;
    }

    @Override
    public byte getConnIdx() {
        return connIdx;
    }

    /**
     * 设置连接索引
     * @param connIdx 连接索引
     */
    public void setConnIdx(byte connIdx) {
        this.connIdx = connIdx;
    }

    @Override
    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    /**
     * 设置流媒体服务器提示
     * @param strmServerHint 流媒体服务器提示
     */
    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    /**
     * 取推流时使用的通讯协议
     * @return 推流时使用的通讯协议
     * @deprecated 
     */
    @Deprecated
    public int getTermProto() {
        return termProto;
    }

    /**
     * 设置推流时使用的通讯协议
     * @param termProto 推流时使用的通讯协议
     * @deprecated 
     */
    @Deprecated
    public void setTermProto(int termProto) {
        this.termProto = termProto;
    }

    @Override
    public int liveDataType() {
        return dataType != null ? dataType : 0;
    }

    @Override
    public int replayMediaType() {
        return 0;
    }

    @Override
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * 设置是否独占打开方式
     * @param exclusive 是否独占打开方式
     */
    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * 取播放时是否同时存储在服务端的本地媒体存储目录
     *
     * @return 播放时是否同时存储在服务端的本地媒体存储目录
     */
    @Override
    public boolean isSaveOnServer() {
        return saveOnServer;
    }

    /**
     * 设置播放时是否同时存储在服务端的本地媒体存储目录
     * @param saveOnServer 播放时是否同时存储在服务端的本地媒体存储目录
     */
    public void setSaveOnServer(boolean saveOnServer) {
        this.saveOnServer = saveOnServer;
    }

    @Override
    @Deprecated
    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    /**
     * 设置是否执行媒体类型检测
     * @param detectMediaTyp 是否执行媒体类型检测
     * @deprecated 已废除，服务端总是执行媒体类型检测
     */
    @Deprecated
    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    @Override
    public Integer getKeepInterval() {
        return keepInterval;
    }

    /**
     * 设置保持间隔, 单位为秒
     * @param keepInterval 保持间隔
     */
    public void setKeepInterval(Integer keepInterval) {
        this.keepInterval = keepInterval;
    }


    /**
     * 取RTSP源。
     * @return RTSP源
     */
    @Override
    public OpenStrmReq.RtspSource getRtspSrc() {
        return rtspSrc;
    }

    /**
     * 设置RTSP源。采用RTSP源进行播放。打开JT/T 1078协议终端时，不需要指定本属性。
     * @param rtspSrc RTSP源
     */
    public void setRtspSrc(OpenStrmReq.RtspSource rtspSrc) {
        this.rtspSrc = rtspSrc;
    }

    @Override
    public AudioConfig getInputAudioCfg() {
        return inputAudioCfg;
    }

    /**
     * 设置输入音频配置
     * @param inputAudioCfg 输入音频配置
     */
    public void setInputAudioCfg(AudioConfig inputAudioCfg) {
        this.inputAudioCfg = inputAudioCfg;
    }

    @Override
    public AudioConfig getAudioCfg() {
        return audioCfg;
    }

    /**
     * 设置输出音频配置
     * @param audioCfg 输出音频配置
     */
    public void setAudioCfg(AudioConfig audioCfg) {
        this.audioCfg = audioCfg;
    }

    @Override
    public String getTimedToken() {
        return timedToken;
    }

    /**
     * 设置时效令牌
     * @param timedToken 时效令牌
     */
    public void setTimedToken(String timedToken) {
        this.timedToken = timedToken;
    }

    /**
     * 取跟踪模式
     * @return 跟踪模式。为 GnssOpenStrmReq.TRACE_MODE__xxx 系列常量之一
     */
    @Override
    public Integer getTrace() {
        return trace;
    }

    /**
     * 设置跟踪模式。
     * @param trace 跟踪模式。为 GnssOpenStrmReq.TRACE_MODE__xxx 系列常量之一
     */
    public void setTrace(Integer trace) {
        this.trace = trace;
    }

    @Override
    public String getScheme() {
        return scheme;
    }

    /**
     * 设置媒体播放URL的协议
     * @param scheme 媒体播放URL的协议
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public Boolean getDontSendCloseIfInterrupt() {
        return dontSendCloseIfInterrupt;
    }

    /**
     * 设置是否禁止在流中断时发送流关闭命令到终端
     * @param dontSendCloseIfInterrupt 是否禁止在流中断时发送流关闭命令到终端
     */
    public void setDontSendCloseIfInterrupt(Boolean dontSendCloseIfInterrupt) {
        this.dontSendCloseIfInterrupt = dontSendCloseIfInterrupt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssOpenLiveStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("async=" + async)
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("channel=" + channel)
                .add("dataType=" + dataType)
                .add("codeStream=" + codeStream)
                .add("proto=" + proto)
                .add("subProto='" + subProto + "'")
                .add("connIdx=" + connIdx)
                .add("strmServerHint=" + strmServerHint)
                .add("termProto=" + termProto)
                .add("exclusive=" + exclusive)
                .add("saveOnServer=" + saveOnServer)
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
