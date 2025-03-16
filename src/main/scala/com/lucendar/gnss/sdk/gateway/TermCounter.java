package com.lucendar.gnss.sdk.gateway;

import java.util.StringJoiner;

/**
 * 终端活动计数器
 */
public class TermCounter {

    /**
     * 终端识别号
     */
    private String simNo;

    /**
     * 本次连接会话上传的轨迹数
     */
    private long trkCnt;

    /**
     * 构造函数
     */
    public TermCounter() {
    }

    /**
     * 构造函数
     * @param simNo 终端识别号
     * @param trkCnt 本次连接会话上传的轨迹数
     */
    public TermCounter(String simNo, long trkCnt) {
        this.simNo = simNo;
        this.trkCnt = trkCnt;
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
     * 获取本次连接会话上传的轨迹数
     * @return 轨迹数
     */
    public long getTrkCnt() {
        return trkCnt;
    }

    /**
     * 设置本次连接会话上传的轨迹数
     * @param trkCnt 轨迹数
     */
    public void setTrkCnt(long trkCnt) {
        this.trkCnt = trkCnt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TermCounter.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("trkCnt=" + trkCnt)
                .toString();
    }
}
