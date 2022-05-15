package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

public class QryServerStatResult {
    private String instanceId;
    private String reportTime;
    private String error;

    private StrmServerStat serverStat;

    public QryServerStatResult() {
    }

    public QryServerStatResult(String instanceId, String reportTime, String error, StrmServerStat serverStat) {
        this.instanceId = instanceId;
        this.reportTime = reportTime;
        this.error = error;
        this.serverStat = serverStat;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public StrmServerStat getServerStat() {
        return serverStat;
    }

    public void setServerStat(StrmServerStat serverStat) {
        this.serverStat = serverStat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryServerStatResult.class.getSimpleName() + "[", "]")
                .add("instanceId='" + instanceId + "'")
                .add("reportTime='" + reportTime + "'")
                .add("error='" + error + "'")
                .add("serverStat=" + serverStat)
                .toString();
    }
}
