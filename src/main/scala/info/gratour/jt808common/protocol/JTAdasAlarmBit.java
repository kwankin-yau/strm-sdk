/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol;

import java.util.Locale;
import java.util.ResourceBundle;

import info.gratour.jtcommon.JTUtils;

/**
 * ADAS 报警名称
 */
class JTAdasAlarmNames {

    /**
     * 驾驶辅助报警字符串资源key
     */
    public static final String MESSAGE_KEY_DRIVING_ASSIST_ALM = "adas.driving_assist.0";

    /**
     * 驾驶员行为报警字符串资源key
     */
    public static final String MESSAGE_KEY_DRIVER_BEHAV_ALM = "adas.driver_behav.1";

    /**
     * 轮胎状态报警字符串资源key
     */
    public static final String MESSAGE_KEY_TYRE_STATE_ALM = "adas.tyre_state.2";

    /**
     * 盲区报警字符串资源key
     */
    public static final String MESSAGE_KEY_BLIND_AREA_ALM = "adas.blind_area.3";

    /**
     * 激烈驾驶报警字符串资源key
     */
    public static final String MESSAGE_KEY_INTENSE_DRIVING_ALM = "adas.intense_driving.4";

    /**
     * 超速报警字符串资源key
     */
    public static final String MESSAGE_KEY_OVER_SPD_ALM = "adas.over_spd.5";

    /**
     * 报警名称字符串资源key数组
     */
    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_DRIVING_ASSIST_ALM,
            MESSAGE_KEY_DRIVER_BEHAV_ALM,
            MESSAGE_KEY_TYRE_STATE_ALM,
            MESSAGE_KEY_BLIND_AREA_ALM,
            MESSAGE_KEY_INTENSE_DRIVING_ALM,
            MESSAGE_KEY_OVER_SPD_ALM
    };


    private static String alarmMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static final ResourceBundle resourceBundle(Locale locale) {
      return ResourceBundle.getBundle("info.gratour.jt808common.protocol.adas-alarm-names", locale != null ? locale : Locale.getDefault());
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
 * ADAS 报警位枚举
 */
public enum JTAdasAlarmBit {

    /**
     * 驾驶辅助报警位
     */
    DRIVING_ASSIST_ALM(0),

    /**
     * 驾驶员行为报警位
     */
    DRIVER_BEHAV_ALM(1),

    /**
     * 轮胎状态报警位
     */
    TYRE_STATE_ALM(2),

    /**
     * 盲区报警位
     */
    BLIND_AREA_ALM(3),

    /**
     * 激烈驾驶报警位
     */
    INTENSE_DRIVING_ALM(4),

    /**
     * 超速报警位
     */
    OVER_SPD_ALM(5);

    private int index;

    /**
     * 构造函数
     * @param bitIndex 报警位索引
     */
    JTAdasAlarmBit(int bitIndex) {
        this.index = bitIndex;
    }

    /**
     * 取报警位索引
     * @return 报警位索引
     */
    public int bitIndex() {
        return index;
    }

    /**
     * 取报警名称
     * @param locale 区域
     * @return 报警名称
     */
    public String alarmName(Locale locale) {
        return JTAdasAlarmNames.getAlarmName(index, locale);
    }

    /**
     * 取ADAS报警名称文本
     * @param adasAlmBits ADAS报警标志字，可能包含多个报警位
     * @param locale 区域
     * @return ADAS报警名称文本，多个报警名称用逗号分隔
     */
    public static String adasAlmText(int adasAlmBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JTAdasAlarmBit bit : values()) {
            if (JTUtils.test(adasAlmBits, bit.index)) {
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


