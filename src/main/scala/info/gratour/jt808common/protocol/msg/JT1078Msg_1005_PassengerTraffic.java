/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_1005_PassengerTraffic;
import info.gratour.jtcommon.JTMsgId;

/**
 * 乘客流量消息 (0x1005)
 */
@JTMsgId(JT1078MsgConsts.PASSENGER_TRAFFIC_1005)
public class JT1078Msg_1005_PassengerTraffic extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.PASSENGER_TRAFFIC_1005;

    /**
     * 构造函数
     */
    public JT1078Msg_1005_PassengerTraffic() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_1005_PassengerTraffic(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_1005_PassengerTraffic data;

    /**
     * 获取数据
     * @return 数据
     */
    public MQEventAddt_1005_PassengerTraffic getData() {
        return data;
    }

    /**
     * 设置数据
     * @param data 数据
     */
    public void setData(MQEventAddt_1005_PassengerTraffic data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT1078Msg_1005_PassengerTraffic{" +
                "data=" + data +
                "} " + super.toString();
    }

}
