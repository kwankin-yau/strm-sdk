package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class ReplayStrmCtrlReq {

    public static final byte CTRL__PLAY = 0;
    public static final byte CTRL__PAUSE = 1;
    public static final byte CTRL__STOP = 2;
    public static final byte CTRL__FAST_FORWARD = 3;
    public static final byte CTRL__KEY_FRAME_BACKWARD = 4;
    public static final byte CTRL__SEEK = 5;
    public static final byte CTRL__KEY_FRAME_PLAY = 6;

    public static final byte SPEED_FACTOR__IGNORED = 0;
    public static final byte SPEED_FACTOR__1x = 1;
    public static final byte SPEED_FACTOR__2x = 2;
    public static final byte SPEED_FACTOR__4x = 3;
    public static final byte SPEED_FACTOR__8x = 4;
    public static final byte SPEED_FACTOR__16x = 5;


    private String reqId;
    private byte ctrl;
    private Byte factor;
    private long time;
    private ServerHint strmServerHint;

    public ReplayStrmCtrlReq() {
    }

    public ReplayStrmCtrlReq(String reqId, byte ctrl, Byte factor, long time, ServerHint strmServerHint) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.factor = factor;
        this.time = time;
        this.strmServerHint = strmServerHint;
    }

    public ReplayStrmCtrlReq(String reqId, byte ctrl, Byte factor, long time) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.factor = factor;
        this.time = time;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    public Byte getFactor() {
        return factor;
    }

    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReplayStrmCtrlReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("ctrl=" + ctrl)
                .add("factor=" + factor)
                .add("time=" + time)
                .add("strmServerHint=" + strmServerHint)
                .toString();
    }
}
