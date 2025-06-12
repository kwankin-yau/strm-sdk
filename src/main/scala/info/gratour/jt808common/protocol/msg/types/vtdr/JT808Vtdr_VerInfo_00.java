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
 * 采集记录仪执行标准版本应答数据(00H)
 */
@Expose
public class JT808Vtdr_VerInfo_00 implements JT808VtdrDataBlock {

    private int year;
    private int rev;

    /**
     * 取年份, 后两位
     * @return 年份
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置年份, 后两位
     * @param year 年份
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 取修改单号
     * @return 修改单号
     */
    public int getRev() {
        return rev;
    }

    /**
     * 设置修改单号
     * @param rev 修改单号
     */
    public void setRev(int rev) {
        this.rev = rev;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_VerInfo_00.class.getSimpleName() + "[", "]")
                .add("year='" + year + "'")
                .add("rev='" + rev + "'")
                .toString();
    }

    @Override
    public JT808Vtdr_VerInfo_00 clone() {
        try {
            return (JT808Vtdr_VerInfo_00) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
