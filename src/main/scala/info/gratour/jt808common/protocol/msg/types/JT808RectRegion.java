/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import com.lucendar.strm.common.types.Expose;

/**
 * JT/T 808 矩形区域
 */
@Expose
public class JT808RectRegion implements Cloneable {

    private int regionId;
    private short attrs;
    private Coordinate minXMinY;
    private Coordinate maxXMaxY;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;

    /**
     * 取区域 ID
     * @return 区域 ID
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * 设置区域 ID
     * @param regionId 区域 ID
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * 取区域属性
     * @return 区域属性
     */
    public short getAttrs() {
        return attrs;
    }

    /**
     * 设置区域属性
     * @param attrs 区域属性
     */
    public void setAttrs(short attrs) {
        this.attrs = attrs;
    }

    /**
     * 取矩形的最小 X 坐标和最小 Y 坐标
     * @return 最小 X 坐标和最小 Y 坐标
     */
    public Coordinate getMinXMinY() {
        return minXMinY;
    }

    /**
     * 设置矩形的最小 X 坐标和最小 Y 坐标
     * @param minXMinY 最小 X 坐标和最小 Y 坐标
     */
    public void setMinXMinY(Coordinate minXMinY) {
        this.minXMinY = minXMinY;
    }

    /**
     * 取矩形的最大 X 坐标和最大 Y 坐标
     * @return 最大 X 坐标和最大 Y 坐标
     */
    public Coordinate getMaxXMaxY() {
        return maxXMaxY;
    }

    /**
     * 设置矩形的最大 X 坐标和最大 Y 坐标
     * @param maxXMaxY 最大 X 坐标和最大 Y 坐标
     */
    public void setMaxXMaxY(Coordinate maxXMaxY) {
        this.maxXMaxY = maxXMaxY;
    }

    /**
     * 取矩形的开始时间
     * @return 开始时间
     */
    public String getStartTm() {
        return startTm;
    }

    /**
     * 设置矩形的开始时间
     * @param startTm 开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 取矩形的结束时间
     * @return 结束时间
     */
    public String getEndTm() {
        return endTm;
    }

    /**
     * 设置矩形的结束时间
     * @param endTm 结束时间
     */
    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    /**
     * 取矩形区域最高速度
     * @return 最高速度
     */
    public Short getSpdUpperLimit() {
        return spdUpperLimit;
    }

    /**
     * 设置矩形区域最高速度
     * @param spdUpperLimit 最高速度
     */
    public void setSpdUpperLimit(Short spdUpperLimit) {
        this.spdUpperLimit = spdUpperLimit;
    }

    /**
     * 取矩形区域超速持续时间
     * @return 超速持续时间
     */
    public Byte getTimeThreshold() {
        return timeThreshold;
    }

    /**
     * 设置矩形区域超速持续时间
     * @param timeThreshold 超速持续时间
     */
    public void setTimeThreshold(Byte timeThreshold) {
        this.timeThreshold = timeThreshold;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808RectRegion source) {
        this.regionId = source.regionId;
        this.attrs = source.attrs;
        this.minXMinY = source.minXMinY != null ? source.minXMinY.clone() : null;
        this.maxXMaxY = source.maxXMaxY != null ? source.maxXMaxY.clone() : null;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.spdUpperLimit = source.spdUpperLimit;
        this.timeThreshold = source.timeThreshold;
    }

    @Override
    public JT808RectRegion clone() {
        try {
            return (JT808RectRegion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808RectRegion{" +
                "regionId=" + regionId +
                ", attrs=" + attrs +
                ", minXMinY=" + minXMinY +
                ", maxXMaxY=" + maxXMaxY +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                '}';
    }
}
