package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

public class StrmReportReq implements StrmMsg {
    private boolean withServerStat;

    public boolean isWithServerStat() {
        return withServerStat;
    }

    public void setWithServerStat(boolean withServerStat) {
        this.withServerStat = withServerStat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmReportReq.class.getSimpleName() + "[", "]")
                .add("withServerStat=" + withServerStat)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__StrmReportReq;
    }
}

