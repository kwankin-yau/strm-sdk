/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.StringJoiner;

/**
 * CAN ID设置(0x0110)
 */
public class TP_0110_CanIdSettings {

    private int canId;
    private boolean calculated; // bit29
    private boolean extFrame; // bit30
    private boolean can2; // bit31
    private int samplingInterval;

    /**
     * 取CAN ID
     * @return CAN ID
     */
    public int getCanId() {
        return canId;
    }

    /**
     * 设置CAN ID
     * @param canId CAN ID
     */
    public void setCanId(int canId) {
        this.canId = canId;
    }

    /**
     * 取是否采集区间的计算值，false 时表原始数据
     * @return 是否计算值
     */
    public boolean isCalculated() {
        return calculated;
    }

    /**
     * 设置是否采集区间的计算值，false 时表原始数据
     * @param calculated 是否计算值
     */
    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    /**
     * 取是否扩展帧, false 为标准帧, true 为扩展帧
     * @return 是否扩展帧
     */
    public boolean isExtFrame() {
        return extFrame;
    }

    /**
     * 设置是否扩展帧, false 为标准帧, true 为扩展帧
     * @param extFrame 是否扩展帧
     */
    public void setExtFrame(boolean extFrame) {
        this.extFrame = extFrame;
    }

    /**
     * 取是否CAN2, false 为CAN1, true 为CAN2
     * @return 是否CAN2
     */
    public boolean isCan2() {
        return can2;
    }

    /**
     * 设置是否CAN2, false 为CAN1, true 为CAN2
     * @param can2 是否CAN2
     */
    public void setCan2(boolean can2) {
        this.can2 = can2;
    }

    /**
     * 取采样间隔, milli-second
     * @return 采样间隔
     */
    public int getSamplingInterval() {
        return samplingInterval;
    }

    /**
     * 设置采样间隔
     * @param samplingInterval 采样间隔
     */
    public void setSamplingInterval(int samplingInterval) {
        this.samplingInterval = samplingInterval;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TP_0110_CanIdSettings.class.getSimpleName() + "[", "]")
                .add("canId=" + canId)
                .add("calculated=" + calculated)
                .add("extFrame=" + extFrame)
                .add("can2=" + can2)
                .add("samplingInterval=" + samplingInterval)
                .toString();
    }
}
