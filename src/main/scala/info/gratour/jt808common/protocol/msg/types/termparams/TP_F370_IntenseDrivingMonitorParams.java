/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 激烈驾驶监测参数
 */
public class TP_F370_IntenseDrivingMonitorParams {

    private int enableFlags;
    private short accelerateTimeThreshold;
    private short accelerateSpeedThreshold;
    private short brakeTimeThreshold;
    private short brakeSpeedThreshold;
    private short turnTimeThreshold;
    private short turnSpeedThreshold;
    private short idlingTimeThreshold;
    private short idlingSpeedThreshold;
    private short idlingRotationalSpeedThreshold;
    private short flameOutTimeThreshold;
    private short flameOutSpeedThreshold;
    private short flameOutRotationalSpeedThreshold;
    private short neutralTimeThreshold;
    private short neutralSpeedThreshold;
    private short neutralRotationalSpeedThreshold;
    private short rotationalSpeedTimeThreshold;
    private short rotationalSpeedSpeedThreshold;
    private short rotationalSpeedRpmThreshold;

    /**
     * 取报警使能标志字
     * @return 报警使能标志字
     */
    public int getEnableFlags() {
        return enableFlags;
    }

    /**
     * 设置报警使能标志字
     * @param enableFlags 报警使能标志字
     */
    public void setEnableFlags(int enableFlags) {
        this.enableFlags = enableFlags;
    }

    /**
     * 取急加速时间阈值, second
     * @return 急加速时间阈值
     */
    public short getAccelerateTimeThreshold() {
        return accelerateTimeThreshold;
    }

    /**
     * 设置急加速时间阈值
     * @param accelerateTimeThreshold 急加速时间阈值
     */
    public void setAccelerateTimeThreshold(short accelerateTimeThreshold) {
        this.accelerateTimeThreshold = accelerateTimeThreshold;
    }

    /**
     * 取急加速速度阈值, km/h
     * @return 急加速速度阈值
     */
    public short getAccelerateSpeedThreshold() {
        return accelerateSpeedThreshold;
    }

    /**
     * 设置急加速速度阈值
     * @param accelerateSpeedThreshold 急加速速度阈值
     */
    public void setAccelerateSpeedThreshold(short accelerateSpeedThreshold) {
        this.accelerateSpeedThreshold = accelerateSpeedThreshold;
    }

    /**
     * 取急刹车时间阈值
     * @return 急刹车时间阈值
     */
    public short getBrakeTimeThreshold() {
        return brakeTimeThreshold;
    }

    /**
     * 设置急刹车时间阈值
     * @param brakeTimeThreshold 急刹车时间阈值
     */
    public void setBrakeTimeThreshold(short brakeTimeThreshold) {
        this.brakeTimeThreshold = brakeTimeThreshold;
    }

    /**
     * 取急刹车速度阈值, km/h
     * @return 急刹车速度阈值
     */
    public short getBrakeSpeedThreshold() {
        return brakeSpeedThreshold;
    }

    /**
     * 设置急刹车速度阈值
     * @param brakeSpeedThreshold 急刹车速度阈值
     */
    public void setBrakeSpeedThreshold(short brakeSpeedThreshold) {
        this.brakeSpeedThreshold = brakeSpeedThreshold;
    }

    /**
     * 取急转弯时间阈值, second
     * @return 急转弯时间阈值
     */
    public short getTurnTimeThreshold() {
        return turnTimeThreshold;
    }

    /**
     * 设置急转弯时间阈值
     * @param turnTimeThreshold 急转弯时间阈值
     */
    public void setTurnTimeThreshold(short turnTimeThreshold) {
        this.turnTimeThreshold = turnTimeThreshold;
    }

    /**
     * 取急转弯速度阈值, km/h
     * @return 急转弯速度阈值
     */
    public short getTurnSpeedThreshold() {
        return turnSpeedThreshold;
    }

    /**
     * 设置急转弯速度阈值
     * @param turnSpeedThreshold 急转弯速度阈值
     */
    public void setTurnSpeedThreshold(short turnSpeedThreshold) {
        this.turnSpeedThreshold = turnSpeedThreshold;
    }

    /**
     * 取怠速时间阈值, second
     * @return 怠速时间阈值
     */
    public short getIdlingTimeThreshold() {
        return idlingTimeThreshold;
    }

    /**
     * 设置怠速时间阈值
     * @param idlingTimeThreshold 怠速时间阈值
     */
    public void setIdlingTimeThreshold(short idlingTimeThreshold) {
        this.idlingTimeThreshold = idlingTimeThreshold;
    }

    /**
     * 取怠速速度阈值, km/h
     * @return 怠速速度阈值
     */
    public short getIdlingSpeedThreshold() {
        return idlingSpeedThreshold;
    }

    /**
     * 设置怠速速度阈值
     * @param idlingSpeedThreshold 怠速速度阈值
     */
    public void setIdlingSpeedThreshold(short idlingSpeedThreshold) {
        this.idlingSpeedThreshold = idlingSpeedThreshold;
    }

    /**
     * 取怠速转速阈值
     * @return 怠速转速阈值
     */
    public short getIdlingRotationalSpeedThreshold() {
        return idlingRotationalSpeedThreshold;
    }

    /**
     * 设置怠速转速阈值
     * @param idlingRotationalSpeedThreshold 怠速转速阈值
     */
    public void setIdlingRotationalSpeedThreshold(short idlingRotationalSpeedThreshold) {
        this.idlingRotationalSpeedThreshold = idlingRotationalSpeedThreshold;
    }

    /**
     * 取异常熄火时间阈值, second
     * @return 异常熄火时间阈值
     */
    public short getFlameOutTimeThreshold() {
        return flameOutTimeThreshold;
    }

    /**
     * 设置异常熄火时间阈值
     * @param flameOutTimeThreshold 异常熄火时间阈值
     */
    public void setFlameOutTimeThreshold(short flameOutTimeThreshold) {
        this.flameOutTimeThreshold = flameOutTimeThreshold;
    }

    /**
     * 取异常熄火速度阈值, km/h
     * @return 异常熄火速度阈值
     */
    public short getFlameOutSpeedThreshold() {
        return flameOutSpeedThreshold;
    }

    /**
     * 设置异常熄火速度阈值
     * @param flameOutSpeedThreshold 异常熄火速度阈值
     */
    public void setFlameOutSpeedThreshold(short flameOutSpeedThreshold) {
        this.flameOutSpeedThreshold = flameOutSpeedThreshold;
    }

    /**
     * 取异常熄火转速阈值, rpm
     * @return 异常熄火转速阈值
     */
    public short getFlameOutRotationalSpeedThreshold() {
        return flameOutRotationalSpeedThreshold;
    }

    /**
     * 设置异常熄火转速阈值
     * @param flameOutRotationalSpeedThreshold 异常熄火转速阈值
     */
    public void setFlameOutRotationalSpeedThreshold(short flameOutRotationalSpeedThreshold) {
        this.flameOutRotationalSpeedThreshold = flameOutRotationalSpeedThreshold;
    }

    /**
     * 取空档滑行报警时间阈值, second
     * @return 空档滑行报警时间阈值
     */
    public short getNeutralTimeThreshold() {
        return neutralTimeThreshold;
    }

    /**
     * 设置空档滑行报警时间阈值
     * @param neutralTimeThreshold 空档滑行报警时间阈值
     */
    public void setNeutralTimeThreshold(short neutralTimeThreshold) {
        this.neutralTimeThreshold = neutralTimeThreshold;
    }

    /**
     * 取空档滑行报警速度阈值, km/h
     * @return 空档滑行报警速度阈值
     */
    public short getNeutralSpeedThreshold() {
        return neutralSpeedThreshold;
    }

    /**
     * 设置空档滑行报警速度阈值
     * @param neutralSpeedThreshold 空档滑行报警速度阈值
     */
    public void setNeutralSpeedThreshold(short neutralSpeedThreshold) {
        this.neutralSpeedThreshold = neutralSpeedThreshold;
    }

    /**
     * 取空档滑行报警转速阈值, rpm
     * @return 空档滑行报警转速阈值
     */
    public short getNeutralRotationalSpeedThreshold() {
        return neutralRotationalSpeedThreshold;
    }

    /**
     * 设置空档滑行报警转速阈值
     * @param neutralRotationalSpeedThreshold 空档滑行报警转速阈值
     */
    public void setNeutralRotationalSpeedThreshold(short neutralRotationalSpeedThreshold) {
        this.neutralRotationalSpeedThreshold = neutralRotationalSpeedThreshold;
    }

    /**
     * 取发动机超转报警时间阈值, second
     * @return 发动机超转报警时间阈值
     */
    public short getRotationalSpeedTimeThreshold() {
        return rotationalSpeedTimeThreshold;
    }

    /**
     * 设置发动机超转报警时间阈值
     * @param rotationalSpeedTimeThreshold 发动机超转报警时间阈值
     */
    public void setRotationalSpeedTimeThreshold(short rotationalSpeedTimeThreshold) {
        this.rotationalSpeedTimeThreshold = rotationalSpeedTimeThreshold;
    }

    /**
     * 取发动机超转报警速度阈值, km/h
     * @return 发动机超转报警速度阈值
     */
    public short getRotationalSpeedSpeedThreshold() {
        return rotationalSpeedSpeedThreshold;
    }

    /**
     * 设置发动机超转报警速度阈值, km/h
     * @param rotationalSpeedSpeedThreshold 发动机超转报警速度阈值
     */
    public void setRotationalSpeedSpeedThreshold(short rotationalSpeedSpeedThreshold) {
        this.rotationalSpeedSpeedThreshold = rotationalSpeedSpeedThreshold;
    }

    /**
     * 取发动机超转报警转速阈值, rpm
     * @return 发动机超转报警转速阈值
     */
    public short getRotationalSpeedRpmThreshold() {
        return rotationalSpeedRpmThreshold;
    }

    /**
     * 设置发动机超转报警转速阈值, rpm
     * @param rotationalSpeedRpmThreshold 发动机超转报警转速阈值
     */
    public void setRotationalSpeedRpmThreshold(short rotationalSpeedRpmThreshold) {
        this.rotationalSpeedRpmThreshold = rotationalSpeedRpmThreshold;
    }

    @Override
    public String toString() {
        return "TP_F370_IntenseDrivingMonitorParams{" +
                "enableFlags=" + enableFlags +
                ", accelerateTimeThreshold=" + accelerateTimeThreshold +
                ", accelerateSpeedThreshold=" + accelerateSpeedThreshold +
                ", brakeTimeThreshold=" + brakeTimeThreshold +
                ", brakeSpeedThreshold=" + brakeSpeedThreshold +
                ", turnTimeThreshold=" + turnTimeThreshold +
                ", turnSpeedThreshold=" + turnSpeedThreshold +
                ", idlingTimeThreshold=" + idlingTimeThreshold +
                ", idlingSpeedThreshold=" + idlingSpeedThreshold +
                ", idlingRotationalSpeedThreshold=" + idlingRotationalSpeedThreshold +
                ", flameOutTimeThreshold=" + flameOutTimeThreshold +
                ", flameOutSpeedThreshold=" + flameOutSpeedThreshold +
                ", flameOutRotationalSpeedThreshold=" + flameOutRotationalSpeedThreshold +
                ", neutralTimeThreshold=" + neutralTimeThreshold +
                ", neutralSpeedThreshold=" + neutralSpeedThreshold +
                ", neutralRotationalSpeedThreshold=" + neutralRotationalSpeedThreshold +
                ", rotationalSpeedTimeThreshold=" + rotationalSpeedTimeThreshold +
                ", rotationalSpeedSpeedThreshold=" + rotationalSpeedSpeedThreshold +
                ", rotationalSpeedRpmThreshold=" + rotationalSpeedRpmThreshold +
                '}';
    }
}
