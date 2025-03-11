/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 媒体集群配置
 */
@Deprecated
public class StrmMediaClusterConfig {


    private static class ClusterConfig {

        /**
         * Key: instanceId
         */
        private Map<String, StrmMediaConfig> map = new TreeMap<>();
        private List<StrmMediaConfig> list = new ArrayList<>();

        /**
         * 获取媒体配置列表
         * @return 媒体配置列表
         */
        public List<StrmMediaConfig> getList() {
            return new ArrayList<>(map.values());
        }

        private void clear() {
            map.clear();
            list.clear();
        }

        private void put(StrmMediaConfig c) {
            map.put(c.getInstanceId(), c);
            list.add(c);
        }

        /**
         * 获取媒体配置
         * @param instanceId 实例ID
         * @return 媒体配置
         */
        public StrmMediaConfig getByInstanceId(String instanceId) {
            return map.get(instanceId);
        }


        /**
         * 设置媒体配置列表
         * @param configs 媒体配置列表
         */
        public void set(Collection<StrmMediaConfig> configs) {
            clear();
            configs.forEach(this::put);
        }

        /**
         * 设置媒体配置列表
         * @param configs 媒体配置列表
         */
        public void set(StrmMediaConfig[] configs) {
            clear();
            for (StrmMediaConfig c : configs)
                put(c);
        }

        /**
         * 获取媒体配置列表大小
         * @return 媒体配置列表大小
         */
        public int size() {
            return list.size();
        }

        /**
         * 获取媒体配置
         * @param index 索引
         * @return 媒体配置
         */
        public StrmMediaConfig getByIndex(int index) {
            return list.get(index);
        }
    }

    private final AtomicReference<ClusterConfig> configRef = new AtomicReference<>(new ClusterConfig());
    private final AtomicInteger lastIndex = new AtomicInteger(0);

    /**
     * 获取媒体配置
     * @param instanceId 实例ID
     * @return 媒体配置
     */
    public StrmMediaConfig getByInstanceId(String instanceId) {
        ClusterConfig config = configRef.get();
        if (config == null)
            return null;

        StrmMediaConfig r = config.getByInstanceId(instanceId);
        if (r != null)
            return r.clone();
        else
            return null;
    }

    /**
     * 设置媒体配置列表
     * @param clusterConfig 媒体配置列表
     */
    public void set(Collection<StrmMediaConfig> clusterConfig) {
        List<StrmMediaConfig> list = new ArrayList<>();
        for (StrmMediaConfig config : clusterConfig) {
            if (!config.isDisabled())
                list.add(config);
        }

        ClusterConfig config = new ClusterConfig();
        config.set(list);

        configRef.set(config);
    }

    /**
     * 设置媒体配置列表
     * @param clusterConfig 媒体配置列表
     */
    public void set(StrmMediaConfig[] clusterConfig) {
        List<StrmMediaConfig> list = new ArrayList<>();
        for (StrmMediaConfig config : clusterConfig) {
            if (!config.isDisabled())
                list.add(config);
        }

        ClusterConfig config = new ClusterConfig();
        config.set(list);

        configRef.set(config);
    }

    /**
     * 获取媒体配置列表
     * @return 媒体配置列表
     */
    public List<StrmMediaConfig> getList() {
        ClusterConfig config = configRef.get();
        return config.getList();
    }

    /**
     * 获取媒体配置
     * @return 媒体配置
     */
    public StrmMediaConfig acquire() {
        ClusterConfig config = configRef.get();
        int sz = config.size();
        if (sz == 0)
            return null;

        int idx = lastIndex.getAndIncrement();
        idx = idx % sz;
        return config.getByIndex(idx);
    }



}
