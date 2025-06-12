/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.config;

import java.util.StringJoiner;

import com.lucendar.strm.common.info.QryInfoResult;

/**
 * 流媒体服务器信息
 */
public class StrmServerInfo implements Cloneable {

    private StrmMediaConfig config;
    private volatile QryInfoResult info;

    /**
     * 获取流媒体配置
     * @return 流媒体配置
     */
    public StrmMediaConfig getConfig() {
        return config;
    }

    /**
     * 设置流媒体配置
     * @param config 流媒体配置
     */
    public void setConfig(StrmMediaConfig config) {
        this.config = config;
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
        if (source.config != null)
            this.config = source.config.clone();
        else
            this.config = null;

        if (source.info != null)
            this.info = source.info.clone();
        else
            this.info = null;
    }

    @Override
    public StrmServerInfo clone() {
        StrmServerInfo r = new StrmServerInfo();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmServerInfo.class.getSimpleName() + "[", "]")
                .add("config=" + config)
                .add("info=" + info)
                .toString();
    }
}
