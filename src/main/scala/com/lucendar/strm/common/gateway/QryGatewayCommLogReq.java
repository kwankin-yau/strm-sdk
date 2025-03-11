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

    /**
     * 获取开始时间, 格式: yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间, 格式: yyyy-MM-dd HH:mm:ss
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
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

    /**
     * 获取每页记录数
     * @return 每页记录数
     */
    public int get__limit() {
        return __limit;
    }

    /**
     * 设置每页记录数
     * @param __limit 每页记录数
     */
    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    /**
     * 获取页码
     * @return 页码, 从1开始
     */
    public int get__page() {
        return __page;
    }

    /**
     * 设置页码
     * @param __page 页码, 从1开始
     */
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
