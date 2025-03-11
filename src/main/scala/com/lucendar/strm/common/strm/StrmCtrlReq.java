package com.lucendar.strm.common.strm;

/**
 * 流控制请求接口
 */
public interface StrmCtrlReq {

    /**
     * 返回是否为实时流
     * @return 是否为实时流
     */
    boolean isLive();

    /**
     * 取请求ID
     * @return 请求ID
     */
    String getReqId();

    /**
     * 取当前请求是否具有控制权
     * @return 是否具有控制权
     */
    byte getCtrl();
}
