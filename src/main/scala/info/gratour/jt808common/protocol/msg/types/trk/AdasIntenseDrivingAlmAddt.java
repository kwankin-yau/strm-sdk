/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;
import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 激烈驾驶报警
 */
@Expose
public class AdasIntenseDrivingAlmAddt extends AdasAddt implements Cloneable {

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
     * 急加速报警
     */
    public static final byte TYP__RAPID_ACCELERATE = 1;

    /**
     * 急减速报警
     */
    public static final byte TYP__RAPID_DECELERATE = 2;

    /**
     * 急转弯报警
     */
    public static final byte TYP__RAPID_TURN = 3;

    /**
     * 怠速报警
     */
    public static final byte TYP__IDLING = 4;

    /**
     * 异常熄火报警
     */
    public static final byte TYP__UNEXPECTED_FLAME_OUT = 5;

    /**
     * 空挡滑行报警
     */
    public static final byte TYP__SLIDING_ON_N = 6;

    /**
     * 发动机超转报警
     */
    public static final byte TYP__ENGINE_RPM_TOO_HIGH = 7;

    /**
     * 不能识别或厂商自定义报警/事件类型
     */
    public static final byte TYP__CUSTOM = (byte) 0xFF;

    private byte flag;
    private short typ;
    private short dur;
    private short thold1;
    private short thold2;

    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasIntenseDrivingAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
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
     * 取终端原始上传的报警类型
     *
     * @return 终端原始上传的报警类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置终端原始上传的报警类型
     *
     * @param typ 终端原始上传的报警类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 取报警时间阀值
     *
     * @return 报警时间阀值，单位：秒
     */
    public short getDur() {
        return dur;
    }

    /**
     * 设置报警时间阀值
     * @param dur 报警时间阀值，单位：秒
     */
    public void setDur(short dur) {
        this.dur = dur;
    }

    /**
     * 取报警时间阀值1
     * @return 报警时间阀值1
     */
    public short getThold1() {
        return thold1;
    }

    /**
     * 设置报警时间阀值1
     * @param thold1 报警时间阀值1
     */
    public void setThold1(short thold1) {
        this.thold1 = thold1;
    }

    /**
     * 取报警时间阀值2
     * @return 报警时间阀值2
     */
    public short getThold2() {
        return thold2;
    }

    /**
     * 设置报警时间阀值2
     * @param thold2 报警时间阀值2
     */
    public void setThold2(short thold2) {
        this.thold2 = thold2;
    }


    @Override
    public AdasIntenseDrivingAlmAddt clone() {
        try {
            return (AdasIntenseDrivingAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasIntenseDrivingAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("dur=" + dur)
                .add("thold1=" + thold1)
                .add("thold2=" + thold2)
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
