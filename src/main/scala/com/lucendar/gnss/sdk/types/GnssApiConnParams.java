package com.lucendar.gnss.sdk.types;

import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

import org.springframework.http.HttpHeaders;

/**
 * GNSS API连接参数
 */
public class GnssApiConnParams {

    /**
     * API基础路径
     */
    private final String apiBasePath;
    private final String appId;
    private final String username;
    private final String password;

    /**
     * 构造函数
     * @param apiBasePath API基础路径
     * @param appId 应用ID
     * @param username 用户名
     * @param password 密码
     */
    public GnssApiConnParams(String apiBasePath, String appId, String username, String password) {
        if (apiBasePath.endsWith("/"))
            this.apiBasePath = apiBasePath.substring(0, apiBasePath.length()-1);
        else
            this.apiBasePath = apiBasePath;
        this.appId = appId;
        this.username = username;
        this.password = password;
    }

    /**
     * 获取API基础路径
     * @return API基础路径
     */
    public String getApiBasePath() {
        return apiBasePath;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 获取密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 获取HTTP Basic认证授权头值
     * @return HTTP Basic认证授权头值
     */
    public String authorizationHeaderValue() {
        return "Basic " + HttpHeaders.encodeBasicAuth(username, password, StandardCharsets.UTF_8);
    }

    /**
     * 获取字符串表示
     * @return 字符串表示
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", GnssApiConnParams.class.getSimpleName() + "[", "]")
                .add("apiBasePath='" + apiBasePath + "'")
                .add("appId='" + appId + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
