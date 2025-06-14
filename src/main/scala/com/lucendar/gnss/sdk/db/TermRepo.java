/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.db;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.lucendar.gnss.sdk.types.TermAppIdResolver;

import info.gratour.jt808common.spi.model.TermBrief;

/**
 * 终端 Repo
 */
public interface TermRepo extends TermAppIdResolver {

    /**
     * 终端注册结果
     */
    enum TermRegResult {
        /**
         * 成功
         */
        OK,

        /**
         * 车辆记录未找到
         */
        VEH_NOT_FOUND,

        /**
         * 终端记录未找到
         */
        TERM_NOT_FOUND,

        /**
         * 车辆已注册
         */
        VEH_REGISTERED,

        /**
         * 终端已注册
         */
        TERM_REGISTERED;

        /**
         * 是否成功
         * @return 是否成功
         */
        public boolean isOk() {
            return this == OK;
        }
    }

    /**
     * 注册终端。终端上报`终端注册 (0x0100)`消息，作数据库方面的处理
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @param plateNo 车牌号
     * @param plateColor 车牌颜色代码
     * @param authCode 鉴权码
     * @return 注册结果
     */
    TermRegResult termRegister(
            @NonNull String appId,
            @NonNull String simNo,
            @NonNull String plateNo,
            int plateColor,
            @NonNull String authCode);

    /**
     * 终端注销返回结果
     */
    enum TermUnRegResult {
        /**
         * 成功
         */
        OK,

        /**
         * 终端未找到
         */
        TERM_NOT_FOUND;

        /**
         * 是否成功
         * @return 是否成功
         */
        public boolean isOk() {
            return this == OK;
        }
    }

    /**
     * 注销终端。终端上报`终端注销 (0x0003)`消息，作数据库方面的处理
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return 注销结果
     */
    TermUnRegResult termUnregister(@NonNull String appId, @NonNull String simNo);

    /**
     * 查询终端鉴权权
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return 终端鉴权权，如果未找到，则返回 null
     */
    @Nullable
    String qryTermAuthCode(@NonNull String appId, @NonNull String simNo);


    /**
     * 查询终端简明信息
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     *
     * @return 终端简明信息。如果未找到，则返回 null
     */
    @Nullable
    TermBrief qryTermBrief(@NonNull String appId, @NonNull String simNo);
}
