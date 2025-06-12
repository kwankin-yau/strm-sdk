/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 位置跟踪控制(0x8202)命令参数
 */
@JTMsgId(JT808MsgConsts.LOCATION_TRACE_CTRL_8202)
@Expose
public class CP_8202_LocationTraceCtrl implements JT808CmdParams {

    private int interval;
    private Integer duration;

    /**
     * 获取位置跟踪间隔，单位：秒
     * @return 位置跟踪间隔
     */
    public int getInterval() {
        return interval;
    }

    /**
     * 设置位置跟踪间隔，单位：秒
     * @param interval 位置跟踪间隔
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * 获取位置跟踪时长，单位：秒
     * @return 位置跟踪时长
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置位置跟踪时长，单位：秒
     * @param duration 位置跟踪时长
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CP_8202_LocationTraceCtrl{" +
                "interval=" + interval +
                ", duration=" + duration +
                '}';
    }

    @Override
    public CP_8202_LocationTraceCtrl clone() {
        try {
            return (CP_8202_LocationTraceCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
