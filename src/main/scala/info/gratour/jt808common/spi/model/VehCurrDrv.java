/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

/**
 * 车辆当前驾驶员信息
 */
public class VehCurrDrv implements IPlateNoAndColor {

    private String plateNo;
    private int plateColor;
    private String drvName;
    private String drvNo;
    private String licenseNo;
    private String issuer;
    private String expireDate;

    @Override
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号
     * 
     * @param plateNo 车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public int getPlateColor() {
        return plateColor;
    }

    /**
     * 设置车牌颜色
     * 
     * @param plateColor 车牌颜色
     */
    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 取驾驶员姓名
     * 
     * @return 驾驶员姓名
     */
    public String getDrvName() {
        return drvName;
    }

    /**
     * 设置驾驶员姓名
     * 
     * @param drvName 驾驶员姓名
     */
    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    /**
     * 取驾驶证号
     * 
     * @return 驾驶证号
     */
    public String getDrvNo() {
        return drvNo;
    }

    /**
     * 设置驾驶证号
     * 
     * @param drvNo 驾驶证号
     */
    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    /**
     * 取从业资格证号
     * 
     * @return 从业资格证号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 设置从业资格证号
     * 
     * @param licenseNo 从业资格证号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * 取发证机关
     * 
     * @return 发证机关
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * 设置发证机关
     * 
     * @param issuer 发证机关
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * 取从业资格证有效期
     * 
     * @return 从业资格证有效期
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * 设置从业资格证有效期
     * 
     * @param expireDate 从业资格证有效期
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "VehCurrDrv{" +
                "plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", issuer='" + issuer + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }
}
