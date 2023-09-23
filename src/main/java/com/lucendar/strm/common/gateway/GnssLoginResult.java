package com.lucendar.strm.common.gateway;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

public class GnssLoginResult {
    private String authToken;
    private String ver;
    private String[] features;
    private Map<String, String> config;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssLoginResult.class.getSimpleName() + "[", "]")
                .add("authToken='" + authToken + "'")
                .add("ver='" + ver + "'")
                .add("features=" + Arrays.toString(features))
                .add("config=" + config)
                .toString();
    }
}
