package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 检查是否有控制权结果 
 */
public class CheckCtrlResult {
    /**
     * 请求ID
     */
    private String reqId;
    /**
     * 是否有控制权
     */
    private boolean ctrl;
    /**
     * 终端识别号
     */
    private String simNo;
    /**
     * 通道ID
     */
    private short channelId;
    /**
     * 是否实时流
     */
    private boolean live;

    /**
     * 构造函数
     */
    public CheckCtrlResult() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param ctrl 是否有控制权
     * @param simNo 终端识别号
     * @param channelId 通道ID
     * @param live 是否实时流
     */
    public CheckCtrlResult(String reqId, boolean ctrl, String simNo, short channelId, boolean live) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.simNo = simNo;
        this.channelId = channelId;
        this.live = live;
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
     * 是否有控制权
     * @return 是否有控制权
     */
    public boolean isCtrl() {
        return ctrl;
    }

    /**
     * 设置是否有控制权
     * @param ctrl 是否有控制权
     */
    public void setCtrl(boolean ctrl) {
        this.ctrl = ctrl;
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
     * 获取通道ID
     * @return 通道ID
     */
    public short getChannelId() {
        return channelId;
    }

    /**
     * 设置通道ID
     * @param channelId 通道ID
     */
    public void setChannelId(short channelId) {
        this.channelId = channelId;
    }

    /**
     * 是否实时流
     * @return 是否实时流
     */
    public boolean isLive() {
        return live;
    }

    /**
     * 设置是否实时流
     * @param live 是否实时流
     */
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
