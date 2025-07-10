package com.lucendar.strm.common.inspect;

import java.util.StringJoiner;

/**
 * 巡检抓拍事件
 */
public class VidInspectEvt {

    /**
     * 事件类型: 任务创建
     */
    public static final String CREATED = "CREATED";

    /**
     * 事件类型: 指令已下发
     */
    public static final String CMD_SENT = "CMD_SENT";

    /**
     * 事件类型: 指令已应答（成功）
     */
    public static final String CMD_ACK = "CMD_ACK";

    /**
     * 事件类型: 指令已应答（失败）。出现这个事件后，最后还会有一个 `FAILED` 事件
     */
    public static final String CMD_FAILED = "CMD_FAILED";

    /**
     * 事件类型: 开始接收码流
     */
    public static final String RECOGNIZED = "RECOGNIZED";

    /**
     * 事件类型: 任务成功，已截图保存（结束态）
     */
    public static final String SUCCESS = "SUCCESS";

    /**
     * 事件类型: 任务失败
     */
    public static final String FAILED = "FAILED";

    private String id;

    private String instId;

    private String appId;

    private String taskId;

    private String simNo;

    private Integer chan;

    private long evtTm;

    private String evtTyp;

    private Integer ackCode;

    private String errMsg;

    private String path;

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
     * @return 通道 ID
     */
    public Integer getChan() {
        return chan;
    }

    /**
     * 设置通道 ID
     * @param chan 通道 ID
     */
    public void setChan(Integer chan) {
        this.chan = chan;
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
     * 取文件路径或下载URL
     * @return 文件路径或下载URL
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件路径或下载URL
     * @param path 文件路径或下载URL
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VidInspectEvt.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("instId='" + instId + "'")
                .add("appId='" + appId + "'")
                .add("taskId='" + taskId + "'")
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("evtTm=" + evtTm)
                .add("evtTyp='" + evtTyp + "'")
                .add("ackCode=" + ackCode)
                .add("errMsg='" + errMsg + "'")
                .add("path='" + path + "'")
                .toString();
    }
}
