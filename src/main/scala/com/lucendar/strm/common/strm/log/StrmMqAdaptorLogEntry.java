package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

/**
 * 消息列表消息转换日志。记录媒体服务调用 消息转换脚本 (JS) 的输入输出。主要用于集成方调试。
 */
public class StrmMqAdaptorLogEntry {

    private String id;
    private long tm;
    private String appId;
    private String method;
    private String input;
    private String err;
    private String output;

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
     * 设置 AppID
     * @param appId AppID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取所调用的方法的名称，如 "getAckInfo", "convertTermCmd"
     * @return 所调用的方法的名称
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置所调用的方法的名称
     * @param method 所调用的方法的名称
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 取方法的输入数据
     *
     * @return 方法的输入数据
     */
    public String getInput() {
        return input;
    }

    /**
     * 设置方法的输入数据
     * @param input 方法的输入数据
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * 取调用过程中发生的错误
     * @return 调用过程中发生的错误，返回 null 时，表示未发生错误
     */
    public String getErr() {
        return err;
    }

    /**
     * 设置调用过程中发生的错误
     * @param err 调用过程中发生的错误。为 null 时，表示未发生错误
     */
    public void setErr(String err) {
        this.err = err;
    }

    /**
     * 取调用方法返回的数据
     *
     * @return 调用方法返回的数据
     */
    public String getOutput() {
        return output;
    }

    /**
     * 设置调用方法返回的数据
     * @param output 调用方法返回的数据
     */
    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmMqAdaptorLogEntry.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("tm=" + tm)
                .add("appId='" + appId + "'")
                .add("method='" + method + "'")
                .add("input='" + input + "'")
                .add("err='" + err + "'")
                .add("output='" + output + "'")
                .toString();
    }
}
