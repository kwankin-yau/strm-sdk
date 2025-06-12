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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0701_WayBill;
import info.gratour.jtcommon.JTMsgId;

/**
 * 电子运单消息 (0x0701)
 */
@JTMsgId(JT808MsgConsts.WAYBILL_0701)
public class JT808Msg_0701_WayBill extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.WAYBILL_0701;

    /**
     * 构造函数
     */
    public JT808Msg_0701_WayBill() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0701_WayBill(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0701_WayBill info;

    /**
     * 获取电子运单信息
     * 
     * @return 电子运单信息
     */
    public MQEventAddt_0701_WayBill getInfo() {
        return info;
    }

    /**
     * 设置电子运单信息
     * 
     * @param info 电子运单信息
     */
    public void setInfo(MQEventAddt_0701_WayBill info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JT808Msg_0701_WayBill{" +
                "info=" + info +
                "} " + super.toString();
    }
}
