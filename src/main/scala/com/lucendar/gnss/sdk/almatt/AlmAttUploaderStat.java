package com.lucendar.gnss.sdk.almatt;

/**
 * 安全报警附件服务统计信息
 */
public class AlmAttUploaderStat {

    /**
     * 是否 leader
     */
    private boolean leader;

    /**
     * 最大重试次数
     */
    private int maxRetryTimes;

    /**
     * 最大任务执行时长（单位：秒，终端未能在此时间内上传完全部文件，将被服务重新调度任务，如果任务重试次数超过，`maxRetryTimes`，任务失败）
     */
    private int retryDurationSeconds;

    /**
     * 最大同时执行的上传任务数，当接收到的热任务数超过此值时，任务排队
     */
    private int maxConcurrentUpload;

    /**
     * 最大的同时写入磁盘的文件数，超过此数值，文件被放弃写入
     */
    private int maxPendingFile;

    /**
     * 近15分钟的平均（总）流量（字节/秒）
     */
    private double trafficFifteenMinuteRate;

    /**
     * 当前排队等待执行的任务数
     */
    private int pending;

    /**
     * 当前执行中的任务数
     */
    private int executing;

    /**
     * 取是否是 leader
     * 
     * @return 是否是 leader
     */
    public boolean isLeader() {
        return leader;
    }

    /**
     * 设置是否是 leader
     * 
     * @param leader 是否是 leader
     */
    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    /**
     * 取最大重试次数
     * 
     * @return 最大重试次数
     */
    public int getMaxRetryTimes() {
        return maxRetryTimes;
    }

    /**
     * 设置最大重试次数
     * 
     * @param maxRetryTimes 最大重试次数
     */
    public void setMaxRetryTimes(int maxRetryTimes) {
        this.maxRetryTimes = maxRetryTimes;
    }

    /**
     * 取最大任务执行时长（秒）
     * 
     * @return 最大任务执行时长
     */
    public int getRetryDurationSeconds() {
        return retryDurationSeconds;
    }

    /**
     * 设置最大任务执行时长（秒）
     * 
     * @param retryDurationSeconds 最大任务执行时长
     */
    public void setRetryDurationSeconds(int retryDurationSeconds) {
        this.retryDurationSeconds = retryDurationSeconds;
    }

    /**
     * 取最大同时执行的上传任务数
     * 
     * @return 最大同时执行的上传任务数
     */
    public int getMaxConcurrentUpload() {
        return maxConcurrentUpload;
    }

    /**
     * 设置最大同时执行的上传任务数
     * 
     * @param maxConcurrentUpload 最大同时执行的上传任务数
     */
    public void setMaxConcurrentUpload(int maxConcurrentUpload) {
        this.maxConcurrentUpload = maxConcurrentUpload;
    }

    /**
     * 取最大同时写入磁盘的文件数
     * 
     * @return 最大同时写入磁盘的文件数
     */
    public int getMaxPendingFile() {
        return maxPendingFile;
    }

    /**
     * 设置最大同时写入磁盘的文件数
     * 
     * @param maxPendingFile 最大同时写入磁盘的文件数
     */
    public void setMaxPendingFile(int maxPendingFile) {
        this.maxPendingFile = maxPendingFile;
    }

    /**
     * 取近15分钟的平均（总）流量（字节/秒）
     * 
     * @return 近15分钟的平均（总）流量（字节/秒）
     */
    public double getTrafficFifteenMinuteRate() {
        return trafficFifteenMinuteRate;
    }

    /**
     * 设置近15分钟的平均（总）流量（字节/秒）
     * 
     * @param trafficFifteenMinuteRate 近15分钟的平均（总）流量（字节/秒）
     */
    public void setTrafficFifteenMinuteRate(double trafficFifteenMinuteRate) {
        this.trafficFifteenMinuteRate = trafficFifteenMinuteRate;
    }

    /**
     * 取当前排队等待执行的任务数
     * 
     * @return 当前排队等待执行的任务数
     */
    public int getPending() {
        return pending;
    }

    /**
     * 设置当前排队等待执行的任务数
     * 
     * @param pending 当前排队等待执行的任务数
     */
    public void setPending(int pending) {
        this.pending = pending;
    }

    /**
     * 取当前执行中的任务数
     * 
     * @return 当前执行中的任务数
     */
    public int getExecuting() {
        return executing;
    }

    /**
     * 设置当前执行中的任务数
     * 
     * @param executing 当前执行中的任务数
     */
    public void setExecuting(int executing) {
        this.executing = executing;
    }
}
