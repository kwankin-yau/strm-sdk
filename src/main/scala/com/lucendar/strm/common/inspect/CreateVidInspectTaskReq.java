package com.lucendar.strm.common.inspect;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 创建巡检抓拍任务请求
 */
public class CreateVidInspectTaskReq {

    private String simNo;
    private int[] channels;

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
     * 取通道ID列表
     * @return 通道ID列表
     */
    public int[] getChannels() {
        return channels;
    }

    /**
     * 设置通道ID列表
     * @param channels 通道ID列表
     */
    public void setChannels(int[] channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateVidInspectTaskReq.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("channels=" + Arrays.toString(channels))
                .toString();
    }
}
