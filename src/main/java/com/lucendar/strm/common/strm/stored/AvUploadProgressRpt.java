/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

/**
 * A/V upload progress report
 */
public class AvUploadProgressRpt {

    private String reqId;
    private long uploadedSize;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public long getUploadedSize() {
        return uploadedSize;
    }

    public void setUploadedSize(long uploadedSize) {
        this.uploadedSize = uploadedSize;
    }

    @Override
    public String toString() {
        return "AvUploadProgressRpt{" +
                "reqId='" + reqId + '\'' +
                ", uploadedSize=" + uploadedSize +
                '}';
    }
}
