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
 * 音视频传输请求指令参数。参数的具体意义，请参阅 JT/T 1078 文本的指令部分
 */
@JTMsgId(JT1078MsgConsts.LIVE_AV_REQ_9101)
@Expose
public class CP_9101_LiveAvReq implements JT808CmdParams {

    /**
     * 数据类型：音视频
     */
    public static final byte DATA_TYPE__AV = 0;

    /**
     * 数据类型：视频
     */
    public static final byte DATA_TYPE__VIDEO = 1;

    /**
     * 数据类型：对讲
     */
    public static final byte DATA_TYPE__TALK = 2;

    /**
     * 数据类型：监听
     */
    public static final byte DATA_TYPE__LISTEN = 3;

    /**
     * 数据类型：广播
     */
    public static final byte DATA_TYPE__BROADCAST = 4;

    /**
     * 数据类型：透传
     */
    public static final byte DATA_TYPE__PASS_THOUGH = 5;

    /**
     * 码流：主码流
     */
    public static final byte CODE_STREAM__PRIMARY = 0;

    /**
     * 码流：子码流
     */
    public static final byte CODE_STREAM__SUB = 1;

    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private int tcpPort2019;
    private int udpPort2019;
    private byte chan;
    private Byte dataTyp;
    private Byte codeStrm;
    private int debug;
    private String serverId;

    /**
     * 取服务器IP地址
     *
     * @return 服务器IP地址
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 设置服务器IP地址
     *
     * @param serverIp 服务器IP地址
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * 取2013协议的TCP端口号
     *
     * @return 2013协议的TCP端口号
     */
    public int getTcpPort() {
        return tcpPort;
    }

    /**
     * 设置2013协议的TCP端口号
     * @param tcpPort 2013协议的TCP端口号
     */
    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    /**
     * 取2013协议的UDP端口号
     * @return 2013协议的UDP端口号
     */
    public int getUdpPort() {
        return udpPort;
    }

    /**
     * 设置2013协议的UDP端口号
     * @param udpPort 2013协议的UDP端口号
     */
    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    /**
     * 取2019协议的TCP端口号
     * @return  2019协议的TCP端口号
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
     * @param chan 通道号
     */
    public void setChan(byte chan) {
        this.chan = chan;
    }

    /**
     * 取数据类型
     *
     * @return 数据类型
     */
    public Byte getDataTyp() {
        return dataTyp;
    }

    /**
     * 设置数据类型
     * @param dataTyp 数据类型
     */
    public void setDataTyp(Byte dataTyp) {
        this.dataTyp = dataTyp;
    }

    /**
     * 取码流
     *
     * @return 码流
     */
    public Byte getCodeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流
     * @param codeStrm 码流
     */
    public void setCodeStrm(Byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    /**
     * 获取数据类型默认值
     * @return 数据类型默认值
     */
    public byte getDataTypeDef() {
        if (dataTyp != null)
            return dataTyp;
        else
            return DATA_TYPE__AV;
    }

    /**
     * 获取码流默认值
     * @return 码流默认值
     */
    public byte getCodeStreamDef() {
        if (codeStrm != null)
            return codeStrm;
        else
            return CODE_STREAM__PRIMARY;
    }

    /**
     * 获取调试标志
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
     * 获取服务器ID
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
     * 获取服务器IP地址
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
     * 获取2013协议的TCP端口号
     * @return 2013协议的TCP端口号
     */
    public int tcpPort() {
        return tcpPort;
    }

    /**
     * 设置2013协议的TCP端口号
     * @param value 2013协议的TCP端口号
     */
    public void tcpPort(int value) {
        this.tcpPort = value;
    }

    /**
     * 获取2019协议的TCP端口号
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
     * 获取2013协议的UDP端口号
     * @return 2013协议的UDP端口号
     */
    public int udpPort() {
        return udpPort;
    }

    /**
     * 设置2013协议的UDP端口号
     * @param value 2013协议的UDP端口号
     */
    public void udpPort(int value) {
        this.udpPort = value;
    }

    /**
     * 获取2019协议的UDP端口号
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
     * 获取通道号
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
     * 获取数据类型默认值
     * @return 数据类型默认值
     */
    public int dataTypDef() {
        if (dataTyp != null)
            return dataTyp;
        else
            return DATA_TYPE__AV;
    }

    /**
     * 设置数据类型
     * @param value 数据类型
     */
    public void dataTyp(int value) {
        this.dataTyp = (byte) value;
    }

    /**
     * 获取码流默认值
     * @return 码流默认值
     */
    public int codeStrmDef() {
        if (codeStrm != null)
            return codeStrm;
        else
            return CODE_STREAM__PRIMARY;
    }

    /**
     * 设置码流
     * @param value 码流
     */
    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    /**
     * 获取调试标志
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
        this.debug = debug;
    }

    /**
     * 获取服务器ID
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
        return new StringJoiner(", ", CP_9101_LiveAvReq.class.getSimpleName() + "[", "]")
                .add("serverIp='" + serverIp + "'")
                .add("tcpPort=" + tcpPort)
                .add("udpPort=" + udpPort)
                .add("tcpPort2019=" + tcpPort2019)
                .add("udpPort2019=" + udpPort2019)
                .add("chan=" + chan)
                .add("dataTyp=" + dataTyp)
                .add("codeStrm=" + codeStrm)
                .add("debug=" + debug)
                .add("serverId='" + serverId + "'")
                .toString();
    }

    @Override
    public CP_9101_LiveAvReq clone() {
        try {
            return (CP_9101_LiveAvReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
