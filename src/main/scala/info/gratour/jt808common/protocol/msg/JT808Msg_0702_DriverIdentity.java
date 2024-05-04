/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0702_DriverIdentity;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.DRIVER_IDENTITY_0702)
public class JT808Msg_0702_DriverIdentity extends JT808Msg_0702_DriverIdentity_Simplified {

    public static final int MSG_ID = JT808Msg_0702_DriverIdentity_Simplified.MSG_ID;

    public JT808Msg_0702_DriverIdentity() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0702_DriverIdentity(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0702_DriverIdentity info;

    public MQEventAddt_0702_DriverIdentity getInfo() {
        return info;
    }

    public void setInfo(MQEventAddt_0702_DriverIdentity info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0702_DriverIdentity.class.getSimpleName() + "[", "]")
                .add("info=" + info)
                .toString();
    }
}