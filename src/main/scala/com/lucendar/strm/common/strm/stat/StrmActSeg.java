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
 * 流活动时间段
 * Streaming Activities in Time Segment
 */
public class StrmActSeg {

    private LocalDate date;
    private long startTm;
    private long endTm;
    private int activities;

    /**
     * 获取日期
     * @return 日期
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * 设置日期
     * @param date 日期
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * 获取开始时间
     * @return 开始时间, epoch millis
     */
    public long getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间
     * @param startTm 开始时间, epoch millis
     */
    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    /**
     * 获取结束时间
     * @return 结束时间, epoch millis
     */
    public long getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间
     * @param endTm 结束时间, epoch millis
     */
    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    /**
     * 获取活动数
     * @return 活动数
     */
    public int getActivities() {
        return activities;
    }

    /**
     * 设置活动数
     * @param activities 活动数
     */
    public void setActivities(int activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmActSeg.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("activities=" + activities)
                .toString();
    }
}
