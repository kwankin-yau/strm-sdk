package com.lucendar.strm.common.strm.stat;

import java.util.Arrays;
import java.util.StringJoiner;

public class StrmStatus {
    private String simNo;
    private short chanId;
    private boolean live;
    private Integer liveDataTyp;
    private byte codeStrm;
    private long createTm;
    private Long srcDetectTm;
    private boolean strmReady;
    private Long strmReadyTm;
    private long recvFromTerm;
    private long termByteRate;
    private long sendToClnt;
    private String audioFmt;
    private boolean aSupported;
    private String videoFmt;
    private boolean vSupported;
    private String videoRes;
    private Float frameRate; // null if not available
    private String mediaTyp;

    private StrmReqStatus[] requests;

    public StrmStatus() {
    }

    public StrmStatus(String simNo,
                      short chanId,
                      boolean live,
                      Integer liveDataTyp,
                      byte codeStrm,
                      long createTm,
                      Long srcDetectTm,
                      boolean strmReady,
                      Long strmReadyTm,
                      long recvFromTerm,
                      long termByteRate,
                      long sendToClnt,
                      String audioFmt,
                      boolean aSupported,
                      String videoFmt,
                      boolean vSupported,
                      String videoRes,
                      Float frameRate,
                      String mediaTyp,
                      StrmReqStatus[] requests
    ) {
        this.simNo = simNo;
        this.chanId = chanId;
        this.live = live;
        this.liveDataTyp = liveDataTyp;
        this.codeStrm = codeStrm;
        this.createTm = createTm;
        this.srcDetectTm = srcDetectTm;
        this.strmReady = strmReady;
        this.strmReadyTm = strmReadyTm;
        this.recvFromTerm = recvFromTerm;
        this.termByteRate = termByteRate;
        this.sendToClnt = sendToClnt;
        this.audioFmt = audioFmt;
        this.aSupported = aSupported;
        this.videoFmt = videoFmt;
        this.vSupported = vSupported;
        this.videoRes = videoRes;
        this.frameRate = frameRate;
        this.mediaTyp = mediaTyp;
        this.requests = requests;
    }

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

    public byte getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(byte codeStrm) {
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

    public long getRecvFromTerm() {
        return recvFromTerm;
    }

    public void setRecvFromTerm(long recvFromTerm) {
        this.recvFromTerm = recvFromTerm;
    }

    public long getTermByteRate() {
        return termByteRate;
    }

    public void setTermByteRate(long termByteRate) {
        this.termByteRate = termByteRate;
    }

    public long getSendToClnt() {
        return sendToClnt;
    }

    public void setSendToClnt(long sendToClnt) {
        this.sendToClnt = sendToClnt;
    }

    public String getAudioFmt() {
        return audioFmt;
    }

    public void setAudioFmt(String audioFmt) {
        this.audioFmt = audioFmt;
    }

    public boolean isaSupported() {
        return aSupported;
    }

    public void setaSupported(boolean aSupported) {
        this.aSupported = aSupported;
    }

    public String getVideoFmt() {
        return videoFmt;
    }

    public void setVideoFmt(String videoFmt) {
        this.videoFmt = videoFmt;
    }

    public boolean isvSupported() {
        return vSupported;
    }

    public void setvSupported(boolean vSupported) {
        this.vSupported = vSupported;
    }

    public String getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(String videoRes) {
        this.videoRes = videoRes;
    }

    /**
     * Get frame rate of video.
     *
     * @return frame rate of video, null if not available
     */
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

    public StrmReqStatus[] getRequests() {
        return requests;
    }

    public void setRequests(StrmReqStatus[] requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmStatus.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("live=" + live)
                .add("liveDataTyp=" + liveDataTyp)
                .add("codeStrm=" + codeStrm)
                .add("createTm=" + createTm)
                .add("srcDetectTm=" + srcDetectTm)
                .add("strmReady=" + strmReady)
                .add("strmReadyTm=" + strmReadyTm)
                .add("recvFromTerm=" + recvFromTerm)
                .add("termByteRate=" + termByteRate)
                .add("sendToClnt=" + sendToClnt)
                .add("audioFmt='" + audioFmt + "'")
                .add("aSupported=" + aSupported)
                .add("videoFmt='" + videoFmt + "'")
                .add("vSupported=" + vSupported)
                .add("videoRes='" + videoRes + "'")
                .add("frameRate=" + frameRate)
                .add("mediaTyp='" + mediaTyp + "'")
                .add("requests=" + Arrays.toString(requests))
                .toString();
    }
}
