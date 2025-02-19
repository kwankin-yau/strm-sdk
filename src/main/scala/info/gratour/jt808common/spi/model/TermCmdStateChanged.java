/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import java.lang.reflect.Type;
import java.util.StringJoiner;

import com.google.gson.reflect.TypeToken;
import com.lucendar.common.utils.CommonUtils;
import com.lucendar.common.utils.DateTimeUtils;

import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jtcommon.JTUtils;

/**
 * 终端指令状态变更通知
 */
public class TermCmdStateChanged {

    /**
     * TermCmdStateChanged的类型信息，用于 GSON 序列化/反序列化。
     */
    public static final Type TYPE = new TypeToken<TermCmdStateChanged>() {
    }.getType();

    /**
     * App ID
     */
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

    /**
     * 发生状态变化的指令的外部ID(TermCmd.externalId)。
     */
    private String externalId;

    /**
     * 发生状态变化的指令的请求ID(TermCmd.reqId)。
     */
    private String reqId;

    /**
     * 发生状态变化的指令的请求时间。
     */
    private String reqTm;

    /**
     * 发生状态变化的指令的新状态。
     */ 
    private int status;

    /**
     * 指令发生状态变化的时间。
     */
    private String tm;

    /**
     * 发生变更的指令的消息ID，即对应的 TermCmd 的 msgId
     */
    private String initMsgId;

    /**
     * 发生变更的指令的子命令类型。
     */
    private String subCmdTyp;

    /**
     * 发生变更的指令的消息流水号。
     */
    private Integer msgSn;

    /**
     * 发生变更的指令的SIM卡号。
     */
    private String simNo;

    /**
     * 发生变更的指令的车牌号。
     */
    private String plateNo;

    /**
     * 发生变更的指令的车牌颜色。
     */
    private Integer plateColor;

    /**
     * 发生变更的指令的应答消息ID。仅当指令状态为 CMD_STATUS__ACK 时有效。
     */
    private String ackMsgId;

    /**
     * 发生变更的指令的应答消息流水号。仅当指令状态为 CMD_STATUS__ACK 时有效。
     */
    private Integer ackSeqNo;

    /**
     * 发生变更的指令的应答消息代码。仅当指令状态为 CMD_STATUS__ACK 时有效。
     */
    private Integer ackCode;

    /**
     * 发生变更的指令的应答消息参数。仅当指令状态为 CMD_STATUS__ACK 时有效。
     */
    private JT808AckParams ackParams;

    /**
     * 发布此通知的实例ID。用于发布到MQ上网关区分是否自己发布的通知
     */
    private String pub;

    /**
     * 取通知的UUID。每个通知的UUID均不一样，可用于去重复。
     * @return 通知的UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置通知的UUID。每个通知的UUID均不一样，可用于去重复。
     * @param uuid 通知的UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 取通知的AppID。
     * @return 通知的AppID
     */    

    public String getAppId() {
        return appId;
    }

    /**
     * 设置通知的AppID。
     * @param appId 通知的AppID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取发生状态变化的指令的ID(TermCmd.id)。
     * @return 发生状态变化的指令的ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置发生状态变化的指令的ID(TermCmd.id)。
     * @param id 发生状态变化的指令的ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取发生状态变化的指令的外部ID(TermCmd.externalId)。
     * @return 发生状态变化的指令的外部ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * 设置发生状态变化的指令的外部ID(TermCmd.externalId)。
     * @param externalId 发生状态变化的指令的外部ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * 取发生状态变化的指令的请求ID(TermCmd.reqId)。
     * @return 发生状态变化的指令的请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置发生状态变化的指令的请求ID(TermCmd.reqId)。
     * @param reqId 发生状态变化的指令的请求ID
     */
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

    /**
     * 取发生变更的指令的消息ID(TermCmd.msgId)。
     * @return 发生变更的指令的消息ID
     */
    public String getInitMsgId() {
        return initMsgId;
    }

    /**
     * 设置发生变更的指令的消息ID(TermCmd.msgId)。
     * @param initMsgId 发生变更的指令的消息ID
     */
    public void setInitMsgId(String initMsgId) {
        this.initMsgId = initMsgId;
    }

    /**
     * 取发生变更的指令的子命令类型(TermCmd.subCmdTyp)。
     * @return 发生变更的指令的子命令类型
     */
    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    /**
     * 设置发生变更的指令的子命令类型(TermCmd.subCmdTyp)。
     * @param subCmdTyp 发生变更的指令的子命令类型
     */
    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    /**
     * 取发生变更的指令的消息流水号(TermCmd.msgSn)。
     * @return 发生变更的指令的消息流水号
     */
    public Integer getMsgSn() {
        return msgSn;
    }

    /**
     * 设置发生变更的指令的消息流水号(TermCmd.msgSn)。
     * @param msgSn 发生变更的指令的消息流水号
     */
    public void setMsgSn(Integer msgSn) {
        this.msgSn = msgSn;
    }

    /**
     * 取发生变更的指令的SIM卡号(TermCmd.simNo)。
     * @return 发生变更的指令的SIM卡号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置发生变更的指令的SIM卡号(TermCmd.simNo)。
     * @param simNo 发生变更的指令的SIM卡号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取发生变更的指令的车牌号(TermCmd.plateNo)。
     * @return 发生变更的指令的车牌号
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置发生变更的指令的车牌号(TermCmd.plateNo)。
     * @param plateNo 发生变更的指令的车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    /**
     * 取发生变更的指令的车牌颜色(TermCmd.plateColor)。
     * @return 发生变更的指令的车牌颜色
     */
    public Integer getPlateColor() {
        return plateColor;
    }

    /**
     * 设置发生变更的指令的车牌颜色(TermCmd.plateColor)。
     * @param plateColor 发生变更的指令的车牌颜色
     */
    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 取引起此状态变更的应答消息ID。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @return 引起此状态变更的应答消息ID
     */
    public String getAckMsgId() {
        return ackMsgId;
    }

    /**
     * 设置引起此状态变更的应答消息ID。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @param ackMsgId 引起此状态变更的应答消息ID
     */
    public void setAckMsgId(String ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    /**
     * 取引起此状态变更的应答消息的流水号。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @return 引起此状态变更的应答消息的流水号
     */
    public Integer getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置引起此状态变更的应答消息的流水号。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @param ackSeqNo 引起此状态变更的应答消息的流水号
     */
    public void setAckSeqNo(Integer ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 取引起此状态变更的应答消息的应答码。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @return 引起此状态变更的应答消息的应答码
     */
    public Integer getAckCode() {
        return ackCode;
    }

    /**
     * 设置引起此状态变更的应答消息的应答码。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @param ackCode 引起此状态变更的应答消息的应答码
     */
    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    /**
     * 取引起此状态变更的应答消息的参数（数据内容）。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @return 引起此状态变更的应答消息的参数（数据内容）
     */
    public JT808AckParams getAckParams() {
        return ackParams;
    }

    /**
     * 设置引起此状态变更的应答消息的参数（数据内容）。仅当指令状态为 CMD_STATUS__ACK 时有效。
     * @param ackParams 引起此状态变更的应答消息的参数（数据内容）
     */
    public void setAckParams(JT808AckParams ackParams) {
        this.ackParams = ackParams;
    }

    /**
     * 判断指令是否已应答。
     * @return 如果指令已应答，则返回 true；否则返回 false
     */ 
    public boolean acknowledged() {
        return status == TermCmd.CMD_STATUS__ACK;
    }

    /**
     * 判断指令是否成功。
     * @return 如果指令已应答且应答码为0，则返回 true；否则返回 false
     */
    public boolean isSuccess() {
        return status == TermCmd.CMD_STATUS__ACK && (ackCode == null || ackCode == 0);
    }

    /**
     * 判断指令是否已应答或已结束。
     * @return 如果指令已应答或已结束，则返回 true；否则返回 false
     */
    public boolean ackOrCompleted() {
        return TermCmd.isAckOrCompletedStatus(status);
    }

    /**
     * 判断指令是否因错误而结束。
     * @return 如果指令因错误而结束，则返回 true；否则返回 false
     */
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

    /**
     * 设置发布此变更通知的服务实例ID。用于发布到MQ上各个服务区分是否自己发布的命令消息
     * @param pub 发布此变更通知的服务实例ID
     */
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
     * 取发生变更的指令的消息ID的整数值。本方法只用于部分协议，如：JT/T 808, JT/T 1078 系列协议
     *
     * @return 发生变更的指令的消息ID的整数值
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
