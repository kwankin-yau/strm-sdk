package com.lucendar.strm.common.strm.stat;

import java.util.Arrays;

import com.lucendar.strm.common.strm.OpenStrmReq;

/**
 * 流请求状态
 */
public class StrmStatus {
    private String appId;
    private String initReqId;
    private String simNo;
    private short chanId;
    private boolean live;
    private Integer liveDataTyp;
    private byte codeStrm;
    private long createTm;
    private Long srcDetectTm;
    private boolean ready;
    private Long readyTm;
    private Long closeTm;

    /**
     * Bytes received from terminal from connection created.
     */
    private long recv;

    /**
     * Terminal pushing byte rate (bytes/second) in recent one minute.
     */
    private long byteRate;

    /**
     * Bytes send to terminal from connection created.
     */
    private long sent;

//    /**
//     * Send to terminal bytes rate (bytes/second) in recent one minute.
//     */
//    private long sendRate;
//
    /**
     * Bytes totally send to client.
     */
    private long sendToClnt;

    private String aFmt;
    private Boolean aNotSupport;
    private String vFmt;
    private Boolean vNotSupport;
    private String vRez;
    private Float frameRate; // null if not available
    private String mediaTyp;
    private Integer trace;

    private StrmReqStatus[] requests;

    /**
     * 构造函数
     */
    public StrmStatus() {
    }

    /**
     * 构造函数
     * @param appId 应用ID
     * @param initReqId 初始请求ID
     * @param simNo 设备SIM卡号
     * @param chanId 通道ID
     * @param live 是否直播
     * @param liveDataTyp 直播数据类型
     * @param codeStrm 码流类型
     * @param createTm 创建时间
     * @param srcDetectTm 源检测时间
     * @param ready 是否准备就绪
     * @param readyTm 准备就绪时间
     * @param closeTm 关闭时间
     * @param recv 接收字节数
     * @param byteRate 字节速率
     * @param sent 发送字节数
     * @param sendToClnt 发送给客户端的字节数
     * @param aFmt 音频格式
     * @param aNotSupport 音频不支持
     * @param vFmt 视频格式
     * @param vNotSupport 视频不支持
     * @param vRez 视频分辨率
     * @param frameRate 帧率
     * @param mediaTyp 媒体类型
     * @param trace 跟踪
     * @param requests 请求状态
     */
    public StrmStatus(
            String appId,
            String initReqId,
            String simNo,
            short chanId,
            boolean live,
            Integer liveDataTyp,
            byte codeStrm,
            long createTm,
            Long srcDetectTm,
            boolean ready,
            Long readyTm,
            Long closeTm,
            long recv,
            long byteRate,
            long sent,
//            long sendRate,
            long sendToClnt,
            String aFmt,
            Boolean aNotSupport,
            String vFmt,
            Boolean vNotSupport,
            String vRez,
            Float frameRate,
            String mediaTyp,
            Integer trace,
            StrmReqStatus[] requests
    ) {
        this.appId = appId;
        this.initReqId = initReqId;
        this.simNo = simNo;
        this.chanId = chanId;
        this.live = live;
        this.liveDataTyp = liveDataTyp;
        this.codeStrm = codeStrm;
        this.createTm = createTm;
        this.srcDetectTm = srcDetectTm;
        this.ready = ready;
        this.readyTm = readyTm;
        this.closeTm = closeTm;
        this.recv = recv;
        this.byteRate = byteRate;
        this.sent = sent;
//        this.sendRate = sendRate;
        this.sendToClnt = sendToClnt;
        this.aFmt = aFmt;
        this.aNotSupport = aNotSupport;
        this.vFmt = vFmt;
        this.vNotSupport = vNotSupport;
        this.vRez = vRez;
        this.frameRate = frameRate;
        this.mediaTyp = mediaTyp;
        this.trace = trace;
        this.requests = requests;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取初始请求ID
     * @return 初始请求ID
     */
    public String getInitReqId() {
        return initReqId;
    }

    /**
     * 设置初始请求ID
     * @param initReqId 初始请求ID
     */
    public void setInitReqId(String initReqId) {
        this.initReqId = initReqId;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 获取通道ID
     * @return 通道ID
     */
    public short getChanId() {
        return chanId;
    }

    /**
     * 设置通道ID
     * @param chanId 通道ID
     */
    public void setChanId(short chanId) {
        this.chanId = chanId;
    }

    /**
     * 获取是否实时播放
     * @return 是否实时播放
     */
    public boolean isLive() {
        return live;
    }

    /**
     * 设置是否实时播放
     * @param live 是否实时播放
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * 获取实时播放数据类型
     * @return 实时播放数据类型
     */
    public Integer getLiveDataTyp() {
        return liveDataTyp;
    }

    /**
     * 设置实时播放数据类型
     * @param liveDataTyp 实时播放数据类型
     */
    public void setLiveDataTyp(Integer liveDataTyp) {
        this.liveDataTyp = liveDataTyp;
    }

    /**
     * 获取码流类型
     * @return 码流类型
     */
    public byte getCodeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流类型
     * @param codeStrm 码流类型
     */
    public void setCodeStrm(byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    /**
     * 获取创建时间
     * @return 创建时间, epoch millis
     */
    public long getCreateTm() {
        return createTm;
    }

    /**
     * 设置创建时间
     * @param createTm 创建时间, epoch millis
     */
    public void setCreateTm(long createTm) {
        this.createTm = createTm;
    }

    /**
     * 获取源检测时间
     * @return 源检测时间, epoch millis
     */
    public Long getSrcDetectTm() {
        return srcDetectTm;
    }

    /**
     * 设置源检测时间
     * @param srcDetectTm 源检测时间, epoch millis
     */
    public void setSrcDetectTm(Long srcDetectTm) {
        this.srcDetectTm = srcDetectTm;
    }

    /**
     * 获取媒体流是否准备就绪
     * @return 是否准备就绪
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * 设置媒体流是否准备就绪
     * @param ready 是否准备就绪
     */
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    /**
     * 获取媒体流准备就绪时间
     * @return 准备就绪时间, epoch millis
     */
    public Long getReadyTm() {
        return readyTm;
    }

    /**
     * 设置媒体流准备就绪时间
     * @param readyTm 准备就绪时间, epoch millis
     */
    public void setReadyTm(Long readyTm) {
        this.readyTm = readyTm;
    }

    /**
     * 获取媒体流关闭时间
     * @return 关闭时间, epoch millis
     */
    public Long getCloseTm() {
        return closeTm;
    }

    /**
     * 设置媒体流关闭时间
     * @param closeTm 关闭时间, epoch millis
     */
    public void setCloseTm(Long closeTm) {
        this.closeTm = closeTm;
    }

    /**
     * 获取从连接创建以来接收的字节数
     * @return 接收字节数
     */
    public long getRecv() {
        return recv;
    }

    /**
     * 设置从连接创建以来接收的字节数
     * @param recv 接收字节数
     */
    public void setRecv(long recv) {
        this.recv = recv;
    }

    /**
     * 获取终端推送字节速率
     * @return 字节速率
     */
    public long getByteRate() {
        return byteRate;
    }

    /**
     * 设置终端推送字节速率
     * @param byteRate 字节速率
     */
    public void setByteRate(long byteRate) {
        this.byteRate = byteRate;
    }

    /**
     * 获取发送给终端的字节数
     * @return 发送字节数
     */
    public long getSent() {
        return sent;
    }

    /**
     * 设置发送给终端的字节数
     * @param sent 发送字节数
     */
    public void setSent(long sent) {
        this.sent = sent;
    }

//    public long getSendRate() {
//        return sendRate;
//    }
//
//    public void setSendRate(long sendRate) {
//        this.sendRate = sendRate;
//    }

    /**
     * 获取发送给客户端的字节数
     * @return 发送给客户端的字节数
     */
    public long getSendToClnt() {
        return sendToClnt;
    }

    /**
     * 设置发送给客户端的字节数
     * @param sendToClnt 发送给客户端的字节数
     */
    public void setSendToClnt(long sendToClnt) {
        this.sendToClnt = sendToClnt;
    }

    /**
     * 获取音频格式
     * @return 音频格式
     */
    public String getAFmt() {
        return aFmt;
    }

    /**
     * 设置音频格式
     * @param aFmt 音频格式
     */
    public void setAFmt(String aFmt) {
        this.aFmt = aFmt;
    }

    /**
     * 获取音频格式是否不支持
     * @return 音频格式是否不支持
     */
    public Boolean getANotSupport() {
        return aNotSupport;
    }

    /**
     * 设置音频格式是否不支持
     * @param aNotSupport 音频格式是否不支持
     */
    public void setANotSupport(Boolean aNotSupport) {
        this.aNotSupport = aNotSupport;
    }

    /**
     * 获取视频格式
     * @return 视频格式
     */
    public String getVFmt() {
        return vFmt;
    }

    /**
     * 设置视频格式
     * @param vFmt 视频格式
     */
    public void setVFmt(String vFmt) {
        this.vFmt = vFmt;
    }

    /**
     * 获取视频格式是否不支持
     * @return 视频格式是否不支持
     */
    public Boolean getVNotSupport() {
        return vNotSupport;
    }

    /**
     * 设置视频格式是否不支持
     * @param vNotSupport 视频格式是否不支持
     */
    public void setVNotSupport(Boolean vNotSupport) {
        this.vNotSupport = vNotSupport;
    }

    /**
     * 获取视频分辨率
     * @return 视频分辨率
     */
    public String getVRez() {
        return vRez;
    }

    /**
     * 设置视频分辨率
     * @param vRez 视频分辨率
     */
    public void setVRez(String vRez) {
        this.vRez = vRez;
    }

    /**
     * 获取视频帧率
     * @return 视频帧率, null if not available
     */
    public Float getFrameRate() {
        return frameRate;
    }

    /**
     * 设置视频帧率
     * @param frameRate 视频帧率, null if not available
     */
    public void setFrameRate(Float frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * 获取媒体类型
     * @return 媒体类型, 为 `StreamingApi.MEDIA_TYP__AUDIO_AND_VIDEO`, 或 `StreamingApi.MEDIA_TYP__AUDIO_ONLY` 或 `StreamingApi.MEDIA_TYP__VIDEO_ONLY`
     */
    public String getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置媒体类型
     * @param mediaTyp 媒体类型, 为 `StreamingApi.MEDIA_TYP__AUDIO_AND_VIDEO`, 或 `StreamingApi.MEDIA_TYP__AUDIO_ONLY` 或 `StreamingApi.MEDIA_TYP__VIDEO_ONLY`
     */
    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 获取音频格式
     * @return 音频格式
     */
    public String getaFmt() {
        return aFmt;
    }

    /**
     * 设置音频格式
     * @param aFmt 音频格式
     */
    public void setaFmt(String aFmt) {
        this.aFmt = aFmt;
    }

    /**
     * 获取音频格式是否不支持
     * @return 音频格式是否不支持
     */
    public Boolean getaNotSupport() {
        return aNotSupport;
    }

    /**
     * 设置音频格式是否不支持
     * @param aNotSupport 音频格式是否不支持
     */
    public void setaNotSupport(Boolean aNotSupport) {
        this.aNotSupport = aNotSupport;
    }

    /**
     * 获取视频格式
     * @return 视频格式
     */
    public String getvFmt() {
        return vFmt;
    }

    /**
     * 设置视频格式
     * @param vFmt 视频格式
     */
    public void setvFmt(String vFmt) {
        this.vFmt = vFmt;
    }

    /**
     * 获取视频格式是否不支持
     * @return 视频格式是否不支持
     */
    public Boolean getvNotSupport() {
        return vNotSupport;
    }

    /**
     * 设置视频格式是否不支持
     * @param vNotSupport 视频格式是否不支持
     */
    public void setvNotSupport(Boolean vNotSupport) {
        this.vNotSupport = vNotSupport;
    }

    /**
     * 获取视频分辨率
     * @return 视频分辨率
     */
    public String getvRez() {
        return vRez;
    }

    /**
     * 设置视频分辨率
     * @param vRez 视频分辨率
     */
    public void setvRez(String vRez) {
        this.vRez = vRez;
    }

    /**
     * 获取跟踪级别
     * @return 跟踪级别, 为 `OpenStrmReq.TRACE_MODE__xxx` 常量之一
     */
    public Integer getTrace() {
        return trace;
    }

    /**
     * 设置跟踪级别
     * @param trace 跟踪级别, 为 `OpenStrmReq.TRACE_MODE__xxx` 常量之一
     */
    public void setTrace(Integer trace) {
        this.trace = trace;
    }

    /**
     * 获取跟踪级别
     * @return 跟踪级别, 为 `OpenStrmReq.TRACE_MODE__xxx` 常量之一
     */
    public int traceDef() {
        if (trace != null)
            return trace;
        else
            return OpenStrmReq.TRACE_MODE__DISABLED;
    }

    /**
     * 获取请求状态
     * @return 请求状态
     */
    public StrmReqStatus[] getRequests() {
        return requests;
    }

    /**
     * 设置请求状态
     * @param requests 请求状态
     */
    public void setRequests(StrmReqStatus[] requests) {
        this.requests = requests;
    }

    /**
     * 判断是否存在指定请求ID的请求
     * @param reqId 请求ID
     * @return 是否存在指定请求ID的请求
     */
    public boolean hasReq(String reqId) {
        if (requests != null) {
            for (StrmReqStatus r : requests)
                if (r.getReqId().equals(reqId))
                    return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "StrmStatus{" +
                "appId='" + appId + '\'' +
                ", initReqId='" + initReqId + '\'' +
                ", simNo='" + simNo + '\'' +
                ", chanId=" + chanId +
                ", live=" + live +
                ", liveDataTyp=" + liveDataTyp +
                ", codeStrm=" + codeStrm +
                ", createTm=" + createTm +
                ", srcDetectTm=" + srcDetectTm +
                ", ready=" + ready +
                ", readyTm=" + readyTm +
                ", closeTm=" + closeTm +
                ", recv=" + recv +
                ", byteRate=" + byteRate +
                ", sent=" + sent +
//                ", sendRate=" + sendRate +
                ", sendToClnt=" + sendToClnt +
                ", aFmt='" + aFmt + '\'' +
                ", aNotSupport=" + aNotSupport +
                ", vFmt='" + vFmt + '\'' +
                ", vNotSupport=" + vNotSupport +
                ", vRez='" + vRez + '\'' +
                ", frameRate=" + frameRate +
                ", mediaTyp='" + mediaTyp + '\'' +
                ", trace=" + trace +
                ", requests=" + Arrays.toString(requests) +
                '}';
    }
}
