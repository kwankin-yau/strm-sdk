/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import java.util.Arrays;
import java.util.StringJoiner;

import info.gratour.jt808common.protocol.msg.types.JT808CanData;

/**
 * CAN 数据事件(0x0705)
 */
public class MQEventAddt_0705_CanData implements MQEventAddt {

    private JT808CanData data[];

    /**
     * 获取 CAN 数据列表
     * @return CAN 数据列表
     */
    public JT808CanData[] getData() {
        return data;
    }

    /**
     * 设置 CAN 数据列表
     * @param data CAN 数据列表
     */
    public void setData(JT808CanData[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MQEventAddt_0705_CanData.class.getSimpleName() + "[", "]")
                .add("data=" + Arrays.toString(data))
                .toString();
    }
}
