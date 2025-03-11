/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

/**
 * 上传终端远程录像应答
 */
public class AvUploadResult {
    private String reqId;

    /**
     * 请求ID。由服务端产生或调用者在`AvUploadReq`中指定。
     *
     * @return 请求ID。
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID。由服务端产生或调用者在`AvUploadReq`中指定。
     *
     * @param reqId 请求ID。
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    @Override
    public String toString() {
        return "AVUploadResult{" +
                "reqId='" + reqId + '\'' +
                '}';
    }
}
