package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class StrmCtrlResult {
        private String reqId;
        private String simNo;
        private short channelId;
        private boolean live;
        private boolean ctrl;

        public StrmCtrlResult() {
        }

        public StrmCtrlResult(String reqId, String simNo, short channelId, boolean live, boolean ctrl) {
            this.reqId = reqId;
            this.simNo = simNo;
            this.channelId = channelId;
            this.live = live;
            this.ctrl = ctrl;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChannelId() {
            return channelId;
        }

        public void setChannelId(short channelId) {
            this.channelId = channelId;
        }

        public boolean isLive() {
            return live;
        }

        public void setLive(boolean live) {
            this.live = live;
        }

        public boolean isCtrl() {
            return ctrl;
        }

        public void setCtrl(boolean ctrl) {
            this.ctrl = ctrl;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmCtrlResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("channelId=" + channelId)
                .add("live=" + live)
                .add("ctrl=" + ctrl)
                .toString();
    }
}
