/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9202_ReplayAvCtrl;
import info.gratour.jtcommon.JTMsgId;

/**
 * 音视频回放控制消息 (0x9202)
 */
@JTMsgId(JT1078MsgConsts.REPLAY_AV_CTRL_9202)
public class JT1078Msg_9202_ReplayAvCtrl extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.REPLAY_AV_CTRL_9202;

    /**
     * 构造函数
     */
    public JT1078Msg_9202_ReplayAvCtrl() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9202_ReplayAvCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_9202_ReplayAvCtrl params;

    /**
     * 获取控制参数
     * @return 控制参数
     */
    public CP_9202_ReplayAvCtrl getParams() {
        return params;
    }

    /**
     * 设置控制参数
     * @param params 控制参数
     */
    public void setParams(CP_9202_ReplayAvCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9202_ReplayAvCtrl.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
