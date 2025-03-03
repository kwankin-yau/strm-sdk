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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9101_LiveAvReq;
import info.gratour.jtcommon.JTMsgId;

/**
 * 音视频请求消息 (0x9101)
 */
@JTMsgId(JT1078MsgConsts.LIVE_AV_REQ_9101)
public class JT1078Msg_9101_LiveAvReq extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.LIVE_AV_REQ_9101;

    /**
     * 构造函数
     */
    public JT1078Msg_9101_LiveAvReq() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9101_LiveAvReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9101_LiveAvReq params;

    /**
     * 获取请求参数
     * @return 请求参数
     */
    public CP_9101_LiveAvReq getParams() {
        return params;
    }

    /**
     * 设置请求参数
     * @param params 请求参数
     */
    public void setParams(CP_9101_LiveAvReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9101_LiveAvReq.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
