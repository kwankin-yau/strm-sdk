/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * JT/T 808 协议 CAN 数据
 */
public class JT808CanData {

    private int id;

    private boolean can2;
    private boolean extFrame;
    private boolean calculated;
    private byte[] data;

    /**
     * 取 CAN 数据 ID
     * @return CAN 数据 ID
     */
    public int getId() {
        return id;
    }

    /**
     * 设置 CAN 数据 ID
     * @param id CAN 数据 ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 取 CAN 数据是否为 CAN2, false 表示 CAN1
     * @return CAN 数据是否为 CAN2
     */
    public boolean isCan2() {
        return can2;
    }

    /**
     * 设置 CAN 数据是否为 CAN2, false 表示 CAN1
     * @param can2 CAN 数据是否为 CAN2
     */
    public void setCan2(boolean can2) {
        this.can2 = can2;
    }

    /**
     * 取 CAN 数据是否为扩展帧, false 表示标准帧
     * @return CAN 数据是否为扩展帧
     */
    public boolean isExtFrame() {
        return extFrame;
    }

    /**
     * 设置 CAN 数据是否为扩展帧, false 表示标准帧
     * @param extFrame CAN 数据是否为扩展帧
     */
    public void setExtFrame(boolean extFrame) {
        this.extFrame = extFrame;
    }

    /**
     * 取 CAN 数据是否为计算平均值, false 为原始数据
     * @return CAN 数据是否为计算平均值
     */
    public boolean isCalculated() {
        return calculated;
    }

    /**
     * 设置 CAN 数据是否为计算平均值, false 为原始数据
     * @param calculated CAN 数据是否为计算平均值
     */
    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    /**
     * 取 CAN 数据
     * @return CAN 数据
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 设置 CAN 数据
     * @param data CAN 数据
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808CanData.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("can2=" + can2)
                .add("extFrame=" + extFrame)
                .add("calculated=" + calculated)
                .add("data=" + Arrays.toString(data))
                .toString();
    }
}
