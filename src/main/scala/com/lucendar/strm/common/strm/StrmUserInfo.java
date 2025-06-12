package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 用户信息
 */
public class StrmUserInfo {

    /**
     * 政府用户
     */
    public static final int USER_GRADE__GOV = 80;

    /**
     * 政府用户(外部)
     */
    public static final int USER_GRADE__GOV_FOREIGN = 70;

    /**
     * 管理员用户
     */
    public static final int USER_GRADE__ADMIN = 50;

    /**
     * 普通用户
     */
    public static final int USER_GRADE__NORMAL = 30;

    private String userId;
    private int userGrade = USER_GRADE__NORMAL;

    /**
     * User access token, used in websocket handler to verify client
     */
    private String token;

    /**
     * 构造函数
     */
    public StrmUserInfo() {
    }

    /**
     * 构造函数
     * @param userId 用户ID
     * @param userGrade 用户等级
     * @param token 用户访问令牌
     */
    public StrmUserInfo(String userId, int userGrade, String token) {
        this.userId = userId;
        this.userGrade = userGrade;
        this.token = token;
    }

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户ID, 如果为空则返回空字符串
     * @return 用户ID
     */
    public String userIdDef() {
        if (userId == null)
            return "";
        else
            return userId;
    }

    /**
     * 获取用户等级
     * @return 用户等级
     */
    public int getUserGrade() {
        return userGrade;
    }

    /**
     * 设置用户等级
     * @param userGrade 用户等级
     */
    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * 是否为政府用户
     * @return 是否为政府用户
     */
    public boolean isGov() {
        return userGrade == USER_GRADE__GOV;
    }

    /**
     * 获取用户访问令牌
     * @return 用户访问令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置用户访问令牌
     * @param token 用户访问令牌
     */
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmUserInfo.class.getSimpleName() + "[", "]")
                .add("userId='" + userId + "'")
                .add("userGrade=" + userGrade)
                .add("token='" + token + "'")
                .toString();
    }
}
