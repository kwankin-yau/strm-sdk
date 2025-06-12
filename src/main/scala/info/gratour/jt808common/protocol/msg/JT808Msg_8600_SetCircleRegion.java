/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8600_SetCircleRegion;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置圆形区域消息 (0x8600)
 */
@JTMsgId(JT808MsgConsts.SET_CIRCLE_REGION_8600)
public class JT808Msg_8600_SetCircleRegion extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.SET_CIRCLE_REGION_8600;

    /**
     * 构造函数
     */
    public JT808Msg_8600_SetCircleRegion() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8600_SetCircleRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8600_SetCircleRegion params;

    /**
     * 获取参数
     * 
     * @return 参数
     */
    public CP_8600_SetCircleRegion getParams() {
        return params;
    }

    /**
     * 设置参数
     * 
     * @param params 参数
     */
    public void setParams(CP_8600_SetCircleRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8600_SetCircleRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
