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
 * 采集记录仪脉冲系数应答数据(04H)
 */
@Expose
public class JT808Vtdr_PulseFactor_04 implements JT808VtdrDataBlock {

    private String dateTime;
    private int factor;

    /**
     * 取记录仪时间, yyyy-MM-dd HH:mm:ss
     * @return 记录仪时间
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 设置记录仪时间, yyyy-MM-dd HH:mm:ss
     * @param dateTime 记录仪时间
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 取脉冲系数
     * @return 脉冲系数
     */
    public int getFactor() {
        return factor;
    }

    /**
     * 设置脉冲系数
     * @param factor 脉冲系数
     */
    public void setFactor(int factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_PulseFactor_04.class.getSimpleName() + "[", "]")
                .add("dateTime='" + dateTime + "'")
                .add("factor=" + factor)
                .toString();
    }

    @Override
    public JT808Vtdr_PulseFactor_04 clone() {
        try {
            return (JT808Vtdr_PulseFactor_04) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
