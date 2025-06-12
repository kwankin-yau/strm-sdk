/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.StringJoiner;

/**
 * 音视频参数(0x0075)
 */
public class TP_0075_AvParams {

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
    private boolean audioOutEnabled;

    /**
     * 取实时流编码模式
     * @return 实时流编码模式
     */
    public byte getLiveStreamMode() {
        return liveStreamMode;
    }

    /**
     * 设置实时流编码模式
     * @param liveStreamMode 实时流编码模式
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
     * 取点播流编码模式
     * @return 点播流编码模式
     */
    public byte getVodStreamMode() {
        return vodStreamMode;
    }

    /**
     * 设置点播流编码模式
     * @param vodStreamMode 点播流编码模式
     */
    public void setVodStreamMode(byte vodStreamMode) {
        this.vodStreamMode = vodStreamMode;
    }

    /**
     * 取点播流分辨率
     * @return 点播流分辨率
     */
    public byte getVodStreamResolution() {
        return vodStreamResolution;
    }

    /**
     * 设置点播流分辨率
     * @param vodStreamResolution 点播流分辨率
     */
    public void setVodStreamResolution(byte vodStreamResolution) {
        this.vodStreamResolution = vodStreamResolution;
    }

    /**
     * 取点播流关键帧间隔
     * @return 点播流关键帧间隔
     */
    public int getVodStreamKFrameInterval() {
        return vodStreamKFrameInterval;
    }

    /**
     * 设置点播流关键帧间隔
     * @param vodStreamKFrameInterval 点播流关键帧间隔
     */
    public void setVodStreamKFrameInterval(int vodStreamKFrameInterval) {
        this.vodStreamKFrameInterval = vodStreamKFrameInterval;
    }

    /**
     * 取点播流帧率
     * @return 点播流帧率
     */
    public byte getVodStreamFrameRate() {
        return vodStreamFrameRate;
    }

    /**
     * 设置点播流帧率
     * @param vodStreamFrameRate 点播流帧率
     */
    public void setVodStreamFrameRate(byte vodStreamFrameRate) {
        this.vodStreamFrameRate = vodStreamFrameRate;
    }

    /**
     * 取点播流码率
     * @return 点播流码率
     */
    public int getVodStreamBitRate() {
        return vodStreamBitRate;
    }

    /**
     * 设置点播流码率
     * @param vodStreamBitRate 点播流码率
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

    /**
     * 取音频输出启用标志
     * @return 音频输出启用标志
     */
    public boolean getAudioOutEnabled() {
        return audioOutEnabled;
    }

    /**
     * 设置音频输出启用标志
     * @param audioOutEnabled 音频输出启用标志
     */
    public void setAudioOutEnabled(boolean audioOutEnabled) {
        this.audioOutEnabled = audioOutEnabled;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TP_0075_AvParams.class.getSimpleName() + "[", "]")
                .add("liveStreamMode=" + liveStreamMode)
                .add("liveStreamResolution=" + liveStreamResolution)
                .add("liveStreamKFrameInterval=" + liveStreamKFrameInterval)
                .add("liveStreamFrameRate=" + liveStreamFrameRate)
                .add("liveStreamBitRate=" + liveStreamBitRate)
                .add("vodStreamMode=" + vodStreamMode)
                .add("vodStreamResolution=" + vodStreamResolution)
                .add("vodStreamKFrameInterval=" + vodStreamKFrameInterval)
                .add("vodStreamFrameRate=" + vodStreamFrameRate)
                .add("vodStreamBitRate=" + vodStreamBitRate)
                .add("osdSettings=" + osdSettings)
                .add("audioOutEnabled=" + audioOutEnabled)
                .toString();
    }
}
