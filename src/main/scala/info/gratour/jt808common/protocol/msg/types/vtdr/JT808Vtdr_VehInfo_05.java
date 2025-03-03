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
 * 采集车辆信息应答数据(05H)
 */
@Expose
public class JT808Vtdr_VehInfo_05 implements JT808VtdrDataBlock {
    private String vin;
    private String plateNo;
    private String plateCategory;

    /**
     * 取车辆识别代码
     * @return 车辆识别代码
     */
    public String getVin() {
        return vin;
    }

    /**
     * 设置车辆识别代码
     * @param vin 车辆识别代码
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * 取车牌号码
     * @return 车牌号码
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号码
     * @param plateNo 车牌号码
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    /**
     * 取车牌类别
     * @return 车牌类别
     */
    public String getPlateCategory() {
        return plateCategory;
    }

    /**
     * 设置车牌类别
     * @param plateCategory 车牌类别
     */
    public void setPlateCategory(String plateCategory) {
        this.plateCategory = plateCategory;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_VehInfo_05.class.getSimpleName() + "[", "]")
                .add("vin='" + vin + "'")
                .add("plateNo='" + plateNo + "'")
                .add("plateCategory='" + plateCategory + "'")
                .toString();
    }

    @Override
    public JT808Vtdr_VehInfo_05 clone() {
        try {
            return (JT808Vtdr_VehInfo_05) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
