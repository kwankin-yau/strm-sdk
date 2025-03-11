/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

/**
 * 车牌号和颜色
 */
public class PlateNoAndColor implements IPlateNoAndColor {

    private String plateNo;
    private int plateColor;

    /**
     * 构造函数
     */
    public PlateNoAndColor() {
    }

    /**
     * 构造函数
     * 
     * @param plateNo 车牌号
     * @param plateColor 车牌颜色
     */
    public PlateNoAndColor(String plateNo, int plateColor) {
        this.plateNo = plateNo;
        this.plateColor = plateColor;
    }

    /**
     * 取车牌号
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号
     * 
     * @param plateNo 车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    /**
     * 取车牌颜色
     */
    public int getPlateColor() {
        return plateColor;
    }

    /**
     * 设置车牌颜色
     * 
     * @param plateColor 车牌颜色
     */
    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 取车牌颜色代码(short 类型)
     * @return 车牌颜色代码
     */
    public short plateColorShort() {
        return (short) plateColor;
    }

    /**
     * 取车牌颜色代码(byte 类型)
     * @return 车牌颜色代码
     */
    public byte plateColorByte() {
        return (byte) plateColor;
    }

    /**
     * 从车牌号字符串解析车牌号和颜色
     * 
     * @param plateNoStr 车牌号字符串
     * @return 车牌号和颜色
     */
    public static PlateNoAndColor parseFromPlateNoStr(String plateNoStr) {
        if (plateNoStr == null)
            return null;
        else {
            int p = plateNoStr.indexOf('_');
            if (p < 0)
                throw new RuntimeException(String.format("Can not parse PlateNo string: `%s`.", plateNoStr));

            return new PlateNoAndColor(plateNoStr.substring(0, p),  Integer.parseInt(plateNoStr.substring(p+1)));
        }
    }

    @Override
    public String toString() {
        return "PlateNoAndColor{" +
                "plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                '}';
    }
}
