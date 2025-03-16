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
 * 更新远程录像上传状态请求
 */
public class UpdateAvUploadStateReq {

    /**
     * 请求状态：已收到客户端上传请求（初始状态）
     */
    public static final byte STATE__REQUESTED = AvUpload2.STATE__REQUESTED;

    /**
     * 请求状态：确认
     */
    public static final byte STATE__ACK = AvUpload2.STATE__ACK;

    /**
     * 请求状态：上传中
     */
    public static final byte STATE__UPLOADING = AvUpload2.STATE__UPLOADING;

    /**
     * 请求状态：上传完成
     */
    public static final byte STATE__UPLOADED = AvUpload2.STATE__UPLOADED;

    /**
     * 请求状态：失败
     */
    public static final byte STATE__FAILED = AvUpload2.STATE__FAILED;

    /**
     * 请求状态：取消
     */
    public static final byte STATE__CANCELED = AvUpload2.STATE__CANCELED;

    /**
     * 请求状态：超时
     */
    public static final byte STATE__TIMEOUT = AvUpload2.STATE__TIMEOUT;

    private String startTm;
    private String reqId;

    /**
     * The new state of request. Value domain: one of AvUpload2.STATE__XXXX constant.
     */
    private int st;

    private String fn;

    private Long sz;

    private String uploadTm;

    /**
     * 远程录像的开始时间, 北京时间。格式：`yyyy-MM-dd HH:mm:ss`
     *
     * @return 远程录像的开始时间
     */
    public String getStartTm() {
        return startTm;
    }

    /**
     * 设置远程录像的开始时间
     *
     * @param startTm 远程录像的开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 获取请求 ID
     *
     * @return 请求 ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求 ID
     *
     * @param reqId 请求 ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取请求状态
     *
     * @return 请求状态
     */
    public int getSt() {
        return st;
    }

    /**
     * 设置请求状态
     *
     * @param st 请求状态
     */
    public void setSt(int st) {
        this.st = st;
    }

    /**
     * 已上传的文件的文件名。仅当请求状态为 AvUpload2#STATE__UPLOADED 时有效
     *
     * @return 已上传的文件的文件名
     */
    public String getFn() {
        return fn;
    }

    /**
     * 设置已上传的文件的文件名
     *
     * @param fn 已上传的文件的文件名
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * 获取已上传的文件的大小
     *
     * @return 已上传的文件的大小
     */
    public Long getSz() {
        return sz;
    }

    /**
     * 设置已上传的文件的大小
     *
     * @param sz 已上传的文件的大小
     */
    public void setSz(Long sz) {
        this.sz = sz;
    }

    /**
     * 上传完成时间, 北京时间。格式：`yyyy-MM-dd HH:mm:ss`
     * 可能为 null 。
     *
     * @return 上传完成时间, 为 null 表示未上传完成
     */
    public String getUploadTm() {
        return uploadTm;
    }

    /**
     * 设置上传完成时间
     *
     * @param uploadTm 上传完成时间
     */
    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateAvUploadStateReq.class.getSimpleName() + "[", "]")
                .add("startTm='" + startTm + "'")
                .add("reqId='" + reqId + "'")
                .add("st=" + st)
                .add("fn='" + fn + "'")
                .add("sz=" + sz)
                .add("uploadTm='" + uploadTm + "'")
                .toString();
    }
}
