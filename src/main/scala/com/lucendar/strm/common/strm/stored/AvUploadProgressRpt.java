/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

/**
 * A/V upload progress report
 * 视频上传进度报告
 */
public class AvUploadProgressRpt {

    private String startTm;
    private String reqId;
    private long uploaded;

    /**
     * 构造函数
     */
    public AvUploadProgressRpt() {
    }

    /**
     * 构造函数
     * @param startTm 开始时间
     * @param reqId 请求ID
     * @param uploaded 已上传大小
     */
    public AvUploadProgressRpt(String startTm, String reqId, long uploaded) {
        this.startTm = startTm;
        this.reqId = reqId;
        this.uploaded = uploaded;
    }

    /**
     * 取开始时间, 格式：yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间, 格式：yyyy-MM-dd HH:mm:ss
     * @param startTm 开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 取请求ID
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
     * 取已上传大小
     * @return 已上传大小
     */
    public long getUploaded() {
        return uploaded;
    }

    /**
     * 设置已上传大小
     * @param uploaded 已上传大小
     */
    public void setUploaded(long uploaded) {
        this.uploaded = uploaded;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadProgressRpt.class.getSimpleName() + "[", "]")
                .add("startTm='" + startTm + "'")
                .add("reqId='" + reqId + "'")
                .add("uploaded=" + uploaded)
                .toString();
    }
}
