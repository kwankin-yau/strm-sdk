/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 驾驶员行为/状态监测参数
 */
public class TP_F365_DriverBehaviorMonitorParams {

    private byte spdAlarmThreshold;
    private byte alarmVoiceVolume;
    private byte activeCapturePolicy;
    private short activeTimedCaptureIntv;
    private int activeDistancedCaptureDistance;
    private byte activeCaptureCount;
    private byte activeCaptureInterval;
    private byte captureResolution;
    private byte videoResolution;
    private int alarmEnabledFlags;
    private int eventEnabledFlags;
    private short smokeAlarmTimeThreshold;
    private short phoneCallAlarmTimeThreshold;

    private byte fatigueDrivingSpdThreshold;
    private byte fatigueDrivingRecordExt;
    private byte fatigueDrivingCaptureCnt;
    private byte fatigueDrivingCaptureIntv;

    private byte phoneCallAlarmSpdThreshold;
    private byte phoneCallAlarmRecordExt;
    private byte phoneCallAlarmFaceCaptureCnt;
    private byte phoneCallAlarmFaceCaptureIntv;

    private byte smokeAlarmSpdThreshold;
    private byte smokeAlarmRecordExt;
    private byte smokeAlarmFaceCaptureCnt;
    private byte smokeAlarmFaceCaptureIntv;

    private byte inattentionSpdThreshold;
    private byte inattentionRecordExt;
    private byte inattentionCaptureCnt;
    private byte inattentionCaptureIntv;

    private byte driverDetectUnableSpdThreshold;
    private byte driverDetectUnableRecordExt;
    private byte driverDetectUnableCaptureCnt;
    private byte driverDetectUnableCaptureIntv;

    private byte driverIdentityTrigger;

    /**
     * 取速度报警阈值, km/h
     * @return 速度报警阈值
     */
    public byte getSpdAlarmThreshold() {
        return spdAlarmThreshold;
    }

    /**
     * 设置速度报警阈值, km/h
     * @param spdAlarmThreshold 速度报警阈值
     */
    public void setSpdAlarmThreshold(byte spdAlarmThreshold) {
        this.spdAlarmThreshold = spdAlarmThreshold;
    }

    /**
     * 取报警音量
     * @return 报警音量
     */
    public byte getAlarmVoiceVolume() {
        return alarmVoiceVolume;
    }

    /**
     * 设置报警音量
     * @param alarmVoiceVolume 报警音量
     */
    public void setAlarmVoiceVolume(byte alarmVoiceVolume) {
        this.alarmVoiceVolume = alarmVoiceVolume;
    }

    /**
     * 取主动抓拍策略
     * @return 主动抓拍策略
     */
    public byte getActiveCapturePolicy() {
        return activeCapturePolicy;
    }

    /**
     * 设置主动抓拍策略
     * @param activeCapturePolicy 主动抓拍策略
     */
    public void setActiveCapturePolicy(byte activeCapturePolicy) {
        this.activeCapturePolicy = activeCapturePolicy;
    }

    /**
     * 取主动定时抓拍时间间隔, second
     * @return 主动定时抓拍时间间隔
     */
    public short getActiveTimedCaptureIntv() {
        return activeTimedCaptureIntv;
    }

    /**
     * 设置主动定时抓拍时间间隔, second
     * @param activeTimedCaptureIntv 主动定时抓拍时间间隔
     */
    public void setActiveTimedCaptureIntv(short activeTimedCaptureIntv) {
        this.activeTimedCaptureIntv = activeTimedCaptureIntv;
    }

    /**
     * 取主动定距抓拍距离, meter
     * @return 主动定距抓拍距离
     */
    public int getActiveDistancedCaptureDistance() {
        return activeDistancedCaptureDistance;
    }

    /**
     * 设置主动定距抓拍距离, meter
     * @param activeDistancedCaptureDistance 主动定距抓拍距离
     */
    public void setActiveDistancedCaptureDistance(int activeDistancedCaptureDistance) {
        this.activeDistancedCaptureDistance = activeDistancedCaptureDistance;
    }

    /**
     * 取主动抓拍张数
     * @return 主动抓拍张数
     */
    public byte getActiveCaptureCount() {
        return activeCaptureCount;
    }

    /**
     * 设置主动抓拍张数
     * @param activeCaptureCount 主动抓拍张数
     */
    public void setActiveCaptureCount(byte activeCaptureCount) {
        this.activeCaptureCount = activeCaptureCount;
    }

    /**
     * 取主动抓拍时间间隔, 100 milli-second
     * @return 主动抓拍时间间隔
     */
    public byte getActiveCaptureInterval() {
        return activeCaptureInterval;
    }

    /**
     * 设置主动抓拍时间间隔, 100 milli-second
     * @param activeCaptureInterval 主动抓拍时间间隔
     */
    public void setActiveCaptureInterval(byte activeCaptureInterval) {
        this.activeCaptureInterval = activeCaptureInterval;
    }

    /**
     * 取抓拍分辨率
     * @return 抓拍分辨率
     */
    public byte getCaptureResolution() {
        return captureResolution;
    }

    /**
     * 设置抓拍分辨率
     * @param captureResolution 抓拍分辨率
     */
    public void setCaptureResolution(byte captureResolution) {
        this.captureResolution = captureResolution;
    }

    /**
     * 取视频分辨率
     * @return 视频分辨率
     */
    public byte getVideoResolution() {
        return videoResolution;
    }

    /**
     * 设置视频分辨率
     * @param videoResolution 视频分辨率
     */
    public void setVideoResolution(byte videoResolution) {
        this.videoResolution = videoResolution;
    }

    /**
     * 取报警使能标志
     * @return 报警使能标志
     */
    public int getAlarmEnabledFlags() {
        return alarmEnabledFlags;
    }

    /**
     * 设置报警使能标志
     * @param alarmEnabledFlags 报警使能标志
     */
    public void setAlarmEnabledFlags(int alarmEnabledFlags) {
        this.alarmEnabledFlags = alarmEnabledFlags;
    }

    /**
     * 取事件使能标志
     * @return 事件使能标志
     */
    public int getEventEnabledFlags() {
        return eventEnabledFlags;
    }

    /**
     * 设置事件使能标志
     * @param eventEnabledFlags 事件使能标志
     */
    public void setEventEnabledFlags(int eventEnabledFlags) {
        this.eventEnabledFlags = eventEnabledFlags;
    }

    /**
     * 取吸烟报警判断时间间隔, second
     * @return 吸烟报警判断时间间隔
     */
    public short getSmokeAlarmTimeThreshold() {
        return smokeAlarmTimeThreshold;
    }

    /**
     * 设置吸烟报警判断时间间隔, second
     * @param smokeAlarmTimeThreshold 吸烟报警判断时间间隔
     */
    public void setSmokeAlarmTimeThreshold(short smokeAlarmTimeThreshold) {
        this.smokeAlarmTimeThreshold = smokeAlarmTimeThreshold;
    }

    /**
     * 取接打手持电话报警判断时间间隔, second
     * @return 接打手持电话报警判断时间间隔
     */
    public short getPhoneCallAlarmTimeThreshold() {
        return phoneCallAlarmTimeThreshold;
    }

    /**
     * 设置接打手持电话报警判断时间间隔, second
     * @param phoneCallAlarmTimeThreshold 接打手持电话报警判断时间间隔
     */
    public void setPhoneCallAlarmTimeThreshold(short phoneCallAlarmTimeThreshold) {
        this.phoneCallAlarmTimeThreshold = phoneCallAlarmTimeThreshold;
    }

    /**
     * 取疲劳驾驶报警速度阈值, km/h
     * @return 疲劳驾驶报警速度阈值
     */
    public byte getFatigueDrivingSpdThreshold() {
        return fatigueDrivingSpdThreshold;
    }

    /**
     * 设置疲劳驾驶报警速度阈值, km/h
     * @param fatigueDrivingSpdThreshold 疲劳驾驶报警速度阈值
     */
    public void setFatigueDrivingSpdThreshold(byte fatigueDrivingSpdThreshold) {
        this.fatigueDrivingSpdThreshold = fatigueDrivingSpdThreshold;
    }

    /**
     * 取疲劳驾驶报警前后视频录制时间, second
     * @return 疲劳驾驶报警前后视频录制时间
     */
    public byte getFatigueDrivingRecordExt() {
        return fatigueDrivingRecordExt;
    }

    /**
     * 设置疲劳驾驶报警前后视频录制时间, second
     * @param fatigueDrivingRecordExt 疲劳驾驶报警前后视频录制时间
     */
    public void setFatigueDrivingRecordExt(byte fatigueDrivingRecordExt) {
        this.fatigueDrivingRecordExt = fatigueDrivingRecordExt;
    }

    /**
     * 取疲劳驾驶报警抓拍张数
     * @return 疲劳驾驶报警抓拍张数
     */
    public byte getFatigueDrivingCaptureCnt() {
        return fatigueDrivingCaptureCnt;
    }

    /**
     * 设置疲劳驾驶报警抓拍张数
     * @param fatigueDrivingCaptureCnt 疲劳驾驶报警抓拍张数
     */
    public void setFatigueDrivingCaptureCnt(byte fatigueDrivingCaptureCnt) {
        this.fatigueDrivingCaptureCnt = fatigueDrivingCaptureCnt;
    }

    /**
     * 取疲劳驾驶报警抓拍时间间隔, 100 milli-second
     * @return 疲劳驾驶报警抓拍时间间隔
     */
    public byte getFatigueDrivingCaptureIntv() {
        return fatigueDrivingCaptureIntv;
    }

    /**
     * 设置疲劳驾驶报警抓拍时间间隔, 100 milli-second
     * @param fatigueDrivingCaptureIntv 疲劳驾驶报警抓拍时间间隔
     */
    public void setFatigueDrivingCaptureIntv(byte fatigueDrivingCaptureIntv) {
        this.fatigueDrivingCaptureIntv = fatigueDrivingCaptureIntv;
    }

    /**
     * 取接打手持电话报警分级速度阈值, km/h
     * @return 接打手持电话报警分级速度阈值
     */
    public byte getPhoneCallAlarmSpdThreshold() {
        return phoneCallAlarmSpdThreshold;
    }

    /**
     * 设置接打手持电话报警分级速度阈值, km/h
     * @param phoneCallAlarmSpdThreshold 接打手持电话报警分级速度阈值
     */
    public void setPhoneCallAlarmSpdThreshold(byte phoneCallAlarmSpdThreshold) {
        this.phoneCallAlarmSpdThreshold = phoneCallAlarmSpdThreshold;
    }

    /**
     * 取接打手持电话报警前后视频录制时间, second
     * @return 接打手持电话报警前后视频录制时间
     */
    public byte getPhoneCallAlarmRecordExt() {
        return phoneCallAlarmRecordExt;
    }

    /**
     * 设置接打手持电话报警前后视频录制时间, second
     * @param phoneCallAlarmRecordExt 接打手持电话报警前后视频录制时间
     */
    public void setPhoneCallAlarmRecordExt(byte phoneCallAlarmRecordExt) {
        this.phoneCallAlarmRecordExt = phoneCallAlarmRecordExt;
    }

    /**
     * 取接打手持电话报警抓拍驾驶员面部特征照片张数
     * @return 接打手持电话报警抓拍驾驶员面部特征照片张数
     */
    public byte getPhoneCallAlarmFaceCaptureCnt() {
        return phoneCallAlarmFaceCaptureCnt;
    }

    /**
     * 设置接打手持电话报警抓拍驾驶员面部特征照片张数
     * @param phoneCallAlarmFaceCaptureCnt 接打手持电话报警抓拍驾驶员面部特征照片张数
     */
    public void setPhoneCallAlarmFaceCaptureCnt(byte phoneCallAlarmFaceCaptureCnt) {
        this.phoneCallAlarmFaceCaptureCnt = phoneCallAlarmFaceCaptureCnt;
    }

    /**
     * 取接打手持电话报警抓拍驾驶员面部特征照片时间间隔, 100 milli-second
     * @return 接打手持电话报警抓拍驾驶员面部特征照片时间间隔
     */ 
    public byte getPhoneCallAlarmFaceCaptureIntv() {
        return phoneCallAlarmFaceCaptureIntv;
    }

    /**
     * 设置接打手持电话报警抓拍驾驶员面部特征照片时间间隔, 100 milli-second
     * @param phoneCallAlarmFaceCaptureIntv 接打手持电话报警抓拍驾驶员面部特征照片时间间隔
     */
    public void setPhoneCallAlarmFaceCaptureIntv(byte phoneCallAlarmFaceCaptureIntv) {
        this.phoneCallAlarmFaceCaptureIntv = phoneCallAlarmFaceCaptureIntv;
    }

    /**
     * 取吸烟报警分级速度阈值, km/h
     * @return 吸烟报警分级速度阈值
     */
    public byte getSmokeAlarmSpdThreshold() {
        return smokeAlarmSpdThreshold;
    }

    /**
     * 设置吸烟报警分级速度阈值, km/h
     * @param smokeAlarmSpdThreshold 吸烟报警分级速度阈值
     */
    public void setSmokeAlarmSpdThreshold(byte smokeAlarmSpdThreshold) {
        this.smokeAlarmSpdThreshold = smokeAlarmSpdThreshold;
    }

    /**
     * 取吸烟报警前后视频录制时间, second
     * @return 吸烟报警前后视频录制时间
     */
    public byte getSmokeAlarmRecordExt() {
        return smokeAlarmRecordExt;
    }

    /**
     * 设置吸烟报警前后视频录制时间, second
     * @param smokeAlarmRecordExt 吸烟报警前后视频录制时间
     */
    public void setSmokeAlarmRecordExt(byte smokeAlarmRecordExt) {
        this.smokeAlarmRecordExt = smokeAlarmRecordExt;
    }

    /**
     * 取吸烟报警抓拍驾驶员面部特征照片张数
     * @return 吸烟报警抓拍驾驶员面部特征照片张数
     */
    public byte getSmokeAlarmFaceCaptureCnt() {
        return smokeAlarmFaceCaptureCnt;
    }

    /**
     * 设置吸烟报警抓拍驾驶员面部特征照片张数
     * @param smokeAlarmFaceCaptureCnt 吸烟报警抓拍驾驶员面部特征照片张数
     */
    public void setSmokeAlarmFaceCaptureCnt(byte smokeAlarmFaceCaptureCnt) {
        this.smokeAlarmFaceCaptureCnt = smokeAlarmFaceCaptureCnt;
    }

    /**
     * 取吸烟报警抓拍驾驶员面部特征照片时间间隔, 100 milli-second
     * @return 吸烟报警抓拍驾驶员面部特征照片时间间隔
     */
    public byte getSmokeAlarmFaceCaptureIntv() {
        return smokeAlarmFaceCaptureIntv;
    }

    /**
     * 设置吸烟报警抓拍驾驶员面部特征照片时间间隔, 100 milli-second
     * @param smokeAlarmFaceCaptureIntv 吸烟报警抓拍驾驶员面部特征照片时间间隔
     */
    public void setSmokeAlarmFaceCaptureIntv(byte smokeAlarmFaceCaptureIntv) {
        this.smokeAlarmFaceCaptureIntv = smokeAlarmFaceCaptureIntv;
    }

    /**
     * 取长时间不目视前方驾驶报警速度阈值, km/h
     * @return 长时间不目视前方驾驶报警速度阈值
     */
    public byte getInattentionSpdThreshold() {
        return inattentionSpdThreshold;
    }

    /**
     * 设置长时间不目视前方驾驶报警速度阈值, km/h
     * @param inattentionSpdThreshold 长时间不目视前方驾驶报警速度阈值
     */
    public void setInattentionSpdThreshold(byte inattentionSpdThreshold) {
        this.inattentionSpdThreshold = inattentionSpdThreshold;
    }

    /**
     * 取长时间不目视前方驾驶报警前后视频录制时间, second
     * @return 长时间不目视前方驾驶报警前后视频录制时间
     */
    public byte getInattentionRecordExt() {
        return inattentionRecordExt;
    }

    /**
     * 设置长时间不目视前方驾驶报警前后视频录制时间, second
     * @param inattentionRecordExt 长时间不目视前方驾驶报警前后视频录制时间
     */
    public void setInattentionRecordExt(byte inattentionRecordExt) {
        this.inattentionRecordExt = inattentionRecordExt;
    }

    /**
     * 取长时间不目视前方驾驶报警抓拍张数
     * @return 长时间不目视前方驾驶报警抓拍张数
     */
    public byte getInattentionCaptureCnt() {
        return inattentionCaptureCnt;
    }

    /**
     * 设置长时间不目视前方驾驶报警抓拍张数
     * @param inattentionCaptureCnt 长时间不目视前方驾驶报警抓拍张数
     */
    public void setInattentionCaptureCnt(byte inattentionCaptureCnt) {
        this.inattentionCaptureCnt = inattentionCaptureCnt;
    }

    /**
     * 取长时间不目视前方驾驶报警抓拍时间间隔, 100 milli-second
     * @return 长时间不目视前方驾驶报警抓拍时间间隔
     */
    public byte getInattentionCaptureIntv() {
        return inattentionCaptureIntv;
    }

    /**
     * 设置长时间不目视前方驾驶报警抓拍时间间隔, 100 milli-second
     * @param inattentionCaptureIntv 长时间不目视前方驾驶报警抓拍时间间隔
     */
    public void setInattentionCaptureIntv(byte inattentionCaptureIntv) {
        this.inattentionCaptureIntv = inattentionCaptureIntv;
    }

    /**
     * 取未检测到驾驶员报警分级速度阈值, km/h
     * @return 未检测到驾驶员报警分级速度阈值
     */
    public byte getDriverDetectUnableSpdThreshold() {
        return driverDetectUnableSpdThreshold;
    }

    /**
     * 设置未检测到驾驶员报警分级速度阈值, km/h
     * @param driverDetectUnableSpdThreshold 未检测到驾驶员报警分级速度阈值
     */
    public void setDriverDetectUnableSpdThreshold(byte driverDetectUnableSpdThreshold) {
        this.driverDetectUnableSpdThreshold = driverDetectUnableSpdThreshold;
    }

    /**
     * 取未检测到驾驶员报警前后视频录制时间, second
     * @return 未检测到驾驶员报警前后视频录制时间
     */
    public byte getDriverDetectUnableRecordExt() {
        return driverDetectUnableRecordExt;
    }

    /**
     * 设置未检测到驾驶员报警前后视频录制时间, second
     * @param driverDetectUnableRecordExt 未检测到驾驶员报警前后视频录制时间
     */
    public void setDriverDetectUnableRecordExt(byte driverDetectUnableRecordExt) {
        this.driverDetectUnableRecordExt = driverDetectUnableRecordExt;
    }

    /**
     * 取未检测到驾驶员报警抓拍张数
     * @return 未检测到驾驶员报警抓拍张数
     */
    public byte getDriverDetectUnableCaptureCnt() {
        return driverDetectUnableCaptureCnt;
    }

    /**
     * 设置未检测到驾驶员报警抓拍张数
     * @param driverDetectUnableCaptureCnt 未检测到驾驶员报警抓拍张数
     */
    public void setDriverDetectUnableCaptureCnt(byte driverDetectUnableCaptureCnt) {
        this.driverDetectUnableCaptureCnt = driverDetectUnableCaptureCnt;
    }

    /**
     * 取未检测到驾驶员报警抓拍时间间隔, 100 milli-second
     * @return 未检测到驾驶员报警抓拍时间间隔
     */
    public byte getDriverDetectUnableCaptureIntv() {
        return driverDetectUnableCaptureIntv;
    }

    /**
     * 设置未检测到驾驶员报警抓拍时间间隔, 100 milli-second
     * @param driverDetectUnableCaptureIntv 未检测到驾驶员报警抓拍时间间隔
     */
    public void setDriverDetectUnableCaptureIntv(byte driverDetectUnableCaptureIntv) {
        this.driverDetectUnableCaptureIntv = driverDetectUnableCaptureIntv;
    }

    /**
     * 取驾驶员身份识别触发条件
     * @return 驾驶员身份识别触发条件
     */
    public byte getDriverIdentityTrigger() {
        return driverIdentityTrigger;
    }

    /**
     * 设置驾驶员身份识别触发条件
     * @param driverIdentityTrigger 驾驶员身份识别触发条件
     */
    public void setDriverIdentityTrigger(byte driverIdentityTrigger) {
        this.driverIdentityTrigger = driverIdentityTrigger;
    }

    @Override
    public String toString() {
        return "TP_F365_DriverBehaviorMonitorParams{" +
                "spdAlarmThreshold=" + spdAlarmThreshold +
                ", alarmVoiceVolume=" + alarmVoiceVolume +
                ", activeCapturePolicy=" + activeCapturePolicy +
                ", activeTimedCaptureIntv=" + activeTimedCaptureIntv +
                ", activeDistancedCaptureDistance=" + activeDistancedCaptureDistance +
                ", activeCaptureCount=" + activeCaptureCount +
                ", activeCaptureInterval=" + activeCaptureInterval +
                ", captureResolution=" + captureResolution +
                ", videoResolution=" + videoResolution +
                ", alarmEnabledFlags=" + alarmEnabledFlags +
                ", eventEnabledFlags=" + eventEnabledFlags +
                ", smokeAlarmTimeThreshold=" + smokeAlarmTimeThreshold +
                ", phoneCallAlarmTimeThreshold=" + phoneCallAlarmTimeThreshold +
                ", fatigueDrivingSpdThreshold=" + fatigueDrivingSpdThreshold +
                ", fatigueDrivingRecordExt=" + fatigueDrivingRecordExt +
                ", fatigueDrivingCaptureCnt=" + fatigueDrivingCaptureCnt +
                ", fatigueDrivingCaptureIntv=" + fatigueDrivingCaptureIntv +
                ", phoneCallAlarmSpdThreshold=" + phoneCallAlarmSpdThreshold +
                ", phoneCallAlarmRecordExt=" + phoneCallAlarmRecordExt +
                ", phoneCallAlarmFaceCaptureCnt=" + phoneCallAlarmFaceCaptureCnt +
                ", phoneCallAlarmFaceCaptureIntv=" + phoneCallAlarmFaceCaptureIntv +
                ", smokeAlarmSpdThreshold=" + smokeAlarmSpdThreshold +
                ", smokeAlarmRecordExt=" + smokeAlarmRecordExt +
                ", smokeAlarmFaceCaptureCnt=" + smokeAlarmFaceCaptureCnt +
                ", smokeAlarmFaceCaptureIntv=" + smokeAlarmFaceCaptureIntv +
                ", inattentionSpdThreshold=" + inattentionSpdThreshold +
                ", inattentionRecordExt=" + inattentionRecordExt +
                ", inattentionCaptureCnt=" + inattentionCaptureCnt +
                ", inattentionCaptureIntv=" + inattentionCaptureIntv +
                ", driverDetectUnableSpdThreshold=" + driverDetectUnableSpdThreshold +
                ", driverDetectUnableRecordExt=" + driverDetectUnableRecordExt +
                ", driverDetectUnableCaptureCnt=" + driverDetectUnableCaptureCnt +
                ", driverDetectUnableCaptureIntv=" + driverDetectUnableCaptureIntv +
                ", driverIdentityTrigger=" + driverIdentityTrigger +
                '}';
    }
}
