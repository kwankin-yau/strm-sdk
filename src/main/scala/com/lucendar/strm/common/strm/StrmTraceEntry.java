package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 流跟踪条目
 */
public class StrmTraceEntry {
    private String simNo;
    private String startTraceTime;

    /**
     * 构造函数
     */
    public StrmTraceEntry() {
    }

    /**
     * 构造函数
     * @param simNo 终端识别号
     * @param startTraceTime 开始跟踪时间
     */
    public StrmTraceEntry(String simNo, String startTraceTime) {
        this.simNo = simNo;
        this.startTraceTime = startTraceTime;
    }

    /**
     * 获取终端识别号
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
     * 获取开始跟踪时间, 格式：yyyy-MM-dd HH:mm:ss
     * @return 开始跟踪时间
     */
    public String getStartTraceTime() {
        return startTraceTime;
    }

    /**
     * 设置开始跟踪时间, 格式：yyyy-MM-dd HH:mm:ss
     * @param startTraceTime 开始跟踪时间
     */
    public void setStartTraceTime(String startTraceTime) {
        this.startTraceTime = startTraceTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmTraceEntry.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("startTraceTime='" + startTraceTime + "'")
                .toString();
    }
}
