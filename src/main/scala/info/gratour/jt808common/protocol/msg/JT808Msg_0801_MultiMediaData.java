/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0801_MultiMediaData;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_0801)
public class JT808Msg_0801_MultiMediaData extends JT808Msg_0801_MultiMediaData_Simplified {

    public static final int MSG_ID = JT808Msg_0801_MultiMediaData_Simplified.MSG_ID;

    public JT808Msg_0801_MultiMediaData() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0801_MultiMediaData(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0801_MultiMediaData data;

    public MQEventAddt_0801_MultiMediaData getData() {
        return data;
    }

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
