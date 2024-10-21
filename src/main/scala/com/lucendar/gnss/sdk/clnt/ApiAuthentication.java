package com.lucendar.gnss.sdk.clnt;

import okhttp3.Request;

/**
 * API鉴权处理器，用于给 HTTP 请求增加鉴权相关的请求头
 */
public interface ApiAuthentication {

    /**
     * 对 HTTP 请求进行鉴权相关的
     * @param builder HTTP 请求 Builder
     * @return 处理后的HTTP 请求 Builder
     */
    Request.Builder handle(Request.Builder builder);
}
