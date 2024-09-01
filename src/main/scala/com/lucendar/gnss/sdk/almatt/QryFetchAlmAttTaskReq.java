package com.lucendar.gnss.sdk.almatt;

import java.util.StringJoiner;

/**
 * 查询提取主动安全附件任务
 */
public class QryFetchAlmAttTaskReq {

    private String taskId;
    private String almNo;
    private String simNo;
    private String reqTmStart;
    private String reqTmEnd;
    private Integer __page;
    private Integer __limit;

    /**
     * 取提取任务ID
     *
     * @return 提取任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     *
     * @param taskId 提取任务ID
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
     * 取任务启动时间范围的开始时间
     *
     * @return 任务启动时间范围的开始时间
     */
    public String getReqTmStart() {
        return reqTmStart;
    }

    /**
     * 设置任务启动时间范围的开始时间
     *
     * @param reqTmStart 任务启动时间范围的开始时间
     */
    public void setReqTmStart(String reqTmStart) {
        this.reqTmStart = reqTmStart;
    }

    /**
     * 取任务启动时间范围的结束时间
     *
     * @return 任务启动时间范围的结束时间
     */
    public String getReqTmEnd() {
        return reqTmEnd;
    }

    /**
     * 设置任务启动时间范围的结束时间
     *
     * @param reqTmEnd 任务启动时间范围的结束时间
     */
    public void setReqTmEnd(String reqTmEnd) {
        this.reqTmEnd = reqTmEnd;
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
        return new StringJoiner(", ", QryFetchAlmAttTaskReq.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("almNo='" + almNo + "'")
                .add("simNo='" + simNo + "'")
                .add("reqTmStart='" + reqTmStart + "'")
                .add("reqTmEnd='" + reqTmEnd + "'")
                .add("__page=" + __page)
                .add("__limit=" + __limit)
                .toString();
    }
}
