package com.lucendar.gnss.sdk.types;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.StringJoiner;

import com.google.gson.reflect.TypeToken;
import com.lucendar.strm.common.StreamingApi;

/**
 * 令牌验证结果
 */
public class TokenValidateResult {

    /**
     * 令牌验证结果的类型
     */
    public static final Type TYPE = new TypeToken<TokenValidateResult>() {
    }.getType();

    private String appId;
    private String userName;
    private Set<String> authorities;

    /**
     * 默认构造函数
     */
    public TokenValidateResult() {
    }

    /**
     * 全参构造函数
     *
     * @param appId       AppId
     * @param userName    用户名
     * @param authorities 用户所具有的授权
     */
    public TokenValidateResult(String appId, String userName, Set<String> authorities) {
        this.appId = appId;
        this.userName = userName;
        this.authorities = authorities;
    }

    /**
     * 取 AppId
     *
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppId
     *
     * @param appId AppId
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
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 取用户具有的授权
     *
     * @return 用户具有的授权
     */
    public Set<String> getAuthorities() {
        return authorities;
    }

    /**
     * 设置用户具有的授权
     *
     * @param authorities 用户具有的授权
     */
    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    /**
     * 取 AppId，如果未设置，则视为默认 AppId
     *
     * @return AppId
     */
    public String appIdDef() {
        if (appId != null)
            return appId;

        return StreamingApi.DEFAULT_APP_ID;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TokenValidateResult.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("userName='" + userName + "'")
                .add("authorities=" + String.join(",", authorities))
                .toString();
    }
}
