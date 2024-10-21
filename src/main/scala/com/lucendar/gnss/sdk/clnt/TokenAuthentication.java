package com.lucendar.gnss.sdk.clnt;

import okhttp3.Request;

/**
 * 令牌鉴权处理器，往 请求中增加 `X-Auth-Token` 请求头
 */
public class TokenAuthentication implements ApiAuthentication {

    private volatile String authToken;

    /**
     * 取是否有鉴权令牌
     * @return 是否有鉴权令牌
     */
    public boolean hasAuthToken() {
        return authToken != null;
    }

    /**
     * 取鉴权令牌
     * @return 鉴权令牌
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * 设置鉴权令牌
     * @param authToken 鉴权令牌
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Request.Builder handle(Request.Builder builder) {
        if (authToken != null)
            builder.addHeader("X-Auth-Token", authToken);

        return builder;
    }
}
