package com.lucendar.gnss.sdk.db;

/**
 * 记录ID提供者
 */
public interface RecIdProvider {

    /**
     * 取新的记录ID
     *
     * @return 新的记录ID
     */
    String nextId();
}
