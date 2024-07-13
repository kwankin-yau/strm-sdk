package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class OpenStrmResult {

    private String reqId;
    private int channel;
    private boolean ctrl;
    private boolean ready;
    private String mediaTyp;
    private String playUrl;
    private String wsUrl;
    private String taUrl;
    private int keepIntv;
    private String host;
    private int port;
    private boolean tcp;
    private int port2019;
    private boolean tcp2019;
    private Boolean recording;
    private AudioConfig audioConfig;
    private Boolean detectMediaTyp;

    public OpenStrmResult() {
    }

    public OpenStrmResult(String reqId, int channel, boolean ctrl, boolean ready, String mediaTyp, String playUrl, String wsUrl,
                          String taUrl,
                          int keepIntv, String host, int port, boolean tcp,
                          int port2019, boolean tcp2019, Boolean recording, AudioConfig audioConfig,
                          Boolean detectMediaTyp) {
        this.reqId = reqId;
        this.channel = channel;
        this.ctrl = ctrl;
        this.ready = ready;
        this.mediaTyp = mediaTyp;
        this.playUrl = playUrl;
        this.wsUrl = wsUrl;
        this.taUrl = taUrl;
        this.keepIntv = keepIntv;
        this.host = host;
        this.port = port;
        this.tcp = tcp;
        this.port2019 = port2019;
        this.tcp2019 = tcp2019;
        this.recording = recording;
        this.audioConfig = audioConfig;
        this.detectMediaTyp = detectMediaTyp;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public boolean isCtrl() {
        return ctrl;
    }

    public void setCtrl(boolean ctrl) {
        this.ctrl = ctrl;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getWsUrl() {
        return wsUrl;
    }

    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    public String getTaUrl() {
        return taUrl;
    }

    public void setTaUrl(String taUrl) {
        this.taUrl = taUrl;
    }

    public int getKeepIntv() {
        return keepIntv;
    }

    public void setKeepIntv(int keepIntv) {
        this.keepIntv = keepIntv;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isTcp() {
        return tcp;
    }

    public void setTcp(boolean tcp) {
        this.tcp = tcp;
    }

    public int getPort2019() {
        return port2019;
    }

    public void setPort2019(int port2019) {
        this.port2019 = port2019;
    }

    public boolean isTcp2019() {
        return tcp2019;
    }

    public void setTcp2019(boolean tcp2019) {
        this.tcp2019 = tcp2019;
    }

    public Boolean getRecording() {
        return recording;
    }

    public void setRecording(Boolean recording) {
        this.recording = recording;
    }

    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    @Override
    public String toString() {
        return "OpenStrmResult{" +
                "reqId='" + reqId + '\'' +
                ", channel=" + channel +
                ", ctrl=" + ctrl +
                ", ready=" + ready +
                ", mediaTyp='" + mediaTyp + '\'' +
                ", playUrl='" + playUrl + '\'' +
                ", wsUrl='" + wsUrl + '\'' +
                ", taUrl='" + taUrl + '\'' +
                ", keepIntv=" + keepIntv +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", tcp=" + tcp +
                ", port2019=" + port2019 +
                ", tcp2019=" + tcp2019 +
                ", recording=" + recording +
                ", audioConfig=" + audioConfig +
                ", detectMediaTyp=" + detectMediaTyp +
                '}';
    }
}
