package com.lucendar.strm.common.strm.stat;

import java.lang.management.MemoryUsage;
import java.util.StringJoiner;

/**
 * 内存使用情况
 */
public class MemUsage {

    private long init;
    private long used;
    private long committed;
    private long max;

    /**
     * 构造函数
     */
    public MemUsage() {
    }

    /**
     * 构造函数
     * @param init 初始内存
     * @param used 已使用内存
     * @param committed 提交的内存
     * @param max 最大内存
     */
    public MemUsage(long init, long used, long committed, long max) {
        this.init = init;
        this.used = used;
        this.committed = committed;
        this.max = max;
    }

    /**
     * 构造函数
     * @param usage 内存使用情况
     */
    public MemUsage(MemoryUsage usage) {
        this.init = usage.getInit();
        this.used = usage.getUsed();
        this.committed = usage.getCommitted();
        this.max = usage.getMax();
    }

    /**
     * 获取初始内存
     * @return 初始内存
     */
    public long getInit() {
        return init;
    }

    /**
     * 获取已使用内存
     * @return 已使用内存
     */
    public long getUsed() {
        return used;
    }

    /**
     * 获取提交的内存
     * @return 提交的内存
     */
    public long getCommitted() {
        return committed;
    }

    /**
     * 获取最大内存
     * @return 最大内存
     */
    public long getMax() {
        return max;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MemUsage.class.getSimpleName() + "[", "]")
                .add("init=" + init)
                .add("used=" + used)
                .add("committed=" + committed)
                .add("max=" + max)
                .toString();
    }
}
