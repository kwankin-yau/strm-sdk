package info.gratour.jt808common.protocol.msg.types.trk;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.gson.reflect.TypeToken;
import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.JT1078VidAlarmBit;
import info.gratour.jt808common.JT808AlarmBit;
import info.gratour.jt808common.JT808StateBit;
import info.gratour.jt808common.protocol.msg.types.Coordinate;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

/**
 * 轨迹信息
 */
@Expose
public class Trk implements MQEventAddt, Cloneable {

    /**
     * 轨迹对象的类型信息，用于 GSON 序列化/反序列化。
     */
    public static final Type TYPE = new TypeToken<Trk>() {
    }.getType();

    /**
     * ADAS 报警状态位定义
     */
    public static class AdasAlarmBits {

        /**
         * 驾驶辅助功能报警
         */
        public static final int ADAS_DRIVING_ASSIST_ALARM = 0;

        /**
         * 驾驶员行为监测功能报警
         */
        public static final int ADAS_DRIVER_BEHAVIOR_ALARM = 1;

        /**
         * 胎压监测功能报警
         */
        public static final int ADAS_TYRE_STATE = 2;

        /**
         * 盲点检测系统报警
         */
        public static final int ADAS_BLIND_AREA = 3;

        /**
         * 激烈驾驶报警
         */
        public static final int ADAS_INTENSE_DRIVING_ALARM = 4;

        /**
         * 卫星定位超速报警
         */
        public static final int ADAS_OVER_SPEED_ALARM = 5;

        /**
         * AI识别报警
         */
        public static final int ADAS_AI_RECOG_ALARM = 6;

        /**
         * 载重报警
         */
        public static final int ADAS_OVERLOAD_ALARM = 7;

        /**
         * 限高报警
         */
        public static final int ADAS_OVER_HEIGHT_ALARM = 8;
    }

    /**
     * 轨迹ID
     */
    @NonNull
    private String id;

    /**
     * 终端识别号
     */
    @NonNull
    private String simNo;

    /**
     * 车辆ID
     */
    @Nullable
    private String vehId;

    /**
     * 车牌号
     */
    @Nullable
    private String plateNo;

    /**
     * 车牌颜色代码
     */
    @Nullable
    private Integer plateColor;

    /**
     * 轨迹接收时间
     */
    private long recvTm;

    /**
     * 卫星时间
     */
    private long gpsTm;

    /**
     * 是否重传的轨迹。为 null 时，也表示 false。
     */
    @Nullable
    private Boolean reTrans;

    /**
     * 报警标志位
     */
    private int alm;

    /**
     * 状态标志位
     */
    private int st;

    /**
     * 经度
     */
    private double lng;

    /**
     * 纬度
     */
    private double lat;

    /**
     * 海拔
     */
    private int alt;

    /**
     * GPS速度, km/h
     */
    private float spd;

    /**
     * 记录仪速度，km/h。附加信息 0x03
     */
    @Nullable
    private Float recSpd;

    /**
     * 方向，0-356
     */
    private int dir;

    /**
     * 扩展信息标志位，附加信息 0x25
     */
    private Integer signal;

    /**
     * IO状态位，附加信息 0x2A
     */
    private Integer ioSt;


    /**
     * 视频报警状态位，JT/T 1078 附加信息 0x14
     */
    private Integer vidAlm;

    /**
     * ADAS报警状态位。各位定义见 AdasAlarmBits
     */
    private Integer adasAlm;

    /**
     * 里程, km. 附加信息 0x01
     */
    private Float mile;

    /**
     * 油量，L, 附加信息 0x02
     */
    private Float gas;

    /**
     * 驾驶员姓名
     */
    private String drvName;

    /**
     * 驾驶证号
     */
    private String drvNo;

    /**
     * 其他附加信息
     */
    private TrkAddt addt;

    /**
     * 取轨迹ID
     * @return 轨迹ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置轨迹ID
     * @param id 轨迹ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取车辆ID
     * @return 车辆ID
     */
    public String getVehId() {
        return vehId;
    }

    /**
     * 设置车辆ID
     * @param vehId 车辆ID
     */ 
    public void setVehId(String vehId) {
        this.vehId = vehId;
    }

    /**
     * 取车牌号
     * @return 车牌号
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号
     * @param plateNo 车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    /**
     * 取车牌颜色代码
     * @return 车牌颜色代码
     */
    public Integer getPlateColor() {
        return plateColor;
    }

    /**
     * 设置车牌颜色代码
     * @param plateColor 车牌颜色代码
     */
    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 取轨迹接收时间
     * @return 轨迹接收时间
     */
    public long getRecvTm() {
        return recvTm;
    }

    /**
     * 设置轨迹接收时间
     * @param recvTm 轨迹接收时间
     */
    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    /**
     * 取GPS时间，epoch millisecond
     * @return GPS时间
     */
    public long getGpsTm() {
        return gpsTm;
    }

    /**
     * 设置GPS时间
     * @param gpsTm GPS时间, epoch millisecond
     */
    public void setGpsTm(long gpsTm) {
        this.gpsTm = gpsTm;
    }

    /**
     * 是否重传的轨迹。`reTrans` 为 null 时，也表示 false。
     * @return 是否重传的轨迹
     */ 
    public boolean isReTrans() {
        return reTrans != null ? reTrans : false;
    }

    /**
     * 取是否重传的轨迹
     * @return 是否重传的轨迹
     */
    public Boolean getReTrans() {
        return reTrans;
    }

    /**
     * 设置是否重传的轨迹
     * @param reTrans 是否重传的轨迹
     */
    public void setReTrans(Boolean reTrans) {
        this.reTrans = reTrans;
    }

    /**
     * 取报警标志位
     * @return 报警标志位
     */
    public int getAlm() {
        return alm;
    }

    /**
     * 设置报警标志位
     * @param alm 报警标志位
     */
    public void setAlm(int alm) {
        this.alm = alm;
    }

    /**
     * 测试报警标志位
     * @param bitIndex 位索引
     * @return 测试结果
     */
    public boolean almTest(int bitIndex) {
        return JTUtils.test(alm, bitIndex);
    }

    /**
     * 测试报警标志位
     * @param bit 报警标志位
     * @return 测试结果
     */
    public boolean almTest(JT808AlarmBit bit) {
        return JTUtils.test(alm, bit.bitIndex());
    }

    /**
     * 取状态标志位
     * @return 状态标志位
     */
    public int getSt() {
        return st;
    }

    /**
     * 设置状态标志位
     * @param st 状态标志位
     */
    public void setSt(int st) {
        this.st = st;
    }

    /**
     * 测试状态标志位
     * @param bitIndex 位索引
     * @return 测试结果
     */
    public boolean stTest(int bitIndex) {
        return JTUtils.test(st, bitIndex);
    }

    /**
     * 测试是否处于ACC ON 状态
     * @return 测试结果
     */
    public boolean stTestAccOn() {
        return stTest(JT808StateBit.ACC_ON.bitIndex());
    }

    /**
     * 取经度
     * @return 经度
     */
    public double getLng() {
        return lng;
    }

    /**
     * 设置经度
     * @param lng 经度
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * 取纬度
     * @return 纬度
     */
    public double getLat() {
        return lat;
    }

    /**
     * 设置纬度
     * @param lat 纬度
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * 转换为坐标对象
     * @return 坐标对象
     */
    public Coordinate toCoordinate() {
        return new Coordinate(lng, lat);
    }

    /**
     * 取海拔
     * @return 海拔
     */
    public int getAlt() {
        return alt;
    }

    /**
     * 设置海拔
     * @param alt 海拔
     */
    public void setAlt(int alt) {
        this.alt = alt;
    }

    /**
     * 取GPS速度
     * @return GPS速度
     */
    public float getSpd() {
        return spd;
    }

    /**
     * 设置GPS速度
     * @param spd GPS速度
     */
    public void setSpd(float spd) {
        this.spd = spd;
    }

    /**
     * 取记录仪速度
     * @return 记录仪速度
     */
    public Float getRecSpd() {
        return recSpd;
    }

    /**
     * 取记录仪速度。当 `recSpd` 为 null 时，返回 0。
     * @return 记录仪速度
     */
    public float recSpdDef0() {
        if (recSpd != null)
            return recSpd;
        else
            return 0f;
    }

    /**
     * 设置记录仪速度
     * @param recSpd 记录仪速度
     */
    public void setRecSpd(Float recSpd) {
        this.recSpd = recSpd;
    }

    /**
     * 取方向
     * @return 方向
     */
    public int getDir() {
        return dir;
    }

    /**
     * 设置方向
     * @param dir 方向
     */
    public void setDir(int dir) {
        this.dir = dir;
    }

    /**
     * 取信号强度
     * @return 信号强度
     */
    public Integer getSignal() {
        return signal;
    }

    /**
     * 设置信号强度
     * @param signal 信号强度
     */
    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    /**
     * 测试信号强度
     * @param bitIndex 位索引
     * @return 测试结果
     */
    public boolean signalTest(int bitIndex) {
        if (signal == null)
            return false;
        else
            return JTUtils.test(signal, bitIndex);
    }

    /**
     * 取IO状态
     * @return IO状态
     */
    public Integer getIoSt() {
        return ioSt;
    }

    /**
     * 设置IO状态
     * @param ioSt IO状态
     */
    public void setIoSt(Integer ioSt) {
        this.ioSt = ioSt;
    }

    /**
     * 测试IO状态
     * @param bitIndex 位索引
     * @return 测试结果
     */
    public boolean ioStTest(int bitIndex) {
        if (ioSt == null)
            return false;
        else
            return JTUtils.test(ioSt.intValue(), bitIndex);
    }

    /**
     * 取视频报警标志位
     * @return 视频报警标志位
     */ 
    public Integer getVidAlm() {
        return vidAlm;
    }

    /**
     * 设置视频报警标志位
     * @param vidAlm 视频报警标志位
     */
    public void setVidAlm(Integer vidAlm) {
        this.vidAlm = vidAlm;
    }

    /**
     * 测试视频报警标志位
     * @param bitIndex 位索引
     * @return 测试结果
     */
    public boolean vidAlmTest(int bitIndex) {
        if (vidAlm != null)
            return JTUtils.test(vidAlm, bitIndex);
        else
            return false;
    }

    /**
     * 测试视频报警标志位
     * @param bit 视频报警标志位
     * @return 测试结果
     */
    public boolean vidAlmTest(JT1078VidAlarmBit bit) {
        if (vidAlm != null)
            return JTUtils.test(vidAlm, bit.bitIndex());
        else
            return false;
    }

    /**
     * 取ADAS报警标志位
     * @return ADAS报警标志位
     */
    public Integer getAdasAlm() {
        return adasAlm;
    }

    /**
     * 设置ADAS报警标志位
     * @param adasAlm ADAS报警标志位
     */
    public void setAdasAlm(Integer adasAlm) {
        this.adasAlm = adasAlm;
    }

    /**
     * 测试ADAS报警标志位
     * @param bitIndex 位索引
     * @return 测试结果
     */
    public boolean adasAlmTest(int bitIndex) {
        if (adasAlm != null)
            return JTUtils.test(adasAlm, bitIndex);
        else
            return false;
    }

    /**
     * 取里程
     * @return 里程
     */
    public Float getMile() {
        return mile;
    }

    /**
     * 设置里程
     * @param mile 里程
     */
    public void setMile(Float mile) {
        this.mile = mile;
    }

    /**
     * 取里程。当 `mile` 为 null 时，返回 0。
     * @return 里程
     */
    public float mileDef0() {
        if (mile == null)
            return 0f;
        else
            return mile;
    }

    /**
     * 取油耗
     * @return 油耗
     */
    public Float getGas() {
        return gas;
    }

    /**
     * 设置油耗
     * @param gas 油耗
     */
    public void setGas(Float gas) {
        this.gas = gas;
    }

    /**
     * 取驾驶员姓名
     * @return 驾驶员姓名
     */
    public String getDrvName() {
        return drvName;
    }

    /**
     * 设置驾驶员姓名
     * @param drvName 驾驶员姓名
     */
    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    /**
     * 取驾驶员编号
     * @return 驾驶员编号
     */
    public String getDrvNo() {
        return drvNo;
    }

    /**
     * 设置驾驶员编号
     * @param drvNo 驾驶员编号
     */
    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    /**
     * 取附加数据
     * @return 附加数据
     */
    public TrkAddt getAddt() {
        return addt;
    }

    /**
     * 设置附加数据
     * @param addt 附加数据
     */ 
    public void setAddt(TrkAddt addt) {
        this.addt = addt;
    }

    /**
     * 设置ADAS报警标志位
     * @param alarmStateBitIndex 报警标志位索引
     * @return 设置后的ADAS报警标志位
     */
    public short adasAlmSet(int alarmStateBitIndex) {
        int state;
        if (this.adasAlm != null)
            state = this.adasAlm;
        else
            state = 0;

        state = JTUtils.set(state, alarmStateBitIndex);
        this.adasAlm = state;
        return (short) state;
    }

    /**
     * 清除ADAS报警标志位
     * @param alarmStateBitIndex 报警标志位索引
     * @return 清除后的ADAS报警标志位
     */
    public short adasAlmClear(int alarmStateBitIndex) {
        if (this.adasAlm == null)
            return 0;

        int state = this.adasAlm;

        state = JTUtils.clear(state, alarmStateBitIndex);
        this.adasAlm = state;
        return (short) state;
    }

    /**
     * 准备附加数据
     * @return 附加数据
     */
    protected TrkAddt prepareAddt() {
        if (addt == null) {
            addt = new TrkAddt();
            addt.setId(id);
        }

        return addt;
    }

    /**
     * 设置异常驾驶行为附加数据
     * @param unusualDriveBehav 异常驾驶行为附加数据
     */
    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        if (unusualDriveBehav == null)
            throw new NullPointerException();

        prepareAddt().setUnusualDriveBehav(unusualDriveBehav);
    }

    /**
     * 设置驾驶辅助报警附加数据
     * @param alm 驾驶辅助报警附加数据
     */
    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDrivingAssistAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_DRIVING_ASSIST_ALARM);
    }

    /**
     * 设置驾驶员行为报警附加数据
     * @param alm 驾驶员行为报警附加数据
     */
    public void setDriverBehavAlm(AdasDriverBehavAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDriverBehavAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_DRIVER_BEHAVIOR_ALARM);
    }

    /**
     * 设置轮胎状态附加数据
     * @param tyreState 轮胎状态附加数据
     */
    public void setAdasTyreState(AdasTyreState tyreState) {
        if (tyreState == null)
            throw new NullPointerException();

        prepareAddt().setTyreState(tyreState);
        if (tyreState.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_TYRE_STATE);
    }

    /**
     * 设置盲区报警附加数据
     * @param alm 盲区报警附加数据
     */
    public void setAdasBlindAreaAlarm(AdasBlindAreaAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setBlindArea(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_BLIND_AREA);
    }

    /**
     * 设置过激驾驶报警附加数据
     * @param alm 过激驾驶报警附加数据
     */
    public void setAdasIntenseDrivingAlarm(AdasIntenseDrivingAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setIntenseDrivingAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_INTENSE_DRIVING_ALARM);
    }

    /**
     * 设置超速报警附加数据
     * @param alm 超速报警附加数据
     */
    public void setAdasOverSpdAlarm(AdasOverSpdAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setAdasOverSpd(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_OVER_SPEED_ALARM);
    }

    /**
     * 设置AI识别报警附加数据
     * @param alm AI识别报警附加数据
     */
    public void setAdasAiRecogAlm(AdasAiRecogAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setAiRecogAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_AI_RECOG_ALARM);
    }

    /**
     * 设置超载报警附加数据
     * @param alm 超载报警附加数据
     */
    public void setAdasOverloadAlm(AdasOverloadAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setOverloadAlmAddt(alm);
        if (alm.getFlag() == 1 || alm.getFlag() == 3)
            adasAlmSet(AdasAlarmBits.ADAS_OVERLOAD_ALARM);
    }

    /**
     * 设置超高报警附加数据
     * @param alm 超高报警附加数据
     */
    public void setAdasOverHeightAlm(AdasOverHeightAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setOverHeightAlmAddt(alm);
        if (alm.getFlag() == 1 || alm.getFlag() == 3)
            adasAlmSet(AdasAlarmBits.ADAS_OVER_HEIGHT_ALARM);
    }

    /**
     * 从源轨迹对象赋值
     * @param source 源轨迹对象
     */
    public void assignFrom(Trk source) {
        this.id = source.id;
        this.simNo = source.simNo;
        this.vehId = source.vehId;
        this.plateNo = source.plateNo;
        this.plateColor = source.plateColor;
        this.recvTm = source.recvTm;
        this.gpsTm = source.gpsTm;
        this.reTrans = source.reTrans;
        this.alm = source.alm;
        this.st = source.st;
        this.lng = source.lng;
        this.lat = source.lat;
        this.alt = source.alt;
        this.spd = source.spd;
        this.recSpd = source.recSpd;
        this.dir = source.dir;
        this.signal = source.signal;
        this.ioSt = source.ioSt;
        this.vidAlm = source.vidAlm;
        this.adasAlm = source.adasAlm;
        this.mile = source.mile;
        this.gas = source.gas;
        this.drvName = source.drvName;
        this.drvNo = source.drvNo;
        this.addt = source.addt != null ? source.addt.clone() : null;
    }

    /**
     * 克隆轨迹对象
     * @return 克隆后的轨迹对象
     */
    @Override
    public Trk clone() {
        try {
            return (Trk) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static final DecimalFormat FLOAT_FORMAT = new DecimalFormat("0.#");

    private class Stringifier {
        private StringBuilder str = new StringBuilder();
        private boolean first = true;

        private void addF(String propName, Float value) {
            if (value != null) {
                if (!first) {
                    str.append(", ");
                }

                str.append(propName).append('=').append(FLOAT_FORMAT.format(value));

                first = false;
            }
        }

        private void addAxis(String propName, Double value) {
            if (value != null) {
                if (!first) {
                    str.append(", ");
                }

                str.append(propName).append('=').append(JTUtils.formatAxis(value));

                first = false;
            }
        }

        private void add(String propName, Object value) {
            if (value != null) {
                if (!first) {
                    str.append(", ");
                }

                str.append(propName).append('=').append(value);

                first = false;
            }
        }

        public String stringifier() {
            str.append("Trk{");

            add("id", id);
            add("simNo", simNo);
            add("vehId", vehId);
            add("plateNo", plateNo);
            add("plateColor", plateColor);
            add("recvTm", recvTm);
            add("gpsTm", gpsTm);
            add("reTrans", reTrans);
            add("alm", alm);
            add("st", st);
            addAxis("lng", lng);
            addAxis("lat", lat);
            addF("spd", spd);
            addF("recSpd", recSpd);
            add("dir", dir);
            add("signal", signal);
            add("ioSt", ioSt);
            add("vidAlm", vidAlm);
            add("adasAlm", adasAlm);
            addF("mile", mile);
            addF("gas", gas);
            add("drvName", drvName);
            add("drvNo", drvNo);
            if (addt != null) {
                String s = JTConsts.GSON().toJson(addt);
                add("addt", s);
            }

            str.append("}");
            return str.toString();
        }


    }

    @Override
    public String toString() {
        Stringifier stringifier = new Stringifier();
        return stringifier.stringifier();
    }
}
