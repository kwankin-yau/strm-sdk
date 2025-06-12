/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jtcommon.JTMsgId;

/**
 * 驾驶员身份信息上报事件(0x0702)
 */
@JTMsgId(JT808MsgConsts.DRIVER_IDENTITY_0702)
@Expose
public class MQEventAddt_0702_DriverIdentity implements MQEventAddt, JT808AckParams {

    /**
     * 从业资格证IC卡插入
     */
    public static final short ACT__LOGIN = 1;

    /**
     * 从业资格证IC卡拔出
     */
    public static final short ACT__LOGOUT = 2;

    /**
     * 读取状态：读取成功
     */
    public static final short READ_STATE__OK = 0;

    private short state;
    private long time;
    private Short readState;
    private String driverName;
    private String licenseNo;
    private String issuer;
    private String expireDate;
    private String idCardNum;

    /**
     * 获取状态
     * @return 状态
     */
    public short getState() {
        return state;
    }

    /**
     * 设置状态
     * @param state 状态
     */
    public void setState(short state) {
        this.state = state;
    }

    /**
     * 获取时间
     * @return 时间
     */
    public long getTime() {
        return time;
    }

    /**
     * 设置时间
     * @param time 时间
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * 获取读取状态
     * @return 读取状态
     */
    public Short getReadState() {
        return readState;
    }

    /**
     * 设置读取状态
     * @param readState 读取状态
     */
    public void setReadState(Short readState) {
        this.readState = readState;
    }

    /**
     * 获取驾驶员姓名
     * @return 驾驶员姓名
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * 设置驾驶员姓名
     * @param driverName 驾驶员姓名
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * 获取从业资格证号
     * @return 从业资格证号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 设置从业资格证号
     * @param licenseNo 从业资格证号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * 获取发证机关
     * @return 发证机关
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * 设置发证机关
     * @param issuer 发证机关
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * 获取从业资格证有效期
     * @return 从业资格证有效期,格式：YYYYMMDD
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * 设置从业资格证有效期
     * @param expireDate 从业资格证有效期,格式：YYYYMMDD
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * 获取驾驶员身份证号
     * @return 驾驶员身份证号
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    /**
     * 设置驾驶员身份证号
     * @param idCardNum 驾驶员身份证号
     */
    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0702_DriverIdentity{" +
                "state=" + state +
                ", time=" + time +
                ", readState=" + readState +
                ", driverName='" + driverName + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", issuer='" + issuer + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", idCardNum='" + idCardNum + '\'' +
                '}';
    }

    @Override
    public MQEventAddt_0702_DriverIdentity clone() {
        try {
            return (MQEventAddt_0702_DriverIdentity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
