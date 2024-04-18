package com.lucendar.gnss.sdk.gateway;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.types.ScopedSimNo;
import info.gratour.jt808common.protocol.msg.types.JT1078TermAvAttrs;

import java.util.Objects;
import java.util.StringJoiner;

public class TermAvAttrsQryResultItem {

    private String appId;
    private String simNo;
    private JT1078TermAvAttrs attrs;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public void setScopedSimNo(ScopedSimNo scopedSimNo) {
        this.appId = scopedSimNo.getAppId();
        this.simNo = scopedSimNo.getSimNo();
    }

    public JT1078TermAvAttrs getAttrs() {
        return attrs;
    }

    public void setAttrs(JT1078TermAvAttrs attrs) {
        this.attrs = attrs;
    }

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
