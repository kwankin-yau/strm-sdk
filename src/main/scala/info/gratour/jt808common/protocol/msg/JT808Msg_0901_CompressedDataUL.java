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
import info.gratour.jtcommon.JTMsgId;

/**
 * 压缩数据上行消息(0x0901)
 */
@JTMsgId(JT808MsgConsts.COMPRESSED_DATA_UL_0x0901)
public class JT808Msg_0901_CompressedDataUL extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.COMPRESSED_DATA_UL_0x0901;

    /**
     * 构造函数
     */
    public JT808Msg_0901_CompressedDataUL() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0901_CompressedDataUL(JT808FrameHeader header) {
        super(header);
    }

    private byte[] data;

    /**
     * 获取压缩数据
     * 
     * @return 压缩数据
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 设置压缩数据
     * 
     * @param data 压缩数据
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT808Msg_0901_CompressedDataUL{} " + super.toString();
    }
}
