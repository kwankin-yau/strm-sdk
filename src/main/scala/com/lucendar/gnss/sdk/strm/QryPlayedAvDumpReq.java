package com.lucendar.gnss.sdk.strm;

import java.util.StringJoiner;

/**
 * 查询服务端终端播放转储文件记录请求参数。有两种查询方式：
 * <ul>
 *     <li>按请求ID查询，此时，`reqId` 为必要参数</li>
 *     <li>按时间段查询，此时，`startTime`, `__limit`, `__page` 为必要参数，`endTime`, `simNo` 为可选参数</li>
 * </ul>
 */
public class QryPlayedAvDumpReq {

    private String reqId;
    private String startTime;
    private String endTime;
    private String simNo;
    private Integer __limit;
    private Integer __page;

    /**
     * 取播放的请求ID
     *
     * @return 播放的请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置播放的请求ID
     *
     * @param reqId 播放的请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取查询时间段的开始时间
     *
     * @return 查询时间段的开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置查询时间段的开始时间
     *
     * @param startTime 查询时间段的开始时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取查询时间段的结束时间（不含）
     *
     * @return 查询时间段的结束时间（不含），格式：yyyy-MM-dd HH:mm:ss。不指定时，表示查询到现在。
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置查询时间段的结束时间（不含）
     *
     * @param endTime 查询时间段的结束时间（不含），格式：yyyy-MM-dd HH:mm:ss。不指定时，表示查询到现在。
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
     * 取分页的每页记录数
     *
     * @return 分页的每页记录数
     */
    public Integer get__limit() {
        return __limit;
    }

    /**
     * 设置分页的每页记录数
     *
     * @param __limit 分页的每页记录数
     */
    public void set__limit(Integer __limit) {
        this.__limit = __limit;
    }

    /**
     * 取分页的页号，从1开始
     *
     * @return 分页的页号，从1开始
     */
    public Integer get__page() {
        return __page;
    }

    /**
     * 设置分页的页号，从1开始
     *
     * @param __page 分页的页号，从1开始
     */
    public void set__page(Integer __page) {
        this.__page = __page;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", QryPlayedAvDumpReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("simNo='" + simNo + "'")
                .add("__limit=" + __limit)
                .add("__page=" + __page)
                .toString();
    }
}
