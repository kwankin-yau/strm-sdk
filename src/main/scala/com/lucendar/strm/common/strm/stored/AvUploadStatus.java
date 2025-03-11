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
 * 视频上传状态
 */
public class AvUploadStatus implements AbstractAvUpload, Cloneable {

    /**
     * 请求ID
     */
    protected String reqId;

    /**
     * 设备识别号
     */
    protected String simNo;

    /**
     * 开始时间, 格式：yyyy-MM-dd HH:mm:ss
     */
    protected String startTm;

    /**
     * 视频大小
     */
    protected Long sz;

    /**
     * 上传状态通知回调地址
     */
    protected String cb;

    /**
     * 状态
     */
    protected int st;

    /**
     * 已上传大小
     */
    protected Long uploaded;

    /**
     * 构造函数
     */
    public AvUploadStatus() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param simNo 设备号
     * @param startTm 开始时间
     * @param sz 视频大小
     * @param cb 回调地址
     * @param st 状态
     * @param uploaded 已上传大小
     */
    public AvUploadStatus(String reqId, String simNo, String startTm, Long sz, String cb, int st, Long uploaded) {
        this.reqId = reqId;
        this.simNo = simNo;
        this.startTm = startTm;
        this.sz = sz;
        this.cb = cb;
        this.st = st;
        this.uploaded = uploaded;
    }

    /**
     * 从AvUpload转换为AvUploadStatus
     * @param avUpload AvUpload对象
     * @param st 状态
     * @param uploaded 已上传大小
     * @return AvUploadStatus对象
     */
    public static AvUploadStatus from(AbstractAvUpload avUpload, int st, Long uploaded) {
        return new AvUploadStatus(
                avUpload.getReqId(),
                avUpload.getSimNo(),
                avUpload.getStartTm(),
                avUpload.getSz(),
                avUpload.getCb(),
                st,
                uploaded);
    }

    /**
     * 取请求ID
     * @return 请求ID
     */
    @Override
    public String getReqId() {
        return reqId;
    }

    /**
     * 取设备识别号
     * @return 设备识别号
     */
    @Override
    public String getSimNo() {
        return simNo;
    }

    /**
     * 取开始时间, 格式：yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    @Override
    public String getStartTm() {
        return startTm;
    }

    /**
     * 取视频大小
     * @return 视频大小
     */
    @Override
    public Long getSz() {
        return sz;
    }

    /**
     * 取上传状态通知回调地址
     * @return 上传状态通知回调地址
     */
    @Override
    public String getCb() {
        return cb;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 设置设备识别号
     * @param simNo 设备识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 设置开始时间, 格式：yyyy-MM-dd HH:mm:ss
     * @param startTm 开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 设置视频大小
     * @param sz 视频大小
     */
    public void setSz(Long sz) {
        this.sz = sz;
    }

    /**
     * 设置上传状态通知回调地址
     * @param cb 上传状态通知回调地址
     */
    public void setCb(String cb) {
        this.cb = cb;
    }

    /**
     * 取状态
     * @return 状态
     */
    public int getSt() {
        return st;
    }

    /**
     * 设置状态
     * @param st 状态
     */
    public void setSt(int st) {
        this.st = st;
    }

    /**
     * 取已上传大小
     * @return 已上传大小
     */
    public Long getUploaded() {
        return uploaded;
    }

    /**
     * 设置已上传大小
     * @param uploaded 已上传大小
     */
    public void setUploaded(Long uploaded) {
        this.uploaded = uploaded;
    }


    @Override
    public AvUploadStatus clone() {
        try {
            AvUploadStatus clone = (AvUploadStatus) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadStatus.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("startTm='" + startTm + "'")
                .add("sz=" + sz)
                .add("cb='" + cb + "'")
                .add("st=" + st)
                .add("uploaded=" + uploaded)
                .toString();
    }
}
