package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 打开流结果
 */
public class OpenStrmResult {

    private String reqId;
    private int channel;
    private int proto;
    private boolean ctrl;
    private boolean ready;
    private String mediaTyp;
    private String playUrl;
    private String wsUrl;
    private String taUrl;
    private int keepIntv;
    private String host;
    private int port;
    private boolean tcp;
    private int port2019;
    private boolean tcp2019;
    private Boolean recording;
    private AudioConfig audioConfig;
    private Boolean detectMediaTyp;

    /**
     * 构造函数
     */
    public OpenStrmResult() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param channel 通道
     * @param proto 客户端协议，媒体格式。为 `StreamingApi.FMT_xxx` 常量之一
     * @param ctrl 控制
     * @param ready 就绪
     * @param mediaTyp 媒体类型
     * @param playUrl 播放URL
     * @param wsUrl WebSocket URL
     * @param taUrl 推流URL
     * @param keepIntv 保持间隔
     * @param host 主机
     * @param port 端口
     * @param tcp TCP
     * @param port2019 适用于2019版终端的端口
     * @param tcp2019 适用于2019版终端的是否使用TCP
     * @param recording 是否录音
     * @param audioConfig 音频配置
     * @param detectMediaTyp 是否检测媒体类型
     */
    public OpenStrmResult(String reqId, int channel, int proto, boolean ctrl, boolean ready, String mediaTyp, String playUrl, String wsUrl,
                          String taUrl,
                          int keepIntv, String host, int port, boolean tcp,
                          int port2019, boolean tcp2019, Boolean recording, AudioConfig audioConfig,
                          Boolean detectMediaTyp) {
        this.reqId = reqId;
        this.channel = channel;
        this.proto = proto;
        this.ctrl = ctrl;
        this.ready = ready;
        this.mediaTyp = mediaTyp;
        this.playUrl = playUrl;
        this.wsUrl = wsUrl;
        this.taUrl = taUrl;
        this.keepIntv = keepIntv;
        this.host = host;
        this.port = port;
        this.tcp = tcp;
        this.port2019 = port2019;
        this.tcp2019 = tcp2019;
        this.recording = recording;
        this.audioConfig = audioConfig;
        this.detectMediaTyp = detectMediaTyp;
    }

    /**
     * 获取请求ID
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

    /**
     * 获取通道
     * @return 通道
     */
    public int getChannel() {
        return channel;
    }

    /**
     * 设置通道
     * @param channel 通道
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * 获取协议, 为 `StreamingApi.FMT_xxx` 常量之一
     * @return 协议
     */
    public int getProto() {
        return proto;
    }

    /**
     * 设置协议, 为 `StreamingApi.FMT_xxx` 常量之一
     * @param proto 协议
     */
    public void setProto(int proto) {
        this.proto = proto;
    }

    /**
     * 返回当前流请求是否具有流的控制权
     * @return 如果当前流请求具有流的控制权，则返回true，否则返回false
     */
    public boolean isCtrl() {
        return ctrl;
    }

    /**
     * 设置当前流请求是否具有流的控制权
     * @param ctrl 如果当前流请求具有流的控制权，则返回true，否则返回false
     */
    public void setCtrl(boolean ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 返回当前流请求是否就绪（可以立即进行播放）
     * @return 如果当前流请求就绪，则返回true，否则返回false
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * 设置当前流请求是否就绪（可以立即进行播放）
     * @param ready 如果当前流请求就绪，则返回true，否则返回false
     */
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    /**
     * 获取媒体类型，为 `StreamingApi.MEDIA_TYPE_xxx` 常量之一
     * @return 媒体类型
     */
    public String getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置媒体类型
     * @param mediaTyp 媒体类型
     */
    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 获取播放URL
     * @return 播放URL
     */
    public String getPlayUrl() {
        return playUrl;
    }

    /**
     * 设置播放URL
     * @param playUrl 播放URL
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 获取WebSocket地址，用于对讲时客户端提交音频数据。此地址使用stomp协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     * @return WebSocket提交音频数据地址
     */
    public String getWsUrl() {
        return wsUrl;
    }

    /**
     * 设置WebSocket地址，用于对讲时客户端提交音频数据。此地址使用stomp协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     * @param wsUrl WebSocket提交音频数据地址
     */
    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    /**
     * 获取WebSocket地址，用于对讲时客户端提交音频数据。此地址使用二进制websocket协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     * @return WebSocket提交音频数据地址
     */
    public String getTaUrl() {
        return taUrl;
    }

    /**
     * WebSocket地址，用于对讲时客户端提交音频数据。此地址使用二进制websocket协议。仅当请求的流类型为实时流，且数据类型(dataTyp)为2: 对讲时有效。
     * @param taUrl WebSocket提交音频数据地址
     */
    public void setTaUrl(String taUrl) {
        this.taUrl = taUrl;
    }

    /**
     * 获取保持间隔, 单位：秒
     * @return 保持间隔
     */
    public int getKeepIntv() {
        return keepIntv;
    }

    /**
     * 设置保持间隔, 单位：秒
     * @param keepIntv 保持间隔
     */
    public void setKeepIntv(int keepIntv) {
        this.keepIntv = keepIntv;
    }

    /**
     * 获取终端推流地址中的主机名或IP。企业应用在向终端下发推流指令时应传此主机名。
     * @return 终端推流地址中的主机名或IP
     */
    public String getHost() {
        return host;
    }

    /**
     * 终端推流地址中的主机名或IP。企业应用在向终端下发推流指令时应传此主机名。
     * @param host 终端推流地址中的主机名或IP
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 取终端推流地址中的端口号。采用JT/T 808-2013协议的终端的码流推流地址的端口号。如果终端采用JT/T 808-2013协议，企业应用在向终端下发推流指令时应传此端口号。
     * @return 终端推流地址中的端口号
     */
    public int getPort() {
        return port;
    }

    /**
     * 设置终端推流地址中的端口号。采用JT/T 808-2013协议的终端的码流推流地址的端口号。如果终端采用JT/T 808-2013协议，企业应用在向终端下发推流指令时应传此端口号。
     * @param port 终端推流地址中的端口号(2013版)
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 取port属性所指代的端口号是否TCP端口。false时表示UDP端口。
     * @return port属性所指代的端口号是否TCP端口
     */
    public boolean isTcp() {
        return tcp;
    }

    /**
     * 设置port属性所指代的端口号是否TCP端口
     * @param tcp port属性所指代的端口号是否TCP端口
     */
    public void setTcp(boolean tcp) {
        this.tcp = tcp;
    }

    /**
     * 取终端推流地址中的端口号。采用JT/T 808-2019协议的终端的码流推流地址的端口号。如果终端采用JT/T 808-2019协议，企业应用在向终端下发推流指令时应传此端口号。
     * @return 终端推流地址中的端口号(2019版)
     */
    public int getPort2019() {
        return port2019;
    }

    /**
     * 设置终端推流地址中的端口号。采用JT/T 808-2019协议的终端的码流推流地址的端口号。如果终端采用JT/T 808-2019协议，企业应用在向终端下发推流指令时应传此端口号。
     * @param port2019 终端推流地址中的端口号(2019版)
     */
    public void setPort2019(int port2019) {
        this.port2019 = port2019;
    }

    /**
     * 指出port2019属性所指代的端口号是否TCP端口。false时表示UDP端口。
     * @return port2019属性所指代的端口号是否TCP端口
     */
    public boolean isTcp2019() {
        return tcp2019;
    }

    /**
     * 设置port2019属性所指代的端口号是否TCP端口
     * @param tcp2019 port2019属性所指代的端口号是否TCP端口
     */
    public void setTcp2019(boolean tcp2019) {
        this.tcp2019 = tcp2019;
    }

    /**
     * 返回服务端是否在播放的同时将媒体转储成录像文件。 为false时，无此属性(null)。
     * @return 服务端是否在播放的同时将媒体转储成录像文件
     */
    public Boolean getRecording() {
        return recording;
    }

    /**
     * 设置服务端是否在播放的同时将媒体转储成录像文件。 
     * @param recording 服务端是否在播放的同时将媒体转储成录像文件
     */
    public void setRecording(Boolean recording) {
        this.recording = recording;
    }

    /**
     * 获取音频配置
     * @return 音频配置
     */
    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    /**
     * 设置音频配置
     * @param audioConfig 音频配置
     */
    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    /**
     * 返回是否检测媒体类型
     * @return 是否检测媒体类型
     * @deprecated 已废弃，媒体服务总是检测媒体类型
     */
    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    /**
     * 设置是否检测媒体类型
     * @param detectMediaTyp 是否检测媒体类型
     * @deprecated 已废弃，媒体服务总是检测媒体类型
     */
    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OpenStrmResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("channel=" + channel)
                .add("proto=" + proto)
                .add("ctrl=" + ctrl)
                .add("ready=" + ready)
                .add("mediaTyp='" + mediaTyp + "'")
                .add("playUrl='" + playUrl + "'")
                .add("wsUrl='" + wsUrl + "'")
                .add("taUrl='" + taUrl + "'")
                .add("keepIntv=" + keepIntv)
                .add("host='" + host + "'")
                .add("port=" + port)
                .add("tcp=" + tcp)
                .add("port2019=" + port2019)
                .add("tcp2019=" + tcp2019)
                .add("recording=" + recording)
                .add("audioConfig=" + audioConfig)
                .add("detectMediaTyp=" + detectMediaTyp)
                .toString();
    }
}
