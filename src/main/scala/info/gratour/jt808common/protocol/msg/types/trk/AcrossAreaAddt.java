package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;

import java.util.StringJoiner;

/**
 * 进出区域/路线报警附加信息
 */
@Expose
public class AcrossAreaAddt implements Cloneable {

    /**
     * 进入区域标志，为 `dir` 属性的值之一
     */
    public static final int DIR__ENTER = 0;

    /**
     * 离开区域标志，为 `dir` 属性的值之一
     */
    public static final int DIR__LEAVE = 1;

    private byte dir;
    private byte typ;
    private int areaId;

    /**
     * 取车辆方向标志。值域：`DIR__ENTER`, `DIR__LEAVE`
     *
     * @return 车辆方向标志
     */
    public byte getDir() {
        return dir;
    }

    /**
     * 设置车辆方向标志。
     *
     * @param dir 车辆方向标志。值域：`DIR__ENTER`, `DIR__LEAVE`
     */
    public void setDir(byte dir) {
        this.dir = dir;
    }

    /**
     * 是否进入区域
     *
     * @return 是否进入区域
     */
    public boolean isEnter() {
        return dir == DIR__ENTER;
    }

    /**
     * 是否离开区域
     *
     * @return 离开区域
     */
    public boolean isLeave() {
        return dir == DIR__LEAVE;
    }

    /**
     * 取位置类型。
     * 1 - 圆形区域
     * 2 - 矩形区域
     * 3 - 多边形区域
     * 4 - 路线
     *
     * @return 位置类型。
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置位置类型。
     *
     * @param typ 位置类型。
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 取区域ID
     *
     * @return 区域ID
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * 设置区域ID
     *
     * @param areaId 区域ID
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public AcrossAreaAddt clone() {
        try {
            return (AcrossAreaAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AcrossAreaAddt.class.getSimpleName() + "[", "]")
                .add("dir=" + dir)
                .add("typ=" + typ)
                .add("areaId=" + areaId)
                .toString();
    }
}
