package com.lucendar.strm.common.strm.stat;

import java.util.Arrays;
import java.util.StringJoiner;

public class QryServerStatusResult {
    private String instId;
    private long rptTm;
    private String error;

    private StrmServerStat sysStat;
    private StrmPerfStat perfStat;
    private StrmStatus[] strms;

    public QryServerStatusResult() {
    }

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

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public long getRptTm() {
        return rptTm;
    }

    public void setRptTm(long rptTm) {
        this.rptTm = rptTm;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public StrmServerStat getSysStat() {
        return sysStat;
    }

    public void setSysStat(StrmServerStat sysStat) {
        this.sysStat = sysStat;
    }

    public StrmPerfStat getPerfStat() {
        return perfStat;
    }

    public void setPerfStat(StrmPerfStat perfStat) {
        this.perfStat = perfStat;
    }

    public StrmStatus[] getStrms() {
        return strms;
    }

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
