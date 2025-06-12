package com.lucendar.gnss.sdk.gateway;

import java.util.StringJoiner;

import com.lucendar.strm.common.StrmMediaNotif;

/**
 * 流媒体通知记录
 */
public class StrmMediaNotifRec {

    private String reqId;
    private long reqTm;
    private long notifTm;
    private StrmMediaNotif notif;

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取请求时间
     * @return 请求时间, epoch millis
     */
    public long getReqTm() {
        return reqTm;
    }

    /**
     * 设置请求时间
     * @param reqTm 请求时间, epoch millis
     */
    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 获取通知时间
     * @return 通知时间, epoch millis
     */
    public long getNotifTm() {
        return notifTm;
    }

    /**
     * 设置通知时间
     * @param notifTm 通知时间, epoch millis
     */
    public void setNotifTm(long notifTm) {
        this.notifTm = notifTm;
    }

    /**
     * 获取媒体通知
     * @return 媒体通知
     */
    public StrmMediaNotif getNotif() {
        return notif;
    }

    /**
     * 设置媒体通知
     * @param notif 媒体通知
     */
    public void setNotif(StrmMediaNotif notif) {
        this.notif = notif;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmMediaNotifRec.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("reqTm=" + reqTm)
                .add("notifTm=" + notifTm)
                .add("notif=" + notif)
                .toString();
    }
}
