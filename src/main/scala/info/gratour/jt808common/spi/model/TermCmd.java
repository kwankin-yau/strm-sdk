/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import com.lucendar.common.utils.CommonUtils;
import info.gratour.jt808common.protocol.msg.types.ackparams.AckParamsParser;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CmdParamsParser;
import info.gratour.jt808common.protocol.msg.types.cmdparams.JT808CmdParams;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 终端指令实体对象
 */
public class TermCmd implements Cloneable {

    public static final ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle(
                "info.gratour.jt808common.spi.model.term-cmds",
                locale != null ? locale : Locale.getDefault()
        );
    }

    public static final int CMD_STATUS__INIT = 0;
    public static final int CMD_STATUS__SENT = 1;
    public static final int CMD_STATUS__ACK = 2;

    /**
     * Use CMD_STATUS__EXECUTE_FAILED instead
     */
    @Deprecated
    public static final int CMD_STATUS__EXCEPTION = -1;
    public static final int CMD_STATUS__EXECUTE_FAILED = -1;
    public static final int CMD_STATUS__BAD_CMD = -2;
    public static final int CMD_STATUS__NOT_SUPPORTED = -3;
    public static final int CMD_STATUS__CANCELED = -4;
    public static final int CMD_STATUS__NO_CONNECTION = -5;
    public static final int CMD_STATUS__TIMEOUT = -6;

    protected static String getStatusStringKey(int status) {
        switch (status) {
            case CMD_STATUS__INIT:
                return "term_cmd.state_init";

            case CMD_STATUS__SENT:
                return "term_cmd.state_sent";

            case CMD_STATUS__ACK:
                return "term_cmd.state_ack";

            case CMD_STATUS__EXECUTE_FAILED:
                return "term_cmd.state_execute_failed";

            case CMD_STATUS__BAD_CMD:
                return "term_cmd.state_bad_cmd";

            case CMD_STATUS__NOT_SUPPORTED:
                return "term_cmd.state_not_supported";

            case CMD_STATUS__CANCELED:
                return "term_cmd.state_canceled";

            case CMD_STATUS__NO_CONNECTION:
                return "term_cmd.state_no_connection";

            case CMD_STATUS__TIMEOUT:
                return "term_cmd.state_timeout";

            default:
                return null;
        }
    }

    public static String getStatusString(Locale locale, int status) {
        String key = getStatusStringKey(status);
        if (key == null)
            return "status(" + status + ")";

        return resourceBundle(locale).getString(key);
    }

    public static String getStatusString(int status) {
        return getStatusString(null, status);
    }

    public static boolean isAckOrCompletedStatus(int status) {
        switch (status) {
            case CMD_STATUS__ACK:
            case CMD_STATUS__EXCEPTION:
            case CMD_STATUS__BAD_CMD:
            case CMD_STATUS__NOT_SUPPORTED:
            case CMD_STATUS__CANCELED:
            case CMD_STATUS__NO_CONNECTION:
            case CMD_STATUS__TIMEOUT:
                return true;

            default:
                return false;
        }
    }

    private String appId = "";

    /**
     * TermCmd record ID
     */
    private String id;

    /**
     * The external system command id of this command.
     */
    private String externalId;

    /**
     * The ID of request, that issued by user, initiated this terminal command. May be null. This property used for
     * associate the terminal command with the initial request. If this property is null, that means this command has
     * no initial request or the initial request is unknown.
     */
    private String reqId;

    /**
     * The session token of the sender of this command. The initial purpose of this property is keep trace of the
     * command sender, so that we can send back CmdStateChanged notification to this sender when command state has been
     * changed.
     */
    private transient String senderToken;

    private long reqTm;
    private Long sentTm;
    private Long ackTm;
    private Long endTm;
    private int status;
    private String simNo;
    private String msgId;
    private String subCmdTyp;
    private String plateNo;
    private Integer plateColor;
    private Integer msgSn;
    private JT808CmdParams params;

    /**
     * 终端应答自身的指令消息号
     */
    private String ackMsgId;

    /**
     * 终端应答自身的指令消息流水号
     */
    private Integer ackSeqNo;

    /**
     * 终端应答的应答码
     */
    private Integer ackCode;

    /**
     * 终端应答的数据内容
     */
    private JT808AckParams ackParams;
    private Integer timeout;

    /**
     * 发布此命令的服务实例ID。用于发布到MQ上各个服务区分是否自己发布的命令消息
     */
    private String pub;

    /**
     * 取指令所属的 AppId
     *
     * @return 指令所属的 AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置指令所属的 AppId
     *
     * @param appId 指令所属的 AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取指令记录ID。全局唯一
     *
     * @return 指令记录ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置指令记录ID
     *
     * @param id 指令记录ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取外部系统的指令ID
     *
     * @return 外部系统的指令ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * 设置外部系统的指令ID
     *
     * @param externalId 外部系统的指令ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * 取请求ID。主要用于媒体服务跟踪，记录本指令所关联的媒体请求的ID
     *
     * @return 请求ID
     */
    @Nullable
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     *
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取下发本指令的用户的令牌。主要用于媒体服务
     *
     * @return 下发本指令的用户的令牌
     */
    @Nullable
    public String getSenderToken() {
        return senderToken;
    }

    /**
     * 下发本指令的用户的令牌
     *
     * @param senderToken 下发本指令的用户的令牌
     */
    public void setSenderToken(String senderToken) {
        this.senderToken = senderToken;
    }

    /**
     * 取终端指令的请求时间, epoch millis.
     *
     * @return 终端指令的请求时间
     */
    public long getReqTm() {
        return reqTm;
    }

    private static OffsetDateTime toOffsetDateTime(Long tm) {
        if (tm != null)
            return OffsetDateTime.ofInstant(Instant.ofEpochMilli(tm), JTConsts.ZONE_OFFSET_BEIJING());
        else
            return null;
    }

    private static Long toEpochMilli(OffsetDateTime odt) {
        if (odt != null)
            return odt.toInstant().toEpochMilli();
        else
            return null;
    }

    /**
     * 取终端指令的请求时间, 返回 OffsetDateTime 对象
     *
     * @return 终端指令的请求时间
     */
    public OffsetDateTime getReqTmOdt() {
        return toOffsetDateTime(reqTm);
    }

    /**
     * 设置终端指令的请求时间
     *
     * @param reqTm 终端指令的请求时间, epoch millis
     */
    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 设置终端指令的请求时间
     *
     * @param odt 终端指令的请求时间
     */
    public void setReqTm(OffsetDateTime odt) {
        if (odt == null)
            throw new NullPointerException();

        this.reqTm = toEpochMilli(odt);
    }

    /**
     * 取实际下发到终端的时间, epoch millis.
     *
     * @return 实际下发到终端的时间，未下发时，返回 null
     */
    @Nullable
    public Long getSentTm() {
        return sentTm;
    }

    /**
     * 取实际下发到终端的时间
     *
     * @return 实际下发到终端的时间，未下发时，返回 null
     */
    @Nullable
    public OffsetDateTime getSentTmOdt() {
        return toOffsetDateTime(sentTm);
    }

    /**
     * 设置实际下发到终端的时间
     *
     * @param sentTm 实际下发到终端的时间, epoch millis
     */
    public void setSentTm(Long sentTm) {
        this.sentTm = sentTm;
    }

    /**
     * 设置实际下发到终端的时间
     *
     * @param odt 实际下发到终端的时间
     */
    public void setSentTm(OffsetDateTime odt) {
        this.sentTm = toEpochMilli(odt);
    }

    /**
     * 取指令的应答时间，epoch millis。
     *
     * @return 指令的应答时间，未应答时，返回 null
     */
    public Long getAckTm() {
        return ackTm;
    }

    /**
     * 取指令的应答时间
     *
     * @return 指令的应答时间，未应答时，返回 null
     */
    public OffsetDateTime getAckTmOdt() {
        return toOffsetDateTime(ackTm);
    }

    /**
     * 设置指令的应答时间
     *
     * @param ackTm 指令的应答时间，epoch millis
     */
    public void setAckTm(Long ackTm) {
        this.ackTm = ackTm;
    }

    /**
     * 设置指令的应答时间
     *
     * @param odt 指令的应答时间
     */
    public void setAckTm(OffsetDateTime odt) {
        this.ackTm = toEpochMilli(odt);
    }

    /**
     * 设置指令的结束时间（已应答、或下发失败的时间）, epoch millis
     *
     * @return 指令的结束时间。未结束时，返回 null
     */
    public Long getEndTm() {
        return endTm;
    }

    /**
     * 设置指令的结束时间（已应答、或下发失败的时间）
     *
     * @return 指令的结束时间。未结束时，返回 null
     */
    public OffsetDateTime getEndTmOdt() {
        return toOffsetDateTime(endTm);
    }

    /**
     * 设置设置指令的结束时间
     *
     * @param endTm 指令的结束时间，epoch millis
     */
    public void setEndTm(Long endTm) {
        this.endTm = endTm;
    }

    /**
     * 设置指令的结束时间
     *
     * @param odt 指令的结束时间
     */
    public void setEndTm(OffsetDateTime odt) {
        this.endTm = toEpochMilli(odt);
    }


    /**
     * 取目标终端的终端识别号
     *
     * @return 目标终端的终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置目标终端的终端识别号
     *
     * @param simNo 目标终端的终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取指令的消息号，如 JT/T 808 协议的定位指令，消息号为 `0200`
     *
     * @return 指令的消息号
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置指令的消息号
     *
     * @param msgId 指令的消息号
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * 取消息号的整数形式，本方法只用于部分协议，如：JT/T 808, JT/T 1078 系列协议
     *
     * @return 消息号的整数形式
     */
    public int jtMsgId() {
        return Integer.parseInt(msgId, 16);
    }

    /**
     * 设置整数表达的消息号
     *
     * @param jtMsgId 整数表达的消息号
     */
    public void jtMsgId(int jtMsgId) {
        msgId = JTUtils.msgIdToHex(jtMsgId);
    }

    /**
     * 取命令的子命令类型。
     *
     * @return 命令的子命令类型。
     */
    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    /**
     * 设置命令的子命令类型。
     *
     * @param subCmdTyp 命令的子命令类型。
     */
    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    /**
     * 取指令所要下发到的车辆的车牌号，主要用于 809 协议下发指令的场景，此时，`simNo` 属性为 null，主要用 `plateNo`, `plateColor` 组合
     * 确定终端。
     *
     * @return 指令所要下发到的车辆的车牌号
     */
    @Nullable
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置指令所要下发到的车辆的车牌号
     *
     * @param plateNo 取指令所要下发到的车辆的车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }


    /**
     * 取指令所要下发到的车辆的车牌颜色代码。参见 `plateNo` 属性的注释
     *
     * @return 指令所要下发到的车辆的车牌颜色代码。
     */
    public Integer getPlateColor() {
        return plateColor;
    }

    /**
     * 设置指令所要下发到的车辆的车牌颜色代码
     *
     * @param plateColor 指令所要下发到的车辆的车牌颜色代码
     */
    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 取指令编码后的消息流水号
     *
     * @return 指令编码后的消息流水号，如果未下发，则为 null
     */
    @Nullable
    public Integer getMsgSn() {
        return msgSn;
    }

    /**
     * 设置指令编码后的消息流水号
     *
     * @param msgSn 指令编码后的消息流水号
     */
    public void setMsgSn(Integer msgSn) {
        this.msgSn = msgSn;
    }

    /**
     * 取指令参数
     *
     * @return 指令参数
     */
    public JT808CmdParams getParams() {
        return params;
    }

    /**
     * 设置指令参数
     *
     * @param params 指令参数
     */
    public void setParams(JT808CmdParams params) {
        this.params = params;
    }

    /**
     * 将指令参数转换为 JSON 字符串
     *
     * @return 转换后的 JSON 字符串。如果 params 为 null，则返回 null
     */
    @Nullable
    public String paramsJson() {
        JT808CmdParams params = getParams();
        if (params != null)
            return JTConsts.GSON().toJson(params);
        else
            return null;
    }

    /**
     * 取指令状态代码
     *
     * @return 指令状态代码。见本类的 CMD_STATUS___ 系列常量定义
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置指令状态代码
     *
     * @param status 指令状态代码。见本类的 CMD_STATUS___ 系列常量定义
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 返回指令状态是否为已应答
     *
     * @return 指令状态是否为已应答
     */
    public boolean acknowledged() {
        return status == TermCmd.CMD_STATUS__ACK;
    }

    /**
     * 返回指令状态是否为已结束
     *
     * @return 指令状态是否为已结束
     */
    public boolean completed() {
        return TermCmd.isAckOrCompletedStatus(status);
    }

    /**
     * 取指令应答后，终端应答消息的消息ID
     *
     * @return 指令应答后，终端应答消息的消息ID。未应答时或无法取得时，返回 null，
     */
    public String getAckMsgId() {
        return ackMsgId;
    }

    /**
     * 设置指令应答后，终端应答消息的消息ID
     *
     * @param ackMsgId 指令应答后，终端应答消息的消息ID
     */
    public void setAckMsgId(String ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    /**
     * 取指令应答后，终端应答消息的消息流水号
     *
     * @return 指令应答后，终端应答消息的消息流水号。未应答时或无法取得时，返回 null，
     */
    public Integer getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置指令应答后，终端应答消息的消息流水号
     *
     * @param ackSeqNo 指令应答后，终端应答消息的消息流水号
     */
    public void setAckSeqNo(Integer ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 取指令应答后，终端应答消息的应答代码
     *
     * @return 指令应答后，终端应答消息的应答代码。未应答时或无应答码、或无法取得时，返回 null，
     */
    public Integer getAckCode() {
        return ackCode;
    }

    /**
     * 设置指令应答后，终端应答消息的应答代码
     *
     * @param ackCode 指令应答后，终端应答消息的应答代码
     */
    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    /**
     * 取指令应答后，终端应答中包含的应答数据
     *
     * @return 指令应答后，终端应答中包含的应答数据。未应答时或无应答数据、或无法取得时，返回 null，
     */
    public JT808AckParams getAckParams() {
        return ackParams;
    }

    /**
     * 设置指令应答后，终端应答中包含的应答数据
     *
     * @param ackParams 指令应答后，终端应答中包含的应答数据
     */
    public void setAckParams(JT808AckParams ackParams) {
        this.ackParams = ackParams;
    }

    /**
     * 将指令应答后，终端应答中包含的应答数据转换成 JSON 字符串
     *
     * @return 转换后的 JSON 字符串。如果 ackParams 为 null ，则返回 null
     */
    @Nullable
    public String ackParamsJson() {
        JT808AckParams ackParams = getAckParams();
        if (ackParams != null)
            return JTConsts.GSON().toJson(ackParams);
        else
            return null;
    }

    /**
     * 取下发者指定的指令超时时间，单位秒。此属性为提示性质的属性，服务端可能不遵从此超时设置。未指令时，指令的超时时间由服务端确定。
     *
     * @return 下发者指定的指令超时时间，单位秒
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * 设置下发者指定的指令超时时间，单位秒。此属性为提示性质的属性，服务端可能不遵从此超时设置。未指令时，指令的超时时间由服务端确定。
     *
     * @param timeout 下发者指定的指令超时时间，单位秒
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * 取发布此命令的服务实例ID。用于发布到MQ上各个服务区分是否自己发布的命令消息
     *
     * @return 发布此命令的服务实例ID
     */
    @Nullable
    public String getPub() {
        return pub;
    }

    /**
     * 设置发布此命令的服务实例ID
     *
     * @param pub 发布此命令的服务实例ID
     */
    public void setPub(String pub) {
        this.pub = pub;
    }

    /**
     * 取指令所属的 AppID。未设置时，视为默认 AppId
     *
     * @return 指令所属的 AppID
     */
    @NonNull
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return "";
    }

    /**
     * 通过 JSON 字符串设置指令参数
     * @param paramsJson JSON 字符串参数
     */
    public void setParamsJson(String paramsJson) {
        if (paramsJson != null) {
            this.params = CmdParamsParser.fromJson(msgId, paramsJson);
        } else
            this.params = null;
    }

    /**
     * 通过 JSON 字符串设置应答数据
     * @param ackParamsJson JSON 字符串应答数据
     */
    public void setAckParamsJson(String ackParamsJson) {
        if (ackParamsJson != null) {
            this.ackParams = AckParamsParser.fromJsonBySrcMsgId(msgId, ackParamsJson);
        } else
            this.ackParams = null;
    }

    /**
     * 将 `id` 属性设置为随机 UUID 的 Base64 编码后的字符串
     */
    public void setRandomId() {
        this.id = CommonUtils.uuidBase64NoPadding();
    }

    /**
     * 从另一个 TermCmd 中复制数据
     *
     * @param source 源 TermCmd 对象
     */
    public void assignFrom(TermCmd source) {
        this.appId = source.appId;
        this.id = source.id;
        this.externalId = source.externalId;
        this.reqId = source.reqId;
        this.senderToken = source.senderToken;
        this.reqTm = source.reqTm;
        this.sentTm = source.sentTm;
        this.ackTm = source.ackTm;
        this.endTm = source.endTm;
        this.status = source.status;
        this.simNo = source.simNo;
        this.msgId = source.msgId;
        this.subCmdTyp = source.subCmdTyp;
        this.plateNo = source.plateNo;
        this.plateColor = source.plateColor;
        this.msgSn = source.msgSn;
        this.params = source.params != null ? source.params.clone() : null;
        this.ackMsgId = source.ackMsgId;
        this.ackSeqNo = source.ackSeqNo;
        this.ackCode = source.ackCode;
        this.ackParams = source.ackParams != null ? source.ackParams.clone() : null;
        this.timeout = source.timeout;
        this.pub = source.pub;
    }


    @Override
    public TermCmd clone() {
        TermCmd r = new TermCmd();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("appId=").append(appId);
        str.append(", id=").append(id);
        str.append(", externalId=").append(externalId);

        // ignore reqId, senderToken which treat as secret

        str.append(", simNo=").append(simNo);
        str.append(", msgId=").append(msgId);
        if (msgSn != null)
            str.append(", msgSn=").append(msgSn);
        if (params != null)
            str.append(", params=").append(params);
        str.append(", reqTm=").append(reqTm);
        str.append(", sentTm=").append(sentTm);
        if (ackTm != null)
            str.append(", ackTm=").append(ackTm);
        if (endTm != null)
            str.append(", endTm=").append(endTm);
        str.append(", status=").append(status);
        if (subCmdTyp != null)
            str.append(", subCmdTyp=").append(subCmdTyp);
        if (plateNo != null)
            str.append(", plateNo=").append(plateNo);
        if (plateColor != null)
            str.append(", plateColor=").append(plateColor);
        if (ackMsgId != null)
            str.append(", ackMsgId").append(ackMsgId);
        if (ackSeqNo != null)
            str.append(", ackSeqNo").append(ackSeqNo);
        if (ackCode != null)
            str.append(", ackCode=").append(ackCode);
        if (ackParams != null)
            str.append(", ackParams=").append(ackParams);
        if (timeout != null)
            str.append(", timeout=").append(timeout);
        if (pub != null)
            str.append(", pub=").append(pub);

        return str.toString();
    }
}
