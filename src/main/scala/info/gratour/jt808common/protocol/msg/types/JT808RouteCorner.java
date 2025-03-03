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
 * JT/T 808 路线拐点
 */
@Expose
public class JT808RouteCorner implements Cloneable {

    private int cornerId;
    private int segmentId;
    private Coordinate coord;
    private byte width;
    private byte attrs;
    private int tmUpThold;
    private int tmLoThold;
    private short spdUpThold;
    private short overSpdTmThold;

    /**
     * 取拐点 ID
     * @return 拐点 ID
     */
    public int getCornerId() {
        return cornerId;
    }

    /**
     * 设置拐点 ID
     * @param cornerId 拐点 ID
     */
    public void setCornerId(int cornerId) {
        this.cornerId = cornerId;
    }

    /**
     * 取路段 ID
     * @return 路段 ID
     */
    public int getSegmentId() {
        return segmentId;
    }

    /**
     * 设置路段 ID
     * @param segmentId 路段 ID
     */
    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    /**
     * 取拐点坐标
     * @return 拐点坐标
     */
    public Coordinate getCoord() {
        return coord;
    }

    /**
     * 设置拐点坐标
     * @param coord 拐点坐标
     */
    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    /**
     * 取路段宽度
     * @return 路段宽度
     */
    public byte getWidth() {
        return width;
    }

    /**
     * 设置路段宽度
     * @param width 路段宽度
     */
    public void setWidth(byte width) {
        this.width = width;
    }

    /**
     * 取路段属性
     * @return 路段属性
     */
    public byte getAttrs() {
        return attrs;
    }

    /**
     * 设置路段属性
     * @param attrs 路段属性
     */
    public void setAttrs(byte attrs) {
        this.attrs = attrs;
    }

    /**
     * 取路段行驶时间过长阈值, second
     * @return 路段行驶时间过长阈值
     */
    public int getTmUpThold() {
        return tmUpThold;
    }

    /**
     * 设置路段行驶时间过长阈值
     * @param tmUpThold 路段行驶时间过长阈值
     */
    public void setTmUpThold(int tmUpThold) {
        this.tmUpThold = tmUpThold;
    }

    /**
     * 取路段行驶时间过短阈值, second
     * @return 路段行驶时间过短阈值
     */ 
    public int getTmLoThold() {
        return tmLoThold;
    }

    /**
     * 设置路段行驶时间过短阈值
     * @param tmLoThold 路段行驶时间过短阈值
     */
    public void setTmLoThold(int tmLoThold) {
        this.tmLoThold = tmLoThold;
    }

    /**
     * 取路段最高速度, km/h
     * @return 路段最高速度
     */
    public short getSpdUpThold() {
        return spdUpThold;
    }

    /**
     * 设置路段最高速度
     * @param spdUpThold 路段最高速度
     */
    public void setSpdUpThold(short spdUpThold) {
        this.spdUpThold = spdUpThold;
    }

    /**
     * 取路段超速持续时间阈值, second
     * @return 路段超速持续时间阈值
     */
    public short getOverSpdTmThold() {
        return overSpdTmThold;
    }

    /**
     * 设置路段超速持续时间阈值
     * @param overSpdTmThold 路段超速持续时间阈值
     */
    public void setOverSpdTmThold(short overSpdTmThold) {
        this.overSpdTmThold = overSpdTmThold;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808RouteCorner source) {
        this.cornerId = source.cornerId;
        this.segmentId = source.segmentId;
        this.coord = source.coord != null ? source.coord.clone() : null;
        this.width = source.width;
        this.attrs = source.attrs;
        this.tmUpThold = source.tmUpThold;
        this.tmLoThold = source.tmLoThold;
        this.spdUpThold = source.spdUpThold;
        this.overSpdTmThold = source.overSpdTmThold;
    }

    @Override
    public JT808RouteCorner clone() {
        try {
            return (JT808RouteCorner) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808RouteCorner{" +
                "cornerId=" + cornerId +
                ", segmentId=" + segmentId +
                ", coord=" + coord +
                ", width=" + width +
                ", attrs=" + attrs +
                ", tmUpThold=" + tmUpThold +
                ", tmLoThold=" + tmLoThold +
                ", spdUpThold=" + spdUpThold +
                ", overSpdTmThold=" + overSpdTmThold +
                '}';
    }
}
