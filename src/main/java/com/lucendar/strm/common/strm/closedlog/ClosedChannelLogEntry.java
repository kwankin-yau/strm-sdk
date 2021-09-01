/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.closedlog;

import java.util.List;

public class ClosedChannelLogEntry {

    private String simNo;
    private short chanId;
    private boolean live;
    private Integer liveDataTyp;
    private long createTm;
    private Long srcDetectTm;
    private boolean strmReady;
    private Long strmReadyTm;
    private long closeTm;
    private long recvFromTerm;
    private long sendToClient;
    private String audioFmt;
    private String videoFmt;
    private String mediaTyp;
    private List<ClosedReqLogEntry> requests;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public short getChanId() {
        return chanId;
    }

    public void setChanId(short chanId) {
        this.chanId = chanId;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Integer getLiveDataTyp() {
        return liveDataTyp;
    }

    public void setLiveDataTyp(Integer liveDataTyp) {
        this.liveDataTyp = liveDataTyp;
    }

    public long getCreateTm() {
        return createTm;
    }

    public void setCreateTm(long createTm) {
        this.createTm = createTm;
    }

    public Long getSrcDetectTm() {
        return srcDetectTm;
    }

    public void setSrcDetectTm(Long srcDetectTm) {
        this.srcDetectTm = srcDetectTm;
    }

    public boolean isStrmReady() {
        return strmReady;
    }

    public void setStrmReady(boolean strmReady) {
        this.strmReady = strmReady;
    }

    public Long getStrmReadyTm() {
        return strmReadyTm;
    }

    public void setStrmReadyTm(Long strmReadyTm) {
        this.strmReadyTm = strmReadyTm;
    }

    public long getCloseTm() {
        return closeTm;
    }

    public void setCloseTm(long closeTm) {
        this.closeTm = closeTm;
    }

    public long getRecvFromTerm() {
        return recvFromTerm;
    }

    public void setRecvFromTerm(long recvFromTerm) {
        this.recvFromTerm = recvFromTerm;
    }

    public long getSendToClient() {
        return sendToClient;
    }

    public void setSendToClient(long sendToClient) {
        this.sendToClient = sendToClient;
    }

    public String getAudioFmt() {
        return audioFmt;
    }

    public void setAudioFmt(String audioFmt) {
        this.audioFmt = audioFmt;
    }

    public String getVideoFmt() {
        return videoFmt;
    }

    public void setVideoFmt(String videoFmt) {
        this.videoFmt = videoFmt;
    }

    public String getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public List<ClosedReqLogEntry> getRequests() {
        return requests;
    }

    public void setRequests(List<ClosedReqLogEntry> requests) {
        this.requests = requests;
    }

    public ClosedReqLogEntry findReq(String reqId) {
        if (this.requests != null) {
            for (ClosedReqLogEntry r : this.requests) {
                if (r.getReqId().equals(reqId))
                    return r;
            }
        }

        return null;
    }

    public boolean hasReq(String reqId) {
        return findReq(reqId) != null;
    }

    @Override
    public String toString() {
        return "ClosedChannelLogEntry{" +
                "simNo='" + simNo + '\'' +
                ", chanId=" + chanId +
                ", live=" + live +
                ", liveDataTyp=" + liveDataTyp +
                ", createTm=" + createTm +
                ", srcDetectTm=" + srcDetectTm +
                ", strmReady=" + strmReady +
                ", strmReadyTm=" + strmReadyTm +
                ", closeTm=" + closeTm +
                ", recvFromTerm=" + recvFromTerm +
                ", sendToClient=" + sendToClient +
                ", audioFmt='" + audioFmt + '\'' +
                ", videoFmt='" + videoFmt + '\'' +
                ", mediaTyp='" + mediaTyp + '\'' +
                ", requests=" + requests +
                '}';
    }
}
