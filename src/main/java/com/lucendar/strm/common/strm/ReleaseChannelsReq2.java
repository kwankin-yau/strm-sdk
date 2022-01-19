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

public class ReleaseChannelsReq2 {

    private List<ReleaseChannelReqItem> reqItems;

    public ReleaseChannelsReq2() {
    }

    public ReleaseChannelsReq2(ReleaseChannelReqItem item) {
        add(item);
    }


    public List<ReleaseChannelReqItem> getReqItems() {
        return reqItems;
    }

    public void setReqItems(List<ReleaseChannelReqItem> reqItems) {
        this.reqItems = reqItems;
    }

    public void add(ReleaseChannelReqItem item) {
        if (this.reqItems == null)
            this.reqItems = new ArrayList<>();

        this.reqItems.add(item);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReleaseChannelsReq2.class.getSimpleName() + "[", "]")
                .add("reqItems=" + reqItems)
                .toString();
    }
}
