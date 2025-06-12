/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

/**
 * 多媒体事件(0x0800)
 */
public class MQEventAddt_0800_MultiMediaEvent implements MQEventAddt {

    /**
     * 媒体类型: 图片
     */
    public static final int MEDIA_TYPE__IMAGE = 0;

    /**
     * 媒体类型: 音频
     */
    public static final int MEDIA_TYPE__AUDIO = 1;

    /**
     * 媒体类型: 视频
     */
    public static final int MEDIA_TYPE__VIDEO = 2;

    /**
     * 媒体格式: JPEG
     */
    public static final int MEDIA_FMT__JPEG = 0;

    /**
     * 媒体格式: TIF
     */
    public static final int MEDIA_FMT__TIF = 1;

    /**
     * 媒体格式: MP3
     */
    public static final int MEDIA_FMT__MP3 = 2;

    /**
     * 媒体格式: WAV
     */
    public static final int MEDIA_FMT__WAV = 3;

    /**
     * 媒体格式: WMV
     */
    public static final int MEDIA_FMT__WMV = 4;


    /**
     * 事件类型: 平台命令
     */
    public static final int EVT_TYPE__PLATFORM_CMD = 0;

    /**
     * 事件类型: 定时触发
     */
    public static final int EVT_TYPE__PERIODICAL_ACT = 1;

    /**
     * 事件类型: 抢劫报警触发
     */
    public static final int EVT_TYPE__ROB = 2;

    /**
     * 事件类型: 碰撞翻滚
     */
    public static final int EVT_TYPE__CRASH_ROLLOVER = 3;

    /**
     * 事件类型: 打开车门
     */
    public static final int EVT_TYPE__OPEN_DOOR = 4;

    /**
     * 事件类型: 关闭车门
     */
    public static final int EVT_TYPE__CLOSE_DOOR = 5;

    /**
     * 事件类型: 关门并超速
     */
    public static final int EVT_TYPE__CLOSE_DOOR_AND_OVERSPD = 6;

    /**
     * 事件类型: 定距拍照
     */
    public static final int EVT_TYPE__FIXED_DISTANCE = 7;

    private long mediaId;
    private byte typ;
    private byte fmt;
    private byte evtCode;
    private byte chan;

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

    @Override
    public String toString() {
        return "MQEventAddt_0800_MultiMediaEvent{" +
                "mediaId=" + mediaId +
                ", typ=" + typ +
                ", fmt=" + fmt +
                ", evtCode=" + evtCode +
                ", chan=" + chan +
                '}';
    }
}
