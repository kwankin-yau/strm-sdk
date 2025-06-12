/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.types;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.StringJoiner;

/**
 * App信息接口。实现类为业务系统的App信息对象。此处定义为接口的目的是屏蔽App信息的细节，披露网关应用所需要的AppId。
 */
public interface AppInfo {

    /**
     * 获取AppId
     * @return AppId
     */
    String getAppId();

    /**
     * 简单App信息对象。主要用于独立运行的网关应用。
     */
    class SimpleAppInfo implements AppInfo {
        private final String appId;

        /**
         * 构造函数
         * @param appId AppId
         */
        public SimpleAppInfo(@NonNull String appId) {
            this.appId = appId;
        }

        @Override
        public String getAppId() {
            return appId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SimpleAppInfo that = (SimpleAppInfo) o;

            return appId.equals(that.appId);
        }

        @Override
        public int hashCode() {
            return appId.hashCode();
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", SimpleAppInfo.class.getSimpleName() + "[", "]")
                    .add("appId='" + appId + "'")
                    .toString();
        }
    }
}
