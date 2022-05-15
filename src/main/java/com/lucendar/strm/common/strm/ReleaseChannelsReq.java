package com.lucendar.strm.common.strm;

import java.util.Arrays;
import java.util.StringJoiner;

public class ReleaseChannelsReq {
        private String[] reqIds;

        public ReleaseChannelsReq() {
        }

        public ReleaseChannelsReq(String[] reqIds) {
            this.reqIds = reqIds;
        }

        public String[] getReqIds() {
            return reqIds;
        }

        public void setReqIds(String[] reqIds) {
            this.reqIds = reqIds;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseChannelsReq.class.getSimpleName() + "[", "]")
                .add("reqIds=" + Arrays.toString(reqIds))
                .toString();
    }
}
