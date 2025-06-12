/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

import com.lucendar.strm.common.strm.StrmStatSampling;

/**
 * 流媒体性能统计
 * Stream performance statistics
 */
public class StrmPerfStat {

    private boolean metricEnabled;
    private Long recvFromTerm1Min;
    private StrmStatSampling audioProcDelay;
    private StrmStatSampling videoProcDelay;
    private StrmStatSampling flvProcDelay;

    /**
     * 是否启用性能监控日志
     * @return 是否启用性能监控日志
     */
    public boolean isMetricEnabled() {
        return metricEnabled;
    }

    /**
     * 设置是否启用性能监控日志
     * @param metricEnabled 是否启用性能监控日志
     */
    public void setMetricEnabled(boolean metricEnabled) {
        this.metricEnabled = metricEnabled;
    }

    /**
     * 获取最近1分钟从终端接收到的数据量
     * @return 最近1分钟从终端接收到的数据量
     */
    public Long getRecvFromTerm1Min() {
        return recvFromTerm1Min;
    }

    /**
     * 设置最近1分钟从终端接收到的数据量
     * @param recvFromTerm1Min 最近1分钟从终端接收到的数据量
     */
    public void setRecvFromTerm1Min(Long recvFromTerm1Min) {
        this.recvFromTerm1Min = recvFromTerm1Min;
    }

    /**
     * 获取音频处理延迟
     * @return 音频处理延迟
     */
    public StrmStatSampling getAudioProcDelay() {
        return audioProcDelay;
    }

    /**
     * 设置音频处理延迟
     * @param audioProcDelay 音频处理延迟
     */
    public void setAudioProcDelay(StrmStatSampling audioProcDelay) {
        this.audioProcDelay = audioProcDelay;
    }

    /**
     * 获取视频处理延迟
     * @return 视频处理延迟
     */
    public StrmStatSampling getVideoProcDelay() {
        return videoProcDelay;
    }

    /**
     * 设置视频处理延迟
     * @param videoProcDelay 视频处理延迟
     */
    public void setVideoProcDelay(StrmStatSampling videoProcDelay) {
        this.videoProcDelay = videoProcDelay;
    }

    /**
     * 获取FLV处理延迟
     * @return FLV处理延迟
     */
    public StrmStatSampling getFlvProcDelay() {
        return flvProcDelay;
    }

    /**
     * 设置FLV处理延迟
     * @param flvProcDelay FLV处理延迟
     */
    public void setFlvProcDelay(StrmStatSampling flvProcDelay) {
        this.flvProcDelay = flvProcDelay;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmPerfStat.class.getSimpleName() + "[", "]")
                .add("metricEnabled=" + metricEnabled)
                .add("recvFromTerm1Min=" + recvFromTerm1Min)
                .add("audioProcDelay=" + audioProcDelay)
                .add("videoProcDelay=" + videoProcDelay)
                .add("flvProcDelay=" + flvProcDelay)
                .toString();
    }
}
