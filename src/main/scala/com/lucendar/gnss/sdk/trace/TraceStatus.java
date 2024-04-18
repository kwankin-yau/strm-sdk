/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.trace;

/**
 * 终端调试跟踪状态
 */
public interface TraceStatus {

    String appId();
    String simNo();

    /**
     * 是否跟踪此终端
     *
     * @return 是否跟踪此终端
     */
    boolean isActive();

    class InactiveTraceStatus implements TraceStatus {
        private final String appId;
        private final String simNo;

        public InactiveTraceStatus(String appId, String simNo) {
            this.appId = appId;
            this.simNo = simNo;
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
        public boolean isActive() {
            return false;
        }
    }
}
