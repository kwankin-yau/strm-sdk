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
 * 速度与状态日志条目
 */
@Expose
public class Vtdr_SpdLogEntry implements Cloneable {

    private short recSpd;
    private short refSpd;

    /**
     * 取记录速度, 单位: km/h
     * @return 记录速度
     */
    public short getRecSpd() {
        return recSpd;
    }

    /**
     * 设置记录速度, 单位: km/h
     * @param recSpd 记录速度
     */
    public void setRecSpd(short recSpd) {
        this.recSpd = recSpd;
    }

    /**
     * 取参考速度, 单位: km/h
     * @return 参考速度
     */
    public short getRefSpd() {
        return refSpd;
    }

    /**
     * 设置参考速度, 单位: km/h
     * @param refSpd 参考速度
     */
    public void setRefSpd(short refSpd) {
        this.refSpd = refSpd;
    }

    @Override
    public Vtdr_SpdLogEntry clone() {
        try {
            return (Vtdr_SpdLogEntry) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_SpdLogEntry.class.getSimpleName() + "[", "]")
                .add("recSpd=" + recSpd)
                .add("refSpd=" + refSpd)
                .toString();
    }
}
