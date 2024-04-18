/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.driver;

import io.netty.buffer.ByteBuf;

import java.util.Map;

/**
 * 终端驱动
 */
public interface GnssDriverFactory {

    String DRIVER_ID__JT808 = "jt808";

    /**
     * ADAS方言，参见：info.gratour.jt808common.AdasDialect
     */
    String CONFIG__ADAS_DIALECT = "adasDialect";

    /**
     * 取驱动的ID，不同的驱动，其ID必须不一。
     *
     * @return 驱动的ID
     */
    String id();

    /**
     * 检查一个报文是否可由本驱动处理。
     *
     * @param buf 报文
     * @return 是否可由本驱动处理。
     */
    boolean probe(ByteBuf buf);

    /**
     * 创建驱动处理上下文
     *
     * @param config            驱动的初始配置
     * @param verifyCrc         是否校验报文的校验码
     * @param simplifiedDecoder 是否使用简化的解码器
     * @param ctx               驱动上下文
     * @return 驱动实例对象
     */
    GnssDriver createDriver(
            Map<String, String> config,
            boolean verifyCrc,
            boolean simplifiedDecoder,
            GnssDriverContext ctx);

    default GnssDriver createDriver(
            Map<String, String> config,
            GnssDriverContext ctx) {
        return createDriver(config, true, false, ctx);
    }
}
