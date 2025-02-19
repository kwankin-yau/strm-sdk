package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;

/**
 * 超速附加信息
 */
@Expose
public class OverSpdAddt implements Cloneable {

    private byte typ;
    private int areaId;

    /**
     * 位置类型：未指定
     */
    public static final byte TYP__UNSPECIFIED = 0;

    /**
     * 位置类型：圆形区域
     */
    public static final byte TYP__CIRCLE_AREA = 1;

    /**
     * 位置类型：矩形区域
     */
    public static final byte TYP__RECTANGLE_AREA = 2;

    /**
     * 位置类型：多边形区域
     */
    public static final byte TYP__POLYGON_AREA = 3;

    /**
     * 位置类型：路段
     */
    public static final byte TYP__ROAD_SECTION = 4;

    /**
     * 取位置类型
     * @return 位置类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置超速附加信息类型
     * @param typ 超速附加信息类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 取区域ID
     * @return 区域ID
     */
    public int getAreaId() {    
        return areaId;
    }

    /**
     * 设置区域ID
     * @param areaId 区域ID
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public OverSpdAddt clone() {
        try {
            return (OverSpdAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "OverSpdAddt{" +
                "typ=" + typ +
                ", areaId=" + areaId +
                '}';
    }
}
