/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 音视频资源
 */
@Expose
public class JT1078AvRes {

    /**
     * 音视频通道
     */
    public static final int MEDIA_TYPE__AV = 0;

    /**
     * 音频通道
     */
    public static final int MEDIA_TYPE__A = 1;

    /**
     * 视频通道
     */
    public static final int MEDIA_TYPE__V = 2;

    /**
     * 音频或视频通道
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
    public static final int STORAGE__ALL = 0;

    /**
     * 主存储器
     */
    public static final int STORAGE__PRIMARY = 1;

    /**
     * 备份存储器
     */
    public static final int STORAGE__BACKUP = 2;

    private byte chan;
    private long startTm;
    private long endTm;
    private int almSt808;
    private int almSt1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private long fileSz;
    private String path;
    private String fileName;

    /**
     * 取逻辑通道号
     *
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
     *
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
     * @return 结束时间, epoch millis
     */
    public long endTm() {
        return this.endTm;
    }

    /**
     * 设置结束时间
     * @param value 结束时间, epoch millis
     */
    public void endTm(long value) {
        this.endTm = value;
    }

    /**
     * 取808报警标志位
     * @return 808报警标志位
     */
    public int almStat808() {
        return almSt808;
    }

    /**
     * 设置808报警标志位
     * @param value 808报警标志位
     */
    public void almState808(int value) {
        this.almSt808 = value;
    }

    /**
     * 取1078报警标志位
     * @return 1078报警标志位
     */
    public int almState1078() {
        return almSt1078;
    }

    /**
     * 设置1078报警标志位
     * @param value 1078报警标志位
     */
    public void almState1078(int value) {
        this.almSt1078 = value;
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
        return this.codeStrm;
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
        return this.stgTyp;
    }

    /**
     * 设置存储器类型
     * @param value 存储器类型
     */
    public void stgTyp(int value) {
        this.stgTyp = (byte) value;
    }

    /**
     * 取文件大小
     * @return 文件大小
     */
    public long fileSz() {
        return fileSz;
    }

    /**
     * 设置文件大小
     * @param value 文件大小
     */
    public void fileSz(long value) {
        this.fileSz = value;
    }

    /**
     * 取文件路径
     * @return 文件路径
     */
    public String path() {
        return path;
    }

    /**
     * 设置文件路径
     * @param value 文件路径
     */
    public void path(String value) {
        this.path = value;
    }

    /**
     * 取文件名
     * @return 文件名
     */
    public String fileName() {
        return fileName;
    }

    /**
     * 设置文件名
     * @param value 文件名
     */
    public void fileName(String value) {
        this.fileName = value;
    }


    /**
     * 取逻辑通道号
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
     * @return 结束时间, epoch millis
     */
    public long getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间
     * @param endTm 结束时间, epoch millis
     */
    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    /**
     * 取808报警标志位
     * @return 808报警标志位
     */
    public int getAlmSt808() {
        return almSt808;
    }

    /**
     * 设置808报警标志位
     * @param almSt808 808报警标志位
     */
    public void setAlmSt808(int almSt808) {
        this.almSt808 = almSt808;
    }

    /**
     * 取1078报警标志位
     * @return 1078报警标志位
     */
    public int getAlmSt1078() {
        return almSt1078;
    }

    /**
     * 设置1078报警标志位
     * @param almSt1078 1078报警标志位
     */
    public void setAlmSt1078(int almSt1078) {
        this.almSt1078 = almSt1078;
    }

    /**
     * 取报警标志位
     * @return 报警标志位
     */
    public long almSt() {
        long r = almSt1078;
        r <<= 32;
        r |= almSt808;
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
     * 取文件大小
     * @return 文件大小
     */
    public long getFileSz() {
        return fileSz;
    }

    /**
     * 设置文件大小
     * @param fileSz 文件大小
     */
    public void setFileSz(long fileSz) {
        this.fileSz = fileSz;
    }

    /**
     * 取文件路径
     * @return 文件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件路径
     * @param path 文件路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取文件名
     * @return 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT1078AvRes source) {
        this.chan = source.chan;
        this.startTm = source.startTm;
        this.endTm = source.endTm;
        this.almSt808 = source.almSt808;
        this.almSt1078 = source.almSt1078;
        this.mediaTyp = source.mediaTyp;
        this.codeStrm = source.codeStrm;
        this.stgTyp = source.stgTyp;
        this.fileSz = source.fileSz;
        this.path = source.path;
        this.fileName = source.fileName;
    }

    @Override
    public JT1078AvRes clone() {
        JT1078AvRes r = new JT1078AvRes();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078AvRes.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("almSt808=" + almSt808)
                .add("almSt1078=" + almSt1078)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .add("fileSz=" + fileSz)
                .add("path='" + path + "'")
                .add("fileName='" + fileName + "'")
                .toString();
    }
}
