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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9205_QryAvRes;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询音视频资源消息 (0x9205)
 */
@JTMsgId(JT1078MsgConsts.QRY_AV_RES_9205)
public class JT1078Msg_9205_QryAvRes extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_RES_9205;

    /**
     * 构造函数
     */
    public JT1078Msg_9205_QryAvRes() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9205_QryAvRes(JT808FrameHeader header) {
        super(header);
    }

    private CP_9205_QryAvRes params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_9205_QryAvRes getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_9205_QryAvRes params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9205_QryAvRes.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
