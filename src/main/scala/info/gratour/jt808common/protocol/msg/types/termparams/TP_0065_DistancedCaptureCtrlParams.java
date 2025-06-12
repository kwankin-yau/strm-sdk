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
 * 距离抓拍控制参数(0x0065)
 */
public class TP_0065_DistancedCaptureCtrlParams {

    private boolean[] chanEnabledFlags;
    private boolean[] chanStoredFlags;
    private byte distanceUnit;
    private short distance;

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
     * 取某通道启用标志
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
     * 取某通道存储标志
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
     * 取距离单位
     * @return 距离单位
     */
    public byte getDistanceUnit() {
        return distanceUnit;
    }

    /**
     * 设置距离单位
     * @param distanceUnit 距离单位
     */
    public void setDistanceUnit(byte distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    /**
     * 取距离
     * @return 距离
     */
    public short getDistance() {
        return distance;
    }

    /**
     * 设置距离
     * @param distance 距离
     */
    public void setDistance(short distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "TP_0065_DistancedCaptureCtrlParams{" +
                "chanEnabledFlags=" + Arrays.toString(chanEnabledFlags) +
                ", chanStoredFlags=" + Arrays.toString(chanStoredFlags) +
                ", distanceUnit=" + distanceUnit +
                ", distance=" + distance +
                '}';
    }
}
