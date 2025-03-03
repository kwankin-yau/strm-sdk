/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1003_QryAvAttrsAck;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询音视频属性应答消息 (0x1003)
 */
@JTMsgId(JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003)
public class JT1078Msg_1003_QryAvAttrsAck extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003;

    /**
     * 构造函数
     */
    public JT1078Msg_1003_QryAvAttrsAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_1003_QryAvAttrsAck(JT808FrameHeader header) {
        super(header);
    }

    private JT1078AckParams_1003_QryAvAttrsAck ackParams;

    /**
     * 获取应答参数
     * @return 应答参数
     */
    public JT1078AckParams_1003_QryAvAttrsAck getAckParams() {
        return ackParams;
    }

    /**
     * 设置应答参数
     * @param ackParams 应答参数
     */
    public void setAckParams(JT1078AckParams_1003_QryAvAttrsAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_1003_QryAvAttrsAck.class.getSimpleName() + "[", "]")
                .add("ackParams=" + ackParams)
                .toString();
    }
}
