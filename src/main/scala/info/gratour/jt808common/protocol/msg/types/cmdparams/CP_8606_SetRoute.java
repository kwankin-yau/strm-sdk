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
import info.gratour.jt808common.protocol.msg.types.JT808RouteCorner;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置路线(0x8606)命令参数
 */
@JTMsgId(JT808MsgConsts.SET_ROUTE_8606)
@Expose
public class CP_8606_SetRoute implements JT808CmdParams {

    private int routeId;
    private short attrs;
    private String startTime;
    private String endTime;
    private JT808RouteCorner[] corners;

    /**
     * 获取路线ID
     * @return 路线ID
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * 设置路线ID
     * @param routeId 路线ID
     */
    public void setRouteId(int routeId) {
        this.routeId = routeId;
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
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取路线拐点列表
     * @return 路线拐点列表
     */
    public JT808RouteCorner[] getCorners() {
        return corners;
    }

    /**
     * 设置路线拐点列表
     * @param corners 路线拐点列表
     */
    public void setCorners(JT808RouteCorner[] corners) {
        this.corners = corners;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_8606_SetRoute source) {
        this.routeId = source.routeId;
        this.attrs = source.attrs;
        this.startTime = source.startTime;
        this.endTime = source.endTime;
        if (source.corners != null) {
            this.corners = new JT808RouteCorner[source.corners.length];
            for (int i = 0; i < this.corners.length; i++) {
                this.corners[i] = source.corners[i].clone();
            }
        } else
            this.corners = null;
    }

    @Override
    public CP_8606_SetRoute clone() {
        CP_8606_SetRoute r = new CP_8606_SetRoute();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "CP_8606_SetRoute{" +
                "routeId=" + routeId +
                ", attrs=" + attrs +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", corners=" + Arrays.toString(corners) +
                '}';
    }
}
