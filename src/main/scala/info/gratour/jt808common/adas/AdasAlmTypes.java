/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.adas;

import info.gratour.jtcommon.AlmTypes;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 平台ADAS报警类型定义。
 * <p>
 * 报警类型标识由4位HEX数字组成。以 `02` 开头
 */
public class AdasAlmTypes {

    /**
     * 判断给定的报警类型是否 ADAS 报警类型
     * @param typ 所要判断的报警类型
     * @return 是否 ADAS 报警类型
     */
    public static boolean isAdasAlmType(String typ) {
        if (typ == null || typ.length() != 4)
            return false;

        return typ.startsWith("02");
    }

    /**
     * 高级驾驶辅助系统报警
     */
    public static class DrivingAssistAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "020";

        /**
         * 判断给定报警类型是否高级驾驶辅助系统报警
         * @param typ 所要判断的报警类型
         * @return 是否高级驾驶辅助系统报警
         */
        public static boolean isDrivingAssistAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 前向碰撞报警
         */
        public static final String FrontCrash = AlmTypes.TYP_0201_ADAS_FRONT_CRASH();

        /**
         * 车道偏离报警
         */
        public static final String StrayPath = AlmTypes.TYP_0202_ADAS_STRAY_PATH();

        /**
         * 车距过近报警
         */
        public static final String TooCloseToFrontCar = AlmTypes.TYP_0203_ADAS_VEH_TOO_CLOSE();

        /**
         * 行人碰撞报警
         */
        public static final String PedestrianHit = AlmTypes.TYP_0204_ADAS_PEDESTRIAN_HIT();

        /**
         * 频繁变道报警
         */
        public static final String ChangeLaneFrequently = AlmTypes.TYP_0205_ADAS_CHANGE_LANE_FREQUENTLY();

        /**
         * 道路标识超限报警
         */
        public static final String RoadRecogMarkOverrun = AlmTypes.TYP_0206_ADAS_ROAD_RECOG_OVERRUN();

        /**
         * 障碍物报警
         */
        public static final String Obstacle = AlmTypes.TYP_0207_ADAS_OBSTACLE();

        /**
         * 驾驶辅助功能失效报警 / 设备失效提醒（湘标）
         */
        public static final String AssistFuncFailure = AlmTypes.TYP_0208_ADAS_DRIVING_ASSIST_FUNC_FAILURE();

        /**
         * 道路标志识别事件
         */
        public static final String RoadSignRecogEvent = AlmTypes.TYP_0209_ADAS_ROAD_SIGN_RECOG_EVENT();

        /**
         * 主动抓拍识别事件
         */
        public static final String ActiveCaptureEvent = AlmTypes.TYP_021F_ADAS_DRIVER_BEHAV_ACTIVE_CAPTURE();

        /**
         * 实线变道报警
         */
        public static final String ViolatedChangePath = AlmTypes.TYP_020A_ADAS_VIOLATED_CHANGE_PATH();

        /**
         * 车厢过道行人监测
         */
        public static final String PassengerAtCarriageHallwayDetected = AlmTypes.TYP_020B_ADAS_PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0200";
    }

    /**
     * 驾驶员状态监测系统报警
     */
    public static class DriverBehavAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "021";

        /**
         * 判断给定报警类型是否驾驶员状态监测系统报警
         * @param typ 所要判断的报警类型
         * @return 是否驾驶员状态监测系统报警
         */
        public static boolean isDriverBehavAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 疲劳驾驶报警
         */
        public static final String Fatigued = AlmTypes.TYP_0211_ADAS_FATIGUED();

        /**
         * 接打手持电话报警
         */
        public static final String PhoneCall = AlmTypes.TYP_0214_ADAS_PHONE_CALL();

        /**
         * 抽烟报警报警
         */
        public static final String Smoke = AlmTypes.TYP_0213_ADAS_SMOKE();

        /**
         * 长时间不目视前方报警
         */
        public static final String NoLookAhead = AlmTypes.TYP_0212_ADAS_NO_LOOK_AHEAD();

        /**
         * 未检测到驾驶员报警
         */
        public static final String DriverNotDetected = AlmTypes.TYP_0215_ADAS_DRIVER_NOT_DETECTED();

        /**
         * 双手同时脱离方向盘报警
         */
        public static final String SteeringWheelNotHolding = AlmTypes.TYP_0216_ADAS_STEERING_WHEEL_NOT_HOLDING();

        /**
         * 驾驶员行为监测功能失效报警
         */
        public static final String DriverBehavAlmFuncFailure = AlmTypes.TYP_0217_ADAS_DRIVER_BEHAV_ALM_FUNC_FAILURE();

        /**
         * 未系安全带报警
         */
        public static final String NotBelting = AlmTypes.TYP_021D_ADAS_DRIVER_BEHAV_NOT_BELTING();

        /**
         * 红外阻断型墨镜失效报警
         */
        public static final String AntiFaceRecogDetectFuncFailure = AlmTypes.TYP_021E_ADAS_ANTI_FACE_RECOG_DETECT_FUNC_FAILURE();

        /**
         * 玩手机报警
         */
        public static final String PlaySmartPhone = AlmTypes.TYP_021J_ADAS_PLAY_SMART_PHONE();

        /**
         * 夜间禁行报警
         */
        public static final String NightDriveProhibited = AlmTypes.TYP_021A_ADAS_NIGHT_DRIVE_PROHIBITED();

        /**
         * 超时驾驶报警
         */
        public static final String DriveOvertime = AlmTypes.TYP_021B_ADAS_DRIVE_OVERTIME();

        /**
         * 自动抓拍事件
         */
        public static final String AutoCapture = AlmTypes.TYP_021C_ADAS_DRIVER_BEHAV_AUTO_CAPTURE();

        /**
         * 驾驶员变更事件
         */
        public static final String DriverChangedEvent = AlmTypes.TYP_0219_ADAS_DRIVER_BEHAV_DRIVER_CHANGED_EVENT();

        /**
         * 驾驶员身份异常
         */
        public static final String InvalidDriverId = AlmTypes.TYP_0218_ADAS_INVALID_DRIVER_ID();

        /**
         * 点火抓拍事件
         */
        public static final String IgnitedCapture = AlmTypes.TYP_021F_ADAS_DRIVER_BEHAV_ACTIVE_CAPTURE();

        /**
         * 探头遮挡报警（粤标）
         */
        public static final String CameraCovered = AlmTypes.TYP_021H_ADAS_DRIVER_ASSIST_CAMERA_COVERED();



        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0210";
    }

    /**
     * 胎压监测系统报警
     */
    public static class TyreStateAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "022";

        /**
         * 判断给定报警类型是否胎压监测系统报警
         * @param typ 所要判断的报警类型
         * @return 是否胎压监测系统报警
         */
        public static boolean isTyreStateAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 胎压过高报警
         */
        public static final String TYRE_PRESS_TOO_HIGH = AlmTypes.TYP_0221_ADAS_TYRE_PRESS_TOO_HIGH();

        /**
         * 胎压过低报警
         */
        public static final String TYRE_PRESS_TOO_LOW = AlmTypes.TYP_0222_ADAS_TYRE_PRESS_TOO_LOW();

        /**
         * 轮胎温度过高报警
         */
        public static final String TYRE_TEMP_TOO_HIGH = AlmTypes.TYP_0223_ADAS_TYRE_TEMP_TOO_HIGH();

        /**
         * 轮胎传感器异常报警
         */
        public static final String TYRE_SENSOR_FAILURE = AlmTypes.TYP_0224_ADAS_TYRE_SENSOR_FAILURE();

        /**
         * 胎压不平衡报警
         */
        public static final String TYRE_PRESS_DISBALANCE = AlmTypes.TYP_0225_ADAS_TYRE_PRESS_DISBALANCE();

        /**
         * 轮胎慢漏气报警
         */
        public static final String TYRE_AIR_LEAK_SLOWLY = AlmTypes.TYP_0226_ADAS_TYRE_AIR_LEAK_SLOWLY();

        /**
         * 电池电压低报警
         */
        public static final String BATTERY_LOW = AlmTypes.TYP_0227_ADAS_BATTERY_LOW();
    }

    /**
     * 盲区监测系统报警
     */
    public static class BlindAreaAlm {
        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "023";

        /**
         * 判断给定报警类型是否盲区监测系统报警
         * @param typ 所要判断的报警类型
         * @return 是否盲区监测系统报警
         */
        public static boolean isBlindAreaAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 后方接近报警
         */
        public static final String RearTooClose = AlmTypes.TYP_0231_ADAS_REAR_TOO_CLOSE();

        /**
         * 左侧后方接近报警
         */
        public static final String LeftRearTooClose = AlmTypes.TYP_0232_ADAS_LEFT_REAR_TOO_CLOSE();

        /**
         * 右侧后方接近报警
         */
        public static final String RightRearTooClose = AlmTypes.TYP_0233_ADAS_RIGHT_REAR_TOO_CLOSE();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0230";
    }

    /**
     * 激烈驾驶报警
     */
    public static class IntenseDrivingAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "024";

        /**
         * 判断给定报警类型是否激烈驾驶报警
         * @param typ 所要判断的报警类型
         * @return 是否激烈驾驶报警
         */
        public static boolean isIntenseDrivingAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 急加速报警
         */
        public static final String RapidAccelerate = AlmTypes.TYP_0241_ADAS_RAPID_ACCELERATE();

        /**
         * 急减速报警
         */
        public static final String RapidDecelerate = AlmTypes.TYP_0242_ADAS_RAPID_DECELERATE();

        /**
         * 急转弯报警
         */
        public static final String RapidTurn = AlmTypes.TYP_0243_ADAS_RAPID_TURN();

        /**
         * 怠速报警
         */
        public static final String Idling = AlmTypes.TYP_0244_ADAS_IDLING();

        /**
         * 异常熄火报警
         */
        public static final String UnexpectedFlameOut = AlmTypes.TYP_0245_ADAS_UNEXPECTED_FLAME_OUT();

        /**
         * 空挡滑行报警
         */
        public static final String SlidingOnN = AlmTypes.TYP_0246_ADAS_SLIDING_ON_N();

        /**
         * 发动机超转报警
         */
        public static final String EngineRpmTooHigh = AlmTypes.TYP_0247_ADAS_ENGINE_RPM_TOO_HIGH();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0240";
    }

    /**
     * 卫星定位超速报警
     */
    public static class OverSpdAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "025";

        /**
         * 判断给定报警类型是否卫星定位超速报警
         * @param typ 所要判断的报警类型
         * @return 是否卫星定位超速报警
         */
        public static boolean isOverSpdAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 超过阈值速度报警
         */
        public static final String OverEquipSpdLimit = AlmTypes.TYP_0251_ADAS_OVER_EQUIP_SPD_LIMIT();

        /**
         * 超过道路限速报警
         */
        public static final String OverRoadSpdLimit = AlmTypes.TYP_0252_ADAS_OVER_ROAD_SPD_LIMIT();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0250";
    }

    /**
     * ADAS 超重报警
     */
    public static class OverloadAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "026";

        /**
         * 判断给定报警类型是否 ADAS 超重报警
         * @param typ 所要判断的报警类型
         * @return 是否 ADAS 超重报警
         */
        public static boolean isOverloadAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }


        /**
         * 超重报警
         */
        public static final String Overload = AlmTypes.TYP_0261_ADAS_OVERLOAD();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0260";
    }

    /**
     * ADAS 限高报警
     */
    public static class OverHeightAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "027";

        /**
         * 判断给定报警类型是否 ADAS 限高报警
         * @param typ 所要判断的报警类型
         * @return 是否 ADAS 限高报警
         */
        public static boolean isOverHeightAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }


        /**
         * 限高报警
         */
        public static final String OverHeight = AlmTypes.TYP_0271_ADAS_OVER_HEIGHT();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0270";
    }

    /**
     * 智能识别系统报警
     */
    public static class AiRecogAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "028";

        /**
         * 判断给定报警类型是否 ADAS 限高报警
         * @param typ 所要判断的报警类型
         * @return 是否 ADAS 限高报警
         */
        public static boolean isAiRecogAlmTyp(@Nullable String typ) {
            return typ != null && typ.startsWith(CATEGORY_ID);
        }

        /**
         * 超员报警
         */
        public static final String Overcrowded = AlmTypes.TYP_0281_ADAS_OVERCROWDED();

        /**
         * 未巡检乘客安全带事件
         */
        public static final String BeltingNotChecked = AlmTypes.TYP_0282_ADAS_BELTING_NOT_CHECKED();

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "0280";
    }
}
