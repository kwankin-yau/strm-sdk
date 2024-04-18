package info.gratour.jt808common.protocol.msg.types.trk;

import com.google.gson.reflect.TypeToken;
import info.gratour.jt808common.JT1078VidAlarmBit;
import info.gratour.jt808common.JT808AlarmBit;
import info.gratour.jt808common.JT808StateBit;
import info.gratour.jt808common.protocol.msg.types.Coordinate;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

/**
 * 轨迹
 */
public class Trk implements MQEventAddt, Cloneable {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getVehId() {
        return vehId;
    }

    public void setVehId(String vehId) {
        this.vehId = vehId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public long getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    public long getGpsTm() {
        return gpsTm;
    }

    public void setGpsTm(long gpsTm) {
        this.gpsTm = gpsTm;
    }

    public boolean isReTrans() {
        return reTrans != null ? reTrans : false;
    }

    public Boolean getReTrans() {
        return reTrans;
    }

    public void setReTrans(Boolean reTrans) {
        this.reTrans = reTrans;
    }

    public int getAlm() {
        return alm;
    }

    public void setAlm(int alm) {
        this.alm = alm;
    }

    public boolean almTest(int bitIndex) {
        return JTUtils.test(alm, bitIndex);
    }

    public boolean almTest(JT808AlarmBit bit) {
        return JTUtils.test(alm, bit.bitIndex());
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public boolean stTest(int bitIndex) {
        return JTUtils.test(st, bitIndex);
    }

    public boolean stTestAccOn() {
        return stTest(JT808StateBit.ACC_ON.bitIndex());
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Coordinate toCoordinate() {
        return new Coordinate(lng, lat);
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    public float getSpd() {
        return spd;
    }

    public void setSpd(float spd) {
        this.spd = spd;
    }

    public Float getRecSpd() {
        return recSpd;
    }

    public float recSpdDef0() {
        if (recSpd != null)
            return recSpd;
        else
            return 0f;
    }

    public void setRecSpd(Float recSpd) {
        this.recSpd = recSpd;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    public boolean signalTest(int bitIndex) {
        if (signal == null)
            return false;
        else
            return JTUtils.test(signal, bitIndex);
    }

    public Integer getIoSt() {
        return ioSt;
    }

    public void setIoSt(Integer ioSt) {
        this.ioSt = ioSt;
    }

    public boolean ioStTest(int bitIndex) {
        if (ioSt == null)
            return false;
        else
            return JTUtils.test(ioSt.intValue(), bitIndex);
    }

    public Integer getVidAlm() {
        return vidAlm;
    }

    public void setVidAlm(Integer vidAlm) {
        this.vidAlm = vidAlm;
    }

    public boolean vidAlmTest(int bitIndex) {
        if (vidAlm != null)
            return JTUtils.test(vidAlm, bitIndex);
        else
            return false;
    }

    public boolean vidAlmTest(JT1078VidAlarmBit bit) {
        if (vidAlm != null)
            return JTUtils.test(vidAlm, bit.bitIndex());
        else
            return false;
    }

    public Integer getAdasAlm() {
        return adasAlm;
    }

    public void setAdasAlm(Integer adasAlm) {
        this.adasAlm = adasAlm;
    }

    public boolean adasAlmTest(int bitIndex) {
        if (adasAlm != null)
            return JTUtils.test(adasAlm, bitIndex);
        else
            return false;
    }

    public Float getMile() {
        return mile;
    }

    public void setMile(Float mile) {
        this.mile = mile;
    }

    public float mileDef0() {
        if (mile == null)
            return 0f;
        else
            return mile;
    }

    public Float getGas() {
        return gas;
    }

    public void setGas(Float gas) {
        this.gas = gas;
    }

    public String getDrvName() {
        return drvName;
    }

    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    public String getDrvNo() {
        return drvNo;
    }

    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    public TrkAddt getAddt() {
        return addt;
    }

    public void setAddt(TrkAddt addt) {
        this.addt = addt;
    }

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

    public short adasAlmClear(int alarmStateBitIndex) {
        if (this.adasAlm == null)
            return 0;

        int state = this.adasAlm;

        state = JTUtils.clear(state, alarmStateBitIndex);
        this.adasAlm = state;
        return (short) state;
    }

    protected TrkAddt prepareAddt() {
        if (addt == null) {
            addt = new TrkAddt();
            addt.setId(id);
        }

        return addt;
    }

    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        if (unusualDriveBehav == null)
            throw new NullPointerException();

        prepareAddt().setUnusualDriveBehav(unusualDriveBehav);
    }

    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDrivingAssistAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_DRIVING_ASSIST_ALARM);
    }

    public void setDriverBehavAlm(AdasDriverBehavAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDriverBehavAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_DRIVER_BEHAVIOR_ALARM);
    }

    public void setAdasTyreState(AdasTyreState tyreState) {
        if (tyreState == null)
            throw new NullPointerException();

        prepareAddt().setTyreState(tyreState);
        if (tyreState.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_TYRE_STATE);
    }

    public void setAdasBlindAreaAlarm(AdasBlindAreaAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setBlindArea(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_BLIND_AREA);
    }

    public void setAdasIntenseDrivingAlarm(AdasIntenseDrivingAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setIntenseDrivingAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_INTENSE_DRIVING_ALARM);
    }

    public void setAdasOverSpdAlarm(AdasOverSpdAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setAdasOverSpd(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_OVER_SPEED_ALARM);
    }

    public void setAdasAiRecogAlm(AdasAiRecogAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setAiRecogAlm(alm);
        if (alm.getFlag() != 2)
            adasAlmSet(AdasAlarmBits.ADAS_AI_RECOG_ALARM);
    }

    public void setAdasOverloadAlm(AdasOverloadAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setOverloadAlmAddt(alm);
        if (alm.getFlag() == 1 || alm.getFlag() == 3)
            adasAlmSet(AdasAlarmBits.ADAS_OVERLOAD_ALARM);
    }

    public void setAdasOverHeightAlm(AdasOverHeightAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setOverHeightAlmAddt(alm);
        if (alm.getFlag() == 1 || alm.getFlag() == 3)
            adasAlmSet(AdasAlarmBits.ADAS_OVER_HEIGHT_ALARM);
    }

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
