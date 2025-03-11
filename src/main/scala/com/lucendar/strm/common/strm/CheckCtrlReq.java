package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;


/**
 * 检查是否有控制权请求
 */
public class CheckCtrlReq implements StrmMsg {
    /**
     * 请求ID
     */
    private String reqId;

    /**
     * 构造函数
     */
    public CheckCtrlReq() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     */
    public CheckCtrlReq(String reqId) {
        this.reqId = reqId;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckCtrlReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__CheckCtrlReq;
    }
}

