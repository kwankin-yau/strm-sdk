/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 超速行驶记录
 */ 
@Expose
public class Vtdr_DriveOverTimeEntry implements Cloneable {

    private String licenseNo;
    private String startTime;
    private String endTime;
    private Vtdr_Location startLocation;
    private Vtdr_Location endLocation;

    /**
     * 取驾驶证号
     * @return 驾驶证号
     */
    public String getLicenseNo() {    
        return licenseNo;
    }

    /**
     * 设置驾驶证号
     * @param licenseNo 驾驶证号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * 取连续驾驶开始时间, yyyy-MM-dd HH:mm:ss
     * @return 连续驾驶开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置连续驾驶开始时间
     * @param startTime 连续驾驶开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取连续驾驶结束时间, yyyy-MM-dd HH:mm:ss
     * @return 连续驾驶结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置连续驾驶结束时间
     * @param endTime 连续驾驶结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取连续驾驶开始位置   
     * @return 连续驾驶开始位置
     */
    public Vtdr_Location getStartLocation() {
        return startLocation;
    }

    /**
     * 设置连续驾驶开始位置
     * @param startLocation 连续驾驶开始位置
     */
    public void setStartLocation(Vtdr_Location startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * 取连续驾驶结束位置
     * @return 连续驾驶结束位置
     */
    public Vtdr_Location getEndLocation() {
        return endLocation;
    }

    /**
     * 设置连续驾驶结束位置
     * @param endLocation 连续驾驶结束位置
     */
    public void setEndLocation(Vtdr_Location endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_DriveOverTimeEntry source) {
        this.licenseNo = source.licenseNo;
        this.startTime = source.startTime;
        this.endTime = source.endTime;
        this.startLocation = source.startLocation != null ? source.startLocation.clone() : null;
        this.endLocation = source.endLocation != null ? source.endLocation.clone() : null;
    }

    @Override
    public Vtdr_DriveOverTimeEntry clone() {
        Vtdr_DriveOverTimeEntry r = new Vtdr_DriveOverTimeEntry();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_DriveOverTimeEntry.class.getSimpleName() + "[", "]")
                .add("licenseNo='" + licenseNo + "'")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("startLocation=" + startLocation)
                .add("endLocation=" + endLocation)
                .toString();
    }
}
