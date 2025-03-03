/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 远程录像回放(0x9201)指令参数
 */
@JTMsgId(JT1078MsgConsts.REPLAY_AV_REQ_9201)
@Expose
public class CP_9201_ReplayAvReq implements JT808CmdParams {

    /**
     * 音视频类型
     */
    public static final int MEDIA_TYPE__AV = 0;

    /**
     * 音频类型
     */
    public static final int MEDIA_TYPE__AUDIO = 1;

    /**
     * 视频类型
     */
    public static final int MEDIA_TYPE__VIDEO = 2;

    /**
     * 音频或视频类型
     */
    public static final int MEDIA_TYPE__A_OR_V = 3;

    /**
     * 所有码流
     */
    public static final byte CODE_STREAM__ALL = 0;

    /**
     * 主码流
     */
    public static final byte CODE_STREAM__PRIMARY = 1;

    /**
     * 子码流
     */
    public static final byte CODE_STREAM__SUB = 2;

    /**
     * 所有存储器
     */
    public static final byte STORAGE_TYPE__ALL = 0;

    /**
     * 主存储器
     */
    public static final byte STORAGE_TYPE__PRIMARY = 1;

    /**
     * 从存储器
     */
    public static final byte STORAGE_TYPE__SECONDARY = 2;

    /**
     * 正常回放
     */
    public static final byte MODE__NORMAL = 0;

    /**
     * 快进
     */
    public static final byte MODE__FAST_FORWARD = 1;

    /**
     * 快退
     */
    public static final byte MODE__KEY_FRAME_BACKWARD = 2;

    /**
     * 关键帧播放
     */
    public static final byte MODE__KEY_FRAME_PLAY = 3;

    /**
     * 上传单帧
     */
    public static final byte MODE__UPLOAD_SINGLE_FRAME = 4;



    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private int tcpPort2019;
    private int udpPort2019;
    private byte chan;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private byte mode;
    private Byte factor;
    private long startTm;
    private Long endTm;
    private int debug;
    private String serverId;

    /**
     * 取服务器IP地址
     * @return 服务器IP地址
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 设置服务器IP地址
     * @param serverIp 服务器IP地址
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * 取TCP端口号
     *
     * @return TCP端口号
     */
    public int getTcpPort() {
        return tcpPort;
    }

    /**
     * 设置TCP端口号
     * @param tcpPort TCP端口号
     */
    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    /**
     * 取UDP端口号
     * @return UDP端口号
     */
    public int getUdpPort() {
        return udpPort;
    }

    /**
     * 设置UDP端口号
     * @param udpPort UDP端口号
     */
    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    /**
     * 取2019协议的TCP端口号
     * @return 2019协议的TCP端口号
     */
    public int getTcpPort2019() {
        return tcpPort2019;
    }

    /**
     * 设置2019协议的TCP端口号
     * @param tcpPort2019 2019协议的TCP端口号
     */
    public void setTcpPort2019(int tcpPort2019) {
        this.tcpPort2019 = tcpPort2019;
    }

    /**
     * 取2019协议的UDP端口号
     * @return 2019协议的UDP端口号
     */
    public int getUdpPort2019() {
        return udpPort2019;
    }

    /**
     * 设置2019协议的UDP端口号
     * @param udpPort2019 2019协议的UDP端口号
     */
    public void setUdpPort2019(int udpPort2019) {
        this.udpPort2019 = udpPort2019;
    }


    /**
     * 取通道号
     *
     * @return 通道号
     */
    public byte getChan() {
        return chan;
    }

    /**
     * 设置通道号
     *
     * @param chan 通道号
     */
    public void setChan(byte chan) {
        this.chan = chan;
    }

    /**
     * 取音视频类型
     * @return 音视频类型
     */
    public byte getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置音视频类型
     * @param mediaTyp 音视频类型
     */
    public void setMediaTyp(byte mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 取码流
     * @return 码流
     */
    public byte getCodeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流
     * @param codeStrm 码流
     */
    public void setCodeStrm(byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    /**
     * 取存储器类型
     * @return 存储器类型
     */
    public byte getStgTyp() {
        return stgTyp;
    }

    /**
     * 设置存储器类型
     * @param stgTyp 存储器类型
     */
    public void setStgTyp(byte stgTyp) {
        this.stgTyp = stgTyp;
    }

    /**
     * 取回放方式
     * @return 回放方式
     */
    public byte getMode() {
        return mode;
    }

    /**
     * 设置回放方式
     * @param mode 回放方式
     */
    public void setMode(byte mode) {
        this.mode = mode;
    }

    /**
     * 取快进或快退倍数
     * @return 快进或快退倍数。仅当回放方式为3或4时不为 null
     */
    public Byte getFactor() {
        return factor;
    }

    /**
     * 设置快进或快退倍数
     * @param factor 快进或快退倍数。仅当回放方式为3或4时不为 null
     */
    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    /**
     * 取开始时间
     * @return 开始时间, epoch millis
     */
    public long getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间
     * @param startTm 开始时间, epoch millis
     */
    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    /**
     * 取结束时间
     * @return 结束时间
     */
    public Long getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间
     * @param endTm 结束时间
     */
    public void setEndTm(Long endTm) {
        this.endTm = endTm;
    }

    /**
     * 取调试标志
     * @return 调试标志
     */
    public int getDebug() {
        return debug;
    }

    /**
     * 设置调试标志
     * @param debug 调试标志
     */
    public void setDebug(int debug) {
        this.debug = debug;
    }

    /**
     * 取服务器ID
     * @return 服务器ID
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * 设置服务器ID
     * @param serverId 服务器ID
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * 取服务器IP地址
     * @return 服务器IP地址
     */
    public String serverIp() {
        return serverIp;
    }

    /**
     * 设置服务器IP地址
     * @param value 服务器IP地址
     */
    public void serverIp(String value) {
        this.serverIp = value;
    }

    /**
     * 取TCP端口号
     * @return TCP端口号
     */
    public int tcpPort() {
        return tcpPort;
    }

    /**
     * 设置TCP端口号
     * @param value TCP端口号
     */
    public void tcpPort(int value) {
        this.tcpPort = value;
    }

    /**
     * 取2019协议的TCP端口号
     * @return 2019协议的TCP端口号
     */
    public int tcpPort2019() {
        return tcpPort2019;
    }

    /**
     * 设置2019协议的TCP端口号
     * @param value 2019协议的TCP端口号
     */
    public void tcpPort2019(int value) {
        this.tcpPort2019 = value;
    }

    /**
     * 取UDP端口号
     * @return UDP端口号
     */
    public int udpPort() {
        return udpPort;
    }

    /**
     * 设置UDP端口号
     * @param value UDP端口号
     */
    public void udpPort(int value) {
        this.udpPort = value;
    }

    /**
     * 取2019协议的UDP端口号
     * @return 2019协议的UDP端口号
     */
    public int udpPort2019() {
        return udpPort2019;
    }

    /**
     * 设置2019协议的UDP端口号
     * @param value 2019协议的UDP端口号
     */
    public void udpPort2019(int value) {
        this.udpPort2019 = value;
    }

    /**
     * 取通道号
     * @return 通道号
     */
    public int chan() {
        return chan;
    }

    /**
     * 设置通道号
     * @param value 通道号
     */
    public void chan(int value) {
        this.chan = (byte) value;
    }

    /**
     * 取音视频类型
     * @return 音视频类型
     */
    public int mediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置音视频类型
     * @param value 音视频类型
     */
    public void mediaTyp(int value) {
        this.mediaTyp = (byte) value;
    }

    /**
     * 取码流
     * @return 码流
     */
    public int codeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流
     * @param value 码流
     */
    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    /**
     * 取存储器类型
     * @return 存储器类型
     */
    public int stgTyp() {
        return stgTyp;
    }

    /**
     * 设置存储器类型
     * @param value 存储器类型
     */
    public void stgTyp(int value) {
        this.stgTyp = (byte) value;
    }

    /**
     * 取回放方式
     * @return 回放方式
     */
    public int mode() {
        return mode;
    }

    /**
     * 设置回放方式
     * @param value 回放方式
     */
    public void mode(int value) {
        this.mode = (byte) value;
    }

    /**
     * 取快进或快退倍数
     * @return 快进或快退倍数。仅当回放方式为3或4时不为 null
     */
    public int factorDef(){
        if (factor != null)
            return factor;
        else
            return 0;
    }

    /**
     * 设置快进或快退倍数
     * @param value 快进或快退倍数。仅当回放方式为3或4时不为 null
     */
    public void factor(int value) {
        this.factor = (byte) value;
    }

    /**
     * 取开始时间
     * @return 开始时间, epoch millis
     */
    public long startTm() {
        return startTm;
    }

    /**
     * 设置开始时间
     * @param value 开始时间, epoch millis
     */
    public void startTm(long value) {
        this.startTm = value;
    }

    /**
     * 取结束时间
     * @return 结束时间
     */
    public long endTimeDef() {
        if (endTm != null)
            return endTm;
        else
            return 0L;
    }

    /**
     * 设置结束时间
     * @param value 结束时间
     */
    public void endTime(long value) {
        this.endTm = value;
    }

    /**
     * 取调试标志
     * @return 调试标志
     */
    public int debug() {
        return debug;
    }

    /**
     * 设置调试标志
     * @param value 调试标志
     */
    public void debug(int value) {
        this.debug = value;
    }

    /**
     * 取服务器ID
     * @return 服务器ID
     */
    public String serverId() {
        return serverId;
    }

    /**
     * 设置服务器ID
     * @param value 服务器ID
     */
    public void serverId(String value) {
        this.serverId = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9201_ReplayAvReq.class.getSimpleName() + "[", "]")
                .add("serverIp='" + serverIp + "'")
                .add("tcpPort=" + tcpPort)
                .add("udpPort=" + udpPort)
                .add("tcpPort2019=" + tcpPort2019)
                .add("udpPort2019=" + udpPort2019)
                .add("chan=" + chan)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("mode=" + mode)
                .add("factor=" + factor)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("debug=" + debug)
                .add("serverId='" + serverId + "'")
                .toString();
    }

    @Override
    public CP_9201_ReplayAvReq clone() {
        try {
            return (CP_9201_ReplayAvReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
