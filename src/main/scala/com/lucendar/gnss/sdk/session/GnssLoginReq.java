package com.lucendar.gnss.sdk.session;

import org.jetbrains.annotations.NotNull;

import java.util.StringJoiner;

/**
 * 登录请求
 */
public class GnssLoginReq {
    private String appId;
    private String userName;
    private String password;

    public GnssLoginReq() {
    }

    /**
     * 构造函数
     *
     * @param appId App ID
     * @param userName 用户名
     * @param password 密码
     */
    public GnssLoginReq(@NotNull String appId, @NotNull String userName, @NotNull String password) {
        this.appId = appId;
        this.userName = userName;
        this.password = password;
    }

    /**
     * 取 APP ID
     * @return APP ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 APP ID
     * @param appId APP ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取用户名
     *
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 取密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssLoginReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
