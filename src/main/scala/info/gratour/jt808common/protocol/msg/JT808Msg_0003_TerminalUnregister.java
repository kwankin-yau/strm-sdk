package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端注销消息 (0x0003)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_UNREGISTER_0003)
public class JT808Msg_0003_TerminalUnregister extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_UNREGISTER_0003;

    /**
     * 构造函数
     */
    public JT808Msg_0003_TerminalUnregister() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0003_TerminalUnregister(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_0003_TerminalUnregister{} " + super.toString();
    }
}
