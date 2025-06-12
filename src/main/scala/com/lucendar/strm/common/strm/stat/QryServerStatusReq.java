package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 查询服务器状态请求
 */
public class QryServerStatusReq implements StrmMsg {

    private boolean sysResStat;
    private boolean perfStat;

    /**
     * 取是否查询系统资源状态
     * @return 如果为true, 则查询系统资源状态, 否则不查询
     */
    public boolean isSysResStat() {
        return sysResStat;
    }

    /**
     * 设置是否查询系统资源状态
     * @param sysResStat 如果为true, 则查询系统资源状态, 否则不查询
     */
    public void setSysResStat(boolean sysResStat) {
        this.sysResStat = sysResStat;
    }

    /**
     * 取是否查询性能统计
     * @return 如果为true, 则查询性能统计, 否则不查询
     */
    public boolean isPerfStat() {
        return perfStat;
    }

    /**
     * 设置是否查询性能统计
     * @param perfStat 如果为true, 则查询性能统计, 否则不查询
     */
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

