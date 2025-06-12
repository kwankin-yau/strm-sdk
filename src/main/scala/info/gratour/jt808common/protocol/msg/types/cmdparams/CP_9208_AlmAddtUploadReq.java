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

import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 报警附件上传指令参数
 */
@JTMsgId(JTAdasMsgConsts.ALM_ATT_UPLOAD_REQ_9208)
@Expose
public class CP_9208_AlmAddtUploadReq implements JT808CmdParams {

    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private String almNo;
    private String almId;
    private long almTm1;

    /**
     * 取服务器地址
     * @return 服务器地址
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 设置服务器地址
     * @param serverIp 服务器地址
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    /**
     * 取TCP端口号
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
     * 取报警标识号
     * @return 报警标识号
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警标识号
     * @param almNo 报警标识号
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    /**
     * 取报警编号
     * @return 报警编号
     */
    public String getAlmId() {
        return almId;
    }

    /**
     * 设置报警编号
     * @param almId 报警编号
     */
    public void setAlmId(String almId) {
        this.almId = almId;
    }

    /**
     * 取报警时间
     * @return 报警时间
     */
    public long getAlmTm1() {
        return almTm1;
    }

    /**
     * 设置报警时间
     * @param almTm1 报警时间
     */
    public void setAlmTm1(long almTm1) {
        this.almTm1 = almTm1;
    }

    /**
     * 取服务器地址
     * @return 服务器地址
     */
    public String serverIp() {
        return serverIp;
    }

    /**
     * 设置服务器地址
     * @param value 服务器地址
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
     * 取报警标识号
     * @return 报警标识号
     */
    public String almNo() {
        return almNo;
    }

    /**
     * 设置报警标识号
     * @param value 报警标识号
     */
    public void almNo(String value) {
        this.almNo = value;
    }

    /**
     * 取报警编号
     * @return 报警编号
     */
    public String almId() {
        return almId;
    }

    /**
     * 设置报警编号
     * @param value 报警编号
     */
    public void almId(String value) {
        this.almId = value;
    }

    /**
     * 取报警时间
     * @return 报警时间
     */
    public long almTm1() {
        return almTm1;
    }

    /**
     * 设置报警时间
     * @param value 报警时间
     */
    public void almTm1(long value) {
        this.almTm1 = value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9208_AlmAddtUploadReq.class.getSimpleName() + "[", "]")
                .add("serverIp='" + serverIp + "'")
                .add("tcpPort=" + tcpPort)
                .add("udpPort=" + udpPort)
                .add("almNo='" + almNo + "'")
                .add("almId='" + almId + "'")
                .add("almTm1=" + almTm1)
                .toString();
    }

    @Override
    public CP_9208_AlmAddtUploadReq clone() {
        try {
            return (CP_9208_AlmAddtUploadReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
