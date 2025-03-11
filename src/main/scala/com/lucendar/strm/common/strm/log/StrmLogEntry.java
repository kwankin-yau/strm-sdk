/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;

/**
 * 流媒体活动日志条目
 * Streaming activity log entry
 */
public class StrmLogEntry {

    /**
     * 打开通道事件
     */
    public static final String EVT__OPEN_CHANNEL = "open";

    /**
     * 识别事件
     */
    public static final String EVT__IDENTIFIED = "id";

    /**
     * 流媒体就绪事件
     */
    public static final String EVT__STRM_READY = "ready";

    /**
     * 请求关闭事件
     */
    public static final String EVT__REQUEST_CLOSED = "reqClosed";

    /**
     * 源关闭事件
     */
    public static final String EVT__SRC_CLOSED = "srcClosed";


    /**
     * 数据键：首次请求
     */
    public static final String DATA_KEY__FIRST_REQ = "firstReq";

    /**
     * 数据键：流媒体数据类型
     */
    public static final String DATA_KEY__LIVE_DATA_TYP = "liveDataTyp";

    /**
     * 数据键：编码流
     */
    public static final String DATA_KEY__CODE_STRM = "codeStrm";

    /**
     * 数据键：协议
     */
    public static final String DATA_KEY__PROTO = "proto";

    /**
     * 数据键：连接索引
     */
    public static final String DATA_KEY__CONN_IDX = "connIdx";

    /**
     * 数据键：客户端数据
     */
    public static final String DATA_KEY__CLIENT_DATA = "clientData";

    /**
     * 数据键：回调
     */
    public static final String DATA_KEY__CALLBACK = "callback";

    /**
     * 数据键：用户
     */
    public static final String DATA_KEY__USER = "user";

    /**
     * 数据键：控制
     */
    public static final String DATA_KEY__CTRL = "ctrl";

    private long time;
    private String appId;
    private String simNo;
    private short chanId;
    private boolean live;
    private String reqId;
    private String evtTyp;
    private String evtData;

    /**
     * 获取事件时间
     * @return 事件时间, epoch millis
     */
    public long getTime() {
        return time;
    }

    /**
     * 设置事件时间
     * @param time 事件时间, epoch millis
     */
    public void setTime(long time) {
        this.time = time;
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
    public short getChanId() {
        return chanId;
    }

    /**
     * 设置通道ID
     * @param chanId 通道ID
     */
    public void setChanId(short chanId) {
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
     * 获取事件类型
     * @return 事件类型, 为 `EVT__*` 常量之一
     */
    public String getEvtTyp() {
        return evtTyp;
    }

    /**
     * 设置事件类型
     * @param evtTyp 事件类型, 为 `EVT__*` 常量之一
     */
    public void setEvtTyp(String evtTyp) {
        this.evtTyp = evtTyp;
    }

    /**
     * 获取事件数据
     * @return 事件数据, 键值对字符串列表
     */
    public String getEvtData() {
        return evtData;
    }

    /**
     * 设置事件数据
     * @param evtData 事件数据, 键值对字符串列表
     */
    public void setEvtData(String evtData) {
        this.evtData = evtData;
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
        return new StringJoiner(", ", StrmLogEntry.class.getSimpleName() + "[", "]")
                .add("time=" + time)
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("live=" + live)
                .add("reqId='" + reqId + "'")
                .add("evtTyp='" + evtTyp + "'")
                .add("evtData='" + evtData + "'")
                .toString();
    }
}
