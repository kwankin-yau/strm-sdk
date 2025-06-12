/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.Arrays;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.Coordinate;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置多边形区域(0x8604)命令参数
 */
@JTMsgId(JT808MsgConsts.SET_POLYGON_REGION_8604)
@Expose
public class CP_8604_SetPolygonRegion implements JT808CmdParams {

    private int regionId;
    private short attrs;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;
    private Coordinate[] vectors;

    /**
     * 获取区域ID
     * @return 区域ID
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * 设置区域ID
     * @param regionId 区域ID
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取属性
     * @return 属性
     */
    public short getAttrs() {
        return attrs;
    }

    /**
     * 设置属性
     * @param attrs 属性
     */
    public void setAttrs(short attrs) {
        this.attrs = attrs;
    }

    /**
     * 获取开始时间
     * @return 开始时间
     */
    public String getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间
     * @param startTm 开始时间
     */
    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    /**
     * 获取结束时间
     * @return 结束时间
     */
    public String getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间
     * @param endTm 结束时间
     */
    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    /**
     * 获取速度上限
     * @return 速度上限
     */
    public Short getSpdUpperLimit() {
        return spdUpperLimit;
    }

    /**
     * 设置速度上限
     * @param spdUpperLimit 速度上限
     */
    public void setSpdUpperLimit(Short spdUpperLimit) {
        this.spdUpperLimit = spdUpperLimit;
    }

    /**
     * 获取时间阈值
     * @return 时间阈值
     */
    public Byte getTimeThreshold() {
        return timeThreshold;
    }

    /**
     * 设置时间阈值
     * @param timeThreshold 时间阈值
     */
    public void setTimeThreshold(Byte timeThreshold) {
        this.timeThreshold = timeThreshold;
    }

    /**
     * 获取坐标点列表
     * @return 坐标点列表
     */
    public Coordinate[] getVectors() {
        return vectors;
    }

    /**
     * 设置坐标点列表
     * @param vectors 坐标点列表
     */
    public void setVectors(Coordinate[] vectors) {
        this.vectors = vectors;
    }

    @Override
    public String toString() {
        return "CP_8604_SetPolygonRegion{" +
                "regionId=" + regionId +
                ", attrs=" + attrs +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                ", vectors=" + Arrays.toString(vectors) +
                '}';
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_8604_SetPolygonRegion source) {
        this.regionId = source.regionId;
        this.attrs = source.attrs;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.spdUpperLimit = source.spdUpperLimit;
        this.timeThreshold = source.timeThreshold;
        if (source.vectors != null) {
            this.vectors = new Coordinate[source.vectors.length];
            for (int i = 0; i < this.vectors.length; i++) {
                this.vectors[i] = source.vectors[i].clone();
            }
        } else
            this.vectors = null;
    }


    @Override
    public CP_8604_SetPolygonRegion clone() {
        CP_8604_SetPolygonRegion r = new CP_8604_SetPolygonRegion();
        r.assignFrom(this);
        return r;
    }
}
