package com.lucendar.gnss.sdk.almatt;

import java.util.StringJoiner;

/**
 * 查询提取主动安全附件任务日志
 */
public class QryFetchAlmAttLogReq {
    private String taskId;
    private String almNo;
    private String simNo;
    private String evtTmStart;
    private String evtTmEnd;
    private Integer __page;
    private Integer __limit;

    /**
     * 取任务ID
     *
     * @return 任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     *
     * @param taskId 任务ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 取报警标识号(HEX)
     *
     * @return 报警标识号(HEX)
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警标识号(HEX)
     *
     * @param almNo 报警标识号(HEX)
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取日志事件时间范围的开始时间
     *
     * @return 日志事件时间范围的开始时间
     */
    public String getEvtTmStart() {
        return evtTmStart;
    }

    /**
     * 设置日志事件时间范围的开始时间
     *
     * @param evtTmStart 日志事件时间范围的开始时间
     */
    public void setEvtTmStart(String evtTmStart) {
        this.evtTmStart = evtTmStart;
    }

    /**
     * 取日志事件时间范围的结束时间
     *
     * @return 日志事件时间范围的结束时间
     */
    public String getEvtTmEnd() {
        return evtTmEnd;
    }

    /**
     * 设置日志事件时间范围的结束时间
     *
     * @param evtTmEnd 日志事件时间范围的结束时间
     */
    public void setEvtTmEnd(String evtTmEnd) {
        this.evtTmEnd = evtTmEnd;
    }

    /**
     * 取分页的页号
     *
     * @return 分页的页号
     */
    public Integer get__page() {
        return __page;
    }

    /**
     * 设置分页的页号
     *
     * @param __page 分页的页号
     */
    public void set__page(Integer __page) {
        this.__page = __page;
    }

    /**
     * 取分页的每页记录数
     *
     * @return 分页的每页记录数
     */
    public Integer get__limit() {
        return __limit;
    }

    /**
     * 设置分页的每页记录数
     *
     * @param __limit 分页的每页记录数
     */
    public void set__limit(Integer __limit) {
        this.__limit = __limit;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryFetchAlmAttLogReq.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("almNo='" + almNo + "'")
                .add("simNo='" + simNo + "'")
                .add("evtTmStart='" + evtTmStart + "'")
                .add("evtTmEnd='" + evtTmEnd + "'")
                .add("__page=" + __page)
                .add("__limit=" + __limit)
                .toString();
    }
}
