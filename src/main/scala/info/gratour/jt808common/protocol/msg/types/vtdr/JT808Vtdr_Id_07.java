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
 * 采集记录仪唯一性编号应答数据(07H)
 */
@Expose
public class JT808Vtdr_Id_07 implements JT808VtdrDataBlock {
    private String ccc;
    private String model;
    private int prodYear;
    private int prodMonth;
    private int prodDay;
    private int serialNum;

    /**
     * 取生产厂CCC认证代码
     * @return 生产厂CCC认证代码
     */
    public String getCcc() {
        return ccc;
    }

    /**
     * 设置生产厂CCC认证代码
     * @param ccc 生产厂CCC认证代码
     */
    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    /**
     * 取认证型号
     * @return 认证型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置认证型号
     * @param model 认证型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 取生产年份
     * @return 生产年份
     */
    public int getProdYear() {
        return prodYear;
    }

    /**
     * 设置生产年份
     * @param prodYear 生产年份
     */
    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    /**
     * 取生产月份
     * @return 生产月份
     */
    public int getProdMonth() {
        return prodMonth;
    }

    /**
     * 设置生产月份
     * @param prodMonth 生产月份
     */
    public void setProdMonth(int prodMonth) {
        this.prodMonth = prodMonth;
    }

    /**
     * 取生产日期
     * @return 生产日期
     */
    public int getProdDay() {
        return prodDay;
    }

    /**
     * 设置生产日期
     * @param prodDay 生产日期
     */
    public void setProdDay(int prodDay) {
        this.prodDay = prodDay;
    }

    /**
     * 取序列号
     * @return 序列号
     */
    public int getSerialNum() {
        return serialNum;
    }

    /**
     * 设置序列号
     * @param serialNum 序列号
     */
    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_Id_07.class.getSimpleName() + "[", "]")
                .add("ccc='" + ccc + "'")
                .add("model='" + model + "'")
                .add("prodYear='" + prodYear + "'")
                .add("prodMonth='" + prodMonth + "'")
                .add("prodDay='" + prodDay + "'")
                .add("serialNum=" + serialNum)
                .toString();
    }

    @Override
    public JT808Vtdr_Id_07 clone() {
        try {
            return (JT808Vtdr_Id_07) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
