/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0800_MultiMediaEvent;
import info.gratour.jtcommon.JTMsgId;

/**
 * 多媒体事件消息(0x0800)
 */
@JTMsgId(JT808MsgConsts.MULTI_MEDIA_EVENT_0800)
public class JT808Msg_0800_MultiMediaEvent extends JT808Msg_0800_MultiMediaEvent_Simplified {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808Msg_0800_MultiMediaEvent_Simplified.MSG_ID;

    /**
     * 构造函数
     */
    public JT808Msg_0800_MultiMediaEvent() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0800_MultiMediaEvent(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0800_MultiMediaEvent event;

    /**
     * 获取事件信息
     * 
     * @return 事件信息
     */
    public MQEventAddt_0800_MultiMediaEvent getEvent() {
        return event;
    }

    /**
     * 设置事件信息
     * 
     * @param event 事件信息
     */
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
