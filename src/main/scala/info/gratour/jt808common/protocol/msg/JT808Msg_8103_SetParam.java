package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8103_SetParams;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置参数消息(0x8103)
 */
@JTMsgId(JT808MsgConsts.SET_PARAMS_8103)
public class JT808Msg_8103_SetParam extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.SET_PARAMS_8103;

    /**
     * 构造函数
     */
    public JT808Msg_8103_SetParam() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8103_SetParam(JT808FrameHeader header) {
        super(header);
    }

    private CP_8103_SetParams params;

    /**
     * 获取参数
     * 
     * @return 参数
     */
    public CP_8103_SetParams getParams() {
        return params;
    }

    /**
     * 设置参数
     * 
     * @param params 参数
     */
    public void setParams(CP_8103_SetParams params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8103_SetParam{" +
                "params=" + params +
                "} " + super.toString();
    }
}
