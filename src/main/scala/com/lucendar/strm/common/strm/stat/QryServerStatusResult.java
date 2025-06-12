package com.lucendar.strm.common.strm.stat;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 查询服务器状态结果
 */
public class QryServerStatusResult {
    private String instId;
    private long rptTm;
    private String error;

    private StrmServerStat sysStat;
    private StrmPerfStat perfStat;
    private StrmStatus[] strms;

    /**
     * 构造函数
     */
    public QryServerStatusResult() {
    }

    /**
     * 构造函数
     * @param instId 实例ID
     * @param rptTm 报告时间, epoch millis
     * @param error 错误信息
     * @param sysStat 系统状态
     * @param perfStat 性能统计
     * @param strms 流状态
     */
    public QryServerStatusResult(
            String instId,
            long rptTm,
            String error,
            StrmServerStat sysStat,
            StrmPerfStat perfStat,
            StrmStatus[] strms) {
        this.instId = instId;
        this.rptTm = rptTm;
        this.error = error;
        this.sysStat = sysStat;
        this.perfStat = perfStat;
        this.strms = strms;
    }

    /**
     * 获取实例ID
     * @return 实例ID
     */
    public String getInstId() {
        return instId;
    }

    /**
     * 设置实例ID
     * @param instId 实例ID
     */
    public void setInstId(String instId) {
        this.instId = instId;
    }

    /**
     * 获取报告时间, epoch millis
     * @return 报告时间, epoch millis
     */
    public long getRptTm() {
        return rptTm;
    }

    /**
     * 设置报告时间, epoch millis
     * @param rptTm 报告时间, epoch millis
     */
    public void setRptTm(long rptTm) {
        this.rptTm = rptTm;
    }

    /**
     * 获取错误信息
     * @return 错误信息
     */
    public String getError() {
        return error;
    }

    /**
     * 设置错误信息
     * @param error 错误信息
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 获取系统状态
     * @return 系统状态
     */
    public StrmServerStat getSysStat() {
        return sysStat;
    }

    /**
     * 设置系统状态
     * @param sysStat 系统状态
     */
    public void setSysStat(StrmServerStat sysStat) {
        this.sysStat = sysStat;
    }

    /**
     * 获取性能统计
     * @return 性能统计
     */
    public StrmPerfStat getPerfStat() {
        return perfStat;
    }

    /**
     * 设置性能统计
     * @param perfStat 性能统计
     */
    public void setPerfStat(StrmPerfStat perfStat) {
        this.perfStat = perfStat;
    }

    /**
     * 获取流状态
     * @return 流状态
     */
    public StrmStatus[] getStrms() {
        return strms;
    }

    /**
     * 设置流状态
     * @param strms 流状态
     */
    public void setStrms(StrmStatus[] strms) {
        this.strms = strms;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryServerStatusResult.class.getSimpleName() + "[", "]")
                .add("instId='" + instId + "'")
                .add("rptTm=" + rptTm)
                .add("error='" + error + "'")
                .add("sysStat=" + sysStat)
                .add("perfStat=" + perfStat)
                .add("strms=" + Arrays.toString(strms))
                .toString();
    }
}
