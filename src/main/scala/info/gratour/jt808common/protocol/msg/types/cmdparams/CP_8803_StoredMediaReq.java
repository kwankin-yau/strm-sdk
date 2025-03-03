/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0800_MultiMediaEvent;
import info.gratour.jtcommon.JTMsgId;

/**
 * 存储媒体上传(0x8803)命令参数
 */
@JTMsgId(JT808MsgConsts.STORED_MEDIA_REQ_8803)
@Expose
public class CP_8803_StoredMediaReq implements JT808CmdParams {

    /**
     * 媒体类型：图片
     */
    public static final int MEDIA_TYPE__IMAGE = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__IMAGE;

    /**
     * 媒体类型：音频
     */
    public static final int MEDIA_TYPE__AUDIO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__AUDIO;

    /**
     * 媒体类型：视频
     */
    public static final int MEDIA_TYPE__VIDEO = MQEventAddt_0800_MultiMediaEvent.MEDIA_TYPE__VIDEO;

    /**
     * 事件类型：平台命令
     */
    public static final int EVT_TYPE__PLATFORM_CMD = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PLATFORM_CMD;

    /**
     * 事件类型：周期性事件
     */
    public static final int EVT_TYPE__PERIODICAL_ACT = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__PERIODICAL_ACT;

    /**
     * 事件类型：抢劫报警触发
     */
    public static final int EVT_TYPE__ROB = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__ROB;

    /**
     * 事件类型：碰撞翻滚
     */
    public static final int EVT_TYPE__CRASH_ROLLOVER = MQEventAddt_0800_MultiMediaEvent.EVT_TYPE__CRASH_ROLLOVER;

    private byte mediaType;
    private byte channelId;
    private byte event;
    private Long startTime;
    private Long endTime;
    private byte deleteFlag;

    /**
     * 获取媒体类型
     * @return 媒体类型
     */
    public byte getMediaType() {
        return mediaType;
    }

    /**
     * 设置媒体类型
     * @param mediaType 媒体类型
     */
    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 获取通道
     * @return 通道
     */
    public byte getChannelId() {
        return channelId;
    }

    /**
     * 设置通道
     * @param channelId 通道
     */
    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取事件
     * @return 事件
     */
    public byte getEvent() {
        return event;
    }

    /**
     * 设置事件
     * @param event 事件
     */
    public void setEvent(byte event) {
        this.event = event;
    }

    /**
     * 获取开始时间
     * @return 开始时间
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     * @return 结束时间
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取删除标志
     * @return 删除标志
     */
    public byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标志
     * @param deleteFlag 删除标志
     */
    public void setDeleteFlag(byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "CP_8803_StoredMediaReq{" +
                "mediaType=" + mediaType +
                ", channelId=" + channelId +
                ", event=" + event +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    @Override
    public CP_8803_StoredMediaReq clone() {
        try {
            return (CP_8803_StoredMediaReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
