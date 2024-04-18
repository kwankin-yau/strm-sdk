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

public class RegisterAvUploadResult {

    private String reqId;
    private String ip;
    private int port;
    private String path;
    private String user;
    private String pwd;
    private String urlPrefix;

    public RegisterAvUploadResult() {
    }

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
     * Get the ID of A/V upload request.
     *
     * @return the ID of A/V upload request.
     */
    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * Get the IP of FTP server.
     *
     * @return the IP of FTP server.
     */
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Get the port of FTP service.
     *
     * @return the port of FTP service.
     */
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Get the file upload path.
     *
     * @return the file upload path.
     */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the FTP username used for A/V upload.
     *
     * @return the FTP username used for A/V upload.
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Get the FTP password used for A/V upload.
     *
     * @return the FTP password used for A/V upload.
     */
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }

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
