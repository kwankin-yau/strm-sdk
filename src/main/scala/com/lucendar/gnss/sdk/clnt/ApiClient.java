package com.lucendar.gnss.sdk.clnt;

import java.io.IOException;
import java.lang.reflect.Type;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lucendar.common.types.KV;
import com.lucendar.common.types.LazyVar;
import com.lucendar.common.types.rest.Pagination;

import info.gratour.common.error.ErrorWithCode;
import info.gratour.common.error.Errors;
import info.gratour.common.types.rest.Reply;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * HTTP API 客户端基类，本类必须是线程安全的
 */
public abstract class ApiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger("apiClient");

    /**
     * JSON 媒体类型
     */
    public static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json; charset=utf-8");

    /**
     * 空字节数组
     */
    private static final byte[] EMPTY_BYTE_ARRAY = {};

    /**
     * 响应转换器接口
     * @param <T> 响应类型
     */
    public interface ReplyConverter<T> {

        /**
         * 从 JSON 字符串转换为响应对象
         * @param gson Gson 实例
         * @param s JSON 字符串
         * @return 响应对象
         */
        T fromJson(Gson gson, String s);
    }

    /**
     * 字符串转换器接口
     * @param <T> 转换后的类型
     */
    public interface StringConverter<T> {
        /**
         * 从 JSON 字符串转换为对象
         * @param s JSON 字符串
         * @return 转换后的对象
         */
        T fromJson(String s);
    }

    /**
     * 获取 Gson 实例
     * @return Gson 实例
     */
    abstract protected Gson gson();

    /**
     * 获取 API 端点 URL
     * @return API 端点 URL
     */
    abstract protected String endPointUrl();

    /**
     * 解析后的 API 端点 URL
     */
    protected LazyVar<HttpUrl> parsedEndPointUrl = new LazyVar<>(() -> HttpUrl.parse(endPointUrl()));

    /**
     * 获取 API 认证实例
     * @return API 认证实例
     */
    abstract protected ApiAuthentication authentication();

    /**
     * 获取 OkHttpClient 实例
     * @return OkHttpClient 实例
     */
    abstract protected OkHttpClient client();

    /**
     * 构建 URL 构建器
     * @param path 路径
     * @return URL 构建器
     */
    protected HttpUrl.Builder urlBuilder(@Nullable String path) {
        var urlBuilder = parsedEndPointUrl.get().newBuilder();
        if (path != null) {
            var paths = path.split("/");
            for (var p : paths)
                urlBuilder.addPathSegment(p);
        }

        return urlBuilder;
    }

    /**
     * 构建 URL 构建器
     * @param path 路径
     * @param params 参数
     * @return URL 构建器
     */
    protected HttpUrl.Builder urlBuilder(@Nullable String path, @Nullable KV... params) {
        var r = urlBuilder(path);
        if (params != null) {
            for (KV kv : params) {
                r.addQueryParameter(kv.key(), kv.value().toString());
            }
        }

        return r;
    }

    /**
     * 构建 POST 请求
     * @param path 路径
     * @param body 请求体
     * @return POST 请求
     */
    protected Request postRequest(@Nullable String path, @NonNull RequestBody body) {
        var builder = new Request.Builder()
                .url(urlBuilder(path).build())
                .post(body);

        return authentication().handle(builder).build();
    }

    /**
     * 构建 JSON 请求体
     * @param json JSON 字符串
     * @return JSON 请求体
     */
    public static RequestBody jsonBody(@Nullable String json) {
        if (json != null)
            return RequestBody.create(json, MEDIA_TYPE_JSON);
        else
            return RequestBody.create(EMPTY_BYTE_ARRAY, null);
    }

    /**
     * 调用GET请求
     * @param resp 响应
     * @param converter 转换器
     * @param <T> 响应类型
     * @return 响应
     */
    public static <T> Reply<T> get(
            @NonNull Response resp,
            @NonNull StringConverter<Reply<T>> converter
    ) {
        var body = resp.body();
        if (body != null) {
            var category = resp.code() / 100;
            if (category != 2)
                throw new ErrorWithCode(
                        Errors.EXECUTION_ERROR,
                        String.format("HTTP status: %d, %s", resp.code(), resp.message())
                );

            try {
                return converter.fromJson(body.string());
            } catch (IOException e) {
                return Reply.error(Errors.IO_ERROR);
            }
        } else
            throw ErrorWithCode.internalError("API Server response empty body: " + resp);
    }

    /**
     * 调用请求
     * @param client OkHttpClient 实例
     * @param req 请求
     * @param converter 转换器
     * @param <T> 响应类型
     * @return 响应
     */
    public static <T> T call(
            @NonNull OkHttpClient client,
            @NonNull Request req,
            @NonNull StringConverter<T> converter) {
        try (final var resp = client.newCall(req).execute()) {
            var body = resp.body();
            if (body != null) {
                var category = resp.code() / 100;
                if (category != 2)
                    throw new ErrorWithCode(
                            Errors.EXECUTION_ERROR,
                            String.format("HTTP status: %d, %s", resp.code(), resp.message())
                    );

                return converter.fromJson(body.string());
            } else
                throw ErrorWithCode.internalError("API Server response empty body: " + resp);
        } catch (ErrorWithCode err) {
            LOGGER.error("Error occurred when call API: " + req.url(), err);
            throw err;
        } catch (Throwable t) {
            var errMsg = "Error occurred when call API: " + req.url();
            LOGGER.error(errMsg, t);
            throw ErrorWithCode.internalError(errMsg);
        }
    }

    /**
     * 调用请求
     * @param req 请求
     * @param converter 转换器
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> T call(@NonNull Request req, @NonNull ReplyConverter<T> converter) {
        try (final var resp = client().newCall(req).execute()) {
            var body = resp.body();
            if (body != null) {
                var category = resp.code() / 100;
                if (category != 2)
                    throw new ErrorWithCode(
                            Errors.EXECUTION_ERROR,
                            String.format("HTTP status: %d, %s", resp.code(), resp.message())
                    );

                return converter.fromJson(gson(), body.string());
            } else
                throw ErrorWithCode.internalError("API Server response empty body: " + resp);
        } catch (ErrorWithCode err) {
            LOGGER.error("Error occurred when call API: " + req.url(), err);
            throw err;
        } catch (Throwable t) {
            var errMsg = "Error occurred when call API: " + req.url();
            LOGGER.error(errMsg, t);
            throw ErrorWithCode.internalError(errMsg);
        }
    }

    /**
     * 调用请求
     * @param req 请求
     * @param typeOfReplyElmt 响应类型
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> Reply<T> call(@NonNull Request req, @NonNull Type typeOfReplyElmt) {
        return call(req, (gson, s) -> gson.fromJson(s, typeOfReplyElmt));
    }

    /**
     * 调用请求
     * @param req 请求
     * @param clzz 响应类型
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> T call(@NonNull Request req, @NonNull Class<T> clzz) {
        return call(req, (gson, s) -> gson.fromJson(s, clzz));
    }

    /**
     * 调用请求，返回 JSON 元素
     * @param req 请求
     * @param <T> 响应类型
     * @return JSON 元素
     */
    public <T> JsonElement callForJson(@NonNull Request req) {
        return call(req, (gson, s) -> JsonParser.parseString(s));
    }

    /**
     * 添加分页参数
     * @param params 参数
     * @param pagination 分页
     * @return 参数
     */
    public KV[] addPaginationParams(@Nullable KV[] params, @Nullable Pagination pagination) {
        if (pagination != null) {
            var paramsLen = params != null ? params.length : 0;

            KV[] r = new KV[paramsLen + 2];
            if (params != null)
                System.arraycopy(params, 0, r, 0, params.length);

            r[paramsLen] = new KV("__limit", pagination.limit);
            r[paramsLen + 1] = new KV("__page", pagination.page);

            return r;
        } else
            return params;
    }

    /**
     * 调用GET请求
     * @param path 路径
     * @param typeOfReplyElmt 响应类型
     * @param reqHooker 请求钩子
     * @param pagination 分页
     * @param params 参数
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> Reply<T> get(
            @Nullable String path,
            @NonNull Type typeOfReplyElmt,
            @Nullable ReqHooker reqHooker,
            @Nullable Pagination pagination,
            @Nullable KV... params) {
        params = addPaginationParams(params, pagination);
        HttpUrl url = urlBuilder(path, params).build();

        var builder = new Request.Builder().url(url);
        var req = authentication().handle(builder).build();
        if (reqHooker != null)
            reqHooker.use(req);

        return call(req, typeOfReplyElmt);
    }

    /**
     * 调用GET请求
     * @param path 路径
     * @param typeOfReplyElmt 响应类型
     * @param reqHooker 请求钩子
     * @param params 参数
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> Reply<T> get(
            @Nullable String path,
            @NonNull Type typeOfReplyElmt,
            @Nullable ReqHooker reqHooker,
            @Nullable KV... params) {
        return get(path, typeOfReplyElmt, reqHooker, null, params);
    }

    /**
     * 调用GET请求
     * @param path 路径
     * @param typeOfReplyElmt 响应类型
     * @param params 参数
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> Reply<T> get(
            @Nullable String path,
            @NonNull Type typeOfReplyElmt,
            @Nullable KV... params) {
        return get(path, typeOfReplyElmt, null, null, params);
    }

    /**
     * 调用POST请求
     * @param path 路径
     * @param typeOfReplyElmt 响应类型
     * @param reqHooker 请求钩子
     * @param body 请求体
     * @param <T> 响应类型
     * @return 响应
     */
    public <T> Reply<T> post(
            @Nullable String path,
            @NonNull Type typeOfReplyElmt,
            @Nullable ReqHooker reqHooker,
            @Nullable Object body) {
        var bodyJson = body != null ? (body instanceof String s ? s : gson().toJson(body)) : null;
        var req = postRequest(path, jsonBody(bodyJson));
        if (reqHooker != null) {
            reqHooker.use(req);
            reqHooker.useBody(bodyJson);
        }

        return call(req, typeOfReplyElmt);
    }

    /**
     * 调用POST请求，返回原始响应
     * @param path 路径
     * @param reqHooker 请求钩子
     * @param body 请求体
     * @return 响应
     */
    public Reply<Void> postRaw(
            @Nullable String path,
            @Nullable ReqHooker reqHooker,
            @Nullable Object body) {
        return post(path, Reply.RAW_REPLY_TYPE, reqHooker, body);
    }

    /**
     * 调用DELETE请求
     * @param path 路径
     * @param reqHooker 请求钩子
     * @param params 参数
     * @return 响应
     */
    public Reply<Void> delete(
            @Nullable String path,
            @Nullable ReqHooker reqHooker,
            @Nullable KV...params
    ) {
        HttpUrl url = urlBuilder(path, params).build();

        var builder = new Request.Builder().url(url);
        var req = authentication().handle(builder).delete().build();
        if (reqHooker != null)
            reqHooker.use(req);

        return call(req, Reply.RAW_REPLY_TYPE);
    }
}
