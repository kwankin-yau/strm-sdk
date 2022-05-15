package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class OpenChannelResult {

        private String reqId;
        private boolean ctrl;
        private boolean strmReady;
        private String mediaTyp;
        private String playUrl;
        private String wsUrl;
        private String taUrl;
//        private String wssUrl;
        private int keepIntervalSeconds;
        private String host;
        private int port;
        private boolean tcp;
        private int port2019;
        private boolean tcp2019;

        public OpenChannelResult() {
        }

        public OpenChannelResult(String reqId, boolean ctrl, boolean strmReady, String mediaTyp, String playUrl, String wsUrl,
                                 String taUrl,
                                 int keepIntervalSeconds, String host, int port, boolean tcp,
                                 int port2019, boolean tcp2019) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.strmReady = strmReady;
            this.mediaTyp = mediaTyp;
            this.playUrl = playUrl;
            this.wsUrl = wsUrl;
            this.taUrl = taUrl;
            this.keepIntervalSeconds = keepIntervalSeconds;
            this.host = host;
            this.port = port;
            this.tcp = tcp;
            this.port2019 = port2019;
            this.tcp2019 = tcp2019;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public boolean isCtrl() {
            return ctrl;
        }

        public void setCtrl(boolean ctrl) {
            this.ctrl = ctrl;
        }

        public boolean isStrmReady() {
            return strmReady;
        }

        public void setStrmReady(boolean strmReady) {
            this.strmReady = strmReady;
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

        public int getKeepIntervalSeconds() {
            return keepIntervalSeconds;
        }

        public void setKeepIntervalSeconds(int keepIntervalSeconds) {
            this.keepIntervalSeconds = keepIntervalSeconds;
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

        @Override
        public String toString() {
            return new StringJoiner(", ", OpenChannelResult.class.getSimpleName() + "[", "]")
                    .add("reqId='" + reqId + "'")
                    .add("ctrl=" + ctrl)
                    .add("strmReady=" + strmReady)
                    .add("mediaTyp='" + mediaTyp + "'")
                    .add("playUrl='" + playUrl + "'")
                    .add("wsUrl='" + wsUrl + "'")
                    .add("taUrl='" + taUrl + "'")
                    .add("keepIntervalSeconds=" + keepIntervalSeconds)
                    .add("host='" + host + "'")
                    .add("port=" + port)
                    .add("tcp=" + tcp)
                    .add("port2019=" + port2019)
                    .add("tcp2019=" + tcp2019)
                    .toString();
        }
    }
