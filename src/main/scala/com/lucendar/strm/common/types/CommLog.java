package com.lucendar.strm.common.types;

import com.lucendar.strm.common.utils.StrmUtils;

import java.util.StringJoiner;

/**
 * Communication log entry.
 */
public class CommLog {

    public static final String EVT_TYP__CONN = "CONN";
    public static final String EVT_TYP__DISC = "DISC";
    public static final String EVT_TYP__RECV = "RECV";
    public static final String EVT_TYP__DECO = "DECO";
    public static final String EVT_TYP__SEND = "SEND";
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Integer getChan() {
        return chan;
    }

    public void setChan(Integer chan) {
        this.chan = chan;
    }

    public String getEvtTyp() {
        return evtTyp;
    }

    public void setEvtTyp(String evtTyp) {
        this.evtTyp = evtTyp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getDataSz() {
        return dataSz;
    }

    public void setDataSz(Integer dataSz) {
        this.dataSz = dataSz;
    }

    public byte[] getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(byte[] binaryData) {
        this.binaryData = binaryData;
    }

    public void encodeFromBinaryData() {
        if (binaryData != null)
            data = StrmUtils.bytesToHex(binaryData);
        else
            data = null;
    }

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
