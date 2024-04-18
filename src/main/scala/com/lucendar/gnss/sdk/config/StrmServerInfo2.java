/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.config;

import com.lucendar.strm.common.info.QryInfoResult;

import java.util.StringJoiner;

public class StrmServerInfo2 {

    private String instId;
    private QryInfoResult info;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public QryInfoResult getInfo() {
        return info;
    }

    public void setInfo(QryInfoResult info) {
        this.info = info;
    }

    public void assignFrom(StrmServerInfo source) {
        this.instId = source.getConfig().getInstanceId();

        QryInfoResult info = source.getInfo();
        if (info != null)
            this.info = info.clone();
        else
            this.info = null;
    }

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
