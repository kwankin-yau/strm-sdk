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
 * 行驶记录仪位置信息
 */
@Expose
public class Vtdr_Location implements Cloneable {
    private double lng;
    private double lat;
    private short alt;

    /**
     * 取经度
     * @return 经度
     */
    public double getLng() {
        return lng;
    }

    /**
     * 设置经度
     * @param lng 经度
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * 取纬度
     * @return 纬度
     */
    public double getLat() {
        return lat;
    }

    /**
     * 设置纬度
     * @param lat 纬度
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * 取海拔高度
     * @return 海拔高度
     */
    public short getAlt() {
        return alt;
    }

    /**
     * 设置海拔高度
     * @param alt 海拔高度
     */
    public void setAlt(short alt) {
        this.alt = alt;
    }

    @Override
    public Vtdr_Location clone() {
        try {
            return (Vtdr_Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_Location.class.getSimpleName() + "[", "]")
                .add("lng=" + lng)
                .add("lat=" + lat)
                .add("alt=" + alt)
                .toString();
    }
}
