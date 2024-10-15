package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

/**
 * 查询消息队列日志记录请求。
 * <p>
 * 必要参数：
 * <ul>
 *     <li>tmStart</li>
 *     <li>tmEnd</li>
 *     <li>__limit</li>
 *     <li>__page</li>
 * </ul>
 */
public class QryStrmMqLogEntryReq {

    private String tmStart;
    private String tmEnd;
    private String appId;
    private String channel;
    private String destination;
    private String kind;
    private Integer typ;
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
     * @param tmStart 事件时间范围的开始时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setTmStart(String tmStart) {
        this.tmStart = tmStart;
    }

    /**
     * 取事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     * @return 事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getTmEnd() {
        return tmEnd;
    }

    /**
     * 设置事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     * @param tmEnd 事件时间范围的结束时间，北京时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setTmEnd(String tmEnd) {
        this.tmEnd = tmEnd;
    }

    /**
     * 取 AppID
     * @return AppID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 AppID
     * @param appId AppID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取消息队列类型。为 StrmMqLogEntry.CHANNEL__xxx 常量之一
     *
     * @return 消息队列类型。为 StrmMqLogEntry.CHANNEL__xxx 常量之一
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置消息队列类型。为 StrmMqLogEntry.CHANNEL__xxx 常量之一
     * @param channel 消息队列类型。为 StrmMqLogEntry.CHANNEL__xxx 常量之一
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 取消息队列的主题
     *
     * @return 消息队列的主题
     */
    public String getDestination() {
        return destination;
    }

    /**
     * 设置消息队列的主题
     * @param destination 消息队列的主题
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * 取消息类型，如 `termCmd`
     * @return 消息类型
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置消息类型
     * @param kind 消息类型
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 取事件类型，为 StrmMqLogEntry.TYP__xxx 常量之一
     * @return 事件类型，为 StrmMqLogEntry.TYP__xxx 常量之一
     */
    public Integer getTyp() {
        return typ;
    }

    /**
     * 设置事件类型，为 StrmMqLogEntry.TYP__xxx 常量之一
     * @param typ 事件类型，为 StrmMqLogEntry.TYP__xxx 常量之一
     */
    public void setTyp(Integer typ) {
        this.typ = typ;
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
        return new StringJoiner(", ", QryStrmMqLogEntryReq.class.getSimpleName() + "[", "]")
                .add("tmStart='" + tmStart + "'")
                .add("tmEnd='" + tmEnd + "'")
                .add("appId='" + appId + "'")
                .add("channel='" + channel + "'")
                .add("destination='" + destination + "'")
                .add("kind='" + kind + "'")
                .add("typ=" + typ)
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
