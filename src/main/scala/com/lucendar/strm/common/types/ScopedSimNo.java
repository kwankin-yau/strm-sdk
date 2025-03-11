package com.lucendar.strm.common.types;

import java.util.StringJoiner;

/**
 * APP ID限定的终端识别号
 */
public class ScopedSimNo {

    /**
     * 应用ID和终端识别号之间的分隔符。
     * This character is not allowed appears in both appId and simNo.
     */
    public static final String AppIdSimNoSeparator = "|";

    private final String appId;
    private final String simNo;

    /**
     * 构造函数
     * @param appId 应用ID
     * @param simNo 终端识别号
     */
    public ScopedSimNo(String appId, String simNo) {
        if (appId == null)
            throw new NullPointerException("appId");
        if (simNo == null)
            throw new NullPointerException("simNo");

        this.appId = appId;
        this.simNo = simNo;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String appId() {
        return appId;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String simNo() {
        return simNo;
    }

    /**
     * 格式化 `AppID|终端识别号` 键
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return `AppID|终端识别号` 键
     */
    public static String formatKey(String appId, String simNo) {
        return appId + AppIdSimNoSeparator + simNo;
    }

    /**
     * 获取 `AppID|终端识别号` 键
     * @return `AppID|终端识别号` 键
     */
    public String key() {
        return formatKey(appId, simNo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ScopedSimNo.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScopedSimNo that = (ScopedSimNo) o;

        if (!appId.equals(that.appId)) return false;
        return simNo.equals(that.simNo);
    }

    @Override
    public int hashCode() {
        int result = appId.hashCode();
        result = 31 * result + simNo.hashCode();
        return result;
    }
}
