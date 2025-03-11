package com.lucendar.gnss.sdk.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lucendar.gnss.sdk.session.GnssLoginReq;
import com.lucendar.gnss.sdk.session.GnssLoginResult;
import com.lucendar.gnss.sdk.strm.GnssOpenLiveStrmReq;
import com.lucendar.gnss.sdk.strm.GnssOpenReplayStrmReq;
import com.lucendar.gnss.sdk.strm.GnssOpenStrmResult;
import com.lucendar.gnss.sdk.types.GnssApiConnParams;
import com.lucendar.gnss.sdk.types.ReplyTypes;
import com.lucendar.strm.common.strm.KeepStrmReq;
import com.lucendar.strm.common.strm.KeepStrmResult;
import com.lucendar.strm.common.strm.LiveStrmCtrlReq;
import com.lucendar.strm.common.strm.ReleaseStrmsReq;
import com.lucendar.strm.common.strm.ReplayStrmCtrlReq;
import info.gratour.common.error.ErrorWithCode;
import info.gratour.common.types.rest.Reply;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;

import static com.lucendar.gnss.sdk.HttpConsts.HEADER_X_APP_ID;
import static com.lucendar.gnss.sdk.HttpConsts.HEADER_X_AUTH_TOKEN;
import static info.gratour.common.types.rest.Reply.RAW_REPLY_TYPE;

/**
 * GNSS API客户端
 */
public class GnssClient {

    /**
     * 日志记录器
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(GnssClient.class);

    /**
     * Gson构建器
     */
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();

    /**
     * Gson实例
     */
    public static final Gson GSON = GSON_BUILDER.create();

    /**
     * Gson构建器（美化输出）
     */
    public static final GsonBuilder GSON_BUILDER_PRETTY = GSON_BUILDER.setPrettyPrinting();

    /** 
     * Gson实例（美化输出）
     */
    public static final Gson GSON_PRETTY = GSON_BUILDER_PRETTY.create();

    private final MediaType JSON = MediaType.get("application/json");

    /**
     * 创建HTTP客户端
     * @param logging 是否启用日志记录
     * @return HTTP客户端
     */
    protected OkHttpClient createHttpClient(boolean logging) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(15));

        if (logging) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(@NotNull String s) {
                    LOGGER.info(s);
                }
            });
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        return builder.build();
    }

    /**
     * HTTP客户端
     */
    protected final OkHttpClient httpClient;

    /**
     * 令牌
     */
    protected String token;

    /**
     * GNSS API连接参数
     */
    protected final GnssApiConnParams connParams;

    /**
     * HTTP Basic认证授权头值
     */
    protected final String authHeaderValue;

    /**
     * 构造函数
     * @param connParams GNSS API连接参数
     * @param logging 是否启用日志记录
     */
    public GnssClient(
            GnssApiConnParams connParams,
            boolean logging) {

        this.connParams = connParams;

        httpClient = createHttpClient(logging);
        authHeaderValue = connParams.authorizationHeaderValue();
    }

    /**
     * 获取GNSS API连接参数
     * @return GNSS API连接参数
     */
    public GnssApiConnParams getConnParams() {
        return connParams;
    }

    /**
     * 获取令牌
     * @return 令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置令牌
     * @param token 令牌
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取HTTP客户端
     * @return HTTP客户端
     */
    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * 调用API
     * @param endPoint API端点
     * @param request 请求
     * @param responseType 响应类型
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T makeCall(String endPoint, Request request, Type responseType, boolean checkResp) {
        try (Response resp = httpClient.newCall(request).execute()) {
            ResponseBody body = resp.body();
            if (body != null) {
                int httpCategory = resp.code() / 100;

                // TODO: what about status code category is 3xx?
                if (httpCategory != 2) {
                    String message = "API `%s` call return status: %d.";
                    message = String.format(message, endPoint, resp.code());
                    throw new RuntimeException(message);
                }

                String s = body.string();
                T r = GSON.fromJson(s, responseType);
                if (checkResp && !r.ok())
                    throw new ErrorWithCode(r.getErrCode(), r.getMessage());

                return r;
            } else {
                String message = "API `%s` call return empty body: " + resp;
                message = String.format(message, endPoint);
                throw new RuntimeException(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建请求
     * @param endPoint API端点
     * @param method 方法
     * @param body 请求体
     * @return 请求
     */
    protected Request buildRequest(String endPoint, String method, RequestBody body) {
        Request.Builder builder = new Request.Builder()
                .url(connParams.getApiBasePath() + endPoint)
                .header(
                        HttpHeaders.AUTHORIZATION,
                        authHeaderValue
                );

        if (token != null)
            builder.header(HEADER_X_AUTH_TOKEN, token);

        if (connParams.getAppId() != null)
            builder.header(HEADER_X_APP_ID, connParams.getAppId());

        if (body == null &&
                (method.equalsIgnoreCase("POST") || (method.equalsIgnoreCase("PUT")))
        )
            body = RequestBody.create("{}", JSON);

        Request r = builder.method(method, body).build();
        System.out.println(r.toString());
        return r;
    }

    /**
     * 调用API（无请求体）
     * @param endPoint API端点
     * @param responseType 响应类型
     * @param method 方法
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T callWithoutBody(
            String endPoint,
            Type responseType,
            String method,
            boolean checkResp) {
        Request request = buildRequest(endPoint, method, null);
        return makeCall(endPoint, request, responseType, checkResp);
    }

    /**
     * 调用API（有请求体）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @param responseType 响应类型
     * @param method 方法
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T callWithBody(
            String endPoint,
            Object reqBody,
            Type responseType,
            String method,
            boolean checkResp) {
        String json = GSON.toJson(reqBody);

        Request request = buildRequest(endPoint, method, RequestBody.create(json, JSON));
        return makeCall(endPoint, request, responseType, checkResp);
    }

    /**
     * 调用API（POST请求，有请求体）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @param responseType 响应类型
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T postWithBody(String endPoint, Object reqBody, Type responseType, boolean checkResp) {
        return callWithBody(endPoint, reqBody, responseType, "POST", checkResp);
    }

    /**
     * 调用API（POST请求，有请求体）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @param responseType 响应类型
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T postWithBody(String endPoint, Object reqBody, Type responseType) {
        return postWithBody(endPoint, reqBody, responseType, true);
    }

    /**
     * 调用API（PUT请求，有请求体）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @param responseType 响应类型
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T putWithBody(String endPoint, Object reqBody, Type responseType, boolean checkResp) {
        return callWithBody(endPoint, reqBody, responseType, "PUT", checkResp);
    }

    /**
     * 调用API（PUT请求，有请求体）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @param responseType 响应类型
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T putWithBody(String endPoint, Object reqBody, Type responseType) {
        return putWithBody(endPoint, reqBody, responseType, true);
    }

    /**
     * 调用API（POST请求，返回原始响应）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @param checkResp 是否检查响应
     * @return 响应
     */
    protected Reply<Void> postReturnRawReply(String endPoint, Object reqBody, boolean checkResp) {
        return postWithBody(endPoint, reqBody, RAW_REPLY_TYPE, checkResp);
    }

    /**
     * 调用API（POST请求，返回原始响应）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @return 响应
     */
    protected Reply<Void> postReturnRawReply(String endPoint, Object reqBody) {
        return postReturnRawReply(endPoint, reqBody, true);
    }

    /**
     * 调用API（POST请求，无请求体，返回简易响应）
     * @param endPoint API端点
     * @param checkResp 是否检查响应
     * @return 响应
     */
    protected Reply<Void> postWithoutBodyReturnRawReply(String endPoint, boolean checkResp) {
        return callWithoutBody(endPoint, RAW_REPLY_TYPE, "POST", checkResp);
    }

    /**
     * 调用API（POST请求，无请求体，返回简易响应）
     * @param endPoint API端点
     * @return 响应
     */
    protected Reply<Void> postWithoutBodyReturnRawReply(String endPoint) {
        return postWithoutBodyReturnRawReply(endPoint, true);
    }

    /**
     * 调用API（PUT请求，返回简易响应）
     * @param endPoint API端点
     * @param reqBody 请求体
     * @return 响应
     */
    protected Reply<Void> putReturnRawReply(String endPoint, Object reqBody) {
        return putWithBody(endPoint, reqBody, RAW_REPLY_TYPE, true);
    }

    /**
     * 调用API（POST请求，无请求体，返回泛型响应）
     * @param endPoint API端点
     * @param responseType 响应类型
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T postWithoutBody(
            String endPoint,
            Type responseType,
            boolean checkResp) {
        return callWithoutBody(endPoint, responseType, "POST", checkResp);
    }

    /**
     * 调用API（POST请求，无请求体，返回泛型响应）
     * @param endPoint API端点
     * @param responseType 响应类型
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T postWithoutBody(
            String endPoint,
            Type responseType) {
        return postWithoutBody(endPoint, responseType, true);
    }

    /**
     * 调用API（PUT请求，无请求体，返回泛型响应）
     * @param endPoint API端点
     * @param responseType 响应类型
     * @param checkResp 是否检查响应
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T putWithoutBody(
            String endPoint,
            Type responseType,
            boolean checkResp) {
        return callWithoutBody(endPoint, responseType, "PUT", checkResp);
    }

    /**
     * 调用API（PUT请求，无请求体，返回泛型响应）
     * @param endPoint API端点
     * @param responseType 响应类型
     * @param <T> 响应类型
     * @return 响应
     */
    protected <T extends Reply<?>> T putWithoutBody(
            String endPoint,
            Type responseType) {
        return putWithoutBody(endPoint, responseType, true);
    }

    /**
     * 登录。
     *
     * @return 登录结果。
     */
    public GnssLoginResult login() {
        GnssLoginReq req = new GnssLoginReq();
        req.setAppId(connParams.getAppId());
        req.setUserName(connParams.getUsername());
        req.setPassword(connParams.getPassword());

        Reply<GnssLoginResult> reply = postWithBody("/login", req, GnssLoginResult.REPLY_TYPE);
        GnssLoginResult r = reply.first();

        if (token == null)
            token = r.getAuthToken();

        return r;
    }

    /**
     * 注销。使当前使用的token失效。已经打开的、未关闭的媒体流请求将全部被关闭。
     */
    public void logout() {
        if (token == null)
            return;

        try {
            postWithoutBodyReturnRawReply("/logout", false);
        } catch (Throwable t) {
            // suppress exception
        }

        token = null;
    }

    /**
     * 打开实时音视频。
     *
     * @param req 实时音视频流请求。
     * @return 打开流请求返回对象。
     */
    public GnssOpenStrmResult openLive(GnssOpenLiveStrmReq req) {
        Reply<GnssOpenStrmResult> r = postWithBody("/strm/live/open", req, GnssOpenStrmResult.REPLY_TYPE);
        return r.first();
    }

    /**
     * 实时音视频控制。
     *
     * @param req 实时音视频控制请求。
     * @return 请求响应。
     */
    public Reply<Void> liveCtrl(LiveStrmCtrlReq req) {
        return postReturnRawReply("/strm/live/ctrl", req);
    }

    /**
     * 打开远程录像回放。
     *
     * @param req 远程录像回放请求。
     * @return 打开流请求返回对象。
     */
    public GnssOpenStrmResult openReplay(GnssOpenReplayStrmReq req) {
        Reply<GnssOpenStrmResult> r = postWithBody("/strm/replay/open", req, GnssOpenStrmResult.REPLY_TYPE);
        return r.first();
    }

    /**
     * 远程录像回放控制。
     *
     * @param req 远程录像回放控制请求。
     * @return 请求响应。
     */
    public Reply<Void> replayCtrl(ReplayStrmCtrlReq req) {
        return postReturnRawReply("/strm/replay/ctrl", req);
    }

    /**
     * 保持流。
     *
     * @param req 保持流请求体。
     * @return 请求响应。
     */
    public Reply<KeepStrmResult> keep(KeepStrmReq req) {
        return postWithBody("/strm/keep", req, ReplyTypes.REPLY_TYPE__KEEP_STRM_RESULT);
    }

    /**
     * 保持流。
     *
     * @param reqId 保持流请求ID
     * @return 请求响应。
     */
    public Reply<KeepStrmResult> keep(String reqId) {
        KeepStrmReq req = new KeepStrmReq(reqId);
        return keep(req);
    }

    /**
     * 关闭媒体请求。
     *
     * @param req 关闭媒体请求对象。
     */
    public void closeStrms(ReleaseStrmsReq req) {
        try {
            postReturnRawReply("/strm/close", req, false);
        } catch (Throwable t) {
            // suppress exception, mainly for network exception
        }
    }

    /**
     * 关闭单个媒体请求。
     *
     * @param reqId 所要关闭的媒体请求ID
     */
    public void closeStrm(String reqId) {
        ReleaseStrmsReq r = new ReleaseStrmsReq();
        r.setReqIds(new String[]{reqId});

        closeStrms(r);
    }

}
