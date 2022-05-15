/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.closedlog;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

public class QryClosedLogReq implements StrmMsg {

    private String reqId;
    private String simNo;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    @Override
    public String toString() {
        return "QryClosedLogReq{" +
                "reqId='" + reqId + '\'' +
                ", simNo='" + simNo + '\'' +
                '}';
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryClosedLogReq;
    }
}
