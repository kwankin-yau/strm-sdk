package com.lucendar.gnss.sdk.evtsrc;

import java.util.StringJoiner;

/**
 * 第二版 WebSocket API 的事件
 */
public class Ws2Event {

    /**
     * 事件类型, 取值为 GnssEventType.name()
     */
    private String typ;

    /**
     * 消息体 JSON
     */
    private String json;

    /**
     * 获取事件类型
     * @return 事件类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置事件类型
     * @param typ 事件类型
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 获取消息体 JSON
     * @return 消息体 JSON
     */
    public String getJson() {
        return json;
    }

    /**
     * 设置消息体 JSON
     * @param json 消息体 JSON
     */
    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ws2Event.class.getSimpleName() + "[", "]")
                .add("typ='" + typ + "'")
                .add("json='" + json + "'")
                .toString();
    }
}
