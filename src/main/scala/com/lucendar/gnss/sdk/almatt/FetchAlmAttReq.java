/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.almatt;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.StringJoiner;

/**
 * 提取 ADAS 报警附件请求。本请求用于向媒体服务请求向终端提取指定的 ADAS 报警附件。
 */
public class FetchAlmAttReq {

    private String simNo;
    private String almNo;
    private String almTyp;
    private Integer almLvl;

    /**
     * 空构造函数
     */
    public FetchAlmAttReq() {
    }

    /**
     * 主构造函数
     * @param simNo 终端识别号
     * @param almNo 终端报警识别号
     */
    public FetchAlmAttReq(String simNo, String almNo) {
        this.simNo = simNo;
        this.almNo = almNo;
    }

    /**
     * 全构造函数
     *
     * @param simNo 终端识别号
     * @param almNo 终端报警识别号
     * @param almTyp 报警类型
     * @param almLvl 报警级别
     */
    public FetchAlmAttReq(String simNo, String almNo, String almTyp, Integer almLvl) {
        this.simNo = simNo;
        this.almNo = almNo;
        this.almTyp = almTyp;
        this.almLvl = almLvl;
    }

    private transient Long tm1Millis;

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取终端 ADAS 报警编号的 HEX 形式
     *
     * @return 终端 ADAS 报警编号的 HEX 形式
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置终端 ADAS 报警编号的 HEX 形式
     *
     * @param almNo 终端 ADAS 报警编号的 HEX 形式
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    /**
     * 取报警类型代码。注意，此报警类型为 {@link info.gratour.jt808common.adas.AdasAlmTypes} 中定义的报警类型代码，由于各省 ADAS 标准有
     * 冲突，所以此处采用的是统一的报警类型代码。
     *
     * @return 报警类型代码
     */
    public String getAlmTyp() {
        return almTyp;
    }

    /**
     * 设置报警类型代码
     *
     * @param almTyp 报警类型代码
     */
    public void setAlmTyp(String almTyp) {
        this.almTyp = almTyp;
    }

    /**
     * 取报警级别。有些 ADAS 报警没有级别。
     *
     * @return 报警级别
     */
    @Nullable
    public Integer getAlmLvl() {
        return almLvl;
    }

    /**
     * 设置报警级别
     *
     * @param almLvl 报警级别
     */
    public void setAlmLvl(Integer almLvl) {
        this.almLvl = almLvl;
    }

    /**
     * 取报警时间，epoch millis。此属性由媒体服务使用
     *
     * @return 报警时间，epoch millis
     */
    public Long getTm1Millis() {
        return tm1Millis;
    }

    /**
     * 设置报警时间，epoch millis。此属性由媒体服务使用。客户端代码不需要设置
     *
     * @param tm1Millis 报警时间，epoch millis
     */
    public void setTm1Millis(Long tm1Millis) {
        this.tm1Millis = tm1Millis;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FetchAlmAttReq.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("almNo='" + almNo + "'")
                .add("almTyp='" + almTyp + "'")
                .add("almLvl=" + almLvl)
                .toString();
    }
}
