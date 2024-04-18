package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class CheckCtrlResult {
    private String reqId;
    private boolean ctrl;
    private String simNo;
    private short channelId;
    private boolean live;

    public CheckCtrlResult() {
    }

    public CheckCtrlResult(String reqId, boolean ctrl, String simNo, short channelId, boolean live) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.simNo = simNo;
        this.channelId = channelId;
        this.live = live;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public boolean isCtrl() {
        return ctrl;
    }

    public void setCtrl(boolean ctrl) {
        this.ctrl = ctrl;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public short getChannelId() {
        return channelId;
    }

    public void setChannelId(short channelId) {
        this.channelId = channelId;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckCtrlResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("ctrl=" + ctrl)
                .add("simNo='" + simNo + "'")
                .add("channelId=" + channelId)
                .add("live=" + live)
                .toString();
    }
}
