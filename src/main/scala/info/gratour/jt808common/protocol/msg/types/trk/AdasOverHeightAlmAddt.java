package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 限高报警附件信息
 */
public class AdasOverHeightAlmAddt extends AdasAddt implements Cloneable {

    /**
     * 标志：报警开始
     */
    public static final byte FLAG__START = 1;
    /**
     * 标志：报警结束
     */
    public static final byte FLAG__END = 2;
    /**
     * 标志：报警持续
     */
    public static final byte FLAG__CONTINUOUSLY = 3;

    /**
     * 超过限定高度报警
     */
    public static final byte TYP__OVER_HEIGHT = 1;

    private byte flag;
    private byte typ;
    private byte vehHeight;
    private byte heightRestriction;

    /**
     * 构造函数
     * @param adasDialect ADAS 方言
     */
    public AdasOverHeightAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取标志状态。见本类的 FLAG__ 系列常量
     *
     * @return 标志状态
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
     * 取报警/事件类型。见本类的 TYP__ 系列常量
     *
     * @return 报警/事件类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置报警/事件类型
     *
     * @param typ 报警/事件类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 取车身高度, 单位：毫米
     *
     * @return 车身高度, 单位：毫米
     */
    public byte getVehHeight() {
        return vehHeight;
    }

    /**
     * 设置车身高度, 单位：毫米
     *
     * @param vehHeight 车身高度, 单位：毫米
     */
    public void setVehHeight(byte vehHeight) {
        this.vehHeight = vehHeight;
    }

    /**
     * 取道路限高，单位：毫米
     *
     * @return 道路限高，单位：毫米
     */
    public byte getHeightRestriction() {
        return heightRestriction;
    }

    /**
     * 设置道路限高，单位：毫米
     *
     * @param heightRestriction 道路限高，单位：毫米
     */
    public void setHeightRestriction(byte heightRestriction) {
        this.heightRestriction = heightRestriction;
    }

    @Override
    public AdasOverHeightAlmAddt clone() {
        try {
            return (AdasOverHeightAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * To string, received by a StringJoiner.
     *
     * @param joiner The StringJoiner used to receive the fields.
     */
    public void toString(StringJoiner joiner) {
        joiner.add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("vehHeight=" + vehHeight)
                .add("heightRestriction=" + heightRestriction)
                .add("spd=" + spd)
                .add("alt=" + alt)
                .add("lat=" + lat)
                .add("lng=" + lng)
                .add("tm=" + tm)
                .add("vehSt=" + vehSt)
                .add("almNo='" + almNo + "'");
    }

    @Override
    public String toString() {
        StringJoiner r = new StringJoiner(", ",
                getClass().getSimpleName() + "[",
                "]");
        toString(r);
        return r.toString();
    }
}
