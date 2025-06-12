/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 流媒体活动统计
 * Streaming activities statistics
 */
public class StrmStat {

    private LocalDate date;
    private int liveAv;
    private int liveA;
    private int liveV;
    private int liveTalk;
    private int replay;
    private int successPeak;

    /**
     * 获取统计日期
     * @return 统计日期
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * 设置统计日期
     * @param date 统计日期
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * 获取成功播放的实时音视频请求数
     * @return 成功播放的实时音视频请求数
     */
    public int getLiveAv() {
        return liveAv;
    }

    /**
     * 设置成功播放的实时音视频请求数
     * @param liveAv 成功播放的实时音视频请求数
     */
    public void setLiveAv(int liveAv) {
        this.liveAv = liveAv;
    }

    /**
     * 增加成功播放的实时音视频请求数
     */
    public void incLiveAv() {
        this.liveAv += 1;
    }

    /**
     * 获取成功播放的实时音频请求数
     * @return 成功播放的实时音频请求数
     */
    public int getLiveA() {
        return liveA;
    }

    /**
     * 设置成功播放的实时音频请求数
     * @param liveA 成功播放的实时音频请求数
     */
    public void setLiveA(int liveA) {
        this.liveA = liveA;
    }

    /**
     * 增加成功播放的实时音频请求数
     */
    public void incLiveA() {
        this.liveA += 1;
    }

    /**
     * 获取成功播放的实时视频请求数
     * @return 成功播放的实时视频请求数
     */
    public int getLiveV() {
        return liveV;
    }

    /**
     * 设置成功播放的实时视频请求数
     * @param liveV 成功播放的实时视频请求数
     */
    public void setLiveV(int liveV) {
        this.liveV = liveV;
    }

    /**
     * 增加成功播放的实时视频请求数
     */
    public void incLiveV() {
        this.liveV += 1;
    }

    /**
     * 获取成功播放的对讲请求数
     * @return 成功播放的对讲请求数
     */
    public int getLiveTalk() {
        return liveTalk;
    }

    /**
     * 设置成功播放的对讲请求数
     * @param liveTalk 成功播放的对讲请求数
     */
    public void setLiveTalk(int liveTalk) {
        this.liveTalk = liveTalk;
    }

    /**
     * 增加成功播放的对讲请求数
     */
    public void incLiveTalk() {
        this.liveTalk += 1;
    }

    /**
     * 获取成功播放的回放请求数
     * @return 成功播放的回放请求数
     */
    public int getReplay() {
        return replay;
    }

    /**
     * 设置成功播放的回放请求数
     * @param replay 成功播放的回放请求数
     */
    public void setReplay(int replay) {
        this.replay = replay;
    }

    /**
     * 增加成功播放的回放请求数
     */
    public void incReplay() {
        this.replay += 1;
    }

    /**
     * 获取成功播放的峰值
     * @return 成功播放的峰值
     */
    public int getSuccessPeak() {
        return successPeak;
    }

    /**
     * 设置成功播放的峰值
     * @param successPeak 成功播放的峰值
     */
    public void setSuccessPeak(int successPeak) {
        this.successPeak = successPeak;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmStat.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("liveAv=" + liveAv)
                .add("liveA=" + liveA)
                .add("liveV=" + liveV)
                .add("liveTalk=" + liveTalk)
                .add("replay=" + replay)
                .add("successPeak=" + successPeak)
                .toString();
    }
}
