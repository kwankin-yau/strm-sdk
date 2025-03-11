package com.lucendar.gnss.sdk.strm;

import java.util.StringJoiner;

import com.lucendar.common.utils.DateTimeUtils;
import com.lucendar.gnss.sdk.types.PagedQuery;

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

    /**
     * 获取开始时间
     * @return 开始时间, 格式: yyyy-MM-dd HH:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     * @param startTime 开始时间, 格式: yyyy-MM-dd HH:mm:ss
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取开始时间, epoch millis
     * @return 开始时间, epoch millis
     */
    public Long startTime() {
        return DateTimeUtils.BeijingConv.strToMillis(startTime);
    }

    /**
     * 设置开始时间, epoch millis
     * @param startTime 开始时间, epoch millis
     */
    public void startTime(Long startTime) {
        this.startTime = DateTimeUtils.BeijingConv.millisToStrBoxed(startTime);
    }

    /**
     * 获取结束时间
     * @return 结束时间, 格式: yyyy-MM-dd HH:mm:ss
     */ 
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     * @param endTime 结束时间, 格式: yyyy-MM-dd HH:mm:ss
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取结束时间, epoch millis
     * @return 结束时间, epoch millis
     */
    public Long endTime() {
        return DateTimeUtils.BeijingConv.strToMillis(endTime);
    }

    /**
     * 设置结束时间, epoch millis
     * @param endTime 结束时间, epoch millis
     */
    public void endTime(Long endTime) {
        this.endTime = DateTimeUtils.BeijingConv.millisToStrBoxed(endTime);
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 获取通道ID
     * @return 通道ID
     */
    public Integer getChanId() {
        return chanId;
    }

    /**
     * 设置通道ID
     * @param chanId 通道ID
     */
    public void setChanId(Integer chanId) {
        this.chanId = chanId;
    }

    /**
     * 获取是否为实时流
     * @return 是否为实时流
     */
    public Boolean getLive() {
        return live;
    }

    /**
     * 设置是否为实时流
     * @param live 是否为实时流
     */
    public void setLive(Boolean live) {
        this.live = live;
    }

    /**
     * 获取事件类型
     * @return 事件类型
     */
    public String getEvtTyp() {
        return evtTyp;
    }

    /**
     * 设置事件类型
     * @param evtTyp 事件类型
     */
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
