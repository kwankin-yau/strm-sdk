/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;
import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 卫星定位超速报警
 */
@Expose
public class AdasOverSpdAlmAddt extends AdasAddt implements Cloneable {


    /**
     * 标志：报警开始
     */
    public static final byte FLAG__START = 1;

    /**
     * 标志：报警结束
     */
    public static final byte FLAG__END = 2;

    /**
     * 标志：报警持续
     */
    public static final byte FLAG__CONTINUOUS = 3;

    /**
     * 超过阈值速度报警标志位
     */
    public static final byte BIT__OVER_EQUIP_SPEED_LIMIT = 0;
    /**
     * 超过道路速度报警标志位
     */
    public static final byte BIT__OVER_ROAD_SPEED_LIMIT = 1;

    private byte flag;
    private short typ;
    private byte overSpdAlmTyp;
    private short termSpdThold;
    private short rdSpdThold;

    public AdasOverSpdAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取报警状态
     * @return 报警状态
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * 设置报警状态
     * @param flag 报警状态
     */
    public void setFlag(byte flag) {
        this.flag = flag;
    }

    /**
     * 取是否报警开始
     * @return 是否报警开始
     */
    public boolean flagIsStart() {
        return flag == FLAG__START;
    }


    /**
     * 取事件类型
     *
     * @return 事件类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置事件类型
     * @param typ 事件类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 取超速报警类型，以各 `BIT__xxx` 位是否置位表示
     * @return 超速报警类型，以各 `BIT__xxx` 位是否置位表示
     */
    public byte getOverSpdAlmTyp() {
        return overSpdAlmTyp;
    }

    /**
     * 设置超速报警类型，以各 `BIT__xxx` 位是否置位表示
     * @param overSpdAlmTyp 超速报警类型，以各 `BIT__xxx` 位是否置位表示
     */
    public void setOverSpdAlmTyp(byte overSpdAlmTyp) {
        this.overSpdAlmTyp = overSpdAlmTyp;
    }

    /**
     * 取终端设定的超速报警阈值，单位：km/h
     * @return 终端设定的超速报警阈值，单位：km/h
     */
    public short getTermSpdThold() {
        return termSpdThold;
    }

    /**
     * 设置终端设定的超速报警阈值，单位：km/h
     * @param termSpdThold 终端设定的超速报警阈值，单位：km/h
     */
    public void setTermSpdThold(short termSpdThold) {
        this.termSpdThold = termSpdThold;
    }

    /**
     * 取车辆当前速度超出报警阈值的插值，单位：km/h
     * @return 车辆当前速度超出报警阈值的插值，单位：km/h
     */
    public short getRdSpdThold() {
        return rdSpdThold;
    }

    /**
     * 设置车辆当前速度超出报警阈值的插值，单位：km/h
     * @param rdSpdThold 车辆当前速度超出报警阈值的插值，单位：km/h
     */
    public void setRdSpdThold(short rdSpdThold) {
        this.rdSpdThold = rdSpdThold;
    }

    @Override
    public AdasOverSpdAlmAddt clone() {
        try {
            return (AdasOverSpdAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasOverSpdAlmAddt.class.getSimpleName() + "[", "]")
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("overSpdAlmTyp=" + overSpdAlmTyp)
                .add("termSpdThold=" + termSpdThold)
                .add("rdSpdThold=" + rdSpdThold)
                .add("adasDialect=" + adasDialect)
                .add("almId=" + almId)
                .add("spd=" + spd)
                .add("alt=" + alt)
                .add("lat=" + lat)
                .add("lng=" + lng)
                .add("tm=" + tm)
                .add("vehSt=" + vehSt)
                .add("almNo='" + almNo + "'")
                .toString();
    }
}
