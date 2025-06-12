/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import info.gratour.jtcommon.JTMsgId;

/**
 * 车辆控制应答参数(0x0500)
 */
@JTMsgId(JT808MsgConsts.VEH_CTRL_ACK_0500)
@Expose
public class JT808AckParams_0500_VehCtrlAck implements JT808AckParams, Cloneable {

    private Trk trk;

    /**
     * 获取轨迹
     * @return 轨迹
     */
    public Trk getTrk() {
        return trk;
    }

    /**
     * 设置轨迹
     * @param trk 轨迹
     */
    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0500_VehCtrlAck{" +
                "trk=" + trk +
                '}';
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808AckParams_0500_VehCtrlAck source) {
        this.trk = source.trk != null ? source.trk.clone() : null;
    }

    @Override
    public JT808AckParams_0500_VehCtrlAck clone() {
        JT808AckParams_0500_VehCtrlAck r = new JT808AckParams_0500_VehCtrlAck();
        r.assignFrom(this);
        return r;
    }
}
