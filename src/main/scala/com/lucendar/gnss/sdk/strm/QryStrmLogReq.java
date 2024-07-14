package com.lucendar.gnss.sdk.strm;

import com.lucendar.common.utils.DateTimeUtils;
import com.lucendar.gnss.sdk.types.PagedQuery;

import java.util.StringJoiner;

/**
 * 查询流媒体日志请求
 */
public class QryStrmLogReq extends PagedQuery {
    private String startTime;
    private String endTime;
    private String simNo;
    private Integer chanId;
    private Boolean live;
    private String evtTyp;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long startTime() {
        return DateTimeUtils.BeijingConv.strToMillis(startTime);
    }

    public void startTime(Long startTime) {
        this.startTime = DateTimeUtils.BeijingConv.millisToStrBoxed(startTime);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long endTime() {
        return DateTimeUtils.BeijingConv.strToMillis(endTime);
    }

    void endTime(Long endTime) {
        this.endTime = DateTimeUtils.BeijingConv.millisToStrBoxed(endTime);
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Integer getChanId() {
        return chanId;
    }

    public void setChanId(Integer chanId) {
        this.chanId = chanId;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public String getEvtTyp() {
        return evtTyp;
    }

    public void setEvtTyp(String evtTyp) {
        this.evtTyp = evtTyp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmLogReq.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("live=" + live)
                .add("evtTyp='" + evtTyp + "'")
                .toString();
    }
}
