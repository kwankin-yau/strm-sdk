package com.lucendar.strm.common.strm;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 更新时效令牌请求
 */
public class UpdateTimedTokenReq {
    private List<TimedToken> tokens;

    /**
     * 构造函数
     */
    public UpdateTimedTokenReq() {
    }

    /**
     * 构造函数
     * @param tokens 时效令牌列表
     */
    public UpdateTimedTokenReq(List<TimedToken> tokens) {
        this.tokens = tokens;
    }

    /**
     * 获取时效令牌列表
     * @return 时效令牌列表
     */
    public List<TimedToken> getTokens() {
        return tokens;
    }

    /**
     * 设置时效令牌列表
     * @param tokens 时效令牌列表
     */
    public void setTokens(List<TimedToken> tokens) {
        this.tokens = tokens;
    }

    /**
     * 添加时效令牌
     * @param token 时效令牌
     */
    public void add(TimedToken token) {
        if (this.tokens == null)
            this.tokens = new ArrayList<>();

        this.tokens.add(token);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateTimedTokenReq.class.getSimpleName() + "[", "]")
                .add("tokens=" + tokens)
                .toString();
    }
}
