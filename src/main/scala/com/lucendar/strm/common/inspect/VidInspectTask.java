package com.lucendar.strm.common.inspect;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 视频抓拍巡检任务
 */
public class VidInspectTask {

    private String taskId;
    private String instId;
    private String appId;
    private String simNo;
    private int[] channels;
    private String reqTm;
    private String endTm;
    private int successCount;

    private List<VidInspectChannelState> tasks;

    /**
     * 取任务ID
     * @return 任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     * @param taskId 任务ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 取媒体服务实例ID
     * @return 媒体服务实例ID
     */
    public String getInstId() {
        return instId;
    }

    /**
     * 设置媒体服务实例ID
     * @param instId 媒体服务实例ID
     */
    public void setInstId(String instId) {
        this.instId = instId;
    }

    /**
     * 取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取终端识别号
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
     * 取通道 ID 列表
     * @return 通道 ID 列表
     */
    public int[] getChannels() {
        return channels;
    }

    /**
     * 设置通道 ID 列表
     * @param channels 通道 ID 列表
     */
    public void setChannels(int[] channels) {
        this.channels = channels;
    }

    /**
     * 取任务创建时间
     * @return 任务创建时间，，格式：yyyy-MM-dd HH:MM:SS
     */
    public String getReqTm() {
        return reqTm;
    }

    /**
     * 设置任务创建时间
     * @param reqTm 任务创建时间，，格式：yyyy-MM-dd HH:MM:SS
     */
    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取任务结束时间
     * @return 任务结束时间，格式：yyyy-MM-dd HH:MM:SS，不为 `null` 表示任务组已经全部结束
     */
    public String getEndTm() {
        return endTm;
    }

    /**
     * 设置任务结束时间
     * @param endTm 任务结束时间，格式：yyyy-MM-dd HH:MM:SS，不为 `null` 表示任务组已经全部结束
     */
    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    /**
     * 取当前已成功的子任务数
     * @return 当前已成功的子任务数
     */
    public int getSuccessCount() {
        return successCount;
    }

    /**
     * 设置当前已成功的子任务数
     * @param successCount 当前已成功的子任务数
     */
    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    /**
     * 取任务列表
     * @return 任务列表
     */
    public List<VidInspectChannelState> getTasks() {
        return tasks;
    }

    /**
     * 设置任务列表
     * @param tasks 任务列表
     */
    public void setTasks(List<VidInspectChannelState> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VidInspectTask.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("instId='" + instId + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("channels=" + Arrays.toString(channels))
                .add("reqTm=" + reqTm)
                .add("endTm=" + endTm)
                .add("successCount=" + successCount)
                .add("tasks=" + (tasks != null ? tasks.stream().map(Objects::toString).collect(Collectors.joining(", ")) : "null"))
                .toString();
    }
}
