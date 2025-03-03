/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 驾驶辅助参数(0x0364)
 */
public class TP_F364_DrivingAssistParams {

    private byte overSpdAlarmThreshold;
    private byte alarmVoiceVolume;
    private byte activeCapturePolicy;
    private short activeTimedCaptureInterval;
    private int activeDistancedCaptureDistance;
    private byte activeCaptureCount;
    private byte activeCaptureInterval;
    private byte captureResolution;
    private byte videoResolution;
    private int alarmEnabledFlags;
    private int eventEnabledFlags;
    private byte obstacleDistance;
    private byte obstacleAlarmSpdThreshold;
    private byte obstacleAlarmRecordExt;
    private byte obstacleCaptureCount;
    private byte obstacleCaptureInterval;
    private byte changeLaneFreqAlarmTimeWindow;
    private byte changeLaneFreqAlarmTimes;
    private byte changeLaneFreqSpdThreshold;
    private byte changeLaneFreqRecordExt;
    private byte changeLaneFreqCaptureCount;
    private byte changeLaneFreqCaptureInterval;

    private byte strayPathAlarmSpdThreshold;
    private byte strayPathAlarmRecordExt;
    private byte strayPathAlarmCaptureCount;
    private byte strayPathAlarmCaptureInterval;

    private byte crashAlarmTimeThreshold;
    private byte crashAlarmSpdThreshold;
    private byte crashAlarmRecordExt;
    private byte crashAlarmCaptureCount;
    private byte crashAlarmCaptureInterval;
    private byte hitAlarmTimeThreshold;
    private byte hitAlarmSpdThreshold;
    private byte hitAlarmRecordExt;
    private byte hitAlarmCaptureCount;
    private byte hitAlarmCaptureInterval;
    private byte safeDistanceAlarmDistanceThreshold;
    private byte safeDistanceAlarmSpdThreshold;
    private byte safeDistanceAlarmRecordExt;
    private byte safeDistanceAlarmCaptureCount;
    private byte safeDistanceAlarmCaptureInterval;
    private byte roadSignCaptureCount;
    private byte roadSignCaptureInterval;

    /**
     * 取超速报警阈值, km/h
     * @return 超速报警阈值
     */
    public byte getOverSpdAlarmThreshold() {
        return overSpdAlarmThreshold;
    }

    /**
     * 设置超速报警阈值, km/h
     * @param overSpdAlarmThreshold 超速报警阈值
     */
    public void setOverSpdAlarmThreshold(byte overSpdAlarmThreshold) {
        this.overSpdAlarmThreshold = overSpdAlarmThreshold;
    }

    /**
     * 取报警语音音量
     * @return 报警语音音量
     */
    public byte getAlarmVoiceVolume() {
        return alarmVoiceVolume;
    }

    /**
     * 设置报警语音音量
     * @param alarmVoiceVolume 报警语音音量
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
    public short getActiveTimedCaptureInterval() {
        return activeTimedCaptureInterval;
    }

    /**
     * 设置主动定时抓拍时间间隔, second
     * @param activeTimedCaptureInterval 主动定时抓拍时间间隔
     */
    public void setActiveTimedCaptureInterval(short activeTimedCaptureInterval) {
        this.activeTimedCaptureInterval = activeTimedCaptureInterval;
    }

    /**
     * 取主动定距抓拍的距离, meter
     * @return 主动定距抓拍的距离
     */
    public int getActiveDistancedCaptureDistance() {
        return activeDistancedCaptureDistance;
    }

    /**
     * 设置主动定距抓拍的距离, meter
     * @param activeDistancedCaptureDistance 主动定距抓拍的距离
     */
    public void setActiveDistancedCaptureDistance(int activeDistancedCaptureDistance) {
        this.activeDistancedCaptureDistance = activeDistancedCaptureDistance;
    }

    /**
     * 取单次主动抓拍张数
     * @return 单次主动抓拍张数
     */
    public byte getActiveCaptureCount() {
        return activeCaptureCount;
    }

    /**
     * 设置单次主动抓拍张数
     * @param activeCaptureCount 单次主动抓拍张数
     */
    public void setActiveCaptureCount(byte activeCaptureCount) {
        this.activeCaptureCount = activeCaptureCount;
    }

    /**
     * 取单次主动抓拍时间间隔, second
     * @return 单次主动抓拍时间间隔
     */
    public byte getActiveCaptureInterval() {
        return activeCaptureInterval;
    }

    /**
     * 设置单次主动抓拍时间间隔, second
     * @param activeCaptureInterval 单次主动抓拍时间间隔
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
     * 取视频录制分辨率
     * @return 视频录制分辨率
     */
    public byte getVideoResolution() {
        return videoResolution;
    }

    /**
     * 设置视频录制分辨率
     * @param videoResolution 视频录制分辨率
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
     * 取障碍物报警距离阈值, 100 miilis-meter
     * @return 障碍物报警距离阈值
     */
    public byte getObstacleDistance() {
        return obstacleDistance;
    }

    /**
     * 设置障碍物报警距离阈值, 100 miilis-meter
     * @param obstacleDistance 障碍物报警距离阈值
     */
    public void setObstacleDistance(byte obstacleDistance) {
        this.obstacleDistance = obstacleDistance;
    }

    /**
     * 取障碍物报警速度阈值, km/h
     * @return 障碍物报警速度阈值
     */
    public byte getObstacleAlarmSpdThreshold() {
        return obstacleAlarmSpdThreshold;
    }

    /**
     * 设置障碍物报警速度阈值, km/h
     * @param obstacleAlarmSpdThreshold 障碍物报警速度阈值
     */
    public void setObstacleAlarmSpdThreshold(byte obstacleAlarmSpdThreshold) {
        this.obstacleAlarmSpdThreshold = obstacleAlarmSpdThreshold;
    }

    /**
     * 取障碍物报警前后视频录制时间，秒
     * @return 障碍物报警前后视频录制时间
     */
    public byte getObstacleAlarmRecordExt() {
        return obstacleAlarmRecordExt;
    }

    /**
     * 设置障碍物报警前后视频录制时间，秒
     * @param obstacleAlarmRecordExt 障碍物报警前后视频录制时间
     */
    public void setObstacleAlarmRecordExt(byte obstacleAlarmRecordExt) {
        this.obstacleAlarmRecordExt = obstacleAlarmRecordExt;
    }

    /**
     * 取障碍物报警抓拍张数
     * @return 障碍物报警抓拍张数
     */
    public byte getObstacleCaptureCount() {
        return obstacleCaptureCount;
    }

    /**
     * 设置障碍物报警抓拍张数
     * @param obstacleCaptureCount 障碍物报警抓拍张数
     */
    public void setObstacleCaptureCount(byte obstacleCaptureCount) {
        this.obstacleCaptureCount = obstacleCaptureCount;
    }

    /**
     * 取障碍物报警抓拍时间间隔, 100 milli-second
     * @return 障碍物报警抓拍时间间隔
     */
    public byte getObstacleCaptureInterval() {
        return obstacleCaptureInterval;
    }

    /**
     * 设置障碍物报警抓拍时间间隔, 100 milli-second
     * @param obstacleCaptureInterval 障碍物报警抓拍时间间隔
     */
    public void setObstacleCaptureInterval(byte obstacleCaptureInterval) {
        this.obstacleCaptureInterval = obstacleCaptureInterval;
    }

    /**
     * 取频繁变道报警判断时间段, second
     * @return 频繁变道报警判断时间段
     */
    public byte getChangeLaneFreqAlarmTimeWindow() {
        return changeLaneFreqAlarmTimeWindow;
    }

    /**
     * 设置频繁变道报警判断时间段, second
     * @param changeLaneFreqAlarmTimeWindow 频繁变道报警判断时间段
     */
    public void setChangeLaneFreqAlarmTimeWindow(byte changeLaneFreqAlarmTimeWindow) {
        this.changeLaneFreqAlarmTimeWindow = changeLaneFreqAlarmTimeWindow;
    }

    /**
     * 取频繁变道报警判断次数
     * @return 频繁变道报警判断次数
     */
    public byte getChangeLaneFreqAlarmTimes() {
        return changeLaneFreqAlarmTimes;
    }

    /**
     * 设置频繁变道报警判断次数
     * @param changeLaneFreqAlarmTimes 频繁变道报警判断次数
     */
    public void setChangeLaneFreqAlarmTimes(byte changeLaneFreqAlarmTimes) {
        this.changeLaneFreqAlarmTimes = changeLaneFreqAlarmTimes;
    }

    /**
     * 取频繁变道报警速度阈值, km/h
     * @return 频繁变道报警速度阈值
     */
    public byte getChangeLaneFreqSpdThreshold() {
        return changeLaneFreqSpdThreshold;
    }

    /**
     * 设置频繁变道报警速度阈值, km/h
     * @param changeLaneFreqSpdThreshold 频繁变道报警速度阈值
     */
    public void setChangeLaneFreqSpdThreshold(byte changeLaneFreqSpdThreshold) {
        this.changeLaneFreqSpdThreshold = changeLaneFreqSpdThreshold;
    }

    /**
     * 取频繁变道报警前后视频录制时间，秒
     * @return 频繁变道报警前后视频录制时间
     */
    public byte getChangeLaneFreqRecordExt() {
        return changeLaneFreqRecordExt;
    }

    /**
     * 设置频繁变道报警前后视频录制时间，秒
     * @param changeLaneFreqRecordExt 频繁变道报警前后视频录制时间
     */
    public void setChangeLaneFreqRecordExt(byte changeLaneFreqRecordExt) {
        this.changeLaneFreqRecordExt = changeLaneFreqRecordExt;
    }

    /**
     * 取频繁变道报警抓拍张数
     * @return 频繁变道报警抓拍张数
     */
    public byte getChangeLaneFreqCaptureCount() {
        return changeLaneFreqCaptureCount;
    }

    /**
     * 设置频繁变道报警抓拍张数
     * @param changeLaneFreqCaptureCount 频繁变道报警抓拍张数
     */
    public void setChangeLaneFreqCaptureCount(byte changeLaneFreqCaptureCount) {
        this.changeLaneFreqCaptureCount = changeLaneFreqCaptureCount;
    }

    /**
     * 取频繁变道报警抓拍时间间隔, 100 milli-second
     * @return 频繁变道报警抓拍时间间隔
     */
    public byte getChangeLaneFreqCaptureInterval() {
        return changeLaneFreqCaptureInterval;
    }

    /**
     * 设置频繁变道报警抓拍时间间隔, 100 milli-second
     * @param changeLaneFreqCaptureInterval 频繁变道报警抓拍时间间隔
     */
    public void setChangeLaneFreqCaptureInterval(byte changeLaneFreqCaptureInterval) {
        this.changeLaneFreqCaptureInterval = changeLaneFreqCaptureInterval;
    }

    /**
     * 取车道偏离报警速度阈值, km/h
     * @return 车道偏离报警速度阈值
     */
    public byte getStrayPathAlarmSpdThreshold() {
        return strayPathAlarmSpdThreshold;
    }

    /**
     * 设置车道偏离报警速度阈值, km/h
     * @param strayPathAlarmSpdThreshold 车道偏离报警速度阈值
     */
    public void setStrayPathAlarmSpdThreshold(byte strayPathAlarmSpdThreshold) {
        this.strayPathAlarmSpdThreshold = strayPathAlarmSpdThreshold;
    }

    /**
     * 取车道偏离报警前后视频录制时间，秒
     * @return 车道偏离报警前后视频录制时间
     */
    public byte getStrayPathAlarmRecordExt() {
        return strayPathAlarmRecordExt;
    }

    /**
     * 设置车道偏离报警前后视频录制时间，秒
     * @param strayPathAlarmRecordExt 车道偏离报警前后视频录制时间
     */
    public void setStrayPathAlarmRecordExt(byte strayPathAlarmRecordExt) {
        this.strayPathAlarmRecordExt = strayPathAlarmRecordExt;
    }

    /**
     * 取车道偏离报警抓拍张数
     * @return 车道偏离报警抓拍张数
     */
    public byte getStrayPathAlarmCaptureCount() {
        return strayPathAlarmCaptureCount;
    }

    /**
     * 设置车道偏离报警抓拍张数
     * @param strayPathAlarmCaptureCount 车道偏离报警抓拍张数
     */
    public void setStrayPathAlarmCaptureCount(byte strayPathAlarmCaptureCount) {
        this.strayPathAlarmCaptureCount = strayPathAlarmCaptureCount;
    }

    /**
     * 取车道偏离报警抓拍时间间隔, 100 milli-second
     * @return 车道偏离报警抓拍时间间隔
     */
    public byte getStrayPathAlarmCaptureInterval() {
        return strayPathAlarmCaptureInterval;
    }

    /**
     * 设置车道偏离报警抓拍时间间隔, 100 milli-second
     * @param strayPathAlarmCaptureInterval 车道偏离报警抓拍时间间隔
     */
    public void setStrayPathAlarmCaptureInterval(byte strayPathAlarmCaptureInterval) {
        this.strayPathAlarmCaptureInterval = strayPathAlarmCaptureInterval;
    }

    /**
     * 取前向碰撞报警时间阈值, 100 milli-second
     * @return 前向碰撞报警时间阈值
     */
    public byte getCrashAlarmTimeThreshold() {
        return crashAlarmTimeThreshold;
    }

    /**
     * 设置前向碰撞报警时间阈值, 100 milli-second
     * @param crashAlarmTimeThreshold 前向碰撞报警时间阈值
     */
    public void setCrashAlarmTimeThreshold(byte crashAlarmTimeThreshold) {
        this.crashAlarmTimeThreshold = crashAlarmTimeThreshold;
    }

    /**
     * 取前向碰撞报警速度阈值, km/h
     * @return 前向碰撞报警速度阈值
     */
    public byte getCrashAlarmSpdThreshold() {
        return crashAlarmSpdThreshold;
    }

    /**
     * 设置前向碰撞报警速度阈值, km/h
     * @param crashAlarmSpdThreshold 前向碰撞报警速度阈值
     */
    public void setCrashAlarmSpdThreshold(byte crashAlarmSpdThreshold) {
        this.crashAlarmSpdThreshold = crashAlarmSpdThreshold;
    }

    /**
     * 取前向碰撞报警前后视频录制时间，秒
     * @return 前向碰撞报警前后视频录制时间
     */
    public byte getCrashAlarmRecordExt() {
        return crashAlarmRecordExt;
    }

    /**
     * 设置前向碰撞报警前后视频录制时间，秒
     * @param crashAlarmRecordExt 前向碰撞报警前后视频录制时间
     */
    public void setCrashAlarmRecordExt(byte crashAlarmRecordExt) {
        this.crashAlarmRecordExt = crashAlarmRecordExt;
    }

    /**
     * 取前向碰撞报警抓拍张数
     * @return 前向碰撞报警抓拍张数
     */
    public byte getCrashAlarmCaptureCount() {
        return crashAlarmCaptureCount;
    }

    /**
     * 设置前向碰撞报警抓拍张数
     * @param crashAlarmCaptureCount 前向碰撞报警抓拍张数
     */
    public void setCrashAlarmCaptureCount(byte crashAlarmCaptureCount) {
        this.crashAlarmCaptureCount = crashAlarmCaptureCount;
    }

    /**
     * 取前向碰撞报警抓拍时间间隔, 100 milli-second
     * @return 前向碰撞报警抓拍时间间隔
     */
    public byte getCrashAlarmCaptureInterval() {
        return crashAlarmCaptureInterval;
    }

    /**
     * 设置前向碰撞报警抓拍时间间隔, 100 milli-second
     * @param crashAlarmCaptureInterval 前向碰撞报警抓拍时间间隔
     */
    public void setCrashAlarmCaptureInterval(byte crashAlarmCaptureInterval) {
        this.crashAlarmCaptureInterval = crashAlarmCaptureInterval;
    }

    /**
     * 取行人碰撞报警时间阈值, 100 milli-second
     * @return 行人碰撞报警时间阈值
     */
    public byte getHitAlarmTimeThreshold() {
        return hitAlarmTimeThreshold;
    }

    /**
     * 设置行人碰撞报警时间阈值, 100 milli-second
     * @param hitAlarmTimeThreshold 行人碰撞报警时间阈值
     */
    public void setHitAlarmTimeThreshold(byte hitAlarmTimeThreshold) {
        this.hitAlarmTimeThreshold = hitAlarmTimeThreshold;
    }

    /**
     * 取行人碰撞报警速度阈值, km/h
     * @return 行人碰撞报警速度阈值
     */
    public byte getHitAlarmSpdThreshold() {
        return hitAlarmSpdThreshold;
    }

    /**
     * 设置行人碰撞报警速度阈值, km/h
     * @param hitAlarmSpdThreshold 行人碰撞报警速度阈值
     */
    public void setHitAlarmSpdThreshold(byte hitAlarmSpdThreshold) {
        this.hitAlarmSpdThreshold = hitAlarmSpdThreshold;
    }

    /**
     * 取行人碰撞报警前后视频录制时间，秒
     * @return 行人碰撞报警前后视频录制时间
     */
    public byte getHitAlarmRecordExt() {
        return hitAlarmRecordExt;
    }

    /**
     * 设置行人碰撞报警前后视频录制时间，秒
     * @param hitAlarmRecordExt 行人碰撞报警前后视频录制时间
     */
    public void setHitAlarmRecordExt(byte hitAlarmRecordExt) {
        this.hitAlarmRecordExt = hitAlarmRecordExt;
    }

    /**
     * 取行人碰撞报警抓拍张数
     * @return 行人碰撞报警抓拍张数
     */
    public byte getHitAlarmCaptureCount() {
        return hitAlarmCaptureCount;
    }

    /**
     * 设置行人碰撞报警抓拍张数
     * @param hitAlarmCaptureCount 行人碰撞报警抓拍张数
     */
    public void setHitAlarmCaptureCount(byte hitAlarmCaptureCount) {
        this.hitAlarmCaptureCount = hitAlarmCaptureCount;
    }

    /**
     * 取行人碰撞报警抓拍时间间隔, 100 milli-second
     * @return 行人碰撞报警抓拍时间间隔
     */
    public byte getHitAlarmCaptureInterval() {
        return hitAlarmCaptureInterval;
    }

    /**
     * 设置行人碰撞报警抓拍时间间隔, 100 milli-second
     * @param hitAlarmCaptureInterval 行人碰撞报警抓拍时间间隔
     */
    public void setHitAlarmCaptureInterval(byte hitAlarmCaptureInterval) {
        this.hitAlarmCaptureInterval = hitAlarmCaptureInterval;
    }

    /**
     * 取车距过近报警距离阈值, 100 millis-meter
     * @return 车距过近报警距离阈值
     */
    public byte getSafeDistanceAlarmDistanceThreshold() {
        return safeDistanceAlarmDistanceThreshold;
    }

    /**
     * 设置车距过近报警距离阈值, 100 millis-meter
     * @param safeDistanceAlarmDistanceThreshold 车距过近报警距离阈值
     */
    public void setSafeDistanceAlarmDistanceThreshold(byte safeDistanceAlarmDistanceThreshold) {
        this.safeDistanceAlarmDistanceThreshold = safeDistanceAlarmDistanceThreshold;
    }

    /**
     * 取车距过近报警速度阈值, km/h
     * @return 车距过近报警速度阈值
     */
    public byte getSafeDistanceAlarmSpdThreshold() {
        return safeDistanceAlarmSpdThreshold;
    }

    /**
     * 设置车距过近报警速度阈值, km/h
     * @param safeDistanceAlarmSpdThreshold 车距过近报警速度阈值
     */
    public void setSafeDistanceAlarmSpdThreshold(byte safeDistanceAlarmSpdThreshold) {
        this.safeDistanceAlarmSpdThreshold = safeDistanceAlarmSpdThreshold;
    }

    /**
     * 取车距过近报警前后视频录制时间，秒
     * @return 车距过近报警前后视频录制时间
     */
    public byte getSafeDistanceAlarmRecordExt() {
        return safeDistanceAlarmRecordExt;
    }

    /**
     * 设置车距过近报警前后视频录制时间，秒
     * @param safeDistanceAlarmRecordExt 车距过近报警前后视频录制时间
     */
    public void setSafeDistanceAlarmRecordExt(byte safeDistanceAlarmRecordExt) {
        this.safeDistanceAlarmRecordExt = safeDistanceAlarmRecordExt;
    }

    /**
     * 取车距过近报警抓拍张数
     * @return 车距过近报警抓拍张数
     */
    public byte getSafeDistanceAlarmCaptureCount() {
        return safeDistanceAlarmCaptureCount;
    }

    /**
     * 设置车距过近报警抓拍张数
     * @param safeDistanceAlarmCaptureCount 车距过近报警抓拍张数
     */
    public void setSafeDistanceAlarmCaptureCount(byte safeDistanceAlarmCaptureCount) {
        this.safeDistanceAlarmCaptureCount = safeDistanceAlarmCaptureCount;
    }

    /**
     * 取车距过近报警抓拍时间间隔, 100 milli-second
     * @return 车距过近报警抓拍时间间隔
     */
    public byte getSafeDistanceAlarmCaptureInterval() {
        return safeDistanceAlarmCaptureInterval;
    }

    /**
     * 设置车距过近报警抓拍时间间隔, 100 milli-second
     * @param safeDistanceAlarmCaptureInterval 车距过近报警抓拍时间间隔
     */
    public void setSafeDistanceAlarmCaptureInterval(byte safeDistanceAlarmCaptureInterval) {
        this.safeDistanceAlarmCaptureInterval = safeDistanceAlarmCaptureInterval;
    }

    /**
     * 取道路标志识别抓拍张数
     * @return 道路标志识别抓拍张数
     */
    public byte getRoadSignCaptureCount() {
        return roadSignCaptureCount;
    }

    /**
     * 设置道路标志识别抓拍张数
     * @param roadSignCaptureCount 道路标志识别抓拍张数
     */
    public void setRoadSignCaptureCount(byte roadSignCaptureCount) {
        this.roadSignCaptureCount = roadSignCaptureCount;
    }

    /**
     * 取道路标志识别抓拍时间间隔, 100 milli-second
     * @return 道路标志识别抓拍时间间隔
     */
    public byte getRoadSignCaptureInterval() {
        return roadSignCaptureInterval;
    }

    /**
     * 设置道路标志识别抓拍时间间隔, 100 milli-second
     * @param roadSignCaptureInterval 道路标志识别抓拍时间间隔
     */
    public void setRoadSignCaptureInterval(byte roadSignCaptureInterval) {
        this.roadSignCaptureInterval = roadSignCaptureInterval;
    }

    @Override
    public String toString() {
        return "TP_F364_DrivingAssistParams{" +
                "overSpdAlarmThreshold=" + overSpdAlarmThreshold +
                ", alarmVoiceVolume=" + alarmVoiceVolume +
                ", activeCapturePolicy=" + activeCapturePolicy +
                ", activeTimedCaptureInterval=" + activeTimedCaptureInterval +
                ", activeDistancedCaptureDistance=" + activeDistancedCaptureDistance +
                ", activeCaptureCount=" + activeCaptureCount +
                ", activeCaptureInterval=" + activeCaptureInterval +
                ", captureResolution=" + captureResolution +
                ", videoResolution=" + videoResolution +
                ", alarmEnabledFlags=" + alarmEnabledFlags +
                ", eventEnabledFlags=" + eventEnabledFlags +
                ", obstacleDistance=" + obstacleDistance +
                ", obstacleAlarmSpdThreshold=" + obstacleAlarmSpdThreshold +
                ", obstacleAlarmRecordExt=" + obstacleAlarmRecordExt +
                ", obstacleCaptureCount=" + obstacleCaptureCount +
                ", obstacleCaptureInterval=" + obstacleCaptureInterval +
                ", changeLaneFreqAlarmTimeWindow=" + changeLaneFreqAlarmTimeWindow +
                ", changeLaneFreqAlarmTimes=" + changeLaneFreqAlarmTimes +
                ", changeLaneFreqSpdThreshold=" + changeLaneFreqSpdThreshold +
                ", changeLaneFreqRecordExt=" + changeLaneFreqRecordExt +
                ", changeLaneFreqCaptureCount=" + changeLaneFreqCaptureCount +
                ", changeLaneFreqCaptureInterval=" + changeLaneFreqCaptureInterval +
                ", strayPathAlarmSpdThreshold=" + strayPathAlarmSpdThreshold +
                ", strayPathAlarmRecordExt=" + strayPathAlarmRecordExt +
                ", strayPathAlarmCaptureCount=" + strayPathAlarmCaptureCount +
                ", strayPathAlarmCaptureInterval=" + strayPathAlarmCaptureInterval +
                ", crashAlarmTimeThreshold=" + crashAlarmTimeThreshold +
                ", crashAlarmSpdThreshold=" + crashAlarmSpdThreshold +
                ", crashAlarmRecordExt=" + crashAlarmRecordExt +
                ", crashAlarmCaptureCount=" + crashAlarmCaptureCount +
                ", crashAlarmCaptureInterval=" + crashAlarmCaptureInterval +
                ", hitAlarmTimeThreshold=" + hitAlarmTimeThreshold +
                ", hitAlarmSpdThreshold=" + hitAlarmSpdThreshold +
                ", hitAlarmRecordExt=" + hitAlarmRecordExt +
                ", hitAlarmCaptureCount=" + hitAlarmCaptureCount +
                ", hitAlarmCaptureInterval=" + hitAlarmCaptureInterval +
                ", safeDistanceAlarmDistanceThreshold=" + safeDistanceAlarmDistanceThreshold +
                ", safeDistanceAlarmSpdThreshold=" + safeDistanceAlarmSpdThreshold +
                ", safeDistanceAlarmRecordExt=" + safeDistanceAlarmRecordExt +
                ", safeDistanceAlarmCaptureCount=" + safeDistanceAlarmCaptureCount +
                ", safeDistanceAlarmCaptureInterval=" + safeDistanceAlarmCaptureInterval +
                ", roadSignCaptureCount=" + roadSignCaptureCount +
                ", roadSignCaptureInterval=" + roadSignCaptureInterval +
                '}';
    }
}
