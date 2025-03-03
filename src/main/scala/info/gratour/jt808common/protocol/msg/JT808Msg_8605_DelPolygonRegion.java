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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8605_DelPolygonRegion;
import info.gratour.jtcommon.JTMsgId;

/**
 * 删除多边形区域消息 (0x8605)
 */
@JTMsgId(JT808MsgConsts.DEL_POLYGON_REGION_8605)
public class JT808Msg_8605_DelPolygonRegion extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.DEL_POLYGON_REGION_8605;

    /**
     * 构造函数
     */
    public JT808Msg_8605_DelPolygonRegion() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8605_DelPolygonRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8605_DelPolygonRegion params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_8605_DelPolygonRegion getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_8605_DelPolygonRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8605_DelPolygonRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
