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

    public static final int CLOSE_CAUSE__clientReq = 1;
    public static final int CLOSE_CAUSE__termStrmClose = 2;
    public static final int CLOSE_CAUSE__connectStrmServerFailed = 3;

    @Deprecated
    public static final int CLOSE_CAUSE__exceptionCaught = 4; // internal error
    public static final int CLOSE_CAUSE__internalError = 4; // internal error
    public static final int CLOSE_CAUSE__keepTimeout = 5;
    public static final int CLOSE_CAUSE__termDataTimeout = 6;
    public static final int CLOSE_CAUSE__badStrmFormat = 7;
    public static final int CLOSE_CAUSE__noConnection = 8;

    /**
     * Terminal response a error for issued media command
     */
    public static final int CLOSE_CAUSE__termCmdFailed = 9;

    /**
     * 代理服务调用媒体服务的打开媒体接口(`/strm/open`)失败
     */
    public static final int CLOSE_CAUSE__openStrmFailed = 10; // /strm/open API call return error

    /**
     * The whole open stream request handling timeout, primary used in `micro-gnss` API.
     * 整个媒体请求处理超时（在成功打开前超时）
     */
    public static final int CLOSE_CAUSE__requestTimeout = 11;

    /**
     * 当客户端成功请求打开一个流后，如果在配置的时间内（默认1分钟）未消费。
     */
    public static final int CLOSE_CAUSE__consumptionTimeout = 12;

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
    private Integer vc;
    private String frameRate;


    public StrmMediaNotif() {
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setTyp(boolean live) {
        if (live)
            typ = TYP_live;
        else
            typ = TYP_replay;
    }

    public boolean isTalk() {
        return talk;
    }

    public void setTalk(boolean talk) {
        this.talk = talk;
    }

    public boolean isLive() {
        return TYP_live.equals(typ);
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public short getChan() {
        return chan;
    }

    public void setChan(short chan) {
        this.chan = chan;
    }

    public Byte getLostRate() {
        return lostRate;
    }

    public void setLostRate(Byte lostRate) {
        this.lostRate = lostRate;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getWsUrl() {
        return wsUrl;
    }

    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    public String getTaUrl() {
        return taUrl;
    }

    public void setTaUrl(String taUrl) {
        this.taUrl = taUrl;
    }

    public Integer getCloseCause() {
        return closeCause;
    }

    public void setCloseCause(Integer closeCause) {
        this.closeCause = closeCause;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public static String closeCauseToText(int closeCause) {
        switch (closeCause) {
            case CLOSE_CAUSE__clientReq:
                return "Client request close.";

            case CLOSE_CAUSE__connectStrmServerFailed:
                return "Connect stream server failed.";

            case CLOSE_CAUSE__exceptionCaught:
                return "Exception caught.";

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

    public String getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * Get audio codec. 0 for NO audio or unrecognized.
     *
     * @return
     */
    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    /**
     * Get video codec. 0 for NO audio or unrecognized.
     *
     * @return
     */
    public Integer getVc() {
        return vc;
    }

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

    public void setaBitrate(Integer aBitrate) {
        this.aBitrate = aBitrate;
    }

    /**
     * 取视频的帧率。单位：帧/秒
     * @return 视频的帧率
     */
    public String getFrameRate() {
        return frameRate;
    }

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
                .add("vc=" + vc)
                .add("frameRate='" + frameRate + "'")
                .toString();
    }
}
