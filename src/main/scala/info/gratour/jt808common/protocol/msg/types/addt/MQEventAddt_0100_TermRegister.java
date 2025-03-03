/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

/**
 * 终端注册事件(0x0100)
 */
public class MQEventAddt_0100_TermRegister implements MQEventAddt {

    private int provinceId;
    private int cityId;
    private String factoryId;
    private String terminalModel;
    private String terminalId;
    private int plateColor;
    private String plateNo;

    /**
     * 获取省份 ID
     * @return 省份 ID
     */
    public int getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份 ID
     * @param provinceId 省份 ID
     */
    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取城市 ID
     * @return 城市 ID
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * 设置城市 ID
     * @param cityId 城市 ID
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
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
     * 获取终端型号
     * @return 终端型号
     */
    public String getTerminalModel() {
        return terminalModel;
    }

    /**
     * 设置终端型号
     * @param terminalModel 终端型号
     */
    public void setTerminalModel(String terminalModel) {
        this.terminalModel = terminalModel;
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
     * 获取车牌颜色
     * @return 车牌颜色
     */
    public int getPlateColor() {
        return plateColor;
    }

    /**
     * 设置车牌颜色
     * @param plateColor 车牌颜色
     */
    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 获取车牌号
     * @return 车牌号
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号
     * @param plateNo 车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0100_TermRegister{" +
                "provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", factoryId='" + factoryId + '\'' +
                ", terminalModel='" + terminalModel + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", plateColor=" + plateColor +
                ", plateNo='" + plateNo + '\'' +
                '}';
    }
}
