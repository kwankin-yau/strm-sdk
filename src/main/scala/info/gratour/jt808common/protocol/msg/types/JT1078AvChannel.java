/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringJoiner;

/**
 * JT/T 1078 音视频通道
 */
public class JT1078AvChannel {

    /**
     * 音视频通道
     */
    public static final byte MEDIA_TYPE__AV = 0;

    /**
     * 音频通道
     */
    public static final byte MEDIA_TYPE__AUDIO_ONLY = 1;

    private byte channelId;
    private byte mediaType;
    private boolean custom;

    /**
     * 构造函数
     */
    public JT1078AvChannel() {
    }

    /**
     * 构造函数
     * @param channelId 通道 ID
     * @param mediaType 媒体类型
     * @param custom 是否自定义
     */
    public JT1078AvChannel(byte channelId, byte mediaType, boolean custom) {
        this.channelId = channelId;
        this.mediaType = mediaType;
        this.custom = custom;
    }

    /**
     * 取通道 ID
     * @return 通道 ID
     */
    public byte getChannelId() {
        return channelId;
    }

    /**
     * 设置通道 ID
     * @param channelId 通道 ID
     */
    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    /**
     * 取通道名称
     * @param locale 区域
     * @return 通道名称
     */
    public String getChannelName(Locale locale) {
        return channelName(channelId, locale);
    }

    /**
     * 取媒体类型
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
     * 是否自定义通道
     * @return 是否自定义通道
     */
    public boolean isCustom() {
        return custom;
    }

    /**
     * 设置是否自定义通道
     * @param custom 是否自定义通道
     */
    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    /**
     * 取通道文本
     * @param locale 区域
     * @return 通道文本
     */
    public String channelText(Locale locale) {
        return getChannelName(locale) + " (" + channelId + ")";
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078AvChannel.class.getSimpleName() + "[", "]")
                .add("channelId=" + channelId)
                .add("mediaType=" + mediaType)
                .add("custom=" + custom)
                .toString();
    }

    /**
     * 取资源包
     * @param locale 区域
     * @return 资源包
     */
    public static final ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.channel-names", locale != null ? locale : Locale.getDefault());
    }

    /**
     * 取通道名称
     * @param channelId 通道 ID
     * @param locale 区域
     * @return 通道名称
     */
    public static String channelName(int channelId, Locale locale) {
        String key = "ch" + channelId;
        ResourceBundle bundle = resourceBundle(locale);
        if (bundle.containsKey(key)) {
            return bundle.getString(key);
        } else
            return key;
    }

    /**
     * 创建标准通道
     * @param channelId 通道 ID
     * @param av 是否音视频通道
     * @return 标准通道
     */
    private static JT1078AvChannel ch(int channelId, boolean av) {
        byte mediaType = av ? MEDIA_TYPE__AV : MEDIA_TYPE__AUDIO_ONLY;
        return new JT1078AvChannel((byte) channelId, mediaType, false);
    }

    /**
     * 标准通道
     */
    public final static JT1078AvChannel[] standardChannels = new JT1078AvChannel[]{
            ch(1, true),
            ch(2, true),
            ch(3, true),
            ch(4, true),
            ch(5, true),
            ch(6, true),
            ch(7, true),
            ch(8, true),
            ch(9, true),
            ch(10, true),
            ch(11, true),
            ch(12, true),
            ch(13, true),
            ch(33, false),
            ch(36, false),
            ch(37, false)
    };
}

