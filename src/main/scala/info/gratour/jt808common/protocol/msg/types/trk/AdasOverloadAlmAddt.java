package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;
import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 载重报警附加信息
 */
@Expose
public class AdasOverloadAlmAddt extends AdasAddt implements Cloneable {

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
     * 超过车辆额定载重报警
     */
    public static final byte TYP__OVER_VEH_LOADING = 1;

    /**
     * 超过道路额定载重报警
     */
    public static final byte TYP__OVER_ROAD_LOADING = 2;

    private byte flag;
    private byte typ;
    private int actualLoading;
    private int threshold;

    /**
     * 构造函数
     * @param adasDialect ADAS 方言
     */
    public AdasOverloadAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取标志状态。为 FLAG__ 系列常量之一
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
     * 取车辆实际载重，单位：10kg
     *
     * @return 车辆实际载重，单位：10kg
     */
    public int getActualLoading() {
        return actualLoading;
    }

    /**
     * 设置车辆实际载重，单位：10kg
     * @param actualLoading 车辆实际载重，单位：10kg
     */
    public void setActualLoading(int actualLoading) {
        this.actualLoading = actualLoading;
    }

    /**
     * 取额定/限定载重，单位：10kg
     * @return 额定/限定载重，单位：10kg
     */
    public int getThreshold() {
        return threshold;
    }

    /**
     * 设置额定/限定载重，单位：10kg
     * @param threshold 额定/限定载重，单位：10kg
     */
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public AdasOverloadAlmAddt clone() {
        try {
            return (AdasOverloadAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasOverloadAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("actualLoading=" + actualLoading)
                .add("threshold=" + threshold)
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
