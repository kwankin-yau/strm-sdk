/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询流媒体服务信息返回结果
 *
 * @since 3.3.1
 */
public class QryInfoResult {

    private String ver;
    private long startTm;
    // actually is rotateRight(not StartupTime2, 4)
    private long instanceId;
    private Map<String, String> attrs;

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public long getStartTm() {
        return startTm;
    }

    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    public long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    public void setAttr(String name, String value) {
        if (this.attrs == null)
            this.attrs = new HashMap<>();

        this.attrs.put(name, value);
    }

    @Override
    public String toString() {
        return "QryInfoResult{" +
                "ver='" + ver + '\'' +
                ", startTm=" + startTm +
                ", instanceId=" + instanceId +
                ", attrs=" + attrs +
                '}';
    }
}
