package com.lucendar.strm.common;

import java.util.StringJoiner;

/**
 * 流媒体配置
 */
public class StreamingConfig {
    private int maxLivePlayTimeInSeconds;
    private String externalServerAddr;

    /**
     * 获取最大实时播放时间（秒）
     * @return 最大实时播放时间（秒）
     */
    public int getMaxLivePlayTimeInSeconds() {
        return maxLivePlayTimeInSeconds;
    }

    /**
     * 设置最大实时播放时间（秒）
     * @param maxLivePlayTimeInSeconds 最大实时播放时间（秒）
     */ 
    public void setMaxLivePlayTimeInSeconds(int maxLivePlayTimeInSeconds) {
        this.maxLivePlayTimeInSeconds = maxLivePlayTimeInSeconds;
    }

    /**
     * 获取外部可访问的服务器地址
     * @return 外部可访问的服务器地址
     */
    public String getExternalServerAddr() {
        return externalServerAddr;
    }

    /**
     * 设置外部可访问的服务器地址
     * @param externalServerAddr 外部可访问的服务器地址
     */
    public void setExternalServerAddr(String externalServerAddr) {
        this.externalServerAddr = externalServerAddr;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StreamingConfig.class.getSimpleName() + "[", "]")
                .add("maxLivePlayTimeInSeconds=" + maxLivePlayTimeInSeconds)
                .add("externalServerAddr='" + externalServerAddr + "'")
                .toString();
    }
}
