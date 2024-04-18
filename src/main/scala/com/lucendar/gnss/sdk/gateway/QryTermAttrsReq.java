/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.gateway;

import java.util.StringJoiner;

/**
 * 查询终端属性（参见：JT/T 808的 0x8107 消息）请求
 */
public class QryTermAttrsReq {
    private String simNos;

    public String getSimNos() {
        return simNos;
    }

    public void setSimNos(String simNos) {
        this.simNos = simNos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryTermAttrsReq.class.getSimpleName() + "[", "]")
                .add("simNos='" + simNos + "'")
                .toString();
    }
}
