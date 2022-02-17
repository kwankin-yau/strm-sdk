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
 * Streaming Activities in Time Segment
 */
public class StrmActSeg {

    private LocalDate date;
    private long startTm;
    private long endTm;
    private int activities;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getStartTm() {
        return startTm;
    }

    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    public long getEndTm() {
        return endTm;
    }

    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    public int getActivities() {
        return activities;
    }

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
