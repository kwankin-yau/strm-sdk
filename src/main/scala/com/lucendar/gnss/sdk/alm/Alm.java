/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.alm;

import info.gratour.jt808common.adas.AdasAlmTypes;
import info.gratour.jt808common.protocol.msg.types.trk.TrkAddt;
import info.gratour.jtcommon.JTMessages;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringJoiner;

/**
 * 报警信息
 */
public class Alm {

    /**
     * 报警源：终端
     */
    public static final int ALM_SRC__TERM = 1;

    /**
     * 报警源：企业平台
     */
    public static final int ALM_SRC__PLATFORM = 2;

    /**
     * 报警源：政府平台
     */
    public static final int ALM_SRC__GOV = 3;

    /**
     * Get resource bundle for specified locale
     * @param locale The specified locale
     * @return resource bundle
     */
    public static ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.alm.alm", locale);
    }

    /**
     * 报警源字面量: 终端
     */
    public static final String MESSAGE_KEY_ALM_SRC__TERM = "almSrc.term.1";

    /**
     * 报警源字面量: 平台（本企业平台）
     */
    public static final String MESSAGE_KEY_ALM_SRC__PLATFORM = "almSrc.platform.2";

    /**
     * 报警源字面量: 政府平台
     */
    public static final String MESSAGE_KEY_ALM_SRC__GOV = "almSrc.gov.3";

    /**
     * 将报警源代码转换成文本字面量
     *
     * @param almSrc 报警源代码，为 ALM_SRC__ 系列常量之一
     * @param locale Locale
     * @return 报警源文本字面量
     */
    public static String almSrcText(int almSrc, Locale locale) {
        String key;

        switch (almSrc) {
            case ALM_SRC__TERM:
                key = MESSAGE_KEY_ALM_SRC__TERM;
                break;

            case ALM_SRC__PLATFORM:
                key = MESSAGE_KEY_ALM_SRC__PLATFORM;
                break;

            case ALM_SRC__GOV:
                key = MESSAGE_KEY_ALM_SRC__GOV;
                break;

            default:
                return JTMessages.unknown(locale);
        }

        return resourceBundle(locale).getString(key);
    }

    /**
     * 处理状态：处理中
     */
    public static final int PROC_ST__PROCESSING = 0;

    /**
     * 处理状态：已处理
     */
    public static final int PROC_ST__PROCESSED = 1;

    /**
     * 处理状态：不作处理
     */
    public static final int PROC_ST__NO_ACTION_TAKEN = 2;

    /**
     * 处理状态：延后处理
     */
    public static final int PROC_ST__DEFERRED = 3;

    /**
     * 处理状态文本字符串 Key: 未处理
     */
    public static final String MESSAGE_KEY_PROC_ST__UNPROCESSED = "almProcSt.unprocessed";
    /**
     * 处理状态文本字符串 Key: 处理中
     */
    public static final String MESSAGE_KEY_PROC_ST__PROCESSING = "almProcSt.processing.0";
    /**
     * 处理状态文本字符串 Key: 已处理
     */
    public static final String MESSAGE_KEY_PROC_ST__PROCESSED = "almProcSt.processed.1";
    /**
     * 处理状态文本字符串 Key: 不作处理
     */
    public static final String MESSAGE_KEY_PROC_ST__NO_ACTION_TAKEN = "almProcSt.noActionTaken.2";
    /**
     * 处理状态文本字符串 Key: 延后处理
     */
    public static final String MESSAGE_KEY_PROC_ST__DEFERRED = "almProcSt.deferred.3";

    /**
     * 将处理状态代码转换成文本字面量
     *
     * @param procSt 处理状态代码，为 PROC_ST__ 系列常量之一
     * @param locale Locale
     * @return 处理状态文本字面量
     */
    public static String procStText(int procSt, Locale locale) {
        String key;

        switch (procSt) {
            case PROC_ST__PROCESSING:
                key = MESSAGE_KEY_PROC_ST__PROCESSING;
                break;

            case PROC_ST__PROCESSED:
                key = MESSAGE_KEY_PROC_ST__PROCESSED;
                break;

            case PROC_ST__NO_ACTION_TAKEN:
                key = MESSAGE_KEY_PROC_ST__NO_ACTION_TAKEN;
                break;

            case PROC_ST__DEFERRED:
                key = MESSAGE_KEY_PROC_ST__DEFERRED;
                break;

            default:
                return JTMessages.unknown(locale);
        }

        return resourceBundle(locale).getString(key);
    }

    /**
     * ADAS报警级别：一级报警
     */
    public static final int LVL__1 = 1;

    /**
     * ADAS报警级别：二级报警
     */
    public static final int LVL__2 = 2;

    /**
     * ADAS报警级别文本字符串 Key：一级报警
     */
    public static final String MESSAGE_KEY_LVL__1 = "almLvl.1";
    /**
     * ADAS报警级别文本字符串 Key：二级报警
     */
    public static final String MESSAGE_KEY_LVL__2 = "almLvl.2";


    /**
     * 将 ADAS 报警级别代码转换成文本字面量
     *
     * @param lvl ADAS 报警级别代码，为 LVL__ 系列常量之一
     * @param locale Locale
     * @return ADAS 报警级别文本字面量
     */
    public static String almLvlText(int lvl, Locale locale) {
        String key;

        switch (lvl) {
            case LVL__1:
                key = MESSAGE_KEY_LVL__1;
                break;

            case LVL__2:
                key = MESSAGE_KEY_LVL__2;
                break;

            default:
                return "";
        }

        return resourceBundle(locale).getString(key);
    }

    /**
     * 报警处理方法：拍照
     */
    public static final int PROC_METH__TAKE_PHOTO = 0;

    /**
     * 报警处理方法：终端语音播报警告
     */
    public static final int PROC_METH__SEND_VOICE = 1;

    /**
     * 报警处理方法：不作处理
     */
    public static final int PROC_METH__NO_ACTION_TAKEN = 2;

    /**
     * 报警处理方法：其它
     */
    public static final int PROC_METH__OTHER = 3;

    /**
     * 报警处理方法文本字面量 Key：拍照
     */
    public static final String MESSAGE_KEY_PROC_METH__TAKE_PHOTO = "procMeth.takePhoto.0";
    /**
     * 报警处理方法文本字面量 Key：终端语音播报警告
     */
    public static final String MESSAGE_KEY_PROC_METH__SEND_VOICE = "procMeth.sendVoice.1";
    /**
     * 报警处理方法文本字面量 Key：不作处理
     */
    public static final String MESSAGE_KEY_PROC_METH__NO_ACTION_TAKEN = "procMeth.noActionTaken.2";
    /**
     * 报警处理方法文本字面量 Key：其它
     */
    public static final String MESSAGE_KEY_PROC_METH__OTHER = "procMeth.other.3";

    /**
     * 将报警处理方法代码转换成文本字面量
     *
     * @param procMeth 报警处理方法代码，为 PROC_METH__ 系列常量之一
     * @param locale Locale
     * @return 报警处理方法文本字面量
     */
    public static String procMethText(int procMeth, Locale locale) {
        String key;
        switch (procMeth) {
            case PROC_METH__TAKE_PHOTO:
                key = MESSAGE_KEY_PROC_METH__TAKE_PHOTO;
                break;

            case PROC_METH__SEND_VOICE:
                key = MESSAGE_KEY_PROC_METH__SEND_VOICE;
                break;

            case PROC_METH__NO_ACTION_TAKEN:
                key = MESSAGE_KEY_PROC_METH__NO_ACTION_TAKEN;
                break;

            case PROC_METH__OTHER:
                key = MESSAGE_KEY_PROC_METH__OTHER;
                break;

            default:
                return JTMessages.unknown(locale);
        }

        return resourceBundle(locale).getString(key);
    }


    private String id;
    private String simNo;
    private String plateNo;
    private Integer plateColor;
    private String trkId;
    private String typ;
    private String subTyp;
    private int src;
    private Integer lvl;
    private boolean actv;

    private long tm1;
    private long recvTm1;
    private double lng1;
    private double lat1;
    private float spd1;
    private Float recSpd1;
    private int alt1;
    private int dir1;
    private TrkAddt addt1;

    private Long tm0;
    private Long recvTm0;
    private double lng0;
    private double lat0;
    private float spd0;
    private Float recSpd0;
    private int alt0;
    private int dir0;
    private TrkAddt addt0;

    private Integer dur;
    private int attCnt;

    private String drvName;
    private String drvNo;

    private String platRgnId;
    private String platRgnName;

    private Integer procSt;
    private Integer procMeth;
    private Long procTm;
    private String oprName;
    private String oprCorpName;
    private String supervId;
    private Long supervTm;
    private Long supervDeadline;
    private Boolean supervReplyNeeded;

    /**
     * 取报警记录ID
     * @return 报警记录ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置报警记录ID
     * @param id 报警记录ID
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
     * 取对应的轨迹记录ID
     * @return 对应的轨迹记录ID
     */
    public String getTrkId() {
        return trkId;
    }

    /**
     * 设置对应的轨迹记录ID
     * @param trkId 对应的轨迹记录ID
     */
    public void setTrkId(String trkId) {
        this.trkId = trkId;
    }

    /**
     * 取报警类型
     * @return 报警类型，为 {@link info.gratour.jtcommon.AlmTypes} 中定义的 TYP_ 系列常量之一
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置报警类型
     * @param typ 报警类型，为 {@link info.gratour.jtcommon.AlmTypes} 中定义的 TYP_ 系列常量之一
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 取子报警类型
     * @return 子报警类型，为 {@link info.gratour.jtcommon.AlmTypes} 中定义的 SUB_TYP_ 系列常量之一
     */
    public String getSubTyp() {
        return subTyp;
    }

    /**
     * 设置子报警类型
     * @param subTyp 子报警类型，为 {@link info.gratour.jtcommon.AlmTypes} 中定义的 SUB_TYP_ 系列常量之一
     */
    public void setSubTyp(String subTyp) {
        this.subTyp = subTyp;
    }

    /**
     * 取报警源
     * @return 报警源，为 ALM_SRC__ 系列常量之一
     */
    public int getSrc() {
        return src;
    }

    /**
     * 设置报警源
     * @param src 报警源，为 ALM_SRC__ 系列常量之一
     */
    public void setSrc(int src) {
        this.src = src;
    }

    /**
     * 取 ADAS 报警级别
     * @return ADAS 报警级别，为 LVL__ 系列常量之一，一般终端报警和部分 ADAS 报警无报警级别
     */
    @Nullable
    public Integer getLvl() {
        return lvl;
    }

    /**
     * 设置ADAS 报警级别
     * @param lvl ADAS 报警级别，为 LVL__ 系列常量之一
     */
    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    /**
     * 返回当前是否未关闭（关闭后 actv 为 false）
     * @return 当前是否未关闭（关闭后 actv 为 false）
     */
    public boolean isActv() {
        return actv;
    }

    /**
     * 设置当前是否未关闭（关闭后 actv 为 false）
     * @param actv 当前是否未关闭（关闭后 actv 为 false）
     */
    public void setActv(boolean actv) {
        this.actv = actv;
    }

    /**
     * 取报警开始时间，为报警开始时的GPS时间. epoch millis
     * @return 报警开始时间，为报警开始时的GPS时间. epoch millis
     */
    public long getTm1() {
        return tm1;
    }

    /**
     * 设置报警开始时间，为报警开始时的GPS时间. epoch millis
     * @param tm1 报警开始时间，为报警开始时的GPS时间. epoch millis
     */
    public void setTm1(long tm1) {
        this.tm1 = tm1;
    }

    /**
     * 取报警开始的系统接收时间，epoch millis
     * @return 报警开始的系统接收时间，epoch millis
     */
    public long getRecvTm1() {
        return recvTm1;
    }

    /**
     * 设置报警开始的系统接收时间，epoch millis
     * @param recvTm1 报警开始的系统接收时间，epoch millis
     */
    public void setRecvTm1(long recvTm1) {
        this.recvTm1 = recvTm1;
    }

    /**
     * 取报警开始时的经度
     * @return 报警开始时的经度
     */
    public double getLng1() {
        return lng1;
    }

    /**
     * 设置报警开始时的经度
     * @param lng1 报警开始时的经度
     */
    public void setLng1(double lng1) {
        this.lng1 = lng1;
    }

    /**
     * 取报警开始时的纬度
     * @return 报警开始时的纬度
     */
    public double getLat1() {
        return lat1;
    }

    /**
     * 设置报警开始时的纬度
     * @param lat1 报警开始时的纬度
     */
    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    /**
     * 取报警开始时的速度，km/h
     * @return 报警开始时的速度，km/h
     */
    public float getSpd1() {
        return spd1;
    }

    /**
     * 设置报警开始时的速度，km/h
     * @param spd1 报警开始时的速度，km/h
     */
    public void setSpd1(float spd1) {
        this.spd1 = spd1;
    }

    /**
     * 取报警开始时的行驶记录仪速度, km/h
     * @return 报警开始时的行驶记录仪速度, km/h
     */
    public Float getRecSpd1() {
        return recSpd1;
    }

    /**
     * 设置报警开始时的行驶记录仪速度, km/h
     * @param recSpd1 报警开始时的行驶记录仪速度, km/h
     */
    public void setRecSpd1(Float recSpd1) {
        this.recSpd1 = recSpd1;
    }

    /**
     * 取报警开始时的海拔，米
     * @return 报警开始时的海拔，米
     */
    public int getAlt1() {
        return alt1;
    }

    /**
     * 设置报警开始时的海拔，米
     * @param alt1 报警开始时的海拔，米
     */
    public void setAlt1(int alt1) {
        this.alt1 = alt1;
    }

    /**
     * 取报警开始时的方向, 0-359
     * @return 报警开始时的方向, 0-359
     */
    public int getDir1() {
        return dir1;
    }

    /**
     * 设置报警开始时的方向, 0-359
     * @param dir1 报警开始时的方向, 0-359
     */
    public void setDir1(int dir1) {
        this.dir1 = dir1;
    }

    /**
     * 取报警开始时的报警附加信息。结构暂定与轨迹附加信息相同，但只有与当前报警类型相关的属性。参见轨迹附加信息对象类型 ({@link TrkAddt})
     * @return 报警开始时的报警附加信息。
     */
    public TrkAddt getAddt1() {
        return addt1;
    }

    /**
     * 设置报警开始时的报警附加信息。
     * @param addt1 报警开始时的报警附加信息。
     */
    public void setAddt1(TrkAddt addt1) {
        this.addt1 = addt1;
    }

    /**
     * 取报警结束时间，为报警结束时的GPS时间, epoch millis，未结束时为 null
     * @return 报警结束时间，为报警结束时的GPS时间, epoch millis
     */
    public Long getTm0() {
        return tm0;
    }

    /**
     * 设置报警结束时间，为报警结束时的GPS时间, epoch millis
     * @param tm0 报警结束时间，为报警结束时的GPS时间, epoch millis
     */
    public void setTm0(Long tm0) {
        this.tm0 = tm0;
    }

    /**
     * 取报警结束的系统接收时间, epoch millis
     * @return 报警结束的系统接收时间, epoch millis
     */
    public Long getRecvTm0() {
        return recvTm0;
    }

    /**
     * 设置报警结束的系统接收时间, epoch millis
     * @param recvTm0 报警结束的系统接收时间, epoch millis
     */
    public void setRecvTm0(Long recvTm0) {
        this.recvTm0 = recvTm0;
    }

    /**
     * 取报警结束时的经度
     * @return 报警结束时的经度
     */
    public double getLng0() {
        return lng0;
    }

    /**
     * 设置报警结束时的经度
     * @param lng0 报警结束时的经度
     */
    public void setLng0(double lng0) {
        this.lng0 = lng0;
    }

    /**
     * 取报警结束时的纬度
     * @return 报警结束时的纬度
     */
    public double getLat0() {
        return lat0;
    }

    /**
     * 设置报警结束时的纬度
     * @param lat0 报警结束时的纬度
     */
    public void setLat0(double lat0) {
        this.lat0 = lat0;
    }

    /**
     * 取报警结束时的速度，km/h
     * @return 报警结束时的速度，km/h
     */
    public float getSpd0() {
        return spd0;
    }

    /**
     * 设置报警结束时的速度，km/h
     * @param spd0 报警结束时的速度，km/h
     */
    public void setSpd0(float spd0) {
        this.spd0 = spd0;
    }

    /**
     * 取报警结束时的行驶记录仪速度, km/h
     * @return 报警结束时的行驶记录仪速度, km/h
     */
    public Float getRecSpd0() {
        return recSpd0;
    }

    /**
     * 设置报警结束时的行驶记录仪速度, km/h
     * @param recSpd0 报警结束时的行驶记录仪速度, km/h
     */
    public void setRecSpd0(Float recSpd0) {
        this.recSpd0 = recSpd0;
    }

    /**
     * 取报警结束时的海拔，米
     * @return 报警结束时的海拔，米
     */
    public int getAlt0() {
        return alt0;
    }

    /**
     * 设置报警结束时的海拔，米
     * @param alt0 报警结束时的海拔，米
     */
    public void setAlt0(int alt0) {
        this.alt0 = alt0;
    }

    /**
     * 取报警结束时的方向, 0-359
     * @return 报警结束时的方向, 0-359
     */
    public int getDir0() {
        return dir0;
    }

    /**
     * 设置报警结束时的方向, 0-359
     * @param dir0 报警结束时的方向, 0-359
     */
    public void setDir0(int dir0) {
        this.dir0 = dir0;
    }

    /**
     * 取报警结束时的报警附加信息。结构暂定与轨迹附加信息相同，但只有与当前报警类型相关的属性。参见轨迹附加信息对象类型 ({@link TrkAddt})
     * @return 报警结束时的报警附加信息。
     */
    public TrkAddt getAddt0() {
        return addt0;
    }

    /**
     * 设置报警结束时的报警附加信息。
     * @param addt0 报警结束时的报警附加信息。
     */
    public void setAddt0(TrkAddt addt0) {
        this.addt0 = addt0;
    }

    /**
     * 取报警时长(DURation)，秒。未结束时为NULL。
     * @return 报警时长(DURation)，秒。未结束时为NULL。
     */
    public Integer getDur() {
        return dur;
    }

    /**
     * 设置报警时长(DURation)，秒。未结束时为NULL。
     * @param dur 报警时长(DURation)，秒。未结束时为NULL。
     */
    public void setDur(Integer dur) {
        this.dur = dur;
    }

    /**
     * 取报警附件文件的数量。由于终端上传附件文件滞后，报警产生后立即查询得到的attCnt通常为0，实际的附件数量要大约在报警产生后2~10分钟才完成统计和更新。
     * @return 报警附件文件的数量。
     */
    public int getAttCnt() {
        return attCnt;
    }

    /**
     * 设置报警附件文件的数量。
     * @param attCnt 报警附件文件的数量。
     */
    public void setAttCnt(int attCnt) {
        this.attCnt = attCnt;
    }

    /**
     * 取报警时对应车辆的驾驶员姓名
     * @return 报警时对应车辆的驾驶员姓名
     */
    public String getDrvName() {
        return drvName;
    }

    /**
     * 设置报警时对应车辆的驾驶员姓名
     * @param drvName 报警时对应车辆的驾驶员姓名
     */
    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    /**
     * 取报警时对应车辆的驾驶员驾照号码
     * @return 报警时对应车辆的驾驶员驾照号码
     */
    public String getDrvNo() {
        return drvNo;
    }

    /**
     * 设置报警时对应车辆的驾驶员驾照号码
     * @param drvNo 报警时对应车辆的驾驶员驾照号码
     */
    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    /**
     * 取平台区域报警相应的平台区域ID。当平台产生平台区域报警时，报警记录的此属性被填入相应的平台区域ID。仅当报警类型为平台区域相关的报警时有效
     * @return 平台区域报警相应的平台区域ID。
     */
    public String getPlatRgnId() {
        return platRgnId;
    }

    /**
     * 设置平台区域报警相应的平台区域ID。
     * @param platRgnId 平台区域报警相应的平台区域ID。
     */
    public void setPlatRgnId(String platRgnId) {
        this.platRgnId = platRgnId;
    }

    /**
     * 取平台区域报警相应的平台区域的区域名称
     * @return 平台区域报警相应的平台区域的区域名称
     */
    public String getPlatRgnName() {
        return platRgnName;
    }

    /**
     * 设置平台区域报警相应的平台区域的区域名称
     * @param platRgnName 平台区域报警相应的平台区域的区域名称
     */
    public void setPlatRgnName(String platRgnName) {
        this.platRgnName = platRgnName;
    }

    /**
     * 取报警处理状态。为 PROC_ST__ 系列常量之一
     * @return 报警处理状态。为 PROC_ST__ 系列常量之一
     */
    public Integer getProcSt() {
        return procSt;
    }

    /**
     * 设置报警处理状态。为 PROC_ST__ 系列常量之一
     * @param procSt 报警处理状态。为 PROC_ST__ 系列常量之一
     */
    public void setProcSt(Integer procSt) {
        this.procSt = procSt;
    }

    /**
     * 取报警处理方式，为 PROC_METH__ 系列常量之一
     * @return 报警处理方式
     */
    public Integer getProcMeth() {
        return procMeth;
    }

    /**
     * 设置报警处理方式，为 PROC_METH__ 系列常量之一
     * @param procMeth 报警处理方式，为 PROC_METH__ 系列常量之一
     */
    public void setProcMeth(Integer procMeth) {
        this.procMeth = procMeth;
    }

    /**
     * 取报警处理时间, epoch millis
     * @return 报警处理时间, epoch millis
     */
    public Long getProcTm() {
        return procTm;
    }

    /**
     * 设置报警处理时间, epoch millis
     * @param procTm 报警处理时间, epoch millis
     */
    public void setProcTm(Long procTm) {
        this.procTm = procTm;
    }

    /**
     * 取报警处理人姓名
     * @return 报警处理人姓名
     */
    public String getOprName() {
        return oprName;
    }

    /**
     * 设置报警处理人姓名
     * @param oprName 报警处理人姓名
     */
    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    /**
     * 取报警处理人所属公司名称
     * @return 报警处理人所属公司名称
     */
    public String getOprCorpName() {
        return oprCorpName;
    }

    /**
     * 设置报警处理人所属公司名称
     * @param oprCorpName 报警处理人所属公司名称
     */
    public void setOprCorpName(String oprCorpName) {
        this.oprCorpName = oprCorpName;
    }

    /**
     * 取最后一次发生的报警督办的记录ID。从未发生督办，则为NULL
     * @return 最后一次发生的报警督办的记录ID
     */
    public String getSupervId() {
        return supervId;
    }

    /**
     * 设置最后一次发生的报警督办的记录ID
     * @param supervId 最后一次发生的报警督办的记录ID
     */
    public void setSupervId(String supervId) {
        this.supervId = supervId;
    }

    /**
     * 取最后一次发生的报警督办的接收时间，epoch millis。从未发生督办，则为NULL
     * @return 最后一次发生的报警督办的接收时间，epoch millis
     */
    public Long getSupervTm() {
        return supervTm;
    }

    /**
     * 设置最后一次发生的报警督办的接收时间，epoch millis
     * @param supervTm 最后一次发生的报警督办的接收时间，epoch millis
     */
    public void setSupervTm(Long supervTm) {
        this.supervTm = supervTm;
    }

    /**
     * 取最后一次发生的报警督办的截止时间, epoch millis
     * @return 最后一次发生的报警督办的截止时间, epoch millis
     */
    public Long getSupervDeadline() {
        return supervDeadline;
    }

    /**
     * 设置最后一次发生的报警督办的截止时间, epoch millis
     * @param supervDeadline 最后一次发生的报警督办的截止时间, epoch millis
     */
    public void setSupervDeadline(Long supervDeadline) {
        this.supervDeadline = supervDeadline;
    }

    /**
     * 取是否需要回应上级平台的督办，为NULL或false表示不需要
     * @return 是否需要回应上级平台的督办，为NULL或false表示不需要
     */
    public Boolean getSupervReplyNeeded() {
        return supervReplyNeeded;
    }

    /**
     * 设置是否需要回应上级平台的督办，为NULL或false表示不需要
     * @param supervReplyNeeded 是否需要回应上级平台的督办，为NULL或false表示不需要
     */
    public void setSupervReplyNeeded(Boolean supervReplyNeeded) {
        this.supervReplyNeeded = supervReplyNeeded;
    }

    /**
     * 返回是否 ADAS 报警
     * @return 是否 ADAS 报警
     */
    public boolean isAdasAlm() {
        return AdasAlmTypes.isAdasAlmType(typ);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Alm.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("simNo='" + simNo + "'")
                .add("plateNo='" + plateNo + "'")
                .add("plateColor=" + plateColor)
                .add("trkId='" + trkId + "'")
                .add("typ='" + typ + "'")
                .add("subTyp='" + subTyp + "'")
                .add("src=" + src)
                .add("lvl=" + lvl)
                .add("actv=" + actv)
                .add("tm1=" + tm1)
                .add("recvTm1=" + recvTm1)
                .add("lng1=" + lng1)
                .add("lat1=" + lat1)
                .add("spd1=" + spd1)
                .add("recSpd1=" + recSpd1)
                .add("alt1=" + alt1)
                .add("dir1=" + dir1)
                .add("addt1=" + addt1)
                .add("tm0=" + tm0)
                .add("recvTm0=" + recvTm0)
                .add("lng0=" + lng0)
                .add("lat0=" + lat0)
                .add("spd0=" + spd0)
                .add("recSpd0=" + recSpd0)
                .add("alt0=" + alt0)
                .add("dir0=" + dir0)
                .add("addt0=" + addt0)
                .add("dur=" + dur)
                .add("attCnt=" + attCnt)
                .add("drvName='" + drvName + "'")
                .add("drvNo='" + drvNo + "'")
                .add("platRgnId='" + platRgnId + "'")
                .add("platRgnName='" + platRgnName + "'")
                .add("procSt=" + procSt)
                .add("procMeth=" + procMeth)
                .add("procTm=" + procTm)
                .add("oprName='" + oprName + "'")
                .add("oprCorpName='" + oprCorpName + "'")
                .add("supervId='" + supervId + "'")
                .add("supervTm=" + supervTm)
                .add("supervDeadline=" + supervDeadline)
                .add("supervReplyNeeded=" + supervReplyNeeded)
                .toString();
    }
}
