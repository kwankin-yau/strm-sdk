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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9201_ReplayAvReq;
import info.gratour.jtcommon.JTMsgId;

/**
 * 音视频回放请求消息 (0x9201)
 */
@JTMsgId(JT1078MsgConsts.REPLAY_AV_REQ_9201)
public class JT1078Msg_9201_ReplayAvReq extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.REPLAY_AV_REQ_9201;

    /**
     * 构造函数
     */
    public JT1078Msg_9201_ReplayAvReq() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9201_ReplayAvReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9201_ReplayAvReq params;

    /**
     * 获取请求参数
     * @return 请求参数
     */
    public CP_9201_ReplayAvReq getParams() {
        return params;
    }

    /**
     * 设置请求参数
     * @param params 请求参数
     */
    public void setParams(CP_9201_ReplayAvReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9201_ReplayAvReq.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
