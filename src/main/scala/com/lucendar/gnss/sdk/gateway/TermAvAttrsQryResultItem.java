package com.lucendar.gnss.sdk.gateway;

import java.util.Objects;
import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.types.ScopedSimNo;

import info.gratour.jt808common.protocol.msg.types.JT1078TermAvAttrs;

/**
 * 终端音视频属性查询结果项
 */
public class TermAvAttrsQryResultItem {

    /**
     * 终端所属AppID
     */
    private String appId;
    private String simNo;
    private JT1078TermAvAttrs attrs;

    /**
     * 获取终端所属AppID
     * @return 终端所属AppID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置终端所属AppID
     * @param appId 终端所属AppID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

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
     * 设置终端所属AppID和终端识别号
     * @param scopedSimNo 终端所属AppID和终端识别号
     */
    public void setScopedSimNo(ScopedSimNo scopedSimNo) {
        this.appId = scopedSimNo.getAppId();
        this.simNo = scopedSimNo.getSimNo();
    }

    /**
     * 获取终端音视频属性
     * @return 终端音视频属性
     */
    public JT1078TermAvAttrs getAttrs() {
        return attrs;
    }

    /**
     * 设置终端音视频属性
     * @param attrs 终端音视频属性
     */
    public void setAttrs(JT1078TermAvAttrs attrs) {
        this.attrs = attrs;
    }

    /**
     * 获取终端所属AppID
     * @return 终端所属AppID
     */
    public String appIdDef() {
        return Objects.requireNonNullElse(appId, StreamingApi.DEFAULT_APP_ID);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TermAvAttrsQryResultItem.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("attrs=" + attrs)
                .toString();
    }
}
