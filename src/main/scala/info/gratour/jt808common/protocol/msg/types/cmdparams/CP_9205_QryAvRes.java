/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;
import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

/**
 * 查询音视频资源列表指令参数
 */
@JTMsgId(JT1078MsgConsts.QRY_AV_RES_9205)
@Expose
public class CP_9205_QryAvRes implements JT808CmdParams {

    private byte chan;
    private Long startTm;
    private Long endTm;
    private Integer almFilter808;
    private Integer almFilter1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;


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
     * 取开始时间，epoch millis
     * @return 开始时间，epoch millis
     */
    public Long getStartTm() {
        return startTm;
    }

    /**
     * 设置开始时间，epoch millis
     * @param startTm 开始时间，epoch millis
     */
    public void setStartTm(Long startTm) {
        this.startTm = startTm;
    }

    /**
     * 取结束时间，epoch millis
     * @return 结束时间，epoch millis
     */
    public Long getEndTm() {
        return endTm;
    }

    /**
     * 设置结束时间，epoch millis
     * @param endTm 结束时间，epoch millis
     */
    public void setEndTm(Long endTm) {
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

    public void setAlarmState(long almState) {
        this.almFilter808 = (int) almState;
        almState >>>= 32;
        this.almFilter1078 = (int) almState;
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

    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
    }

    public int almFilter808() {
        return almFilter808 != null ? almFilter808 : 0;
    }

    public void almFilter808(int value) {
        this.almFilter808 = value;
    }

    public int almFilter1078() {
        return almFilter1078 != null ? almFilter1078 : 0;
    }

    public void almFilter1078(int value) {
        this.almFilter1078 = value;
    }

    public long almFilterLong() {
        long r = almFilter1078;
        r <<= 32;
        r |= almFilter808;

        return r;
    }

    public void almFilterLong(long value) {
        long t = value >>> 32;
        this.almFilter1078 = (int) t;
        this.almFilter808 = (int) (value & 0xFFFF_FFFFL);
    }

    public int mediaTyp() {
        return mediaTyp;
    }

    public void mediaTyp(int value) {
        this.mediaTyp = (byte) value;
    }

    public int codeStrm() {
        return codeStrm;
    }

    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    public int stgTyp() {
        return stgTyp;
    }

    public void stgTyp(int value) {
        this.stgTyp = (byte) value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9205_QryAvRes.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("startTm=" + startTm)
                .add("endTm=" + endTm)
                .add("almFilter808=" + almFilter808)
                .add("almFilter1078=" + almFilter1078)
                .add("mediaTyp=" + mediaTyp)
                .add("codeStrm=" + codeStrm)
                .add("stgTyp=" + stgTyp)
                .toString();
    }

    @Override
    public CP_9205_QryAvRes clone() {
        try {
            return (CP_9205_QryAvRes) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
