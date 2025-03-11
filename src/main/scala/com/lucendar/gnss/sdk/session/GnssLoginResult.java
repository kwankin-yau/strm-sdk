package com.lucendar.gnss.sdk.session;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

import com.google.gson.reflect.TypeToken;
import com.lucendar.common.utils.DateTimeUtils;
import com.lucendar.gnss.sdk.gateway.ServerInfo;

import info.gratour.common.types.rest.Reply;

/**
 * 登录返回项
 */
public class GnssLoginResult extends ServerInfo {

    /**
     * 登录返回项类型
     */
    public static final Type REPLY_TYPE = new TypeToken<Reply<GnssLoginResult>>(){}.getType();

    /**
     * 鉴权令牌
     */
    private String authToken;

    /**
     * 构造函数
     */
    public GnssLoginResult() {
    }

    /**
     * 构造函数
     *
     * @param authToken 令牌
     * @param ver 服务端版本号
     * @param startTm 启动时间, epoch millis
     * @param instance 实例ID
     * @param features 特征列表
     * @param config 配置
     * @param api API URL
     */
    public GnssLoginResult(String authToken, String ver, long startTm, String instance, String[] features, Map<String, String> config,
                           String api) {
        this.authToken = authToken;
        setVer(ver);
        setStartTm(startTm);
        setInstance(instance);
        setFeatures(features);
        setConfig(config);
        setApi(api);
    }

    /**
     * 取鉴权令牌
     *
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
    public String toString() {
        return new StringJoiner(", ", GnssLoginResult.class.getSimpleName() + "[", "]")
                .add("authToken='" + authToken + "'")
                .add("ver='" + getVer() + "'")
                .add("startTm=" + DateTimeUtils.millisToOffsetDateTimeString(getStartTm()))
                .add("instance='" + getInstance() + "'")
                .add("features=" + Arrays.toString(getFeatures()))
                .add("config=" + getConfig())
                .add("api=" + getApi())
                .toString();
    }
}
