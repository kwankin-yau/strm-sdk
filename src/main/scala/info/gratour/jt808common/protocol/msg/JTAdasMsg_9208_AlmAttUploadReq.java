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
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9208_AlmAddtUploadReq;
import info.gratour.jtcommon.JTMsgId;

/**
 * ADAS报警附件上传请求消息 (0x9208)
 */
@JTMsgId(JTAdasMsgConsts.ALM_ATT_UPLOAD_REQ_9208)
public class JTAdasMsg_9208_AlmAttUploadReq extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_UPLOAD_REQ_9208;

    /**
     * 构造函数
     */
    public JTAdasMsg_9208_AlmAttUploadReq() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JTAdasMsg_9208_AlmAttUploadReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9208_AlmAddtUploadReq params;

    /**
     * 获取参数
     * @return 参数
     */
    public CP_9208_AlmAddtUploadReq getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_9208_AlmAddtUploadReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JTAdasMsg_9208_AlmAttUploadReq{" +
                "params=" + params +
                '}';
    }
}
