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
 * 盲区监测系统报警附加信息
 */
public class AdasBlindAreaAlmAddt extends AdasAddt implements Cloneable {

    /**
     * 标志：不可用
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
     * 报警类型：后方接近报警
     */
    public static final byte TYP__REAR_TOO_CLOSE = 1;

    /**
     * 报警类型：左侧后方接近报警
     */
    public static final byte TYP__LEFT_REAR_TOO_CLOSE = 2;

    /**
     * 报警类型：右侧后方接近报警
     */
    public static final byte TYP__RIGHT_REAR_TOO_CLOSE = 3;

    /**
     * 报警类型：不能识别或厂商自定义报警/事件类型
     */
    public static final byte TYP__CUSTOM = (byte) 0xFF;


    private byte flag;
    private short typ;

    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasBlindAreaAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取标志状态
     *
     * @return 标志状态，为 FLAG__ 系列常量之一
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * 设置标志状态
     *
     * @param flag 标志状态，为 FLAG__ 系列常量之一
     */
    public void setFlag(byte flag) {
        this.flag = flag;
    }

    /**
     * 返回标志状态是否不可用或报警开始，即非结束
     *
     * @return 标志状态是否不可用或报警开始，即非结束
     */
    public boolean flagIsStartOrNA() {
        return flag == FLAG__NOT_AVAILABLE || flag == FLAG__START;
    }

    /**
     * 取报警/事件类型
     *
     * @return 报警/事件类型，为 TYP__ 系列常量之一
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置报警/事件类型
     *
     * @param typ 报警/事件类型，为 TYP__ 系列常量之一
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    @Override
    public AdasBlindAreaAlmAddt clone() {
        try {
            return (AdasBlindAreaAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasBlindAreaAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
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
