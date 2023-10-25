package com.lucendar.strm.common.strm.stat;

import java.lang.management.MemoryUsage;
import java.util.StringJoiner;

public class MemUsage {

    private long init;
    private long used;
    private long committed;
    private long max;

    public MemUsage() {
    }

    public MemUsage(long init, long used, long committed, long max) {
        this.init = init;
        this.used = used;
        this.committed = committed;
        this.max = max;
    }

    public MemUsage(MemoryUsage usage) {
        this.init = usage.getInit();
        this.used = usage.getUsed();
        this.committed = usage.getCommitted();
        this.max = usage.getMax();
    }

    public long getInit() {
        return init;
    }

    public long getUsed() {
        return used;
    }

    public long getCommitted() {
        return committed;
    }

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
