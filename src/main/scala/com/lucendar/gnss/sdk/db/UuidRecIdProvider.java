package com.lucendar.gnss.sdk.db;

import com.lucendar.common.utils.CommonUtils;


/**
 * UUID(记录ID)提供者
 */
public class UuidRecIdProvider implements RecIdProvider {

    @Override
    public String nextId() {
        return CommonUtils.uuidBase64NoPadding();
    }

}
