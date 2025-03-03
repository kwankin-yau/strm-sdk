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
 * 透传消息下行 (0x8900)
 */
@JTMsgId(JT808MsgConsts.PASS_THROUGH_DATA_DL_8900)
public class JT808Msg_8900_PassThroughDL extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.PASS_THROUGH_DATA_DL_8900;

    /**
     * 构造函数
     */
    public JT808Msg_8900_PassThroughDL() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT808Msg_8900_PassThroughDL(JT808FrameHeader header) {
        super(header);
    }

    private byte typ;
    private byte[] content;

    /**
     * 获取透传消息类型
     * @return 透传消息类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置透传消息类型
     * @param typ 透传消息类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 获取透传消息内容
     * @return 透传消息内容
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * 设置透传消息内容
     * @param content 透传消息内容
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "JT808Msg_PassThroughDL_8900{" +
                "typ=" + typ +
                "} " + super.toString();
    }
}
