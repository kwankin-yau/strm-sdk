/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 查询流活动报表请求
 */
public class QryStrmActivityReq implements StrmMsg {

    private String appId;
    private String simNo;
    private String startTmFrom;
    private String startTmTo;
    private int __limit;
    private int __page;

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
     * 获取开始时间, 格式: yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTmFrom() {
        return startTmFrom;
    }

    /**
     * 设置开始时间, 格式: yyyy-MM-dd HH:mm:ss
     * @param startTmFrom 开始时间
     */
    public void setStartTmFrom(String startTmFrom) {
        this.startTmFrom = startTmFrom;
    }

    /**
     * 获取结束时间, 格式: yyyy-MM-dd HH:mm:ss
     * @return 结束时间
     */
    public String getStartTmTo() {
        return startTmTo;
    }

    /**
     * 设置结束时间, 格式: yyyy-MM-dd HH:mm:ss
     * @param startTmTo 结束时间
     */
    public void setStartTmTo(String startTmTo) {
        this.startTmTo = startTmTo;
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

    /**
     * 获取应用ID, 如果为null, 则使用默认应用ID
     * @return 应用ID
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmActivityReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("startTmFrom='" + startTmFrom + "'")
                .add("startTmTo='" + startTmTo + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryStrmActivityReq;
    }
}
