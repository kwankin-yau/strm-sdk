/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.info;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 查询流媒体服务信息返回结果
 *
 * @since 3.3.1
 */
public class QryInfoResult implements Cloneable {

    private String ver;
    private long startTm;
    private String nc;
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

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
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
        return new StringJoiner(", ", QryInfoResult.class.getSimpleName() + "[", "]")
                .add("ver='" + ver + "'")
                .add("startTm=" + startTm)
                .add("nc='" + nc + "'")
                .add("attrs=" + attrs)
                .toString();
    }

    @Override
    public QryInfoResult clone() {
        try {
            QryInfoResult clone = (QryInfoResult) super.clone();
            if (this.attrs != null)
                clone.attrs = new HashMap<>(this.attrs);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
