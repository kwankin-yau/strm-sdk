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
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0802_StoredMediaSearchAck;
import info.gratour.jtcommon.JTMsgId;

/**
 * 存储多媒体数据检索应答消息(0x0802)
 */
@JTMsgId(JT808MsgConsts.STORED_MEDIA_SEARCH_ACK_0802)
public class JT808Msg_0802_StoredMediaSearchAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.STORED_MEDIA_SEARCH_ACK_0802;

    /**
     * 构造函数
     */
    public JT808Msg_0802_StoredMediaSearchAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0802_StoredMediaSearchAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private JT808AckParams_0802_StoredMediaSearchAck ackParams;

    /**
     * 获取应答流水号
     * 
     * @return 应答流水号
     */
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置应答流水号
     * 
     * @param ackSeqNo 应答流水号
     */
    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 获取应答参数
     * 
     * @return 应答参数
     */
    public JT808AckParams_0802_StoredMediaSearchAck getAckParams() {
        return ackParams;
    }

    /**
     * 设置应答参数
     * 
     * @param ackParams 应答参数
     */
    public void setAckParams(JT808AckParams_0802_StoredMediaSearchAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return "JT808Msg_0802_StoredMediaSearchAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackParams=" + ackParams +
                "} " + super.toString();
    }
}
