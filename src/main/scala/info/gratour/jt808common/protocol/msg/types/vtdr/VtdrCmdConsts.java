/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

/**
 * 采集记录仪命令常量
 */
public class VtdrCmdConsts {

    /**
     * 查询执行标准版本
     */
    public static final byte QRY_VER_INFO_00 = 0x00;

    /**
     * 查询驾驶员信息
     */
    public static final byte QRY_DRIVER_INFO_01 = 0x01;

    /**
     * 查询记录仪时间
     */
    public static final byte QRY_TIME_02 = 0x02;

    /**
     * 查询行驶里程
     */
    public static final byte QRY_MILEAGE_03 = 0x03;

    /**
     * 查询脉冲系数
     */
    public static final byte QRY_PULSE_FACTOR_04 = 0x04;

    /**
     * 查询车辆信息
     */
    public static final byte QRY_VEH_INFO_05 = 0x05;

    /**
     * 查询状态信号配置
     */
    public static final byte QRY_STATUS_SIGNAL_CONFIG_06 = 0x06;

    /**
     * 查询车辆唯一性编码
     */
    public static final byte QRY_ID_07 = 0x07;

    /**
     * 查询行驶速度记录
     */
    public static final byte QRY_SPD_RECORDS_08 = 0x08;

    /**
     * 查询位置记录
     */
    public static final byte QRY_LOCATIONS_09 = 0X09;

    /**
     * 查询事故疑点数据
     */
    public static final byte QRY_ACCIDENT_POINTS_10 = 0x10;

    /**
     * 查询超时驾驶记录
     */
    public static final byte QRY_DRIVE_OVER_TIME_11 = 0x11;

    /**
     * 查询驾驶员身份记录
     */
    public static final byte QRY_DRIVER_CARD_EVENTS_12 = 0x12;

    /**
     * 查询外部供电记录
     */
    public static final byte QRY_POWER_EVENTS_13 = 0x13;

    /**
     * 查询参数修改记录
     */
    public static final byte QRY_REV_EVENTS_14 = 0x14;

    /**
     * 查询速度状态日志
     */
    public static final byte QRY_SPD_STATUS_LOG_15 = 0x15;

    /**
     * 设置车辆信息
     */
    public static final byte SET_VEH_INFO_82 = (byte) 0x82;

    /**
     * 设置安装日期
     */
    public static final byte SET_INSTALL_DATE_83 = (byte) 0x83;

    /**
     * 设置状态信号配置
     */
    public static final byte SET_STATUS_SIGNAL_CONFIG_84 = (byte) 0x84;

    /**
     * 设置记录仪时间
     */
    public static final byte SET_TIME_C2 = (byte) 0xC2;

    /**
     * 设置脉冲系数
     */
    public static final byte SET_PULSE_FACTOR_C3 = (byte) 0xC3;

    /**
     * 设置起始里程
     */
    public static final byte SET_MILEAGE_C4 = (byte) 0xC4;

}
