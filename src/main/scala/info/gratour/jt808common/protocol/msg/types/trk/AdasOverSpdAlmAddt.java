/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.AdasDialect;

/**
 * 卫星定位超速报警
 */
@Expose
public class AdasOverSpdAlmAddt extends AdasAddt implements Cloneable {


    /**
     * 标志位：开始报警
     */
    public static final byte FLAG__START = 1;

    /**
     * 标志位：结束报警
     */
    public static final byte FLAG__END = 2;

    /**
     * 标志位：持续报警
     */
    public static final byte FLAG__CONTINUOUS = 3;

    /**
     * 报警类型：超设备限速
     */
    public static final byte BIT__OVER_EQUIP_SPEED_LIMIT = 0;

    /**
     * 报警类型：超道路限速
     */
    public static final byte BIT__OVER_ROAD_SPEED_LIMIT = 1;

    private byte flag;
    private short typ;
    private byte overSpdAlmTyp;
    private short termSpdThold;
    private short rdSpdThold;

    /**
     * 构造函数
     * @param adasDialect ADAS方言
     */
    public AdasOverSpdAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }


    /**
     * 取报警标志位
     * @return 报警标志位
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * 设置报警标志位
     * @param flag 报警标志位
     */
    public void setFlag(byte flag) {
        this.flag = flag;
    }

    /**
     * 判断是否开始报警
     * @return 是否开始报警
     */
    public boolean flagIsStart() {
        return flag == FLAG__START;
    }

    /**
     * 取报警类型。以位掩码表示。见 `BIT__xxx` 常量。
     * @return 报警类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置报警类型
     * @param typ 报警类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 取超速报警类型
     * @return 超速报警类型
     */
    public byte getOverSpdAlmTyp() {
        return overSpdAlmTyp;
    }

    /**
     * 设置超速报警类型
     * @param overSpdAlmTyp 超速报警类型
     */
    public void setOverSpdAlmTyp(byte overSpdAlmTyp) {
        this.overSpdAlmTyp = overSpdAlmTyp;
    }

    /**
     * 取终端限速阈值
     * @return 终端限速阈值
     */
    public short getTermSpdThold() {
        return termSpdThold;
    }

    /**
     * 设置终端限速阈值
     * @param termSpdThold 终端限速阈值
     */
    public void setTermSpdThold(short termSpdThold) {
        this.termSpdThold = termSpdThold;
    }

    /**
     * 取道路限速阈值
     * @return 道路限速阈值
     */
    public short getRdSpdThold() {
        return rdSpdThold;
    }

    /**
     * 设置道路限速阈值
     * @param rdSpdThold 道路限速阈值
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
