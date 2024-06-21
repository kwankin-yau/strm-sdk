package com.lucendar.strm.common;

import com.lucendar.strm.common.strm.OpenStrmReq;

import java.util.StringJoiner;

/**
 * 媒体状态变更通知
 */
public class StrmMediaNotif implements Cloneable {

    public static final String ACT__cmdSent = "sent";
    public static final String ACT__cmdFailed = "failed";
    public static final String ACT__id = "id";
    public static final String ACT__strmReady = "ready";
    public static final String ACT__strmClosed = "closed";
    public static final String ACT__qualityReport = "qr";

    public static final String TYP_none = "";
    public static final String TYP_live = "live";
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
    private Integer vc;


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
                .add("vc=" + vc)
                .toString();
    }
}
