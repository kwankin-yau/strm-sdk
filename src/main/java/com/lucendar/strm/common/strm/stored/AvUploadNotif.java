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
    private int st;
    private Long uploadedSz;
    private String fileName;
    private String url;
    private String uploadTm;

    /**
     * 取请求ID
     *
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取录像上传状态代码，为 AvUpload.STATE__XXX 之一
     *
     * @return 录像上传状态代码
     */
    public int getSt() {
        return st;
    }

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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 取上传完成时间。仅当`st`为 AvUpload.STATE__UPLOADED时有效
     *
     * @return 上传完成时间
     */
    public String getUploadTm() {
        return uploadTm;
    }

    public void setUploadTm(String uploadTm) {
        this.uploadTm = uploadTm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadNotif.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("st=" + st)
                .add("uploadedSz=" + uploadedSz)
                .add("fileName='" + fileName + "'")
                .add("url='" + url + "'")
                .add("uploadTm='" + uploadTm + "'")
                .toString();
    }
}
