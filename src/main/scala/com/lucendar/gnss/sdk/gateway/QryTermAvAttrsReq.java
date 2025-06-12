/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.gateway;

import java.util.StringJoiner;

/**
 * 查询终端属性（参见：JT/T 1078 的 0x9003 消息）请求
 */
public class QryTermAvAttrsReq {
    private String simNos;

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNos() {
        return simNos;
    }

    /**
     * 设置终端识别号
     * @param simNos 终端识别号
     */
    public void setSimNos(String simNos) {
        this.simNos = simNos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryTermAvAttrsReq.class.getSimpleName() + "[", "]")
                .add("simNos='" + simNos + "'")
                .toString();
    }
}
