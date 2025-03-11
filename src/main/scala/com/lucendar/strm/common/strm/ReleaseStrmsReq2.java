/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 释放流请求(可设置关闭原因)
 */
public class ReleaseStrmsReq2 implements StrmMsg {

    private List<ReleaseStrmReqItem> reqItems;

    /**
     * 构造函数
     */
    public ReleaseStrmsReq2() {
    }

    /**
     * 构造函数
     * @param item 释放流请求项
     */
    public ReleaseStrmsReq2(ReleaseStrmReqItem item) {
        add(item);
    }

    /**
     * 获取释放流请求项列表
     * @return 释放流请求项列表
     */
    public List<ReleaseStrmReqItem> getReqItems() {
        return reqItems;
    }

    /**
     * 设置释放流请求项列表
     * @param reqItems 释放流请求项列表
     */
    public void setReqItems(List<ReleaseStrmReqItem> reqItems) {
        this.reqItems = reqItems;
    }

    /**
     * 添加释放流请求项
     * @param item 释放流请求项
     */
    public void add(ReleaseStrmReqItem item) {
        if (this.reqItems == null)
            this.reqItems = new ArrayList<>();

        this.reqItems.add(item);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseStrmsReq2.class.getSimpleName() + "[", "]")
                .add("reqItems=" + reqItems)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__ReleaseStrmsReq2;
    }
}
