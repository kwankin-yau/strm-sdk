/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
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
 * 智能识别系统报警（湘标）
 */
@Expose
public class AdasAiRecogAlmAddt extends AdasAddt implements Cloneable {

    /**
     * 标志：不可用（无意义）
     */
    public static final byte FLAG__NOT_AVAILABLE = 0;

    /**
     * 标志：报警开始
     */
    public static final byte FLAG__START = 1;

    /**
     * 标志：报警结束
     */
    public static final byte FLAG__END = 2;

    /**
     * 超员报警
     */
    public static final short TYP__OVERCROWDING = 1;

    /**
     * 未巡检乘客安全带（事件）
     */
    public static final short TYP__SEAT_BELT_NOT_CHECKED = 0x80;


    private byte flag;
    private short typ;
    private byte lvl;

    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasAiRecogAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取标志状态。见本类的 FLAG__xxxx 系列常量
     *
     * @return 标志状态
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * 设置标志状态
     *
     * @param flag 标志状态
     */
    public void setFlag(byte flag) {
        this.flag = flag;
    }

    /**
     * 取报警/事件类型。见本类的 TYP__ 系列常量
     *
     * @return 报警/事件类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置报警/事件类型
     *
     * @param typ 报警/事件类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 取报警级别
     *
     * @return 报警级别
     */
    public byte getLvl() {
        return lvl;
    }

    /**
     * 设置报警级别
     *
     * @param lvl 报警级别
     */
    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }

    @Override
    public AdasAiRecogAlmAddt clone() {
        try {
            return (AdasAiRecogAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasAiRecogAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("lvl=" + lvl)
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
