/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.config;

import java.util.StringJoiner;

import com.lucendar.strm.common.info.QryInfoResult;

/**
 * 流媒体服务器信息(v2)
 */
public class StrmServerInfo2 {

    /**
     * 流媒体实例ID
     */
    private String instId;
    private QryInfoResult info;

    /**
     * 获取流媒体实例ID
     * @return 流媒体实例ID
     */
    public String getInstId() {
        return instId;
    }

    /**
     * 设置流媒体实例ID
     * @param instId 流媒体实例ID
     */
    public void setInstId(String instId) {
        this.instId = instId;
    }

    /**
     * 获取流媒体信息
     * @return 流媒体信息
     */
    public QryInfoResult getInfo() {
        return info;
    }

    /**
     * 设置流媒体信息
     * @param info 流媒体信息
     */
    public void setInfo(QryInfoResult info) {
        this.info = info;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(StrmServerInfo source) {
        this.instId = source.getConfig().getInstanceId();

        QryInfoResult info = source.getInfo();
        if (info != null)
            this.info = info.clone();
        else
            this.info = null;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(StrmServerInfo2 source) {
        this.instId = source.getInstId();

        QryInfoResult info = source.getInfo();
        if (info != null)
            this.info = info.clone();
        else
            this.info = null;
    }

    @Override
    public StrmServerInfo2 clone() {
        StrmServerInfo2 r = new StrmServerInfo2();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmServerInfo2.class.getSimpleName() + "[", "]")
                .add("instId='" + instId + "'")
                .add("info=" + info)
                .toString();
    }
}
