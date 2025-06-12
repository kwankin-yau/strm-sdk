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
 * 拍照(0x8801)命令参数
 */
@JTMsgId(JT808MsgConsts.TAKE_PHOTO_8801)
@Expose
public class CP_8801_TakePhoto implements JT808CmdParams {

    private byte channel;
    private short cmd;
    private Short count;
    private Short interval;
    private Byte save;
    private Byte resolution;
    private Byte quality;
    private Byte brightness;
    private Byte contrast;
    private Byte saturability;
    private Byte chroma;

    /**
     * 获取通道
     * @return 通道
     */
    public byte getChannel() {
        return channel;
    }

    /**
     * 设置通道
     * @param channel 通道
     */
    public void setChannel(byte channel) {
        this.channel = channel;
    }

    /**
     * 获取命令
     * @return 命令
     */
    public short getCmd() {
        return cmd;
    }

    /**
     * 设置命令
     * @param cmd 命令
     */
    public void setCmd(short cmd) {
        this.cmd = cmd;
    }

    /**
     * 获取数量
     * @return 数量
     */
    public Short getCount() {
        return count;
    }

    /**
     * 设置数量
     * @param count 数量
     */
    public void setCount(Short count) {
        this.count = count;
    }

    /**
     * 获取拍照间隔/录像时间，秒
     * @return 拍照间隔/录像时间
     */
    public Short getInterval() {
        return interval;
    }

    /**
     * 设置拍照间隔/录像时间，秒
     * @param interval 拍照间隔/录像时间
     */
    public void setInterval(Short interval) {
        this.interval = interval;
    }

    /**
     * 获取是否保存
     * @return 是否保存
     */
    public Byte getSave() {
        return save;
    }

    /**
     * 设置是否保存
     * @param save 是否保存
     */
    public void setSave(Byte save) {
        this.save = save;
    }

    /**
     * 获取分辨率
     * @return 分辨率
     */
    public Byte getResolution() {
        return resolution;
    }

    /**
     * 设置分辨率
     * @param resolution 分辨率
     */
    public void setResolution(Byte resolution) {
        this.resolution = resolution;
    }

    /**
     * 获取质量
     * @return 质量
     */
    public Byte getQuality() {
        return quality;
    }

    /**
     * 设置质量
     * @param quality 质量
     */
    public void setQuality(Byte quality) {
        this.quality = quality;
    }

    /**
     * 获取亮度
     * @return 亮度
     */
    public Byte getBrightness() {
        return brightness;
    }

    /**
     * 设置亮度
     * @param brightness 亮度
     */
    public void setBrightness(Byte brightness) {
        this.brightness = brightness;
    }

    /**
     * 获取对比度
     * @return 对比度
     */
    public Byte getContrast() {
        return contrast;
    }

    /**
     * 设置对比度
     * @param contrast 对比度
     */
    public void setContrast(Byte contrast) {
        this.contrast = contrast;
    }

    /**
     * 获取饱和度
     * @return 饱和度
     */
    public Byte getSaturability() {
        return saturability;
    }

    /**
     * 设置饱和度
     * @param saturability 饱和度
     */
    public void setSaturability(Byte saturability) {
        this.saturability = saturability;
    }

    /**
     * 获取色度
     * @return 色度
     */
    public Byte getChroma() {
        return chroma;
    }

    /**
     * 设置色度
     * @param chroma 色度
     */
    public void setChroma(Byte chroma) {
        this.chroma = chroma;
    }

    @Override
    public String toString() {
        return "CP_8801_TakePhoto{" +
                "channel=" + channel +
                ", cmd=" + cmd +
                ", count=" + count +
                ", interval=" + interval +
                ", save=" + save +
                ", resolution=" + resolution +
                ", quality=" + quality +
                ", brightness=" + brightness +
                ", contrast=" + contrast +
                ", saturability=" + saturability +
                ", chroma=" + chroma +
                '}';
    }

    @Override
    public CP_8801_TakePhoto clone() {
        try {
            return (CP_8801_TakePhoto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
