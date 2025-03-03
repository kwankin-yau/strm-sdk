/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
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
 * 查询服务器时间应答消息(0x8004)
 */
@JTMsgId(JT808MsgConsts.QRY_SERVER_TIME_ACK_8004)
public class JT808Msg_8004_QryServerTimeAck extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.QRY_SERVER_TIME_ACK_8004;

    private long serverTime;

    /**
     * 构造函数
     */
    public JT808Msg_8004_QryServerTimeAck() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8004_QryServerTimeAck(JT808FrameHeader header) {
        super(header);
    }

    /**
     * 获取服务器时间, epoch millis
     * 
     * @return 服务器时间
     */
    public long getServerTime() {
        return serverTime;
    }

    /**
     * 设置服务器时间
     * 
     * @param serverTime 服务器时间
     */
    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public String toString() {
        return "JT808Msg_8004_QryServerTimeAck{" +
                "serverTime=" + serverTime +
                '}';
    }
}
