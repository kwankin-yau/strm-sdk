package com.lucendar.gnss.sdk.clnt;

import java.util.function.Consumer;

import okhttp3.Request;

/**
 * 请求钩子接口
 */
public interface ReqHooker extends Consumer<Request> {

    /**
     * 使用请求
     * @param req 请求
     * @param method 方法
     * @param path 路径
     * @param qryParams 查询参数
     */
    void use(Request req, String method, String path, String qryParams);

    /**
     * 使用请求体
     * @param body 请求体
     */
    void useBody(String body);

    /**
     * 使用请求
     * @param req 请求
     */
    default void use(Request req) {
        var url = req.url();
        var method = req.method();
        var path = url.encodedPath();
        var qryParams = url.encodedQuery();

        use(req, method, path, qryParams);
    }


    @Override
    default void accept(Request request) {
        use(request);
    }
}
