/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 卫星定位超速报警
 */
public class AdasOverSpdAlmAddt extends AdasAddt implements Cloneable {


    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;
    public static final byte FLAG__CONTINUOUS = 3;

    public static final byte BIT__OVER_EQUIP_SPEED_LIMIT = 0;
    public static final byte BIT__OVER_ROAD_SPEED_LIMIT = 1;

    private byte flag;
    private short typ;
    private byte overSpdAlmTyp;
    private short termSpdThold;
    private short rdSpdThold;

    public AdasOverSpdAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public boolean flagIsStart() {
        return flag == FLAG__START;
    }


    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public byte getOverSpdAlmTyp() {
        return overSpdAlmTyp;
    }

    public void setOverSpdAlmTyp(byte overSpdAlmTyp) {
        this.overSpdAlmTyp = overSpdAlmTyp;
    }

    public short getTermSpdThold() {
        return termSpdThold;
    }

    public void setTermSpdThold(short termSpdThold) {
        this.termSpdThold = termSpdThold;
    }

    public short getRdSpdThold() {
        return rdSpdThold;
    }

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
