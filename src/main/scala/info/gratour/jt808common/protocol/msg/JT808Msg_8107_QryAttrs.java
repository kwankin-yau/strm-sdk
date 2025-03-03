package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询终端属性消息(0x8107)
 */
@JTMsgId(JT808MsgConsts.QRY_TERMINAL_ATTRS_8107)
public class JT808Msg_8107_QryAttrs extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_TERMINAL_ATTRS_8107;

    /**
     * 构造函数
     */
    public JT808Msg_8107_QryAttrs() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8107_QryAttrs(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_8107_QryAttrs{} " + super.toString();
    }
}
