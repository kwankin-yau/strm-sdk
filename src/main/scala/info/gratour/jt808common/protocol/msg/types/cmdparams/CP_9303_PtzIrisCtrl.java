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
 * 云台光圈控制(0x9303)命令参数
 */
@JTMsgId(JT1078MsgConsts.PTZ_IRIS_CTRL_9303)
@Expose
public class CP_9303_PtzIrisCtrl implements JT808CmdParams {

    private byte chan;
    private byte ctrl;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9303_PtzIrisCtrl.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("ctrl=" + ctrl)
                .toString();
    }

    @Override
    public CP_9303_PtzIrisCtrl clone() {
        try {
            return (CP_9303_PtzIrisCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
