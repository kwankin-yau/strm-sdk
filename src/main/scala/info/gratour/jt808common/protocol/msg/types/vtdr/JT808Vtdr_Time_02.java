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
 * 采集记录仪时间应答数据(02H)
 */
@Expose
public class JT808Vtdr_Time_02 implements JT808VtdrDataBlock {

    private String dateTime;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_Time_02.class.getSimpleName() + "[", "]")
                .add("dateTime='" + dateTime + "'")
                .toString();
    }

    @Override
    public JT808Vtdr_Time_02 clone() {
        try {
            return (JT808Vtdr_Time_02) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
