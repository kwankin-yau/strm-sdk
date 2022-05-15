package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class LiveStrmCtrlReq {

    public static final byte CTRL__CLOSE = 0;
    public static final byte CTRL__SWITCH_CODE_STREAM = 1;
    public static final byte CTRL__PAUSE = 2;
    public static final byte CTRL__RESUME = 3;
    public static final byte CTRL__CLOSE_TALK = 4;

    public static final byte CLOSE_ACTION__CLOSE_FULLY = 0;
    public static final byte CLOSE_ACTION__MUTE = 1;
    public static final byte CLOSE_ACTION__CLOSE_VIDEO = 2;

    public static final byte CODE_STREAM__PRIMARY = 0;
    public static final byte CODE_STREAM__SUB = 1;

    private String reqId;
    private byte ctrl;
    private Byte closeAction;
    private Byte codeStream;
    private ServerHint strmServerHint;
    private String closeReason;

    public LiveStrmCtrlReq() {
    }

    public LiveStrmCtrlReq(String reqId, byte ctrl, Byte closeAction, Byte codeStream, String closeReason, ServerHint strmServerHint) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.closeAction = closeAction;
        this.codeStream = codeStream;
        this.strmServerHint = strmServerHint;
        this.closeReason = closeReason;
    }

    public LiveStrmCtrlReq(String reqId, byte ctrl, Byte closeAction, Byte codeStream, String closeReason) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.closeAction = closeAction;
        this.codeStream = codeStream;
        this.closeReason = closeReason;
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

    public Byte getCloseAction() {
        return closeAction;
    }

    public void setCloseAction(Byte closeAction) {
        this.closeAction = closeAction;
    }

    public byte closeActionDef() {
        if (closeAction == null)
            return 0;
        else
            return closeAction;
    }

    public Byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(Byte codeStream) {
        this.codeStream = codeStream;
    }

    public byte codeStreamDef() {
        if (codeStream == null)
            return 0;
        else
            return codeStream;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LiveStrmCtrlReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("ctrl=" + ctrl)
                .add("closeAction=" + closeAction)
                .add("codeStream=" + codeStream)
                .add("strmServerHint=" + strmServerHint)
                .add("closeReason='" + closeReason + "'")
                .toString();
    }

}
