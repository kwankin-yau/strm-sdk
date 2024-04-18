package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.AdasDialect;

import java.util.StringJoiner;

/**
 * 辅助驾驶系统报警附加信息
 */
public class AdasDrivingAssistAlmAddt extends AdasAddt implements Cloneable {


    /**
     * 标志：不可用
     */
    public static final byte FLAG__NOT_AVAILABLE = 0;


    /**
     * 标志：报警开始
     */
    public static final byte FLAG__START = 1;

    /**
     * 标志：报警结束
     */
    public static final byte FLAG__END = 2;

    /**
     * 前向碰撞报警
     */
    public static final byte TYP__FRONT_CRASH = 1;

    /**
     * 车道偏离报警
     */
    public static final byte TYP__STRAY_PATH = 2;

    /**
     * 车距过近报警
     */
    public static final byte TYP__TOO_CLOSE_TO_FRONT_CAR = 3;

    /**
     * 行人碰撞报警
     */
    public static final byte TYP__PEDESTRIAN_HIT = 4;

    /**
     * 频繁变道报警
     */
    public static final byte TYP__CHANGE_LANE_FREQUENTLY = 5;

    /**
     * 道路标识超限报警
     */
    public static final byte TYP__ROAD_RECOG_MARK_OVERRUN = 6;

    /**
     * 障碍物报警
     */
    public static final byte TYP__OBSTACLE = 7;

    /**
     * 驾驶辅助功能失效报警
     */
    public static final byte TYP__ASSIST_FUNC_FAILURE = 8;

    /**
     * 道路标志识别事件
     */
    public static final byte TYP__ROAD_RECOG_EVENT = 0x10;

    /**
     * 主动抓拍识别事件
     */
    public static final byte TYP__ACTIVE_CAPTURE_EVENT = 0x11;

    /**
     * 实线变道报警
     */
    public static final byte TYP__VIOLATED_CHANGE_PATH = 0x12;

    /**
     * 车厢过道行人监测
     */
    public static final byte TYP__PASSENGER_AT_CARRIAGE_HALLWAY_DETECTED = 0x13;

    /**
     * 设备失效提醒
     */
    public static final byte TYP__DEVICE_FAILURE = 0x14;

    /**
     * 不能识别或厂商自定义报警/事件类型
     */
    public static final byte TYP__CUSTOM = (byte) 0xFF;


    private int almId;
    private byte flag;
    private short typ;
    private short typ2;
    private byte lvl;
    private Short frontCarSpd;
    private Float frontCarDist;
    private Byte deviateTyp;
    private Byte rdRecogMark;
    private Byte rdRecogDat;
    private short spd;
    private short alt;
    private double lat;
    private double lng;
    private long tm;
    private short vehSt;
    private String almNo;

    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasDrivingAssistAlmAddt(AdasDialect adasDialect) {
        super(adasDialect);
    }

    /**
     * 取报警ID
     *
     * @return 报警ID
     */
    public int getAlmId() {
        return almId;
    }

    /**
     * 设置报警ID
     *
     * @param almId 报警ID
     */
    public void setAlmId(int almId) {
        this.almId = almId;
    }

    /**
     * 取标志状态
     *
     * @return 标志状态，为 FLAG__ 系列常量之一
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * 设置标志状态
     *
     * @param flag 标志状态，为 FLAG__ 系列常量之一
     */
    public void setFlag(byte flag) {
        this.flag = flag;
    }

    /**
     * 返回标志状态是否不可用或报警开始，即非结束
     *
     * @return 标志状态是否不可用或报警开始，即非结束
     */
    public boolean flagIsStartOrNA() {
        return flag == FLAG__NOT_AVAILABLE || flag == FLAG__START;
    }

    /**
     * 取终端原始上传的报警类型
     *
     * @return 终端原始上传的报警类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置终端原始上传的报警类型
     *
     * @param typ 终端原始上传的报警类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 取映射后的报警类型
     *
     * @return 映射后的报警类型
     */
    public short getTyp2() {
        return typ2;
    }

    /**
     * 设置映射后的报警类型
     *
     * @param typ2 映射后的报警类型
     */
    public void setTyp2(short typ2) {
        this.typ2 = typ2;
    }

    /**
     * 取报警级别
     *
     * @return 报警级别
     */
    public byte getLvl() {
        return lvl;
    }

    /**
     * 设置报警级别
     *
     * @param lvl 报警级别
     */
    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }

    /**
     * 取前车速度
     *
     * @return 前车速度, km/h
     */
    public Short getFrontCarSpd() {
        return frontCarSpd;
    }

    /**
     * 设置前车速度
     * @param frontCarSpd 前车速度, km/h
     */
    public void setFrontCarSpd(Short frontCarSpd) {
        this.frontCarSpd = frontCarSpd;
    }

    /**
     * 取前车/行人距离
     *
     * @return 前车/行人距离, 单位：km
     */
    public Float getFrontCarDist() {
        return frontCarDist;
    }

    /**
     * 设置前车/行人距离
     * @param frontCarDist 前车/行人距离, 单位：km
     */
    public void setFrontCarDist(Float frontCarDist) {
        this.frontCarDist = frontCarDist;
    }

    /**
     * 取偏离类型
     *
     * @return 偏离类型
     */
    public Byte getDeviateTyp() {
        return deviateTyp;
    }

    /**
     * 设置偏离类型
     * @param deviateTyp 偏离类型
     */
    public void setDeviateTyp(Byte deviateTyp) {
        this.deviateTyp = deviateTyp;
    }

    /**
     * 取道路标识识别类型
     *
     * @return 道路标识识别类型
     */
    public Byte getRdRecogMark() {
        return rdRecogMark;
    }

    /**
     * 设置道路标识识别类型
     * @param rdRecogMark 道路标识识别类型
     */
    public void setRdRecogMark(Byte rdRecogMark) {
        this.rdRecogMark = rdRecogMark;
    }

    /**
     * 取道路标识识别数据
     * @return 道路标识识别数据
     */
    public Byte getRdRecogDat() {
        return rdRecogDat;
    }

    /**
     * 设置道路标识识别数据
     * @param rdRecogDat 道路标识识别数据
     */
    public void setRdRecogDat(Byte rdRecogDat) {
        this.rdRecogDat = rdRecogDat;
    }

    /**
     * 取车速
     * @return 车速, km/h
     */
    public short getSpd() {
        return spd;
    }

    /**
     * 设置车速
     * @param spd 车速, km/h
     */
    public void setSpd(short spd) {
        this.spd = spd;
    }

    /**
     * 取高程
     *
     * @return 高程, m
     */
    public short getAlt() {
        return alt;
    }

    /**
     * 设置高程
     *
     * @param alt 高程, m
     */
    public void setAlt(short alt) {
        this.alt = alt;
    }

    /**
     * 取纬度
     *
     * @return 纬度
     */
    public double getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * 取经度
     *
     * @return 经度
     */
    public double getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * 取报警时间, epoch millis
     *
     * @return 报警时间, epoch millis
     */
    public long getTm() {
        return tm;
    }

    /**
     * 设置报警时间
     *
     * @param tm 报警时间, epoch millis
     */
    public void setTm(long tm) {
        this.tm = tm;
    }

    /**
     * 取车辆状态字
     *
     * @return 车辆状态字
     */
    public short getVehSt() {
        return vehSt;
    }

    /**
     * 设置车辆状态字
     *
     * @param vehSt 车辆状态字
     */
    public void setVehSt(short vehSt) {
        this.vehSt = vehSt;
    }

    /**
     * 取报警识别号/编号
     *
     * @return 报警识别号/编号, HEX格式
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警识别号/编号
     *
     * @param almNo 报警识别号/编号, HEX格式
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    @Override
    public AdasDrivingAssistAlmAddt clone() {
        try {
            return (AdasDrivingAssistAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasDrivingAssistAlmAddt.class.getSimpleName() + "[", "]")
                .add("almId=" + almId)
                .add("flag=" + flag)
                .add("typ=" + typ)
                .add("typ2=" + typ2)
                .add("lvl=" + lvl)
                .add("frontCarSpd=" + frontCarSpd)
                .add("frontCarDist=" + frontCarDist)
                .add("deviateTyp=" + deviateTyp)
                .add("rdRecogMark=" + rdRecogMark)
                .add("rdRecogDat=" + rdRecogDat)
                .add("spd=" + spd)
                .add("alt=" + alt)
                .add("lat=" + lat)
                .add("lng=" + lng)
                .add("tm=" + tm)
                .add("vehSt=" + vehSt)
                .add("almNo='" + almNo + "'")
                .toString();
    }
}
