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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9102_LiveAvCtrl;
import info.gratour.jtcommon.JTMsgId;

/**
 * 实时音视频控制消息 (0x9102)
 */
@JTMsgId(JT1078MsgConsts.LIVE_AV_CTRL_9102)
public class JT1078Msg_9102_LiveAvCtrl extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.LIVE_AV_CTRL_9102;

    /**
     * 构造函数
     */
    public JT1078Msg_9102_LiveAvCtrl() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9102_LiveAvCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_9102_LiveAvCtrl params;

    /**
     * 获取控制参数
     * @return 控制参数
     */
    public CP_9102_LiveAvCtrl getParams() {
        return params;
    }

    /**
     * 设置控制参数
     * @param params 控制参数
     */
    public void setParams(CP_9102_LiveAvCtrl params) {
        this.params = params;
    }

    @Override
    public StringJoiner toString(StringJoiner joiner) {
        StringJoiner r = super.toString(joiner);
        r.add("params=" + params);
        return r;
    }
}
