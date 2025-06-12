/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

import java.nio.ByteBuffer;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.UUID;

import com.lucendar.gnss.sdk.GnssConsts;

/**
 * GT-Streaming API 常量及公用函数
 */
public class StreamingApi {

    /**
     * 验证ID是否符合媒体服务应用的ID格式。ID包括应用ID、流ID、录像ID、终端识别号等。
     * @param id 需要验证的ID
     * @return 如果ID有效，则返回true，否则返回false
     */
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
     * 默认应用ID。
     */
    public static final String DEFAULT_APP_ID = GnssConsts.DEFAULT_APP_ID;

    /**
     * 最大终端识别号长度。
     */
    public static final int MAX_SIM_NO_LENGTH = 64;

    /**
     * 最大JT808 终端识别号长度。
     */
    public static final int MAX_JT808_SIM_NO_LENGTH = 20;


    /**
     * 验证应用ID是否有效。
     * @param appId 需要验证的应用ID
     * @return 如果应用ID有效，则返回true，否则返回false
     */
    public static boolean isValidAppId(String appId) {
        return isValidId(appId);
    }

    /**
     * 流媒体格式/客户端协议：FLV
     */
    public static final byte STRM_FORMAT__FLV = 0;

    /**
     * 流媒体格式/客户端协议：HLS
     */
    public static final byte STRM_FORMAT__HLS = 1;

    /**
     * 流媒体格式/客户端协议：RTMP
     */
    public static final byte STRM_FORMAT__RTMP = 2;

    /**
     * 流媒体格式/客户端协议：RAW （原始码流）
     */
    public static final byte STRM_FORMAT__RAW = 3;

    /**
     * 流媒体格式/客户端协议：RTSP
     */
    public static final byte STRM_FORMAT__RTSP = 4;

    /**
     * 流媒体子格式：FMP4，用于HLS
     */
    public static final String STRM_SUB_FORMAT__FMP4 = "fmp4";

    /**
     * 流媒体子格式：MPEGTS，用于HLS
     */
    public static final String STRM_SUB_FORMAT__MPEGTS = "mpegts";

    /**
     * 通道类型：直播
     */
    public static final String CHANNEL_TYPE__LIVE = "live";

    /**
     * 通道类型：回放
     */
    public static final String CHANNEL_TYPE__REPLAY = "replay";

    /**
     * 媒体类型：音视频
     */
    public static final String MEDIA_TYP__AUDIO_AND_VIDEO = "av";

    /**
     * 媒体类型：音频
     */
    public static final String MEDIA_TYP__AUDIO_ONLY = "a";

    /**
     * 媒体类型：视频
     */
    public static final String MEDIA_TYP__VIDEO_ONLY = "v";


    /**
     * 每个流媒体请求最大的生命期，流媒体请求超过这个时长请求ID将会无效。单位：分钟
     */
    public static final int STRM_REQ_MAX_LIFETIME_MINUTES = 2 * 60;

    /**
     * 远程录像上传请求的最大的生命期，上传请求超过这个时长请求ID将会无效。单位：分钟
     */
    public static final int AV_UPLOAD_REQ_MAX_LIFETIME_MINUTES = 30;

    /**
     * 验证终端识别号字符是否有效。
     * @param c 需要验证的字符
     * @return 如果字符有效，则返回true，否则返回false
     */
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

    /**
     * 验证终端识别号是否有效。
     * @param simNo 需要验证的终端识别号
     * @return 如果终端识别号有效，则返回true，否则返回false
     */
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

    /**
     * 规范化终端识别号。
     * @param simNo 需要规范化的终端识别号
     * @return 规范化后的终端识别号
     */
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

    /**
     * 编码流名称。
     * @param simNo 终端识别号
     * @param channelId 通道ID
     * @param live 是否直播
     * @param talk 是否语音
     * @return 编码后的流名称
     */
    public static String encodeStreamName(String simNo, short channelId, boolean live, boolean talk) {
        return normalizeSimNo(simNo) + "_" + channelId + "_" + (talk ? "2" : (live ? "1" : "0"));
    }

    private static final Base64.Encoder UrlSafeBase64EncoderNoPadding =
            Base64.getUrlEncoder().withoutPadding();

    /**
     * 生成新的请求ID。
     * @return 新的请求ID
     */
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
     * 验证请求ID是否有效。`reqId` 长度范围为8到40，只包含以下字符：
     * <ul>
     *     <li>字母：`a`-`z`, `A`-`Z`</li>
     *     <li>数字：`0`-`9`</li>
     *     <li>其他：`-`, `_`, `.`, '~'</li>
     * </ul>
     *
     * @param reqId 请求ID（用于流或音视频上传）
     * @return 如果请求ID有效，则返回true，否则返回false
     */
    public static boolean isValidReqId(String reqId) {
        if (reqId == null)
            return false;

        int len = reqId.length();

        if (len < 8 || len > 40)
            return false;

        return isValidId(reqId);
    }

    /**
     * 北京时区偏移量。
     */
    public static final ZoneOffset BEIJING_ZONE_OFFSET = ZoneOffset.ofHours(8);
}
