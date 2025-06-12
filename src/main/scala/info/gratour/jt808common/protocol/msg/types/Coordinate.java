package info.gratour.jt808common.protocol.msg.types;

import java.util.Objects;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jtcommon.JTUtils;

/**
 * 坐标（经纬度）
 */
@Expose
public class Coordinate implements Cloneable {

    private double lng;
    private double lat;

    /**
     * 构造函数
     */
    public Coordinate() {
    }

    /**
     * 构造函数
     * @param lng 经度
     * @param lat 纬度
     */
    public Coordinate(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

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
     * 取经度字符串
     * @return 经度字符串
     */
    public String lngStr() {
        return JTUtils.formatAxis(lng);
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
     * 取纬度字符串
     * @return 纬度字符串
     */
    public String latStr() {
        return JTUtils.formatAxis(lat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.lng, lng) == 0 &&
                Double.compare(that.lat, lat) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lng, lat);
    }

    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "POINT (" + lng +
                ", " + lat +
                ')';
    }
}
