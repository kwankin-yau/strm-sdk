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
import info.gratour.jtcommon.JTMsgId;

/**
 * 音视频上传完成消息 (0x1206)
 */
@JTMsgId(JT1078MsgConsts.AV_UPLOAD_COMPLETED_1206)
public class JT1078Msg_1206_AvUploadCompleted extends JT1078Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT1078MsgConsts.AV_UPLOAD_COMPLETED_1206;

    /**
     * 构造函数
     */
    public JT1078Msg_1206_AvUploadCompleted() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT1078Msg_1206_AvUploadCompleted(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private byte result;

    /**
     * 获取应答流水号
     * @return 应答流水号
     */
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置应答流水号
     * @param ackSeqNo 应答流水号
     */
    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 获取上传结果
     * @return 上传结果
     */
    public byte getResult() {
        return result;
    }

    /**
     * 设置上传结果
     * @param result 上传结果
     */
    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078Msg_1206_AvUploadCompleted.class.getSimpleName() + "[", "]")
                .add("ackSeqNo=" + ackSeqNo)
                .add("result=" + result)
                .toString();
    }
}
