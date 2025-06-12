/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端控制(0x8105)命令参数
 */
@JTMsgId(JT808MsgConsts.TERMINAL_CTRL_8105)
@Expose
public class CP_8105_TerminalCtrl implements JT808CmdParams {

    /**
     * 无线升级, REMOVED in rev-2019
     */
    public static final int CMD__WIRELESS_UPGRADE = 1;

    /**
     * 连接到指定服务器
     */
    public static final int CMD__CONNECT_TO_SPECIFIED_SERVER = 2;

    /**
     * 关机
     */
    public static final int CMD__SHUTDOWN = 3;

    /**
     * 重启, REMOVED in rev-2019
     */
    public static final int CMD__RESET = 4;

    /**
     * 恢复出厂设置
     */
    public static final int CMD__RECOVERY = 5;

    /**
     * 关闭数据通信, REMOVED in rev-2019
     */
    public static final int CMD__CLOSE_COMM = 6;

    /**
     * 关闭无线通信, REMOVED in rev-2019
     */
    public static final int CMD__CLOSE_WIRELESS_COMM = 7;

    /**
     * 从源对象复制
     * @param source 源对象
     */
    public void assignFrom(CP_8105_TerminalCtrl source) {
        this.cmd = source.cmd;
        this.params = source.params != null ? source.params.clone() : null;
    }

    @Override
    public CP_8105_TerminalCtrl clone() {
        CP_8105_TerminalCtrl r = new CP_8105_TerminalCtrl();
        r.assignFrom(this);
        return r;
    }

    /**
     * 终端控制参数接口
     */
    @Expose
    public static interface CP_8105_Params extends Cloneable {

        /**
         * 克隆
         * @return 克隆对象
         */
        CP_8105_Params clone();
    }


    private int cmd;
    private CP_8105_Params params;

    /**
     * 获取命令
     * @return 命令
     */
    public int getCmd() {
        return cmd;
    }

    /**
     * 设置命令
     * @param cmd 命令
     */
    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    /**
     * 获取参数
     * @return 参数
     */
    public CP_8105_Params getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(CP_8105_Params params) {
        this.params = params;
    }

    /**
     * 无线升级命令参数对象
     */
    @Expose
    public static class Cmd1_WirelessUpgrade implements CP_8105_Params {

        private String url;
        private String apName;
        private String apUser;
        private String apPwd;
        private String host;
        private int tcpPort;
        private int udpPort;
        private String factoryId;
        private String hardwareVer;
        private String firmwareVer;
        private int connTimeout;

        /**
         * 获取URL
         * @return URL
         */
        public String getUrl() {
            return url;
        }

        /**
         * 设置URL
         * @param url URL
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * 获取AP名称
         * @return AP名称
         */
        public String getApName() {
            return apName;
        }

        /**
         * 设置AP名称
         * @param apName AP名称
         */
        public void setApName(String apName) {
            this.apName = apName;
        }

        /**
         * 获取AP用户名
         * @return AP用户名
         */
        public String getApUser() {
            return apUser;
        }

        /**
         * 设置AP用户名
         * @param apUser AP用户名
         */
        public void setApUser(String apUser) {
            this.apUser = apUser;
        }

        /**
         * 获取AP密码
         * @return AP密码
         */
        public String getApPwd() {
            return apPwd;
        }

        /**
         * 设置AP密码
         * @param apPwd AP密码
         */
        public void setApPwd(String apPwd) {
            this.apPwd = apPwd;
        }

        /**
         * 获取主机
         * @return 主机
         */
        public String getHost() {
            return host;
        }

        /**
         * 设置主机
         * @param host 主机
         */
        public void setHost(String host) {
            this.host = host;
        }

        /**
         * 获取TCP端口
         * @return TCP端口
         */
        public int getTcpPort() {
            return tcpPort;
        }

        /**
         * 设置TCP端口
         * @param tcpPort TCP端口
         */
        public void setTcpPort(int tcpPort) {
            this.tcpPort = tcpPort;
        }

        /**
         * 获取UDP端口
         * @return UDP端口
         */
        public int getUdpPort() {
            return udpPort;
        }

        /**
         * 设置UDP端口
         * @param udpPort UDP端口
         */
        public void setUdpPort(int udpPort) {
            this.udpPort = udpPort;
        }

        /**
         * 获取工厂ID
         * @return 工厂ID
         */
        public String getFactoryId() {
            return factoryId;
        }

        /**
         * 设置工厂ID
         * @param factoryId 工厂ID
         */
        public void setFactoryId(String factoryId) {
            this.factoryId = factoryId;
        }

        /**
         * 获取硬件版本
         * @return 硬件版本
         */
        public String getHardwareVer() {
            return hardwareVer;
        }

        /**
         * 设置硬件版本
         * @param hardwareVer 硬件版本
         */
        public void setHardwareVer(String hardwareVer) {
            this.hardwareVer = hardwareVer;
        }

        /**
         * 获取固件版本
         * @return 固件版本
         */
        public String getFirmwareVer() {
            return firmwareVer;
        }

        /**
         * 设置固件版本
         * @param firmwareVer 固件版本
         */
        public void setFirmwareVer(String firmwareVer) {
            this.firmwareVer = firmwareVer;
        }

        /**
         * 获取连接超时
         * @return 连接超时
         */
        public int getConnTimeout() {
            return connTimeout;
        }

        /**
         * 设置连接超时
         * @param connTimeout 连接超时
         */
        public void setConnTimeout(int connTimeout) {
            this.connTimeout = connTimeout;
        }

        /**
         * 转换为命令参数
         * @return 命令参数
         */
        public String toCmdParams() {
            return url + ";" + apName + ";" + apUser + ";" + apPwd + ";" + host + ";"
                    + tcpPort + ";" + udpPort + ";" + factoryId + ";" + hardwareVer + ";"
                    + firmwareVer + ";" + connTimeout;
        }

        @Override
        public String toString() {
            return "Cmd1_WirelessUpgrade{" +
                    "url='" + url + '\'' +
                    ", apName='" + apName + '\'' +
                    ", apUser='" + apUser + '\'' +
                    ", apPwd='" + apPwd + '\'' +
                    ", host='" + host + '\'' +
                    ", tcpPort=" + tcpPort +
                    ", udpPort=" + udpPort +
                    ", factoryId='" + factoryId + '\'' +
                    ", hardwareVer='" + hardwareVer + '\'' +
                    ", firmwareVer='" + firmwareVer + '\'' +
                    ", connTimeout=" + connTimeout +
                    '}';
        }

        @Override
        public Cmd1_WirelessUpgrade clone() {
            try {
                return (Cmd1_WirelessUpgrade) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 连接到指定服务器命令参数对象
     */
    @Expose
    public static class Cmd2_ConnSpecialServer implements CP_8105_Params {

        private int connectCtrl;
        private String authCode;
        private String apName;
        private String apUser;
        private String apPwd;
        private String host;
        private int tcpPort;
        private int udpPort;
        private int connTime;

        /**
         * 获取连接控制
         * @return 连接控制
         */
        public int getConnectCtrl() {
            return connectCtrl;
        }

        /**
         * 设置连接控制
         * @param connectCtrl 连接控制
         */
        public void setConnectCtrl(int connectCtrl) {
            this.connectCtrl = connectCtrl;
        }

        /**
         * 获取认证码
         * @return 认证码
         */
        public String getAuthCode() {
            return authCode;
        }

        /**
         * 设置认证码
         * @param authCode 认证码
         */
        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        /**
         * 获取AP名称
         * @return AP名称
         */
        public String getApName() {
            return apName;
        }

        /**
         * 设置AP名称
         * @param apName AP名称
         */
        public void setApName(String apName) {
            this.apName = apName;
        }

        /**
         * 获取AP用户名
         * @return AP用户名
         */
        public String getApUser() {
            return apUser;
        }

        /**
         * 设置AP用户名
         * @param apUser AP用户名
         */
        public void setApUser(String apUser) {
            this.apUser = apUser;
        }

        /**
         * 获取AP密码
         * @return AP密码
         */
        public String getApPwd() {
            return apPwd;
        }

        /**
         * 设置AP密码
         * @param apPwd AP密码
         */
        public void setApPwd(String apPwd) {
            this.apPwd = apPwd;
        }

        /**
         * 获取主机
         * @return 主机
         */
        public String getHost() {
            return host;
        }

        /**
         * 设置主机
         * @param host 主机
         */
        public void setHost(String host) {
            this.host = host;
        }

        /**
         * 获取TCP端口
         * @return TCP端口
         */
        public int getTcpPort() {
            return tcpPort;
        }

        /**
         * 设置TCP端口
         * @param tcpPort TCP端口
         */
        public void setTcpPort(int tcpPort) {
            this.tcpPort = tcpPort;
        }

        /**
         * 获取UDP端口
         * @return UDP端口
         */
        public int getUdpPort() {
            return udpPort;
        }

        /**
         * 设置UDP端口
         * @param udpPort UDP端口
         */
        public void setUdpPort(int udpPort) {
            this.udpPort = udpPort;
        }

        /**
         * 获取连接时限，单位：分钟
         * @return 连接时间
         */
        public int getConnTime() {
            return connTime;
        }

        /**
         * 设置连接时限，单位：分钟
         * @param connTime 连接时限
         */
        public void setConnTime(int connTime) {
            this.connTime = connTime;
        }

        /**
         * 转换为命令参数
         * @return 命令参数
         */
        public String toCmdParams() {
            return connectCtrl + ";" + authCode + ";" + apName + ";" + apUser + ";" + apPwd + ";"
                    + host + ";" + tcpPort + ";" + udpPort + ";" + connTime
                    ;
        }

        @Override
        public String toString() {
            return "Cmd2_ConnSpecialServer{" +
                    "connectCtrl=" + connectCtrl +
                    ", authCode='" + authCode + '\'' +
                    ", apName='" + apName + '\'' +
                    ", apUser='" + apUser + '\'' +
                    ", apPwd='" + apPwd + '\'' +
                    ", host='" + host + '\'' +
                    ", tcpPort=" + tcpPort +
                    ", udpPort=" + udpPort +
                    ", connTime=" + connTime +
                    '}';
        }

        @Override
        public Cmd2_ConnSpecialServer clone() {
            try {
                return (Cmd2_ConnSpecialServer) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
