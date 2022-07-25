/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ReleaseStrmsReq2 {

    private List<ReleaseStrmReqItem> reqItems;

    public ReleaseStrmsReq2() {
    }

    public ReleaseStrmsReq2(ReleaseStrmReqItem item) {
        add(item);
    }


    public List<ReleaseStrmReqItem> getReqItems() {
        return reqItems;
    }

    public void setReqItems(List<ReleaseStrmReqItem> reqItems) {
        this.reqItems = reqItems;
    }

    public void add(ReleaseStrmReqItem item) {
        if (this.reqItems == null)
            this.reqItems = new ArrayList<>();

        this.reqItems.add(item);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseStrmsReq2.class.getSimpleName() + "[", "]")
                .add("reqItems=" + reqItems)
                .toString();
    }
}
