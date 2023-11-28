/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.StreamingApi;

import java.util.StringJoiner;

public class AvUploadReq {
    private String appId;
    private String simNo;
    private int channel;
    private String startTime;
    private String endTime;
    private String almState;
    private int mediaType;
    private int codeStream;
    private int storageType;
    private Integer when;

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

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAlmState() {
        return almState;
    }

    public void setAlmState(String almState) {
        this.almState = almState;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(int codeStream) {
        this.codeStream = codeStream;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public Integer getWhen() {
        return when;
    }

    public void setWhen(Integer when) {
        this.when = when;
    }

    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    public int whenDef() {
        if (when != null)
            return when;
        else
            return 7;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("channel=" + channel)
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("almState='" + almState + "'")
                .add("mediaType=" + mediaType)
                .add("codeStream=" + codeStream)
                .add("storageType=" + storageType)
                .add("when=" + when)
                .toString();
    }
}
