/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

import com.lucendar.gnss.sdk.GnssConsts;

import java.nio.ByteBuffer;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.UUID;

public class StreamingApi {

    public static boolean isValidId(String id) {
        if (id == null)
            return false;

        if (id.isEmpty())
            return true;

        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                switch (c) {
                    case '_':
                    case '-':
                    case '$':
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


    /**
     * Default application ID.
     */
    public static final String DEFAULT_APP_ID = GnssConsts.DEFAULT_APP_ID;

    public static final int MAX_SIM_NO_LENGTH = 64;
    public static final int MAX_JT808_SIM_NO_LENGTH = 20;


    public static boolean isValidAppId(String appId) {
        return isValidId(appId);
    }

    public static final byte STRM_FORMAT__FLV = 0;
    public static final byte STRM_FORMAT__HLS = 1;
    public static final byte STRM_FORMAT__RTMP = 2;
    public static final byte STRM_FORMAT__RAW = 3;
    public static final byte STRM_FORMAT__RTSP = 4;

    public static final String STRM_SUB_FORMAT__FMP4 = "fmp4";
    public static final String STRM_SUB_FORMAT__MPEGTS = "mpegts";

    public static final String CHANNEL_TYPE__LIVE = "live";
    public static final String CHANNEL_TYPE__REPLAY = "replay";


    /**
     * 每个流媒体请求最大的生命期，流媒体请求超过这个时长请求ID将会无效。单位：分钟
     */
    public static final int STRM_REQ_MAX_LIFETIME_MINUTES = 2 * 60;

    /**
     * 远程录像上传请求的最大的生命期，上传请求超过这个时长请求ID将会无效。单位：分钟
     */
    public static final int AV_UPLOAD_REQ_MAX_LIFETIME_MINUTES = 30;

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

        if (simNo.length() > MAX_SIM_NO_LENGTH)
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
        boolean allDigit = true;
        for (int i = 0; i < simNo.length(); i++) {
            char c = simNo.charAt(i);
            if (c >= '0' && c <= '9') {
                // find out first non-zero digit position
                if (start < 0 && c != '0') {
                    start = i;
                }
            } else
                allDigit = false;
        }

        if (allDigit && start >= 0)
            return simNo.substring(start);
        else
            return simNo;
    }

    public static String encodeStreamName(String simNo, short channelId, boolean live, boolean talk) {
        return normalizeSimNo(simNo) + "_" + channelId + "_" + (talk ? "2" : (live ? "1" : "0"));
    }

    private static final Base64.Encoder UrlSafeBase64EncoderNoPadding =
            Base64.getUrlEncoder().withoutPadding();

    public static String newReqId() {
        UUID uuid = UUID.randomUUID();
        byte[] bytes = new byte[16];
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        String r = UrlSafeBase64EncoderNoPadding.encodeToString(bytes);
        int idx = r.indexOf('='); // remove the ending `=` character
        if (idx > 0)
            r = r.substring(0, idx);

        return r;
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

        return isValidId(reqId);
    }

    public static final ZoneOffset BEIJING_ZONE_OFFSET = ZoneOffset.ofHours(8);
}
