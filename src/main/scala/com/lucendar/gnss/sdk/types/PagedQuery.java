package com.lucendar.gnss.sdk.types;

import java.util.StringJoiner;

/**
 * 分页查询
 */
public class PagedQuery {
    private Integer __page;
    private Integer __limit;

    /**
     * 获取页码
     * @return 页码, 从1开始
     */
    public Integer get__page() {
        return __page;
    }

    /**
     * 设置页码
     * @param __page 页码, 从1开始
     */
    public void set__page(Integer __page) {
        this.__page = __page;
    }

    /**
     * 获取每页记录数
     * @return 每页记录数
     */
    public Integer get__limit() {
        return __limit;
    }

    /**
     * 设置每页记录数
     * @param __limit 每页记录数
     */
    public void set__limit(Integer __limit) {
        this.__limit = __limit;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PagedQuery.class.getSimpleName() + "[", "]")
                .add("__page=" + __page)
                .add("__limit=" + __limit)
                .toString();
    }
}
