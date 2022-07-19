package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class StrmUserInfo {

    public static final int USER_GRADE__GOV = 80;
    public static final int USER_GRADE__GOV_FOREIGN = 70;
    public static final int USER_GRADE__ADMIN = 50;
    public static final int USER_GRADE__NORMAL = 30;

    private String userId;
    private int userGrade = USER_GRADE__NORMAL;

    /**
     * User access token, used in websocket handler to verify client
     */
    private String token;

    public StrmUserInfo() {
    }

    public StrmUserInfo(String userId, int userGrade, String token) {
        this.userId = userId;
        this.userGrade = userGrade;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String userIdDef() {
        if (userId == null)
            return "";
        else
            return userId;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public boolean isGov() {
        return userGrade == USER_GRADE__GOV;
    }

    public String getToken() {
        return token;
    }

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
