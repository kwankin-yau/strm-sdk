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
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

/**
 * 批量位置信息汇报消息 (0x0704)
 */
@JTMsgId(JT808MsgConsts.BATCH_LOCATION_0704)
public class JT808Msg_0704_BatchLocation extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.BATCH_LOCATION_0704;

    /**
     * 构造函数
     */
    public JT808Msg_0704_BatchLocation() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0704_BatchLocation(JT808FrameHeader header) {
        super(header);
    }

    private boolean retransmit;
    private Trk[] trks;

    /**
     * 获取是否重发
     * 
     * @return 是否重发
     */
    public boolean isRetransmit() {
        return retransmit;
    }

    /**
     * 设置是否重发
     * 
     * @param retransmit 是否重发
     */
    public void setRetransmit(boolean retransmit) {
        this.retransmit = retransmit;
    }

    /**
     * 获取位置信息列表
     * 
     * @return 位置信息列表
     */
    public Trk[] getTrks() {
        return trks;
    }

    /**
     * 设置位置信息列表
     * 
     * @param trks 位置信息列表
     */
    public void setTrks(Trk[] trks) {
        this.trks = trks;
    }

    @Override
    public String toString() {
        return "JT808Msg_0704_BatchLocation{" +
                "retransmit=" + retransmit +
                ", trks=" + Arrays.toString(trks) +
                "} " + super.toString();
    }
}
