/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import java.util.StringJoiner;

import info.gratour.jt808common.protocol.msg.types.trk.Trk;

/**
 * 多媒体数据事件(0x0801)
 */
public class MQEventAddt_0801_MultiMediaData implements MQEventAddt {

    /**
     * 媒体类型: 图片
     */
    public static final int MEDIA_TYPE__IMAGE = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__IMAGE;

    /**
     * 媒体类型: 音频
     */
    public static final int MEDIA_TYPE__AUDIO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__AUDIO;

    /**
     * 媒体类型: 视频
     */
    public static final int MEDIA_TYPE__VIDEO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__VIDEO;

    /**
     * 媒体格式: JPEG
     */
    public static final int MEDIA_FMT__JPEG = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__JPEG;

    /**
     * 媒体格式: TIF
     */
    public static final int MEDIA_FMT__TIF = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__TIF;

    /**
     * 媒体格式: MP3
     */
    public static final int MEDIA_FMT__MP3 = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__MP3;

    /**
     * 媒体格式: WAV
     */
    public static final int MEDIA_FMT__WAV = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__WAV;

    /**
     * 媒体格式: WMV
     */
    public static final int MEDIA_FMT__WMV = MQEventAddt_0800_MultiMediaEvent.MEDIA_FMT__WMV;

    /**
     * 事件类型: 平台命令
     */
    public static final int EVT_TYPE__PLATFORM_CMD = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PLATFORM_CMD;

    /**
     * 事件类型: 定时触发
     */
    public static final int EVT_TYPE__PERIODICAL_ACT = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PERIODICAL_ACT;

    /**
     * 事件类型: 抢劫报警触发
     */
    public static final int EVT_TYPE__ROB = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__ROB;

    /**
     * 事件类型: 碰撞翻滚
     */
    public static final int EVT_TYPE__CRASH_ROLLOVER = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__CRASH_ROLLOVER;

    /**
     * 事件类型: 打开车门
     */
    public static final int EVT_TYPE__OPEN_DOOR = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__OPEN_DOOR;

    /**
     * 事件类型: 关闭车门
     */
    public static final int EVT_TYPE__CLOSE_DOOR = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__CLOSE_DOOR;


    private long mediaId;
    private byte typ;
    private byte fmt;
    private byte evtCode;
    private byte chan;
    private Trk trk;
    private byte[] data;

    /**
     * 获取媒体 ID
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
     * 获取媒体类型
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
     * 获取媒体格式
     * @return 媒体格式
     */
    public byte getFmt() {
        return fmt;
    }

    /**
     * 设置媒体格式
     * @param fmt 媒体格式
     */
    public void setFmt(byte fmt) {
        this.fmt = fmt;
    }

    /**
     * 获取事件代码
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
     * 获取通道号
     * @return 通道号
     */
    public byte getChan() {
        return chan;
    }

    /**
     * 设置通道号
     * @param chan 通道号
     */
    public void setChan(byte chan) {
        this.chan = chan;
    }

    /**
     * 获取轨迹
     * @return 轨迹
     */
    public Trk getTrk() {
        return trk;
    }

    /**
     * 设置轨迹
     * @param trk 轨迹
     */
    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    /**
     * 获取数据
     * @return 数据
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 设置数据
     * @param data 数据
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * 获取数据长度
     * @return 数据长度
     */
    public int dataLength() {
        if (data != null)
            return data.length;
        else
            return 0;
    }

    /**
     * 获取媒体 ID
     * @return 媒体 ID
     */
    public long mediaId() {
        return mediaId;
    }

    /**
     * 设置媒体 ID
     * @param value 媒体 ID
     */
    public void mediaId(long value) {
        this.mediaId = value;
    }

    /**
     * 获取媒体类型
     * @return 媒体类型
     */
    public int typ() {
        return typ;
    }

    /**
     * 设置媒体类型
     * @param value 媒体类型
     */
    public void typ(int value) {
        this.typ = (byte) value;
    }

    /**
     * 获取媒体格式
     * @return 媒体格式
     */
    public int fmt() {
        return fmt;
    }

    /**
     * 设置媒体格式
     * @param value 媒体格式
     */
    public void fmt(int value) {
        this.fmt = (byte) value;
    }

    /**
     * 获取事件代码
     * @return 事件代码
     */
    public int evtCode() {
        return evtCode;
    }

    /**
     * 设置事件代码
     * @param value 事件代码
     */
    public void evtCode(int value) {
        this.evtCode = (byte) value;
    }

    /**
     * 获取通道号
     * @return 通道号
     */
    public int chan() {
        return chan;
    }

    /**
     * 设置通道号
     * @param value 通道号
     */
    public void chan(int value) {
        this.chan = (byte) value;
    }

    /**
     * 获取轨迹
     * @return 轨迹
     */
    public Trk trk() {
        return trk;
    }

    /**
     * 设置轨迹
     * @param value 轨迹
     */
    public void trk(Trk value) {
        this.trk = value;
    }

    /**
     * 获取数据
     * @return 数据
     */
    public byte[] data() {
        return data;
    }

    /**
     * 设置数据
     * @param value 数据
     */
    public void data(byte[] value) {
        this.data = value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MQEventAddt_0801_MultiMediaData.class.getSimpleName() + "[", "]")
                .add("mediaId=" + mediaId)
                .add("typ=" + typ)
                .add("fmt=" + fmt)
                .add("evtCode=" + evtCode)
                .add("chan=" + chan)
                .add("trk=" + trk)
                .add("data.sz=" + (data != null ? data.length : 0))
                .toString();
    }
}
