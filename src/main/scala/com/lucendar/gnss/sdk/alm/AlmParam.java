/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.alm;

import java.util.StringJoiner;

/**
 * 报警配置
 */
public class AlmParam {

    private String appId;
    private String typ;
    private boolean disabled;
    private boolean stat;
    private boolean sendVoice;
    private String voiceText;
    private boolean notifyClnt;

    private boolean capture;
    private short captureChanMask;
    private boolean liveVidMon;
    private short liveVidMonChanMask;

    /**
     * 取 App ID
     * @return App ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 App ID
     * @param appId App ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取报警类型，为 {@link info.gratour.jtcommon.AlmTypes} 中定义的 TYP_ 系列常量之一
     * @return 报警类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置报警类型，为 {@link info.gratour.jtcommon.AlmTypes} 中定义的 TYP_ 系列常量之一
     * @param typ 报警类型
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 取是否不启用此报警记录
     *
     * @return 是否不启用此报警记录
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * 设置是否不启用此报警记录
     * @param disabled 是否不启用此报警记录
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 取发生报警时是否进行语音播报
     * @return 发生报警时是否进行语音播报
     */
    public boolean isSendVoice() {
        return sendVoice;
    }

    /**
     * 设置发生报警时是否进行语音播报
     * @param sendVoice 发生报警时是否进行语音播报
     */
    public void setSendVoice(boolean sendVoice) {
        this.sendVoice = sendVoice;
    }

    /**
     * 取报警时语音播报的信息文本
     * @return 报警时语音播报的信息文本
     */
    public String getVoiceText() {
        return voiceText;
    }

    /**
     * 设置报警时语音播报的信息文本
     * @param voiceText 报警时语音播报的信息文本
     */
    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }

    /**
     * 取报警时是否通知客户端
     *
     * @return 报警时是否通知客户端
     */
    public boolean isNotifyClnt() {
        return notifyClnt;
    }

    /**
     * 设置报警时是否通知客户端
     * @param notifyClnt 报警时是否通知客户端
     */
    public void setNotifyClnt(boolean notifyClnt) {
        this.notifyClnt = notifyClnt;
    }

    /**
     * 取是否对此类型报警进行统计
     * @return 是否对此类型报警进行统计
     */
    public boolean isStat() {
        return stat;
    }

    /**
     * 设置是否对此类型报警进行统计
     * @param stat 是否对此类型报警进行统计
     */
    public void setStat(boolean stat) {
        this.stat = stat;
    }

    /**
     * 取报警时是否拍照
     * @return 报警时是否拍照
     */
    public boolean isCapture() {
        return capture;
    }

    /**
     * 设置报警时是否拍照
     * @param capture 报警时是否拍照
     */
    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    /**
     * 取报警时拍照的通道掩码。拍照的通道（16路），以位表示。位0置位表示通道1拍照，位1置位表示通道2拍照，以此类推。多位置位表示多路摄像头一起拍摄。
     *
     * @return 报警时拍照的通道掩码
     */
    public short getCaptureChanMask() {
        return captureChanMask;
    }

    /**
     * 设置报警时拍照的通道掩码
     * @param captureChanMask 报警时拍照的通道掩码
     */
    public void setCaptureChanMask(short captureChanMask) {
        this.captureChanMask = captureChanMask;
    }

    /**
     * 取报警发生时是否立即打开实时音视频
     *
     * @return 报警发生时是否立即打开实时音视频
     */
    public boolean isLiveVidMon() {
        return liveVidMon;
    }

    /**
     * 设置报警发生时是否立即打开实时音视频
     * @param liveVidMon 报警发生时是否立即打开实时音视频
     */
    public void setLiveVidMon(boolean liveVidMon) {
        this.liveVidMon = liveVidMon;
    }

    /**
     * 取报警发生时打开实时音视频的通道号的掩码。启动音频频监控的通道（16路），以位表示。位0置位表示通道1监控，位1置位表示通道2监控，以此类推。多位置位表示多路摄像头一起监控。
     *
     * @return 报警发生时打开实时音视频的通道号的掩码
     */
    public short getLiveVidMonChanMask() {
        return liveVidMonChanMask;
    }

    /**
     * 设置报警发生时打开实时音视频的通道号的掩码
     * @param liveVidMonChanMask 报警发生时打开实时音视频的通道号的掩码
     */
    public void setLiveVidMonChanMask(short liveVidMonChanMask) {
        this.liveVidMonChanMask = liveVidMonChanMask;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlmParam.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("typ='" + typ + "'")
                .add("disabled=" + disabled)
                .add("stat=" + stat)
                .add("sendVoice=" + sendVoice)
                .add("voiceText='" + voiceText + "'")
                .add("notifyClnt=" + notifyClnt)
                .add("capture=" + capture)
                .add("captureChanMask=" + captureChanMask)
                .add("liveVidMon=" + liveVidMon)
                .add("liveVidMonChanMask=" + liveVidMonChanMask)
                .toString();
    }
}
