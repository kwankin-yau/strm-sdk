package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

public class QryServerStatusReq implements StrmMsg {

    private boolean sysResStat;
    private boolean perfStat;

    public boolean isSysResStat() {
        return sysResStat;
    }

    public void setSysResStat(boolean sysResStat) {
        this.sysResStat = sysResStat;
    }

    public boolean isPerfStat() {
        return perfStat;
    }

    public void setPerfStat(boolean perfStat) {
        this.perfStat = perfStat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryServerStatusReq.class.getSimpleName() + "[", "]")
                .add("sysResStat=" + sysResStat)
                .add("perfStat=" + perfStat)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryServerStatusReq;
    }
}

