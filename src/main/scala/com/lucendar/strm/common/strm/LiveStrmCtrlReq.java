package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 实时流控制请求
 */
public class LiveStrmCtrlReq implements StrmMsg, StrmCtrlReq{

    /**
     * 关闭音视频传输指令
     */
    public static final byte CTRL__CLOSE = 0;

    /**
     * 切换码流
     */
    public static final byte CTRL__SWITCH_CODE_STREAM = 1;

    /**
     * 暂停音视频传输指令
     */
    public static final byte CTRL__PAUSE = 2;

    /**
     * 恢复音视频传输指令
     */
    public static final byte CTRL__RESUME = 3;

    /**
     * 关闭双向对讲指令
     */
    public static final byte CTRL__CLOSE_TALK = 4;

    /**
     * 关闭音视频传输指令
     */
    public static final byte CLOSE_ACTION__CLOSE_FULLY = 0;

    /**
     * 静音指令
     */
    public static final byte CLOSE_ACTION__MUTE = 1;

    /**
     * 关闭视频指令
     */
    public static final byte CLOSE_ACTION__CLOSE_VIDEO = 2;

    /**
     * 主码流
     */
    public static final byte CODE_STREAM__PRIMARY = 0;

    /**
     * 子码流
     */
    public static final byte CODE_STREAM__SUB = 1;

    private String reqId;
    private byte ctrl;
    private Byte closeAction;
    private Byte codeStream;
    private ServerHint strmServerHint;
    private String closeReason;

    /**
     * 构造函数
     */
    public LiveStrmCtrlReq() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param ctrl 控制指令
     * @param closeAction 关闭指令
     * @param codeStream 码流类型
     * @param closeReason 关闭原因
     * @param strmServerHint 流服务器选择提示
     */
    public LiveStrmCtrlReq(String reqId, byte ctrl, Byte closeAction, Byte codeStream, String closeReason, ServerHint strmServerHint) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.closeAction = closeAction;
        this.codeStream = codeStream;
        this.strmServerHint = strmServerHint;
        this.closeReason = closeReason;
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param ctrl 控制指令
     * @param closeAction 关闭指令
     * @param codeStream 码流类型
     * @param closeReason 关闭原因
     */
    public LiveStrmCtrlReq(String reqId, byte ctrl, Byte closeAction, Byte codeStream, String closeReason) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.closeAction = closeAction;
        this.codeStream = codeStream;
        this.closeReason = closeReason;
    }

    /**
     * 获取请求ID
     * @return 请求ID
     */
    @Override
    public boolean isLive() {
        return true;
    }

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取控制指令
     * @return 控制指令
     */
    public byte getCtrl() {
        return ctrl;
    }

    /**
     * 设置控制指令
     * @param ctrl 控制指令
     */
    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 获取关闭指令
     * @return 关闭指令
     */
    public Byte getCloseAction() {
        return closeAction;
    }

    /**
     * 设置关闭指令
     * @param closeAction 关闭指令
     */
    public void setCloseAction(Byte closeAction) {
        this.closeAction = closeAction;
    }

    /**
     * 获取码流类型
     * @return 码流类型
     */
    public byte closeActionDef() {
        if (closeAction == null)
            return 0;
        else
            return closeAction;
    }

    /**
     * 获取码流类型
     * @return 码流类型
     */
    public Byte getCodeStream() {
        return codeStream;
    }

    /**
     * 设置码流类型
     * @param codeStream 码流类型
     */
    public void setCodeStream(Byte codeStream) {
        this.codeStream = codeStream;
    }

    /**
     * 获取码流类型
     * @return 码流类型
     */
    public byte codeStreamDef() {
        if (codeStream == null)
            return 0;
        else
            return codeStream;
    }

    /**
     * 获取流服务器选择提示
     * @return 流服务器选择提示
     */
    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    /**
     * 设置流服务器选择提示
     * @param strmServerHint 流服务器选择提示
     */
    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    /**
     * 获取关闭原因
     * @return 关闭原因
     */
    public String getCloseReason() {
        return closeReason;
    }

    /**
     * 设置关闭原因
     * @param closeReason 关闭原因
     */
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

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__LiveStrmCtrlReq;
    }
}
