package com.lucendar.gnss.sdk.db;

import java.time.OffsetDateTime;

import com.lucendar.common.utils.DateTimeUtils;

import info.gratour.jt808common.protocol.msg.types.TermCmdParamsParser;
import info.gratour.jt808common.spi.model.TermCmd;

/**
 * 用于存储 TermCmd 到数据库的中间对象
 */
public class TermCmdRec extends TermCmd {

    private OffsetDateTime stgReqTm;
    private OffsetDateTime stgSendTm;
    private OffsetDateTime stgAckTm;
    private OffsetDateTime stgEndTm;
    private String stgParams;
    private String stgAckParams;

    /**
     * 获取数据库中存储的请求时间
     * @return 请求时间
     */
    public OffsetDateTime getStgReqTm() {
        return stgReqTm;
    }

    /**
     * 设置数据库中存储的请求时间
     * @param stgReqTm 请求时间
     */
    public void setStgReqTm(OffsetDateTime stgReqTm) {
        this.stgReqTm = stgReqTm;
    }

    /**
     * 获取数据库中存储的发送时间
     * @return 发送时间
     */
    public OffsetDateTime getStgSendTm() {
        return stgSendTm;
    }

    /**
     * 设置数据库中存储的发送时间
     * @param stgSendTm 发送时间
     */ 
    public void setStgSendTm(OffsetDateTime stgSendTm) {
        this.stgSendTm = stgSendTm;
    }

    /**
     * 获取数据库中存储的应答时间
     * @return 应答时间
     */
    public OffsetDateTime getStgAckTm() {
        return stgAckTm;
    }

    /**
     * 设置数据库中存储的应答时间
     * @param stgAckTm 应答时间
     */
    public void setStgAckTm(OffsetDateTime stgAckTm) {
        this.stgAckTm = stgAckTm;
    }

    /**
     * 获取数据库中存储的结束时间
     * @return 结束时间
     */
    public OffsetDateTime getStgEndTm() {
        return stgEndTm;
    }

    /**
     * 设置数据库中存储的结束时间
     * @param stgEndTm 结束时间
     */
    public void setStgEndTm(OffsetDateTime stgEndTm) {
        this.stgEndTm = stgEndTm;
    }

    /**
     * 获取数据库中存储的参数
     * @return 参数
     */
    public String getStgParams() {
        return stgParams;
    }

    /**
     * 设置数据库中存储的参数
     * @param stgParams 参数
     */
    public void setStgParams(String stgParams) {
        this.stgParams = stgParams;
    }

    /**
     * 获取数据库中存储的应答参数
     * @return 应答参数
     */
    public String getStgAckParams() {
        return stgAckParams;
    }

    /**
     * 设置数据库中存储的应答参数
     * @param stgAckParams 应答参数
     */
    public void setStgAckParams(String stgAckParams) {
        this.stgAckParams = stgAckParams;
    }

    /**
     * 从 TermCmd 对象中复制数据
     * @param termCmd TermCmd 对象
     */
    public void fromTermCmd(TermCmd termCmd) {
        this.assignFrom(termCmd);

        stgReqTm = DateTimeUtils.BeijingConv.millisToOdt(getReqTm());
        stgSendTm = DateTimeUtils.BeijingConv.millisToOdtBoxed(getSentTm());
        stgAckTm = DateTimeUtils.BeijingConv.millisToOdtBoxed(getAckTm());
        stgEndTm = DateTimeUtils.BeijingConv.millisToOdtBoxed(getEndTm());
        stgParams = paramsJson();
        stgAckParams = ackParamsJson();
    }

    /**
     * 将 TermCmdRec 对象转换为 TermCmd 对象
     * @param parser TermCmdParamsParser 对象
     * @return TermCmd 对象
     */
    public TermCmd toTermCmd(TermCmdParamsParser parser) {
        setReqTm(stgReqTm.toInstant().toEpochMilli());
        if (stgSendTm != null)
            setSentTm(stgSendTm.toInstant().toEpochMilli());
        else
            setSentTm((Long) null);
        if (stgAckTm != null)
            setAckTm(stgAckTm.toInstant().toEpochMilli());
        else
            setAckTm((Long) null);
        if (stgEndTm != null)
            setEndTm(stgEndTm.toInstant().toEpochMilli());
        else
            setEndTm((Long) null);

        if (stgParams != null) {
            setParams(parser.cmdParamsFromJson(getMsgId(), stgParams));
        } else
            setParams(null);

        if (stgAckParams != null)
            setAckParams(parser.ackParamsFromJson(getMsgId(), stgAckParams));
        else
            setAckParams(null);

        TermCmd r = new TermCmd();
        r.assignFrom(this);
        return r;
    }
}
