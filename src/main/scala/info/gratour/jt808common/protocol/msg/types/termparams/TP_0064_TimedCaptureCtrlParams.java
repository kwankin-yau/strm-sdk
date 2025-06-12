/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.Arrays;

/**
 * 定时抓拍控制参数(0x0064)
 */
public class TP_0064_TimedCaptureCtrlParams {

    private boolean[] chanEnabledFlags;
    private boolean[] chanStoredFlags;
    private byte timeUnit;
    private short interval;

    /**
     * 取通道启用标志
     * @return 通道启用标志
     */
    public boolean[] getChanEnabledFlags() {
        return chanEnabledFlags;
    }

    /**
     * 设置通道启用标志
     * @param chanEnabledFlags 通道启用标志
     */
    public void setChanEnabledFlags(boolean[] chanEnabledFlags) {
        this.chanEnabledFlags = chanEnabledFlags;
    }

    /**
     * 取通道存储标志
     * @return 通道存储标志
     */
    public boolean[] getChanStoredFlags() {
        return chanStoredFlags;
    }

    /**
     * 设置通道存储标志
     * @param chanStoredFlags 通道存储标志
     */
    public void setChanStoredFlags(boolean[] chanStoredFlags) {
        this.chanStoredFlags = chanStoredFlags;
    }

    /**
     * 取通道启用标志
     * @param chanId 通道ID
     * @return 通道启用标志
     */
    public boolean chanEnabled(int chanId) {
        if (chanId >= 1 && chanId <= 5) {
            int index = chanId - 1;
            if (index >= 0 && index < chanEnabledFlags.length)
                return chanEnabledFlags[index];
            else
                return false;
        } else
            return false;
    }

    /**
     * 取通道存储标志
     * @param chanId 通道ID
     * @return 通道存储标志
     */
    public boolean chanStored(int chanId) {
        if (chanId >= 1 && chanId <= 5) {
            int index = chanId - 1;
            if (index >= 0 && index < chanStoredFlags.length)
                return chanStoredFlags[index];
            else
                return false;
        } else
            return false;
    }

    /**
     * 取时间单位
     * @return 时间单位
     */
    public byte getTimeUnit() {
        return timeUnit;
    }

    /**
     * 设置时间单位
     * @param timeUnit 时间单位
     */
    public void setTimeUnit(byte timeUnit) {
        this.timeUnit = timeUnit;
    }

    /**
     * 取时间间隔
     * @return 时间间隔
     */
    public short getInterval() {
        return interval;
    }

    /**
     * 设置时间间隔
     * @param interval 时间间隔
     */
    public void setInterval(short interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "TP_0064_TimedCaptureCtrlParams{" +
                "chanEnabledFlags=" + Arrays.toString(chanEnabledFlags) +
                ", chanStoredFlags=" + Arrays.toString(chanStoredFlags) +
                ", timeUnit=" + timeUnit +
                ", interval=" + interval +
                '}';
    }
}
