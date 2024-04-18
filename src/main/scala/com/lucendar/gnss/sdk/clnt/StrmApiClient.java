/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.clnt;

import com.google.gson.Gson;
import com.lucendar.common.types.KV;
import com.lucendar.common.types.rest.Pagination;
import com.lucendar.gnss.sdk.almatt.AlmAtt;
import com.lucendar.gnss.sdk.almatt.FetchAlmAttReq;
import info.gratour.common.types.rest.Reply;
import okhttp3.OkHttpClient;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 媒体服务API客户端
 */
public class StrmApiClient extends SimpleApiClient {

    public StrmApiClient(
            @NonNull Gson gson,
            @NonNull String endPointUrl,
            @NonNull ApiAuthentication authentication,
            @NonNull OkHttpClient httpClient) {
        super(gson, endPointUrl, authentication, httpClient);
    }

    /**
     * ADAS 报警附件API
     */
    public class AdasAlmAttApi {

        /**
         * 指示媒体服务提取终端的 ADAS 报警附件
         *
         * @param req 提取 ADAS 报警附件请求
         * @return 常规响应
         */
        public Reply<Void> fetch(@NonNull FetchAlmAttReq req) {
            return post("/alm/att/fetch", Reply.RAW_REPLY_TYPE, null, req);
        }

        /**
         * 按 ID 查询 ADAS 报警附件
         * @param id 终端ADAS报警ID（16字节或40字节(2019版)），HEX编码
         * @param simNo 终端识别号
         * @return 附件信息列表
         */
        public Reply<AlmAtt> qryAlmAttById(@NonNull String id, @NonNull String simNo) {
            return get("/alm/att", AlmAtt.REPLY_TYPE, KV.of("id", id), KV.of("simNo", simNo));
        }

        /**
         * 按时间范围查询 ADAS 报警附件
         * @param simNo 终端识别号
         * @param startTime 报警时间的开始时间，格式：`yyyy-MM-dd HH:mm:ss`
         * @param endTime 报警时间的结束时间，格式：`yyyy-MM-dd HH:mm:ss`。查询结果不包含结束时刻，即小于结束时刻。
         *                不指定时，表示到服务执行查询的时间。时间跨度不能超过7天。
         * @return 附件信息列表
         */
        public Reply<AlmAtt> qryAlmAttByTimeRange(
                @Nullable String simNo,
                @NonNull String startTime,
                @Nullable String endTime,
                @Nullable Pagination pagination) {
            KV.KVList list = new KV.KVList();
            list.addNonNull("simNo", simNo);
            list.add("startTime", startTime);
            list.addNonNull("endTime", endTime);
            if (pagination != null) {
                list.add("__limit", pagination.limit);
                list.add("__page", pagination.page);
            }

            return get("/alm/att", AlmAtt.REPLY_TYPE, list.toArray());
        }
    }

    /**
     * ADAS 报警附件API
     */
    public final AdasAlmAttApi adasAlmAttApi = new AdasAlmAttApi();
}
