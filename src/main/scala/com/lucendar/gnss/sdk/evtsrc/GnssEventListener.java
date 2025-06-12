package com.lucendar.gnss.sdk.evtsrc;

/**
 * GNSS 事件监听器
 */
public interface GnssEventListener {

    /**
     * 订阅成功后回调
     * @param eventType 事件类型
     */
    void afterSubscribed(GnssEventType eventType);

    /**
     * 订阅失败后回调
     * @param eventType 事件类型
     * @param t 异常
     */
    void onFailure(GnssEventType eventType, Throwable t);

    /**
     * 收到事件后回调
     * @param event 事件
     */
    void onEvent(GnssEvent event);
}
