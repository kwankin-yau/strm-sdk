package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0104_QryParamsAck;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询参数应答消息 (0x0104)
 */
@JTMsgId(JT808MsgConsts.QRY_PARAMS_ACK_0104)
public class JT808Msg_0104_QryParamsAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_PARAMS_ACK_0104;

    /**
     * 构造函数
     */
    public JT808Msg_0104_QryParamsAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0104_QryParamsAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private JT808AckParams_0104_QryParamsAck ackParams;

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
    public JT808AckParams_0104_QryParamsAck getAckParams() {
        return ackParams;
    }

    /**
     * 设置应答参数
     * 
     * @param ackParams 应答参数
     */
    public void setAckParams(JT808AckParams_0104_QryParamsAck ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return "JT808Msg_0104_QryParamsAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackParams=" + ackParams +
                "} " + super.toString();
    }
}
