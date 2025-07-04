/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

/**
 * Register a terminal A/V upload request.
 * 注册终端音视频上传请求
 */
public class RegisterAvUploadReq implements AbstractAvUpload {

    private String reqId;
    private String simNo;
    private String startTm;
    private Long sz;
    private String cb;

    /**
     * 构造函数
     */
    public RegisterAvUploadReq() {
    }

    /**
     * 构造函数
     * @param reqId 音视频上传请求ID
     * @param simNo 终端识别号
     * @param startTm 开始时间
     * @param sz 大小
     * @param cb 回调URL前缀
     */
    public RegisterAvUploadReq(String reqId, String simNo, String startTm, Long sz, String cb) {
        this.reqId = reqId;
        this.simNo = simNo;
        this.startTm = startTm;
        this.sz = sz;
        this.cb = cb;
    }

    /**
     * 构造函数
     * @param avUpload2 音视频上传请求
     */
    public RegisterAvUploadReq(AvUpload2 avUpload2) {
        assign(avUpload2);
    }

    /**
     * 取音视频上传请求ID。
     * Get the A/V upload request ID, must be unique among all A/V upload request.
     * Can be `null`, if so then the `reqId` will be generated by the service and returned in `RegisterAvUploadResult`.
     * If supplied, it must satisfy {@link com.lucendar.strm.common.StreamingApi#isValidReqId(String)}.
     *
     * @return 音视频上传请求ID。 A/V upload request ID. `null` if the `reqId` generated by service.
     */
    @Override
    public String getReqId() {
        return reqId;
    }

    /** 
     * 取终端识别号。
     * Get `simNo` of the terminal.
     *
     * @return 终端识别号。 `simNo` of the terminal.
     */
    @Override
    public String getSimNo() {
        return simNo;
    }

    /**
     * 取终端存储的音视频文件的开始时间。 日期时间格式：`yyyy-MM-dd HH:mm:ss`。
     * Get the start time of the terminal stored AV file.  Date time format: `yyyy-MM-dd HH:mm:ss`.
     *
     * @return 终端存储的音视频文件的开始时间。 start time of the terminal stored AV file.
     */
    @Override
    public String getStartTm() {
        return startTm;
    }

    /**
     * 取FTP通知的回调URL前缀（用于`/upload`和`/upload/progress`）。
     * Get the base callback url of FTP notification(for `/upload` and `/upload/progress`).
     *
     * @return FTP通知的回调URL前缀。 base callback url of FTP notification.
     */
    @Override
    public String getCb() {
        return cb;
    }

    /**
     * 取标称的音视频文件的大小。
     * Get the claimed size of the A/V file.
     *
     * @return 标称的音视频文件的大小。 claimed size of the A/V file.
     */
    @Override
    public Long getSz() {
        return sz;
    }

    /**
     * 设置音视频上传请求ID。
     * Set the A/V upload request ID.
     *
     * @param reqId 音视频上传请求ID。 A/V upload request ID.
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 设置终端识别号。
     * Set the `simNo` of the terminal.
     *
     * @param simNo 终端识别号。 `simNo` of the terminal.
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 设置终端存储的音视频文件的开始时间。
     * Set the start time of the terminal stored AV file.
     *
     * @param startTm 开始时间。 start time of the terminal stored AV file.
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 设置标称的音视频文件的大小。
     * Set the claimed size of the A/V file.
     *
     * @param sz 大小。 claimed size of the A/V file.
     */
    public void setSz(Long sz) {
        this.sz = sz;
    }

    /**
     * 设置FTP通知的回调URL前缀（用于`/upload`和`/upload/progress`）。
     * Set the base callback url of FTP notification(for `/upload` and `/upload/progress`).
     *
     * @param cb 回调URL前缀。 base callback url of FTP notification.
     */
    public void setCb(String cb) {
        this.cb = cb;
    }

    /**
     * 将AvUpload2对象的属性值赋值给当前对象。
     * Assign the attributes of the `AvUpload2` object to the current object.
     *
     * @param avUpload2 音视频上传请求。 A/V upload request.
     */
    public void assign(AvUpload2 avUpload2) {
        this.reqId = avUpload2.getReqId();
        this.simNo = avUpload2.getSimNo();
        this.startTm = avUpload2.getStartTm();
        this.sz = avUpload2.getSz();
        this.cb = avUpload2.getCb();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegisterAvUploadReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("startTm='" + startTm + "'")
                .add("sz=" + sz)
                .add("cb='" + cb + "'")
                .toString();
    }
}
