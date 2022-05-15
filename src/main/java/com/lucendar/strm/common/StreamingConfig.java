package com.lucendar.strm.common;

import java.util.StringJoiner;

public class StreamingConfig {
        private int maxLivePlayTimeInSeconds;
        private String externalServerAddr;

        public int getMaxLivePlayTimeInSeconds() {
            return maxLivePlayTimeInSeconds;
        }

        public void setMaxLivePlayTimeInSeconds(int maxLivePlayTimeInSeconds) {
            this.maxLivePlayTimeInSeconds = maxLivePlayTimeInSeconds;
        }

        public String getExternalServerAddr() {
            return externalServerAddr;
        }

        public void setExternalServerAddr(String externalServerAddr) {
            this.externalServerAddr = externalServerAddr;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", StreamingConfig.class.getSimpleName() + "[", "]")
                .add("maxLivePlayTimeInSeconds=" + maxLivePlayTimeInSeconds)
                .add("externalServerAddr='" + externalServerAddr + "'")
                .toString();
    }
}
