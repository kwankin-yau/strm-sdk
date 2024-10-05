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

import java.util.List;
import java.util.StringJoiner;

@Expose
public class AdasTyreState extends AdasAddt implements Cloneable {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    private byte flag;
    private List<PressureAlarmInfo> alms;

    public AdasTyreState(AdasDialect adasDialect) {
        super(adasDialect);
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public boolean flagIsStartOrNA() {
        return flag == FLAG__NOT_AVAILABLE || flag == FLAG__START;
    }


    public List<PressureAlarmInfo> getAlms() {
        return alms;
    }

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
