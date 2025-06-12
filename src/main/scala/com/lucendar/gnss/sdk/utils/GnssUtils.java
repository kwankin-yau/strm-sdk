package com.lucendar.gnss.sdk.utils;

import com.lucendar.common.utils.CommonUtils;

/**
 * 工具类
 */
public class GnssUtils {

    /**
     * 创建一个令牌。
     *
     * @return 新的令牌字符串。
     */
    public static String newToken() {
        return CommonUtils.uuidBase64NoPadding();
    }

}
