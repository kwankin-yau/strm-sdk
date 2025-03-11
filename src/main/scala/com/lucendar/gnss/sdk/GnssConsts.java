/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lucendar.common.Consts;
import com.lucendar.strm.common.StreamingApi;
import info.gratour.jt808common.mat.TermCmdMaterializer;
import info.gratour.jt808common.mat.TermCmdStateChangedMaterializer;
import info.gratour.jt808common.spi.model.TermCmd;
import info.gratour.jt808common.spi.model.TermCmdStateChanged;

import java.util.ArrayList;

/**
 * 常量类
 */
public class GnssConsts {

    /**
     * 构造GsonBuilder实例
     * @return GsonBuilder实例
     */
    public static GsonBuilder GSON_BUILDER() {
        return Consts.defaultGsonBuilder()
                .registerTypeAdapter(TermCmd.class, new TermCmdMaterializer())
                .registerTypeAdapter(TermCmdStateChanged.class, new TermCmdStateChangedMaterializer());
    }

    /**
     * Gson实例
     */
    public static final Gson GSON = GSON_BUILDER().create();

    /**
     * 格式化Gson实例
     */
    public static final Gson GSON_PRETTY = GSON_BUILDER().setPrettyPrinting().create();


    /**
     * 默认 AppId
     */
    public static final String DEFAULT_APP_ID = "";

    /**
     * 功能特征类
     */
    public static class Features {

        private final boolean externalGateway;
        private final boolean batchOnlineTermsQryDisabled;
        private final boolean attrsQry;
        private final boolean avAttrsQry;
        private final boolean noQryLocationCmd;

        /**
         * 是否使用外部网关
         */
        public static final String FEATURE__EXTERNAL_GATEWAY = "externalGateway";

        /**
         * 是否禁用批量查询在线终端
         */
        public static final String FEATURE__BATCH_ONLINE_TERMS_QRY_DISABLED = "batchOnlineTermsQryDisabled";

        /**
         * 是否支持终端属性查询（8107）
         */
        public static final String FEATURE__ATTRS_QRY = "attrsQry";

        /**
         * 是否支持A/V属性查询（9003）
         */
        public static final String FEATURE__AV_ATTRS_QRY = "avAttrsQry";

        /**
         * 是否不支持查询定位指令
         */
        public static final String FEATURE__NO_QRY_LOCATE_CMD = "noQryLocateCmd";

        private final String[] features;

        /**
         * 构造函数
         * @param externalGateway 是否使用外部网关
         * @param batchOnlineTermsQryDisabled 是否禁用批量查询在线终端
         * @param attrsQry 是否支持终端属性查询（8107）
         * @param avAttrsQry 是否支持A/V属性查询（9003）
         * @param noQryLocationCmd 是否不支持查询定位指令
         * @param extraFeatures 额外功能
         */
        public Features(
                boolean externalGateway,
                boolean batchOnlineTermsQryDisabled,
                boolean attrsQry,
                boolean avAttrsQry,
                boolean noQryLocationCmd,
                String[] extraFeatures) {
            this.externalGateway = externalGateway;
            this.batchOnlineTermsQryDisabled = batchOnlineTermsQryDisabled;
            this.attrsQry = attrsQry;
            this.avAttrsQry = avAttrsQry;
            this.noQryLocationCmd = noQryLocationCmd;

            var list = new ArrayList<String>();
            if (externalGateway)
                list.add(FEATURE__EXTERNAL_GATEWAY);
            if (batchOnlineTermsQryDisabled)
                list.add(FEATURE__BATCH_ONLINE_TERMS_QRY_DISABLED);
            if (attrsQry)
                list.add(FEATURE__ATTRS_QRY);
            if (avAttrsQry)
                list.add(FEATURE__AV_ATTRS_QRY);
            if (noQryLocationCmd)
                list.add(FEATURE__NO_QRY_LOCATE_CMD);

            if (extraFeatures != null)
                for (String f : extraFeatures)
                    list.add(f);

            features = list.toArray(new String[0]);
        }

        /**
         * 是否使用外部网关
         * @return 是否使用外部网关
         */
        public boolean externalGateway() {
            return externalGateway;
        }

        /**
         * 是否禁用批量查询在线终端
         * @return 是否禁用批量查询在线终端
         */
        public boolean batchOnlineTermsQryDisabled() {
            return batchOnlineTermsQryDisabled;
        }

        /**
         * 是否支持终端属性查询（8107）
         * @return 是否支持终端属性查询（8107）
         */
        public boolean attrsQry() {
            return attrsQry;
        }

        /**
         * 是否支持A/V属性查询（9003）
         * @return 是否支持A/V属性查询（9003）
         */
        public boolean avAttrsQry() {
            return avAttrsQry;
        }

        /**
         * 是否不支持查询定位指令
         * @return 是否不支持查询定位指令
         */
        public boolean noQryLocationCmd() {
            return noQryLocationCmd;
        }

        /**
         * 获取特征名称列表
         * @return 特征名称列表
         */
        public String[] features() {
            String[] r = new String[features.length];
            System.arraycopy(features, 0, r, 0, features.length);
            return r;
        }
    }

    /**
     * 常见终端制造商ID
     */
    public static class WellKnownFactories {

        /**
         * 亿程
         */
        public static final String YI_CHENG = "70101";

        /**
         * 华宝
         */
        public static final String HUA_BAO = "70107";

        /**
         * 伊爱
         */
        public static final String YI_AI = "70108";

        /**
         * 联和安业
         */
        public static final String LIAN_HE_AN_YE = "70110";

        /**
         * 博实结
         */
        public static final String BO_SHI_JIE = "70111";

        /**
         * 赛格
         */
        public static final String SAI_GE = "70112";

        /**
         * 慧视通
         */
        public static final String HUI_SHI_TONG = "70113";

        /**
         * 雅迅
         */
        public static final String YA_XUN = "70118";

        /**
         * 有为
         */
        public static final String YOU_WEI = "70218";

        /**
         * 易流
         */
        public static final String YI_LIU = "70220";

        /**
         * 飞田
         */
        public static final String FEI_TIAN = "70304";

        /**
         * 首航
         */
        public static final String SHOU_HANG = "70465";

        /**
         * 锐明
         */
        public static final String RUI_MING = "70504";

        /**
         * 通立
         */
        public static final String TONG_LI = "72302";

        /**
         * 取厂商的短名称
         * @param factoryId 制造商ID
         * @return 短名称
         */
        public static String shortName(String factoryId) {
            if (factoryId == null)
                return null;

            return switch (factoryId) {
                case YI_CHENG -> "YiCheng";
                case HUA_BAO -> "HuaBao";
                case YI_AI -> "YiAi";
                case LIAN_HE_AN_YE -> "LianHeAY";
                case BO_SHI_JIE -> "BoShiJie";
                case SAI_GE -> "SiaGe";
                case HUI_SHI_TONG -> "HuiShiTong";
                case YA_XUN -> "YaXun";
                case YOU_WEI -> "YouWei";
                case YI_LIU -> "YiLiu";
                case FEI_TIAN -> "FeiTian";
                case SHOU_HANG -> "ShouHang";
                case RUI_MING -> "RuiMing";
                case TONG_LI -> "TongLi";
                default -> factoryId;
            };
        }
    }
}
