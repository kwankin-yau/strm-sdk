/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common;

import java.util.Locale;

import info.gratour.jtcommon.JTUtils;

/**
 * 终端状态位操作
 */
public class JT808StateBits {

    private int stateBits;

    /**
     * 获取终端状态位
     * @return 终端状态位
     */
    public int getStateBits() {
        return stateBits;
    }

    /**
     * 设置终端状态位
     * @param stateBits 终端状态位
     */
    public void setStateBits(int stateBits) {
        this.stateBits = stateBits;
    }

    /**
     * 测试终端状态位
     * @param bit 终端状态位
     * @return 是否设置
     */
    public boolean test(JT808StateBit bit) {
        return JTUtils.test(stateBits, bit.bitIndex());
    }

    /**
     * 测试终端状态位
     * @param bitIndex 终端状态位索引
     * @return 是否设置
     */
    public boolean test(int bitIndex) {
        return JTUtils.test(stateBits, bitIndex);
    }

    /**
     * 设置终端状态位
     * @param bit 终端状态位
     * @return 终端状态位
     */
    public JT808StateBits set(JT808StateBit bit) {
        stateBits = JTUtils.set(stateBits, bit.bitIndex());
        return this;
    }

    /**
     * 设置终端状态位
     * @param bitIndex 终端状态位索引
     * @return 终端状态位
     */
    public JT808StateBits set(int bitIndex) {
        stateBits = JTUtils.set(stateBits, bitIndex);
        return this;
    }

    /**
     * 清除终端状态位
     * @param bit 终端状态位
     * @return 终端状态位
     */
    public JT808StateBits clear(JT808StateBit bit) {
        stateBits = JTUtils.clear(stateBits, bit.bitIndex());
        return this;
    }

    /**
     * 清除终端状态位
     * @param bitIndex 终端状态位索引
     * @return 终端状态位
     */
    public JT808StateBits clear(int bitIndex) {
        stateBits = JTUtils.clear(stateBits, bitIndex);
        return this;
    }

    /**
     * 获取终端状态文本
     * @param locale 区域
     * @return 终端状态文本
     */
    public String getStateText(Locale locale) {
        return JT808StateBit.vehStateText(stateBits, locale);
    }

    /**
     * 终端状态位：北斗+ACC ON+已定位
     */
    public static final JT808StateBits ACC_ON_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.ACC_ON).set(JT808StateBit.LOCATED);

    /**
     * 终端状态位：北斗+ACC OFF+已定位
     */
    public static final JT808StateBits ACC_OFF_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.LOCATED);

    /**
     * 终端状态位：北斗+已定位
     */
    public static final JT808StateBits BEIDOU_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.LOCATED);

    @Override
    public String toString() {
        return "JT808StateBits{" +
                "stateBits=" + stateBits +
                '}';
    }
}
