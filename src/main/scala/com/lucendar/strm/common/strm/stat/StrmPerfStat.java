/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.strm.StrmStatSampling;

import java.util.StringJoiner;

/**
 * Stream performance statistics
 */
public class StrmPerfStat {

    private boolean metricEnabled;
    private Long recvFromTerm1Min;
    private StrmStatSampling audioProcDelay;
    private StrmStatSampling videoProcDelay;
    private StrmStatSampling flvProcDelay;

    public boolean isMetricEnabled() {
        return metricEnabled;
    }

    public void setMetricEnabled(boolean metricEnabled) {
        this.metricEnabled = metricEnabled;
    }

    public Long getRecvFromTerm1Min() {
        return recvFromTerm1Min;
    }

    public void setRecvFromTerm1Min(Long recvFromTerm1Min) {
        this.recvFromTerm1Min = recvFromTerm1Min;
    }

    public StrmStatSampling getAudioProcDelay() {
        return audioProcDelay;
    }

    public void setAudioProcDelay(StrmStatSampling audioProcDelay) {
        this.audioProcDelay = audioProcDelay;
    }

    public StrmStatSampling getVideoProcDelay() {
        return videoProcDelay;
    }

    public void setVideoProcDelay(StrmStatSampling videoProcDelay) {
        this.videoProcDelay = videoProcDelay;
    }

    public StrmStatSampling getFlvProcDelay() {
        return flvProcDelay;
    }

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
