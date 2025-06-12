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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8805_SingleStoredMediaReq;
import info.gratour.jtcommon.JTMsgId;

/**
 * 单条存储多媒体数据上传消息 (0x8805)
 */
@JTMsgId(JT808MsgConsts.SINGLE_STORED_MEDIA_REQ_8805)
public class JT808Msg_8805_SingleStoredMediaReq extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.SINGLE_STORED_MEDIA_REQ_8805;

    /**
     * 构造函数
     */
    public JT808Msg_8805_SingleStoredMediaReq() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT808Msg_8805_SingleStoredMediaReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_8805_SingleStoredMediaReq params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_8805_SingleStoredMediaReq getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_8805_SingleStoredMediaReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8805_SingleStoredMediaReq{" +
                "params=" + params +
                "} " + super.toString();
    }
}
