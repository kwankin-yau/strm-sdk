package com.lucendar.gnss.sdk.config;

import java.util.StringJoiner;

import info.gratour.common.error.ErrorWithCode;
import info.gratour.common.error.Errors;

/**
 * 流媒体配置
 */
public class StrmMediaConfig implements Cloneable {

    private String instanceId;
    private boolean disabled;
    private String apiUrl;
    private String username;
    private String password;

    /**
     * 获取实例ID
     * @return 实例ID
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * 设置实例ID
     * @param instanceId 实例ID
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 获取是否禁用
     * @return 是否禁用
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * 设置是否禁用
     * @param disabled 是否禁用
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 获取API URL
     * @return API URL
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * 设置API URL
     * @param apiUrl API URL
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
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

    /**
     * 验证并设置默认值
     */
    public void validateAndSettle() {
        if (instanceId == null || instanceId.isEmpty())
            throw new ErrorWithCode(Errors.INVALID_CONFIG, "strm.instanceId");

        if (!disabled) {
            if (apiUrl == null || apiUrl.isEmpty())
                throw new ErrorWithCode(Errors.INVALID_CONFIG, "strm.apiUrl");

            if (username == null || username.isEmpty())
                throw new ErrorWithCode(Errors.INVALID_CONFIG, "strm.username");

            if (password == null || password.isEmpty())
                throw new ErrorWithCode(Errors.INVALID_CONFIG, "strm.password");
        }
    }


    @Override
    public StrmMediaConfig clone() {
        try {
            return (StrmMediaConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmMediaConfig.class.getSimpleName() + "[", "]")
                .add("instanceId='" + instanceId + "'")
                .add("disabled=" + disabled)
                .add("apiUrl='" + apiUrl + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
