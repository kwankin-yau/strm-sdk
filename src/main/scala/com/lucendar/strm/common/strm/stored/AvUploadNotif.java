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
 * 录像上传状态通知
 */
public class AvUploadNotif {
    private String reqId;
    private String simNo;
    private int st;
    private Long uploadedSz;
    private String fileName;
    private String url;
    private String uploadTm;

    private transient boolean progressNotif;

    /**
     * 取请求ID
     *
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
     * 取终端识别号
     *
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
     * 取录像上传状态代码，为 AvUpload.STATE__XXX 之一
     *
     * @return 录像上传状态代码
     */
    public int getSt() {
        return st;
    }

    /**
     * 设置录像上传状态代码
     * @param st 录像上传状态代码，为 AvUpload.STATE__XXX 之一
     */
    public void setSt(int st) {
        this.st = st;
    }

    /**
     * 取当前已经上传字节数。
     *
     * @return 当前已经上传字节数
     */
    public Long getUploadedSz() {
        return uploadedSz;
    }

    /**
     * 设置当前已经上传字节数
     * @param uploadedSz 当前已经上传字节数
     */
    public void setUploadedSz(Long uploadedSz) {
        this.uploadedSz = uploadedSz;
    }

    /**
     * 取文件名。仅当`st`为 AvUpload.STATE__UPLOADED时有效
     *
     * @return 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置取文件名
     * @param fileName 取文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 取文件下载 URL
     * @return 文件下载 URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件下载 URL
     * @param url 文件下载 URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 取上传完成时间。仅当`st`为 AvUpload.STATE__UPLOADED时有效
     *
     * @return 上传完成时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getUploadTm() {
        return uploadTm;
    }

    /**
     * 设置上传完成时间
     * @param uploadTm 上传完成时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    /**
     * 是否为进度通知
     * @return 是否为进度通知
     */
    public boolean isProgressNotif() {
        return progressNotif;
    }

    /**
     * 设置是否为进度通知
     * @param progressNotif 是否为进度通知
     */
    public void setProgressNotif(boolean progressNotif) {
        this.progressNotif = progressNotif;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadNotif.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("st=" + st)
                .add("uploadedSz=" + uploadedSz)
                .add("fileName='" + fileName + "'")
                .add("url='" + url + "'")
                .add("uploadTm='" + uploadTm + "'")
                .add("progressNotif=" + progressNotif)
                .toString();
    }
}
