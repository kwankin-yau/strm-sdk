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

    /**
     * 获取媒体服务的版本号
     * @return 版本号
     */
    public String getVer() {
        return ver;
    }

    /**
     * 设置媒体服务的版本号
     * @param ver 版本号
     */
    public void setVer(String ver) {
        this.ver = ver;
    }

    /**
     * 获取媒体服务启动时间, epoch millis
     * @return 启动时间
     */
    public long getStartTm() {
        return startTm;
    }

    /**
     * 设置媒体服务启动时间, epoch millis
     * @param startTm 启动时间
     */
    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    /**
     * nc
     * @return nc
     */
    public String getNc() {
        return nc;
    }

    /**
     * 设置nc
     * @param nc nc
     */
    public void setNc(String nc) {
        this.nc = nc;
    }

    /**
     * 获取属性
     * @return 属性
     */
    public Map<String, String> getAttrs() {
        return attrs;
    }

    /**
     * 设置属性
     * @param attrs 属性
     */
    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    /**
     * 设置属性
     * @param name 属性名
     * @param value 属性值
     */
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
