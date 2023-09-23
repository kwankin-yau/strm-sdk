package com.lucendar.strm.common.gateway;

import java.util.StringJoiner;

public class GnssLoginReq {
    private String appId;
    private String userName;
    private String password;
    private String token;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssLoginReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("token='" + token + "'")
                .toString();
    }
}
