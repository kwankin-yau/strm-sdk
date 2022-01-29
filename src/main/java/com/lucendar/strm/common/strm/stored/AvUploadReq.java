/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

public class AvUploadReq {
    private String simNo;
    private int channel;
    private String startTime;
    private String endTime;
    private String almState;
    private int mediaType;
    private int codeStream;
    private int storageType;
    private Integer when;

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

    public int whenDef() {
        if (when != null)
            return when;
        else
            return 7;
    }

    @Override
    public String toString() {
        return "AVUploadReq{" +
                "simNo='" + simNo + '\'' +
                ", channel=" + channel +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", almState='" + almState + '\'' +
                ", mediaType=" + mediaType +
                ", codeStream=" + codeStream +
                ", storageType=" + storageType +
                ", when=" + when +
                '}';
    }
}
