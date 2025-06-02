/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.dump;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;
import com.lucendar.strm.common.types.RelativeFileNameProvider;

/**
 * 终端音视频播放或回放时，服务端同时存储在服务器本地的转录文件
 */
public class PlayedAvDump implements StrmMsg, RelativeFileNameProvider {

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

    /**
     * 构造函数
     */
    public PlayedAvDump() {
    }

    /**
     * 构造函数
     * @param reqId 请求ID
     * @param reqTm 请求时间
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @param chan 通道号
     * @param live 是否实时音视频
     * @param path 文件路径
     * @param ext 文件扩展名
     * @param sz 文件大小
     * @param mediaTyp 媒体类型
     */
    public PlayedAvDump(
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

    /**
     * 取播放时的请求ID
     *
     * @return 播放时的请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置播放时的请求ID
     *
     * @param reqId 播放时的请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取播放流请求（实时音视频或远程录像回放）的时间
     *
     * @return 播放流请求（实时音视频或远程录像回放）的时间。格式：yyyy-MM-dd HH:mm:ss
     */
    public String getReqTm() {
        return reqTm;
    }

    /**
     * 设置播放流请求（实时音视频或远程录像回放）的时间。
     *
     * @param reqTm 播放流请求（实时音视频或远程录像回放）的时间。格式：yyyy-MM-dd HH:mm:ss
     */
    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    /**
     * 取 AppId
     *
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置AppId
     *
     * @param appId AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取通道号
     *
     * @return 通道号
     */
    public int getChan() {
        return chan;
    }

    /**
     * 设置通道号
     *
     * @param chan 通道号
     */
    public void setChan(int chan) {
        this.chan = chan;
    }

    /**
     * 取播放时请求的是否实时音视频
     *
     * @return 播放时请求的是否实时音视频，为 false 表示当时执行的是远程录像回放
     */
    public boolean isLive() {
        return live;
    }

    /**
     * 设置播放时请求的是否实时音视频
     *
     * @param live 播放时请求的是否实时音视频，为 false 表示当时执行的是远程录像回放
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * 取文件的相对路径（无前面的 `/`）
     *
     * @return 文件相对路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件相对路径（无前面的 `/`）
     *
     * @param path 文件路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取文件扩展名
     *
     * @return 文件扩展名
     */
    public String getExt() {
        return ext;
    }

    /**
     * 设置文件扩展名
     *
     * @param ext 文件扩展名
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * 取文件大小
     *
     * @return 文件大小，字节数
     */
    public long getSz() {
        return sz;
    }

    /**
     * 设置文件大小
     *
     * @param sz 文件大小，字节数
     */
    public void setSz(long sz) {
        this.sz = sz;
    }

    /**
     * 取文件的下载地址
     *
     * @return 文件的下载地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件的下载地址
     *
     * @param url 文件的下载地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 取播放时的媒体类型：`av`, `v`, `a`之一
     *
     * @return 播放时的媒体类型
     */
    public String getMediaTyp() {
        return mediaTyp;
    }

    /**
     * 设置播放时的媒体类型
     *
     * @param mediaTyp 播放时的媒体类型，`av`, `v`, `a`之一
     */
    public void setMediaTyp(String mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    /**
     * 取 AppId ，如果未设置时，返回 `StreamingApi.DEFAULT_APP_ID`
     *
     * @return AppId
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 从本对象中复制一个 StoredAv 对象，然后设置返回对象的 `sz` 和 `mediaTyp` 属性
     *
     * @param newSz       新的 `sz` 属性值
     * @param newMediaTyp 新的 `mediaTyp` 属性值
     * @return 复制后的 StoredAv 对象
     */
    public PlayedAvDump copyWithNewSzAndMediaTyp(long newSz, String newMediaTyp) {
        PlayedAvDump r = new PlayedAvDump();
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
        return new StringJoiner(", ", PlayedAvDump.class.getSimpleName() + "[", "]")
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
        return StrmMsgs.STRM_MSG__PlayedAvDump;
    }

    @Override
    public String relativeFileName() {
        if (path.startsWith("/"))
            return path.substring(1);
        else
            return path;
    }
}
