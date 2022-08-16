/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

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
     * Check whether given `reqId` is valid or not. The `reqId` with length range from 8 to 40 and contains
     * only following characters are treat as valid:
     * <ul>
     *     <li>letters: `a`-`z`, `A`-`Z`</li>
     *     <li>digests: `0`-`9`</li>
     *     <li>others: `-`, `_`, `.`, '~'</li>
     * </ul>
     *
     * @param reqId request ID (for stream or A/V upload).
     * @return whether given `reqId` is valid or not.
     */
    public static boolean isValidReqId(String reqId) {
        if (reqId == null)
            return false;

        int len = reqId.length();

        if (len < 8 || len > 40)
            return false;

        for (int i = 0; i < reqId.length(); i++) {
            char c = reqId.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                switch (c) {
                    case '-':
                    case '_':
                    case '.':
                    case '~':
                        break;

                    default:
                        return false;
                }
            }
        }

        return true;
    }

    public static String timeCodedId(long time) {
        UUID uuid = UUID.randomUUID();
        byte[] bytes = new byte[16 + 8];
        ByteBuffer bb = ByteBuffer.wrap(bytes);

        bb.putLong(time);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return Base64.getUrlEncoder().encodeToString(bytes);
    }

    public static long extractTimeFromId(String id) {
        byte[] bytes = Base64.getUrlDecoder().decode(id);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return bb.getLong();
    }

}
