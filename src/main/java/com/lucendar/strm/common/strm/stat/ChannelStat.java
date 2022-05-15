package com.lucendar.strm.common.strm.stat;

import java.util.Arrays;
import java.util.StringJoiner;

public class ChannelStat {
        private String simNo;
        private short chanId;
        private boolean live;
        private Integer liveDataTyp;
        private byte codeStrm;
        private long createTm;
        private Long srcDetectTm;
        private boolean strmReady;
        private Long strmReadyTm;
        private boolean strmClosed;
        private long recvFromTerm;
        private long recvFromTermByteRate;
        private long sendToClnt;
        private String audioFmt;
        private String videoFmt;
        private String videoRes;
        private String mediaTyp;

        private ReqStat[] requests;

        public ChannelStat() {
        }

        public ChannelStat(String simNo,
                           short chanId,
                           boolean live,
                           Integer liveDataTyp,
                           byte codeStrm,
                           long createTm,
                           Long srcDetectTm,
                           boolean strmReady,
                           Long strmReadyTm,
                           boolean strmClosed,
                           long recvFromTerm,
                           long recvFromTermByteRate,
                           long sendToClnt,
                           String audioFmt,
                           String videoFmt,
                           String videoRes,
                           String mediaTyp,
                           ReqStat[] requests
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
            this.strmClosed = strmClosed;
            this.recvFromTerm = recvFromTerm;
            this.recvFromTermByteRate = recvFromTermByteRate;
            this.sendToClnt = sendToClnt;
            this.audioFmt = audioFmt;
            this.videoFmt = videoFmt;
            this.videoRes = videoRes;
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

        public boolean isStrmClosed() {
            return strmClosed;
        }

        public void setStrmClosed(boolean strmClosed) {
            this.strmClosed = strmClosed;
        }

        public long getRecvFromTerm() {
            return recvFromTerm;
        }

        public void setRecvFromTerm(long recvFromTerm) {
            this.recvFromTerm = recvFromTerm;
        }

        public long getRecvFromTermByteRate() {
            return recvFromTermByteRate;
        }

        public void setRecvFromTermByteRate(long recvFromTermByteRate) {
            this.recvFromTermByteRate = recvFromTermByteRate;
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

        public ReqStat[] getRequests() {
            return requests;
        }

        public void setRequests(ReqStat[] requests) {
            this.requests = requests;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ChannelStat.class.getSimpleName() + "[", "]")
                    .add("simNo='" + simNo + "'")
                    .add("chanId=" + chanId)
                    .add("live=" + live)
                    .add("liveDataTyp=" + liveDataTyp)
                    .add("codeStrm=" + codeStrm)
                    .add("createTm=" + createTm)
                    .add("srcDetectTm=" + srcDetectTm)
                    .add("strmReady=" + strmReady)
                    .add("strmReadyTm=" + strmReadyTm)
                    .add("strmClosed=" + strmClosed)
                    .add("recvFromTerm=" + recvFromTerm)
                    .add("recvFromTermByteRate=" + recvFromTermByteRate)
                    .add("sendToClnt=" + sendToClnt)
                    .add("audioFmt='" + audioFmt + "'")
                    .add("videoFmt='" + videoFmt + "'")
                    .add("videoRes='" + videoRes + "'")
                    .add("mediaTyp='" + mediaTyp + "'")
                    .add("requests=" + Arrays.toString(requests))
                    .toString();
        }
    }
