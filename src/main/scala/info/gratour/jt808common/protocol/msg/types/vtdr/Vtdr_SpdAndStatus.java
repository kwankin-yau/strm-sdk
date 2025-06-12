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
 * 速度和状态
 */
@Expose
public class Vtdr_SpdAndStatus implements Cloneable {

    private short spd;
    private byte status;

    /**
     * 取速度
     * @return 速度
     */
    public short getSpd() {
        return spd; 
    }

    /**
     * 设置速度
     * @param spd 速度
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 取状态
     * @return 状态
     */
    public byte getStatus() {
        return status;
    }

    /**
     * 设置状态
     * @param status 状态
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public Vtdr_SpdAndStatus clone() {
        try {
            return (Vtdr_SpdAndStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_SpdAndStatus.class.getSimpleName() + "[", "]")
                .add("spd=" + spd)
                .add("status=" + status)
                .toString();
    }
}
