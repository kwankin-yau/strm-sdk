package com.lucendar.strm.common;

import java.util.StringJoiner;

/**
 * 媒体状态变更通知
 */
public class StrmMediaNotif implements Cloneable {

    /**
     * 通知类型：下发指令（当终端未及时推流时，服务端可能多次下发指令，因此此通知也可能多次推送）
     */
    public static final String ACT__cmdSent = "sent";

    /**
     * 通知类型：终端指令失败（终端不在线或终端应答提出指令已经失败）。
     */
    public static final String ACT__cmdFailed = "failed";

    /**
     * 通知类型：终端开始推流。
     */
    public static final String ACT__id = "id";

    /**
     * 通知类型：流已经准备好，此时客户端可以打开流URL（URL由playUrl属性指出）。注意：用异步模式打开实时音视频播放时，如果目标通道已经有其他请求
     * 打开，则POST /strm/live/open请求返回的对象的ready将为true。返回后，服务端不会发送act为ready的流媒体状态通知。
     */
    public static final String ACT__strmReady = "ready";

    /**
     * 通知类型：流已经关闭，如果客户端此时仍在播放，则应停止播放。具体关闭原因请检查closeCause和closeReason属性。注意：流关闭并不意味着终端已
     * 经关闭码流，如果有其他请求仍在使用码流，则终端码流将仍然保持推流，只是当前的请求ID(reqId)已经关闭、失效。
     */
    public static final String ACT__strmClosed = "closed";

    /**
     * 通知类型： 终端媒体流网络传输质量报告。在接收终端媒体流过程中，媒体服务将定时产生此报告。企业应用可据此向终端发出实时音视频传输状态通知
     * （0x9105）。此通知不需推送到客户端。
     */
    public static final String ACT__qualityReport = "qr";

    /**
     * 流的类型：无
     */
    public static final String TYP_none = "";

    /**
     * 流的类型：直播流
     */
    public static final String TYP_live = "live";

    /**
     * 流的类型：回放流
     */
    public static final String TYP_replay = "replay";

    /**
     * 关闭原因：客户端请求关闭流
     */
    public static final int CLOSE_CAUSE__clientReq = 1;

    /**
     * 关闭原因：终端码流断开
     */
    public static final int CLOSE_CAUSE__termStrmClose = 2;

    /**
     * 关闭原因：连接媒体服务失败
     */
    public static final int CLOSE_CAUSE__connectStrmServerFailed = 3;

    /**
     * 关闭原因：服务端发生未处理的异常
     */
    @Deprecated
    public static final int CLOSE_CAUSE__exceptionCaught = 4; // internal error

    /**
     * 关闭原因：服务端发生未处理的异常
     */
    public static final int CLOSE_CAUSE__internalError = 4; // internal error

    /**
     *关闭原因：客户端流请求保持超时
     */
    public static final int CLOSE_CAUSE__keepTimeout = 5;

    /**
     * 关闭原因：终端未能在一定时间内推流
     */
    public static final int CLOSE_CAUSE__termDataTimeout = 6;

    /**
     * 关闭原因：终端媒体格式错误或不能识别
     */
    public static final int CLOSE_CAUSE__badStrmFormat = 7;

    /**
     * 关闭原因：终端不在线
     */
    public static final int CLOSE_CAUSE__noConnection = 8;

    /**
     * 关闭原因：终端指令失败
     */
    public static final int CLOSE_CAUSE__termCmdFailed = 9;

    /**
     * 关闭原因：代理服务调用媒体服务的打开媒体接口(`/strm/open`)失败
     */
    public static final int CLOSE_CAUSE__openStrmFailed = 10; // /strm/open API call return error

    /**
     * 关闭原因：整个媒体请求处理超时（在成功打开前超时）
     */
    public static final int CLOSE_CAUSE__requestTimeout = 11;

    /**
     * 当客户端成功请求打开一个流后，如果在配置的时间内（默认2分钟）未消费。
     */
    public static final int CLOSE_CAUSE__consumptionTimeout = 12;

    /**
     * 媒体类型：音视频
     */
    public static final String MEDIA_TYP__AUDIO_AND_VIDEO = StreamingApi.MEDIA_TYP__AUDIO_AND_VIDEO;

    /**
     * 媒体类型：音频
     */
    public static final String MEDIA_TYP__AUDIO_ONLY = StreamingApi.MEDIA_TYP__AUDIO_ONLY;

    /**
     * 媒体类型：视频
     */
    public static final String MEDIA_TYP__VIDEO_ONLY = StreamingApi.MEDIA_TYP__VIDEO_ONLY;

    private String instId;
    private String act;
    private String reqId;
    private String typ;
    private boolean talk;
    private String simNo;
    private short chan;

    private String mediaTyp;
    private String playUrl;
    private String wsUrl;
    private String taUrl;

    private Byte lostRate;

    private Integer closeCause;
    private String closeReason;
    private Integer ac;
    private Integer aBitrate;
    private Integer sampleRate;
    private Integer vc;
    private String frameRate;


    /**
     * 构造函数
     */
    public StrmMediaNotif() {
    }

    /**
     * 取发出此通知的媒体服务实例ID。
     * @return 发出此通知的媒体服务实例ID。
     */
    public String getInstId() {
        return instId;
    }

    /**
     * 设置发出此通知的媒体服务实例ID。
     * @param instId 发出此通知的媒体服务实例ID。
     */
    public void setInstId(String instId) {
        this.instId = instId;
    }

    /**
     * 取通知的类型，为 ACT__xxxx 系列常量之一:
     * <ul>
     *     <li>`sent`: 下发指令（当终端未及时推流时，服务端可能多次下发指令，因此此通知也可能多次推送）。</li>
     *     <li>`failed`: 终端指令失败（终端不在线或终端应答提出指令已经失败）。</li>
     *     <li>`id`: 终端开始推流。</li>
     *     <li>`ready`: 流已经准备好，此时客户端可以打开流URL（URL由playUrl属性指出）。</li>
     *     <li>`qr`: 终端媒体流网络传输质量报告。在接收终端媒体流过程中，媒体服务将定时产生此报告。企业应用可据此向终端发出实时音视频传输状态通知（0x9105）。此通知不需推送到客户端。</li>
     *     <li>`closed`: 流已经关闭，如果客户端此时仍在播放，则应停止播放。具体关闭原因请检查closeCause和closeReason属性。</li>
     * </ul>
     * @return 通知的类型
     */
    public String getAct() {
        return act;
    }

    /**
     * 设置通知的类型
     * @param act 通知的类型，为 ACT__xxxx 系列常量之一
     */
    public void setAct(String act) {
        this.act = act;
    }

    /**
     * 取请求ID。
     * @return 请求ID。
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID。
     * @param reqId 请求ID。
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取流的类型，为 TYP__xxxx 系列常量之一：
     * <ul>
     *     <li>`live`: 表示流为实时流</li>
     *     <li>`replay`: 表示流为回放流</li>
     * </ul>
     *
     * @return 流的类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置流的类型。
     * @param typ 流的类型，为 TYP__xxxx 系列常量之一。
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 设置流的类型。
     *
     * @param live 是否实时流
     */
    public void setTyp(boolean live) {
        if (live)
            typ = TYP_live;
        else
            typ = TYP_replay;
    }

    /**
     * 取是否对讲请求。
     *
     * @return 是否对讲请求。
     */
    public boolean isTalk() {
        return talk;
    }

    /**
     * 设置是否对讲请求。
     * @param talk 是否对讲请求。
     */
    public void setTalk(boolean talk) {
        this.talk = talk;
    }

    /**
     * 取是否实时播放流。对讲时，此属性返回 `true`
     *
     * @return 是否实时播放流
     */
    public boolean isLive() {
        return TYP_live.equals(typ);
    }

    /**
     * 取终端识别号。
     *
     * @return 终端识别号。
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号。
     * @param simNo 终端识别号。
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取音视频逻辑通道号（参见JT/T 1076-2016 表2）
     * @return 音视频逻辑通道号（参见JT/T 1076-2016 表2）
     */
    public short getChan() {
        return chan;
    }

    /**
     * 设置音视频逻辑通道号（参见JT/T 1076-2016 表2）
     * @param chan 音视频逻辑通道号（参见JT/T 1076-2016 表2）
     */
    public void setChan(short chan) {
        this.chan = chan;
    }

    /**
     * 取丢包率。0-100。仅当 `act` == `qr`时有效。
     * @return 丢包率
     */
    public Byte getLostRate() {
        return lostRate;
    }

    /**
     * 设置丢包率
     * @param lostRate 丢包率。0-100。
     */
    public void setLostRate(Byte lostRate) {
        this.lostRate = lostRate;
    }

    /**
     * 取音视频播放 URL
     * @return 音视频播放 URL
     */
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * 设置音视频播放 URL
     * @param playUrl 音视频播放 URL
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 取WebSocket对讲推流地址，用于对讲时客户端提交音频数据。此地址使用stomp协议。仅当 `talk` == `true` 时有效
     *
     * @return WebSocket 对讲推流地址(stomp协议)
     */
    public String getWsUrl() {
        return wsUrl;
    }

    /**
     * 设置WebSocket对讲推流地址(stomp协议)
     * @param wsUrl WebSocket对讲推流地址(stomp协议)
     */
    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    /**
     * 取 WebSocket 对讲推流地址，用于对讲时客户端提交音频数据。此地址使用二进制 websocket 协议。仅当 `talk` == `true` 时有效。客户端可选择
     * 选择`taUrl`或`wsUrl`来推送对讲的音频数据。建议使用 `taUrl`。
     *
     * @return WebSocket 对讲推流地址（二进㓡）
     */
    public String getTaUrl() {
        return taUrl;
    }

    /**
     * 取 WebSocket 对讲推流地址（二进㓡），
     * @param taUrl 取 WebSocket 对讲推流地址（二进㓡），
     */
    public void setTaUrl(String taUrl) {
        this.taUrl = taUrl;
    }

    /**
     * 取流关闭的原因代码。为 CLOSE_CAUSE__xxxx 系列常量之一
     *
     * @return 流关闭的原因代码
     */
    public Integer getCloseCause() {
        return closeCause;
    }

    /**
     * 设置流关闭的原因代码
     * @param closeCause 流关闭的原因代码。为 CLOSE_CAUSE__xxxx 系列常量之一
     */
    public void setCloseCause(Integer closeCause) {
        this.closeCause = closeCause;
    }

    /**
     * 取流关闭的原因描述字符串
     * @return 流关闭的原因描述字符串
     */
    public String getCloseReason() {
        return closeReason;
    }

    /**
     * 设置流关闭的原因描述字符串
     * @param closeReason 流关闭的原因描述字符串
     */
    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    /**
     * 将 流关闭的原因代码转换成描述字符串
     * @param closeCause 流关闭的原因代码
     * @return 流关闭的原因描述字符串
     */
    public static String closeCauseToText(int closeCause) {
        switch (closeCause) {
            case CLOSE_CAUSE__clientReq:
                return "Client request close.";

            case CLOSE_CAUSE__connectStrmServerFailed:
                return "Connect stream server failed.";

            case CLOSE_CAUSE__internalError:
                return "Internal error.";

            case CLOSE_CAUSE__keepTimeout:
                return "Client keep timeout.";

            case CLOSE_CAUSE__termDataTimeout:
                return "Terminal media data timeout.";

            case CLOSE_CAUSE__termStrmClose:
                return "Terminal connection closed.";

            case CLOSE_CAUSE__badStrmFormat:
                return "Bad stream format.";

            case CLOSE_CAUSE__noConnection:
                return "No connection";

            case CLOSE_CAUSE__termCmdFailed:
                return "Terminal command failed.";

            case CLOSE_CAUSE__openStrmFailed:
                return "Call `/strm/open` API failed.";

            case CLOSE_CAUSE__requestTimeout:
                return "Whole request handling timeout.";

            case CLOSE_CAUSE__consumptionTimeout:
                return "Media consumption timeout.";

            default:
                return "Unknown";
        }
    }

    /**
     * 根据 closeCause 的当前值更新 closeReason 属性
     */
    public void updateCloseReason() {
        if (closeReason != null)
            return;

        if (closeCause != null) {
            int cc = closeCause;
            if (cc != 0) {
                closeReason = closeCauseToText(cc);
            }
        }
    }

    /**
     * 取流的媒体类型，为 MEDIA_TYP__xxxx 系列常量之一
     *
     * @return 流的媒体类型
     */
    public String getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置流的媒体类型
     * @param mediaTyp 流的媒体类型，为 MEDIA_TYP__xxxx 系列常量之一
     */
    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * Get audio codec ID. 0 for NO audio or unrecognized.
     *
     * @return audio codec ID
     */
    public Integer getAc() {
        return ac;
    }

    /**
     * Set audio codec ID.
     * @param ac audio codec ID
     */
    public void setAc(Integer ac) {
        this.ac = ac;
    }

    /**
     * Get video codec ID. 0 for NO audio or unrecognized.
     *
     * @return video codec ID
     */
    public Integer getVc() {
        return vc;
    }

    /**
     * Set video codec ID.
     * @param vc video codec ID
     */
    public void setVc(Integer vc) {
        this.vc = vc;
    }

    /**
     * 取音频的位率，单位：位/秒
     * @return 音频的位率
     */
    public Integer getaBitrate() {
        return aBitrate;
    }

    /**
     * 设置音频的位率
     * @param aBitrate 音频的位率，单位：位/秒
     */
    public void setaBitrate(Integer aBitrate) {
        this.aBitrate = aBitrate;
    }

    /**
     * 取音频的采样率
     * @return 音频的采样率
     */
    public Integer getSampleRate() {
        return sampleRate;
    }

    /**
     * 设置音频的采样率
     * @param sampleRate 音频的采样率
     */
    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
    }

    /**
     * 取视频的帧率。单位：帧/秒
     * @return 视频的帧率
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * 设置视频的帧率
     * @param frameRate 视频的帧率。单位：帧/秒
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    @Override
    public StrmMediaNotif clone() {
        try {
            return (StrmMediaNotif) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmMediaNotif.class.getSimpleName() + "[", "]")
                .add("instId='" + instId + "'")
                .add("act='" + act + "'")
                .add("reqId='" + reqId + "'")
                .add("typ='" + typ + "'")
                .add("talk=" + talk)
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("mediaTyp='" + mediaTyp + "'")
                .add("playUrl='" + playUrl + "'")
                .add("wsUrl='" + wsUrl + "'")
                .add("taUrl='" + taUrl + "'")
                .add("lostRate=" + lostRate)
                .add("closeCause=" + closeCause)
                .add("closeReason='" + closeReason + "'")
                .add("ac=" + ac)
                .add("aBitrate=" + aBitrate)
                .add("sampleRate=" + sampleRate)
                .add("vc=" + vc)
                .add("frameRate='" + frameRate + "'")
                .toString();
    }
}
