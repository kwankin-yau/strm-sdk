/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.trace;

/**
 * 终端调试跟踪状态
 */
public interface TraceStatus {

    /**
     * 所属 appId
     * @return appId
     */
    String appId();

    /**
     * 终端识别号
     * @return 终端识别号
     */
    String simNo();

    /**
     * 是否跟踪此终端
     *
     * @return 是否跟踪此终端
     */
    boolean isActive();

    /**
     * 不跟踪的（未启用的）TraceStatus 实现
     */
    class InactiveTraceStatus implements TraceStatus {
        private final String appId;
        private final String simNo;

        /**
         * 构造函数
         * @param appId appId
         * @param simNo 终端识别号
         */
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
