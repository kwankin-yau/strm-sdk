/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 事故点（行驶记录仪数据）
 */
@Expose
public class Vtdr_AccidentPoint implements Cloneable {

    private String endTime;
    private String licenseNo;
    private short spd;
    private byte status;
    private List<Vtdr_SpdAndStatus> spdAndStatus;

    /**
     * 取结束时间
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取车牌号
     * @return 车牌号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 设置车牌号
     * @param licenseNo 车牌号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * 取速度
     * @return 速度
     */
    public short getSpd() {
        return spd;
    }

    /**
     * 设置速度
     * @param spd 速度
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 取状态
     * @return 状态
     */
    public byte getStatus() {
        return status;
    }

    /**
     * 设置状态
     * @param status 状态
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * 取速度和状态
     * @return 速度和状态
     */
    public List<Vtdr_SpdAndStatus> getSpdAndStatus() {
        return spdAndStatus;
    }

    /**
     * 设置速度和状态
     * @param spdAndStatus 速度和状态
     */
    public void setSpdAndStatus(List<Vtdr_SpdAndStatus> spdAndStatus) {
        this.spdAndStatus = spdAndStatus;
    }

    /**
     * 添加速度和状态
     * @param spdAndStatus 速度和状态
     */
    public void addSpdAndStatus(Vtdr_SpdAndStatus spdAndStatus) {
        if (this.spdAndStatus == null)
            this.spdAndStatus = new ArrayList<>();

        this.spdAndStatus.add(spdAndStatus);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_AccidentPoint source) {
        this.endTime = source.endTime;
        this.licenseNo = source.licenseNo;
        this.spd = source.spd;
        this.status = source.status;
        if (source.spdAndStatus != null) {
            this.spdAndStatus = new ArrayList<>();
            for (Vtdr_SpdAndStatus s : source.spdAndStatus) {
                this.spdAndStatus.add(s.clone());
            }
        } else
            this.spdAndStatus = null;
    }

    @Override
    public Vtdr_AccidentPoint clone() {
        try {
            return (Vtdr_AccidentPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_AccidentPoint.class.getSimpleName() + "[", "]")
                .add("endTime='" + endTime + "'")
                .add("licenseNo='" + licenseNo + "'")
                .add("spd=" + spd)
                .add("status=" + status)
                .add("spdAndStatus=" + spdAndStatus)
                .toString();
    }
}
