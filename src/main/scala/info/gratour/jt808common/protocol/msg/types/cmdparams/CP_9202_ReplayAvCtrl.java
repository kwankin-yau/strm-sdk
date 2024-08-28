/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

/**
 * 远程录像回放控制参数
 */
@JTMsgId(JT1078MsgConsts.REPLAY_AV_CTRL_9202)
public class CP_9202_ReplayAvCtrl implements JT808CmdParams {

    public static final int CTRL__RESUME = 0;
    public static final int CTRL__PAUSE = 1;
    public static final int CTRL__STOP = 2;
    public static final int CTRL__FORWARD = 3;
    public static final int CTRL__BACKWARD = 4;
    public static final int CTRL__SEEK = 5;
    public static final int CTRL__K_FRAME_PLAY = 6;

    private byte chan;
    private int ctrl;
    private Byte factor;
    private Long tm;
    private String serverId;


    /**
     * 取通道号
     *
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
     * 取回放控制
     * @return 回放控制
     */
    public int getCtrl() {
        return ctrl;
    }

    /**
     * 设置回放控制
     * @param ctrl 回放控制
     */
    public void setCtrl(int ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 取快进或快退倍数
     * @return 快进或快退倍数。仅当回放方式为1或2时不为 null
     */
    public Byte getFactor() {
        return factor;
    }

    /**
     * 设置快进或快退倍数
     * @param factor 快进或快退倍数。仅当回放方式为1或2时不为 null
     */
    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    /**
     * 取拖动回放位置
     * @return 拖动回放位置, epoch millis。仅当回放方式为5时不为 null
     */
    public Long getTm() {
        return tm;
    }

    /**
     * 设置拖动回放位置
     * @param tm 拖动回放位置， epoch millis。仅当回放方式为5时不为 null
     */
    public void setTm(Long tm) {
        this.tm = tm;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }


    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
    }

    public int ctrl() {
        return ctrl;
    }

    public void ctrl(int value) {
        this.ctrl = value;
    }

    public int factorDef() {
        if (factor != null)
            return factor;
        else
            return 0;
    }

    public void factor(int value) {
        this.factor = (byte) value;
    }

    public long tmDef() {
        if (tm != null)
            return tm;
        else
            return 0L;
    }

    public void tm(long value) {
        this.tm = value;
    }

    public String serverId() {
        return serverId;
    }

    public void serverId(String value) {
        this.serverId = value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9202_ReplayAvCtrl.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("ctrl=" + ctrl)
                .add("factor=" + factor)
                .add("tm=" + tm)
                .add("serverId='" + serverId + "'")
                .toString();
    }

    @Override
    public CP_9202_ReplayAvCtrl clone() {
        try {
            return (CP_9202_ReplayAvCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
