package com.lucendar.gnss.sdk.evtsrc;

import java.lang.reflect.Type;
import java.util.StringJoiner;

import com.google.gson.reflect.TypeToken;
import com.lucendar.gnss.sdk.utils.GnssClient;
import com.lucendar.strm.common.StrmMediaNotif;
import com.lucendar.strm.common.strm.stored.AvUploadNotif;

import info.gratour.jt808common.spi.model.TermCmdStateChanged;

/**
 * GNSS事件
 */
public class GnssEvent {

    private GnssEventType eventType;
    private String eventBody;
    private StrmMediaNotif strmMediaNotif;
    private AvUploadNotif avUploadNotif;
    private TermCmdStateChanged cmdStateChanged;
    private static final Type StrmMediaNotifType = new TypeToken<StrmMediaNotif>() {
    }.getType();
    private static final Type AvUploadNotifType = new TypeToken<AvUploadNotif>() {
    }.getType();

    /**
     * 获取事件类型
     * @return 事件类型
     */
    public GnssEventType getEventType() {
        return eventType;
    }

    /**
     * 设置事件类型
     * @param eventType 事件类型
     */
    public void setEventType(GnssEventType eventType) {
        this.eventType = eventType;
    }

    /**
     * 获取事件体 JSON 字符串
     * @return 事件体 JSON 字符串
     */
    public String getEventBody() {
        return eventBody;
    }

    /**
     * 设置事件体 JSON 字符串。
     * @param eventBody 事件体 JSON 字符串
     */
    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
    }

    /**
     * 获取流媒体通知, 当事件类型为 strm 时有效
     * @return 流媒体通知
     */
    public StrmMediaNotif getStrmMediaNotif() {
        return strmMediaNotif;
    }

    /**
     * 设置流媒体通知
     * @param strmMediaNotif 流媒体通知
     */
    public void setStrmMediaNotif(StrmMediaNotif strmMediaNotif) {
        this.strmMediaNotif = strmMediaNotif;
    }

    /**
     * 获取音视频上传通知, 当事件类型为 av_upload 时有效
     * @return 音视频上传通知
     */
    public AvUploadNotif getAvUploadNotif() {
        return avUploadNotif;
    }

    /**
     * 设置音视频上传通知
     * @param avUploadNotif 音视频上传通知
     */
    public void setAvUploadNotif(AvUploadNotif avUploadNotif) {
        this.avUploadNotif = avUploadNotif;
    }

    /**
     * 获取终端命令状态改变通知, 当事件类型为 cmd 时有效
     * @return 终端命令状态改变通知
     */
    public TermCmdStateChanged getCmdStateChanged() {
        return cmdStateChanged;
    }

    /**
     * 设置终端命令状态改变通知
     * @param cmdStateChanged 终端命令状态改变通知
     */
    public void setCmdStateChanged(TermCmdStateChanged cmdStateChanged) {
        this.cmdStateChanged = cmdStateChanged;
    }

    /**
     * 创建 GNSS 事件
     * @param evtTyp 事件类型
     * @param eventBody 事件体 JSON 字符串
     * @return GNSS 事件
     */
    public static GnssEvent of(GnssEventType evtTyp, String eventBody) {
        GnssEvent r = new GnssEvent();
        r.setEventType(evtTyp);

        switch (evtTyp) {
            case cmd:
                r.cmdStateChanged = GnssClient.GSON.fromJson(eventBody, TermCmdStateChanged.TYPE);
                break;
            case av_upload:
                r.avUploadNotif = GnssClient.GSON.fromJson(eventBody, AvUploadNotifType);
                break;
            case strm:
                r.strmMediaNotif = GnssClient.GSON.fromJson(eventBody, StrmMediaNotifType);
                break;

            default:
                throw new RuntimeException("Unhandled event type: " + evtTyp);
        }

        return r;
    }

    /**
     * 创建 GNSS 事件
     * @param eventType 事件类型
     * @param eventBody 事件体 JSON 字符串
     * @return GNSS 事件
     */
    public static GnssEvent of(String eventType, String eventBody) {
        GnssEventType evtTyp = GnssEventType.valueOf(eventType);
        return of(evtTyp, eventBody);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssEvent.class.getSimpleName() + "[", "]")
                .add("eventType=" + eventType)
                .add("strmMediaNotif=" + strmMediaNotif)
                .add("avUploadNotif=" + avUploadNotif)
                .add("cmdStateChanged=" + cmdStateChanged)
                .toString();
    }
}
