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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8602_SetRectRegion;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置矩形区域消息 (0x8602)
 */
@JTMsgId(JT808MsgConsts.SET_RECT_REGION_8602)
public class JT808Msg_8602_SetRectRegion extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.SET_RECT_REGION_8602;

    /**
     * 构造函数
     */
    public JT808Msg_8602_SetRectRegion() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8602_SetRectRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8602_SetRectRegion params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_8602_SetRectRegion getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_8602_SetRectRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8602_SetRectRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
