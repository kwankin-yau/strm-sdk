/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 睡眠唤醒设置(0x007C)
 */
public class TP_007C_SleepWakeupSettings {

    /**
     * 每日唤醒设置
     */
    public static class DailyWakeupSetting {
        private byte periodEnableFlags;
        private String period1WakeupTime;
        private String period1SleepTime;

        private String period2WakeupTime;
        private String period2SleepTime;

        private String period3WakeupTime;
        private String period3SleepTime;

        private String period4WakeupTime;
        private String period4SleepTime;

        /**
         * 取周期启用标志
         * @return 周期启用标志
         */
        public byte getPeriodEnableFlags() {
            return periodEnableFlags;
        }

        /**
         * 设置周期启用标志
         * @param periodEnableFlags 周期启用标志
         */
        public void setPeriodEnableFlags(byte periodEnableFlags) {
            this.periodEnableFlags = periodEnableFlags;
        }

        /**
         * 取周期1唤醒时间
         * @return 周期1唤醒时间
         */
        public String getPeriod1WakeupTime() {
            return period1WakeupTime;
        }

        /**
         * 设置周期1唤醒时间
         * @param period1WakeupTime 周期1唤醒时间
         */
        public void setPeriod1WakeupTime(String period1WakeupTime) {
            this.period1WakeupTime = period1WakeupTime;
        }

        /**
         * 取周期1睡眠时间
         * @return 周期1睡眠时间
         */
        public String getPeriod1SleepTime() {
            return period1SleepTime;
        }

        /**
         * 设置周期1睡眠时间
         * @param period1SleepTime 周期1睡眠时间
         */
        public void setPeriod1SleepTime(String period1SleepTime) {
            this.period1SleepTime = period1SleepTime;
        }

        /**
         * 取周期2唤醒时间
         * @return 周期2唤醒时间
         */
        public String getPeriod2WakeupTime() {
            return period2WakeupTime;
        }

        /**
         * 设置周期2唤醒时间
         * @param period2WakeupTime 周期2唤醒时间
         */
        public void setPeriod2WakeupTime(String period2WakeupTime) {
            this.period2WakeupTime = period2WakeupTime;
        }

        /**
         * 取周期2睡眠时间
         * @return 周期2睡眠时间
         */
        public String getPeriod2SleepTime() {
            return period2SleepTime;
        }

        /**
         * 设置周期2睡眠时间
         * @param period2SleepTime 周期2睡眠时间
         */
        public void setPeriod2SleepTime(String period2SleepTime) {
            this.period2SleepTime = period2SleepTime;
        }

        /**
         * 取周期3唤醒时间
         * @return 周期3唤醒时间
         */
        public String getPeriod3WakeupTime() {
            return period3WakeupTime;
        }

        /**
         * 设置周期3唤醒时间
         * @param period3WakeupTime 周期3唤醒时间
         */
        public void setPeriod3WakeupTime(String period3WakeupTime) {
            this.period3WakeupTime = period3WakeupTime;
        }

        /**
         * 取周期3睡眠时间
         * @return 周期3睡眠时间
         */
        public String getPeriod3SleepTime() {
            return period3SleepTime;
        }

        /**
         * 设置周期3睡眠时间
         * @param period3SleepTime 周期3睡眠时间
         */
        public void setPeriod3SleepTime(String period3SleepTime) {
            this.period3SleepTime = period3SleepTime;
        }

        /**
         * 取周期4唤醒时间
         * @return 周期4唤醒时间
         */
        public String getPeriod4WakeupTime() {
            return period4WakeupTime;
        }

        /**
         * 设置周期4唤醒时间
         * @param period4WakeupTime 周期4唤醒时间
         */
        public void setPeriod4WakeupTime(String period4WakeupTime) {
            this.period4WakeupTime = period4WakeupTime;
        }

        /**
         * 取周期4睡眠时间
         * @return 周期4睡眠时间
         */
        public String getPeriod4SleepTime() {
            return period4SleepTime;
        }

        /**
         * 设置周期4睡眠时间
         * @param period4SleepTime 周期4睡眠时间
         */
        public void setPeriod4SleepTime(String period4SleepTime) {
            this.period4SleepTime = period4SleepTime;
        }

        @Override
        public String toString() {
            return "DailyWakeupSetting{" +
                    "periodEnableFlags=" + periodEnableFlags +
                    ", period1WakeupTime='" + period1WakeupTime + '\'' +
                    ", period1SleepTime='" + period1SleepTime + '\'' +
                    ", period2WakeupTime='" + period2WakeupTime + '\'' +
                    ", period2SleepTime='" + period2SleepTime + '\'' +
                    ", period3WakeupTime='" + period3WakeupTime + '\'' +
                    ", period3SleepTime='" + period3SleepTime + '\'' +
                    ", period4WakeupTime='" + period4WakeupTime + '\'' +
                    ", period4SleepTime='" + period4SleepTime + '\'' +
                    '}';
        }
    }

    private byte wakeupMode;
    private byte wakeupConditions;
    private byte weeklyWakeupSetting;
    private DailyWakeupSetting dailyWakeupSetting;

    /**
     * 取唤醒模式
     * @return 唤醒模式
     */
    public byte getWakeupMode() {
        return wakeupMode;
    }

    /**
     * 设置唤醒模式
     * @param wakeupMode 唤醒模式
     */
    public void setWakeupMode(byte wakeupMode) {
        this.wakeupMode = wakeupMode;
    }

    /**
     * 取唤醒条件
     * @return 唤醒条件
     */
    public byte getWakeupConditions() {
        return wakeupConditions;
    }

    /**
     * 设置唤醒条件
     * @param wakeupConditions 唤醒条件
     */
    public void setWakeupConditions(byte wakeupConditions) {
        this.wakeupConditions = wakeupConditions;
    }

    /**
     * 取每周唤醒设置
     * @return 每周唤醒设置
     */
    public byte getWeeklyWakeupSetting() {
        return weeklyWakeupSetting;
    }

    /**
     * 设置每周唤醒设置
     * @param weeklyWakeupSetting 每周唤醒设置
     */
    public void setWeeklyWakeupSetting(byte weeklyWakeupSetting) {
        this.weeklyWakeupSetting = weeklyWakeupSetting;
    }

    /**
     * 取每日唤醒设置
     * @return 每日唤醒设置
     */
    public DailyWakeupSetting getDailyWakeupSetting() {
        return dailyWakeupSetting;
    }

    /**
     * 设置每日唤醒设置
     * @param dailyWakeupSetting 每日唤醒设置
     */
    public void setDailyWakeupSetting(DailyWakeupSetting dailyWakeupSetting) {
        this.dailyWakeupSetting = dailyWakeupSetting;
    }

    @Override
    public String toString() {
        return "TP_007C_SleepWakeupSettings{" +
                "wakeupMode=" + wakeupMode +
                ", wakeupConditions=" + wakeupConditions +
                ", weeklyWakeupSetting=" + weeklyWakeupSetting +
                ", dailyWakeupSetting=" + dailyWakeupSetting +
                '}';
    }
}
