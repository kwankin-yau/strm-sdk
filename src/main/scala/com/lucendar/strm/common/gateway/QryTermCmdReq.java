package com.lucendar.strm.common.gateway;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.StringJoiner;

/**
 * 查询终端指令记录请求
 */
public class QryTermCmdReq {

    private String startTime;
    private String endTime;
    private String appId;
    private String simNo;
    private String reqId;
    private int __limit;
    private int __page;

    /**
     * 取查询条件：指令的请求时间范围的开始时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 查询条件：指令的请求时间范围的开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置查询条件：指令的请求时间范围的开始时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @param startTime 查询条件：指令的请求时间范围的开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTime(@NonNull String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取查询条件：指令的请求时间范围的结果时间，格式：yyyy-MM-dd HH:mm:ss。不指定时，为 `startTime` 后加 24 小时。指令的请求时间范
     * 围的跨度不能大于31天。
     *
     * @return 查询条件：指令的请求时间范围的结果时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置查询条件：指令的请求时间范围的结果时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @param endTime 查询条件：指令的请求时间范围的结果时间，格式：yyyy-MM-dd HH:mm:ss。不指定时，为 `startTime` 后加 24 小时。指令的
     *                请求时间范围的跨度不能大于31天。
     */
    public void setEndTime(@Nullable String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取查询条件：AppId
     *
     * @return 查询条件：AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置查询条件：AppId
     *
     * @param appId 查询条件：AppId
     */
    public void setAppId(@Nullable String appId) {
        this.appId = appId;
    }

    /**
     * 取查询条件：终端识别号
     *
     * @return 查询条件：终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置查询条件：终端识别号
     *
     * @param simNo 查询条件：终端识别号
     */
    public void setSimNo(@Nullable String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取查询条件：关联的流媒体请求ID
     *
     * @return 查询条件：关联的流媒体请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置查询条件：关联的流媒体请求ID
     *
     * @param reqId 查询条件：关联的流媒体请求ID
     */
    public void setReqId(@Nullable String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取查询结果分页的每页记录数
     *
     * @return 查询结果分页的每页记录数
     */
    public int get__limit() {
        return __limit;
    }

    /**
     * 设置查询结果分页的每页记录数
     *
     * @param __limit 查询结果分页的每页记录数
     */
    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    /**
     * 取查询结果的分页页号，从1开始
     *
     * @return 查询结果的分页页号，从1开始
     */
    public int get__page() {
        return __page;
    }

    /**
     * 设置查询结果的分页页号，从1开始
     *
     * @param __page 查询结果的分页页号，从1开始
     */
    public void set__page(int __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryTermCmdReq.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("reqId='" + reqId + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
