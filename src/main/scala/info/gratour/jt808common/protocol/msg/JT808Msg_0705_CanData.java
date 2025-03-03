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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0705_CanData;
import info.gratour.jtcommon.JTMsgId;

import java.time.LocalTime;
import java.util.StringJoiner;

/**
 * CAN数据上传消息 (0x0705)
 */
@JTMsgId(JT808MsgConsts.CAN_DATA_0705)
public class JT808Msg_0705_CanData extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.CAN_DATA_0705;

    /**
     * 构造函数
     */
    public JT808Msg_0705_CanData() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0705_CanData(JT808FrameHeader header) {
        super(header);
    }

    private LocalTime receiveTime;
    private MQEventAddt_0705_CanData canData;

    /**
     * 获取接收时间
     * 
     * @return 接收时间
     */
    public LocalTime getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置接收时间
     * 
     * @param receiveTime 接收时间
     */
    public void setReceiveTime(LocalTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取CAN数据
     * 
     * @return CAN数据
     */
    public MQEventAddt_0705_CanData getCanData() {
        return canData;
    }

    /**
     * 设置CAN数据
     * 
     * @param canData CAN数据
     */
    public void setCanData(MQEventAddt_0705_CanData canData) {
        this.canData = canData;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0705_CanData.class.getSimpleName() + "[", "]")
                .add("receiveTime=" + receiveTime)
                .add("canData=" + canData)
                .toString();
    }
}
