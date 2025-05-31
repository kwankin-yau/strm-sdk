package com.lucendar.gnss.sdk.almatt;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 查询提取主动安全附件任务
 */
public class QryFetchAlmAttTaskReq {

    private String taskId;
    private String almNo;
    private String simNo;

    /**
     * 报警类型
     * 
     * @since 4.0.2
     */
    private String almTyp;

    /**
     * 报警级别
     * 
     * @since 4.0.2
     */
    private Integer almLvl;

    /**
     * 报警时间范围的开始时间
     * 
     * @since 4.0.2
     */
    private String tm1Start;

    /**
     * 报警时间范围的结束时间
     * 
     * @since 4.0.2
     */
    private String tm1End;

    private String reqTmStart;
    private String reqTmEnd;


    /**
     * 任务状态
     * 
     * @since 4.0.2
     */
    private List<Integer> states;

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
     * @param reqTmStart 任务启动时间范围的开始时间, 格式：yyyy-MM-dd HH:mm:ss
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
     * @param reqTmEnd 任务启动时间范围的结束时间, 格式：yyyy-MM-dd HH:mm:ss    
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

    /**
     * 取报警类型
     *
     * @return 报警类型
     * 
     * @since 4.0.2
     */
    public String getAlmTyp() {
        return almTyp;
    }

    /**
     * 设置报警类型
     *
     * @param almTyp 报警类型
     * 
     * @since 4.0.2
     */
    public void setAlmTyp(String almTyp) {
        this.almTyp = almTyp;
    }

    /**
     * 取报警级别
     *
     * @return 报警级别
     * 
     * @since 4.0.2
     */
    public Integer getAlmLvl() {
        return almLvl;
    }

    /**
     * 设置报警级别
     *
     * @param almLvl 报警级别
     * 
     * @since 4.0.2
     */
    public void setAlmLvl(Integer almLvl) {
        this.almLvl = almLvl;
    }

    /**
     * 取报警时间范围的开始时间
     *
     * @return 报警时间范围的开始时间
     * 
     * @since 4.0.2
     */
    public String getTm1Start() {
        return tm1Start;
    }

    /**
     * 设置报警时间范围的开始时间
     *
     * @param tm1Start 报警时间范围的开始时间, 格式：yyyy-MM-dd HH:mm:ss
     * 
     * @since 4.0.2
     */
    public void setTm1Start(String tm1Start) {
        this.tm1Start = tm1Start;
    }

    /**
     * 取报警时间范围的结束时间
     *
     * @return 报警时间范围的结束时间
     * 
     * @since 4.0.2
     */
    public String getTm1End() {
        return tm1End;
    }

    /**
     * 设置报警时间范围的结束时间
     *
     * @param tm1End 报警时间范围的结束时间, 格式：yyyy-MM-dd HH:mm:ss
     * 
     * @since 4.0.2
     */
    public void setTm1End(String tm1End) {
        this.tm1End = tm1End;
    }

    /**
     * 取任务状态
     *
     * @return 任务状态
     * 
     * @since 4.0.2
     */
    public List<Integer> getStates() {
        return states;
    }

    /**
     * 设置任务状态
     *
     * @param states 任务状态
     * 
     * @since 4.0.2
     */
    public void setStates(List<Integer> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryFetchAlmAttTaskReq.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("almNo='" + almNo + "'")
                .add("simNo='" + simNo + "'")
                .add("almTyp='" + almTyp + "'")
                .add("almLvl=" + almLvl)
                .add("tm1Start='" + tm1Start + "'")
                .add("tm1End='" + tm1End + "'")
                .add("reqTmStart='" + reqTmStart + "'")
                .add("reqTmEnd='" + reqTmEnd + "'")
                .add("states=" + (states != null ? states.stream().map(String::valueOf).collect(Collectors.joining(",")) : "null"))
                .add("__page=" + __page)
                .add("__limit=" + __limit)
                .toString();
    }
}
