/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 胎压监测参数
 */
public class TP_F366_TyrePressureMonitorParams {

    private String tyreModel;
    private short pressureUnit;
    private int normalPressureValue;
    private short imbalanceThreshold;
    private short airLeakSlowlyThreshold;
    private short lowPressureThreshold;
    private short highPressureThreshold;
    private short highTemperatureThreshold;
    private short voltageThreshold;
    private short reportInterval;

    /**
     * 取轮胎规格型号
     * @return 轮胎规格型号
     */
    public String getTyreModel() {
        return tyreModel;
    }

    /**
     * 设置轮胎规格型号
     * @param tyreModel 轮胎规格型号
     */
    public void setTyreModel(String tyreModel) {
        this.tyreModel = tyreModel;
    }

    /**
     * 取胎压单位
     * @return 胎压单位
     */
    public short getPressureUnit() {
        return pressureUnit;
    }

    /**
     * 设置胎压单位
     * @param pressureUnit 胎压单位
     */
    public void setPressureUnit(short pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    /**
     * 取正常胎压值
     * @return 正常胎压值
     */
    public int getNormalPressureValue() {
        return normalPressureValue;
    }

    /**
     * 设置正常胎压值
     * @param normalPressureValue 正常胎压值
     */
    public void setNormalPressureValue(int normalPressureValue) {
        this.normalPressureValue = normalPressureValue;
    }

    /**
     * 取轮胎不平衡报警阈值
     * @return 轮胎不平衡报警阈值
     */
    public short getImbalanceThreshold() {
        return imbalanceThreshold;
    }

    /**
     * 设置轮胎不平衡报警阈值
     * @param imbalanceThreshold 轮胎不平衡报警阈值
     */
    public void setImbalanceThreshold(short imbalanceThreshold) {
        this.imbalanceThreshold = imbalanceThreshold;
    }

    /**
     * 取轮胎慢漏气报警阈值
     * @return 轮胎慢漏气报警阈值
     */
    public short getAirLeakSlowlyThreshold() {
        return airLeakSlowlyThreshold;
    }

    /**
     * 设置轮胎慢漏气报警阈值
     * @param airLeakSlowlyThreshold 轮胎慢漏气报警阈值
     */
    public void setAirLeakSlowlyThreshold(short airLeakSlowlyThreshold) {
        this.airLeakSlowlyThreshold = airLeakSlowlyThreshold;
    }

    /**
     * 取胎压低报警阈值
     * @return 胎压低报警阈值
     */
    public short getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    /**
     * 设置胎压低报警阈值
     * @param lowPressureThreshold 胎压低报警阈值
     */
    public void setLowPressureThreshold(short lowPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
    }

    /**
     * 取胎压高报警阈值
     * @return 胎压高报警阈值
     */
    public short getHighPressureThreshold() {
        return highPressureThreshold;
    }

    /**
     * 设置胎压高报警阈值
     * @param highPressureThreshold 胎压高报警阈值
     */
    public void setHighPressureThreshold(short highPressureThreshold) {
        this.highPressureThreshold = highPressureThreshold;
    }

    /**
     * 取胎压高温报警阈值
     * @return 胎压高温报警阈值
     */
    public short getHighTemperatureThreshold() {
        return highTemperatureThreshold;
    }

    /**
     * 设置胎压高温报警阈值
     * @param highTemperatureThreshold 胎压高温报警阈值
     */
    public void setHighTemperatureThreshold(short highTemperatureThreshold) {
        this.highTemperatureThreshold = highTemperatureThreshold;
    }

    /**
     * 取电压报警阈值
     * @return 电压报警阈值
     */
    public short getVoltageThreshold() {
        return voltageThreshold;
    }

    /**
     * 设置电压报警阈值
     * @param voltageThreshold 电压报警阈值
     */
    public void setVoltageThreshold(short voltageThreshold) {
        this.voltageThreshold = voltageThreshold;
    }

    /**
     * 取胎压监测数据上报间隔
     * @return 胎压监测数据上报间隔
     */
    public short getReportInterval() {
        return reportInterval;
    }

    /**
     * 设置胎压监测数据上报间隔
     * @param reportInterval 胎压监测数据上报间隔
     */
    public void setReportInterval(short reportInterval) {
        this.reportInterval = reportInterval;
    }

    @Override
    public String toString() {
        return "TP_F366_TyrePressureMonitorParams{" +
                "tyreModel='" + tyreModel + '\'' +
                ", pressureUnit=" + pressureUnit +
                ", normalPressureValue=" + normalPressureValue +
                ", imbalanceThreshold=" + imbalanceThreshold +
                ", airLeakSlowlyThreshold=" + airLeakSlowlyThreshold +
                ", lowPressureThreshold=" + lowPressureThreshold +
                ", highPressureThreshold=" + highPressureThreshold +
                ", highTemperatureThreshold=" + highTemperatureThreshold +
                ", voltageThreshold=" + voltageThreshold +
                ", reportInterval=" + reportInterval +
                '}';
    }
}
