package com.lucendar.gnss.sdk.clnt;

import okhttp3.Request;

/**
 * 空的 HTTP 鉴权处理器（不做任何事）
 */
public class DummyAuthentication implements ApiAuthentication{

    /**
     * 单例实例
     */
    public static final DummyAuthentication INSTANCE = new DummyAuthentication();

    @Override
    public Request.Builder handle(Request.Builder builder) {
        return builder;
    }
}
