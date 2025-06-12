/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;


import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.msg.types.trk.Trk;

/**
 * JT/T 808 媒体信息
 */
@Expose
public class JT808MediaInfo implements Cloneable {

    private long mediaId;
    private byte typ;
    private byte channel;
    private byte evtCode;
    private Trk trk;

    /**
     * 取媒体 ID
     * @return 媒体 ID
     */
    public long getMediaId() {
        return mediaId;
    }

    /**
     * 设置媒体 ID
     * @param mediaId 媒体 ID
     */
    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 取媒体类型
     * @return 媒体类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置媒体类型
     * @param typ 媒体类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 取通道号
     * @return 通道号
     */
    public byte getChannel() {
        return channel;
    }

    /**
     * 设置通道号
     * @param channel 通道号
     */
    public void setChannel(byte channel) {
        this.channel = channel;
    }

    /**
     * 取事件代码
     * @return 事件代码
     */
    public byte getEvtCode() {
        return evtCode;
    }

    /**
     * 设置事件代码
     * @param evtCode 事件代码
     */
    public void setEvtCode(byte evtCode) {
        this.evtCode = evtCode;
    }

    /**
     * 取位置信息
     * @return 位置信息
     */
    public Trk getTrk() {
        return trk;
    }

    /**
     * 设置位置信息
     * @param trk 位置信息
     */
    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808MediaInfo source) {
        this.mediaId = source.mediaId;
        this.typ = source.typ;
        this.channel = source.channel;
        this.evtCode = source.evtCode;
        this.trk = source.trk != null ? source.trk.clone() : null;
    }

    @Override
    public JT808MediaInfo clone() {
        try {
            return (JT808MediaInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808MediaInfo{" +
                "mediaId=" + mediaId +
                ", typ=" + typ +
                ", channel=" + channel +
                ", evtCode=" + evtCode +
                ", trk=" + trk +
                '}';
    }
}
