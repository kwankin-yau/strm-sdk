/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.StringJoiner;

/**
 * 查询服务缓存中的最近关闭的媒体请求的状态信息。服务端仅缓存最多两千条最近关闭的媒体请求的状态信息。
 */
public class QryRecentClosedStrmReq implements StrmMsg {

    @Nullable
    private String reqId;

    @Nullable
    private String simNo;

    private int __page;
    private int __limit;

    /**
     * 取请求ID
     *
     * @return 请求ID
     */
    @Nullable
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID。不设置时，不使用请求ID查询条件
     *
     * @param reqId 请求ID
     */
    public void setReqId(@Nullable String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    @Nullable
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号。不设置时，不使用终端识别号查询条件
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取分页的页号，从1开始
     *
     * @return 分页的页号，从1开始
     */
    public int get__page() {
        return __page;
    }

    /**
     * 设置分页的页号，从1开始
     *
     * @param __page 分页的页号，从1开始
     */
    public void set__page(int __page) {
        this.__page = __page;
    }

    /**
     * 取每个分页的记录数
     *
     * @return 每个分页的记录数
     */
    public int get__limit() {
        return __limit;
    }

    /**
     * 设置每个分页的记录数
     *
     * @param __limit 每个分页的记录数
     */
    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryRecentClosedStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("simNo='" + simNo + "'")
                .add("__page=" + __page)
                .add("__limit=" + __limit)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryRecentClosedStrmReq;
    }
}
