package com.lucendar.strm.common.gateway;

import java.util.StringJoiner;

/**
 * 查询终端网关通讯日志
 */
public class QryGatewayCommLogReq {

    private String startTime;
    private String appId;
    private String simNo;
    private boolean retData;
    private int __limit;
    private int __page;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

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

    /**
     * 取是否返回 `data` 属性。为 false 时，不返回 `data` 而返回 `dataSz`
     * @return 是否返回 `data` 属性。为 false 时，不返回 `data` 而返回 `dataSz`
     */
    public boolean isRetData() {
        return retData;
    }

    /**
     * 设置是否返回 `data` 属性。为 false 时，不返回 `data` 而返回 `dataSz`
     * @param retData 是否返回 `data` 属性。为 false 时，不返回 `data` 而返回 `dataSz`
     */
    public void setRetData(boolean retData) {
        this.retData = retData;
    }

    public int get__limit() {
        return __limit;
    }

    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    public int get__page() {
        return __page;
    }

    public void set__page(int __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryGatewayCommLogReq.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("retData=" + retData)
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
