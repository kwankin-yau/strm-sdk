/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8700_VtdrDataCollectReq;
import info.gratour.jtcommon.JTMsgId;

/**
 * 行驶记录仪数据采集消息 (0x8700)
 */
@JTMsgId(JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700)
public class JT808Msg_8700_VtdrDataCollectReq extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700;

    /**
     * 构造函数
     */
    public JT808Msg_8700_VtdrDataCollectReq() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8700_VtdrDataCollectReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_8700_VtdrDataCollectReq params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_8700_VtdrDataCollectReq getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_8700_VtdrDataCollectReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_8700_VtdrDataCollectReq.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
