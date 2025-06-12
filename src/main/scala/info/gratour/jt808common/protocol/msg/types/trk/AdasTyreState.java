/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import java.util.List;
import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.AdasDialect;

/**
 * ADAS 轮胎状态
 */
@Expose
public class AdasTyreState extends AdasAddt implements Cloneable {

    /**
     * 标志位：不可用
     */
    public static final byte FLAG__NOT_AVAILABLE = 0;

    /**
     * 标志位：开始
     */
    public static final byte FLAG__START = 1;

    /**
     * 标志位：结束
     */
    public static final byte FLAG__END = 2;

    private byte flag;
    private List<PressureAlarmInfo> alms;

    /**
     * 构造函数
     * @param adasDialect ADAS方言
     */
    public AdasTyreState(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取标志位
     * @return 标志位
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * 设置标志位
     * @param flag 标志位
     */
    public void setFlag(byte flag) {
        this.flag = flag;
    }

    /**
     * 测试标志位是否为开始或不可用
     * @return 测试结果
     */
    public boolean flagIsStartOrNA() {
        return flag == FLAG__NOT_AVAILABLE || flag == FLAG__START;
    }

    /**
     * 取胎压报警信息列表
     * @return 胎压报警信息列表
     */
    public List<PressureAlarmInfo> getAlms() {
        return alms;
    }

    /**
     * 设置胎压报警信息列表
     * @param alms 胎压报警信息列表
     */
    public void setAlms(List<PressureAlarmInfo> alms) {
        this.alms = alms;
    }

    @Override
    public AdasTyreState clone() {
        try {
            return (AdasTyreState) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasTyreState.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("spd=" + spd)
                .add("alt=" + alt)
                .add("lat=" + lat)
                .add("lng=" + lng)
                .add("tm=" + tm)
                .add("vehSt=" + vehSt)
                .add("almNo='" + almNo + "'")
                .add("alms=" + alms)
                .toString();
    }
}
