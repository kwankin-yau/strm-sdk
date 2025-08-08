package com.lucendar.strm.common.inspect;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 巡检抓拍事件
 */
public class VidInspectEvt {

    /**
     * 事件类型(任务事件): 任务创建成功
     */
    public static final String CREATED = "CREATED";

    /**
     * 事件类型(任务事件)：由于其他原因，任务创建失败，可检查 errMsg 以获得错误信息。注意，创建失败事件后无 `END` 事件
     */
    public static final String CREATE_FAILED = "CREATE_FAILED";

    /**
     * 事件类型(任务事件)：创建任务失败，当前执行任务数已经达到限制数。注意，创建失败事件后无 `END` 事件
     */
    public static final String TOO_MANY_REQUEST = "TOO_MANY_REQUEST";

    /**
     * 事件类型(通道执行事件): （通道）截图已经完成
     */
    public static final String CHANNEL_SUCCESS = "CHANNEL_SUCCESS";

    /**
     * 事件类型(通道执行事件): （通道）截图已经失败
     */
    public static final String CHANNEL_FAILED = "CHANNEL_FAILED";

    /**
     * 事件类型(任务事件): 任务已经结束
     */
    public static final String END = "END";

    private String id;

    private String instId;

    private String appId;

    private String taskId;

    private Integer taskState;

    private String simNo;

    private Integer chan;

    private int[] channels;

    private long evtTm;

    private String evtTyp;

    private Integer ackCode;

    private String errMsg;

    private String path;

    private String url;

    /**
     * 取事件 ID
     * @return 事件 ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置事件 ID
     * @param id 事件 ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取媒体服务实例 ID
     * @return 媒体服务实例 ID
     */
    public String getInstId() {
        return instId;
    }

    /**
     * 设置媒体服务实例 ID
     * @param instId 媒体服务实例 ID
     */
    public void setInstId(String instId) {
        this.instId = instId;
    }

    /**
     * 取应用 ID
     * @return 应用 ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用 ID
     * @param appId 应用 ID
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
     * 取通道 ID
     * @return 通道 ID。当事件类型为通道执行事件时，此属性才有效
     */
    public Integer getChan() {
        return chan;
    }

    /**
     * 设置通道 ID
     * @param chan 通道 ID。当事件类型为通道执行事件时，此属性才有效
     */
    public void setChan(Integer chan) {
        this.chan = chan;
    }

    /**
     * 取通道ID列表
     * @return 通道ID列表，。当事件类型为任务事件时，此属性才有效
     */
    public int[] getChannels() {
        return channels;
    }

    /**
     * 通道ID列表
     * @param channels 通道ID列表，。当事件类型为任务时，此属性才有效
     */
    public void setChannels(int[] channels) {
        this.channels = channels;
    }

    /**
     * 取任务 ID
     * @return 任务 ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务 ID
     * @param taskId 任务 ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 取事件发生时任务的状态，见 `VidInspectTask.STATE__xxx` 系列常量
     * @return 事件发生时任务的状态
     */
    public Integer getTaskState() {
        return taskState;
    }

    /**
     * 设置事件发生时任务的状态
     * @param taskState 事件发生时任务的状态
     */
    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    /**
     * 取事件时间, epoch-millis
     * @return 事件时间
     */
    public long getEvtTm() {
        return evtTm;
    }

    /**
     * 设置事件时间
     * @param evtTm 事件时间, epoch-millis
     */
    public void setEvtTm(long evtTm) {
        this.evtTm = evtTm;
    }

    /**
     * 取事件类型
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

    /**
     * 取应答码
     * @return 应答码
     */
    public Integer getAckCode() {
        return ackCode;
    }

    /**
     * 设置应答码
     * @param ackCode 应答码
     */
    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    /**
     * 取错误信息
     * @return 错误信息
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 设置错误信息
     * @param errMsg 错误信息
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    /**
     * 取文件路径
     * @return 文件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件路径
     * @param path 文件路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取下载URL
     * @return 下载URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置下载URL
     * @param url 下载URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VidInspectEvt.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("instId='" + instId + "'")
                .add("appId='" + appId + "'")
                .add("taskId='" + taskId + "'")
                .add("taskState=" + taskState)
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("channels=" + (channels != null ? Arrays.toString(channels) : "null"))
                .add("evtTm=" + evtTm)
                .add("evtTyp='" + evtTyp + "'")
                .add("ackCode=" + ackCode)
                .add("errMsg='" + errMsg + "'")
                .add("path='" + path + "'")
                .add("url='" + url + "'")
                .toString();
    }
}
