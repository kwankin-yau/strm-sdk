package com.lucendar.gnss.sdk.evtsrc;

import java.util.StringJoiner;

/**
 * GNSS 事件监听器注册项
 */
public class GnssEventListenerReg {
    private final GnssEventType eventType;
    private final GnssEventListener listener;

    /**
     * 创建 GNSS 事件监听器注册项
     * @param eventType 事件类型
     * @param listener 事件监听器
     */
    public GnssEventListenerReg(GnssEventType eventType, GnssEventListener listener) {
        this.eventType = eventType;
        this.listener = listener;
    }

    /**
     * 获取事件类型
     * @return 事件类型
     */
    public GnssEventType getEventType() {
        return eventType;
    }

    /**
     * 获取事件监听器
     * @return 事件监听器
     */
    public GnssEventListener getListener() {
        return listener;
    }

    /**
     * 创建流媒体事件监听器注册项
     * @param listener 事件监听器
     * @return 流媒体事件监听器注册项
     */
    public static GnssEventListenerReg strm(GnssEventListener listener) {
        return new GnssEventListenerReg(GnssEventType.strm, listener);
    }

    /**
     * 创建音视频上传事件监听器注册项
     * @param listener 事件监听器
     * @return 音视频上传事件监听器注册项
     */
    public static GnssEventListenerReg av_upload(GnssEventListener listener) {
        return new GnssEventListenerReg(GnssEventType.av_upload, listener);
    }

    /**
     * 创建终端命令事件监听器注册项
     * @param listener 事件监听器
     * @return 终端命令事件监听器注册项
     */
    public static GnssEventListenerReg cmd(GnssEventListener listener) {
        return new GnssEventListenerReg(GnssEventType.cmd, listener);
    }

    /**
     * 获取 WebSocket (stomp) 队列目标
     * @param token 令牌
     * @return WebSocket 队列目标
     */
    public String wsDestOfQueue(String token) {
        return "/user/" + token + "/queue/" + eventType.name();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssEventListenerReg.class.getSimpleName() + "[", "]")
                .add("eventType=" + eventType)
                .add("listener=" + listener)
                .toString();
    }
}
