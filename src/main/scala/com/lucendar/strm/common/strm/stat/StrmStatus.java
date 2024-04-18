package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.strm.OpenStrmReq;

import java.util.Arrays;
import java.util.StringJoiner;

public class StrmStatus {
    private String appId;
    private String initReqId;
    private String simNo;
    private short chanId;
    private boolean live;
    private Integer liveDataTyp;
    private byte codeStrm;
    private long createTm;
    private Long srcDetectTm;
    private boolean ready;
    private Long readyTm;
    private Long closeTm;

    /**
     * Bytes received from terminal from connection created.
     */
    private long recv;

    /**
     * Terminal pushing byte rate (bytes/second) in recent one minute.
     */
    private long byteRate;

    /**
     * Bytes totally send to client.
     */
    private long sendToClnt;

    private String aFmt;
    private Boolean aNotSupport;
    private String vFmt;
    private Boolean vNotSupport;
    private String vRez;
    private Float frameRate; // null if not available
    private String mediaTyp;
    private Integer trace;

    private StrmReqStatus[] requests;

    public StrmStatus() {
    }

    public StrmStatus(
            String appId,
            String initReqId,
            String simNo,
            short chanId,
            boolean live,
            Integer liveDataTyp,
            byte codeStrm,
            long createTm,
            Long srcDetectTm,
            boolean ready,
            Long readyTm,
            Long closeTm,
            long recv,
            long byteRate,
            long sendToClnt,
            String aFmt,
            Boolean aNotSupport,
            String vFmt,
            Boolean vNotSupport,
            String vRez,
            Float frameRate,
            String mediaTyp,
            Integer trace,
            StrmReqStatus[] requests
    ) {
        this.appId = appId;
        this.initReqId = initReqId;
        this.simNo = simNo;
        this.chanId = chanId;
        this.live = live;
        this.liveDataTyp = liveDataTyp;
        this.codeStrm = codeStrm;
        this.createTm = createTm;
        this.srcDetectTm = srcDetectTm;
        this.ready = ready;
        this.readyTm = readyTm;
        this.closeTm = closeTm;
        this.recv = recv;
        this.byteRate = byteRate;
        this.sendToClnt = sendToClnt;
        this.aFmt = aFmt;
        this.aNotSupport = aNotSupport;
        this.vFmt = vFmt;
        this.vNotSupport = vNotSupport;
        this.vRez = vRez;
        this.frameRate = frameRate;
        this.mediaTyp = mediaTyp;
        this.trace = trace;
        this.requests = requests;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getInitReqId() {
        return initReqId;
    }

    public void setInitReqId(String initReqId) {
        this.initReqId = initReqId;
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

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Long getReadyTm() {
        return readyTm;
    }

    public void setReadyTm(Long readyTm) {
        this.readyTm = readyTm;
    }

    public Long getCloseTm() {
        return closeTm;
    }

    public void setCloseTm(Long closeTm) {
        this.closeTm = closeTm;
    }

    public long getRecv() {
        return recv;
    }

    public void setRecv(long recv) {
        this.recv = recv;
    }

    public long getByteRate() {
        return byteRate;
    }

    public void setByteRate(long byteRate) {
        this.byteRate = byteRate;
    }

    public long getSendToClnt() {
        return sendToClnt;
    }

    public void setSendToClnt(long sendToClnt) {
        this.sendToClnt = sendToClnt;
    }

    public String getAFmt() {
        return aFmt;
    }

    public void setAFmt(String aFmt) {
        this.aFmt = aFmt;
    }

    public Boolean getANotSupport() {
        return aNotSupport;
    }

    public void setANotSupport(Boolean aNotSupport) {
        this.aNotSupport = aNotSupport;
    }

    public String getVFmt() {
        return vFmt;
    }

    public void setVFmt(String vFmt) {
        this.vFmt = vFmt;
    }

    public Boolean getVNotSupport() {
        return vNotSupport;
    }

    public void setVNotSupport(Boolean vNotSupport) {
        this.vNotSupport = vNotSupport;
    }

    public String getVRez() {
        return vRez;
    }

    public void setVRez(String vRez) {
        this.vRez = vRez;
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

    public String getaFmt() {
        return aFmt;
    }

    public void setaFmt(String aFmt) {
        this.aFmt = aFmt;
    }

    public Boolean getaNotSupport() {
        return aNotSupport;
    }

    public void setaNotSupport(Boolean aNotSupport) {
        this.aNotSupport = aNotSupport;
    }

    public String getvFmt() {
        return vFmt;
    }

    public void setvFmt(String vFmt) {
        this.vFmt = vFmt;
    }

    public Boolean getvNotSupport() {
        return vNotSupport;
    }

    public void setvNotSupport(Boolean vNotSupport) {
        this.vNotSupport = vNotSupport;
    }

    public String getvRez() {
        return vRez;
    }

    public void setvRez(String vRez) {
        this.vRez = vRez;
    }

    public Integer getTrace() {
        return trace;
    }

    public void setTrace(Integer trace) {
        this.trace = trace;
    }

    public int traceDef() {
        if (trace != null)
            return trace;
        else
            return OpenStrmReq.TRACE_MODE__DISABLED;
    }

    public StrmReqStatus[] getRequests() {
        return requests;
    }

    public void setRequests(StrmReqStatus[] requests) {
        this.requests = requests;
    }

    public boolean hasReq(String reqId) {
        if (requests != null) {
            for (StrmReqStatus r : requests)
                if (r.getReqId().equals(reqId))
                    return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmStatus.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("initReqId='" + initReqId + "'")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("live=" + live)
                .add("liveDataTyp=" + liveDataTyp)
                .add("codeStrm=" + codeStrm)
                .add("createTm=" + createTm)
                .add("srcDetectTm=" + srcDetectTm)
                .add("ready=" + ready)
                .add("readyTm=" + readyTm)
                .add("closeTm=" + closeTm)
                .add("recv=" + recv)
                .add("byteRate=" + byteRate)
                .add("sendToClnt=" + sendToClnt)
                .add("aFmt='" + aFmt + "'")
                .add("aNotSupport=" + aNotSupport)
                .add("vFmt='" + vFmt + "'")
                .add("vNotSupport=" + vNotSupport)
                .add("vRez='" + vRez + "'")
                .add("frameRate=" + frameRate)
                .add("mediaTyp='" + mediaTyp + "'")
                .add("trace=" + trace)
                .add("requests=" + Arrays.toString(requests))
                .toString();
    }
}
