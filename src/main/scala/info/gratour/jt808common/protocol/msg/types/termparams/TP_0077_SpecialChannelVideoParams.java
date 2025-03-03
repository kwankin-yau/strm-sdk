/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.Arrays;

/**
 * 特殊通道视频参数(0x0077)
 */
public class TP_0077_SpecialChannelVideoParams {

    /**
     * 特殊通道视频设置
     */
    public static class SpecialChannelVideoSetting {
        private byte logChannelId;

        private byte liveStreamMode;
        private byte liveStreamResolution;
        private int liveStreamKFrameInterval;
        private byte liveStreamFrameRate;
        private int liveStreamBitRate;

        private byte vodStreamMode;
        private byte vodStreamResolution;
        private int vodStreamKFrameInterval;
        private byte vodStreamFrameRate;
        private int vodStreamBitRate;

        private short osdSettings;

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
         * 取实时流模式
         * @return 实时流模式
         */
        public byte getLiveStreamMode() {
            return liveStreamMode;
        }

        /**
         * 设置实时流模式
         * @param liveStreamMode 实时流模式
         */
        public void setLiveStreamMode(byte liveStreamMode) {
            this.liveStreamMode = liveStreamMode;
        }

        /**
         * 取实时流分辨率
         * @return 实时流分辨率
         */
        public byte getLiveStreamResolution() {
            return liveStreamResolution;
        }

        /**
         * 设置实时流分辨率
         * @param liveStreamResolution 实时流分辨率
         */
        public void setLiveStreamResolution(byte liveStreamResolution) {
            this.liveStreamResolution = liveStreamResolution;
        }

        /**
         * 取实时流关键帧间隔
         * @return 实时流关键帧间隔
         */
        public int getLiveStreamKFrameInterval() {
            return liveStreamKFrameInterval;
        }

        /**
         * 设置实时流关键帧间隔
         * @param liveStreamKFrameInterval 实时流关键帧间隔
         */
        public void setLiveStreamKFrameInterval(int liveStreamKFrameInterval) {
            this.liveStreamKFrameInterval = liveStreamKFrameInterval;
        }

        /**
         * 取实时流帧率
         * @return 实时流帧率
         */
        public byte getLiveStreamFrameRate() {
            return liveStreamFrameRate;
        }

        /**
         * 设置实时流帧率
         * @param liveStreamFrameRate 实时流帧率
         */
        public void setLiveStreamFrameRate(byte liveStreamFrameRate) {
            this.liveStreamFrameRate = liveStreamFrameRate;
        }

        /**
         * 取实时流码率
         * @return 实时流码率
         */
        public int getLiveStreamBitRate() {
            return liveStreamBitRate;
        }

        /**
         * 设置实时流码率
         * @param liveStreamBitRate 实时流码率
         */
        public void setLiveStreamBitRate(int liveStreamBitRate) {
            this.liveStreamBitRate = liveStreamBitRate;
        }

        /**
         * 取回放流模式
         * @return 回放流模式
         */
        public byte getVodStreamMode() {
            return vodStreamMode;
        }

        /**
         * 设置回放流模式
         * @param vodStreamMode 回放流模式
         */
        public void setVodStreamMode(byte vodStreamMode) {
            this.vodStreamMode = vodStreamMode;
        }

        /**
         * 取回放流分辨率
         * @return 回放流分辨率
         */
        public byte getVodStreamResolution() {
            return vodStreamResolution;
        }

        /**
         * 设置回放流分辨率
         * @param vodStreamResolution 回放流分辨率
         */
        public void setVodStreamResolution(byte vodStreamResolution) {
            this.vodStreamResolution = vodStreamResolution;
        }

        /**
         * 取回放流关键帧间隔
         * @return 回放流关键帧间隔
         */
        public int getVodStreamKFrameInterval() {
            return vodStreamKFrameInterval;
        }

        /**
         * 设置回放流关键帧间隔
         * @param vodStreamKFrameInterval 回放流关键帧间隔
         */
        public void setVodStreamKFrameInterval(int vodStreamKFrameInterval) {
            this.vodStreamKFrameInterval = vodStreamKFrameInterval;
        }

        /**
         * 取回放流帧率
         * @return 回放流帧率
         */
        public byte getVodStreamFrameRate() {
            return vodStreamFrameRate;
        }

        /**
         * 设置回放流帧率
         * @param vodStreamFrameRate 回放流帧率
         */
        public void setVodStreamFrameRate(byte vodStreamFrameRate) {
            this.vodStreamFrameRate = vodStreamFrameRate;
        }

        /**
         * 取回放流码率
         * @return 回放流码率
         */
        public int getVodStreamBitRate() {
            return vodStreamBitRate;
        }

        /**
         * 设置回放流码率
         * @param vodStreamBitRate 回放流码率
         */
        public void setVodStreamBitRate(int vodStreamBitRate) {
            this.vodStreamBitRate = vodStreamBitRate;
        }

        /**
         * 取OSD设置
         * @return OSD设置
         */
        public short getOsdSettings() {
            return osdSettings;
        }

        /**
         * 设置OSD设置
         * @param osdSettings OSD设置
         */
        public void setOsdSettings(short osdSettings) {
            this.osdSettings = osdSettings;
        }

        @Override
        public String toString() {
            return "SpecialChannelVideoSetting{" +
                    "logChannelId=" + logChannelId +
                    ", liveStreamMode=" + liveStreamMode +
                    ", liveStreamResolution=" + liveStreamResolution +
                    ", liveStreamKFrameInterval=" + liveStreamKFrameInterval +
                    ", liveStreamFrameRate=" + liveStreamFrameRate +
                    ", liveStreamBitRate=" + liveStreamBitRate +
                    ", vodStreamMode=" + vodStreamMode +
                    ", vodStreamResolution=" + vodStreamResolution +
                    ", vodStreamKFrameInterval=" + vodStreamKFrameInterval +
                    ", vodStreamFrameRate=" + vodStreamFrameRate +
                    ", vodStreamBitRate=" + vodStreamBitRate +
                    ", osdSettings=" + osdSettings +
                    '}';
        }
    }

    private SpecialChannelVideoSetting[] settings;

    /**
     * 取特殊通道视频设置
     * @return 特殊通道视频设置
     */
    public SpecialChannelVideoSetting[] getSettings() {
        return settings;
    }

    /**
     * 设置特殊通道视频设置
     * @param settings 特殊通道视频设置
     */
    public void setSettings(SpecialChannelVideoSetting[] settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "TP_0077_SpecialChannelVideoParams{" +
                "settings=" + Arrays.toString(settings) +
                '}';
    }
}
