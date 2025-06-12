/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端鉴权消息 (0x0102)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_AUTH_0102)
public class JT808Msg_0102_TerminalAuth extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_AUTH_0102;

    /**
     * 构造函数
     */
    public JT808Msg_0102_TerminalAuth() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0102_TerminalAuth(JT808FrameHeader header) {
        super(header);
    }

    private String authCode;
    private String imei;
    private String softwareVer;

    /**
     * 获取鉴权码
     * 
     * @return 鉴权码
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * 设置鉴权码
     * 
     * @param authCode 鉴权码
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * 获取IMEI
     * 
     * @return IMEI
     */
    public String getImei() {
        return imei;
    }

    /**
     * 设置IMEI
     * 
     * @param imei IMEI
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * 获取固件版本
     * 
     * @return 固件版本
     */
    public String getSoftwareVer() {
        return softwareVer;
    }

    /**
     * 设置固件版本
     * 
     * @param softwareVer 固件版本
     */
    public void setSoftwareVer(String softwareVer) {
        this.softwareVer = softwareVer;
    }

    @Override
    public String toString() {
        return "JT808Msg_0102_TerminalAuth{" +
                "authCode='" + authCode + '\'' +
                ", imei='" + imei + '\'' +
                ", softwareVer='" + softwareVer + '\'' +
                '}';
    }
}
