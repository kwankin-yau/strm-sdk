/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common;

import java.util.Locale;
import java.util.ResourceBundle;

import info.gratour.jtcommon.JTUtils;

class JT808IoStateNames {
    public static final String MESSAGE_KEY_DEEP_SLEEP = "iost.deep_sleep.0";
    public static final String MESSAGE_KEY_SLEEP = "iost.sleep.1";

    private static final String[] MESSAGE_KEYS = new String[] {
            MESSAGE_KEY_DEEP_SLEEP,
            MESSAGE_KEY_SLEEP
    };

    private static String ioStateMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.io-state-names", locale != null ? locale : Locale.getDefault());
    }

    public static String getStateName(int bitIndex, Locale locale) {
        String key = ioStateMessageKey(bitIndex);
        if (key != null)
            return resourceBundle(locale).getString(key);
        else
            return null;
    }

}

/**
 * 车辆IO状态
 */
public enum  JT808IoState {

    /**
     * 深度休眠
     */
    DEEP_SLEEP(0),

    /**
     * 休眠
     */
    SLEEP(1);


    private int index;

    JT808IoState(int bitIndex) {
        this.index = bitIndex;
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
    public String stateName(Locale locale) {
        return JT808IoStateNames.getStateName(index, locale);
    }

    /**
     * 格式化车辆IO状态文本
     * @param vehIoStateBits 车辆IO状态位
     * @param locale 区域
     * @return 车辆IO状态文本
     */
    public static String vehIoStateText(int vehIoStateBits, Locale locale) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808IoState st: values()) {
            if (JTUtils.test(vehIoStateBits, st.index)) {
                if (first)
                    first = false;
                else
                    str.append(";");

                str.append(st.stateName(locale));
            }
        }

        return str.toString();
    }

}
