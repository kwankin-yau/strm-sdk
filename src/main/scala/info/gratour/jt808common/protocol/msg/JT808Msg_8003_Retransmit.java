package info.gratour.jt808common.protocol.msg;

import java.util.Arrays;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 重发请求消息(0x8003)
 */
@JTMsgId(JT808MsgConsts.PACKET_RETRANSMIT_REQ_8003)
public class JT808Msg_8003_Retransmit extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.PACKET_RETRANSMIT_REQ_8003;

    /**
     * 构造函数
     */
    public JT808Msg_8003_Retransmit() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8003_Retransmit(JT808FrameHeader header) {
        super(header);
    }

    private int origSeqNo;
    private int[] retransmitPacketIds;

    /**
     * 获取原始流水号
     * 
     * @return 原始流水号
     */
    public int getOrigSeqNo() {
        return origSeqNo;
    }

    /**
     * 设置原始流水号
     * 
     * @param origSeqNo 原始流水号
     */
    public void setOrigSeqNo(int origSeqNo) {
        this.origSeqNo = origSeqNo;
    }

    /**
     * 获取重发包ID列表
     * 
     * @return 重发包ID列表
     */
    public int[] getRetransmitPacketIds() {
        return retransmitPacketIds;
    }

    /**
     * 设置重发包ID列表
     * 
     * @param retransmitPacketIds 重发包ID列表
     */
    public void setRetransmitPacketIds(int[] retransmitPacketIds) {
        this.retransmitPacketIds = retransmitPacketIds;
    }

    @Override
    public String toString() {
        return "JT808Msg_8003_Retransmit{" +
                "origSeqNo=" + origSeqNo +
                ", retransmitPacketIds=" + Arrays.toString(retransmitPacketIds) +
                "} " + super.toString();
    }
}
