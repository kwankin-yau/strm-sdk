package com.lucendar.strm.common.strm;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UpdateTimedTokenReq {
        private List<TimedToken> tokens;

        public UpdateTimedTokenReq() {
        }

        public UpdateTimedTokenReq(List<TimedToken> tokens) {
            this.tokens = tokens;
        }

        public List<TimedToken> getTokens() {
            return tokens;
        }

        public void setTokens(List<TimedToken> tokens) {
            this.tokens = tokens;
        }

        public void add(TimedToken token) {
            if (this.tokens == null)
                this.tokens = new ArrayList<>();

            this.tokens.add(token);
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateTimedTokenReq.class.getSimpleName() + "[", "]")
                .add("tokens=" + tokens)
                .toString();
    }
}
