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

    public String getReqId() {
        return reqId;
    }

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

    public int get__limit() {
        return __limit;
    }

    public void set__limit(int __limit) {
        this.__limit = __limit;
    }

    public int get__page() {
        return __page;
    }

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
