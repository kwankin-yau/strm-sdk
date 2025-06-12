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
 * JT/T 808 圆形区域
 */
@Expose
public class JT808CircleRegion implements Cloneable {

    private int regionId;
    private short attrs;
    private Coordinate center;
    private int radius;
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
     * 取中心点
     * @return 中心点
     */
    public Coordinate getCenter() {
        return center;
    }

    /**
     * 设置中心点
     * @param center 中心点
     */
    public void setCenter(Coordinate center) {
        this.center = center;
    }

    /**
     * 取半径, meter
     * @return 半径
     */
    public int getRadius() {
        return radius;
    }

    /**
     * 设置半径, meter
     * @param radius 半径
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * 取开始时间, yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间, yyyy-MM-dd HH:mm:ss
     * @param startTm 开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 取结束时间, yyyy-MM-dd HH:mm:ss
     * @return 结束时间
     */
    public String getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间, yyyy-MM-dd HH:mm:ss
     * @param endTm 结束时间
     */
    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    /**
     * 取最高速度, km/h
     * @return 最高速度
     */
    public Short getSpdUpperLimit() {
        return spdUpperLimit;
    }

    /**
     * 设置最高速度, km/h
     * @param spdUpperLimit 最高速度
     */
    public void setSpdUpperLimit(Short spdUpperLimit) {
        this.spdUpperLimit = spdUpperLimit;
    }

    /**
     * 取超速持续时间, 秒
     * @return 超速持续时间
     */
    public Byte getTimeThreshold() {
        return timeThreshold;
    }

    /**
     * 设置超速持续时间, 秒
     * @param timeThreshold 超速持续时间
     */
    public void setTimeThreshold(Byte timeThreshold) {
        this.timeThreshold = timeThreshold;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808CircleRegion source) {
        this.regionId = source.regionId;
        this.attrs = source.attrs;
        this.center = source.center != null ? source.center.clone() : null;
        this.radius = source.radius;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.spdUpperLimit = source.spdUpperLimit;
        this.timeThreshold = source.timeThreshold;
    }

    @Override
    public JT808CircleRegion clone() {
        JT808CircleRegion r = new JT808CircleRegion();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808CircleRegion{" +
                "regionId=" + regionId +
                ", attrs=" + attrs +
                ", center=" + center +
                ", radius=" + radius +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                '}';
    }
}
