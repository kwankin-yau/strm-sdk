/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

/**
 * 车牌号和颜色提供者
 */
public interface IPlateNoAndColor {

    /**
     * 取车牌号
     * @return 车牌号
     */
    String getPlateNo();

    /**
     * 取车牌颜色
     * @return 车牌颜色
     */
    int getPlateColor();

    /**
     * 格式化车牌号和颜色字符串
     * @param plateNo 车牌号
     * @param plateColor 车牌颜色
     * @return 车牌号和颜色字符串
     */
    static String plateNoString(String plateNo, int plateColor) {
        if (plateNo == null)
            throw new NullPointerException("plateNo");

        return plateNo + "_" + plateColor;
    }

    /**
     * 格式化车牌号和颜色字符串
     * @return 车牌号和颜色字符串
     */
    default String plateNoStr() {
        return getPlateNo() + "_" + getPlateColor();
    }
}
