/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

public class AvStoreLog implements StrmMsg {

    private String reqId;
    private String reqTm;
    private String simNo;
    private int chan;
    private boolean live;
    private String path;
    private String ext;
    private long sz;
    private String url;

    public AvStoreLog() {
    }

    public AvStoreLog(String reqId, String reqTm, String simNo, int chan, boolean live, String path, String ext, long sz) {
        this.reqId = reqId;
        this.reqTm = reqTm;
        this.simNo = simNo;
        this.chan = chan;
        this.live = live;
        this.path = path;
        this.ext = ext;
        this.sz = sz;
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

    public AvStoreLog copyWithNewSz(long newSz) {
        AvStoreLog r = new AvStoreLog();
        r.reqId = reqId;
        r.reqTm = reqTm;
        r.simNo = simNo;
        r.chan = chan;
        r.live = live;
        r.path = path;
        r.ext = ext;
        r.sz = newSz;
        r.url = url;

        return r;
    }

    @Override
    public String toString() {
        return "AVStoreLog{" +
                "reqId='" + reqId + '\'' +
                ", reqTm='" + reqTm + '\'' +
                ", simNo='" + simNo + '\'' +
                ", chan=" + chan +
                ", live=" + live +
                ", path='" + path + '\'' +
                ", ext='" + ext + '\'' +
                ", sz=" + sz +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__AvStoreLog;
    }
}
