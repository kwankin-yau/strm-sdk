package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 查询媒体服务通讯日志请求
 */
public class QryStrmCommLogReq {

    private String reqId;
    private boolean retData;
    private int __limit;
    private int __page;

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
     * 取分页的每页记录数
     * @return 分页的每页记录数
     */
    public int get__limit() {
        return __limit;
    }

    /**
     * 设置分页的每页记录数
     * @param __limit 分页的每页记录数
     */
    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    /**
     * 取分页的页码, 从1开始
     * @return 分页的页码
     */
    public int get__page() {
        return __page;
    }

    /**
     * 设置分页的页码
     * @param __page 分页的页码
     */
    public void set__page(int __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryStrmCommLogReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("retData=" + retData)
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
