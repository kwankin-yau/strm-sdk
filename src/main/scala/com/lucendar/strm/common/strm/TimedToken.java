package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 时效令牌
 */
public class TimedToken {

    /**
     * 政府平台令牌
     */
    public static final String TIMED_TOKEN_TYP__SUPERVISOR = "supervisor";

    /**
     * 外部政府平台令牌
     */
    public static final String TIMED_TOKEN_TYP__FOREIGN = "foreign";

    /**
     * 客户端令牌
     */
    public static final String TIMED_TOKEN_TYP__CLIENT = "client";

    private String typ;
    private String token;
    private long expiredAt;

    /**
     * 构造函数
     */
    public TimedToken() {
    }

    /**
     * 构造函数
     * @param typ 令牌类型
     * @param token 令牌
     * @param expiredAt 过期时间
     */
    public TimedToken(String typ, String token, long expiredAt) {
        this.typ = typ;
        this.token = token;
        this.expiredAt = expiredAt;
    }

    /**
     * 获取令牌类型
     * @return 令牌类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置令牌类型
     * @param typ 令牌类型
     */
    public void setTyp(String typ) {
        this.typ = typ;
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
     * 获取过期时间， epoch millis
     * @return 过期时间
     */
    public long getExpiredAt() {
        return expiredAt;
    }

    /**
     * 设置过期时间， epoch millis
     * @param expiredAt 过期时间
     */
    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TimedToken.class.getSimpleName() + "[", "]")
                .add("typ='" + typ + "'")
                .add("token='" + token + "'")
                .add("expiredAt=" + expiredAt)
                .toString();
    }
}
