/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

public class QryStrmActivityReq implements StrmMsg {

    private String appId;
    private String simNo;
    private String startTmFrom;
    private String startTmTo;
    private int __limit;
    private int __page;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

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

    public int get__limit() {
        return __limit;
    }

    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    public int get__page() {
        return __page;
    }

    public void set__page(int __page) {
        this.__page = __page;
    }

    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmActivityReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("startTmFrom='" + startTmFrom + "'")
                .add("startTmTo='" + startTmTo + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryStrmActivityReq;
    }
}
