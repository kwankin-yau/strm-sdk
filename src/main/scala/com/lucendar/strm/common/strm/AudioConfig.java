/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class AudioConfig implements Cloneable {

    public static final int SAMPLE_RATE__8K = 8000;
    public static final int SAMPLE_RATE__11K = 11025;
    public static final int SAMPLE_RATE__22K = 22050;
    public static final int SAMPLE_RATE__44K = 44100;
    public static final int SAMPLE_RATE__48K = 48000;
    public static final int SAMPLE_RATE__64K = 64000;
    public static final int SAMPLE_RATE__96K = 96000;

    public static boolean isValidSampleRate(int sampleRate) {
        switch (sampleRate) {
            case SAMPLE_RATE__8K:
            case SAMPLE_RATE__11K:
            case SAMPLE_RATE__22K:
            case SAMPLE_RATE__44K:
            case SAMPLE_RATE__48K:
            case SAMPLE_RATE__64K:
            case SAMPLE_RATE__96K:
                return true;

            default:
                return false;
        }
    }

    public static final int CHANNELS__MONO = 1;
    public static final int CHANNELS__STEREO = 2;

    public static boolean isValidChannels(int channels) {
        return channels >= 1 && channels <= 8 && channels != 7;
    }

    private int sampleRate;
    private int channels;

    public AudioConfig() {
        this.sampleRate = SAMPLE_RATE__8K;
        this.channels = CHANNELS__MONO;
    }

    public AudioConfig(int sampleRate, int channels) {
        this.sampleRate = sampleRate;
        this.channels = channels;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public boolean stereo() {
        return channels > CHANNELS__MONO;
    }

    public static int mp4SamplingFrequencyIndexMap(int sampleRate) {
        switch (sampleRate) {
            case 8000:
                return 11;
            case 11024:
                return 10;
            case 44100:
                return 4;
            case 96000:
                return 0;
            case 88200:
                return 1;
            case 64000:
                return 2;
            case 48000:
                return 3;
            case 32000:
                return 5;
            case 24000:
                return 6;
            case 22050:
                return 7;
            case 16000:
                return 8;
            case 12000:
                return 9;
            case 7350:
                return 12;
            default:
                throw new RuntimeException("Sample rate does not supported: " + sampleRate);
        }
    }

    public int mp4SamplingFrequencyIndex() {
        return mp4SamplingFrequencyIndexMap(sampleRate);
    }

    public static int mp4ChannelConfigurationMap(int channels) {
        if (channels >= 1 && channels <= 6)
            return channels;
        else if (channels == 8)
            return 7;
        else
            throw new RuntimeException("Channels does not supported: " + channels);
    }

    public int mp4ChannelConfiguration() {
        return mp4ChannelConfigurationMap(channels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudioConfig that = (AudioConfig) o;

        if (sampleRate != that.sampleRate) return false;
        return channels == that.channels;
    }

    @Override
    public int hashCode() {
        int result = sampleRate;
        result = 31 * result + channels;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AudioConfig.class.getSimpleName() + "[", "]")
                .add("sampleRate=" + sampleRate)
                .add("channels=" + channels)
                .toString();
    }

    @Override
    public AudioConfig clone() {
        try {
            return (AudioConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
