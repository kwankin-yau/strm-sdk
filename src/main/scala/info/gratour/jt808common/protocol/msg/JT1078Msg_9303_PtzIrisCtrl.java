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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9303_PtzIrisCtrl;
import info.gratour.jtcommon.JTMsgId;

/**
 * 云台光圈控制消息 (0x9303)
 */
@JTMsgId(JT1078MsgConsts.PTZ_IRIS_CTRL_9303)
public class JT1078Msg_9303_PtzIrisCtrl extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.PTZ_IRIS_CTRL_9303;

    /**
     * 构造函数
     */
    public JT1078Msg_9303_PtzIrisCtrl() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_9303_PtzIrisCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_9303_PtzIrisCtrl params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_9303_PtzIrisCtrl getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_9303_PtzIrisCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_9303_PtzIrisCtrl.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
