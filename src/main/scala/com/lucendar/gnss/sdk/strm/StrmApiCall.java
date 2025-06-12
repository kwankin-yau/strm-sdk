package com.lucendar.gnss.sdk.strm;

import java.util.StringJoiner;

/**
 * 流媒体API调用记录
 */
public class StrmApiCall {
    private String reqId;
    private long reqTm;
    private String apiName;
    private long callTm;
    private String qryParams;
    private String reqBody;
    private String resp;
    private Integer err;

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
     * 获取请求时间
     * @return 请求时间, epoch millis
     */
    public long getReqTm() {
        return reqTm;
    }

    /**
     * 设置请求时间
     * @param reqTm 请求时间, epoch millis
     */
    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 获取API名称
     * @return API名称
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * 设置API名称
     * @param apiName API名称
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    /**
     * 获取调用时间
     * @return 调用时间, epoch millis
     */
    public long getCallTm() {
        return callTm;
    }

    /**
     * 设置调用时间
     * @param callTm 调用时间, epoch millis
     */
    public void setCallTm(long callTm) {
        this.callTm = callTm;
    }

    /**
     * 获取查询参数
     * @return 查询参数
     */
    public String getQryParams() {
        return qryParams;
    }

    /**
     * 设置查询参数
     * @param qryParams 查询参数
     */
    public void setQryParams(String qryParams) {
        this.qryParams = qryParams;
    }

    /**
     * 获取请求体
     * @return 请求体
     */
    public String getReqBody() {
        return reqBody;
    }

    /**
     * 设置请求体
     * @param reqBody 请求体
     */
    public void setReqBody(String reqBody) {
        this.reqBody = reqBody;
    }

    /**
     * 获取响应
     * @return 响应
     */
    public String getResp() {
        return resp;
    }

    /**
     * 设置响应
     * @param resp 响应
     */
    public void setResp(String resp) {
        this.resp = resp;
    }

    /**
     * 获取错误码
     * @return 错误码
     */
    public Integer getErr() {
        return err;
    }

    /**
     * 设置错误码
     * @param err 错误码
     */
    public void setErr(Integer err) {
        this.err = err;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmApiCall.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("reqTm=" + reqTm)
                .add("apiName='" + apiName + "'")
                .add("callTm=" + callTm)
                .add("qryParams='" + qryParams + "'")
                .add("reqBody='" + reqBody + "'")
                .add("resp='" + resp + "'")
                .add("err=" + err)
                .toString();
    }
}
