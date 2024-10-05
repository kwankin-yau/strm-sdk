/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;
import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.PTZ_IRIS_CTRL_9303)
@Expose
public class CP_9303_PtzIrisCtrl implements JT808CmdParams {

    private byte chan;
    private byte ctrl;

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    public byte getCtrl() {
        return ctrl;
    }

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
