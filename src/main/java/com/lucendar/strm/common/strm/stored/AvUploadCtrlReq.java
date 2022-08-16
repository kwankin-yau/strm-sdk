/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import java.util.StringJoiner;

public class AvUploadCtrlReq {

    public static final byte CTRL__PAUSE = 0;
    public static final byte CTRL__RESUME = 1;
    public static final byte CTRL__CANCEL = 2;


    private String reqId;
    private byte ctrl;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public byte getCtrl() {
        return ctrl;
    }

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
