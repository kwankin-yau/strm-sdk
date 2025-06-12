package com.lucendar.gnss.sdk.gateway;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.types.ScopedSimNo;

/**
 * 终端上下线通知
 */
public class OnlineOfflineNotif {
    private String appId;
    private String simNo;
    private boolean online;
    private long tm;
    private Long totalConnectTimes;
    private String gwInstId;

    private String protoVer;

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 是否上线通知。false表下线通知。
     *
     * @return 是否上线通知
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * 设置是否上线通知
     * @param online 是否上线通知
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    /**
     * 获取通知时间, epoch millis
     * @return 通知时间
     */
    public long getTm() {
        return tm;
    }

    /**
     * 设置通知时间
     * @param tm 通知时间, epoch millis
     */
    public void setTm(long tm) {
        this.tm = tm;
    }

    /**
     * 产生本通知的网关的ID。可能为 null。
     *
     * @return 产生本通知的网关的ID
     */
    public String getGwInstId() {
        return gwInstId;
    }

    /**
     * 设置产生本通知的网关的ID
     * @param gwInstId 产生本通知的网关的ID
     */
    public void setGwInstId(String gwInstId) {
        this.gwInstId = gwInstId;
    }

    /**
     * 判断是否为下线通知
     * @return 如果为下线通知，则返回 true，否则返回 false
     */
    public boolean isOffline() {
        return !online;
    }

    /**
     * 获取应用ID, 如果为 null, 则返回默认应用ID
     * @return 应用ID
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 获取带应用ID的终端识别号
     * @return 带应用ID的终端识别号
     */
    public ScopedSimNo scopedSimNo() {
        return new ScopedSimNo(appIdDef(), simNo);
    }

    /**
     * 获取总连接次数
     * @return 总连接次数
     */
    public Long getTotalConnectTimes() {
        return totalConnectTimes;
    }

    /**
     * 设置总连接次数
     * @param totalConnectTimes 总连接次数
     */
    public void setTotalConnectTimes(Long totalConnectTimes) {
        this.totalConnectTimes = totalConnectTimes;
    }

    /**
     * 获取终端协议版本，0: 2013版；1: 2019版
     * @return 终端协议版本
     */
    public String getProtoVer() {
        return protoVer;
    }

    /**
     * 设置终端协议版本，0: 2013版；1: 2019版
     * @param protoVer 终端协议版本，0: 2013版；1: 2019版
     */
    public void setProtoVer(String protoVer) {
        this.protoVer = protoVer;
    }

    /**
     * 创建上线通知
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @param tm 通知时间, epoch millis
     * @param totalConnectTimes 总连接次数
     * @param protoVer 终端协议版本，0: 2013版；1: 2019版
     * @return 上线通知
     */
    public static OnlineOfflineNotif online(
            String appId,
            String simNo,
            long tm,
            Long totalConnectTimes,
            String protoVer) {
        OnlineOfflineNotif r = new OnlineOfflineNotif();
        r.setAppId(appId);
        r.setSimNo(simNo);
        r.setOnline(true);
        r.setTm(tm);
        r.setTotalConnectTimes(totalConnectTimes);
        r.setProtoVer(protoVer);

        return r;
    }

    /**
     * 创建下线通知
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @param tm 通知时间, epoch millis
     * @return 下线通知
     */
    public static OnlineOfflineNotif offline(String appId, String simNo, long tm) {
        OnlineOfflineNotif r = new OnlineOfflineNotif();
        r.setAppId(appId);
        r.setSimNo(simNo);
        r.setOnline(false);
        r.setTm(tm);

        return r;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", OnlineOfflineNotif.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("online=" + online)
                .add("tm=" + tm)
                .add("totalConnectTimes=" + totalConnectTimes)
                .add("gwInstId='" + gwInstId + "'")
                .add("protoVer=" + protoVer)
                .toString();
    }
}
