/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.Arrays;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 媒体数据应答(0x8800)
 */
@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_ACK_8800)
public class JT808Msg_8800_MMDataAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.MULTI_MEDIA_DATA_ACK_8800;

    /**
     * 构造函数
     */
    public JT808Msg_8800_MMDataAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8800_MMDataAck(JT808FrameHeader header) {
        super(header);
    }

    private int mediaId;
    private short[] retransmitPacketIds;

    /**
     * 获取媒体ID
     * @return 媒体ID
     */
    public int getMediaId() {
        return mediaId;
    }

    /**
     * 设置媒体ID
     * @param mediaId 媒体ID
     */
    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 获取重传包ID列表
     * @return 重传包ID列表
     */
    public short[] getRetransmitPacketIds() {
        return retransmitPacketIds;
    }

    /**
     * 设置重传包ID列表
     * @param retransmitPacketIds 重传包ID列表
     */
    public void setRetransmitPacketIds(short[] retransmitPacketIds) {
        this.retransmitPacketIds = retransmitPacketIds;
    }

    @Override
    public String toString() {
        return "JT808Msg_8800_MMDataAck{" +
                "mediaId=" + mediaId +
                ", retransmitPacketIds=" + Arrays.toString(retransmitPacketIds) +
                "} " + super.toString();
    }
}
