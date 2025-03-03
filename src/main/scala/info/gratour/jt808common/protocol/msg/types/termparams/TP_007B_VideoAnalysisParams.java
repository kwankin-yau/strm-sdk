/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 视频分析参数(0x007B)
 */
public class TP_007B_VideoAnalysisParams {

    /**
     * 车辆核载人数
     */
    private byte maxBoarding;
    private byte fatigueThreshold;

    /**
     * 取车辆核载人数
     * @return 车辆核载人数
     */
    public byte getMaxBoarding() {
        return maxBoarding;
    }

    /**
     * 设置车辆核载人数
     * @param maxBoarding 车辆核载人数
     */
    public void setMaxBoarding(byte maxBoarding) {
        this.maxBoarding = maxBoarding;
    }

    /**
     * 取疲劳阈值
     * @return 疲劳阈值
     */
    public byte getFatigueThreshold() {
        return fatigueThreshold;
    }

    /**
     * 设置疲劳阈值
     * @param fatigueThreshold 疲劳阈值
     */
    public void setFatigueThreshold(byte fatigueThreshold) {
        this.fatigueThreshold = fatigueThreshold;
    }

    @Override
    public String toString() {
        return "TP_007B_VideoAnalysisParams{" +
                "maxBoarding=" + maxBoarding +
                ", fatigueThreshold=" + fatigueThreshold +
                '}';
    }
}
