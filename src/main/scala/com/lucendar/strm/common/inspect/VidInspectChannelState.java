package com.lucendar.strm.common.inspect;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringJoiner;

/**
 * 巡检抓拍任务通道执行状态
 */
public class VidInspectChannelState implements Cloneable {

    /**
     * 通道任务状态：等待执行
     */
    public static final int STATE__WAIT_FOR_EXEC = 0;

    /**
     * 通道任务状态：执行中
     */
    public static final int STATE__EXECUTING = 1;

    /**
     * 通道任务状态：成功
     */
    public static final int STATE__SUCCESS = 2;

    /**
     * 通道任务状态：失败
     */
    public static final int STATE__FAILED = -1;

    /**
     * 通道任务状态：已取消
     */
    public static final int STATE__CANCELED = -2;

    /**
     * 获取资源包
     * @param locale 区域
     * @return 资源包
     */
    public static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle(
                "com.lucendar.gnss.sdk.inspect.vid-inspect",
                locale != null ? locale : Locale.getDefault()
        );
    }

    /**
     * 获取状态文本
     * @param state 任务状态代码，STATE__xxx 之一
     * @return 状态文本
     */
    public static String getStateText(int state) {
        String key;
        if (state >= 0)
            key = "vidInspectChannelState.state." + state;
        else
            key = "vidInspectChannelState.state._" + (-state);

        return resourceBundle(Locale.getDefault()).getString(key);
    }


    private String taskId;
    private int chan;
    private String endTm;
    private int state;
    private String path;
    private String url;
    private String createTm;
    private Integer sz;

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
     * 取通道 ID
     * @return 通道 ID
     */
    public int getChan() {
        return chan;
    }

    /**
     * 设置通道 ID
     * @param chan 通道 ID
     */
    public void setChan(int chan) {
        this.chan = chan;
    }

    /**
     * 取执行结束时间，仅当 `state` 为 `2` 或 `-1`, `-2` 时有效
     * @return 执行结束时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public String getEndTm() {
        return endTm;
    }

    /**
     * 设置执行结束时间
     * @param endTm 执行结束时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    /**
     * 取通道执行状态
     * @return 通道执行状态
     */
    public int getState() {
        return state;
    }

    /**
     * 设置通道执行状态
     * @param state 通道执行状态
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * 取截图的文件路径，仅当 `state` 为 `2` 时有效
     * @return 截图的文件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置截图的文件路径
     * @param path 截图的文件路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取截图文件的下载URL，仅当 `state` 为 `2` 时有效
     * @return 截图文件的下载URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置截图文件的下载URL
     * @param url 截图文件的下载URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 取截图文件的创建时间，仅当 `state` 为 `2` 时有效
     * @return 截图文件的创建时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public String getCreateTm() {
        return createTm;
    }

    /**
     * 设置截图文件的创建时间
     * @param createTm 截图文件的创建时间，格式：yyyy-MM-dd HH:MM:SS
     */
    public void setCreateTm(String createTm) {
        this.createTm = createTm;
    }

    /**
     * 取文件大小，仅当 `state` 为 `2` 时有效
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

    /**
     * 取是否结束态（成功或失败或已取消）
     * @return 是否结束态
     */
    public boolean isFinalState() {
        return state == STATE__SUCCESS || state == STATE__FAILED || state == STATE__CANCELED;
    }

    /**
     * 取是否成功
     * @return 是否成功
     */
    public boolean isSuccess() {
        return state == STATE__SUCCESS;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VidInspectChannelState.class.getSimpleName() + "[", "]")
                .add("taskId='" + taskId + "'")
                .add("chan=" + chan)
                .add("endTm='" + endTm + "'")
                .add("state=" + state)
                .add("path='" + path + "'")
                .add("url='" + url + "'")
                .add("sz=" + sz)
                .toString();
    }

    @Override
    public VidInspectChannelState clone() {
        try {
            return  (VidInspectChannelState) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
