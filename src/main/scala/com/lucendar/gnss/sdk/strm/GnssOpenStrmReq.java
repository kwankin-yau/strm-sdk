package com.lucendar.gnss.sdk.strm;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.strm.AudioConfig;
import com.lucendar.strm.common.strm.OpenStrmReq;
import com.lucendar.strm.common.strm.ServerHint;

/**
 * （实时或回放）播放请求抽象
 */
public interface GnssOpenStrmReq {

    /**
     * HTTP FLV 格式
     */
    int FORMAT__HTTP_FLV = StreamingApi.STRM_FORMAT__FLV;

    /**
     * RTMP 格式
     */
    int FORMAT__RTMP = StreamingApi.STRM_FORMAT__RTMP;

    /**
     * HLS 格式
     */
    int FORMAT__HLS = StreamingApi.STRM_FORMAT__HLS;

    /**
     * RTSP 格式
     */
    int FORMAT__RTSP = StreamingApi.STRM_FORMAT__RTSP;

    /**
     * FMP4 子格式
     */
    String SUB_FORMAT__FMP4 = StreamingApi.STRM_SUB_FORMAT__FMP4;

    /**
     * MPEG-TS 子格式
     */
    String SUB_FORMAT__MPEGTS = StreamingApi.STRM_SUB_FORMAT__MPEGTS;

    /**
     * DISABLED mode. DO NOT trace
     */
    int TRACE_MODE__DISABLED = 0;

    /**
     * SIMPLE mode. Trace:
     * - stream state changes (StrmReq.state)
     * - all terminal inbound/outbound message, including
     */
    int TRACE_MODE__SIMPLE = 1;

    /**
     * ADVANCED mode. Trace:
     * - stream state changes (StrmReq.state)
     * - stream media notification (StrmMediaNotif)
     * - all terminal inbound/outbound message, including
     */
    int TRACE_MODE__ADVANCED = 2;

    /**
     * FULL mode. Trace:
     * - stream state changes(StrmReq.state)
     * - stream media notification (StrmMediaNotif)
     * - stream data
     * - all terminal inbound/outbound message, including
     */
    int TRACE_MODE__FULL = 3;

    /**
     * 获取请求ID
     * @return 请求ID
     */
    String getReqId();

    /**
     * 是否异步打开模式
     * @return 是否异步打开模式
     */
    boolean isAsync();

    /**
     * 是否实时播放请求
     * @return 是否实时播放请求， false 表示回放请求
     */
    boolean isLiveReq();

    /**
     * 获取APP ID
     * @return APP ID
     */
    String getAppId();

    /**
     * 获取APP ID, 如果未设置则返回默认的APP ID
     * @return APP ID
     */
    default String appIdDef() {
        String r = getAppId();
        if (r == null)
            return StreamingApi.DEFAULT_APP_ID;
        else
            return r;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    String getSimNo();

    /**
     * 获取通道号
     * @return 通道号
     */
    byte getChannel();
    /**
     * 设置通道号。主要用于对讲时。对讲时可指定 channel = 0。此时媒体代理服务将确定实际的通道号，确定后，通过此方法设置确定后的通道号。
     *
     * @param channel 通道号
     */
    void setChannel(byte channel);

    /**
     * 获取客户端协议类型， 为 FORMAT__xxx 常量之一
     * @return 客户端协议类型
     */
    int getProto();

    /**
     * 获取客户端子协议类型, 为 SUB_FORMAT__xxx 常量之一
     * @return 客户端子协议类型
     */
    String getSubProto();

    /**
     * 获取连接索引
     * @return 连接索引
     */
    byte getConnIdx();

    /**
     * 获取流媒体服务器提示
     * @return 流媒体服务器提示
     */
    ServerHint getStrmServerHint();

    /**
     * 获取是否执行媒体类型检测
     * @return 是否执行媒体类型检测
     * @deprecated 已废除，服务端总是执行媒体类型检测
     */
    @Deprecated
    Boolean getDetectMediaTyp();

    /**
     * 获取请求数据类型, 仅当请求为实时播放请求时有效
     * @return 请求数据类型
     */
    int liveDataType();

    /**
     * 获取回放媒体类型
     * @return 回放媒体类型
     */
    int replayMediaType();

    /**
     * 获取请求的实时数据类型或回放媒体类型
     * @return 请求的实时数据类型或回放媒体类型
     */
    default int liveDataTypeOrReplayMediaType() {
        if (isLiveReq())
            return liveDataType();
        else
            return replayMediaType();
    }

    
    /**
     * 取码流
     * @return 码流
     */
    byte getCodeStrm();


    /**
     * 是否独占打开方式
     * @return 是否独占打开方式
     */
    boolean isExclusive();

    /**
     * 是否在播放时的同时保存视频文件在服务器
     * @return 是否在播放时的同时保存视频文件在服务器
     */
    boolean isSaveOnServer();

    /**
     * 获取保持间隔, 单位为秒
     * @return 保持间隔
     */
    Integer getKeepInterval();

    /**
     * 获取输入音频配置
     * @return 输入音频配置
     */
    AudioConfig getInputAudioCfg();

    /**
     * 获取输出音频配置
     * @return 输出音频配置
     */
    AudioConfig getAudioCfg();

    /**
     * 获取RTSP源
     * @return RTSP源
     */
    OpenStrmReq.RtspSource getRtspSrc();

    /**
     * 获取时效令牌
     * @return 时效令牌
     */
    String getTimedToken();

    /**
     * 获取跟踪模式
     * The trace mode should be applied to this request.
     * Optional. `null` if not specified. Value domain: TRACE_MODE__XXXX constant defined in
     * `com.lucendar.strm.common.strm.OpenStrmReq`.
     *
     * @return trace mode
     */
    Integer getTrace();

    /**
     * 获取跟踪模式, 默认值为 TRACE_MODE__DISABLED
     * @return 跟踪模式
     */
    default int traceDef() {
        Integer v = getTrace();
        if (v != null)
            return v;
        else
            return OpenStrmReq.TRACE_MODE__DISABLED;
    }

    /**
     * 返回当前请求是否要求跟踪
     * @return 是否要求跟踪
     */
    default boolean isTraced() {
        Integer trace = getTrace();
        return trace != null && trace != OpenStrmReq.TRACE_MODE__DISABLED;
    }

    /**
     * 获取媒体播放URL的协议, 如 `http`, `https`, `ws`, `wss`
     * 
     * <pre>
     * The scheme of media playing url. When the `proto` is `FLV` or `HLS`, the scheme of returned url in GNSS
     * `strm/live/open`, `strm/replay/open` API is determined by the value of the `async` parameter:
     * - when `async` is true, return URL with `wss` scheme.
     * - when `async` is false, return URL with `https` scheme.
     *
     * If this logic is not appropriate, application can use this parameter to specify the scheme needed. At present,
     * the following value(case-sensitive) are meaningful:
     * - `http`: supported by FLV, HLS proto
     * - `https`: supported by FLV, HLS proto
     * - `ws`: supported by FLV, HLS proto
     * - `wss`: supported by FLV, HLS proto
     *
     * This is a optional parameter, if supplied, the `scheme` must be supported by the `proto`.
     *</pre>
     * @return 媒体播放URL的协议
     */
    String getScheme();

    /**
     * 是否禁止在流中断时发送流关闭命令到终端
     * @return 是否禁止在流中断时发送流关闭命令到终端
     */
    Boolean getDontSendCloseIfInterrupt();

    /**
     * 获取是否禁止在流中断时发送流关闭命令到终端, 默认值为 false
     * @return 是否禁止在流中断时发送流关闭命令到终端
     */
    default boolean dontSendCloseIfInterruptDef() {
        Boolean v = getDontSendCloseIfInterrupt();
        if (v != null)
            return v;
        else
            return false;
    }

}
