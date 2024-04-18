/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 智能识别系统报警（湘标）
 */
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

    private int almId;
    private byte flag;
    private short typ;
    private byte lvl;
    private short spd;
    private short alt;
    private double lat;
    private double lng;
    private long tm;
    private short vehSt;
    private String almNo;

    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasAiRecogAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取报警ID
     *
     * @return 报警ID
     */
    public int getAlmId() {
        return almId;
    }

    /**
     * 设置报警ID
     *
     * @param almId 报警ID
     */
    public void setAlmId(int almId) {
        this.almId = almId;
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

    /**
     * 取车速，km/h
     *
     * @return 车速
     */
    public short getSpd() {
        return spd;
    }

    /**
     * 设置车速
     *
     * @param spd 车速，km/h
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 取高程。单位：m
     *
     * @return 高程
     */
    public short getAlt() {
        return alt;
    }

    /**
     * 设置高程
     *
     * @param alt 高程，单位：m
     */
    public void setAlt(short alt) {
        this.alt = alt;
    }

    /**
     * 取纬度。
     *
     * @return 纬度
     */
    public double getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * 取经度
     *
     * @return 经度
     */
    public double getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * 取报警、事件发生时间. epoch millis
     *
     * @return 报警、事件发生时间
     */
    public long getTm() {
        return tm;
    }

    /**
     * 设置报警、事件发生时间
     *
     * @param tm 报警、事件发生时间，epoch millis
     */
    public void setTm(long tm) {
        this.tm = tm;
    }

    /**
     * 取车辆状态。详见湘标规范
     *
     * @return 车辆状态
     */
    public short getVehSt() {
        return vehSt;
    }

    /**
     * 设置车辆状态
     *
     * @param vehSt 车辆状态
     */
    public void setVehSt(short vehSt) {
        this.vehSt = vehSt;
    }

    /**
     * 取报警识别号
     *
     * @return 报警识别号
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警识别号
     *
     * @param almNo 报警识别号
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
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
