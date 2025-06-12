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

/**
 * 透传上行事件(0x0900)
 */
public class MQEventAddt_0900_PassThroughUl implements MQEventAddt {

    private byte typ;
    private byte[] data;

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
     * 获取数据
     * @return 数据
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 设置数据
     * @param data 数据
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MQEventAddt_0900_PassThroughUl.class.getSimpleName() + "[", "]")
                .add("typ=" + typ)
                .add("data=" + Arrays.toString(data))
                .toString();
    }
}
