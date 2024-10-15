package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

/**
 * 查询消息队列消息转换日志记录请求
 * <p>
 * 必要参数：
 * <ul>
 *     <li>tmStart</li>
 *     <li>tmEnd</li>
 *     <li>__limit</li>
 *     <li>__page</li>
 * </ul>
 */
public class QryStrmMqAdaptorLogEntryReq {
    private String tmStart;
    private String tmEnd;
    private String appId;
    private String simNo;
    private String method;
    private int __limit;
    private int __page;

    /**
     * 取事件时间范围的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 事件时间范围的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getTmStart() {
        return tmStart;
    }

    /**
     * 设置事件时间范围的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @param tmStart 事件时间范围的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setTmStart(String tmStart) {
        this.tmStart = tmStart;
    }

    /**
     * 取事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getTmEnd() {
        return tmEnd;
    }

    /**
     * 设置事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     *
     * @param tmEnd 事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setTmEnd(String tmEnd) {
        this.tmEnd = tmEnd;
    }

    /**
     * 取 AppID
     *
     * @return AppID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppID
     *
     * @param appId AppID
     */
    public void setAppId(String appId) {
        this.appId = appId;
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
     * 取消息转换调用的函数
     *
     * @return 消息转换调用的函数
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置消息转换调用的函数
     *
     * @param method 消息转换调用的函数
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 取分页每页记录数
     *
     * @return 分页每页记录数
     */
    public int get__limit() {
        return __limit;
    }

    /**
     * 设置分页每页记录数
     * @param __limit 分页每页记录数，不设置时，默认为 50 条
     */
    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    /**
     * 取分页的页码，从1开始
     * @return 分页的页码
     */
    public int get__page() {
        return __page;
    }

    /**
     * 设置分页的页码，不设置时，默认为第1页
     * @param __page 分页的页码，从1开始
     */
    public void set__page(int __page) {
        this.__page = __page;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmMqAdaptorLogEntryReq.class.getSimpleName() + "[", "]")
                .add("tmStart='" + tmStart + "'")
                .add("tmEnd='" + tmEnd + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("method='" + method + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
