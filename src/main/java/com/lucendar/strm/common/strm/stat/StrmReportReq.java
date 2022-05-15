package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

public class StrmReportReq {
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
}

