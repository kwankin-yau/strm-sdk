package com.lucendar.gnss.sdk.almatt;

import info.gratour.jt808common.protocol.msg.types.AdasAlmNo;

import java.util.StringJoiner;

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
     * 任务状态：重试次数过多，任务已终止
     */
    public static final int STATE__TOO_MANY_RETRIES = -1;

    private String taskId;
    private String almNo;
    private String simNo;
    private int fileCount;
    private int recvFileCount;
    private long reqTm;
    private Long endTm;
    private int state;
    private int retryTimes;

    public FetchAlmAttTask() {
    }

    public FetchAlmAttTask(FetchAlmAttReq req, String taskId) {
        this.taskId = taskId;
        this.almNo = req.getAlmNo();
        this.simNo = req.getSimNo();
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
}
