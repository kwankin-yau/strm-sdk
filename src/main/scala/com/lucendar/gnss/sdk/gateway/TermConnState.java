/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.gateway;

import com.lucendar.strm.common.StreamingApi;
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import org.springframework.lang.Nullable;

import java.util.StringJoiner;

/**
 * 终端最新状态
 */
public class TermConnState implements Cloneable {

    /**
     * 所属 appId
     */
    private String appId;

    /**
     * 终端识别号
     */
    private String simNo;

    /**
     * 连接次数
     */
    private long connTimes;

    /**
     * 最后连接时间, epoch millis
     * 定义为String 类型是为了前端 js 解释时不丢失精度
     */
    private String connAt;

    /**
     * 终端的协议版本。对于JT/T 808协议：
     * - 0: 2013
     * - 1: 2019
     * - null: 未知
     */
    private String protoVer;

    /**
     * 最后上传或应答时间，epoch millis
     * 定义为String 类型是为了前端 js 解释时不丢失精度
     */
    private String lastActive;

    /**
     * 连接期间上报的轨迹数
     */
    private long trkCnt;

    /**
     * ACC 状态
     */
    private Boolean acc;

    /**
     * GPS速度
     */
    private Float spd;

    /**
     * 视频报警状态字
     */
    private Integer vidAlm;

    /**
     * 轨迹对象
     */
    @Nullable
    private Trk latestTrk;

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

    /**
     * The times of terminal connected to server .
     *
     * @return
     */
    public long getConnTimes() {
        return connTimes;
    }

    public void setConnTimes(long connTimes) {
        this.connTimes = connTimes;
    }

    public String getConnAt() {
        return connAt;
    }

    public void setConnAt(long connAtEpochMillis) {
        this.connAt = String.valueOf(connAtEpochMillis);
    }

    public void setConnAt(String connAtEpochMillis) {
        this.connAt = connAtEpochMillis;
    }

    public Integer getVidAlm() {
        return vidAlm;
    }

    public void setVidAlm(Integer vidAlm) {
        this.vidAlm = vidAlm;
    }

    public String getProtoVer() {
        return protoVer;
    }

    public void setProtoVer(String protoVer) {
        this.protoVer = protoVer;
    }

    public String getLastActive() {
        return lastActive;
    }

    public void setLastActive(long lastActiveEpochMillis) {
        this.lastActive = String.valueOf(lastActiveEpochMillis);
    }

    public void setLastActive(String lastActiveEpochMillis) {
        this.lastActive = lastActiveEpochMillis;
    }

    public long getTrkCnt() {
        return trkCnt;
    }

    public void setTrkCnt(long trkCnt) {
        this.trkCnt = trkCnt;
    }

    public Boolean getAcc() {
        return acc;
    }

    public void setAcc(Boolean acc) {
        this.acc = acc;
    }

    public Float getSpd() {
        return spd;
    }

    public void setSpd(Float spd) {
        this.spd = spd;
    }

    /**
     * The latest track is received in this connection.
     *
     * @return latest track is received in this connection.
     */
    public Trk getLatestTrk() {
        return latestTrk;
    }

    public void setLatestTrk(Trk latestTrk) {
        this.latestTrk = latestTrk;
        if (latestTrk != null) {
            this.acc = latestTrk.stTestAccOn();
            this.spd = latestTrk.getSpd();
            this.vidAlm = latestTrk.getVidAlm();
        }
    }

    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    public void assign(TermConnState src) {
        this.appId = src.appId;
        this.simNo = src.simNo;
        this.connTimes = src.connTimes;
        this.connAt = src.connAt;
        this.protoVer = src.protoVer;
        this.lastActive = src.lastActive;
        this.trkCnt = src.trkCnt;
        this.acc = src.acc;
        this.spd = src.spd;
        this.vidAlm = src.vidAlm;
        if (src.latestTrk != null)
            this.latestTrk = src.latestTrk.clone();
        else
            this.latestTrk = null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TermConnState.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("connTimes=" + connTimes)
                .add("connAt=" + connAt)
                .add("protoVer=" + protoVer)
                .add("lastActive=" + lastActive)
                .add("trkCnt=" + trkCnt)
                .add("acc=" + acc)
                .add("spd=" + spd)
                .add("vidAlm=" + vidAlm)
                .add("latestTrk=" + latestTrk)
                .toString();
    }

    @Override
    public TermConnState clone() {
        TermConnState r = new TermConnState();
        r.assign(this);
        return r;
    }
}
