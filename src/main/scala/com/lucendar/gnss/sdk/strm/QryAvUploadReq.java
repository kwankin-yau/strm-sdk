/*
 * Copyright (c) 2023 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.strm;

import com.lucendar.common.utils.DateTimeUtils;
import info.gratour.common.error.ErrorWithCode;

import java.time.format.DateTimeParseException;
import java.util.StringJoiner;

/**
 * 查询录像上传状态请求。查询录像上传请求的完成状态有两种查询模式：
 * <ul>
 *     <li>按上传请求ID查询，此时只需要提供reqId参数</li>
 *     <li>按开始时间的范围查询（即查询`startTimeStart` &lt;= startTime &lt; `startTimeEnd`的记录），
 *     此时需要提供`startTimeStart`, `startTimeEnd`两个参数，同时要指定`__page`，`__limit`两个分页参数，可选提供`appId`, `simNo`参数。
 *     </li>
 * </ul>
 */
public class QryAvUploadReq {
    private String reqId;
    private long startTimeStart;
    private long startTimeEnd;
    private String simNo;
    private int __limit;
    private int __page;

    /**
     * 取上传请求ID。由上传远程录像接口 `POST /strm/stored/upload` 接口返回的请求ID
     *
     * @return 上传请求ID。
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置上传请求ID。
     * @param reqId 上传请求ID。
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取录像的开始时间的范围起始时间
     *
     * @return 录像的开始时间的范围起始时间，epoch millis-seconds。
     */
    public long getStartTimeStart() {
        return startTimeStart;
    }

    /**
     * 设置录像的开始时间的范围起始时间
     * @param startTimeStart 录像的开始时间的范围起始时间，epoch millis-seconds。
     */
    public void setStartTimeStart(long startTimeStart) {
        this.startTimeStart = startTimeStart;
    }

    /**
     * 设置录像的开始时间的范围起始时间
     * @param startTimeStart 录像的开始时间的范围起始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTimeStart(String startTimeStart) {
        if (startTimeStart.isEmpty())
            throw ErrorWithCode.invalidParam("startTmStart");

        try {
            this.startTimeStart = DateTimeUtils.BeijingConv.stringToMillis(startTimeStart);
        } catch (DateTimeParseException e) {
            throw ErrorWithCode.invalidParam("startTmStart");
        }
    }

    /**
     * 取录像的开始时间的范围结束时间
     * @return 录像的开始时间的范围结束时间，epoch millis-seconds。
     */
    public long getStartTimeEnd() {
        return startTimeEnd;
    }

    /**
     * 设置录像的开始时间的范围结束时间
     * @param startTimeEnd 录像的开始时间的范围结束时间，epoch millis-seconds。
     */
    public void setStartTimeEnd(long startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }

    /**
     * 设置录像的开始时间的范围结束时间
     * @param startTimeEnd 录像的开始时间的范围结束时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTimeEnd(String startTimeEnd) {
        if (startTimeEnd.isEmpty())
            throw ErrorWithCode.invalidParam("startTmEnd");

        try {
            this.startTimeEnd = DateTimeUtils.BeijingConv.stringToMillis(startTimeEnd);
        } catch (DateTimeParseException e) {
            throw ErrorWithCode.invalidParam("startTmEnd");
        }
    }

    /**
     * 取终端识别号
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
     * 取分页每页记录数
     * @return 分页每页记录数
     */
    public int get__limit() {
        return __limit;
    }

    /**
     * 设置分页每页记录数
     * @param __limit 分页每页记录数，必须大于等于`1`，小于等于`2000`。
     */
    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    /**
     * 取分页的第几页，从`1`开始。
     * @return 分页的第几页，从`1`开始。
     */
    public int get__page() {
        return __page;
    }

    /**
     * 设置分页的第几页，从`1`开始。
     * @param __page 分页的第几页，从`1`开始。
     */
    public void set__page(int __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryAvUploadReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("startTimeStart=" + startTimeStart)
                .add("startTimeEnd=" + startTimeEnd)
                .add("simNo='" + simNo + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
