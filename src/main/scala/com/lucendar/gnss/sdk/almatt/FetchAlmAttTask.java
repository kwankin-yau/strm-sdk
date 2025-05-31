package com.lucendar.gnss.sdk.almatt;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.msg.types.AdasAlmNo;

/**
 * 提取主动安全附件任务
 */
public class FetchAlmAttTask implements Cloneable {

    /**
     * 任务状态：执行中
     */
    public static final int STATE__EXECUTING = 0;

    /**
     * 任务状态：成功
     */
    public static final int STATE__SUCCESS = 1;

    /**
     * 任务状态：排队中
     */
    public static final int STATE__QUEUED = 2;

    /**
     * 任务状态：重试次数过多，任务已终止
     */
    public static final int STATE__TOO_MANY_RETRIES = -1;

    /**
     * 任务状态：由系统取消，任务已终止
     */
    public static final int STATE__SYSTEM_CANCELLED = -2;

    /**
     * 任务状态：由用户取消，任务已终止
     */
    public static final int STATE__USER_CANCELLED = -3;

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
     * 报警时间, epoch millis
     * 
     * @since 4.0.2
     */
    private Long tm1;

    private int fileCount;
    private int recvFileCount;
    private long reqTm;
    private Long endTm;
    private int state;
    private int retryTimes;

    /**
     * 构造函数
     */
    public FetchAlmAttTask() {
    }

    /**
     * 构造函数
     * @param req 提取主动安全附件请求
     * @param taskId 任务ID
     * @param tm1 报警时间, epoch millis
     */
    public FetchAlmAttTask(FetchAlmAttReq req, String taskId, Long tm1) {
        this.taskId = taskId;
        this.almNo = req.getAlmNo();
        this.simNo = req.getSimNo();
        this.almTyp = req.getAlmTyp();
        this.almLvl = req.getAlmLvl();
        this.tm1 = tm1;
        AdasAlmNo adasAlmNo = AdasAlmNo.decodeFromHex(req.getAlmNo());
        this.fileCount = adasAlmNo.getAttFileCount();
        this.recvFileCount = 0;
        this.reqTm = System.currentTimeMillis();
        this.endTm = null;
        this.state = STATE__EXECUTING;
        this.retryTimes = 0;
    }

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
     * 取报警标识号 (HEX)
     *
     * @return 报警标识号(HEX)
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警标识号 (HEX)
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
     * 取报警时间, epoch millis
     * 
     * @return 报警时间, epoch millis
     * 
     * @since 4.0.2
     */
    public Long getTm1() {
        return tm1;
    }

    /**
     * 设置报警时间, epoch millis
     * 
     * @param tm1 报警时间, epoch millis
     * 
     * @since 4.0.2
     */
    public void setTm1(Long tm1) {
        this.tm1 = tm1;
    }

    /**
     * 取报警包含的文件数量
     *
     * @return 报警包含的文件数量
     */
    public int getFileCount() {
        return fileCount;
    }

    /**
     * 设置报警包含的文件数量
     *
     * @param fileCount 报警包含的文件数量
     */
    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    /**
     * 取已经成功接收的文件数
     *
     * @return 已经成功接收的文件数
     */
    public int getRecvFileCount() {
        return recvFileCount;
    }

    /**
     * 设置已经成功接收的文件数
     *
     * @param recvFileCount 已经成功接收的文件数
     */
    public void setRecvFileCount(int recvFileCount) {
        this.recvFileCount = recvFileCount;
    }

    /**
     * 增加已经成功接收的文件数
     *
     * @return 当前对象
     */
    public FetchAlmAttTask incRecvFileCount() {
        recvFileCount += 1;
        return this;
    }

    /**
     * 取任务的开始时间
     *
     * @return 任务的开始时间, epoch millis
     */
    public long getReqTm() {
        return reqTm;
    }

    /**
     * 设置任务的开始时间
     *
     * @param reqTm 任务的开始时间, epoch millis
     */
    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取任务的结束时间
     *
     * @return 任务的结束时间， 未结束时为 null
     */
    public Long getEndTm() {
        return endTm;
    }

    /**
     * 设置任务的结束时间， 未结束时为 null
     *
     * @param endTm 任务的结束时间， 未结束时为 null
     */
    public void setEndTm(Long endTm) {
        this.endTm = endTm;
    }

    /**
     * 取任务的状态。为 STATE__xxx 系列常量之一
     *
     * @return 任务的状态。为 STATE__xxx 系列常量之一
     */
    public int getState() {
        return state;
    }

    /**
     * 设置任务的状态。为 STATE__xxx 系列常量之一
     *
     * @param state 任务的状态。为 STATE__xxx 系列常量之一
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * 取重试次数
     *
     * @return 重试次数
     */
    public int getRetryTimes() {
        return retryTimes;
    }

    /**
     * 设置重试次数
     *
     * @param retryTimes 重试次数
     */
    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    /**
     * 增加重试次数
     *
     * @return 当前对象
     */
    public FetchAlmAttTask incRetryTimes() {
        retryTimes += 1;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FetchAlmAttTask.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("almNo='" + almNo + "'")
                .add("simNo='" + simNo + "'")
                .add("almTyp='" + almTyp + "'")
                .add("almLvl=" + almLvl)
                .add("tm1=" + tm1)
                .add("fileCount=" + fileCount)
                .add("recvFileCount=" + recvFileCount)
                .add("reqTm=" + reqTm)
                .add("endTm=" + endTm)
                .add("state=" + state)
                .add("retryTimes=" + retryTimes)
                .toString();
    }

    @Override
    public FetchAlmAttTask clone() {
        try {
            return (FetchAlmAttTask) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从任务信息创建提取附件请求
     * @return 提取附件请求
     */
    public FetchAlmAttReq toReq() {
        return new FetchAlmAttReq(simNo, almNo, almTyp, almLvl);
    }

    /**
     * 判断任务状态是否是一个结束态
     *
     * @return 是否是一个结束态
     */
    public boolean isEndingState() {
        return state != STATE__EXECUTING && state != STATE__QUEUED;
    }
}
