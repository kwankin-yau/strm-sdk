/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StreamingApi;

/**
 * URI协议类型
 */
public enum UriScheme {

    /**
     * HTTP
     */
    HTTP("http"),

    /**
     * HTTPS
     */
    HTTPS("https"),

    /**
     * WebSocket
     */
    WS("ws"),

    /**
     * WebSocket Secure
     */
    WSS("wss"),

    /**
     * RTSP
     */
    RTSP("rtsp"),

    /**
     * RTMP
     */
    RTMP("rtmp");

    /**
     * HTTP值
     */
    public static final String HTTP_VALUE = "http";

    /**
     * HTTPS值
     */
    public static final String HTTPS_VALUE = "https";

    /**
     * WebSocket值
     */
    public static final String WS_VALUE = "ws";

    /**
     * WebSocket Secure值
     */
    public static final String WSS_VALUE = "wss";

    /**
     * RTSP值
     */
    public static final String RTSP_VALUE = "rtsp";

    /**
     * RTMP值
     */
    public static final String RTMP_VALUE = "rtmp";

    private String str;

    UriScheme(String str) {
        this.str = str;
    }

    /**
     * 是否为安全协议
     * @return 是否为安全协议
     */
    public boolean isSecure() {
        switch (this) {
            case HTTPS:
            case WSS:
                return true;

            default:
                return false;
        }
    }

    /**
     * 是否为WebSocket家族协议
     * @return 是否为WebSocket家族协议
     */
    public boolean isWebSocketFamily() {
        return this == WS || this == WSS;
    }

    /**
     * 检查给定的协议类型字符串是否为WebSocket家族协议值
     * @param scheme 协议值
     * @return 是否为WebSocket家族协议值
     */
    public static boolean isWebSocketFamilyValue(String scheme) {
        switch (scheme) {
            case WS_VALUE:
            case WSS_VALUE:
                return true;

            default:
                return false;
        }
    }

    /**
     * 是否为HTTP或HTTPS协议
     * @return 是否为HTTP或HTTPS协议
     */
    public boolean isHttpOrHttps() {
        return this == HTTP || this == HTTPS;
    }

    /**
     * 检查给定的协议类型字符串是否为HTTP或HTTPS协议值
     * @param scheme 协议值
     * @return 是否为HTTP或HTTPS协议值
     */
    public static boolean isHttpOrHttpsValue(String scheme) {
        switch (scheme.toLowerCase()) {
            case HTTP_VALUE:
            case HTTPS_VALUE:
                return true;

            default:
                return false;
        }
    }

    /**
     * 获取协议类型字符串
     * @return 协议类型字符串
     */
    public String str() {
        return str;
    }

    /**
     * 检查给定的协议类型字符串是否为有效协议值
     * @param uriScheme 协议类型字符串
     * @return 是否为有效协议值
     */
    public static boolean isValid(String uriScheme) {
        switch (uriScheme) {
            case HTTP_VALUE:
            case HTTPS_VALUE:
            case WS_VALUE:
            case WSS_VALUE:
            case RTSP_VALUE:
            case RTMP_VALUE:
                return true;

            default:
                return false;
        }
    }

    /**
     * 根据给定的协议类型字符串获取协议类型
     * @param uriScheme 协议类型字符串
     * @return 协议类型
     */
    public static UriScheme of(String uriScheme) {
        switch (uriScheme) {
            case HTTP_VALUE:
                return HTTP;

            case HTTPS_VALUE:
                return HTTPS;

            case WS_VALUE:
                return WS;

            case WSS_VALUE:
                return WSS;

            case RTSP_VALUE:
                return RTSP;

            default:
                throw new IllegalArgumentException(String.format("Invalid UriScheme: `%s`.", uriScheme));
        }
    }

    /**
     * 根据给定的流格式和SSL状态获取默认协议类型
     * @param strmFormat 流格式
     * @param sslEnabled SSL状态
     * @return 默认协议类型
     */
    public static UriScheme defaultSchemeOf(int strmFormat, boolean sslEnabled) {
        switch (strmFormat) {
            case StreamingApi.STRM_FORMAT__HLS:
                if (sslEnabled)
                    return HTTPS;
                else
                    return HTTP;

            case StreamingApi.STRM_FORMAT__RTSP:
                return RTSP;

            case StreamingApi.STRM_FORMAT__FLV:
            case StreamingApi.STRM_FORMAT__RAW:
                if (sslEnabled)
                    return WSS;
                else
                    return WS;

            case StreamingApi.STRM_FORMAT__RTMP:
                return RTMP;

            default:
                throw new IllegalArgumentException(String.format("Stream format is not supported: `%d`.", strmFormat));
        }
    }
}
