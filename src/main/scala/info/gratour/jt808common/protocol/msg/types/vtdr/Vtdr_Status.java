/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 行驶记录仪状态信号配置
 */
@Expose
public class Vtdr_Status implements Cloneable {
    private byte stateWord;
    private List<String> bitDesc;

    /**
     * 取状态字
     * @return 状态字
     */
    public byte getStateWord() {
        return stateWord;
    }

    /**
     * 设置状态字
     * @param stateWord 状态字
     */
    public void setStateWord(byte stateWord) {
        this.stateWord = stateWord;
    }

    /**
     * 取状态字位描述
     * @return 状态字位描述
     */
    public List<String> getBitDesc() {
        return bitDesc;
    }

    /**
     * 设置状态字位描述
     * @param bitDesc 状态字位描述
     */
    public void setBitDesc(List<String> bitDesc) {
        this.bitDesc = bitDesc;
    }

    /**
     * 添加状态字位描述
     * @param bitDesc 状态字位描述
     */
    public void addBitDesc(String bitDesc) {
        if (this.bitDesc == null)
            this.bitDesc = new ArrayList<>();
        this.bitDesc.add(bitDesc);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_Status source) {
        this.stateWord = source.stateWord;
        if (source.bitDesc != null) {
            this.bitDesc = new ArrayList<>();
            this.bitDesc.addAll(source.bitDesc);
        } else
            this.bitDesc = null;
    }

    @Override
    public Vtdr_Status clone() {
        try {
            return (Vtdr_Status) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_Status.class.getSimpleName() + "[", "]")
                .add("stateWord=" + stateWord)
                .add("bitDesc=" + bitDesc)
                .toString();
    }
}
