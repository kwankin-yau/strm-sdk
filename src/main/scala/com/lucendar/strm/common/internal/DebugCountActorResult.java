package com.lucendar.strm.common.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class DebugCountActorResult {
    private String requestId;
    private long count;
    private List<String> names;

    public DebugCountActorResult() {
    }

    public DebugCountActorResult(String requestId, long count) {
        this.requestId = requestId;
        this.count = count;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void inc() {
        count += 1;
    }

    public void addName(String name) {
        if (names == null) {
            names = new ArrayList<>();
        }

        names.add(name);
        inc();
    }

    public void sortNames() {
        if (names != null)
            names.sort(String::compareTo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DebugCountActorResult.class.getSimpleName() + "[", "]")
                .add("requestId='" + requestId + "'")
                .add("count=" + count)
                .add("names=" + names)
                .toString();
    }
}
