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
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0900_PassThroughUl;
import info.gratour.jtcommon.JTMsgId;

/**
 * 透传上行消息(0x0900)
 */
@JTMsgId(JT808MsgConsts.PASS_THROUGH_DATA_UL_0900)
public class JT808Msg_0900_PassThroughUL extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.PASS_THROUGH_DATA_UL_0900;

    /**
     * 构造函数
     */
    public JT808Msg_0900_PassThroughUL() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0900_PassThroughUL(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0900_PassThroughUl data;

    /**
     * 获取透传数据
     * 
     * @return 透传数据
     */
    public MQEventAddt_0900_PassThroughUl getData() {
        return data;
    }

    /**
     * 设置透传数据
     * 
     * @param data 透传数据
     */
    public void setData(MQEventAddt_0900_PassThroughUl data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0900_PassThroughUL.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}
