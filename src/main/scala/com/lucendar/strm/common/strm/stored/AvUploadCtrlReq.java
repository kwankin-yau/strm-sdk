/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

/**
 * 远程录像上传控制请求
 */
public class AvUploadCtrlReq {

    /**
     * 控制指令：暂停上传（注意，由于存在FTP数据超时，暂停超过一定时间会断开连接，所以暂停不能太久。实际应用中，暂停上传没有太大意义）
     */
    public static final byte CTRL__PAUSE = 0;

    /**
     * 控制指令：恢复上传
     */
    public static final byte CTRL__RESUME = 1;

    /**
     * 控制指令：取消上传
     */
    public static final byte CTRL__CANCEL = 2;


    private String reqId;
    private byte ctrl;

    /**
     * 取远程上传的请求ID
     *
     * @return 远程上传的请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置远程上传的请求ID
     *
     * @param reqId 远程上传的请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取控制指令
     *
     * @return 控制指令，为 CTRL__ 系列常量之一
     */
    public byte getCtrl() {
        return ctrl;
    }

    /**
     * 设置控制指令
     *
     * @param ctrl 控制指令，为 CTRL__ 系列常量之一
     */
    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadCtrlReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("ctrl=" + ctrl)
                .toString();
    }
}
