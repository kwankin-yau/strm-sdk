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

    private int almId;
    private byte flag;
    private short typ;
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
    public AdasBlindAreaAlmAddt(AdasDialect adasDialect) {
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

    /**
     * 取车速
     *
     * @return 车速, km/h
     */
    public short getSpd() {
        return spd;
    }

    /**
     * 设置车速
     *
     * @param spd 车速, km/h
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 取高程
     *
     * @return 高程, 单位：m
     */
    public short getAlt() {
        return alt;
    }

    /**
     * 设置高程
     *
     * @param alt 高程, 单位：m
     */
    public void setAlt(short alt) {
        this.alt = alt;
    }

    /**
     * 取纬度
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
     * 取报警时间
     *
     * @return 报警时间，epoch millis
     */
    public long getTm() {
        return tm;
    }

    /**
     * 设置报警时间
     *
     * @param tm 报警时间, epoch millis
     */
    public void setTm(long tm) {
        this.tm = tm;
    }

    /**
     * 取车辆状态
     *
     * @return 车辆状态（原始协议数据）
     */
    public short getVehSt() {
        return vehSt;
    }

    /**
     * 设置车辆状态
     *
     * @param vehSt 车辆状态（原始协议数据）
     */
    public void setVehSt(short vehSt) {
        this.vehSt = vehSt;
    }

    /**
     * 取报警标识号
     *
     * @return 报警标识号，HEX格式
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警标识号
     *
     * @param almNo 报警标识号，HEX格式
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
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
