package com.lucendar.gnss.sdk.strm;

import java.util.StringJoiner;

/**
 * 流媒体请求
 * A database representation of GnssOpenStrmReq.
 */
public class StrmReq implements CompoundStrmReqId {

    /**
     * 流媒体请求类型：实时播放
     */
    public static final int TYP__LIVE = 1;

    /**
     * 流媒体请求类型：回放
     */
    public static final int TYP__REPLAY = 2;

    /**
     * 跟踪模式：禁用
     */
    public static final int TRACE_MODE__DISABLED = GnssOpenStrmReq.TRACE_MODE__DISABLED;

    /**
     * 跟踪模式：简单
     */
    public static final int TRACE_MODE__SIMPLE = GnssOpenStrmReq.TRACE_MODE__SIMPLE;

    /**
     * 跟踪模式：高级
     */
    public static final int TRACE_MODE__ADVANCED = GnssOpenStrmReq.TRACE_MODE__ADVANCED;

    /**
     * 跟踪模式：完整
     */
    public static final int TRACE_MODE__FULL = GnssOpenStrmReq.TRACE_MODE__FULL;


    /**
     * 流媒体请求状态：未跟踪
     */
    public static final int STATE__NOT_TRACED = -1;

    /**
     * 流媒体请求状态：初始化
     */
    public static final int STATE__INIT = 0;

    /**
     * 流媒体请求状态：收到媒体服务API调用
     */
    public static final int STATE__MEDIA_SERVER_API_CALLED = 1;

    /**
     * 流媒体请求状态：打开流媒体的终端指令已发送
     */
    public static final int STATE__OPEN_STRM_CMD_SENT = 2;

    /**
     * 流媒体请求状态：由于打开流媒体的终端指令失败，重试
     */
    public static final int STATE__RETRY_DUE_TO_OPEN_STRM_CMD_FAILED = 3;

    /**
     * 流媒体请求状态：流媒体已准备好
     */
    public static final int STATE__STREAM_READY = 4;

    /**
     * 流媒体请求状态：请求无效
     */
    public static final int STATE__INVALID_REQUEST = 5;

    /**
     * 流媒体请求状态：由于流媒体命令失败，关闭
     */
    public static final int STATE__CLOSED_DUE_TO_STRM_CMD_FAILED = 20;

    /**
     * 流媒体请求状态：由于客户端请求关闭，关闭
     */
    public static final int STATE__CLOSED_DUE_TO_CLIENT_REQUEST = 21;

    /**
     * 流媒体请求状态：媒体服务器API调用失败
     */
    public static final int STATE__MEDIA_SERVER_API_CALL_FAILED = 22;

    /**
     * 流媒体请求状态：媒体格式错误
     */
    public static final int STATE__BAD_MEDIA_FORMAT = 23;

    /**
     * 流媒体请求状态：码流已中止
     */
    public static final int STATE__STRM_ABORTED = 24;

    /**
     * 流媒体请求状态：媒体数据超时
     */
    public static final int STATE__MEDIA_DATA_TIMEOUT = 25;

    /**
     * 流媒体请求状态：客户端保持超时
     */
    public static final int STATE__CLIENT_KEEP_TIMEOUT = 26;

    /**
     * 流媒体请求状态：媒体未在指定时间内拉取（消费）
     */
    public static final int STATE__CONSUMPTION_TIMEOUT = 27;

    /**
     * 流媒体请求状态：请求超时
     * The whole request timed out.
     */
    public static final int STATE__REQUEST_TIMEOUT = 27;

    /**
     * 流媒体请求状态：内部错误
     */
    public static final int STATE__INTERNAL_ERROR = 28;

    /**
     * 流媒体请求状态：请求无效
     */
    public static final int STATE__REQUEST_INVALID = 29;


    /**
     * 判断给定的流媒体请求状态是否为最终状态
     * @param state 流媒体请求状态
     * @return 是否为最终状态
     */
    public static boolean isFinalState(int state) {
        return state == STATE__NOT_TRACED || state >= STATE__CLOSED_DUE_TO_STRM_CMD_FAILED;
    }


    private String reqId;
    private int typ;
    private long reqTm;
    private String simNo;
    private Integer chan;
    private Integer mediaTyp;
    private int fmt;
    private String subFmt;
    private Boolean detectMediaTyp;
    private Integer codeStrm;
    private Boolean exclusive;
    private Boolean saveOnServer;
    private String reqBody;

    /**
     * Trace mode ID. Value domain: one of `TRACE_MODE__xxx` constant.
     */
    private int trace;
    /**
     * The instance ID of the media server.
     */
    private String strmInst;
    private int state;
    private String errMsg;
    private java.lang.Long closeTm;

    /**
     * 获取流媒体请求ID
     * @return 流媒体请求ID
     */
    @Override
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置流媒体请求ID
     * @param reqId 流媒体请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取流媒体请求类型
     * @return 流媒体请求类型
     */
    public int getTyp() {
        return typ;
    }

    /**
     * 设置流媒体请求类型
     * @param typ 流媒体请求类型, 为 {@link #TYP__LIVE} 或 {@link #TYP__REPLAY}
     */
    public void setTyp(int typ) {
        this.typ = typ;
    }

    /**
     * 获取流媒体请求时间
     * @return 流媒体请求时间, epoch millis
     */
    @Override
    public long getReqTm() {
        return reqTm;
    }

    /**
     * 设置流媒体请求时间
     * @param reqTm 流媒体请求时间, epoch millis
     */ 
    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
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
     * 获取通道号
     * @return 通道号
     */
    public Integer getChan() {
        return chan;
    }

    /**
     * 设置通道号
     * @param chan 通道号
     */
    public void setChan(Integer chan) {
        this.chan = chan;
    }

    /**
     * 获取媒体类型
     * @return 媒体类型
     */
    public Integer getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置媒体类型
     * @param mediaTyp 媒体类型
     */
    public void setMediaTyp(Integer mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 设置媒体类型
     * @param mediaType 媒体类型
     */
    public void setMediaType(Byte mediaType) {
        if (mediaType != null)
            this.mediaTyp = mediaTyp.intValue();
        else
            this.mediaTyp = null;
    }

    /**
     * 获取媒体格式
     * @return 媒体格式, 为 `StreamingApi.STRM_FORMAT__xxx` 常量之一
     */
    public int getFmt() {
        return fmt;
    }

    /**
     * 设置媒体格式
     * @param fmt 媒体格式, 为 `StreamingApi.STRM_FORMAT__xxx` 常量之一
     */
    public void setFmt(int fmt) {
        this.fmt = fmt;
    }

    /**
     * 获取媒体子格式
     * @return 媒体子格式, 为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一
     */
    public String getSubFmt() {
        return subFmt;
    }

    /**
     * 设置媒体子格式
     * @param subFmt 媒体子格式, 为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一
     */
    public void setSubFmt(String subFmt) {
        this.subFmt = subFmt;
    }

    /**
     * 获取是否检测媒体类型
     * @return 是否检测媒体类型
     */
    @Deprecated
    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    /**
     * 设置是否检测媒体类型
     * @param detectMediaTyp 是否检测媒体类型
     */
    @Deprecated
    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    /**
     * 获取码流类型
     * @return 码流类型, 为 `GnssOpenLiveStrmReq.CODE_STREAM__xxx` 常量之一
     */
    public Integer getCodeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流类型
     * @param codeStrm 码流类型, 为 `GnssOpenLiveStrmReq.CODE_STREAM__xxx` 常量之一
     */
    public void setCodeStrm(Integer codeStrm) {
        this.codeStrm = codeStrm;
    }

    /**
     * 获取是否以独占方式打开流媒体
     * @return 是否以独占方式打开流媒体
     */
    public Boolean getExclusive() {
        return exclusive;
    }

    /**
     * 设置是否以独占方式打开流媒体
     * @param exclusive 是否以独占方式打开流媒体
     */
    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * 获取是否在播放时的同时保存视频文件在服务器
     * @return 是否在播放时的同时保存视频文件在服务器
     */
    public Boolean getSaveOnServer() {
        return saveOnServer;
    }

    /**
     * 设置是否在播放时的同时保存视频文件在服务器
     * @param saveOnServer 是否在播放时的同时保存视频文件在服务器
     */
    public void setSaveOnServer(Boolean saveOnServer) {
        this.saveOnServer = saveOnServer;
    }

    /**
     * 获取流媒体请求的请求体
     * @return 流媒体请求的请求体
     */
    public String getReqBody() {
        return reqBody;
    }

    /**
     * 设置流媒体请求的请求体
     * @param reqBody 流媒体请求的请求体
     */
    public void setReqBody(String reqBody) {
        this.reqBody = reqBody;
    }

    /**
     * 获取跟踪模式
     * @return 跟踪模式, 为 `TRACE_MODE__xxx` 常量之一
     */
    public int getTrace() {
        return trace;
    }

    /**
     * 设置跟踪模式
     * @param trace 跟踪模式, 为 `TRACE_MODE__xxx` 常量之一
     */
    public void setTrace(int trace) {
        this.trace = trace;
    }

    /**
     * 获取流媒体实例ID
     * @return 流媒体实例ID
     */
    public String getStrmInst() {
        return strmInst;
    }

    /**
     * 设置流媒体实例ID
     * @param strmInst 流媒体实例ID
     */
    public void setStrmInst(String strmInst) {
        this.strmInst = strmInst;
    }

    /**
     * 获取流媒体请求状态
     * @return 流媒体请求状态, 为 {@link #STATE__xxx} 常量之一
     */
    public int getState() {
        return state;
    }

    /**
     * 设置流媒体请求状态
     * @param state 流媒体请求状态, 为 {@link #STATE__xxx} 常量之一
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * 获取错误消息
     * @return 错误消息
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 设置错误消息
     * @param errMsg 错误消息
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    /**
     * 获取关闭时间
     * @return 关闭时间
     */
    public java.lang.Long getCloseTm() {
        return closeTm;
    }

    /**
     * 设置关闭时间
     * @param closeTm 关闭时间
     */
    public void setCloseTm(java.lang.Long closeTm) {
        this.closeTm = closeTm;
    }

    /**
     * 判断流媒体请求是否处于最终状态
     * @return 是否处于最终状态
     */
    public boolean finalState() {
        return isFinalState(state);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("typ=" + typ)
                .add("reqTm=" + reqTm)
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("mediaTyp=" + mediaTyp)
                .add("fmt=" + fmt)
                .add("subFmt='" + subFmt + "'")
                .add("detectMediaTyp=" + detectMediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("exclusive=" + exclusive)
                .add("saveOnServer=" + saveOnServer)
                .add("reqBody='" + reqBody + "'")
                .add("trace=" + trace)
                .add("strmInst='" + strmInst + "'")
                .add("state=" + state)
                .add("errMsg='" + errMsg + "'")
                .add("closeTm=" + closeTm)
                .toString();
    }
}
