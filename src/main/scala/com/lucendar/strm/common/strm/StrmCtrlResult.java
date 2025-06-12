package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 流控制结果
 */
public class StrmCtrlResult {
    private String reqId;
    private String simNo;
    private short channelId;
    private boolean live;
    private boolean ctrl;

    /**
     * 构造函数
     */
    public StrmCtrlResult() {
    }

    /**
     * 构造函数
     * 
     * @param reqId     请求ID
     * @param simNo     卡号
     * @param channelId 通道ID
     * @param live      是否直播
     * @param ctrl      是否控制
     */
    public StrmCtrlResult(String reqId, String simNo, short channelId, boolean live, boolean ctrl) {
        this.reqId = reqId;
        this.simNo = simNo;
        this.channelId = channelId;
        this.live = live;
        this.ctrl = ctrl;
    }

    /**
     * 获取请求ID
     * 
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * 
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取终端识别号
     * 
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * 
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 获取通道ID
     * 
     * @return 通道ID
     */
    public short getChannelId() {
        return channelId;
    }

    /**
     * 设置通道ID
     * 
     * @param channelId 通道ID
     */
    public void setChannelId(short channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取是否实时播放
     * 
     * @return 是否实时播放
     */
    public boolean isLive() {
        return live;
    }

    /**
     * 设置是否实时播放
     * 
     * @param live 是否实时播放
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * 获取是否具有控制权
     * 
     * @return 是否具有控制权
     */
    public boolean isCtrl() {
        return ctrl;
    }

    /**
     * 设置是否具有控制权
     * 
     * @param ctrl 是否具有控制权
     */
    public void setCtrl(boolean ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmCtrlResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("channelId=" + channelId)
                .add("live=" + live)
                .add("ctrl=" + ctrl)
                .toString();
    }
}
