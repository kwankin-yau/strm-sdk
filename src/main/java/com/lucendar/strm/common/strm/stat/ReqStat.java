package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

public class ReqStat {
        private String reqId;
        private String userId;
        private long reqTm;
        private int proto;
        private int closeCause;
        private long lastKeepTm;

        public ReqStat() {
        }

        public ReqStat(String reqId, String userId, long reqTm, int proto, int closeCause, long lastKeepTm) {
            this.reqId = reqId;
            this.userId = userId;
            this.reqTm = reqTm;
            this.proto = proto;
            this.closeCause = closeCause;
            this.lastKeepTm = lastKeepTm;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public long getReqTm() {
            return reqTm;
        }

        public void setReqTm(long reqTm) {
            this.reqTm = reqTm;
        }

        public int getProto() {
            return proto;
        }

        public void setProto(int proto) {
            this.proto = proto;
        }

        public int getCloseCause() {
            return closeCause;
        }

        public void setCloseCause(int closeCause) {
            this.closeCause = closeCause;
        }

        public long getLastKeepTm() {
            return lastKeepTm;
        }

        public void setLastKeepTm(long lastKeepTm) {
            this.lastKeepTm = lastKeepTm;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ReqStat.class.getSimpleName() + "[", "]")
                    .add("reqId='" + reqId + "'")
                    .add("userId='" + userId + "'")
                    .add("reqTm=" + reqTm)
                    .add("proto=" + proto)
                    .add("closeCause=" + closeCause)
                    .add("lastKeepTm=" + lastKeepTm)
                    .toString();
        }
    }
