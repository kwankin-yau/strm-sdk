package com.lucendar.strm.common.types;

import java.util.StringJoiner;

/**
 * APP ID限定的终端识别号
 */
public class ScopedSimNo {

    // This character is not allowed appears in both appId and simNo
    public static final String AppIdSimNoSeparator = "|";

    private final String appId;
    private final String simNo;

    public ScopedSimNo(String appId, String simNo) {
        if (appId == null)
            throw new NullPointerException("appId");
        if (simNo == null)
            throw new NullPointerException("simNo");

        this.appId = appId;
        this.simNo = simNo;
    }

    public String getAppId() {
        return appId;
    }

    public String getSimNo() {
        return simNo;
    }

    public String appId() {
        return appId;
    }

    public String simNo() {
        return simNo;
    }

    public static String formatKey(String appId, String simNo) {
        return appId + AppIdSimNoSeparator + simNo;
    }

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
