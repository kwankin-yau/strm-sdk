/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 释放流请求项
 */
public class ReleaseStrmReqItem {

    private String reqId;
    private int closeCause;

    /**
     * 构造函数
     */
    public ReleaseStrmReqItem() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param closeCause 关闭原因
     */
    public ReleaseStrmReqItem(String reqId, int closeCause) {
        this.reqId = reqId;
        this.closeCause = closeCause;
    }

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取关闭原因, 为 StrmMediaNotif.CLOSE_CAUSE_* 常量之一
     * @return 关闭原因
     */
    public int getCloseCause() {
        return closeCause;
    }

    /**
     * 设置关闭原因, 为 StrmMediaNotif.CLOSE_CAUSE_* 常量之一
     * @param closeCause 关闭原因
     */
    public void setCloseCause(int closeCause) {
        this.closeCause = closeCause;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseStrmReqItem.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("closeCause=" + closeCause)
                .toString();
    }
}
