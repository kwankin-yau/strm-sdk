package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询服务器时间消息 (0x0004)
 */
@JTMsgId(JT808MsgConsts.QRY_SERVER_TIME_0004)
public class JT808Msg_0004_QryServerTime extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_SERVER_TIME_0004;

    /**
     * 构造函数
     */
    public JT808Msg_0004_QryServerTime() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0004_QryServerTime(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_0004_QryServerTime{}";
    }
}
