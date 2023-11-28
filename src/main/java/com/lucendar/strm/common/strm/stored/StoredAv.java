/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

/**
 * 终端音视频播放或回放时，服务端同时存储在服务器本地的转录文件
 */
public class StoredAv implements StrmMsg {

    private String reqId;
    private String reqTm;
    private String appId;
    private String simNo;
    private int chan;
    private boolean live;
    private String path;
    private String ext;
    private long sz;
    private String url;
    private String mediaTyp;

    public StoredAv() {
    }

    public StoredAv(
            String reqId,
            String reqTm,
            String appId,
            String simNo,
            int chan,
            boolean live,
            String path,
            String ext,
            long sz,
            String mediaTyp) {
        this.reqId = reqId;
        this.reqTm = reqTm;
        this.appId = appId;
        this.simNo = simNo;
        this.chan = chan;
        this.live = live;
        this.path = path;
        this.ext = ext;
        this.sz = sz;
        this.mediaTyp = mediaTyp;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public int getChan() {
        return chan;
    }

    public void setChan(int chan) {
        this.chan = chan;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public long getSz() {
        return sz;
    }

    public void setSz(long sz) {
        this.sz = sz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    public StoredAv copyWithNewSzAndMediaTyp(long newSz, String newMediaTyp) {
        StoredAv r = new StoredAv();
        r.reqId = reqId;
        r.reqTm = reqTm;
        r.appId = appId;
        r.simNo = simNo;
        r.chan = chan;
        r.live = live;
        r.path = path;
        r.ext = ext;
        r.sz = newSz;
        r.url = url;
        r.mediaTyp = newMediaTyp;

        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StoredAv.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("reqTm='" + reqTm + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("chan=" + chan)
                .add("live=" + live)
                .add("path='" + path + "'")
                .add("ext='" + ext + "'")
                .add("sz=" + sz)
                .add("url='" + url + "'")
                .add("mediaTyp='" + mediaTyp + "'")
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__StoredAv;
    }
}
