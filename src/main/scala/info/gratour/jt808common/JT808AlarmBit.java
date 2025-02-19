package info.gratour.jt808common;


import java.util.Locale;
import java.util.ResourceBundle;

import info.gratour.jtcommon.JTUtils;

/**
 * JT/T 808 报警名称
 */
class JT808AlarmNames {

    // load the string from alarm-names_zh.properties

    /**
     * 报警名称字符串key：紧急报警
     */
    public static final String MESSAGE_KEY_PANIC = "alm.panic.0";

    /**
     * 报警名称字符串key：超速报警
     */
    public static final String MESSAGE_KEY_OVERSPEED = "alm.overspd.1";

    /**
     * 报警名称字符串key：疲劳驾驶报警
     */
    public static final String MESSAGE_KEY_FATIGUED = "alm.fatigued.2";

    /**
     * 报警名称字符串key：危险预警
     */
    public static final String MESSAGE_KEY_DANGER_EARLY_WARNING = "alm.danger_early_warn.3";

    /**
     * 报警名称字符串key：GNSS模块故障
     */
    public static final String MESSAGE_KEY_GNSS_FAILED = "alm.gnss_failed.4";

    /**
     * 报警名称字符串key：GNSS天线断开
     */
    public static final String MESSAGE_KEY_ANTENNA_CUT = "alm.antenna_cut.5";

    /**
     * 报警名称字符串key：GNSS天线短路
     */
    public static final String MESSAGE_KEY_ANTENNA_SHORT = "alm.antenna_short.6";

    /**
     * 报警名称字符串key：主电源欠压
     */
    public static final String MESSAGE_KEY_POWER_ALARM = "alm.power_alm.7";

    /**
     * 报警名称字符串key：主电源掉电
     */
    public static final String MESSAGE_KEY_POWER_FAILED = "alm.power_failed.8";

    /**
     * 报警名称字符串key：LED模块故障
     */
    public static final String MESSAGE_KEY_LCD_FAILED = "alm.led_failed.9";

    /**
     * 报警名称字符串key：TTS模块故障
     */
    public static final String MESSAGE_KEY_TTS_FAILED = "alm.tts_failed.10";

    /**
     * 报警名称字符串key：摄像头故障
     */
    public static final String MESSAGE_KEY_CAMERA_FAILED = "alm.camera_failed.11";

    /**
     * 报警名称字符串key：IC卡模块故障
     */
    public static final String MESSAGE_KEY_ICCARD_FAILED = "alm.iccard_failed.12";

    /**
     * 报警名称字符串key：超速预警
     */
    public static final String MESSAGE_KEY_OVERSPEED_EARLY_WARNING = "alm.overspd_early_warn.13";

    /**
     * 报警名称字符串key：疲劳驾驶预警
     */
    public static final String MESSAGE_KEY_FATIGUED_EARLY_WARNING = "alm.fatigued_early_warn.14";

    /**
     * 报警名称字符串key：胎压预警
     */
    public static final String MESSAGE_KEY_VIOLATED_2019 = "alm.violated.15";

    /**
     * 报警名称字符串key：轮胎预警
     */
    public static final String MESSAGE_KEY_TYRE_EARLY_WARNING_2019 = "alm.tyre_early_warn.16";

    /**
     * 报警名称字符串key：右转盲区异常报警
     */
    public static final String MESSAGE_KEY_TURN_RIGHT_BLIND_AREA_2019 = "alm.turn_right_blind_area.17";

    /**
     * 报警名称字符串key：当天累计驾驶超时报警
     */
    public static final String MESSAGE_KEY_DRIVE_OVERTIME = "alm.drive_overtime.18";

    /**
     * 报警名称字符串key：超时停车报警
     */
    public static final String MESSAGE_KEY_PARK_OVERTIME = "alm.park_overtime.19";

    /**
     * 报警名称字符串key：进出区域报警
     */
    public static final String MESSAGE_KEY_REGION_EVENT = "alm.region_event.20";

    /**
     * 报警名称字符串key：进出路线报警
     */
    public static final String MESSAGE_KEY_ROUTE_EVENT = "alm.route_event.21";

    /**
     * 报警名称字符串key：路段行驶时间不足/过长报警
     */
    public static final String MESSAGE_KEY_ROAD_TIME_EVENT = "alm.road_time_event.22";

    /**
     * 报警名称字符串key：偏离路线报警
     */
    public static final String MESSAGE_KEY_STRAY_PATH = "alm.stray_path.23";

    /**
     * 报警名称字符串key：VSS模块故障
     */
    public static final String MESSAGE_KEY_VSS_FAILED = "alm.vss_failed.24";

    /**
     * 报警名称字符串key：油量异常报警
     */
    public static final String MESSAGE_KEY_FUEL_LEAK = "alm.fuel_leak.25";

    /**
     * 报警名称字符串key：盗警
     */
    public static final String MESSAGE_KEY_STEAL = "alm.steal.26";

    /**
     * 报警名称字符串key：非法点火报警
     */
    public static final String MESSAGE_KEY_UNINTENDED_IGNITION = "alm.unintended_ignition.27";

    /**
     * 报警名称字符串key：非法移动报警
     */
    public static final String MESSAGE_KEY_UNINTENDED_MOTION = "alm.unintended_motion.28";

    /**
     * 报警名称字符串key：碰撞预警
     */
    public static final String MESSAGE_KEY_CRASH_EARLY_WARNING = "alm.crash_early_warn.29";

    /**
     * 报警名称字符串key：翻车预警
     */
    public static final String MESSAGE_KEY_TURNOVER_EARLY_WARNING = "alm.turnover_early_warn.30";

    /**
     * 报警名称字符串key：非法开门报警
     */
    public static final String MESSAGE_KEY_UNINTENDED_OPEN_DOOR = "alm.unintended_open_door.31";

    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_PANIC,
            MESSAGE_KEY_OVERSPEED,
            MESSAGE_KEY_FATIGUED,
            MESSAGE_KEY_DANGER_EARLY_WARNING,
            MESSAGE_KEY_GNSS_FAILED,
            MESSAGE_KEY_ANTENNA_CUT,
            MESSAGE_KEY_ANTENNA_SHORT,
            MESSAGE_KEY_POWER_ALARM,
            MESSAGE_KEY_POWER_FAILED,
            MESSAGE_KEY_LCD_FAILED,
            MESSAGE_KEY_TTS_FAILED,
            MESSAGE_KEY_CAMERA_FAILED,
            MESSAGE_KEY_ICCARD_FAILED,
            MESSAGE_KEY_OVERSPEED_EARLY_WARNING,
            MESSAGE_KEY_FATIGUED_EARLY_WARNING,
            MESSAGE_KEY_VIOLATED_2019,
            MESSAGE_KEY_TYRE_EARLY_WARNING_2019,
            MESSAGE_KEY_TURN_RIGHT_BLIND_AREA_2019,
            MESSAGE_KEY_DRIVE_OVERTIME,
            MESSAGE_KEY_PARK_OVERTIME,
            MESSAGE_KEY_REGION_EVENT,
            MESSAGE_KEY_ROUTE_EVENT,
            MESSAGE_KEY_ROAD_TIME_EVENT,
            MESSAGE_KEY_STRAY_PATH,
            MESSAGE_KEY_VSS_FAILED,
            MESSAGE_KEY_FUEL_LEAK,
            MESSAGE_KEY_STEAL,
            MESSAGE_KEY_UNINTENDED_IGNITION,
            MESSAGE_KEY_UNINTENDED_MOTION,
            MESSAGE_KEY_CRASH_EARLY_WARNING,
            MESSAGE_KEY_TURNOVER_EARLY_WARNING,
            MESSAGE_KEY_UNINTENDED_OPEN_DOOR
    };

    private static String alarmMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.alarm-names", locale != null ? locale : Locale.getDefault());
    }

    static String getAlarmName(int bitIndex, Locale locale) {
        String key = alarmMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return null;
    }
}

/**
 * JT/T 808 报警位
 */
public enum JT808AlarmBit {

    /**
     * 报警位：紧急报警
     */
    PANIC(0),

    /**
     * 报警位：超速报警
     */
    OVERSPEED(1),

    /**
     * 报警位：疲劳驾驶报警
     */
    FATIGUED(2),

    /**
     * 报警位：危险预警
     */
    DANGER_EARLY_WARNING(3),

    /**
     * 报警位：GNSS模块故障
     */
    GNSS_FAILED(4),

    /**
     * 报警位：GNSS天线断开
     */
    ANTENNA_CUT(5),

    /**
     * 报警位：GNSS天线短路
     */
    ANTENNA_SHORT(6),

    /**
     * 报警位：主电源欠压
     */
    POWER_ALARM(7),

    /**
     * 报警位：主电源掉电
     */
    POWER_FAILED(8),

    /**
     * 报警位：LED模块故障
     */
    LCD_FAILED(9),

    /**
     * 报警位：TTS模块故障
     */
    TTS_FAILED(10),

    /**
     * 报警位：摄像头故障
     */
    CAMERA_FAILED(11),

    /**
     * 报警位：IC卡模块故障
     */
    ICCARD_FAILED(12),

    /**
     * 报警位：超速预警
     */
    OVERSPEED_EARLY_WARNING(13),

    /**
     * 报警位：疲劳驾驶预警
     */
    FATIGUED_EARLY_WARNING(14),

    /**
     * 报警位：违规行驶报警
     */
    VIOLATED_2019(15),

    /**
     * 报警位：胎压预警
     */
    TYRE_EARLY_WARNING_2019(16),

    /**
     * 报警位：右转盲区异常报警
     */
    TURN_RIGHT_BLIND_AREA_2019(17),

    /**
     * 报警位：当天累计驾驶超时报警
     */
    DRIVE_OVERTIME(18),

    /**
     * 报警位：超时停车报警
     */
    PARK_OVERTIME(19),
    
    /**
     * 报警位：进出区域报警
     */
    REGION_EVENT(20),

    /**
     * 报警位：进出路线报警
     */
    ROUTE_EVENT(21),

    /**
     * 报警位：路段行驶时间不足/过长报警
     */
    ROAD_TIME_EVENT(22),

    /**
     * 报警位：偏离路线报警
     */
    STRAY_PATH(23),

    /**
     * 报警位：VSS模块故障
     */
    VSS_FAILED(24),

    /**
     * 报警位：油量异常报警
     */
    FUEL_LEAK(25),

    /**
     * 报警位：盗警
     */
    STEAL(26),

    /**
     * 报警位：非法点火报警
     */
    UNINTENDED_IGNITION(27),

    /**
     * 报警位：非法移动报警
     */
    UNINTENDED_MOTION(28),

    /**
     * 报警位：碰撞预警
     */
    CRASH_EARLY_WARNING(29),

    /**
     * 报警位：翻车预警
     */
    TURNOVER_EARLY_WARNING(30),

    /**
     * 报警位：非法开门报警
     */
    UNINTENDED_OPEN_DOOR(31);

    // BIT31 DEPRECATED IN 2019

    private int index;


    private JT808AlarmBit(int bitIndex) {
        index = bitIndex;
    }

    /**
     * 获取报警位索引
     * @return 报警位索引
     */
    public int bitIndex() {
        return index;
    }

    /**
     * 获取报警名称
     * @param locale 区域
     * @return 报警名称
     */
    public String alarmName(Locale locale) {
        return JT808AlarmNames.getAlarmName(index, locale);
    }

    /**
     * 格式化车辆报警文本
     * @param vehAlarmBits 车辆报警位
     * @param locale 区域
     * @return 车辆报警文本
     */
    public static String vehAlarmText(int vehAlarmBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808AlarmBit bit : values()) {
            if (JTUtils.test(vehAlarmBits, bit.index)) {
                if (first)
                    first = false;
                else
                    str.append(',');
                str.append(bit.alarmName(locale));
            }
        }

        return str.toString();
    }
}
