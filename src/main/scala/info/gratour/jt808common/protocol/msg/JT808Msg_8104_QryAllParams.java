package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询所有参数消息(0x8104)
 */
@JTMsgId(JT808MsgConsts.QRY_ALL_PARAMS_8104)
public class JT808Msg_8104_QryAllParams extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_ALL_PARAMS_8104;

    /**
     * 构造函数
     */
    public JT808Msg_8104_QryAllParams() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8104_QryAllParams(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_8104_QryAllParams{} " + super.toString();
    }
}
