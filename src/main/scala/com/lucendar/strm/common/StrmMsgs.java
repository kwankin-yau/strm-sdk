/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

/**
 * 流媒体消息
 */
public class StrmMsgs {

    /**
     * 实时流控制请求
     */
    public static final int STRM_MSG__LiveStrmCtrlReq = 1;

    /**
     * 回放流控制请求
     */
    public static final int STRM_MSG__ReplayStrmCtrlReq = 2;

    /**
     * 检查流控制请求
     */
    public static final int STRM_MSG__CheckCtrlReq = 3;

    /**
     * 打开流请求
     */
    public static final int STRM_MSG__OpenStrmReq = 4;

    /**
     * 保持流请求
     */
    public static final int STRM_MSG__KeepStrmReq = 5;

    /**
     * 释放流请求
     */
    public static final int STRM_MSG__ReleaseStrmsReq = 6;

    /**
     * 查询服务器状态请求
     */
    public static final int STRM_MSG__QryServerStatusReq = 7;

    /**
     * 检查流请求
     */
    public static final int STRM_MSG__CheckStrmReq = 8;

    /**
     * 关闭流请求
     */
    public static final int STRM_MSG__ClosedStrm = 9;

    /**
     * 查询最近关闭的流请求
     */
    public static final int STRM_MSG__QryRecentClosedStrmReq = 10;

    /**
     * 播放音视频转储请求
     */
    public static final int STRM_MSG__PlayedAvDump = 11;

    /**
     * 查询流活动请求
     */
    public static final int STRM_MSG__QryStrmActivityReq = 12;

    /**
     * 查询流统计请求
     */
    public static final int STRM_MSG__QryStrmStatReq = 13;

    /**
     * 查询流活动分段请求
     */
    public static final int STRM_MSG__QryStrmActSegReq = 14;

    /**
     * 释放流请求2
     */
    public static final int STRM_MSG__ReleaseStrmsReq2 = 15;

}
