package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0107_QryAttrsAck;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询终端属性应答消息 (0x0107)
 */
@JTMsgId(JT808MsgConsts.QRY_TERMINAL_ATTRS_ACK_0107)
public class JT808Msg_0107_QryAttrsAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_TERMINAL_ATTRS_ACK_0107;

    /**
     * 构造函数
     */
    public JT808Msg_0107_QryAttrsAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0107_QryAttrsAck(JT808FrameHeader header) {
        super(header);
    }

    private JT808AckParams_0107_QryAttrsAck attrs;

    /**
     * 获取终端属性
     * 
     * @return 终端属性
     */
    public JT808AckParams_0107_QryAttrsAck getAttrs() {
        return attrs;
    }

    /**
     * 设置终端属性
     * 
     * @param attrs 终端属性
     */
    public void setAttrs(JT808AckParams_0107_QryAttrsAck attrs) {
        this.attrs = attrs;
    }

    @Override
    public String toString() {
        return "JT808Msg_0107_QryAttrsAck{" +
                "attrs=" + attrs +
                "} " + super.toString();
    }
}
