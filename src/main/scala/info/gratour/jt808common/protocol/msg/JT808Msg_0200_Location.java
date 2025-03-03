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
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import info.gratour.jtcommon.JTMsgId;

/**
 * 位置消息 (0x0200)
 */
@JTMsgId(JT808MsgConsts.LOCATION_0200)
public class JT808Msg_0200_Location extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.LOCATION_0200;

    /**
     * 构造函数
     */
    public JT808Msg_0200_Location() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0200_Location(JT808FrameHeader header) {
        super(header);
    }

    private Trk trk;

    /**
     * 获取位置信息
     * 
     * @return 位置信息
     */
    public Trk getTrk() {
        return trk;
    }

    /**
     * 设置位置信息
     * 
     * @param trk 位置信息
     */
    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    @Override
    public String toString() {
        return "JT808Msg_0200_Location{" +
                "trk=" + trk +
                "} " + super.toString();
    }
}
