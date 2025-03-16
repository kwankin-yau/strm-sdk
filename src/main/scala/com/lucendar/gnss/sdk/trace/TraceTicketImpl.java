/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.trace;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 跟踪凭据实现
 */
public class TraceTicketImpl implements TraceTicket, TraceStatus {

    private final String appId;
    private final String simNo;
    private final AtomicInteger traceCount = new AtomicInteger();

    /**
     * 构造函数
     * @param appId appId
     * @param simNo 终端识别号
     */
    public TraceTicketImpl(String appId, String simNo) {
        this.appId = appId;
        this.simNo = simNo;
    }

    @Override
    public boolean isActive() {
        return traceCount.get() > 0;
    }

    @Override
    public String appId() {
        return appId;
    }

    @Override
    public String simNo() {
        return simNo;
    }

    @Override
    public void untrace() {
        traceCount.decrementAndGet();
    }

    /**
     * 跟踪
     */
    public void trace() {
        traceCount.incrementAndGet();
    }
}
