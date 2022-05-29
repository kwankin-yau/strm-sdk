/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class AudioConfig2 implements Cloneable {

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

    public AudioConfig2(int sampleRate, int channels) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudioConfig2 that = (AudioConfig2) o;

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
        return new StringJoiner(", ", AudioConfig2.class.getSimpleName() + "[", "]")
                .add("sampleRate=" + sampleRate)
                .add("channels=" + channels)
                .toString();
    }

    @Override
    public AudioConfig2 clone() {
        try {
            return (AudioConfig2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
