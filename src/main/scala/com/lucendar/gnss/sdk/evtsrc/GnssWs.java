package com.lucendar.gnss.sdk.evtsrc;

/**
 * GNSS WebSocket 接口
 */
public interface GnssWs extends GnssEventSource{

    /**
     * 默认连接超时时间
     */
    int DEFAULT_CONNECT_TIMEOUT = 6;

    /**
     * 默认重连间隔
     */
    int DEFAULT_RECONNECT_INTERVAL = 10;

    /**
     * 是否已连接
     * @return 是否已连接
     */
    boolean isConnected();

    /**
     * 是否活跃
     * @return 是否活跃
     */
    boolean isActive();

    /**
     * 打开连接
     */
    void open();

    /**
     * 关闭连接
     */
    void close();


}

