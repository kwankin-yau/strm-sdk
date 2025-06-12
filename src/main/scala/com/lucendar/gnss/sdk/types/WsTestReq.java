package com.lucendar.gnss.sdk.types;

import java.util.StringJoiner;

/**
 * WebSocket 接口 测试请求。用于调试，可触发 服务向 WebSocket 发送消息
 */
public class WsTestReq {

    private String queue;
    private String msg;

    /**
     * 获取消息的队列名
     * @return 消息的队列名
     */
    public String getQueue() {
        return queue;
    }

    /**
     * 设置消息的队列名
     * @param queue 消息的队列名
     */
    public void setQueue(String queue) {
        this.queue = queue;
    }

    /**
     * 获取所要发送的消息的内容
     * @return 所要发送的消息的内容
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置所要发送的消息的内容
     * @param msg 所要发送的消息的内容
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WsTestReq.class.getSimpleName() + "[", "]")
                .add("queue='" + queue + "'")
                .add("msg='" + msg + "'")
                .toString();
    }
}
