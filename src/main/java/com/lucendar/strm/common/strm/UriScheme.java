/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StreamingApi;

public enum UriScheme {


    HTTP("http"),
    HTTPS("https"),
    WS("ws"),
    WSS("wss"),
    RTSP("rtsp"),
    RTMP("rtmp");

    public static final String HTTP_VALUE = "http";
    public static final String HTTPS_VALUE = "https";
    public static final String WS_VALUE = "ws";
    public static final String WSS_VALUE = "wss";
    public static final String RTSP_VALUE = "rtsp";
    public static final String RTMP_VALUE = "rtmp";

    private String str;

    UriScheme(String str) {
        this.str = str;
    }

    public boolean isSecure() {
        switch (this) {
            case HTTPS:
            case WSS:
                return true;

            default:
                return false;
        }
    }

    public boolean isWebSocketFamily() {
        return this == WS || this == WSS;
    }

    public static boolean isWebSocketFamilyValue(String scheme) {
        switch (scheme) {
            case WS_VALUE:
            case WSS_VALUE:
                return true;

            default:
                return false;
        }
    }

    public boolean isHttpOrHttps() {
        return this == HTTP || this == HTTPS;
    }

    public static boolean isHttpOrHttpsValue(String scheme) {
        switch (scheme.toLowerCase()) {
            case HTTP_VALUE:
            case HTTPS_VALUE:
                return true;

            default:
                return false;
        }
    }

    public String str() {
        return str;
    }

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
