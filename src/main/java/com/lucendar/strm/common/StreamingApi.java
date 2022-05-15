/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

import com.lucendar.strm.common.strm.TimedToken;
import com.lucendar.strm.common.strm.UriScheme;
import com.lucendar.strm.common.strm.stat.ChannelStat;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StreamingApi {

    public static final byte PROTO__HTTP_FLV = 0;
    public static final byte PROTO__HLS = 1;
    public static final byte PROTO__RTMP = 2;
    public static final byte PROTO__RAW = 3;

    public static final String CHANNEL_TYPE__LIVE = "live";
    public static final String CHANNEL_TYPE__REPLAY = "replay";

    public static String normalizeSimNo(String simNo) {
        int start = -1;
        for (int i = 0; i < simNo.length(); i++) {
            char c = simNo.charAt(i);
            if (c != '0') {
                start = i;
                break;
            }
        }

        if (start >= 0)
            return simNo.substring(start);
        else
            return simNo;
    }

    public static String encodeStreamName(String simNo, short channelId, boolean live) {
        return normalizeSimNo(simNo) + "_" + channelId + "_" + (live ? "1" : "0");
    }

    /**
     * Check whether an given `reqId` is valid.
     *
     * @param reqId
     * @return
     */
    public static boolean isValidReqId(String reqId) {
        if (reqId == null || reqId.isEmpty())
            return false;

        for (int i = 0; i < reqId.length(); i++) {
            char c = reqId.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c) && c != '-' && c != '_' && c != '.')
                return false;
        }

        return true;
    }

}
