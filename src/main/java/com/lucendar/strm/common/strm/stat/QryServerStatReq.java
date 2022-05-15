package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

public class QryServerStatReq implements StrmMsg {
    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__QryServerStatReq;
    }
}
