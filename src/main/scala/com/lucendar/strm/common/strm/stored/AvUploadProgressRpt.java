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
 */
public class AvUploadProgressRpt {

    private String startTm;
    private String reqId;
    private long uploaded;

    public AvUploadProgressRpt() {
    }

    public AvUploadProgressRpt(String startTm, String reqId, long uploaded) {
        this.startTm = startTm;
        this.reqId = reqId;
        this.uploaded = uploaded;
    }

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

    public long getUploaded() {
        return uploaded;
    }

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
