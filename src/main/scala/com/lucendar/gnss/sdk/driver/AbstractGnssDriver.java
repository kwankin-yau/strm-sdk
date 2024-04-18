/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.driver;

import info.gratour.common.error.ErrorWithCode;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * GNSS驱动基类
 */
public abstract class AbstractGnssDriver implements GnssDriver {

    /**
     * 初始传入的设置：是否校验CRC
     */
    protected final boolean initVerifyCrc;

    /**
     * 是否校验CRC
     */
    protected boolean verifyCrc;

    /**
     * 是否使用简化的解码器
     */
    protected final boolean simplifiedDecoder;

    /**
     * 初始传入的驱动配置属性
     */
    protected final Map<String, String> initConfig;

    /**
     * 驱动配置属性，初始时，等同于 `initConfig`
     */
    protected final Map<String, Object> config;

    /**
     * 驱动上下文
     */
    protected final GnssDriverContext ctx;

    /**
     * 构造函数
     *
     * @param config            驱动的初始化配置
     * @param verifyCrc         提示驱动是否验证报文中的CRC，对于无CRC协议的驱动，本参数无效。本参数只起提示作用，驱动实现不一定遵循
     * @param simplifiedDecoder 是否使用简化的解码器
     * @param ctx               驱动运行上下文
     */
    public AbstractGnssDriver(
            Map<String, String> config,
            boolean verifyCrc,
            boolean simplifiedDecoder,
            GnssDriverContext ctx) {
        this.initVerifyCrc = verifyCrc;
        this.verifyCrc = verifyCrc;

        this.simplifiedDecoder = simplifiedDecoder;

        this.initConfig = config;
        this.config = new HashMap<>();
        this.config.putAll(config);
        this.ctx = ctx;
    }

    /**
     * 查找配置属性，如果找不到，则返回 null
     *
     * @param attr 属性名
     * @return 属性值
     */
    @Nullable
    protected Object findAttr(String attr) {
        return config.get(attr);
    }

    /**
     * 取配置属性，如果找不到，则抛出异常
     *
     * @param attr 属性名
     * @return 属性值
     */
    protected Object getAttr(String attr) {
        Object r = findAttr(attr);
        if (r == null) {
            String err = String.format("Attribute `%s` is not found.", attr);
            throw ErrorWithCode.recordNotFound(err);
        }

        return r;
    }

    /**
     * 取配置属性，如果找不到，则返回给定的默认值( defaultValue )
     *
     * @param attr         属性名
     * @param defaultValue 如果找不到时使用的默认值
     * @return 属性值
     */
    protected Object getAttrDefault(String attr, Object defaultValue) {
        Object r = findAttr(attr);
        if (r == null)
            return defaultValue;
        else
            return r;
    }

    /**
     * 查找字符串类型的配置属性，如果找不到，则返回 null
     *
     * @param attr 属性名
     * @return 属性值
     */
    protected String findStringAttr(String attr) {
        Object r = findAttr(attr);
        if (r != null)
            return r.toString();
        else
            return null;
    }

    /**
     * 取字符串类型的配置属性，如果找不到，则抛出异常
     *
     * @param attr 属性名
     * @return 属性值
     */
    protected String getStringAttr(String attr) {
        return getAttr(attr).toString();
    }

    /**
     * 查找字符串类型的配置属性，如果找不到，则返回给定的默认值( defaultValue )
     *
     * @param attr         属性名
     * @param defaultValue 默认值
     * @return 属性值
     */
    protected String getStringAttrDefault(String attr, String defaultValue) {
        return getAttrDefault(attr, defaultValue).toString();
    }

    /**
     * 取布尔类型的配置属性，如果找不到，则抛出异常
     *
     * @param attr 属性名
     * @return 属性值
     */
    protected boolean getBooleanAttr(String attr) {
        Object value = getAttr(attr);
        if (value instanceof Boolean)
            return (Boolean) value;
        else
            return Boolean.parseBoolean(value.toString());
    }

    /**
     * 查找布尔类型的配置属性，如果找不到，则返回给定的默认值( defaultValue )
     *
     * @param attr         属性名
     * @param defaultValue 默认值
     * @return 属性值
     */
    protected boolean getBooleanAttrDefault(String attr, boolean defaultValue) {
        Object value = findAttr(attr);
        if (value == null)
            return defaultValue;
        else if (value instanceof Boolean)
            return (Boolean) value;
        else
            return Boolean.parseBoolean(value.toString());
    }

    /**
     * 设置配置属性
     *
     * @param attr  属性名
     * @param value 属性值
     */
    protected void setAttr(String attr, Object value) {
        config.put(attr, value);
    }

    /**
     * 取驱动上下文
     *
     * @return 驱动上下文
     */
    public GnssDriverContext getCtx() {
        return ctx;
    }

    @Override
    public void reset() {
        verifyCrc = initVerifyCrc;
        config.clear();
        if (initConfig != null)
            config.putAll(initConfig);
    }
}
