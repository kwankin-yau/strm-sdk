/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common;

/**
 * ADAS 方言枚举。用于标识各省 ADAS 标准
 */
public enum AdasDialect {

    /**
     * 川标
     */
    SI_CHUAN(JT808Consts.ProtocolVersions.PROTO_VER__REV2013),

    /**
     * 粤标
     */
    GUANG_DONG(JT808Consts.ProtocolVersions.PROTO_VER__REV2019),

    /**
     * 湘标
     */
    HU_NAN(JT808Consts.ProtocolVersions.PROTO_VER__REV2013),

    /**
     * 苏标
     */
    JIANG_SU(JT808Consts.ProtocolVersions.PROTO_VER__REV2013),

    /**
     * 渝标
     */
    CHONG_QING(JT808Consts.ProtocolVersions.PROTO_VER__REV2013);

    private final int minProtoVer;

    AdasDialect(int minProtoVer) {
        this.minProtoVer = minProtoVer;
    }

    /**
     * 返回方言支持的最小的JT/T 808 协议版本号（参见 {@link JT808Consts.ProtocolVersions}）
     *
     * @return 方言支持的最小的JT/T 808 协议版本号
     */
    public int getMinProtoVer() {
        return minProtoVer;
    }

    /**
     * 默认的 ADAS 言
     */
    public static final AdasDialect DEFAULT = AdasDialect.GUANG_DONG;

    /**
     * 将字符串转换成 AdasDialect 枚举，如果给定 `name` 参数为 null，返回给定的 `defaultValue`
     *
     * @param name         AdasDialect 的文本字面量
     * @param defaultValue 当 `name` 为 null 时返回的默认值
     * @return AdasDialect 枚举
     */
    public static AdasDialect valueOfDefault(String name, AdasDialect defaultValue) {
        if (name == null)
            return defaultValue;
        else
            return valueOf(name);
    }

    /**
     * 将字符串转换成 AdasDialect 枚举，如果给定 `name` 参数为 null，返回默认的 ADAS 方言（见 {@link AdasDialect#DEFAULT}）
     *
     * @param name AdasDialect 的文本字面量
     * @return AdasDialect 枚举
     */
    public static AdasDialect valueOfDefault(String name) {
        return valueOfDefault(name, DEFAULT);
    }
}
