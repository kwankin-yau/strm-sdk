/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 车辆外部供电记录
 */
@Expose
public class Vtdr_PowerEvent implements Cloneable {

    /**
     * 事件类型：供电
     */
    public static final int TYP_POWER_ON = 1;

    /**
     * 事件类型：断电
     */
    public static final int TYP_POWER_OFF = 2;

    private String time;
    private byte typ;

    /**
     * 取事件时间, yyyy-MM-dd HH:mm:ss
     * @return 事件时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置事件时间, yyyy-MM-dd HH:mm:ss
     * @param time 事件时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 取事件类型
     * @return 事件类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置事件类型
     * @param typ 事件类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    @Override
    public Vtdr_PowerEvent clone() {
        try {
            return (Vtdr_PowerEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_PowerEvent.class.getSimpleName() + "[", "]")
                .add("time='" + time + "'")
                .add("typ=" + typ)
                .toString();
    }
}
