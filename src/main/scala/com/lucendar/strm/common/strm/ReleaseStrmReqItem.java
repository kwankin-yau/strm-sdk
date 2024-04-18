/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class ReleaseStrmReqItem {

    private String reqId;
    private int closeCause;

    public ReleaseStrmReqItem() {
    }

    public ReleaseStrmReqItem(String reqId, int closeCause) {
        this.reqId = reqId;
        this.closeCause = closeCause;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public int getCloseCause() {
        return closeCause;
    }

    public void setCloseCause(int closeCause) {
        this.closeCause = closeCause;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseStrmReqItem.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("closeCause=" + closeCause)
                .toString();
    }
}
