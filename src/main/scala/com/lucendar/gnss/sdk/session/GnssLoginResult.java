package com.lucendar.gnss.sdk.session;

import com.google.gson.reflect.TypeToken;
import com.lucendar.common.utils.DateTimeUtils;
import com.lucendar.gnss.sdk.gateway.ServerInfo;
import info.gratour.common.types.rest.Reply;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

public class GnssLoginResult extends ServerInfo {
    public static final Type REPLY_TYPE = new TypeToken<Reply<GnssLoginResult>>(){}.getType();
    private String authToken;

    public GnssLoginResult() {
    }

    public GnssLoginResult(String authToken, String ver, long startTm, String instance, String[] features, Map<String, String> config,
                           String api) {
        this.authToken = authToken;
        setVer(ver);
        setStartTm(startTm);
        setInstance(instance);
        setFeatures(features);
        setConfig(config);
        setApi(api);
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", GnssLoginResult.class.getSimpleName() + "[", "]")
                .add("authToken='" + authToken + "'")
                .add("ver='" + getVer() + "'")
                .add("startTm=" + DateTimeUtils.millisToOffsetDateTimeString(getStartTm()))
                .add("instance='" + getInstance() + "'")
                .add("features=" + Arrays.toString(getFeatures()))
                .add("config=" + getConfig())
                .add("api=" + getApi())
                .toString();
    }
}
