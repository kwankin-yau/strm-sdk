package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class ServerHint {

        public static final String STRM_SERVER_ID__TEST = "test";

        private String strmServerId;

        public String getStrmServerId() {
            return strmServerId;
        }

        public void setStrmServerId(String strmServerId) {
            this.strmServerId = strmServerId;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", ServerHint.class.getSimpleName() + "[", "]")
                .add("strmServerId='" + strmServerId + "'")
                .toString();
    }
}
