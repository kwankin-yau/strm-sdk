package com.lucendar.gnss.sdk.trace;

import java.util.StringJoiner;

/**
 * 设置跟踪消息。用于消息队列
 */
public class SetTraceMsg {

    private String appId;
    private String simNo;
    private boolean trace;

    /**
     * 取 AppId
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppId
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
     * 取是否跟踪该终端
     *
     * @return 是否跟踪该终端
     */
    public boolean isTrace() {
        return trace;
    }

    /**
     * 设置是否跟踪该终端
     * @param trace 是否跟踪该终端
     */
    public void setTrace(boolean trace) {
        this.trace = trace;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SetTraceMsg.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("trace=" + trace)
                .toString();
    }
}
