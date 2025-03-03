/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询终端属性应答参数(0x0107)
 */
@JTMsgId(JT808MsgConsts.QRY_TERMINAL_ATTRS_ACK_0107)
@Expose
public class JT808AckParams_0107_QryAttrsAck implements JT808AckParams, Cloneable {

    private short terminalType;
    private String factoryId;
    private String model;
    private String terminalId;
    private String iccid;
    private String hardwareVer;
    private String firmwareVer;
    private byte gnssModuleAttrs;
    private byte commModuleAttrs;

    /**
     * 获取终端类型
     * @return 终端类型
     */
    public short getTerminalType() {
        return terminalType;
    }

    /**
     * 设置终端类型
     * @param terminalType 终端类型
     */
    public void setTerminalType(short terminalType) {
        this.terminalType = terminalType;
    }

    /**
     * 获取厂家 ID
     * @return 厂家 ID
     */
    public String getFactoryId() {
        return factoryId;
    }

    /**
     * 设置厂家 ID
     * @param factoryId 厂家 ID
     */
    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    /**
     * 获取型号
     * @return 型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置型号
     * @param model 型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取终端 ID
     * @return 终端 ID
     */
    public String getTerminalId() {
        return terminalId;
    }

    /**
     * 设置终端 ID
     * @param terminalId 终端 ID
     */
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * 获取 ICCID
     * @return ICCID
     */
    public String getIccid() {
        return iccid;
    }

    /**
     * 设置 ICCID
     * @param iccid ICCID
     */
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    /**
     * 获取硬件版本
     * @return 硬件版本
     */
    public String getHardwareVer() {
        return hardwareVer;
    }

    /**
     * 设置硬件版本
     * @param hardwareVer 硬件版本
     */
    public void setHardwareVer(String hardwareVer) {
        this.hardwareVer = hardwareVer;
    }

    /**
     * 获取固件版本
     * @return 固件版本
     */
    public String getFirmwareVer() {
        return firmwareVer;
    }

    /**
     * 设置固件版本
     * @param firmwareVer 固件版本
     */
    public void setFirmwareVer(String firmwareVer) {
        this.firmwareVer = firmwareVer;
    }

    /**
     * 获取 GNSS 模块属性
     * @return GNSS 模块属性
     */
    public byte getGnssModuleAttrs() {
        return gnssModuleAttrs;
    }

    /**
     * 设置 GNSS 模块属性
     * @param gnssModuleAttrs GNSS 模块属性
     */
    public void setGnssModuleAttrs(byte gnssModuleAttrs) {
        this.gnssModuleAttrs = gnssModuleAttrs;
    }

    /**
     * 获取通信模块属性
     * @return 通信模块属性
     */
    public byte getCommModuleAttrs() {
        return commModuleAttrs;
    }

    /**
     * 设置通信模块属性
     * @param commModuleAttrs 通信模块属性
     */
    public void setCommModuleAttrs(byte commModuleAttrs) {
        this.commModuleAttrs = commModuleAttrs;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0107_QryAttrsAck{" +
                "terminalType=" + terminalType +
                ", factoryId='" + factoryId + '\'' +
                ", model='" + model + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", iccid='" + iccid + '\'' +
                ", hardwareVer='" + hardwareVer + '\'' +
                ", firmwareVer='" + firmwareVer + '\'' +
                ", gnssModuleAttrs=" + gnssModuleAttrs +
                ", commModuleAttrs=" + commModuleAttrs +
                '}';
    }

    @Override
    public JT808AckParams_0107_QryAttrsAck clone() {
        try {
            return (JT808AckParams_0107_QryAttrsAck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
