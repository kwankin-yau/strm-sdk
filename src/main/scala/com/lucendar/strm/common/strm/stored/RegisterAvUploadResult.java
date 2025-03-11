/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.net.InetSocketAddress;
import java.util.StringJoiner;

/**
 * 注册终端音视频上传结果
 */
public class RegisterAvUploadResult {

    private String reqId;
    private String ip;
    private int port;
    private String path;
    private String user;
    private String pwd;
    private String urlPrefix;

    /**
     * 构造函数
     */
    public RegisterAvUploadResult() {
    }

    /**
     * 构造函数
     * @param reqId 音视频上传请求ID
     * @param ip FTP服务器IP地址
     * @param port FTP服务器端口号
     * @param path 音视频文件路径
     * @param user FTP用户名
     * @param pwd FTP密码
     * @param urlPrefix FTP通知的回调URL前缀
     */
    public RegisterAvUploadResult(
            String reqId,
            String ip,
            int port,
            String path,
            String user,
            String pwd,
            String urlPrefix) {
        this.reqId = reqId;
        this.ip = ip;
        this.port = port;
        this.path = path;
        this.user = user;
        this.pwd = pwd;
        this.urlPrefix = urlPrefix;
    }

    /**
     * 取音视频上传请求ID。
     * Get the ID of A/V upload request.
     *
     * @return 音视频上传请求ID。 the ID of A/V upload request.
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置音视频上传请求ID。
     * Set the ID of A/V upload request.
     *
     * @param reqId 音视频上传请求ID。 the ID of A/V upload request.
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取FTP服务器IP地址。
     * Get the IP of FTP server.
     *
     * @return 服务器IP地址。 the IP of FTP server.
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置FTP服务器IP地址。
     * Set the IP of FTP server.
     *
     * @param ip 服务器IP地址。 the IP of FTP server.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 取FTP服务器端口号。
     * Get the port of FTP service.
     *
     * @return 端口号。 the port of FTP service.
     */
    public int getPort() {
        return port;
    }

    /**
     * 设置FTP服务器端口号。
     * Set the port of FTP service.
     *
     * @param port 端口号。 the port of FTP service.
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 取音视频文件路径。
     * Get the file upload path.
     *
     * @return 音视频文件路径。 the file upload path.
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置音视频文件路径。
     * Set the file upload path.
     *
     * @param path 音视频文件路径。 the file upload path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取FTP用户名。
     * Get the FTP username used for A/V upload.
     *
     * @return 用户名。 the FTP username used for A/V upload.
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置FTP用户名。
     * Set the FTP username used for A/V upload.
     *
     * @param user 用户名。 the FTP username used for A/V upload.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 取FTP密码。
     * Get the FTP password used for A/V upload.
     *
     * @return 密码。 the FTP password used for A/V upload.
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置FTP密码。
     * Set the FTP password used for A/V upload.
     *
     * @param pwd 密码。 the FTP password used for A/V upload.
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 取FTP通知的回调URL前缀。
     * Get the base callback url of FTP notification.
     *
     * @return 回调URL前缀。 the base callback url of FTP notification.
     */
    public String getUrlPrefix() {
        return urlPrefix;
    }

    /**
     * 设置FTP通知的回调URL前缀。
     * Set the base callback url of FTP notification.
     *
     * @param urlPrefix 回调URL前缀。 the base callback url of FTP notification.
     */
    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }

    /**
     * 将FTP地址转换为InetSocketAddress对象。
     * Convert the FTP address to an InetSocketAddress object.
     *
     * @return InetSocketAddress对象。 the InetSocketAddress object.
     */
    public InetSocketAddress toSocketAddress() {
        return new InetSocketAddress(ip, port);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegisterAvUploadResult.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("ip='" + ip + "'")
                .add("port=" + port)
                .add("path='" + path + "'")
                .add("user='" + user + "'")
                .add("pwd='" + pwd + "'")
                .add("urlPrefix='" + urlPrefix + "'")
                .toString();
    }
}
