/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.log;

import com.lucendar.strm.common.StreamingApi;

import java.util.StringJoiner;

/**
 * Streaming activity log entry
 */
public class StrmLogEntry {

    public static final String EVT__OPEN_CHANNEL = "open";
    public static final String EVT__IDENTIFIED = "id";
    public static final String EVT__STRM_READY = "ready";
    public static final String EVT__REQUEST_CLOSED = "reqClosed";
    public static final String EVT__SRC_CLOSED = "srcClosed";

    public static final String DATA_KEY__FIRST_REQ = "firstReq";
    public static final String DATA_KEY__LIVE_DATA_TYP = "liveDataTyp";
    public static final String DATA_KEY__CODE_STRM = "codeStrm";
    public static final String DATA_KEY__PROTO = "proto";
    public static final String DATA_KEY__CONN_IDX = "connIdx";
    public static final String DATA_KEY__CLIENT_DATA = "clientData";
    public static final String DATA_KEY__CALLBACK = "callback";
    public static final String DATA_KEY__USER = "user";
    public static final String DATA_KEY__CTRL = "ctrl";

    private long time;
    private String appId;
    private String simNo;
    private short chanId;
    private boolean live;
    private String reqId;
    private String evtTyp;
    private String evtData;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public short getChanId() {
        return chanId;
    }

    public void setChanId(short chanId) {
        this.chanId = chanId;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getEvtTyp() {
        return evtTyp;
    }

    public void setEvtTyp(String evtTyp) {
        this.evtTyp = evtTyp;
    }

    public String getEvtData() {
        return evtData;
    }

    public void setEvtData(String evtData) {
        this.evtData = evtData;
    }

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
