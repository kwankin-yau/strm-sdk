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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0800_MultiMediaEvent;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.MULTI_MEDIA_EVENT_0800)
public class JT808Msg_0800_MultiMediaEvent extends JT808Msg_0800_MultiMediaEvent_Simplified {

    public static final int MSG_ID = JT808Msg_0800_MultiMediaEvent_Simplified.MSG_ID;

    public JT808Msg_0800_MultiMediaEvent() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0800_MultiMediaEvent(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0800_MultiMediaEvent event;

    public MQEventAddt_0800_MultiMediaEvent getEvent() {
        return event;
    }

    public void setEvent(MQEventAddt_0800_MultiMediaEvent event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0800_MultiMediaEvent.class.getSimpleName() + "[", "]")
                .add("event=" + event)
                .toString();
    }
}
