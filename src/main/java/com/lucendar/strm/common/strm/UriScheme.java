/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

public enum UriScheme {
    HTTP("http"),
    HTTPS("https"),
    WS("ws"),
    WSS("wss");

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

    public String str() {
        return str;
    }

    public static boolean isValid(String uriScheme) {
        switch (uriScheme.toLowerCase()) {
            case "http":
            case "https":
            case "ws":
            case "wss":
                return true;

            default:
                return false;
        }
    }

    public static UriScheme of(String uriScheme) {
        switch (uriScheme.toLowerCase()) {
            case "http":
                return HTTP;
            case "https":
                return HTTPS;
            case "ws":
                return WS;
            case "wss":
                return WSS;

            default:
                throw new IllegalArgumentException(String.format("Invalid UriScheme: `%s`.", uriScheme));
        }
    }
}
