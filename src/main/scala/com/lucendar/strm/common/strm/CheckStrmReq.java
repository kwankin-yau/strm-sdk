package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 检查流请求是否有效请求
 */
public class CheckStrmReq implements StrmMsg {

    /**
     * 请求ID
     */
    private String reqId;

    /**
     * 构造函数
     */
    public CheckStrmReq() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     */
    public CheckStrmReq(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取所要检查的请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置所要检查的请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__CheckStrmReq;
    }
}
