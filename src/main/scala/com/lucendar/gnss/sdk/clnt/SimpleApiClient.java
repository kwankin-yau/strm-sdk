/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.clnt;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

/**
 * 简单的 API 客户端
 */
public class SimpleApiClient extends ApiClient {

    private final Gson gson;
    private final String endPointUrl;
    private final ApiAuthentication authentication;
    private final OkHttpClient httpClient;

    /**
     * 构造函数
     * @param gson Gson 实例
     * @param endPointUrl 端点 URL
     * @param authentication 认证信息
     * @param httpClient OkHttpClient 实例
     */
    public SimpleApiClient(Gson gson, String endPointUrl, ApiAuthentication authentication, OkHttpClient httpClient) {
        this.gson = gson;
        this.endPointUrl = endPointUrl;
        this.authentication = authentication;
        this.httpClient = httpClient;
    }

    @Override
    protected Gson gson() {
        return gson;
    }

    @Override
    protected String endPointUrl() {
        return endPointUrl;
    }

    @Override
    protected ApiAuthentication authentication() {
        return authentication;
    }

    @Override
    protected OkHttpClient client() {
        return httpClient;
    }

}
