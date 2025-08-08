package com.lucendar.strm.common.strm.log;

import java.util.StringJoiner;

/**
 * 聚合后的跟踪日志
 */
public class CombinedTraceLog {

    /**
     * 日志记录类型：码流通讯日志
     */
    public static final String TYP__STRM_COMM_LOG = "code-strm";

    /**
     * 日志记录类型：媒体服务通知
     */
    public static final String TYP__STRM_NOTIF = "strm-notif";

    /**
     * 日志记录类型：终端指令
     */
    public static final String TYP__TERM_CMD = "term-cmd";

    /**
     * 日志记录类型：API 调用
     */
    public static final String TYP__API_CALL = "api-call";

    /**
     * 日志记录类型，为 TYP__xxx 系列常量之一
     */
    private String typ;

    /**
     * 日志记录子类型
     * 当 typ 为 `code-strm` 时，存放 `CommLog.evtTyp` 属性
     * 当 typ 为 `strm-notif` 时，存放 `StrmMediaNotif.act` 属性
     * 当 typ 为 `term-cmd` 时， 存放 `TermCmd.msgId` 属性
     * 当 typ 为 `api-call` 时，存放 `StrmApiCall.apiName` 属性
     */
    private String subTyp;

    /**
     * 日志时间，实际类型 long， epoch millis
     */
    private String ts;

    /**
     * 顺序号，实际类型 long
     */
    private String ord;

    private String desc;

    /**
     * 日志数据，可能不出现此属性，而仅出现 dataSz
     */
    private String data;

    /**
     * 日志数据长度，字节
     */
    private Integer dataSz;

    /**
     * 取日志记录类型，为 TYP__xxx 系列常量之一
     * @return 日志记录类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置日志记录类型
     * @param typ 日志记录类型，为 TYP__xxx 系列常量之一
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 取日志记录子类型
     * <ul>
     *     <li>当 typ 为 `code-strm` 时，存放 `CommLog.evtTyp` 属性</li>
     *     <li>当 typ 为 `strm-notif` 时，存放 `StrmMediaNotif.act` 属性</li>
     *     <li>当 typ 为 `term-cmd` 时， 存放 `TermCmd.msgId` 属性</li>
     *     <li>当 typ 为 `api-call` 时，存放 `StrmApiCall.apiName` 属性</li>
     * </ul>
     * @return 日志记录子类型
     */
    public String getSubTyp() {
        return subTyp;
    }

    /**
     * 设置日志记录子类型
     * @param subTyp 日志记录子类型
     */
    public void setSubTyp(String subTyp) {
        this.subTyp = subTyp;
    }

    /**
     * 取日志时间，实际类型 long， epoch millis
     * @return 日志时间，实际类型 long， epoch millis
     */
    public String getTs() {
        return ts;
    }

    /**
     * 设置日志时间
     * @param ts，实际类型 long， epoch millis
     */
    public void setTs(String ts) {
        this.ts = ts;
    }

    /**
     * 取顺序号，实际类型 long
     * @return 顺序号，实际类型 long
     */
    public String getOrd() {
        return ord;
    }

    /**
     * 设置顺序号
     * @param ord 顺序号，实际类型 long
     */
    public void setOrd(String ord) {
        this.ord = ord;
    }

    /**
     * 取事件描述
     *
     * @return 事件描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置事件描述
     * @param desc 事件描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 取日志数据, hex 格式
     *
     * @return 日志数据
     */
    public String getData() {
        return data;
    }

    /**
     * 设置日志数据
     * @param data 日志数据, hex 格式
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 取日志数据长度，字节
     * @return 日志数据长度，字节
     */
    public Integer getDataSz() {
        return dataSz;
    }

    /**
     * 设置日志数据长度，字节
     * @param dataSz 日志数据长度，字节
     */
    public void setDataSz(Integer dataSz) {
        this.dataSz = dataSz;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CombinedTraceLog.class.getSimpleName() + "[", "]")
                .add("typ='" + typ + "'")
                .add("subTyp='" + subTyp + "'")
                .add("ts='" + ts + "'")
                .add("ord='" + ord + "'")
                .add("desc='" + desc + "'")
                .add("data='" + data + "'")
                .add("dataSz=" + dataSz)
                .toString();
    }
}
