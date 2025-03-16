package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

/**
 * 媒体流请求状态
 */
public class StrmReqStatus {
    private String reqId;
    private String userId;
    private long reqTm;
    private int fmt;
    private long lastKeepTm;
    private Long readyTm;
    private Long closeTm;
    private Integer closeCause;

    /**
     * 构造函数
     */
    public StrmReqStatus() {
    }

    /**
     * 构造函数
     * @param reqId 媒体请求ID
     * @param userId 用户ID
     * @param reqTm 请求时间
     * @param closeCause 关闭原因
     */
    public StrmReqStatus(String reqId,
                         String userId,
                         long reqTm,
                         Integer closeCause) {
        this.reqId = reqId;
        this.userId = userId;
        this.reqTm = reqTm;
        this.fmt = fmt;
        this.lastKeepTm = lastKeepTm;
        this.readyTm = readyTm;
        this.closeTm = closeTm;
        this.closeCause = closeCause;
    }

    /**
     * 获取媒体请求ID
     * @return 媒体请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置媒体请求ID
     * @param reqId 媒体请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取请求时间
     * @return 请求时间, epoch millis
     */
    public long getReqTm() {
        return reqTm;
    }

    /**
     * 设置请求时间
     * @param reqTm 请求时间, epoch millis
     */
    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取媒体流格式，为 `com.lucendar.strm.common.StreamingApi.FORMAT__XXX` 系列常量之一
     * @return 媒体流格式
     */
    public int getFmt() {
        return fmt;
    }

    /**
     * 设置媒体流格式
     * @param fmt 媒体流格式
     */
    public void setFmt(int fmt) {
        this.fmt = fmt;
    }

    /**
     * 获取关闭原因
     * @return 关闭原因
     */
    public Integer getCloseCause() {
        return closeCause;
    }

    /**
     * 设置关闭原因
     * @param closeCause 关闭原因
     */
    public void setCloseCause(Integer closeCause) {
        this.closeCause = closeCause;
    }

    /**
     * 获取最后保持时间
     * @return 最后保持时间, epoch millis
     */
    public long getLastKeepTm() {
        return lastKeepTm;
    }

    /**
     * 设置最后保持时间
     * @param lastKeepTm 最后保持时间, epoch millis
     */
    public void setLastKeepTm(long lastKeepTm) {
        this.lastKeepTm = lastKeepTm;
    }

    /**
     * 获取准备时间
     * @return 准备时间, epoch millis
     */
    public Long getReadyTm() {
        return readyTm;
    }

    /**
     * 设置准备时间
     * @param readyTm 准备时间, epoch millis
     */
    public void setReadyTm(Long readyTm) {
        this.readyTm = readyTm;
    }

    /**
     * 获取关闭时间
     * @return 关闭时间, epoch millis
     */
    public Long getCloseTm() {
        return closeTm;
    }

    /**
     * 设置关闭时间
     * @param closeTm 关闭时间, epoch millis
     */
    public void setCloseTm(Long closeTm) {
        this.closeTm = closeTm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmReqStatus.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("userId='" + userId + "'")
                .add("reqTm=" + reqTm)
                .add("fmt=" + fmt)
                .add("lastKeepTm=" + lastKeepTm)
                .add("readyTm=" + readyTm)
                .add("closeTm=" + closeTm)
                .add("closeCause=" + closeCause)
                .toString();
    }
}
