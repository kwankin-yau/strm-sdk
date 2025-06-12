/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.types;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 视频上传设置监控请求
 */
public class AvUploadSetMonitoringReq {

    // This field is marked as `transient` which used by `strm-proxy` internal, client code need not set this field.
    private transient String token;
    private String[] reqIds;

    /**
     * 取令牌
     * @return 令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置令牌
     * @param token 令牌
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 取请求ID列表
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
        return new StringJoiner(", ", AvUploadSetMonitoringReq.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("reqIds=" + Arrays.toString(reqIds))
                .toString();
    }
}
