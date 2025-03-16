/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import java.lang.reflect.Type;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.gson.reflect.TypeToken;
import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.adas.AdasAlmTypes;
import info.gratour.jtcommon.JTConsts;

/**
 * 轨迹附加信息
 */
@Expose
public class TrkAddt implements Cloneable {

    /**
     * 轨迹附加信息的类型
     */
    public static final Type TYPE = new TypeToken<TrkAddt>() {
    }.getType();

    /**
     * 轨迹的 ID
     */
    private String id;

    /**
     * 卫星数
     */
    private Short sat;

    /**
     * 网络信号强度
     */
    private Short netSigStr;

    private Integer confirmAlmId;
    private OverSpdAddt overSpd;
    private AcrossAreaAddt acrossArea;
    private RouteAlmAddt routeAlm;
    private AnalogQty anQty;

    /**
     * 视频丢失报警状态字
     */
    private Integer vidLoss;

    /**
     * 视频遮挡报警状态字
     */
    private Integer vidCover;

    /**
     * 视频存储报警状态字
     */
    private Short vidStgAlm;

    /**
     * 异常驾驶行为报警
     */
    private UnusualDriveBehav unusualDriveBehav;

    /**
     * adas
     */
    private AdasDrivingAssistAlmAddt drivingAssistAlm;
    private AdasDriverBehavAlmAddt driverBehavAlm;
    private AdasTyreState tyreState;
    private AdasBlindAreaAlmAddt blindArea;
    private AdasIntenseDrivingAlmAddt intenseDrivingAlm;
    private AdasOverSpdAlmAddt adasOverSpd;
    private AdasAiRecogAlmAddt aiRecogAlm;
    private AdasOverloadAlmAddt overloadAlmAddt;
    private AdasOverHeightAlmAddt overHeightAlmAddt;

    /**
     * 获取轨迹的 ID
     * @return 轨迹的 ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置轨迹的 ID
     * @param id 轨迹的 ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取卫星数
     * @return 卫星数
     */
    public Short getSat() {
        return sat;
    }

    /**
     * 设置卫星数
     * @param sat 卫星数
     */
    public void setSat(Short sat) {
        this.sat = sat;
    }

    /**
     * 获取网络信号强度
     * @return 网络信号强度
     */
    public Short getNetSigStr() {
        return netSigStr;
    }

    /**
     * 设置网络信号强度
     * @param netSigStr 网络信号强度
     */
    public void setNetSigStr(Short netSigStr) {
        this.netSigStr = netSigStr;
    }

    /**
     * 获取确认的报警 ID
     * @return 确认的报警 ID
     */
    public Integer getConfirmAlmId() {
        return confirmAlmId;
    }

    /**
     * 设置确认的报警 ID
     * @param confirmAlmId 确认的报警 ID
     */
    public void setConfirmAlmId(Integer confirmAlmId) {
        this.confirmAlmId = confirmAlmId;
    }

    /**
     * 获取超速附加信息
     * @return 超速附加信息
     */
    public OverSpdAddt getOverSpd() {
        return overSpd;
    }

    /**
     * 设置超速附加信息
     * @param overSpd 超速附加信息
     */
    public void setOverSpd(OverSpdAddt overSpd) {
        this.overSpd = overSpd;
    }

    /**
     * 获取进出区域/路线报警附加信息
     * @return 进出区域/路线报警附加信息
     */
    public AcrossAreaAddt getAcrossArea() {
        return acrossArea;
    }

    /**
     * 设置进出区域/路线报警附加信息
     * @param acrossArea 进出区域/路线报警附加信息
     */
    public void setAcrossArea(AcrossAreaAddt acrossArea) {
        this.acrossArea = acrossArea;
    }

    /**
     * 获取路线行驶时间不足/过长报警附加信息
     * @return 路线行驶时间不足/过长报警附加信息
     */
    public RouteAlmAddt getRouteAlm() {
        return routeAlm;
    }

    /**
     * 设置路线行驶时间不足/过长报警附加信息
     * @param routeAlm 路线行驶时间不足/过长报警附加信息
     */
    public void setRouteAlm(RouteAlmAddt routeAlm) {
        this.routeAlm = routeAlm;
    }

    /**
     * 获取模拟量数据
     * @return 模拟量数据
     */
    public AnalogQty getAnQty() {
        return anQty;
    }

    /**
     * 设置模拟量数据
     * @param anQty 模拟量数据
     */
    public void setAnQty(AnalogQty anQty) {
        this.anQty = anQty;
    }

    /**
     * 获取视频丢失报警状态字
     * @return 视频丢失报警状态字
     */
    public Integer getVidLoss() {
        return vidLoss;
    }

    /**
     * 设置视频丢失报警状态字
     * @param vidLoss 视频丢失报警状态字
     */
    public void setVidLoss(Integer vidLoss) {
        this.vidLoss = vidLoss;
    }

    /**
     * 获取视频遮挡报警状态字
     * @return 视频遮挡报警状态字
     */
    public Integer getVidCover() {
        return vidCover;
    }

    /**
     * 设置视频遮挡报警状态字
     * @param vidCover 视频遮挡报警状态字
     */
    public void setVidCover(Integer vidCover) {
        this.vidCover = vidCover;
    }

    /**
     * 获取视频存储报警状态字
     * @return 视频存储报警状态字
     */
    public Short getVidStgAlm() {
        return vidStgAlm;
    }

    /**
     * 设置视频存储报警状态字
     * @param vidStgAlm 视频存储报警状态字
     */
    public void setVidStgAlm(Short vidStgAlm) {
        this.vidStgAlm = vidStgAlm;
    }

    /**
     * 获取异常驾驶行为报警
     * @return 异常驾驶行为报警
     */
    public UnusualDriveBehav getUnusualDriveBehav() {
        return unusualDriveBehav;
    }

    /**
     * 设置异常驾驶行为报警
     * @param unusualDriveBehav 异常驾驶行为报警
     */
    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        this.unusualDriveBehav = unusualDriveBehav;
    }

    /**
     * 获取 ADAS 驾驶辅助报警附加信息
     * @return ADAS 驾驶辅助报警附加信息
     */
    public AdasDrivingAssistAlmAddt getDrivingAssistAlm() {
        return drivingAssistAlm;
    }

    /**
     * 设置 ADAS 驾驶辅助报警附加信息
     * @param drivingAssistAlm ADAS 驾驶辅助报警附加信息
     */
    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt drivingAssistAlm) {
        this.drivingAssistAlm = drivingAssistAlm;
    }

    /**
     * 获取 ADAS 驾驶员行为报警附加信息
     * @return ADAS 驾驶员行为报警附加信息
     */
    public AdasDriverBehavAlmAddt getDriverBehavAlm() {
        return driverBehavAlm;
    }

    /**
     * 设置 ADAS 驾驶员行为报警附加信息
     * @param driverBehavAlm ADAS 驾驶员行为报警附加信息
     */
    public void setDriverBehavAlm(AdasDriverBehavAlmAddt driverBehavAlm) {
        this.driverBehavAlm = driverBehavAlm;
    }

    /**
     * 获取 ADAS 轮胎状态报警附加信息
     * @return ADAS 轮胎状态报警附加信息
     */
    public AdasTyreState getTyreState() {
        return tyreState;
    }

    /**
     * 设置 ADAS 轮胎状态报警附加信息
     * @param tyreState ADAS 轮胎状态报警附加信息
     */
    public void setTyreState(AdasTyreState tyreState) {
        this.tyreState = tyreState;
    }

    /**
     * 获取 ADAS 盲区报警附加信息
     * @return ADAS 盲区报警附加信息
     */
    public AdasBlindAreaAlmAddt getBlindArea() {
        return blindArea;
    }

    /**
     * 设置 ADAS 盲区报警附加信息
     * @param blindArea ADAS 盲区报警附加信息
     */
    public void setBlindArea(AdasBlindAreaAlmAddt blindArea) {
        this.blindArea = blindArea;
    }

    /**
     * 获取 ADAS 激烈驾驶报警附加信息
     * @return ADAS 激烈驾驶报警附加信息
     */
    public AdasIntenseDrivingAlmAddt getIntenseDrivingAlm() {
        return intenseDrivingAlm;
    }

    /**
     * 设置 ADAS 激烈驾驶报警附加信息
     * @param intenseDrivingAlm ADAS 激烈驾驶报警附加信息
     */
    public void setIntenseDrivingAlm(AdasIntenseDrivingAlmAddt intenseDrivingAlm) {
        this.intenseDrivingAlm = intenseDrivingAlm;
    }

    /**
     * 获取 ADAS 超速报警附加信息
     * @return ADAS 超速报警附加信息
     */
    public AdasOverSpdAlmAddt getAdasOverSpd() {
        return adasOverSpd;
    }

    /**
     * 设置 ADAS 超速报警附加信息
     * @param adasOverSpd ADAS 超速报警附加信息
     */
    public void setAdasOverSpd(AdasOverSpdAlmAddt adasOverSpd) {
        this.adasOverSpd = adasOverSpd;
    }

    /**
     * 获取 ADAS 智能识别报警附加信息
     * @return ADAS 识别报警附加信息
     */
    public AdasAiRecogAlmAddt getAiRecogAlm() {
        return aiRecogAlm;
    }

    /**
     * 设置 ADAS 智能识别报警附加信息
     * @param aiRecogAlm ADAS 智能识别报警附加信息
     */
    public void setAiRecogAlm(AdasAiRecogAlmAddt aiRecogAlm) {
        this.aiRecogAlm = aiRecogAlm;
    }

    /**
     * 获取 ADAS 超载报警附加信息
     * @return ADAS 超载报警附加信息
     */
    public AdasOverloadAlmAddt getOverloadAlmAddt() {
        return overloadAlmAddt;
    }

    /**
     * 设置 ADAS 超载报警附加信息
     * @param overloadAlmAddt ADAS 超载报警附加信息
     */
    public void setOverloadAlmAddt(AdasOverloadAlmAddt overloadAlmAddt) {
        this.overloadAlmAddt = overloadAlmAddt;
    }

    /**
     * 获取 ADAS 超限报警附加信息
     * @return ADAS 超限报警附加信息
     */
    public AdasOverHeightAlmAddt getOverHeightAlmAddt() {
        return overHeightAlmAddt;
    }

    /**
     * 设置 ADAS 超限报警附加信息
     * @param overHeightAlmAddt ADAS 超限报警附加信息
     */
    public void setOverHeightAlmAddt(AdasOverHeightAlmAddt overHeightAlmAddt) {
        this.overHeightAlmAddt = overHeightAlmAddt;
    }

    /**
     * 按报警类型取 ADAS 报警附件信息
     *
     * @param almTyp ADAS 报警类型
     * @return ADAS 报警附件信息。如果 `almTyp` 不是 ADAS 报警类型，或不能识别，则返回 null
     */
    @Nullable
    public AdasAddt getAdasAddtByAlmTyp(String almTyp) {
        if (AdasAlmTypes.DrivingAssistAlm.isDrivingAssistAlmTyp(almTyp)) {
            return drivingAssistAlm;
        } else if (AdasAlmTypes.DriverBehavAlm.isDriverBehavAlmTyp(almTyp)) {
            return driverBehavAlm;
        } else if (AdasAlmTypes.TyreStateAlm.isTyreStateAlmTyp(almTyp)) {
            return tyreState;
        } else if (AdasAlmTypes.BlindAreaAlm.isBlindAreaAlmTyp(almTyp)) {
            return blindArea;
        } else if (AdasAlmTypes.IntenseDrivingAlm.isIntenseDrivingAlmTyp(almTyp)) {
            return intenseDrivingAlm;
        } else if (AdasAlmTypes.OverSpdAlm.isOverSpdAlmTyp(almTyp)) {
            return adasOverSpd;
        } else if (AdasAlmTypes.OverHeightAlm.isOverHeightAlmTyp(almTyp)) {
            return overHeightAlmAddt;
        } else if (AdasAlmTypes.AiRecogAlm.isAiRecogAlmTyp(almTyp)) {
            return aiRecogAlm;
        } else
            return null;
    }

    /**
     * 从 另一个 TrkAddt 复制属性到本 TrkAddt 对象中
     *
     * @param source 源TrkAddt
     */
    public void assignFrom(TrkAddt source) {
        this.id = source.id;
        this.sat = source.sat;
        this.netSigStr = source.netSigStr;
        this.confirmAlmId = source.confirmAlmId;
        this.overSpd = source.overSpd;
        this.acrossArea = source.acrossArea;
        this.routeAlm = source.routeAlm;
        this.anQty = source.anQty;
        this.vidLoss = source.vidLoss;
        this.vidCover = source.vidCover;
        this.vidStgAlm = source.vidStgAlm;
        this.unusualDriveBehav = source.unusualDriveBehav != null ? source.unusualDriveBehav.clone() : null;
        this.drivingAssistAlm = source.drivingAssistAlm != null ? source.drivingAssistAlm.clone() : null;
        this.driverBehavAlm = source.driverBehavAlm != null ? source.driverBehavAlm.clone() : null;
        this.tyreState = source.tyreState != null ? source.tyreState.clone() : null;
        this.blindArea = source.blindArea != null ? source.blindArea.clone() : null;
        this.intenseDrivingAlm = source.intenseDrivingAlm != null ? source.intenseDrivingAlm.clone() : null;
        this.adasOverSpd = source.adasOverSpd != null ? source.adasOverSpd.clone() : null;
        this.aiRecogAlm = source.aiRecogAlm != null ? source.aiRecogAlm.clone() : null;
        this.overloadAlmAddt = source.overloadAlmAddt != null ? source.overloadAlmAddt.clone() : null;
        this.overHeightAlmAddt = source.overHeightAlmAddt != null ? source.overHeightAlmAddt.clone() : null;
    }

    @Override
    public TrkAddt clone() {
        TrkAddt r = new TrkAddt();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return JTConsts.GSON().toJson(this);
    }
}
