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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8203_ManualConfirmAlarm;
import info.gratour.jtcommon.JTMsgId;

/**
 * 手动确认报警消息 (0x8203)
 */
@JTMsgId(JT808MsgConsts.MANUAL_CONFIRM_ALARM_8203)
public class JT808Msg_8203_ManualConfirmAlarm extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.MANUAL_CONFIRM_ALARM_8203;

    /**
     * 构造函数
     */
    public JT808Msg_8203_ManualConfirmAlarm() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8203_ManualConfirmAlarm(JT808FrameHeader header) {
        super(header);
    }


    private CP_8203_ManualConfirmAlarm params;

    /**
     * 获取参数
     * 
     * @return 参数
     */
    public CP_8203_ManualConfirmAlarm getParams() {
        return params;
    }

    /**
     * 设置参数
     * 
     * @param params 参数
     */
    public void setParams(CP_8203_ManualConfirmAlarm params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8203_ManualConfirmAlarm{" +
                "params=" + params +
                "} " + super.toString();
    }
}
