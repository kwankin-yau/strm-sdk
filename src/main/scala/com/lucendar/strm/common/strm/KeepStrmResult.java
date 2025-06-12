package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 保持流请求结果
 */
public class KeepStrmResult {

    private String reqId;
    private boolean keep;

    /**
     * 构造函数
     */
    public KeepStrmResult() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param keep 是否保持
     */
    public KeepStrmResult(String reqId, boolean keep) {
        this.reqId = reqId;
        this.keep = keep;
    }

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取此请求是否被成功保持
     * @return 是否被成功保持
     */
    public boolean isKeep() {
        return keep;
    }

    /**
     * 设置此请求是否被成功保持
     * @param keep 是否被成功保持
     */
    public void setKeep(boolean keep) {
        this.keep = keep;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KeepStrmResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("keep=" + keep)
                .toString();
    }
}
