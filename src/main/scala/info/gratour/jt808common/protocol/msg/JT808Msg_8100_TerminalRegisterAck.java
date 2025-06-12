package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端注册应答消息(0x8100)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_REGISTER_ACK_8100)
public class JT808Msg_8100_TerminalRegisterAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_REGISTER_ACK_8100;

    /**
     * 构造函数
     */
    public JT808Msg_8100_TerminalRegisterAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8100_TerminalRegisterAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private byte result;
    private String authCode;

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
     * 获取结果代码
     * 
     * @return 结果代码
     */
    public byte getResult() {
        return result;
    }

    /**
     * 设置结果代码
     * 
     * @param result 结果代码
     */
    public void setResult(byte result) {
        this.result = result;
    }

    /**
     * 获取鉴权码
     * 
     * @return 鉴权码
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * 设置鉴权码
     * 
     * @param authCode 鉴权码
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "JT808Msg_8100_DeviceRegisterAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", result=" + result +
                ", authCode='" + authCode + '\'' +
                "} " + super.toString();
    }
}
