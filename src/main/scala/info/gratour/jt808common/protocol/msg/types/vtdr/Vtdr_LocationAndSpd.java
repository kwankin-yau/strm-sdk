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
 * 位置与速度信息
 */
@Expose
public class Vtdr_LocationAndSpd implements Cloneable {

    private Vtdr_Location location;
    private short spd;

    /**
     * 取位置
     * @return 位置
     */
    public Vtdr_Location getLocation() {
        return location;
    }

    /**
     * 设置位置
     * @param location 位置
     */
    public void setLocation(Vtdr_Location location) {
        this.location = location;
    }

    /**
     * 取速度, 单位: km/h
     * @return 速度
     */
    public short getSpd() {
        return spd;
    }

    /**
     * 设置速度, 单位: km/h
     * @param spd 速度
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_LocationAndSpd source) {
        this.location = source.location != null ? source.location.clone() : null;
        this.spd = source.spd;
    }

    @Override
    public Vtdr_LocationAndSpd clone() {
        try {
            return (Vtdr_LocationAndSpd) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_LocationAndSpd.class.getSimpleName() + "[", "]")
                .add("location=" + location)
                .add("spd=" + spd)
                .toString();
    }
}
