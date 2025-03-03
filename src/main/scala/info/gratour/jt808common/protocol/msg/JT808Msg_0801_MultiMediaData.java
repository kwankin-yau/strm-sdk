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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0801_MultiMediaData;
import info.gratour.jtcommon.JTMsgId;

/**
 * 多媒体数据消息(0x0801)
 */
@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_0801)
public class JT808Msg_0801_MultiMediaData extends JT808Msg_0801_MultiMediaData_Simplified {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808Msg_0801_MultiMediaData_Simplified.MSG_ID;

    /**
     * 构造函数
     */
    public JT808Msg_0801_MultiMediaData() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0801_MultiMediaData(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0801_MultiMediaData data;

    /**
     * 获取多媒体数据
     * 
     * @return 多媒体数据
     */
    public MQEventAddt_0801_MultiMediaData getData() {
        return data;
    }

    /**
     * 设置多媒体数据
     * 
     * @param data 多媒体数据
     */
    public void setData(MQEventAddt_0801_MultiMediaData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0801_MultiMediaData.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}
