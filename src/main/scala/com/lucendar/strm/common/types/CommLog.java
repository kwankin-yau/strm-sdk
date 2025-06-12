package com.lucendar.strm.common.types;

import java.util.StringJoiner;

import com.lucendar.strm.common.utils.StrmUtils;

/**
 * 通信日志条目
 */
public class CommLog {

    /**
     * 事件类型: 连接
     */
    public static final String EVT_TYP__CONN = "CONN";

    /**
     * 事件类型: 断开连接
     */
    public static final String EVT_TYP__DISC = "DISC";

    /**
     * 事件类型: 接收
     */
    public static final String EVT_TYP__RECV = "RECV";

    /**
     * 事件类型: 解码
     */
    public static final String EVT_TYP__DECO = "DECO";

    /**
     * 事件类型: 发送
     */
    public static final String EVT_TYP__SEND = "SEND";

    /**
     * 事件类型: 错误
     */
    public static final String EVT_TYP__ERRO = "ERRO";

    private String id;

    /**
     * The time of the event.
     */
    private long ts;

    private String appId;

    /**
     * Media (open live channel or open replay channel) request ID.
     * This field primary used in JT/T 1078 code stream log rather general JT/T 808 communication log.
     */
    private String reqId;

    private String simNo;

    /**
     * Media Code stream channel ID.
     * This field primary used in JT/T 1078 code stream log rather general JT/T 808 communication log.
     */
    private Integer chan;

    /**
     * Event type. One of EVT_TYP__xxxx constant.
     */
    private String evtTyp;


    /**
     * The event description.
     * <p>
     * - for `CONN`, `DISC`, this field is a k/v list.
     * - for `DECO`, `SEND`, this field is the result of the JT808Msg.toString() method.
     * - for `SEND`, this field may be null.
     */
    private String desc;


    /**
     * The packet content of `RECV`/`SEND`.
     */
    private String data;

    /**
     * The size of the packet content. The server will only return `dataSz` instead of `data` if retData
     */
    private Integer dataSz;

    transient private byte[] binaryData;


    /**
     * 获取记录ID
     * @return 记录ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置记录ID
     * @param id 记录ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取事件时间戳
     * @return 事件时间戳
     */
    public long getTs() {
        return ts;
    }

    /**
     * 设置事件时间戳
     * @param ts 事件时间戳
     */
    public void setTs(long ts) {
        this.ts = ts;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取终端识别号
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
     * 获取通道ID
     * @return 通道ID
     */
    public Integer getChan() {
        return chan;
    }

    /**
     * 设置通道ID
     * @param chan 通道ID
     */
    public void setChan(Integer chan) {
        this.chan = chan;
    }

    /**
     * 获取事件类型
     * @return 事件类型
     */
    public String getEvtTyp() {
        return evtTyp;
    }

    /**
     * 设置事件类型
     * @param evtTyp 事件类型
     */
    public void setEvtTyp(String evtTyp) {
        this.evtTyp = evtTyp;
    }

    /**
     * 获取事件描述
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
     * 获取事件数据（十六进制）
     * @return 事件数据
     */
    public String getData() {
        return data;
    }

    /**
     * 设置事件数据（十六进制）
     * @param data 事件数据
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 获取事件数据大小
     * @return 事件数据大小
     */
    public Integer getDataSz() {
        return dataSz;
    }

    /**
     * 设置事件数据大小
     * @param dataSz 事件数据大小
     */
    public void setDataSz(Integer dataSz) {
        this.dataSz = dataSz;
    }

    /**
     * 获取事件二进制数据
     * @return 事件二进制数据
     */
    public byte[] getBinaryData() {
        return binaryData;
    }

    /**
     * 设置事件二进制数据
     * @param binaryData 事件二进制数据
     */
    public void setBinaryData(byte[] binaryData) {
        this.binaryData = binaryData;
    }

    /**
     * 从二进制数据编码十六进制事件数据
     */
    public void encodeFromBinaryData() {
        if (binaryData != null)
            data = StrmUtils.bytesToHex(binaryData);
        else
            data = null;
    }

    /**
     * 从二进制数据编码十六进制事件数据
     * @return 事件数据
     */
    public String dataFromBinary() {
        if (data == null)
            encodeFromBinaryData();

        return data;
    }

    @Override
    public String toString() {
        String d = data != null ? data : (binaryData != null ? StrmUtils.bytesToHex(binaryData) : "");

        return new StringJoiner(", ", CommLog.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("ts=" + ts)
                .add("appId='" + appId + "'")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("evtTyp='" + evtTyp + "'")
                .add("desc='" + desc + "'")
                .add("data='" + d + "'")
                .add("dataSz=" + dataSz)
                .toString();
    }
}
