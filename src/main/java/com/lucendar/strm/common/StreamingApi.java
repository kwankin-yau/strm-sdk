/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

public class StreamingApi {

    public static final byte STRM_FORMAT__FLV = 0;
    public static final byte STRM_FORMAT__HLS = 1;
    public static final byte STRM_FORMAT__RTMP = 2;
    public static final byte STRM_FORMAT__RAW = 3;

    public static final String CHANNEL_TYPE__LIVE = "live";
    public static final String CHANNEL_TYPE__REPLAY = "replay";

    public static boolean isValidSimNoChar(char c) {
        if (c >= '0' && c <= '9')
            return true;

        if (c >= 'a' && c <= 'z')
            return true;

        if (c >= 'A' && c <= 'Z')
            return true;

        switch (c) {
            case '.':
            case '-':
            case '_':
            case '~':
                return true;

            default:
                return false;
        }
    }

    public static boolean isValidSimNo(String simNo) {
        if (simNo == null || simNo.isEmpty())
            return false;

        for (int i = 0; i < simNo.length(); i++) {
            char c = simNo.charAt(i);
            if (!isValidSimNoChar(c))
                return false;
        }

        return true;
    }


    public static String normalizeSimNo(String simNo) {
        int start = -1;
        for (int i = 0; i < simNo.length(); i++) {
            char c = simNo.charAt(i);
            if (c != '0') {
                start = i;
                break;
            }
        }

        if (start >= 0)
            return simNo.substring(start);
        else
            return simNo;
    }

    public static String encodeStreamName(String simNo, short channelId, boolean live) {
        return normalizeSimNo(simNo) + "_" + channelId + "_" + (live ? "1" : "0");
    }

    /**
     * Check whether an given `reqId` is valid.
     *
     * @param reqId
     * @return
     */
    public static boolean isValidReqId(String reqId) {
        if (reqId == null || reqId.isEmpty())
            return false;

        for (int i = 0; i < reqId.length(); i++) {
            char c = reqId.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c) && c != '-' && c != '_' && c != '.')
                return false;
        }

        return true;
    }

}
