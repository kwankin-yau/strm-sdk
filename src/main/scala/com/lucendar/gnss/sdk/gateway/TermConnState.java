/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.gateway;

import java.util.StringJoiner;

import org.springframework.lang.Nullable;

import com.lucendar.strm.common.StreamingApi;

import info.gratour.jt808common.protocol.msg.types.trk.Trk;

/**
 * 终端状态
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
     * <p>
     * 能是非 jt808 终端，所以 protoVer 为字符串
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
     * 最近的轨迹
     */
    @Nullable
    private Trk latestTrk;

    /**
     * 获取所属 appId
     * @return 所属 appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置所属 appId
     * @param appId 所属 appId
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
     * 获取终端在服务启动后连接到服务的次数
     * @return 连接次数
     */
    public long getConnTimes() {
        return connTimes;
    }

    /**
     * 设置终端在服务启动后连接到服务的次数
     * @param connTimes 连接次数
     */
    public void setConnTimes(long connTimes) {
        this.connTimes = connTimes;
    }

    /**
     * 获取终端最后连接时间
     * @return 最后连接时间, 格式: yyyy-MM-dd HH:mm:ss, 北京时间
     */
    public String getConnAt() {
        return connAt;
    }

    /**
     * 设置终端最后连接时间
     * @param connAtEpochMillis 最后连接时间, epoch millis
     */
    public void setConnAt(long connAtEpochMillis) {
        this.connAt = String.valueOf(connAtEpochMillis);
    }

    /**
     * 设置终端最后连接时间
     * @param connAt 最后连接时间, 格式: yyyy-MM-dd HH:mm:ss, 北京时间
     */
    public void setConnAt(String connAt) {
        this.connAt = connAt;
    }

    /**
     * 获取视频报警状态字
     * @return 视频报警状态字
     */
    public Integer getVidAlm() {
        return vidAlm;
    }

    /**
     * 设置视频报警状态字
     * @param vidAlm 视频报警状态字
     */
    public void setVidAlm(Integer vidAlm) {
        this.vidAlm = vidAlm;
    }

    /**
     * 获取终端的协议版本，如 JT/T 808 协议的 `0`（2011/2013） 或 `1`（2019）
     * @return 终端的协议版本
     */
    public String getProtoVer() {
        return protoVer;
    }

    /**
     * 设置终端的协议版本
     * @param protoVer 终端的协议版本
     */
    public void setProtoVer(String protoVer) {
        this.protoVer = protoVer;
    }

    /**
     * 获取终端最后上传或应答时间
     * @return 最后上传或应答时间, 格式: yyyy-MM-dd HH:mm:ss, 北京时间
     */
    public String getLastActive() {
        return lastActive;
    }

    /**
     * 设置终端最后上传或应答时间
     * @param lastActiveEpochMillis 最后上传或应答时间, epoch millis
     */
    public void setLastActive(long lastActiveEpochMillis) {
        this.lastActive = String.valueOf(lastActiveEpochMillis);
    }

    /**
     * 设置终端最后上传或应答时间
     * @param lastActive 最后上传或应答时间, 格式: yyyy-MM-dd HH:mm:ss, 北京时间
     */
    public void setLastActive(String lastActive) {
        this.lastActive = lastActive;
    }

    /**
     * 获取连接期间上报的轨迹数
     * @return 连接期间上报的轨迹数
     */
    public long getTrkCnt() {
        return trkCnt;
    }

    /**
     * 设置连接期间上报的轨迹数
     * @param trkCnt 连接期间上报的轨迹数
     */
    public void setTrkCnt(long trkCnt) {
        this.trkCnt = trkCnt;
    }

    /**
     * 获取ACC状态
     * @return ACC状态
     */
    public Boolean getAcc() {
        return acc;
    }

    /**
     * 设置ACC状态
     * @param acc ACC状态
     */
    public void setAcc(Boolean acc) {
        this.acc = acc;
    }

    /**
     * 获取GPS速度
     * @return GPS速度
     */
    public Float getSpd() {
        return spd;
    }

    /**
     * 设置GPS速度
     * @param spd GPS速度
     */
    public void setSpd(Float spd) {
        this.spd = spd;
    }

    /**
     * 获取最近的轨迹
     * @return 最近的轨迹
     */
    public Trk getLatestTrk() {
        return latestTrk;
    }

    /**
     * 设置最近的轨迹
     * @param latestTrk 最近的轨迹
     */
    public void setLatestTrk(Trk latestTrk) {
        this.latestTrk = latestTrk;
        if (latestTrk != null) {
            this.acc = latestTrk.stTestAccOn();
            this.spd = latestTrk.getSpd();
            this.vidAlm = latestTrk.getVidAlm();
        }
    }

    /**
     * 获取所属 appId
     * @return 所属 appId
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 将另一个 TermConnState 对象的值赋给当前对象
     * @param src 源 TermConnState 对象
     */
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
