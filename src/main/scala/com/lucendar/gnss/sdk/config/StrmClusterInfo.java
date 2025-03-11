/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 流媒体集群配置信息
 */
@Deprecated
public class StrmClusterInfo implements Cloneable {

    private List<StrmServerInfo> serverList = new ArrayList<>();

    /**
     * 获取服务器列表
     * @return 服务器列表
     */
    public List<StrmServerInfo> getServerList() {
        return serverList;
    }

    /**
     * 设置服务器列表
     * @param serverList 服务器列表
     */
    public void setServerList(List<StrmServerInfo> serverList) {
        this.serverList = serverList;
    }

    /**
     * 查找服务器配置信息
     * @param instanceId 服务器实例ID
     * @return 服务器配置信息
     */
    public StrmServerInfo find(String instanceId) {
        if (this.serverList == null)
            return null;

        for (StrmServerInfo info : this.serverList)
            if (Objects.equals(info.getConfig().getInstanceId(), instanceId))
                return info;

        return null;
    }

    /**
     * 从集群配置信息中赋值
     * @param clusterConfig 集群配置信息
     */
    public void assign(StrmMediaClusterConfig clusterConfig) {
        serverList.clear();

        for (StrmMediaConfig config : clusterConfig.getList()) {
            StrmMediaConfig cfg = config.clone();
            StrmServerInfo info = new StrmServerInfo();
            info.setConfig(cfg);

            serverList.add(info);
        }
    }

    /**
     * 从源集群配置信息中赋值
     * @param source 源集群配置信息
     */
    public void assignFrom(StrmClusterInfo source) {
        List<StrmServerInfo> serverList = source.serverList;
        if (serverList != null) {
            this.serverList = new ArrayList<>();
            for (StrmServerInfo info : source.serverList) {
                this.serverList.add(info.clone());
            }
        } else
            this.serverList = null;
    }

    /**
     * 初始化集群配置信息
     * @param clusterConfig 集群配置信息
     * @return 集群配置信息
     */
    public static StrmClusterInfo init(StrmMediaClusterConfig clusterConfig) {
        StrmClusterInfo r = new StrmClusterInfo();
        r.assign(clusterConfig);
        return r;
    }

    @Override
    public StrmClusterInfo clone() {
        StrmClusterInfo r = new StrmClusterInfo();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmClusterInfo.class.getSimpleName() + "[", "]")
                .add("serverList=" + serverList)
                .toString();
    }
}
