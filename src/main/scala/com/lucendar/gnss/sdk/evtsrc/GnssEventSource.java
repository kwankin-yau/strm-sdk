package com.lucendar.gnss.sdk.evtsrc;

/**
 * GNSS 事件源
 */
public interface GnssEventSource {
    
    /**
     * 立即释放资源
     */
    void cancel();
}
