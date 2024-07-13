package com.lucendar.gnss.sdk.types;

import java.util.StringJoiner;

public class PagedQuery {
    private Integer __page;
    private Integer __limit;

    public Integer get__page() {
        return __page;
    }

    public void set__page(Integer __page) {
        this.__page = __page;
    }

    public Integer get__limit() {
        return __limit;
    }

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
