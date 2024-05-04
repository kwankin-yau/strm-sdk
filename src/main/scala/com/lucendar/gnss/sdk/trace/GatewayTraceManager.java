/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */

package com.lucendar.gnss.sdk.trace;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 终端跟踪管理器
 */
public interface GatewayTraceManager {

    /**
     * 取跟踪状态。如果之前没有设置，则新建一个 active 为 false 的 TraceStatus.
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return 终端跟踪状态
     */
    @NonNull
    TraceStatus getTraceStatus(@NonNull String appId, @NonNull String simNo);

    /**
     * 跟踪终端
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return 终端跟踪
     */
    @NonNull
    TraceTicket trace(@NonNull String appId, @NonNull String simNo);

    /**
     * 取消跟踪
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     */
    void untrace(@NonNull String appId, @NonNull String simNo);
}
