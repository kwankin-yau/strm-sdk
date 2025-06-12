/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 音视频通道设置(0x0076)
 */
public class TP_0076_AvChannelSettings {

    /**
     * 通道设置
     */
    public static class ChannelSetting {
        private byte phyChannelId;
        private byte logChannelId;
        private byte typ;
        private byte ptz;

        /**
         * 取物理通道ID
         * @return 物理通道ID
         */
        public byte getPhyChannelId() {
            return phyChannelId;
        }

        /**
         * 设置物理通道ID
         * @param phyChannelId 物理通道ID
         */
        public void setPhyChannelId(byte phyChannelId) {
            this.phyChannelId = phyChannelId;
        }

        /**
         * 取逻辑通道ID
         * @return 逻辑通道ID
         */
        public byte getLogChannelId() {
            return logChannelId;
        }

        /**
         * 设置逻辑通道ID
         * @param logChannelId 逻辑通道ID
         */
        public void setLogChannelId(byte logChannelId) {
            this.logChannelId = logChannelId;
        }

        /**
         * 取通道类型
         * @return 通道类型
         */
        public byte getTyp() {
            return typ;
        }

        /**
         * 设置通道类型
         * @param typ 通道类型
         */
        public void setTyp(byte typ) {
            this.typ = typ;
        }

        /**
         * 取是否连接云台
         * @return 是否连接云台
         */
        public byte getPtz() {
            return ptz;
        }

        /**
         * 设置是否连接云台
         * @param ptz 是否连接云台
         */
        public void setPtz(byte ptz) {
            this.ptz = ptz;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ChannelSetting.class.getSimpleName() + "[", "]")
                    .add("phyChannelId=" + phyChannelId)
                    .add("logChannelId=" + logChannelId)
                    .add("typ=" + typ)
                    .add("ptz=" + ptz)
                    .toString();
        }
    }

    private byte avChannelCnt;
    private byte audioChannelCnt;
    private byte videoChannelCnt;
    private ChannelSetting[] channelSettings;

    /**
     * 取音视频通道总数
     * @return 音视频通道总数
     */
    public byte getAvChannelCnt() {
        return avChannelCnt;
    }

    /**
     * 设置音视频通道总数
     * @param avChannelCnt 音视频通道总数
     */
    public void setAvChannelCnt(byte avChannelCnt) {
        this.avChannelCnt = avChannelCnt;
    }

    /**
     * 取音频通道总数
     * @return 音频通道总数
     */
    public byte getAudioChannelCnt() {
        return audioChannelCnt;
    }

    /**
     * 设置音频通道总数
     * @param audioChannelCnt 音频通道总数
     */
    public void setAudioChannelCnt(byte audioChannelCnt) {
        this.audioChannelCnt = audioChannelCnt;
    }

    /**
     * 取视频通道总数
     * @return 视频通道总数
     */
    public byte getVideoChannelCnt() {
        return videoChannelCnt;
    }

    /**
     * 设置视频通道总数
     * @param videoChannelCnt 视频通道总数
     */
    public void setVideoChannelCnt(byte videoChannelCnt) {
        this.videoChannelCnt = videoChannelCnt;
    }

    /**
     * 取通道设置
     * @return 通道设置
     */
    public ChannelSetting[] getChannelSettings() {
        return channelSettings;
    }

    /**
     * 设置通道设置
     * @param channelSettings 通道设置
     */
    public void setChannelSettings(ChannelSetting[] channelSettings) {
        this.channelSettings = channelSettings;
    }

    @Override
    public String toString() {
        return "TP_0076_AVChannelSettings{" +
                "avChannelCnt=" + avChannelCnt +
                ", audioChannelCnt=" + audioChannelCnt +
                ", videoChannelCnt=" + videoChannelCnt +
                ", channelSettings=" + Arrays.toString(channelSettings) +
                '}';
    }
}
