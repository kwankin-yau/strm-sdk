package com.lucendar.gnss.sdk.gateway;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.types.ScopedSimNo;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 属性查询结果项
 * @param <ATTRS> 属性类型
 */
public class AttrsQryResultItem<ATTRS extends JT808AckParams> {

    private String appId;
    private String simNo;
    private ATTRS attrs;

    /**
     * 获取AppId
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置AppId
     * @param appId AppId
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
     * 设置ScopedSimNo
     * @param scopedSimNo ScopedSimNo
     */
    public void setScopedSimNo(ScopedSimNo scopedSimNo) {
        this.appId = scopedSimNo.getAppId();
        this.simNo = scopedSimNo.getSimNo();
    }

    /**
     * 获取属性
     * @return 属性
     */
    public ATTRS getAttrs() {
        return attrs;
    }

    /**
     * 设置属性
     * @param attrs 属性
     */
    public void setAttrs(ATTRS attrs) {
        this.attrs = attrs;
    }

    /**
     * 获取AppId，如果未设置则返回默认值
     * @return AppId或默认值
     */
    public String appIdDef() {
        return Objects.requireNonNullElse(appId, StreamingApi.DEFAULT_APP_ID);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AttrsQryResultItem.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("attrs=" + attrs)
                .toString();
    }
}
