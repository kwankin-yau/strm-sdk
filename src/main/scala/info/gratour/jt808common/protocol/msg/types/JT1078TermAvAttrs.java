package info.gratour.jt808common.protocol.msg.types;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 终端音视频属性
 */
@Expose
public class JT1078TermAvAttrs {

    private byte audioCodec;
    private byte audioChannels;
    private byte audioSampleRate;
    private byte audioBitsPerSample;
    private int audioFrameSize;
    private boolean supportAudioOut;
    private byte videoCodec;
    private byte maxAudioChannels;
    private byte maxVideoChannels;

    /**
     * 取音频编码
     * @return 音频编码
     */
    public byte getAudioCodec() {
        return audioCodec;
    }

    /**
     * 设置音频编码
     * @param audioCodec 音频编码
     */
    public void setAudioCodec(byte audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * 取音频通道数
     * @return 音频通道数
     */
    public byte getAudioChannels() {
        return audioChannels;
    }

    /**
     * 设置音频通道数
     * @param audioChannels 音频通道数
     */
    public void setAudioChannels(byte audioChannels) {
        this.audioChannels = audioChannels;
    }

    /**
     * 取音频采样率
     * @return 音频采样率
     */
    public byte getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * 设置音频采样率
     * @param audioSampleRate 音频采样率
     */
    public void setAudioSampleRate(byte audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    /**
     * 取音频位数
     * @return 音频位数
     */
    public byte getAudioBitsPerSample() {
        return audioBitsPerSample;
    }

    /**
     * 设置音频位数
     * @param audioBitsPerSample 音频位数
     */
    public void setAudioBitsPerSample(byte audioBitsPerSample) {
        this.audioBitsPerSample = audioBitsPerSample;
    }

    /**
     * 取音频帧大小
     * @return 音频帧大小
     */
    public int getAudioFrameSize() {
        return audioFrameSize;
    }

    /**
     * 设置音频帧大小
     * @param audioFrameSize 音频帧大小
     */
    public void setAudioFrameSize(int audioFrameSize) {
        this.audioFrameSize = audioFrameSize;
    }

    /**
     * 是否支持音频输出
     * @return 是否支持音频输出
     */
    public boolean isSupportAudioOut() {
        return supportAudioOut;
    }

    /**
     * 设置是否支持音频输出
     * @param supportAudioOut 是否支持音频输出
     */
    public void setSupportAudioOut(boolean supportAudioOut) {
        this.supportAudioOut = supportAudioOut;
    }

    /**
     * 取视频编码
     * @return 视频编码
     */
    public byte getVideoCodec() {
        return videoCodec;
    }

    /**
     * 设置视频编码
     * @param videoCodec 视频编码
     */
    public void setVideoCodec(byte videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * 取最大音频通道数
     * @return 最大音频通道数
     */
    public byte getMaxAudioChannels() {
        return maxAudioChannels;
    }

    /**
     * 设置最大音频通道数
     * @param maxAudioChannels 最大音频通道数
     */
    public void setMaxAudioChannels(byte maxAudioChannels) {
        this.maxAudioChannels = maxAudioChannels;
    }

    /**
     * 取最大视频通道数
     * @return 最大视频通道数
     */
    public byte getMaxVideoChannels() {
        return maxVideoChannels;
    }

    /**
     * 设置最大视频通道数
     * @param maxVideoChannels 最大视频通道数
     */
    public void setMaxVideoChannels(byte maxVideoChannels) {
        this.maxVideoChannels = maxVideoChannels;
    }

    /**
     * 取音频编码
     * @return 音频编码
     */
    public int audioCodec() {
        return audioCodec;
    }

    /**
     * 设置音频编码
     * @param value 音频编码
     */
    public void audioCodec(int value) {
        this.audioCodec = (byte) value;
    }

    /**
     * 取音频通道数
     * @return 音频通道数
     */
    public int audioChannels() {
        return audioChannels;
    }

    /**
     * 设置音频通道数
     * @param value 音频通道数
     */
    public void audioChannels(int value) {
        this.audioChannels = (byte) value;
    }

    /**
     * 取音频采样率
     * @return 音频采样率
     */
    public int audioSampleRate() {
        return audioSampleRate;
    }

    /**
     * 设置音频采样率
     * @param value 音频采样率
     */
    public void audioSampleRate(int value) {
        this.audioSampleRate = (byte) value;
    }

    /**
     * 取音频位数
     * @return 音频位数
     */
    public int audioBitsPerSample() {
        return audioBitsPerSample;
    }

    /**
     * 设置音频位数
     * @param value 音频位数
     */
    public void audioBitsPerSample(int value) {
        this.audioBitsPerSample = (byte) value;
    }

    /**
     * 取音频帧大小
     * @return 音频帧大小
     */
    public int audioFrameSize() {
        return audioFrameSize;
    }

    /**
     * 设置音频帧大小
     * @param value 音频帧大小
     */
    public void audioFrameSize(int value) {
        this.audioFrameSize = value;
    }

    /**
     * 是否支持音频输出
     * @return 是否支持音频输出
     */
    public boolean supportAudioOut() {
        return supportAudioOut;
    }

    /**
     * 设置是否支持音频输出
     * @param value 是否支持音频输出
     */
    public void supportAudioOut(boolean value) {
        this.supportAudioOut = value;
    }

    /**
     * 取视频编码
     * @return 视频编码
     */
    public int videoCodec() {
        return videoCodec;
    }

    /**
     * 设置视频编码
     * @param value 视频编码
     */
    public void videoCodec(int value) {
        this.videoCodec = (byte) value;
    }

    /**
     * 取最大音频通道数
     * @return 最大音频通道数
     */
    public int maxAudioChannels() {
        return maxAudioChannels;
    }

    /**
     * 设置最大音频通道数
     * @param value 最大音频通道数
     */
    public void maxAudioChannels(int value) {
        this.maxAudioChannels = (byte) value;
    }

    /**
     * 取最大视频通道数
     * @return 最大视频通道数
     */
    public int maxVideoChannels() {
        return maxVideoChannels;
    }

    /**
     * 设置最大视频通道数
     * @param value 最大视频通道数
     */
    public void maxVideoChannels(int value) {
        this.maxVideoChannels = (byte) value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078TermAvAttrs.class.getSimpleName() + "[", "]")
                .add("audioCodec=" + audioCodec)
                .add("audioChannels=" + audioChannels)
                .add("audioSampleRate=" + audioSampleRate)
                .add("audioBitsPerSample=" + audioBitsPerSample)
                .add("audioFrameSize=" + audioFrameSize)
                .add("supportAudioOut=" + supportAudioOut)
                .add("videoCodec=" + videoCodec)
                .add("maxAudioChannels=" + maxAudioChannels)
                .add("maxVideoChannels=" + maxVideoChannels)
                .toString();
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT1078TermAvAttrs source) {
        this.audioCodec = source.audioCodec;
        this.audioChannels = source.audioChannels;
        this.audioSampleRate = source.audioSampleRate;
        this.audioBitsPerSample = source.audioBitsPerSample;
        this.audioFrameSize = source.audioFrameSize;
        this.supportAudioOut = source.supportAudioOut;
        this.videoCodec = source.videoCodec;
        this.maxAudioChannels = source.maxAudioChannels;
        this.maxVideoChannels = source.maxVideoChannels;
    }

    @Override
    public JT1078TermAvAttrs clone() {
        JT1078TermAvAttrs r = new JT1078TermAvAttrs();
        r.assignFrom(this);
        return r;
    }

}
