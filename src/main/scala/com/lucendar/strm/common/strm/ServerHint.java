package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 流服务器选择提示
 */
public class ServerHint {

    /**
     * 测试流服务器ID
     */
    public static final String STRM_SERVER_ID__TEST = "test";

    /**
     * 期望选用的流服务器ID
     */
    private String strmServerId;

    /**
     * 获取期望选用的流服务器ID
     * @return 期望选用的流服务器ID
     */
    public String getStrmServerId() {
        return strmServerId;
    }

    /**
     * 设置期望选用的流服务器ID
     * @param strmServerId 期望选用的流服务器ID
     */
    public void setStrmServerId(String strmServerId) {
        this.strmServerId = strmServerId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ServerHint.class.getSimpleName() + "[", "]")
                .add("strmServerId='" + strmServerId + "'")
                .toString();
    }
}
