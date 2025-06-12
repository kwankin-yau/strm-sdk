package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0100_TermRegister;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端注册消息 (0x0100)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_REGISTER_0100)
public class JT808Msg_0100_TerminalRegister extends JT808Msg  {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_REGISTER_0100;

    /**
     * 构造函数
     */
    public JT808Msg_0100_TerminalRegister() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0100_TerminalRegister(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0100_TermRegister info;

    /**
     * 获取终端注册信息
     * 
     * @return 终端注册信息
     */
    public MQEventAddt_0100_TermRegister getInfo() {
        return info;
    }

    /**
     * 设置终端注册信息
     * 
     * @param info 终端注册信息
     */
    public void setInfo(MQEventAddt_0100_TermRegister info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JT808Msg_0100_TerminalRegister{" +
                "info=" + info +
                "} " + super.toString();
    }
}
