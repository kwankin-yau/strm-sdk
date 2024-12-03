package com.lucendar.gnss.sdk.session;

import java.util.StringJoiner;

/**
 * 设置令牌（代替登录方法）请求
 */
public class SetTokenReq {
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SetTokenReq.class.getSimpleName() + "[", "]")
                .add("authToken='" + authToken + "'")
                .toString();
    }
}
