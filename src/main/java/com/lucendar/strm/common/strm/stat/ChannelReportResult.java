package com.lucendar.strm.common.strm.stat;

import java.util.Arrays;
import java.util.StringJoiner;

public class ChannelReportResult {
    private String instanceId;
    private long reportTm;
    private String error;

    private StrmServerStat serverStat;
    private long recvFromTerm1Minute;
    private int channelCount;
    private ChannelStat[] channels;

    public ChannelReportResult() {
    }

    public ChannelReportResult(
            String instanceId,
            long reportTm,
            String error,
            StrmServerStat serverStat,
            long recvFromTerm1Minute,
            int channelCount,
            ChannelStat[] channels) {
        this.instanceId = instanceId;
        this.reportTm = reportTm;
        this.error = error;
        this.serverStat = serverStat;
        this.recvFromTerm1Minute = recvFromTerm1Minute;
        this.channelCount = channelCount;
        this.channels = channels;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public long getReportTm() {
        return reportTm;
    }

    public void setReportTm(long reportTm) {
        this.reportTm = reportTm;
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

    public long getRecvFromTerm1Minute() {
        return recvFromTerm1Minute;
    }

    public void setRecvFromTerm1Minute(long recvFromTerm1Minute) {
        this.recvFromTerm1Minute = recvFromTerm1Minute;
    }

    public int getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(int channelCount) {
        this.channelCount = channelCount;
    }

    public ChannelStat[] getChannels() {
        return channels;
    }

    public void setChannels(ChannelStat[] channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChannelReportResult.class.getSimpleName() + "[", "]")
                .add("instanceId='" + instanceId + "'")
                .add("reportTm=" + reportTm)
                .add("error='" + error + "'")
                .add("serverStat=" + serverStat)
                .add("recvFromTerm1Minute=" + recvFromTerm1Minute)
                .add("channelCount=" + channelCount)
                .add("channels=" + Arrays.toString(channels))
                .toString();
    }
}
