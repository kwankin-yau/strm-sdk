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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8500_VehCtrl;
import info.gratour.jtcommon.JTMsgId;

/**
 * 车辆控制消息 (0x8500)
 */
@JTMsgId(JT808MsgConsts.VEH_CTRL_8500)
public class JT808Msg_8500_VehCtrl extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.VEH_CTRL_8500;

    /**
     * 构造函数
     */
    public JT808Msg_8500_VehCtrl() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8500_VehCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_8500_VehCtrl params;

    /**
     * 获取参数
     * 
     * @return 参数
     */
    public CP_8500_VehCtrl getParams() {
        return params;
    }

    /**
     * 设置参数
     * 
     * @param params 参数
     */
    public void setParams(CP_8500_VehCtrl params) {
        this.params = params;
    }


    @Override
    public String toString() {
        return "JT808Msg_8500_VehCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
