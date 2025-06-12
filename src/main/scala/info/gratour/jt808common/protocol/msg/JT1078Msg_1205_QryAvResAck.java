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
import info.gratour.jt808common.protocol.msg.types.ackparams.JT1078AckParams_1205_QryAvResAck;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询音视频资源应答消息 (0x1205)
 */
@JTMsgId(JT1078MsgConsts.QRY_AV_RES_ACK_1205)
public class JT1078Msg_1205_QryAvResAck extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_RES_ACK_1205;

    /**
     * 构造函数
     */
    public JT1078Msg_1205_QryAvResAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_1205_QryAvResAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private JT1078AckParams_1205_QryAvResAck ackParams;

    /**
     * 获取应答流水号
     * @return 应答流水号
     */
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置应答流水号
     * @param ackSeqNo 应答流水号
     */
    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 获取应答参数
     * @return 应答参数
     */
    public JT1078AckParams_1205_QryAvResAck getAckParams() {
        return ackParams;
    }

    /**
     * 设置应答参数
     * @param ackParams 应答参数
     */
    public void setAckParams(JT1078AckParams_1205_QryAvResAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_1205_QryAvResAck.class.getSimpleName() + "[", "]")
                .add("ackSeqNo=" + ackSeqNo)
                .add("ackParams=" + ackParams)
                .toString();
    }
}
