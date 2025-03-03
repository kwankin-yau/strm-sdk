package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8105_TerminalCtrl;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端控制消息 (0x8105)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_CTRL_8105)
public class JT808Msg_8105_TerminalCtrl extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_CTRL_8105;

    /**
     * 构造函数
     */
    public JT808Msg_8105_TerminalCtrl() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8105_TerminalCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_8105_TerminalCtrl params;

    /**
     * 获取参数
     * 
     * @return 参数
     */
    public CP_8105_TerminalCtrl getParams() {
        return params;
    }

    /**
     * 设置参数
     * 
     * @param params 参数
     */
    public void setParams(CP_8105_TerminalCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8105_TerminalCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
