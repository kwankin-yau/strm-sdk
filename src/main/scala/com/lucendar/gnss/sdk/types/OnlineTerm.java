/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.types;

import java.util.StringJoiner;

/**
 * 在线终端
 */
public class OnlineTerm {
    private String simNo;
    private Integer protoVer;
    private Boolean acc;
    private Float spd;

    /**
     * 获取终端识别号
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
     * 获取终端协议版本。0: 2013版；1: 2019版
     * @return 终端协议版本
     */
    public Integer getProtoVer() {
        return protoVer;
    }

    /**
     * 设置终端协议版本。0: 2013版；1: 2019版
     * @param protoVer 终端协议版本
     */
    public void setProtoVer(Integer protoVer) {
        this.protoVer = protoVer;
    }

    /**
     * 获取ACC状态
     * @return ACC状态
     */
    public Boolean getAcc() {
        return acc;
    }

    /**
     * 设置ACC状态
     * @param acc ACC状态
     */
    public void setAcc(Boolean acc) {
        this.acc = acc;
    }

    /**
     * 获取速度, 单位: km/h
     * @return 速度
     */
    public Float getSpd() {
        return spd;
    }

    /**
     * 设置速度, 单位: km/h
     * @param spd 速度
     */
    public void setSpd(Float spd) {
        this.spd = spd;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OnlineTerm.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("protoVer=" + protoVer)
                .add("acc=" + acc)
                .add("spd=" + spd)
                .toString();
    }
}
