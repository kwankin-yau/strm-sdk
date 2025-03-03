package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

/**
 * 终端通用应答消息 (0x0001)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_GENERIC_ACK_0001)
public class JT808Msg_0001_TerminalGeneralAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_GENERIC_ACK_0001;

    /**
     * 成功
     */
    public static final byte RESULT__SUCCESS = 0;

    /**
     * 失败
     */
    public static final byte RESULT__FAILED = 1;

    /**
     * 格式错误
     */
    public static final byte RESULT__BAD_FORMAT = 2;

    /**
     * 不支持
     */
    public static final byte RESULT__NOT_SUPPORTED = 3;

    /**
     * 取成功或失败的结果代码
     * @param success 是否成功
     * @return 结果代码
     */
    public static byte resultCodeOf(boolean success) {
        if (success)
            return RESULT__SUCCESS;
        else
            return RESULT__FAILED;
    }

    /**
     * 构造函数
     */
    public JT808Msg_0001_TerminalGeneralAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT808Msg_0001_TerminalGeneralAck(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private int ackMsgId;
    private byte result;

    /**
     * 取应答流水号
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
     * 取应答消息ID
     * @return 应答消息ID
     */
    public int getAckMsgId() {
        return ackMsgId;
    }

    /**
     * 设置应答消息ID
     * @param ackMsgId 应答消息ID
     */
    public void setAckMsgId(int ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    /**
     * 取应答消息ID十六进制字符串
     * @return 应答消息ID十六进制字符串
     */
    public String ackMsgIdToHex() {
        return JTUtils.msgIdToHex(ackMsgId);
    }

    /**
     * 取结果代码
     * @return 结果代码
     */
    public byte getResult() {
        return result;
    }

    /**
     * 设置结果代码
     * @param result 结果代码
     */
    public void setResult(byte result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "JT808Msg_0001_TerminalGeneralAck{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackMsgId=" + ackMsgIdToHex() +
                ", result=" + result +
                "} " + super.toString();
    }
}
