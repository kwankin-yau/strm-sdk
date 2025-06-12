/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 查询流统计报表请求
 */
public class QryStrmStatReq implements StrmMsg {

    private String dateFrom;
    private String dateTo;

    /**
     * 获取开始日期
     * @return 开始日期, 格式: yyyy-MM-dd
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * 设置开始日期
     * @param dateFrom 开始日期, 格式: yyyy-MM-dd
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * 获取结束日期
     * @return 结束日期, 格式: yyyy-MM-dd
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * 设置结束日期
     * @param dateTo 结束日期, 格式: yyyy-MM-dd
     */
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmStatReq.class.getSimpleName() + "[", "]")
                .add("dateFrom='" + dateFrom + "'")
                .add("dateTo='" + dateTo + "'")
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryStrmStatReq;
    }
}
