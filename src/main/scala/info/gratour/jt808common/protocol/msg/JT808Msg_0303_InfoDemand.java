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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0303_InfoDemand;
import info.gratour.jtcommon.JTMsgId;

/**
 * 信息点播/取消消息 (0x0303)
 */
@JTMsgId(JT808MsgConsts.INFO_DEMAND_0303)
public class JT808Msg_0303_InfoDemand extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.INFO_DEMAND_0303;

    /**
     * 构造函数
     */
    public JT808Msg_0303_InfoDemand() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0303_InfoDemand(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0303_InfoDemand params;

    /**
     * 获取信息点播/取消参数
     * 
     * @return 信息点播/取消参数
     */
    public MQEventAddt_0303_InfoDemand getParams() {
        return params;
    }

    /**
     * 设置信息点播/取消参数
     * 
     * @param params 信息点播/取消参数
     */
    public void setParams(MQEventAddt_0303_InfoDemand params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_0303_InfoDemand{" +
                "params=" + params +
                "} " + super.toString();
    }
}
