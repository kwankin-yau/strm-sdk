/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;

/**
 * 流活动信息
 */
public class StrmActivity {

    private String reqId;
    private String appId;
    private String simNo;
    private int chanId;
    private boolean live;
    private boolean success;
    private long startTm;
    private long endTm;

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
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
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
    public int getChanId() {
        return chanId;
    }

    /**
     * 设置通道ID
     * @param chanId 通道ID
     */
    public void setChanId(int chanId) {
        this.chanId = chanId;
    }

    /**
     * 获取是否为实时流
     * @return 是否为实时流
     */
    public boolean isLive() {
        return live;
    }

    /**
     * 设置是否为实时流
     * @param live 是否为实时流
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * 获取是否成功
     * @return 是否成功
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置是否成功
     * @param success 是否成功
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取开始时间, epoch millis
     * @return 开始时间
     */
    public long getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间, epoch millis
     * @param startTm 开始时间
     */
    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    /**
     * 获取结束时间, epoch millis
     * @return 结束时间
     */
    public long getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间, epoch millis
     * @param endTm 结束时间
     */
    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    /**
     * 获取应用ID, 如果为空则返回默认应用ID
     * @return 应用ID
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmActivity.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("live=" + live)
                .add("success=" + success)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .toString();
    }
}
