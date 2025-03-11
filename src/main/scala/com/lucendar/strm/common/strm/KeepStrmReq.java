package com.lucendar.strm.common.strm;

import java.util.Arrays;
import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 保持流请求
 */
public class KeepStrmReq implements StrmMsg {
    /**
     * 请求ID
     */
    private String[] reqIds;

    /**
     * 流服务器选择提示
     */
    private ServerHint strmServerHint;

    /**
     * 构造函数
     */
    public KeepStrmReq() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     */
    public KeepStrmReq(String reqId) {
        this.reqIds = new String[]{reqId};
    }

    /**
     * 构造函数
     * @param reqIds 请求ID
     * @param strmServerHint 流服务器选择提示
     */
    public KeepStrmReq(String[] reqIds, ServerHint strmServerHint) {
        this.reqIds = reqIds;
        this.strmServerHint = strmServerHint;
    }

    /**
     * 获取所要保持的请求ID列表
     * @return 请求ID列表
     */
    public String[] getReqIds() {
        return reqIds;
    }

    /**
     * 设置所要保持的请求ID列表
     * @param reqIds 请求ID列表
     */
    public void setReqIds(String[] reqIds) {
        this.reqIds = reqIds;
    }

    /**
     * 获取流服务器选择提示
     * @return 流服务器选择提示
     */
    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    /**
     * 设置流服务器选择提示
     * @param strmServerHint 流服务器选择提示
     */
    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public String toString() {
        if (strmServerHint != null)
            return new StringJoiner(", ", KeepStrmReq.class.getSimpleName() + "[", "]")
                    .add("reqIds=" + Arrays.toString(reqIds))
                    .add("strmServerHint=" + strmServerHint)
                    .toString();
        else
            return new StringJoiner(", ", KeepStrmReq.class.getSimpleName() + "[", "]")
                    .add("reqIds=" + Arrays.toString(reqIds))
                    .toString();

    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__KeepStrmReq;
    }
}
