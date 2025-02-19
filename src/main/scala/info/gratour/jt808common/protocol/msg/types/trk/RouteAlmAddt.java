package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;

/**
 * 路线行驶时间不足/过长报警附加信息
 */
@Expose
public class RouteAlmAddt implements Cloneable {

    /**
     * 类型：行驶时间不足
     */
    public static final byte TYP__TOO_SHORT = 0;

    /**
     * 类型：行驶时间过长
     */
    public static final byte TYP__TOO_LONG = 1;

    private byte typ;
    private int tm;
    private int routeId;

    /**
     * 取类型
     * @return 类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置类型
     * @param typ 类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 取行驶时间，单位为秒
     * @return 行驶时间
     */
    public int getTm() {
        return tm;
    }

    /**
     * 设置行驶时间，单位为秒
     * @param tm 行驶时间
     */
    public void setTm(int tm) {
        this.tm = tm;
    }

    /**
     * 取路段ID
     * @return 路段ID
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * 设置路段ID
     * @param routeId 路段ID
     */
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public RouteAlmAddt clone() {
        try {
            return (RouteAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "RouteAlarmAddtInfo{" +
                "typ=" + typ +
                ", time=" + tm +
                ", routeId=" + routeId +
                '}';
    }
}
