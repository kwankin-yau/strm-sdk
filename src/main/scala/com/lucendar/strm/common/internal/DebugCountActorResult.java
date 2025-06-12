package com.lucendar.strm.common.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 调试Actor计数结果
 */
public class DebugCountActorResult {
    /**
     * 请求ID
     */
    private String requestId;
    private long count;
    private List<String> names;

    /**
     * 构造函数
     */
    public DebugCountActorResult() {
    }

    /**
     * 构造函数
     * @param requestId 请求ID
     * @param count 计数
     */
    public DebugCountActorResult(String requestId, long count) {
        this.requestId = requestId;
        this.count = count;
    }

    /**
     * 取请求ID
     * @return 请求ID
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 设置请求ID
     * @param requestId 请求ID
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * 取计数
     * @return 计数
     */
    public long getCount() {
        return count;
    }

    /**
     * 设置计数
     * @param count 计数
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * 取名称列表
     * @return 名称列表
     */
    public List<String> getNames() {
        return names;
    }

    /**
     * 设置名称列表
     * @param names 名称列表
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * 增加计数
     */
    public void inc() {
        count += 1;
    }

    /**
     * 增加名称
     * @param name 名称
     */
    public void addName(String name) {
        if (names == null) {
            names = new ArrayList<>();
        }

        names.add(name);
        inc();
    }

    /**
     * 名称排序
     */
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
