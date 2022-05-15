package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.Arrays;
import java.util.StringJoiner;

public class ReleaseChannelsReq implements StrmMsg {
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

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__ReleaseChannelsReq;
    }
}
