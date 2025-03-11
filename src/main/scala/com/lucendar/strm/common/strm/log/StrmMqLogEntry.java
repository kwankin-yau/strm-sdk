package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

/**
 * 消息队列日志项
 */
public class StrmMqLogEntry {

    /**
     * 消息队列类型：RabbitMQ
     */
    public static final String CHANNEL__RABBIT = "rabbit";

    /**
     * 消息队列类型：Apache MQ
     */
    public static final String CHANNEL__APACHE_MQ = "apacheMq";

    /**
     * 消息队列类型：Artemis
     */
    public static final String CHANNEL__ARTEMIS = "artemis";

    /**
     * 消息队列类型：Kafka
     */
    public static final String CHANNEL__KAFKA = "kafka";

    /**
     * 消息队列类型：MQTT
     */
    public static final String CHANNEL__MQTT = "mqtt";

    /**
     * 消息队列类型：Redis
     */
    public static final String CHANNEL__REDIS = "redis";

    /**
     * 事件类型：发送
     */
    public static final int TYP__SEND = 1;

    /**
     * 事件类型：接收
     */
    public static final int TYP__RECV = 2;

    /**
     * 消息类型：指令下发
     * 发送者：媒体服务
     */
    public static final String KIND__termCmd = "termCmd";

    /**
     * 消息类型：指令状态变更通知
     * 发送者：集成系统
     */
    public static final String KIND__cmdStateChanged = "cmdStateChanged";

    /**
     * 消息类型：远程录像上传通知
     * 发送者：媒体服务
     */
    public static final String KIND__avUploadNotif = "avUploadNotif";

    /**
     * 消息类型：提取ADAS报警附件请求消息
     * 发送者：集成系统
     */
    public static final String KIND__fetchAlmAtt = "fetchAlmAtt";

    /**
     * 消息类型：提取ADAS报警附件任务结束通知
     * 发送者：媒体服务
     */
    public static final String KIND__fetchAlmAttCompleted = "fetchAlmAttCompleted";

    private String id;
    private long tm;
    private String appId;
    private String channel;
    private String destination;
    private int typ;
    private String kind;
    private String msg;

    /**
     * 取日志记录ID
     *
     * @return 日志记录ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置日志记录ID
     * @param id 日志记录ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取事件时间, epoch millis
     * @return 事件时间, epoch millis
     */
    public long getTm() {
        return tm;
    }

    /**
     * 设置事件时间, epoch millis
     * @param tm 事件时间, epoch millis
     */
    public void setTm(long tm) {
        this.tm = tm;
    }

    /**
     * 取 AppID
     * @return AppID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置AppID
     * @param appId AppID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取消息队列类型。为 CHANNEL__xxx 系列常量之一
     *
     * @return 消息队列类型
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置消息队列类型。为 CHANNEL__xxx 系列常量之一
     * @param channel 消息队列类型。为 CHANNEL__xxx 系列常量之一
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 取主题名称
     *
     * @return 主题名称
     */
    public String getDestination() {
        return destination;
    }

    /**
     * 设置主题名称
     * @param destination 主题名称
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * 取消息类型，为 KIND__xxx 常量之一。应用应跳过识别不了消息类型的消息
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
     * 取事件类型，为 TYP__xxx 系列常量之一
     *
     * @return 事件类型，为 TYP__xxx 系列常量之一
     */
    public int getTyp() {
        return typ;
    }

    /**
     * 设置事件类型，为 TYP__xxx 系列常量之一
     * @param typ 事件类型，为 TYP__xxx 系列常量之一
     */
    public void setTyp(int typ) {
        this.typ = typ;
    }

    /**
     * 取发送或接收的消息
     *
     * @return 发送或接收的消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置发送或接收的消息
     * @param msg 发送或接收的消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmMqLogEntry.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("tm=" + tm)
                .add("appId='" + appId + "'")
                .add("channel='" + channel + "'")
                .add("destination='" + destination + "'")
                .add("typ=" + typ)
                .add("kind='" + kind + "'")
                .add("msg='" + msg + "'")
                .toString();
    }
}
