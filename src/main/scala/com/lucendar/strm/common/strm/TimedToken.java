package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class TimedToken {

        public static final String TIMED_TOKEN_TYP__SUPERVISOR = "supervisor";
        public static final String TIMED_TOKEN_TYP__FOREIGN = "foreign";
        public static final String TIMED_TOKEN_TYP__CLIENT = "client";

        private String typ;
        private String token;
        private long expiredAt;

        public TimedToken() {
        }

        public TimedToken(String typ, String token, long expiredAt) {
            this.typ = typ;
            this.token = token;
            this.expiredAt = expiredAt;
        }

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getExpiredAt() {
            return expiredAt;
        }

        public void setExpiredAt(long expiredAt) {
            this.expiredAt = expiredAt;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", TimedToken.class.getSimpleName() + "[", "]")
                .add("typ='" + typ + "'")
                .add("token='" + token + "'")
                .add("expiredAt=" + expiredAt)
                .toString();
    }
}
