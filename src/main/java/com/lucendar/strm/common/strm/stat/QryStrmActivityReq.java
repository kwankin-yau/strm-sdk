/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

public class QryStrmActivityReq implements StrmMsg {

    private String simNo;
    private String startTmFrom;
    private String startTmTo;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getStartTmFrom() {
        return startTmFrom;
    }

    public void setStartTmFrom(String startTmFrom) {
        this.startTmFrom = startTmFrom;
    }

    public String getStartTmTo() {
        return startTmTo;
    }

    public void setStartTmTo(String startTmTo) {
        this.startTmTo = startTmTo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmActivityReq.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("startTmFrom='" + startTmFrom + "'")
                .add("startTmTo='" + startTmTo + "'")
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryStrmActivityReq;
    }
}
