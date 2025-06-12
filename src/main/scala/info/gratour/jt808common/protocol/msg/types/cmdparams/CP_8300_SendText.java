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
import info.gratour.jtcommon.JTUtils;

/**
 * 文本信息下发消息(0x8300)命令参数
 */
@JTMsgId(JT808MsgConsts.SEND_TEXT_8300)
@Expose
public class CP_8300_SendText implements JT808CmdParams {

    /**
     * 紧急消息
     */
    public static final int BIT__EMERGE = 0;

    /**
     * 显示消息
     */
    public static final int BIT__DISPLAY = 2;

    /**
     * 语音播报
     */
    public static final int BIT__TTS = 3;

    /**
     * 广告
     */
    public static final int BIT__ADVERT = 4;

    /**
     * 车辆故障
     */
    public static final int BIT__CAN_FAULT = 5;

    /**
     * 标志位掩码：紧急消息
     */
    public static final int BIT_MASK__EMERGE = 1;

    /**
     * 标志位掩码：显示消息
     */
    public static final int BIT_MASK__DISPLAY = 1 << 2;

    /**
     * 标志位掩码：语音播报
     */
    public static final int BIT_MASK__TTS = 1 << 3;

    /**
     * 标志位掩码：广告
     */
    public static final int BIT_MASK__ADVERT = 1 << 4;

    /**
     * 标志位掩码：车辆故障
     */
    public static final int BIT_MASK__CAN_FAULT = 1 << 5;

    private byte opts;
    private byte typ;
    private String text;

    /**
     * 获取标志位
     * @return 标志位
     */
    public byte getOpts() {
        return opts;
    }

    /**
     * 设置标志位
     * @param opts 标志位
     */
    public void setOpts(byte opts) {
        this.opts = opts;
    }

    /**
     * 设置类型
     * @param opts 类型
     */
    public void setOpts(int opts) {
        this.opts = (byte) opts;
    }

    /**
     * 获取类型
     * @return 类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置类型
     * @param typ 类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 获取文本
     * @return 文本
     */
    public String getText() {
        return text;
    }

    /**
     * 设置文本
     * @param text 文本
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 是否紧急消息
     * @return 是否紧急消息
     */
    public boolean isEmerge() {
        return JTUtils.test(opts, BIT__EMERGE);
    }

    /**
     * 设置是否紧急消息
     * @param emerge 是否紧急消息
     */
    public void setEmerge(boolean emerge) {
        if (emerge)
            opts = (byte) JTUtils.set(opts, BIT__EMERGE);
        else
            opts = (byte) JTUtils.clear(opts, BIT__EMERGE);
    }

    /**
     * 是否显示消息
     * @return 是否显示消息
     */
    public boolean isDisplay() {
        return JTUtils.test(opts, BIT__DISPLAY);
    }

    /**
     * 获取标志位掩码：车辆故障
     * @return 标志位掩码：车辆故障
     */
    public static int getBitMask_canFault() {
        return BIT_MASK__CAN_FAULT;
    }

    @Override
    public String toString() {
        return "CP_8300_SendText{" +
                "opts=" + opts +
                ", typ=" + typ +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public CP_8300_SendText clone() {
        try {
            return (CP_8300_SendText) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
