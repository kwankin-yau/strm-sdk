package com.lucendar.gnss.sdk.gateway;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 服务端信息
 */
public class ServerInfo {
    private String ver;
    private long startTm;
    private String instance;
    private String[] features;
    private Map<String, String> config;
    private String api;
    private String wsApi;

    /**
     * 取服务端版本号
     *
     * @return 服务端版本号
     */
    public String getVer() {
        return ver;
    }

    /**
     * 设置服务端版本号
     * @param ver 服务端版本号
     */
    public void setVer(String ver) {
        this.ver = ver;
    }

    /**
     * 取服务端启动时间
     *
     * @return 服务端启动时间, epoch millis
     */
    public long getStartTm() {
        return startTm;
    }

    /**
     * 设置服务端启动时间
     * @param startTm 服务端启动时间, epoch millis
     */
    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    /**
     * 取服务实例ID
     *
     * @return 服务实例ID
     */
    public String getInstance() {
        return instance;
    }

    /**
     * 设置服务实例ID
     * @param instance 服务实例ID
     */
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * 取服务端启用的特征标识字符串列表
     *
     * @return 服务端启用的特征标识字符串列表
     */
    public String[] getFeatures() {
        return features;
    }

    /**
     * 设置服务端启用的特征标识字符串列表
     * @param features 服务端启用的特征标识字符串列表
     */
    public void setFeatures(String[] features) {
        this.features = features;
    }

    /**
     * 增加功能特征标识字符串
     *
     * @param feature 功能特征标识字符串
     */
    public void addFeature(String feature) {
        if (this.features == null) {
            this.features = new String[]{feature};
        } else {
            this.features = Arrays.copyOf(this.features, this.features.length + 1);
            this.features[this.features.length - 1] = feature;
        }
    }

    /**
     * 取服务端配置
     *
     * @return 服务端配置
     */
    public Map<String, String> getConfig() {
        return config;
    }


    /**
     * 设置服务端配置
     * @param config 服务端配置
     */
    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    /**
     * 取HTTP API地址，形如：`https://wx.gratour.info:7200`
     *
     * @return HTTP API地址
     */
    public String getApi() {
        return api;
    }

    /**
     * 设置HTTP API地址
     * @param api HTTP API地址
     */
    public void setApi(String api) {
        this.api = api;
    }

    /**
     * 取 Websocket API 地址，形如：`wss://wx.gratour.info:7211/ws2`
     * @return Websocket API 地址
     */
    public String getWsApi() {
        return wsApi;
    }

    /**
     * 设置Websocket API 地址
     * @param wsApi Websocket API 地址
     */
    public void setWsApi(String wsApi) {
        this.wsApi = wsApi;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ServerInfo.class.getSimpleName() + "[", "]")
                .add("ver='" + ver + "'")
                .add("startTm=" + startTm)
                .add("instance='" + instance + "'")
                .add("features=" + Arrays.toString(features))
                .add("config=" + config)
                .add("api='" + api + "'")
                .add("wsApi='" + wsApi + "'")
                .toString();
    }
}
