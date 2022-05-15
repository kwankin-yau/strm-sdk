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

import java.util.List;
import java.util.StringJoiner;

public class ClosedChannelLogEntry implements StrmMsg {

    private String simNo;
    private short chanId;
    private boolean live;
    private Integer liveDataTyp;
    private Integer codeStrm;
    private long createTm;
    private Long srcDetectTm;
    private boolean strmReady;
    private Long strmReadyTm;
    private long closeTm;
    private long recvFromTerm;
    private long sendToClient;
    private String audioFmt;
    private String videoFmt;
    private String videoRes;
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

    public Integer getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(Integer codeStrm) {
        this.codeStrm = codeStrm;
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

    public String getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(String videoRes) {
        this.videoRes = videoRes;
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
        return new StringJoiner(", ", ClosedChannelLogEntry.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("live=" + live)
                .add("liveDataTyp=" + liveDataTyp)
                .add("codeStrm=" + codeStrm)
                .add("createTm=" + createTm)
                .add("srcDetectTm=" + srcDetectTm)
                .add("strmReady=" + strmReady)
                .add("strmReadyTm=" + strmReadyTm)
                .add("closeTm=" + closeTm)
                .add("recvFromTerm=" + recvFromTerm)
                .add("sendToClient=" + sendToClient)
                .add("audioFmt='" + audioFmt + "'")
                .add("videoFmt='" + videoFmt + "'")
                .add("videoRes='" + videoRes + "'")
                .add("mediaTyp='" + mediaTyp + "'")
                .add("requests=" + requests)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__ClosedChannelLogEntry;
    }
}
