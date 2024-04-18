/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.almatt;

import com.lucendar.common.types.rest.Pagination;
import com.lucendar.common.utils.DateTimeUtils;
import info.gratour.common.error.ErrorWithCode;

import java.util.StringJoiner;

/**
 * ADAS 报警附件查询请求。分为按 id 查询和按时间段查询。
 * <ul>
 *     <li>按 id 查询时，只使用 `id`, `simNo` 两个参数，且两者均为必要参数</li>
 *     <li>按时间段查询时，使用 `simNo`, `startTime`, `endTime`, `__page`, `__limit` 参数，其中 `simNo`, `startTime`
 *     为必要参数，`endTime` 不指定时，表示报警时间到当前时间为止</li>
 * </ul>
 * 本类的字符串时间值采用北京时间，格式为：yyyy-MM-dd HH:mm:ss
 */
public class QryAdasAlmAttReq {
    private String id;
    private String simNo;
    private String startTime;
    private String endTime;
    private Integer __page;
    private Integer __limit;

    /**
     * 取平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     * @return 平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     */
    public String getId() {
        return id;
    }

    /**
     * 设置平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     * @param id 平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取报警时间范围的开始时间
     *
     * @return 报警时间范围的开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置报警时间范围的开始时间
     * @param startTime 报警时间范围的开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取报警时间范围的结束时间
     * @return 报警时间范围的结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置报警时间范围的结束时间
     * @param endTime 报警时间范围的结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取分页的页码，从1开始
     * @return 分页的页码
     */
    public Integer get__page() {
        return __page;
    }

    /**
     * 设置分页的页码，不设置时，默认为第1页
     * @param __page 分页的页码，从1开始
     */
    public void set__page(Integer __page) {
        this.__page = __page;
    }

    /**
     * 取分页每页记录数
     *
     * @return 分页每页记录数
     */
    public Integer get__limit() {
        return __limit;
    }

    /**
     * 设置分页每页记录数
     * @param __limit 分页每页记录数，不设置时，默认为 50 条
     */
    public void set__limit(Integer __limit) {
        this.__limit = __limit;
    }

    /**
     * 验证参数
     */
    public void validate() {
        if (id != null && !id.isEmpty()) {
            if (simNo == null || simNo.isEmpty())
                throw ErrorWithCode.invalidParam("simNo");
        } else {
            if (startTime == null || startTime.isEmpty())
                throw ErrorWithCode.invalidParam("startTime");
            else
                DateTimeUtils.BeijingConv.validateStr(startTime); // validate

            if (endTime != null && !endTime.isEmpty()) {
                DateTimeUtils.BeijingConv.validateStr(endTime); // validate
            }

            if (__page != null || __limit != null) {
                int p = __page != null ? __page : 1;
                int l = __limit != null ? __limit : 50;

                Pagination.check(p, l);
            }

        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryAdasAlmAttReq.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("simNo='" + simNo + "'")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("__page=" + __page)
                .add("__limit=" + __limit)
                .toString();
    }
}
