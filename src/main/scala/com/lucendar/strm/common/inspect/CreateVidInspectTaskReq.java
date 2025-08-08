package com.lucendar.strm.common.inspect;

import com.lucendar.strm.common.StreamingApi;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 创建巡检抓拍任务请求
 */
public class CreateVidInspectTaskReq {

    private String appId = StreamingApi.DEFAULT_APP_ID;
    private String simNo;
    private int[] channels;

    /**
     * 取 AppId
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppId，可选，默认空白
     * @param appId AppId
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
     * 取所要执行抓拍的通道ID列表
     * @return 所要执行抓拍的通道ID列表
     */
    public int[] getChannels() {
        return channels;
    }

    /**
     * 设置所要执行抓拍的通道ID列表
     * @param channels 所要执行抓拍的通道ID列表
     */
    public void setChannels(int[] channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateVidInspectTaskReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("channels=" + Arrays.toString(channels))
                .toString();
    }
}
