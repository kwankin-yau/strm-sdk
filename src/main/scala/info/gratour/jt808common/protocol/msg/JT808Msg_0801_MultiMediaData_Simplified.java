package info.gratour.jt808common.protocol.msg;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 多媒体数据消息(0x0801)（简化版, 不包含多媒体数据）
 */
@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_0801)
public class JT808Msg_0801_MultiMediaData_Simplified extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.MULTI_MEDIA_DATA_0801;

    /**
     * 构造函数
     */
    public JT808Msg_0801_MultiMediaData_Simplified() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0801_MultiMediaData_Simplified(JT808FrameHeader header) {
        super(header);
    }

    private long mediaId;

    /**
     * 获取媒体ID
     * 
     * @return 媒体ID
     */
    public long getMediaId() {
        return mediaId;
    }

    /**
     * 设置媒体ID
     * 
     * @param mediaId 媒体ID
     */
    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0801_MultiMediaData_Simplified.class.getSimpleName() + "[", "]")
                .add("mediaId=" + mediaId)
                .toString();
    }
}
