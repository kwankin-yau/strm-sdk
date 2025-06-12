/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 音视频状态通知(0x9105)参数
 */
@JTMsgId(JT1078MsgConsts.LIVE_AV_STATUS_9105)
@Expose
public class CP_9105_LiveAvStatus implements JT808CmdParams {

    private byte channelId;
    private byte lossRate;

    /**
     * 获取通道号
     * @return 通道号
     */
    public byte getChannelId() {
        return channelId;
    }

    /**
     * 设置通道号
     * @param channelId 通道号
     */
    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取丢包率
     * @return 丢包率
     */
    public byte getLossRate() {
        return lossRate;
    }

    /**
     * 设置丢包率
     * @param lossRate 丢包率
     */
    public void setLossRate(byte lossRate) {
        this.lossRate = lossRate;
    }

    /**
     * 获取通道号
     * @return 通道号
     */
    public int chan() {
        return channelId;
    }

    /**
     * 设置通道号
     * @param value 通道号
     */
    public void chan(int value) {
        this.channelId = (byte) value;
    }

    /**
     * 获取丢包率
     * @return 丢包率
     */
    public int lossRate() {
        return lossRate;
    }

    /**
     * 设置丢包率
     * @param value 丢包率
     */
    public void lossRate(int value) {
        this.lossRate = (byte) value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9105_LiveAvStatus.class.getSimpleName() + "[", "]")
                .add("channelId=" + channelId)
                .add("lossRate=" + lossRate)
                .toString();
    }

    @Override
    public CP_9105_LiveAvStatus clone() {
        try {
            return (CP_9105_LiveAvStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
