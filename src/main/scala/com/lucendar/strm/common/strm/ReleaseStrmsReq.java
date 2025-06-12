package com.lucendar.strm.common.strm;

import java.util.Arrays;
import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 释放流请求
 */
public class ReleaseStrmsReq implements StrmMsg {
    private String[] reqIds;

    /**
     * 构造函数
     */
    public ReleaseStrmsReq() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     */
    public ReleaseStrmsReq(String reqId) {
        this.reqIds = new String[]{reqId};
    }

    /**
     * 构造函数
     * @param reqIds 请求ID列表
     */
    public ReleaseStrmsReq(String[] reqIds) {
        this.reqIds = reqIds;
    }

    /**
     * 获取请求ID列表
     * @return 请求ID列表
     */
    public String[] getReqIds() {
        return reqIds;
    }

    /**
     * 设置请求ID列表
     * @param reqIds 请求ID列表
     */
    public void setReqIds(String[] reqIds) {
        this.reqIds = reqIds;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseStrmsReq.class.getSimpleName() + "[", "]")
                .add("reqIds=" + Arrays.toString(reqIds))
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__ReleaseStrmsReq;
    }
}
