package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8106_QrySpecialParams;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询特殊参数消息(0x8106)
 */
@JTMsgId(JT808MsgConsts.QRY_SPECIAL_PARAMS_8106)
public class JT808Msg_8106_QrySpecialParams extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_SPECIAL_PARAMS_8106;

    /**
     * 构造函数
     */
    public JT808Msg_8106_QrySpecialParams() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8106_QrySpecialParams(JT808FrameHeader header) {
        super(header);
    }

    private CP_8106_QrySpecialParams params;

    /**
     * 获取参数
     * 
     * @return 参数
     */
    public CP_8106_QrySpecialParams getParams() {
        return params;
    }

    /**
     * 设置参数
     * 
     * @param params 参数
     */
    public void setParams(CP_8106_QrySpecialParams params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8106_QrySpecialParams{" +
                "params=" + params +
                "} " + super.toString();
    }
}
