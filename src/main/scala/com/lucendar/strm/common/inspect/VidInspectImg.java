package com.lucendar.strm.common.inspect;

import java.util.StringJoiner;

/**
 * 巡检抓拍截图文件
 */
public class VidInspectImg {

    private String taskId;
    private String instId;
    private String appId;
    private String simNo;
    private int chan;
    private String reqTm;
    private String createTm;
    private String path;
    private Integer sz;

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
     * 取通道ID
     * @return 通道ID
     */
    public int getChan() {
        return chan;
    }

    /**
     * 设置通道ID
     * @param chan 通道ID
     */
    public void setChan(int chan) {
        this.chan = chan;
    }

    /**
     * 取任务的请求时间
     * @return 任务的请求时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public String getReqTm() {
        return reqTm;
    }

    /**
     * 设置任务的请求时间
     * @param reqTm 任务的请求时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取截图创建时间，仅当截图文件成功生成时有值
     * @return 截图创建时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public String getCreateTm() {
        return createTm;
    }

    /**
     * 设置截图创建时间
     * @param createTm 截图创建时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public void setCreateTm(String createTm) {
        this.createTm = createTm;
    }

    /**
     * 取截图的文件路径或下载URL，仅当截图文件成功生成时有值
     * @return 截图的文件路径或下载URL
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置截图的文件路径或下载URL
     * @param path 截图的文件路径或下载URL
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取文件大小，仅当截图文件成功生成时有值
     * @return 文件大小
     */
    public Integer getSz() {
        return sz;
    }

    /**
     * 设置文件大小
     * @param sz 文件大小
     */
    public void setSz(Integer sz) {
        this.sz = sz;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VidInspectImg.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("instId='" + instId + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("createTm=" + createTm)
                .add("path='" + path + "'")
                .add("sz=" + sz)
                .toString();
    }
}
