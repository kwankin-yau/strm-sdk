/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 云台转动(0x9301)命令参数
 */
@JTMsgId(JT1078MsgConsts.PTZ_TURN_9301)
@Expose
public class CP_9301_PtzTurn implements JT808CmdParams {

    private byte chan;
    private byte ctrl;
    private byte spd;

    /**
     * 取通道号
     * @return 通道号
     */
    public byte getChan() {
        return chan;
    }

    /**
     * 设置通道号
     * @param chan 通道号
     */
    public void setChan(byte chan) {
        this.chan = chan;
    }

    /**
     * 取控制命令
     * @return 控制命令
     */
    public byte getCtrl() {
        return ctrl;
    }

    /**
     * 设置控制命令
     * @param ctrl 控制命令
     */
    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 取速度
     * @return 速度
     */
    public byte getSpd() {
        return spd;
    }

    /**
     * 设置速度
     * @param spd 速度
     */
    public void setSpd(byte spd) {
        this.spd = spd;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9301_PtzTurn.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("ctrl=" + ctrl)
                .add("spd=" + spd)
                .toString();
    }

    @Override
    public CP_9301_PtzTurn clone() {
        try {
            return (CP_9301_PtzTurn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
