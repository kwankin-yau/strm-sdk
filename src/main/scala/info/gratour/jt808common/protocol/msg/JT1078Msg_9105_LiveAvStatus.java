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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9105_LiveAvStatus;
import info.gratour.jtcommon.JTMsgId;

/**
 * 实时音视频传输状态通知消息 (0x9105)
 */
@JTMsgId(JT1078MsgConsts.LIVE_AV_STATUS_9105)
public class JT1078Msg_9105_LiveAvStatus extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.LIVE_AV_STATUS_9105;

    /**
     * 构造函数
     */
    public JT1078Msg_9105_LiveAvStatus() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9105_LiveAvStatus(JT808FrameHeader header) {
        super(header);
    }

    private CP_9105_LiveAvStatus params;

    /**
     * 获取状态参数
     * @return 状态参数
     */
    public CP_9105_LiveAvStatus getParams() {
        return params;
    }

    /**
     * 设置状态参数
     * @param params 状态参数
     */
    public void setParams(CP_9105_LiveAvStatus params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9105_LiveAvStatus.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
