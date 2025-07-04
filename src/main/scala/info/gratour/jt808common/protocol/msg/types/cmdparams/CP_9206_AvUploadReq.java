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
 * 录像文件上传指令参数
 */
@JTMsgId(JT1078MsgConsts.AV_UPLOAD_REQ_9206)
@Expose
public class CP_9206_AvUploadReq implements JT808CmdParams {

    /**
     * 音视频资源类型
     */
    public static final int MEDIA_TYPE__AV = 0;

    /**
     * 音频资源类型
     */
    public static final int MEDIA_TYPE__A = 1;

    /**
     * 视频资源类型
     */
    public static final int MEDIA_TYPE__V = 2;

    /**
     * 音频或视频资源类型
     */
    public static final int MEDIA_TYPE__A_OR_V = 3;

    /**
     * 所有码流
     */
    public static final int CODE_STREAM__ALL = 0;

    /**
     * 主码流
     */
    public static final int CODE_STREAM__PRIMARY = 1;

    /**
     * 子码流
     */
    public static final int CODE_STREAM__SUB = 2;

    /**
     * 所有存储器
     */
    public static final int STORAGE_TYPE__ALL = 0;

    /**
     * 主存储器
     */
    public static final int STORAGE_TYPE__PRIMARY = 1;

    /**
     * 备份存储器
     */
    public static final int STORAGE_TYPE__BACKUP = 2;

    private String ftpHost;
    private int ftpPort;
    private String ftpUser;
    private String ftpPwd;
    private String uploadPath;


    private byte chan;
    private long startTm;
    private long endTm;
    private Integer almFilter808;
    private Integer almFilter1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private byte when;

    /**
     * 取服务器地址
     * @return 服务器地址
     */
    public String getFtpHost() {
        return ftpHost;
    }

    /**
     * 设置服务器地址
     * @param ftpHost 服务器地址
     */
    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    /**
     * 取FTP端口号
     * @return FTP端口号
     */
    public int getFtpPort() {
        return ftpPort;
    }

    /**
     * 设置FTP端口号
     * @param ftpPort FTP端口号
     */
    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    /**
     * 取FTP用户名
     * @return FTP用户名
     */
    public String getFtpUser() {
        return ftpUser;
    }

    /**
     * 设置FTP用户名
     * @param ftpUser FTP用户名
     */
    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    /**
     * 取FTP密码
     * @return FTP密码
     */
    public String getFtpPwd() {
        return ftpPwd;
    }

    /**
     * 设置FTP密码
     * @param ftpPwd FTP密码
     */
    public void setFtpPwd(String ftpPwd) {
        this.ftpPwd = ftpPwd;
    }

    /**
     * 取文件上传路径
     * @return 文件上传路径
     */
    public String getUploadPath() {
        return uploadPath;
    }

    /**
     * 设置文件上传路径
     * @param uploadPath 文件上传路径
     */
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    /**
     * 取逻辑通道号
     *
     * @return 逻辑通道号
     */
    public byte getChan() {
        return chan;
    }

    /**
     * 设置逻辑通道号
     * @param chan 逻辑通道号
     */
    public void setChan(byte chan) {
        this.chan = chan;
    }

    /**
     * 取开始时间
     * @return 开始时间，epoch millis
     */
    public long getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间
     * @param startTm 开始时间，epoch millis
     */
    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    /**
     * 取结束时间
     * @return 结束时间，epoch millis
     */
    public long getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间
     * @param endTm 结束时间，epoch millis
     */
    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    /**
     * 取808报警标志位
     * @return 808报警标志位
     */
    public Integer getAlmFilter808() {
        return almFilter808;
    }

    /**
     * 设置808报警标志位
     * @param almFilter808 808报警标志位
     */
    public void setAlmFilter808(Integer almFilter808) {
        this.almFilter808 = almFilter808;
    }

    /**
     * 取808报警标志位
     * @return 808报警标志位
     */
    @Deprecated
    public int almSt808() {
        if (almFilter808 != null)
            return almFilter808;
        else
            return 0;
    }

    /**
     * 取1078报警标志位
     * @return 1078报警标志位
     */
    public Integer getAlmFilter1078() {
        return almFilter1078;
    }

    /**
     * 设置1078报警标志位
     * @param almFilter1078 1078报警标志位
     */
    public void setAlmFilter1078(Integer almFilter1078) {
        this.almFilter1078 = almFilter1078;
    }

    /**
     * 取1078报警标志位
     * @return 1078报警标志位
     */
    @Deprecated
    public int almSt1078() {
        if (almFilter1078 != null)
            return almFilter1078;
        else
            return 0;
    }

    /**
     * 取报警状态(808报警标志位和1078报警标志位)
     * @return 报警状态
     */
    @Deprecated
    public long almState() {
        int st808 = almSt808();

        long r = almSt1078();
        r <<= 32;
        r |= st808;

        return r;
    }

    /**
     * 取音视频资源类型
     * @return 音视频资源类型
     */
    public byte getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置音视频资源类型
     * @param mediaTyp 音视频资源类型
     */
    public void setMediaTyp(byte mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 取码流类型
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
     * 取执行条件
     * @return 执行条件
     */
    public byte getWhen() {
        return when;
    }

    /**
     * 设置执行条件
     * @param when 执行条件
     */
    public void setWhen(byte when) {
        this.when = when;
    }

    /**
     * 取FTP服务器地址
     * @return FTP服务器地址
     */
    public String ftpHost() {
        return ftpHost;
    }

    /**
     * 设置FTP服务器地址
     * @param value FTP服务器地址
     */
    public void ftpHost(String value) {
        this.ftpHost = value;
    }

    /**
     * 取FTP端口号
     * @return FTP端口号
     */
    public int ftpPort() {
        return ftpPort;
    }

    /**
     * 设置FTP端口号
     * @param value FTP端口号
     */
    public void ftpPort(int value) {
        this.ftpPort = value;
    }

    /**
     * 取FTP用户名
     * @return FTP用户名
     */
    public String ftpUser() {
        return ftpUser;
    }

    /**
     * 设置FTP用户名
     * @param value FTP用户名
     */
    public void ftpUser(String value) {
        this.ftpUser = value;
    }

    /**
     * 取FTP密码
     * @return FTP密码
     */
    public String ftpPwd() {
        return ftpPwd;
    }

    /**
     * 设置FTP密码
     * @param value FTP密码
     */
    public void ftpPwd(String value) {
        this.ftpPwd = value;
    }

    /**
     * 取文件上传路径
     * @return 文件上传路径
     */
    public String uploadPath() {
        return uploadPath;
    }

    /**
     * 设置文件上传路径
     * @param value 文件上传路径
     */
    public void uploadPath(String value) {
        this.uploadPath = value;
    }

    /**
     * 取逻辑通道号
     * @return 逻辑通道号
     */
    public int chan() {
        return chan;
    }

    /**
     * 设置逻辑通道号
     * @param value 逻辑通道号
     */
    public void chan(int value) {
        this.chan = (byte) value;
    }

    /**
     * 取开始时间
     * @return 开始时间，epoch millis
     */
    public long startTm() {
        return startTm;
    }

    /**
     * 设置开始时间
     * @param value 开始时间，epoch millis
     */
    public void startTm(long value) {
        this.startTm = value;
    }

    /**
     * 取结束时间
     * @return 结束时间，epoch millis
     */
    public long endTm() {
        return endTm;
    }

    /**
     * 设置结束时间
     * @param value 结束时间，epoch millis
     */
    public void endTm(long value) {
        this.endTm = value;
    }

    /**
     * 取808报警标志位
     * @return 808报警标志位
     */
    public int almFilter808Def() {
        if (almFilter808 != null)
            return almFilter808;
        else
            return 0;
    }

    /**
     * 设置808报警标志位
     * @param value 808报警标志位
     */
    public void almFilter808(int value) {
        this.almFilter808 = value;
    }

    /**
     * 取1078报警标志位
     * @return 1078报警标志位
     */
    public int almFilter1078Def() {
        if (almFilter1078 != null)
            return almFilter1078;
        else
            return 0;
    }

    /**
     * 设置1078报警标志位
     * @param value 1078报警标志位
     */
    public void almFilter1078(int value) {
        this.almFilter1078 = value;
    }

    /**
     * 取报警状态(808报警标志位和1078报警标志位)
     * @return 报警状态
     */
    public long almFilterLong() {
        long r = almFilter1078Def();
        r <<= 32;
        r |= almFilter808Def();

        return r;
    }

    /**
     * 设置报警状态(808报警标志位和1078报警标志位)
     * @param value 报警状态
     */
    public void almFilterLong(long value) {
        long t = value >>> 32;
        almFilter1078 = (int)(t);
        almFilter808 = (int) (value & 0xFFFF_FFFFL);
    }

    /**
     * 取音视频资源类型
     * @return 音视频资源类型
     */
    public int mediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置音视频资源类型
     * @param value 音视频资源类型
     */
    public void mediaTyp(int value) {
        this.mediaTyp = (byte) value;
    }

    /**
     * 取码流类型
     * @return 码流类型
     */
    public int codeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流类型
     * @param value 码流类型
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
     * 取执行条件
     * @return 执行条件
     */
    public int when() {
        return when;
    }

    /**
     * 设置执行条件
     * @param value 执行条件
     */
    public void when(int value) {
        this.when = (byte) value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9206_AvUploadReq.class.getSimpleName() + "[", "]")
                .add("ftpHost='" + ftpHost + "'")
                .add("ftpPort=" + ftpPort)
                .add("ftpUser='" + ftpUser + "'")
                .add("ftpPwd='" + ftpPwd + "'")
                .add("uploadPath='" + uploadPath + "'")
                .add("chan=" + chan)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("almFilter808=" + almFilter808)
                .add("almFilter1078=" + almFilter1078)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("when=" + when)
                .toString();
    }

    @Override
    public CP_9206_AvUploadReq clone() {
        try {
            return (CP_9206_AvUploadReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
