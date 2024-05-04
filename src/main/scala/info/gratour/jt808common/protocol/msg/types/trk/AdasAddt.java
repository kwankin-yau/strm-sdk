/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.AdasDialect;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * ADAS报警附加信息
 */
public abstract class AdasAddt {

    /**
     * ADAS 方言
     */
    protected final AdasDialect adasDialect;

    /**
     * 终端报警ID（序号）
     */
    protected int almId;

    /**
     * 车速, km/h
     */
    protected short spd;

    /**
     * 高程, m
     */
    protected short alt;

    /**
     * 纬度
     */
    protected double lat;

    /**
     * 经度
     */
    protected double lng;

    /**
     * 报警时间, epoch millis
     */
    protected long tm;

    /**
     * 车辆状态字
     */
    protected short vehSt;

    /**
     * 报警识别号/编号，不可为 null
     */
    protected String almNo;


    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasAddt(@NonNull AdasDialect adasDialect) {
        this.adasDialect = adasDialect;
    }

    /**
     * 取附加信息所执行的 ADAS 方言
     *
     * @return 附加信息所执行的 ADAS 方言
     */
    @NonNull
    public AdasDialect getAdasDialect() {
        return adasDialect;
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
     * 取车速
     * @return 车速, km/h
     */
    public short getSpd() {
        return spd;
    }

    /**
     * 设置车速
     * @param spd 车速, km/h
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 取高程
     *
     * @return 高程, m
     */
    public short getAlt() {
        return alt;
    }

    /**
     * 设置高程
     *
     * @param alt 高程, m
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
     * 取报警时间, epoch millis
     *
     * @return 报警时间, epoch millis
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
     * 取车辆状态字
     *
     * @return 车辆状态字
     */
    public short getVehSt() {
        return vehSt;
    }

    /**
     * 设置车辆状态字
     *
     * @param vehSt 车辆状态字
     */
    public void setVehSt(short vehSt) {
        this.vehSt = vehSt;
    }

    /**
     * 取报警识别号/编号
     *
     * @return 报警识别号/编号, HEX格式
     */
    @NonNull
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警识别号/编号
     *
     * @param almNo 报警识别号/编号, HEX格式
     */
    public void setAlmNo(@NonNull String almNo) {
        this.almNo = almNo;
    }

    /**
     * 取 ADAS 终端报警编号
     * @return ADAS 终端报警编号
     */
    @NonNull
    public String adasAlmNo() {
        return almNo;
    }


}

