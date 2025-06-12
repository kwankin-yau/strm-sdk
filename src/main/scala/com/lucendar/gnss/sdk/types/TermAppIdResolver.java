/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.types;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 终端所属AppID解析器
 */
public interface TermAppIdResolver {

    /**
     * 取终端所属的AppID。
     * <p>
     * 由于 终端识别号 和 AppID 的对应关系是固定的，且本方法调用极其频繁，所以，实现类应该对此关联关系使用本地缓存，或多级缓存。
     *
     * @param simNo 终端识别号
     * @return 终端所属的AppID。如果应用不考虑 AppID ， 或无法确定 AppID ，则应返回 GnssConsts.DEFAULT_APP_ID 。不能返回 null 。
     */
    @NonNull
    String appIdOfSimNo(@NonNull String simNo);

}
