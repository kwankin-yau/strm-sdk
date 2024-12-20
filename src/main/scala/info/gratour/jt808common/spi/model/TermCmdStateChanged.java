/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import com.google.gson.reflect.TypeToken;
import com.lucendar.common.utils.CommonUtils;
import com.lucendar.common.utils.DateTimeUtils;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jtcommon.JTUtils;

import java.lang.reflect.Type;
import java.util.StringJoiner;

/**
 * 终端指令状态变更通知
 */
public class TermCmdStateChanged {

    public static final Type TYPE = new TypeToken<TermCmdStateChanged>() {
    }.getType();


    private String appId;

    /**
     * 变更通知消息唯一号。每个变更通知的消息唯一号均不一样，可用于去重复。由发出此通知的模块设置。
     * <p>
     * 通常由 `com.lucendar.common.utils.CommonUtils#uuidBase64NoPadding()`产生。
     * <p>
     * 参见：本类的setRandomUuid()方法
     */
    private String uuid;

    /**
     * 对应的TermCmd的id
     */
    private String id;
    private String externalId;
    private String reqId;
    private String reqTm;

    private int status;
    private String tm;

    /**
     * 发生变更的指令的消息ID，即对应的 TermCmd 的 msgId
     */
    private String initMsgId;
    private String subCmdTyp;

    private Integer msgSn;

    private String simNo;
    private String plateNo;
    private Integer plateColor;

    private String ackMsgId;
    private Integer ackSeqNo;
    private Integer ackCode;
    private JT808AckParams ackParams;

    /**
     * 发布此通知的实例ID。用于发布到MQ上网关区分是否自己发布的通知
     */
    private String pub;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(long reqTm) {
        this.reqTm = DateTimeUtils.BeijingConv.millisToString(reqTm);
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取指令状态
     *
     * @return 指令状态。为 TermCmd.CMD_STATUS__xxx 系列常量之一
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置指令状态
     *
     * @param status 指令状态。为 TermCmd.CMD_STATUS__xxx 系列常量之一
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 取指令发生变更的时间，格式: yyyy-MM-dd HH:mm:ss，北京时间
     *
     * @return 指令发生变更的时间
     */
    public String getTm() {
        return tm;
    }

    /**
     * 设置指令发生变更的时间
     *
     * @param tm 指令发生变更的时间，epoch millis
     */
    public void setTm(long tm) {
        this.tm = DateTimeUtils.BeijingConv.millisToString(tm);
    }

    /**
     * 设置指令发生变更的时间
     *
     * @param tm 指令发生变更的时间，格式: yyyy-MM-dd HH:mm:ss，北京时间
     */
    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getInitMsgId() {
        return initMsgId;
    }

    public void setInitMsgId(String initMsgId) {
        this.initMsgId = initMsgId;
    }

    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    public Integer getMsgSn() {
        return msgSn;
    }

    public void setMsgSn(Integer msgSn) {
        this.msgSn = msgSn;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public String getAckMsgId() {
        return ackMsgId;
    }

    public void setAckMsgId(String ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    /**
     * 应答消息的流水号
     *
     * @return 应答消息的流水号
     */
    public Integer getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(Integer ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public Integer getAckCode() {
        return ackCode;
    }

    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    public JT808AckParams getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT808AckParams ackParams) {
        this.ackParams = ackParams;
    }

    public boolean acknowledged() {
        return status == TermCmd.CMD_STATUS__ACK;
    }

    public boolean isSuccess() {
        return status == TermCmd.CMD_STATUS__ACK && (ackCode == null || ackCode == 0);
    }

    public boolean ackOrCompleted() {
        return TermCmd.isAckOrCompletedStatus(status);
    }

    public boolean completedDueToError() {
        return status < 0;
    }

    /**
     * 取发布此变更通知的服务实例ID。用于发布到MQ上各个服务区分是否自己发布的命令消息
     *
     * @return 发布此变更通知的服务实例ID
     */
    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    /**
     * 从 TermCmd 对象中复制属性。
     *
     * @param cmd      源 TermCmd 对象
     * @param status    新的指令状态
     * @param changeTm 状态变更的时间
     */
    public void assign(TermCmd cmd, int status, long changeTm) {
        this.appId = cmd.appIdDef();
        this.id = cmd.getId();
        this.externalId = cmd.getExternalId();
        this.reqId = cmd.getReqId();
        this.reqTm = DateTimeUtils.BeijingConv.millisToString(cmd.getReqTm());
        this.status = status;
        this.tm = DateTimeUtils.BeijingConv.millisToString(changeTm);
        this.initMsgId = cmd.getMsgId();
        this.subCmdTyp = cmd.getSubCmdTyp();
        this.msgSn = cmd.getMsgSn();
        this.simNo = cmd.getSimNo();
        this.plateNo = cmd.getPlateNo();
        this.plateColor = cmd.getPlateColor();

        this.ackMsgId = cmd.getAckMsgId();
        this.ackSeqNo = cmd.getAckSeqNo();
        this.ackCode = cmd.getAckCode();
        this.ackParams = cmd.getAckParams();
    }

    /**
     * 从 TermCmd 对象中复制属性。`status` 采用 `termCmd.status`。
     *
     * @param cmd      源 TermCmd 对象
     * @param changeTm 状态变更的时间
     */
    public void assign(TermCmd cmd, long changeTm) {
        assign(cmd, cmd.getStatus(), changeTm);
    }

    /**
     * 将变更应用到 TermCmd 对象中。
     *
     * @param cmd 目标 TermCmd 对象
     */
    public void applyTo(TermCmd cmd) {
        switch (status) {
            case TermCmd.CMD_STATUS__SENT:
                cmd.setStatus(TermCmd.CMD_STATUS__SENT);
                cmd.setSentTm(tmAsEpochMillis());
                cmd.setMsgSn(msgSn);
                break;

            case TermCmd.CMD_STATUS__ACK:
                cmd.setStatus(TermCmd.CMD_STATUS__ACK);
                cmd.setAckMsgId(ackMsgId);
                cmd.setAckSeqNo(ackSeqNo);
                cmd.setAckCode(ackCode);
                cmd.setAckParams(ackParams);
                cmd.setAckTm(tmAsEpochMillis());
                break;

            default:
                cmd.setStatus(status);
                cmd.setEndTm(tmAsEpochMillis());
        }
    }

    /**
     * 将指令发生变更的时间字符串转船成 epoch millis。
     *
     * @return 指令发生变更的时间 的 epoch millis 表示。
     */
    public Long tmAsEpochMillis() {
        if (tm != null)
            return DateTimeUtils.BeijingConv.stringToMillis(tm);
        else
            return null;
    }

    /**
     * 取 initMsgId 属性的整数值。本方法只用于部分协议，如：JT/T 808, JT/T 1078 系列协议
     *
     * @return initMsgId 属性的整数值
     */
    public int jtInitMsgId() {
        return JTUtils.hexToMsgId(initMsgId);
    }

    /**
     * 将 uuid 属性设置为随机 UUID 的 Base64 形式
     */
    public void setRandomUuid() {
        uuid = CommonUtils.uuidBase64NoPadding();
    }

    /**
     * 交换 `id` 和 `externalId` 属性的值
     */
    public void swapIdAndExternalId() {
        var s = id;
        id = externalId;
        externalId = s;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TermCmdStateChanged.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("uuid='" + uuid + "'")
                .add("id='" + id + "'")
                .add("externalId='" + externalId + "'")
                .add("reqId='" + reqId + "'")
                .add("reqTm='" + reqTm + "'")
                .add("status=" + status)
                .add("tm='" + tm + "'")
                .add("initMsgId='" + initMsgId + "'")
                .add("subCmdTyp='" + subCmdTyp + "'")
                .add("msgSn=" + msgSn)
                .add("simNo='" + simNo + "'")
                .add("plateNo='" + plateNo + "'")
                .add("plateColor=" + plateColor)
                .add("ackMsgId='" + ackMsgId + "'")
                .add("ackSeqNo=" + ackSeqNo)
                .add("ackCode=" + ackCode)
                .add("ackParams=" + ackParams)
                .add("pub='" + pub + "'")
                .toString();
    }
}
