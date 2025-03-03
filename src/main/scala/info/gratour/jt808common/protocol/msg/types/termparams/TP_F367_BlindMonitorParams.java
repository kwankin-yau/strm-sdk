/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 盲区监测参数
 */
public class TP_F367_BlindMonitorParams {
    private byte rearDistanceAlarmTimeThreshold;
    private byte sideDistanceAlarmTimeThreshold;

    /**
     * 取后车距离报警时间阈值
     * @return 后车距离报警时间阈值
     */
    public byte getRearDistanceAlarmTimeThreshold() {
        return rearDistanceAlarmTimeThreshold;
    }

    /**
     * 设置后车距离报警时间阈值
     * @param rearDistanceAlarmTimeThreshold 后车距离报警时间阈值
     */
    public void setRearDistanceAlarmTimeThreshold(byte rearDistanceAlarmTimeThreshold) {
        this.rearDistanceAlarmTimeThreshold = rearDistanceAlarmTimeThreshold;
    }

    /**
     * 取侧后车距离报警时间阈值
     * @return 侧后车距离报警时间阈值
     */
    public byte getSideDistanceAlarmTimeThreshold() {
        return sideDistanceAlarmTimeThreshold;
    }

    /**
     * 设置侧后车距离报警时间阈值
     * @param sideDistanceAlarmTimeThreshold 侧后车距离报警时间阈值
     */
    public void setSideDistanceAlarmTimeThreshold(byte sideDistanceAlarmTimeThreshold) {
        this.sideDistanceAlarmTimeThreshold = sideDistanceAlarmTimeThreshold;
    }

    @Override
    public String toString() {
        return "TP_F367_BlindMonitorParams{" +
                "rearDistanceAlarmTimeThreshold=" + rearDistanceAlarmTimeThreshold +
                ", sideDistanceAlarmTimeThreshold=" + sideDistanceAlarmTimeThreshold +
                '}';
    }
}
