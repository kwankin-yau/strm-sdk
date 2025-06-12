package info.gratour.jt808common;

import java.util.Locale;
import java.util.ResourceBundle;

import info.gratour.jtcommon.JTMessages;
import info.gratour.jtcommon.JTUtils;

class JT808StateNames {
    public static final String MESSAGE_KEY_ACC_ON = "state.acc_on.0";
    public static final String MESSAGE_KEY_LOCATED = "state.located.1";
    public static final String MESSAGE_KEY_SOUTH = "state.south.2";
    public static final String MESSAGE_KEY_WEST = "state.west.3";
    public static final String MESSAGE_KEY_OUT_OF_SERVICE = "state.out_of_serv.4";
    public static final String MESSAGE_KEY_ENCRYPT = "state.encrypt.5";
    public static final String MESSAGE_KEY_FULL = "state.full.8";
    public static final String MESSAGE_KEY_LOADING = "state.loading.9";
    public static final String MESSAGE_KEY_OIL_CUT = "state.oil_cut.10";
    public static final String MESSAGE_KEY_CIRCUIT_CUT = "state.circuit_cut.11";
    public static final String MESSAGE_KEY_DOOR_LOCKED = "state.door_locked.12";
    public static final String MESSAGE_KEY_FRONT_DOOR_OPEN = "state.front_door_open.13";
    public static final String MESSAGE_KEY_MID_DOOR = "state.mid_door_open.14";
    public static final String MESSAGE_KEY_END_DOOR = "state.end_door_open.15";
    public static final String MESSAGE_KEY_DRIVER_DOOR = "state.driver_door_open.16";
    public static final String MESSAGE_KEY_DOOR5 = "state.door5_open.17";
    public static final String MESSAGE_KEY_GPS = "state.gps.18";
    public static final String MESSAGE_KEY_BEIDOU = "state.beidou.19";
    public static final String MESSAGE_KEY_GLONASS = "state.glonass.20";
    public static final String MESSAGE_KEY_GALILEO = "state.galileo.21";

    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_ACC_ON,
            MESSAGE_KEY_LOCATED,
            MESSAGE_KEY_SOUTH,
            MESSAGE_KEY_WEST,
            MESSAGE_KEY_OUT_OF_SERVICE,
            MESSAGE_KEY_ENCRYPT,
            null, // 6
            null, // 7
            MESSAGE_KEY_FULL,
            MESSAGE_KEY_LOADING,
            MESSAGE_KEY_OIL_CUT,
            MESSAGE_KEY_CIRCUIT_CUT,
            MESSAGE_KEY_DOOR_LOCKED,
            MESSAGE_KEY_FRONT_DOOR_OPEN,
            MESSAGE_KEY_MID_DOOR,
            MESSAGE_KEY_END_DOOR,
            MESSAGE_KEY_DRIVER_DOOR,
            MESSAGE_KEY_DOOR5,
            MESSAGE_KEY_GPS,
            MESSAGE_KEY_BEIDOU,
            MESSAGE_KEY_GLONASS,
            MESSAGE_KEY_GALILEO
    };

    private static String stateMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

//    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("info.gratour.jt808common.protocol.state-names", Locale.getDefault());

    private static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.state-names", locale != null ? locale : Locale.getDefault());
    }

    private static String unknownBit(int bitIndex, Locale locale) {
        return JTMessages.unknown(locale) + "(bit:" + bitIndex + ")";
    }

    private static String[] unknownBits(Locale locale) {
        String[] r = new String[32];
        for (int i = 0; i < r.length; i++) {
            r[i] = unknownBit(i, locale);
        }

        return r;
    }

    static String getStateName(int bitIndex, Locale locale) {
        String key = stateMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return unknownBit(bitIndex, locale);
    }

}

/**
 * JT/T 808 状态位
 */
public enum JT808StateBit {

    /**
     * ACC ON
     */
    ACC_ON(0),

    /**
     * 已定位
     */
    LOCATED(1),

    /**
     * 南纬
     */
    SOUTH(2),

    /**
     * 西经
     */
    WEST(3),

    /**
     * 停运
     */
    OUT_OF_SERVICE(4),

    /**
     * 经纬度已加密
     */
    ENCRYPT(5),

    /**
     * 紧急刹车系统采集的前撞预警
     */
    CRASH_EARLY_WARNING(6),

    /**
     * 满载
     */
    FULL(8),

    /**
     * 半载或满载（满载时，FULL位同时置位）
     */
    LOADING(9),

    /**
     * 油路断开
     */
    OIL_CUT(10),

    /**
     * 电路断开
     */
    CIRCUIT_CUT(11),

    /**
     * 车门锁闭
     */
    DOOR_LOCKED(12),

    /**
     * 前车门开启
     */
    FRONT_DOOR_OPEN(13),

    /**
     * 驾驶员车门开启（2013版）、中门开启（2019版）
     */
    DRIVER_DOOR_OPEN(16),

    /**
     * 后车门开启
     */
    END_DOOR_OPEN(15),

    /**
     * 自定义车门开启
     */
    DOOR5_OPEN(17),

    /**
     * 使用GPS卫星定位
     */
    GPS(18),

    /**
     * 使用北斗卫星定位
     */
    BEIDOU(19),

    /**
     * 使用GLONASS卫星定位
     */
    GLONASS(20),

    /**
     * 使用伽利略卫星定位
     */
    GALILEO(21),
    
    /**
     * 车辆行驶状态
     */
    MOTION(22);


    private int index;
//    private String stateName;


    JT808StateBit(int bitIndex) {
        this.index = bitIndex;
//        this.stateName = JT808StateNames.getStateName(bitIndex);
    }

    /**
     * 获取位索引
     * @return 位索引
     */
    public int bitIndex() {
        return index;
    }

    /**
     * 获取状态名称
     * @param locale 区域
     * @return 状态名称
     */
    public String getStateName(Locale locale) {
        return JT808StateNames.getStateName(index, locale);
    }

    /**
     * 格式化车辆状态文本
     * @param vehStateBits 车辆状态位
     * @param locale 区域
     * @return 车辆状态文本
     */
    public static String vehStateText(int vehStateBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808StateBit bit : values()) {
            if (JTUtils.test(vehStateBits, bit.index)) {
                if (first)
                    first = false;
                else
                    str.append(',');
                str.append(bit.getStateName(locale));
            }
        }
        return str.toString();
    }
}
