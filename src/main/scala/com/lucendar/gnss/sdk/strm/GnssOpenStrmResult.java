/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package com.lucendar.gnss.sdk.strm;

import com.google.gson.reflect.TypeToken;
import info.gratour.common.types.rest.Reply;

import java.lang.reflect.Type;
import java.util.StringJoiner;

/**
 * 打开媒体流结果
 */
public class GnssOpenStrmResult {

    public static final Type REPLY_TYPE = new TypeToken<Reply<GnssOpenStrmResult>>(){}.getType();

    private String reqId;
    private String instanceId;
    private int channel;
    private int proto;
    private boolean ctrl;
    private boolean ready;
    private String playUrl;

    /**
     * WebSocket地址，用于对讲时客户端提交音频数据。此地址使用stomp协议。仅当请求的流类型为实时流，且数据类型(`dataTyp`)为`2: 对讲`时有效。
     */
    private String wsUrl;

    /**
     * WebSocket地址，用于对讲时客户端提交音频数据。此地址使用二进制websocket协议。仅当请求的流类型为实时流，且数据类型(`dataTyp`)为`2: 对讲`时有效。
     */
    private String taUrl;
    private String mediaTyp;

    private Integer sampleRate;

    /**
     * 取请求ID
     *
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }


    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 取通道号
     *
     * @return 通道号
     */
    public int getChannel() {
        return channel;
    }

    /**
     * 设置通道号
     * @param channel 通道号
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * 取客户端协议
     *
     * @return 客户端协议，为 StreamingApi.STRM_FORMAT__xxxx 系列常量之一
     */
    public int getProto() {
        return proto;
    }

    /**
     * 设置客户端协议
     * @param proto 客户端协议，为 StreamingApi.STRM_FORMAT__xxxx 系列常量之一
     */
    public void setProto(int proto) {
        this.proto = proto;
    }

    /**
     * 此字段已废弃
     * @return 当前用户是否有流的控制权
     */
    public boolean getCtrl() {
        return ctrl;
    }

    /**
     * 此字段已废弃
     * @param ctrl
     */
    public void setCtrl(boolean ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 取播放 URL
     * @return 播放 URL
     */
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * 设置播放 URL
     * @param playUrl 播放 URL
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 取流是否已经可以播放。为false时，要等到收到act为ready的流媒体通知才能播放。
     * @return 流是否已经可以播放。
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * 设置流是否已经可以播放。
     * @param ready 流是否已经可以播放。为false时，要等到收到act为ready的流媒体通知才能播放。
     */
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    /**
     * 取对讲时客户端提交音频数据的 WebSocket 地址，此地址使用stomp协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     * @return 对讲时客户端提交音频数据的 WebSocket 地址
     */
    public String getWsUrl() {
        return wsUrl;
    }

    /**
     * 设置对讲时客户端提交音频数据的 WebSocket 地址
     * @param wsUrl 对讲时客户端提交音频数据的 WebSocket 地址，此地址使用stomp协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     */
    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    /**
     * 取对讲时客户端提交音频数据的 WebSocket 地址。此地址使用二进制websocket协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     * @return 对讲时客户端提交音频数据的 WebSocket 地址
     */
    public String getTaUrl() {
        return taUrl;
    }

    /**
     * 调协对讲时客户端提交音频数据的 WebSocket 地址
     * @param taUrl 对讲时客户端提交音频数据的 WebSocket 地址。此地址使用二进制websocket协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     */
    public void setTaUrl(String taUrl) {
        this.taUrl = taUrl;
    }

    /**
     * 取流的媒体类型：
     * <ul>
     *     <li>av: 音频和视频</li>
     *     <li>a: 仅音频</li>
     *     <li>v: 仅视频</li>
     * </ul>
     *
     * @return 流的媒体类型
     */
    public String getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置流的媒体类型
     * <ul>
     *     <li>av: 音频和视频</li>
     *     <li>a: 仅音频</li>
     *     <li>v: 仅视频</li>
     * </ul>
     *
     * @param mediaTyp 流的媒体类型
     */
    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 取音频的采样率
     * @return 音频的采样率
     */
    public Integer getSampleRate() {
        return sampleRate;
    }

    /**
     * 设置音频的采样率
     * @param sampleRate 音频的采样率
     */
    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssOpenStrmResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("instanceId='" + instanceId + "'")
                .add("channel=" + channel)
                .add("proto=" + proto)
                .add("ctrl=" + ctrl)
                .add("ready=" + ready)
                .add("playUrl='" + playUrl + "'")
                .add("wsUrl='" + wsUrl + "'")
                .add("taUrl='" + taUrl + "'")
                .add("mediaTyp='" + mediaTyp + "'")
                .add("sampleRate=" + sampleRate)
                .toString();
    }
}
