/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.closed;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.List;
import java.util.StringJoiner;

public class ClosedStrm implements StrmMsg {

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
    private boolean audioFmtSupported;
    private String videoFmt;
    private boolean videoFmtSupported;
    private String videoRes;
    private Float frameRate;
    private String mediaTyp;
    private List<ClosedStrmReq> requests;

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

    public boolean isAudioFmtSupported() {
        return audioFmtSupported;
    }

    public void setAudioFmtSupported(boolean audioFmtSupported) {
        this.audioFmtSupported = audioFmtSupported;
    }

    public String getVideoFmt() {
        return videoFmt;
    }

    public void setVideoFmt(String videoFmt) {
        this.videoFmt = videoFmt;
    }

    public boolean isVideoFmtSupported() {
        return videoFmtSupported;
    }

    public void setVideoFmtSupported(boolean videoFmtSupported) {
        this.videoFmtSupported = videoFmtSupported;
    }

    public String getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(String videoRes) {
        this.videoRes = videoRes;
    }

    public Float getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(Float frameRate) {
        this.frameRate = frameRate;
    }

    public String getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public List<ClosedStrmReq> getRequests() {
        return requests;
    }

    public void setRequests(List<ClosedStrmReq> requests) {
        this.requests = requests;
    }

    public ClosedStrmReq findReq(String reqId) {
        if (this.requests != null) {
            for (ClosedStrmReq r : this.requests) {
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
        return new StringJoiner(", ", ClosedStrm.class.getSimpleName() + "[", "]")
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
                .add("audioFmtSupported=" + audioFmtSupported)
                .add("videoFmt='" + videoFmt + "'")
                .add("videoFmtSupported=" + videoFmtSupported)
                .add("videoRes='" + videoRes + "'")
                .add("frameRate=" + frameRate)
                .add("mediaTyp='" + mediaTyp + "'")
                .add("requests=" + requests)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__ClosedStrm;
    }
}
