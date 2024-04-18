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

    public static final byte STATE__REQUESTED = AvUpload2.STATE__REQUESTED;
    public static final byte STATE__ACK = AvUpload2.STATE__ACK;
    public static final byte STATE__UPLOADING = AvUpload2.STATE__UPLOADING;
    public static final byte STATE__UPLOADED = AvUpload2.STATE__UPLOADED;
    public static final byte STATE__FAILED = AvUpload2.STATE__FAILED;
    public static final byte STATE__CANCELED = AvUpload2.STATE__CANCELED;
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
     * @return
     */
    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * The new state of request. Value domain: one of AvUpload2.STATE__XXXX constant.
     *
     * @return
     */
    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    /**
     * The file name of uploaded file. Only valid when st == AvUpload2#STATE__UPLOADED
     *
     * @return
     */
    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public Long getSz() {
        return sz;
    }

    public void setSz(Long sz) {
        this.sz = sz;
    }

    /**
     * 上传完成时间, 北京时间。格式：`yyyy-MM-dd HH:mm:ss`
     * 可能为 null 。
     *
     * @return
     */
    public String getUploadTm() {
        return uploadTm;
    }

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
