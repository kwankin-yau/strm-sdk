/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

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

public class StreamingApi {

    public static final byte PROTO__HTTP_FLV = 0;
    public static final byte PROTO__RTMP = 1;
    public static final byte PROTO__HLS = 2;
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

    public static class TimedToken {

        public static final String TIMED_TOKEN_TYP__SUPERVISOR = "supervisor";
        public static final String TIMED_TOKEN_TYP__FOREIGN = "foreign";
        public static final String TIMED_TOKEN_TYP__CLIENT = "client";

        private String typ;
        private String token;
        private long expiredAt;

        public TimedToken() {
        }

        public TimedToken(String typ, String token, long expiredAt) {
            this.typ = typ;
            this.token = token;
            this.expiredAt = expiredAt;
        }

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getExpiredAt() {
            return expiredAt;
        }

        public void setExpiredAt(long expiredAt) {
            this.expiredAt = expiredAt;
        }

        @Override
        public String toString() {
            return "TimedToken{" +
                    "typ='" + typ + '\'' +
                    ", token='" + token + '\'' +
                    ", expiredAt=" + expiredAt +
                    '}';
        }
    }

    public static class UpdateTimedTokenReq {
        private List<TimedToken> tokens;

        public UpdateTimedTokenReq() {
        }

        public UpdateTimedTokenReq(List<TimedToken> tokens) {
            this.tokens = tokens;
        }

        public List<TimedToken> getTokens() {
            return tokens;
        }

        public void setTokens(List<TimedToken> tokens) {
            this.tokens = tokens;
        }

        public void add(TimedToken token) {
            if (this.tokens == null)
                this.tokens = new ArrayList<>();

            this.tokens.add(token);
        }

        @Override
        public String toString() {
            return "UpdateTimedTokenReq{" +
                    "tokens=" + tokens +
                    '}';
        }
    }

    public static class ReqStat {
        private String reqId;
        private String userId;
        private long reqTm;
        private int proto;
        private int closeCause;
        private long lastKeep;

        public ReqStat() {
        }

        public ReqStat(String reqId, String userId, long reqTm, int proto, int closeCause, long lastKeep) {
            this.reqId = reqId;
            this.userId = userId;
            this.reqTm = reqTm;
            this.proto = proto;
            this.closeCause = closeCause;
            this.lastKeep = lastKeep;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public long getReqTm() {
            return reqTm;
        }

        public void setReqTm(long reqTm) {
            this.reqTm = reqTm;
        }

        public int getProto() {
            return proto;
        }

        public void setProto(int proto) {
            this.proto = proto;
        }

        public int getCloseCause() {
            return closeCause;
        }

        public void setCloseCause(int closeCause) {
            this.closeCause = closeCause;
        }

        public long getLastKeep() {
            return lastKeep;
        }

        public void setLastKeep(long lastKeep) {
            this.lastKeep = lastKeep;
        }

        @Override
        public String toString() {
            return "ReqStat{" +
                    "reqId='" + reqId + '\'' +
                    ", userId='" + userId + '\'' +
                    ", reqTm=" + reqTm +
                    ", proto=" + proto +
                    ", closeCause=" + closeCause +
                    ", lastKeep=" + lastKeep +
                    '}';
        }
    }

    public static class ChannelStat {
        private String simNo;
        private short chanId;
        private boolean live;
        private Integer liveDataTyp;
        private byte codeStrm;
        private long createTm;
        private Long srcDetectTm;
        private boolean strmReady;
        private Long strmReadyTm;
        private boolean strmClosed;
        private long recvFromTerm;
        private long recvFromTermByteRate;
        private long sendToClnt;
        private String audioFmt;
        private String videoFmt;
        private String videoRes;
        private String mediaTyp;

        private ReqStat[] requests;

        public ChannelStat() {
        }

        public ChannelStat(String simNo,
                           short chanId,
                           boolean live,
                           Integer liveDataTyp,
                           byte codeStrm,
                           long createTm,
                           Long srcDetectTm,
                           boolean strmReady,
                           Long strmReadyTm,
                           boolean strmClosed,
                           long recvFromTerm,
                           long recvFromTermByteRate,
                           long sendToClnt,
                           String audioFmt,
                           String videoFmt,
                           String videoRes,
                           String mediaTyp,
                           ReqStat[] requests
        ) {
            this.simNo = simNo;
            this.chanId = chanId;
            this.live = live;
            this.liveDataTyp = liveDataTyp;
            this.codeStrm = codeStrm;
            this.createTm = createTm;
            this.srcDetectTm = srcDetectTm;
            this.strmReady = strmReady;
            this.strmReadyTm = strmReadyTm;
            this.strmClosed = strmClosed;
            this.recvFromTerm = recvFromTerm;
            this.recvFromTermByteRate = recvFromTermByteRate;
            this.sendToClnt = sendToClnt;
            this.audioFmt = audioFmt;
            this.videoFmt = videoFmt;
            this.videoRes = videoRes;
            this.mediaTyp = mediaTyp;
            this.requests = requests;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChanId() {
            return chanId;
        }

        public void setChanId(short chanId) {
            this.chanId = chanId;
        }

        public boolean isLive() {
            return live;
        }

        public void setLive(boolean live) {
            this.live = live;
        }

        public Integer getLiveDataTyp() {
            return liveDataTyp;
        }

        public void setLiveDataTyp(Integer liveDataTyp) {
            this.liveDataTyp = liveDataTyp;
        }

        public byte getCodeStrm() {
            return codeStrm;
        }

        public void setCodeStrm(byte codeStrm) {
            this.codeStrm = codeStrm;
        }

        public long getCreateTm() {
            return createTm;
        }

        public void setCreateTm(long createTm) {
            this.createTm = createTm;
        }

        public Long getSrcDetectTm() {
            return srcDetectTm;
        }

        public void setSrcDetectTm(Long srcDetectTm) {
            this.srcDetectTm = srcDetectTm;
        }

        public boolean isStrmReady() {
            return strmReady;
        }

        public void setStrmReady(boolean strmReady) {
            this.strmReady = strmReady;
        }

        public Long getStrmReadyTm() {
            return strmReadyTm;
        }

        public void setStrmReadyTm(Long strmReadyTm) {
            this.strmReadyTm = strmReadyTm;
        }

        public boolean isStrmClosed() {
            return strmClosed;
        }

        public void setStrmClosed(boolean strmClosed) {
            this.strmClosed = strmClosed;
        }

        public long getRecvFromTerm() {
            return recvFromTerm;
        }

        public void setRecvFromTerm(long recvFromTerm) {
            this.recvFromTerm = recvFromTerm;
        }

        public long getRecvFromTermByteRate() {
            return recvFromTermByteRate;
        }

        public void setRecvFromTermByteRate(long recvFromTermByteRate) {
            this.recvFromTermByteRate = recvFromTermByteRate;
        }

        public long getSendToClnt() {
            return sendToClnt;
        }

        public void setSendToClnt(long sendToClnt) {
            this.sendToClnt = sendToClnt;
        }

        public String getAudioFmt() {
            return audioFmt;
        }

        public void setAudioFmt(String audioFmt) {
            this.audioFmt = audioFmt;
        }

        public String getVideoFmt() {
            return videoFmt;
        }

        public void setVideoFmt(String videoFmt) {
            this.videoFmt = videoFmt;
        }

        public String getVideoRes() {
            return videoRes;
        }

        public void setVideoRes(String videoRes) {
            this.videoRes = videoRes;
        }

        public String getMediaTyp() {
            return mediaTyp;
        }

        public void setMediaTyp(String mediaTyp) {
            this.mediaTyp = mediaTyp;
        }

        public ReqStat[] getRequests() {
            return requests;
        }

        public void setRequests(ReqStat[] requests) {
            this.requests = requests;
        }

        @Override
        public String toString() {
            return "ChannelStat{" +
                    "simNo='" + simNo + '\'' +
                    ", chanId=" + chanId +
                    ", live=" + live +
                    ", liveDataTyp=" + liveDataTyp +
                    ", codeStrm=" + codeStrm +
                    ", createTm=" + createTm +
                    ", srcDetectTm=" + srcDetectTm +
                    ", strmReady=" + strmReady +
                    ", strmReadyTm=" + strmReadyTm +
                    ", strmClosed=" + strmClosed +
                    ", recvFromTerm=" + recvFromTerm +
                    ", recvFromTermByteRate=" + recvFromTermByteRate +
                    ", sendToClnt=" + sendToClnt +
                    ", audioFmt='" + audioFmt + '\'' +
                    ", videoFmt='" + videoFmt + '\'' +
                    ", videoRes='" + videoRes + '\'' +
                    ", mediaTyp='" + mediaTyp + '\'' +
                    ", requests=" + Arrays.toString(requests) +
                    '}';
        }
    }

    public static class StrmChannelLogEntry {

        public static final String EVT__SUBSCRIBE_CHANNEL = "subscribe";
        public static final String EVT__IDENTIFIED = "identified";
        public static final String EVT__STRM_READY = "strm_ready";
        //        public static final String EVT__MEDIA_TYPE_DETECTED = "media_type_detected";
        public static final String EVT__REQUEST_CLOSED = "request_closed";

        private long time;
        private String simNo;
        private short chanId;
        private boolean live;
        private String reqId;
        private String evtTyp;
        private String evtData;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChanId() {
            return chanId;
        }

        public void setChanId(short chanId) {
            this.chanId = chanId;
        }

        public boolean isLive() {
            return live;
        }

        public void setLive(boolean live) {
            this.live = live;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getEvtTyp() {
            return evtTyp;
        }

        public void setEvtTyp(String evtTyp) {
            this.evtTyp = evtTyp;
        }

        public String getEvtData() {
            return evtData;
        }

        public void setEvtData(String evtData) {
            this.evtData = evtData;
        }

        @Override
        public String toString() {
            return "StrmChannelLogEntry{" +
                    "time=" + time +
                    ", simNo='" + simNo + '\'' +
                    ", chanId=" + chanId +
                    ", live=" + live +
                    ", reqId='" + reqId + '\'' +
                    ", evtTyp='" + evtTyp + '\'' +
                    ", evtData='" + evtData + '\'' +
                    '}';
        }
    }

    public static class StrmUserInfo {

        public static final int USER_GRADE__GOV = 80;
        public static final int USER_GRADE__GOV_FOREIGN = 70;
        public static final int USER_GRADE__ADMIN = 50;
        public static final int USER_GRADE__NORMAL = 30;

        private String userId;
        private int userGrade;

        public StrmUserInfo() {
        }

        public StrmUserInfo(String userId, int userGrade) {
            this.userId = userId;
            this.userGrade = userGrade;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String userIdDef() {
            if (userId == null)
                return "";
            else
                return userId;
        }

        public int getUserGrade() {
            return userGrade;
        }

        public void setUserGrade(int userGrade) {
            this.userGrade = userGrade;
        }

        public boolean isGov() {
            return userGrade == USER_GRADE__GOV;
        }

        @Override
        public String toString() {
            return "StrmUserInfo{" +
                    "userId='" + userId + '\'' +
                    ", userGrade=" + userGrade +
                    '}';
        }
    }

    public static class SubscribeChannelReq {

        public static final int DATA_TYPE__AV = 0;
        public static final int DATA_TYPE__VIDEO = 1;
        public static final int DATA_TYPE__TALK = 2;
        public static final int DATA_TYPE__LISTEN = 3;
        public static final int DATA_TYPE__BROADCAST = 4;

        public static final byte LIVE_CODE_STREAM__PRIMARY = 0;
        public static final byte LIVE_CODE_STREAM__SUB = 1;

        public static final byte REPLAY_CODE_STREAM__ANY = 0;
        public static final byte REPLAY_CODE_STREAM__PRIMARY = 1;
        public static final byte REPLAY_CODE_STREAM__SUB = 2;

        public static final byte REPLAY_STORAGE_TYPE__ANY = 0;
        public static final byte REPLAY_STORAGE_TYPE__PRIMARY = 1;
        public static final byte REPLAY_STORAGE_TYPE__BACKUP = 2;

        public static final int MIN_INTERVAL__FLV = 10;
        public static final int DEFAULT_INTERVAL__FLV = 20;
        public static final int MAX_INTERVAL__FLV = 30 * 60;

        public static final int MIN_INTERVAL__HLS = 15;
        public static final int DEFAULT_INTERVAL__HLS = 20;
        public static final int MAX_INTERVAL__HLS = 30 * 60;

        public static boolean dataTypeContainsServerAudio(int dataType) {
            switch (dataType) {
                case DATA_TYPE__TALK:
                case DATA_TYPE__BROADCAST:
                    return true;

                default:
                    return false;
            }
        }

        private String reqId;
        private String callback;
        private StrmUserInfo user;
        private String typ;
        private String simNo;
        private short channelId;
        private byte proto;
        private byte connIdx;
        private String clientData;
        private int dataTyp;
        private byte codeStrm;
        private boolean recordOnServer;
        private Integer keepInterval;

        public SubscribeChannelReq() {
        }

        public SubscribeChannelReq(
                String reqId, String callback, StrmUserInfo user, String typ, String simNo, short channelId,
                byte proto, byte connIdx, String clientData, int dataTyp, byte codeStrm, boolean recordOnServer,
                Integer keepInterval) {
            this.reqId = reqId;
            this.callback = callback;
            this.user = user;
            this.typ = typ;
            this.simNo = simNo;
            this.channelId = channelId;
            this.proto = proto;
            this.connIdx = connIdx;
            this.clientData = clientData;
            this.dataTyp = dataTyp;
            this.codeStrm = codeStrm;
            this.recordOnServer = recordOnServer;
            this.keepInterval = keepInterval;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getCallback() {
            return callback;
        }

        public void setCallback(String callback) {
            this.callback = callback;
        }

        public StrmUserInfo getUser() {
            return user;
        }

        public void setUser(StrmUserInfo user) {
            this.user = user;
        }

        /**
         * `live` or `replay`
         *
         * @return
         */
        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChannelId() {
            return channelId;
        }

        public void setChannelId(short channelId) {
            this.channelId = channelId;
        }

        public byte getProto() {
            return proto;
        }

        public void setProto(byte proto) {
            this.proto = proto;
        }

        public byte getConnIdx() {
            return connIdx;
        }

        public void setConnIdx(byte connIdx) {
            this.connIdx = connIdx;
        }

        public String getClientData() {
            return clientData;
        }

        public void setClientData(String clientData) {
            this.clientData = clientData;
        }

        public boolean isLive() {
            return CHANNEL_TYPE__LIVE.equals(typ);
        }
        public boolean isReplay() { return CHANNEL_TYPE__REPLAY.equals(typ); }

        public String streamName() {
            return encodeStreamName(simNo, channelId, isLive());
        }

        /**
         * Requested data type of the channel. One of `DATA_TYPE__XXXX`.
         * Only valid for `live` channel.
         *
         * @return
         */
        public int getDataTyp() {
            return dataTyp;
        }

        public void setDataTyp(int dataTyp) {
            this.dataTyp = dataTyp;
        }

        public byte getCodeStrm() {
            return codeStrm;
        }

        public void setCodeStrm(byte codeStrm) {
            this.codeStrm = codeStrm;
        }

        public boolean isRecordOnServer() {
            return recordOnServer;
        }

        public void setRecordOnServer(boolean recordOnServer) {
            this.recordOnServer = recordOnServer;
        }

        public Integer getKeepInterval() {
            return keepInterval;
        }

        public void setKeepInterval(Integer keepInterval) {
            this.keepInterval = keepInterval;
        }

        /**
         * Validate the request parameters.
         *
         * @return error message, null for OK.
         */
        public String validate() {
            if (reqId != null) {
                if (!isValidReqId(reqId))
                    return "reqId";
            }

//            if (callback == null)
//                return "callback";

            if (user == null)
                return "user";



            if (typ == null)
                return "typ";

            boolean live = isLive();
            if (!live && !isReplay())
                return "typ";

            if (simNo == null || simNo.isEmpty() || simNo.contains(":"))
                return "simNo";

            switch (dataTyp) {
                case DATA_TYPE__AV:
                case DATA_TYPE__VIDEO:
                case DATA_TYPE__TALK:
                case DATA_TYPE__LISTEN:
                case DATA_TYPE__BROADCAST:
                    break;

                default:
                    return "dataTyp";
            }

            if (live) {
                switch (codeStrm) {
                    case LIVE_CODE_STREAM__PRIMARY:
                    case LIVE_CODE_STREAM__SUB:
                        break;

                    default:
                        return "codeStrm";
                }
            } else {
                switch (codeStrm) {
                    case REPLAY_CODE_STREAM__ANY:
                    case REPLAY_CODE_STREAM__PRIMARY:
                    case REPLAY_CODE_STREAM__SUB:
                        break;

                    default:
                        return "codeStrm";
                }
            }

            switch (proto) {
                case PROTO__HLS:
                    if (keepInterval != null) {
                        if (keepInterval < MIN_INTERVAL__HLS || keepInterval > MAX_INTERVAL__HLS)
                            return "keepInterval";
                    }
                    break;

                case PROTO__HTTP_FLV:
                    if (keepInterval != null) {
                        if (keepInterval < MIN_INTERVAL__FLV || keepInterval > MAX_INTERVAL__FLV)
                            return "keepInterval";
                    }
                    break;

                case PROTO__RTMP:
                    break;

                default:
                    return "proto";
            }


            return null;
        }

        public static int defaultKeepInterval(int proto) {
            switch (proto) {
                case PROTO__HTTP_FLV:
                    return DEFAULT_INTERVAL__FLV;

                case PROTO__HLS:
                    return DEFAULT_INTERVAL__HLS;

                case PROTO__RTMP:
                    return 0;

                default:
                    throw new RuntimeException("Invalid parameter: `proto`.");
            }
        }

        @Override
        public String toString() {
            return "SubscribeChannelReq{" +
                    "reqId='" + reqId + '\'' +
                    ", callback='" + callback + '\'' +
                    ", user=" + user +
                    ", typ='" + typ + '\'' +
                    ", simNo='" + simNo + '\'' +
                    ", channelId=" + channelId +
                    ", proto=" + proto +
                    ", connIdx=" + connIdx +
                    ", clientData='" + clientData + '\'' +
                    ", dataTyp=" + dataTyp +
                    ", codeStrm=" + codeStrm +
                    ", recordOnServer=" + recordOnServer +
                    ", keepInterval=" + keepInterval +
                    '}';
        }
    }

    public static class SubscribeChannelResult {

        private String reqId;
        private boolean ctrl;
        private boolean strmReady;
        private String mediaTyp;
        private String playUrl;
        private String wsUrl;
        private int keepIntervalSeconds;
        private String host;
        private int port;
        private boolean tcp;
        private int port2019;
        private boolean tcp2019;

        public SubscribeChannelResult() {
        }

        public SubscribeChannelResult(String reqId, boolean ctrl, boolean strmReady, String mediaTyp, String playUrl, String wsUrl,
                                      int keepIntervalSeconds, String host, int port, boolean tcp,
                                      int port2019, boolean tcp2019) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.strmReady = strmReady;
            this.mediaTyp = mediaTyp;
            this.playUrl = playUrl;
            this.wsUrl = wsUrl;
            this.keepIntervalSeconds = keepIntervalSeconds;
            this.host = host;
            this.port = port;
            this.tcp = tcp;
            this.port2019 = port2019;
            this.tcp2019 = tcp2019;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public boolean isCtrl() {
            return ctrl;
        }

        public void setCtrl(boolean ctrl) {
            this.ctrl = ctrl;
        }

        public boolean isStrmReady() {
            return strmReady;
        }

        public void setStrmReady(boolean strmReady) {
            this.strmReady = strmReady;
        }

        public String getMediaTyp() {
            return mediaTyp;
        }

        public void setMediaTyp(String mediaTyp) {
            this.mediaTyp = mediaTyp;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public String getWsUrl() {
            return wsUrl;
        }

        public void setWsUrl(String wsUrl) {
            this.wsUrl = wsUrl;
        }

        public int getKeepIntervalSeconds() {
            return keepIntervalSeconds;
        }

        public void setKeepIntervalSeconds(int keepIntervalSeconds) {
            this.keepIntervalSeconds = keepIntervalSeconds;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public boolean isTcp() {
            return tcp;
        }

        public void setTcp(boolean tcp) {
            this.tcp = tcp;
        }

        public int getPort2019() {
            return port2019;
        }

        public void setPort2019(int port2019) {
            this.port2019 = port2019;
        }

        public boolean isTcp2019() {
            return tcp2019;
        }

        public void setTcp2019(boolean tcp2019) {
            this.tcp2019 = tcp2019;
        }

        @Override
        public String toString() {
            return "SubscribeChannelResult{" +
                    "reqId='" + reqId + '\'' +
                    ", ctrl=" + ctrl +
                    ", strmReady=" + strmReady +
                    ", mediaTyp='" + mediaTyp + '\'' +
                    ", playUrl='" + playUrl + '\'' +
                    ", wsUrl='" + wsUrl + '\'' +
                    ", keepIntervalSeconds=" + keepIntervalSeconds +
                    ", host='" + host + '\'' +
                    ", port=" + port +
                    ", tcp=" + tcp +
                    ", port2019=" + port2019 +
                    ", tcp2019=" + tcp2019 +
                    '}';
        }
    }

    public static class ServerHint {

        public static final String STRM_SERVER_ID__TEST = "test";

        private String strmServerId;

        public String getStrmServerId() {
            return strmServerId;
        }

        public void setStrmServerId(String strmServerId) {
            this.strmServerId = strmServerId;
        }

        @Override
        public String toString() {
            return "StrmServerHint{" +
                    "strmServerId='" + strmServerId + '\'' +
                    '}';
        }
    }

    public static class KeepChannelReq {
        private String[] reqIds;
        private ServerHint strmServerHint;

        public KeepChannelReq() {
        }

        public KeepChannelReq(String[] reqIds, ServerHint strmServerHint) {
            this.reqIds = reqIds;
            this.strmServerHint = strmServerHint;
        }

        public String[] getReqIds() {
            return reqIds;
        }

        public void setReqIds(String[] reqIds) {
            this.reqIds = reqIds;
        }

        public ServerHint getStrmServerHint() {
            return strmServerHint;
        }

        public void setStrmServerHint(ServerHint strmServerHint) {
            this.strmServerHint = strmServerHint;
        }

        @Override
        public String toString() {
            if (strmServerHint != null)
            return "KeepChannelReq{" +
                    "reqIds=" + Arrays.toString(reqIds) +
                    ", strmServerHint=" + strmServerHint +
                    '}';
            else
                return "KeepChannelReq{" +
                        "reqIds=" + Arrays.toString(reqIds) +
                        '}';

        }
    }

    public static class KeepChannelItemResult {
        private String reqId;
        private boolean keep;

        public KeepChannelItemResult() {
        }

        public KeepChannelItemResult(String reqId, boolean keep) {
            this.reqId = reqId;
            this.keep = keep;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public boolean isKeep() {
            return keep;
        }

        public void setKeep(boolean keep) {
            this.keep = keep;
        }

        @Override
        public String toString() {
            return "KeepChannelItemResult{" +
                    "reqId='" + reqId + '\'' +
                    ", keep=" + keep +
                    '}';
        }
    }

    public static class CheckChannelReq {
        private String reqId;

        public CheckChannelReq() {
        }

        public CheckChannelReq(String reqId) {
            this.reqId = reqId;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        @Override
        public String toString() {
            return "CheckChannelReq{" +
                    "reqId='" + reqId + '\'' +
                    '}';
        }
    }

    public static class CheckCtrlReq {
        private String reqId;

        public CheckCtrlReq() {
        }

        public CheckCtrlReq(String reqId) {
            this.reqId = reqId;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        @Override
        public String toString() {
            return "CheckCtrlReq{" +
                    "reqId='" + reqId + '\'' +
                    '}';
        }
    }

    public static class CheckCtrlResult {
        private String reqId;
        private boolean ctrl;
        private String simNo;
        private short channelId;
        private boolean live;

        public CheckCtrlResult() {
        }

        public CheckCtrlResult(String reqId, boolean ctrl, String simNo, short channelId, boolean live) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.simNo = simNo;
            this.channelId = channelId;
            this.live = live;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public boolean isCtrl() {
            return ctrl;
        }

        public void setCtrl(boolean ctrl) {
            this.ctrl = ctrl;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChannelId() {
            return channelId;
        }

        public void setChannelId(short channelId) {
            this.channelId = channelId;
        }

        public boolean isLive() {
            return live;
        }

        public void setLive(boolean live) {
            this.live = live;
        }

        @Override
        public String toString() {
            return "CheckCtrlResult{" +
                    "reqId='" + reqId + '\'' +
                    ", ctrl=" + ctrl +
                    ", simNo='" + simNo + '\'' +
                    ", channelId=" + channelId +
                    ", live=" + live +
                    '}';
        }
    }

    public static class LiveStrmCtrlReq {

        public static final byte CTRL__CLOSE = 0;
        public static final byte CTRL__SWITCH_CODE_STREAM = 1;
        public static final byte CTRL__PAUSE = 2;
        public static final byte CTRL__RESUME = 3;
        public static final byte CTRL__CLOSE_TALK = 4;

        public static final byte CLOSE_ACTION__CLOSE_FULLY = 0;
        public static final byte CLOSE_ACTION__MUTE = 1;
        public static final byte CLOSE_ACTION__CLOSE_VIDEO = 2;

        public static final byte CODE_STREAM__PRIMARY = 0;
        public static final byte CODE_STREAM__SUB = 1;

        private String reqId;
        private byte ctrl;
        private Byte closeAction;
        private Byte codeStream;
        private ServerHint strmServerHint;
        private String closeReason;

        public LiveStrmCtrlReq() {
        }

        public LiveStrmCtrlReq(String reqId, byte ctrl, Byte closeAction, Byte codeStream, String closeReason, ServerHint strmServerHint) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.closeAction = closeAction;
            this.codeStream = codeStream;
            this.strmServerHint = strmServerHint;
            this.closeReason = closeReason;
        }

        public LiveStrmCtrlReq(String reqId, byte ctrl, Byte closeAction, Byte codeStream, String closeReason) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.closeAction = closeAction;
            this.codeStream = codeStream;
            this.closeReason = closeReason;
        }

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

        public Byte getCloseAction() {
            return closeAction;
        }

        public void setCloseAction(Byte closeAction) {
            this.closeAction = closeAction;
        }

        public byte closeActionDef() {
            if (closeAction == null)
                return 0;
            else
                return closeAction;
        }

        public Byte getCodeStream() {
            return codeStream;
        }

        public void setCodeStream(Byte codeStream) {
            this.codeStream = codeStream;
        }

        public byte codeStreamDef() {
            if (codeStream == null)
                return 0;
            else
                return codeStream;
        }

        public ServerHint getStrmServerHint() {
            return strmServerHint;
        }

        public void setStrmServerHint(ServerHint strmServerHint) {
            this.strmServerHint = strmServerHint;
        }

        public String getCloseReason() {
            return closeReason;
        }

        public void setCloseReason(String closeReason) {
            this.closeReason = closeReason;
        }

        @Override
        public String toString() {
            return "LiveStrmCtrlReq{" +
                    "reqId='" + reqId + '\'' +
                    ", ctrl=" + ctrl +
                    ", closeAction=" + closeAction +
                    ", codeStream=" + codeStream +
                    ", strmServerHint=" + strmServerHint +
                    ", closeReason='" + closeReason + '\'' +
                    '}';
        }

    }

    public static class ReleaseChannelsReq {
        private String[] reqIds;

        public ReleaseChannelsReq() {
        }

        public ReleaseChannelsReq(String[] reqIds) {
            this.reqIds = reqIds;
        }

        public String[] getReqIds() {
            return reqIds;
        }

        public void setReqIds(String[] reqIds) {
            this.reqIds = reqIds;
        }

        @Override
        public String toString() {
            return "ReleaseChannelsReq{" +
                    "reqIds=" + Arrays.toString(reqIds) +
                    '}';
        }
    }

    public static class ReplayStrmCtrlReq {

        public static final byte CTRL__PLAY = 0;
        public static final byte CTRL__PAUSE = 1;
        public static final byte CTRL__STOP = 2;
        public static final byte CTRL__FAST_FORWARD = 3;
        public static final byte CTRL__KEY_FRAME_BACKWARD = 4;
        public static final byte CTRL__SEEK = 5;
        public static final byte CTRL__KEY_FRAME_PLAY = 6;

        public static final byte SPEED_FACTOR__IGNORED = 0;
        public static final byte SPEED_FACTOR__1x = 1;
        public static final byte SPEED_FACTOR__2x = 2;
        public static final byte SPEED_FACTOR__4x = 3;
        public static final byte SPEED_FACTOR__8x = 4;
        public static final byte SPEED_FACTOR__16x = 5;


        private String reqId;
        private byte ctrl;
        private Byte factor;
        private long time;
        private ServerHint strmServerHint;

        public ReplayStrmCtrlReq() {
        }

        public ReplayStrmCtrlReq(String reqId, byte ctrl, Byte factor, long time, ServerHint strmServerHint) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.factor = factor;
            this.time = time;
            this.strmServerHint = strmServerHint;
        }

        public ReplayStrmCtrlReq(String reqId, byte ctrl, Byte factor, long time) {
            this.reqId = reqId;
            this.ctrl = ctrl;
            this.factor = factor;
            this.time = time;
        }

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

        public Byte getFactor() {
            return factor;
        }

        public void setFactor(Byte factor) {
            this.factor = factor;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public ServerHint getStrmServerHint() {
            return strmServerHint;
        }

        public void setStrmServerHint(ServerHint strmServerHint) {
            this.strmServerHint = strmServerHint;
        }

        @Override
        public String toString() {
            return "VodStrmCtrlReq{" +
                    "reqId='" + reqId + '\'' +
                    ", ctrl=" + ctrl +
                    ", factor=" + factor +
                    ", time=" + time +
                    ", strmServerHint=" + strmServerHint +
                    '}';
        }
    }

    public static class StrmCtrlResult {
        private String reqId;
        private String simNo;
        private short channelId;
        private boolean live;
        private boolean ctrl;

        public StrmCtrlResult() {
        }

        public StrmCtrlResult(String reqId, String simNo, short channelId, boolean live, boolean ctrl) {
            this.reqId = reqId;
            this.simNo = simNo;
            this.channelId = channelId;
            this.live = live;
            this.ctrl = ctrl;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChannelId() {
            return channelId;
        }

        public void setChannelId(short channelId) {
            this.channelId = channelId;
        }

        public boolean isLive() {
            return live;
        }

        public void setLive(boolean live) {
            this.live = live;
        }

        public boolean isCtrl() {
            return ctrl;
        }

        public void setCtrl(boolean ctrl) {
            this.ctrl = ctrl;
        }

        @Override
        public String toString() {
            return "StrmCtrlResult{" +
                    "reqId='" + reqId + '\'' +
                    ", simNo='" + simNo + '\'' +
                    ", channelId=" + channelId +
                    ", live=" + live +
                    ", ctrl=" + ctrl +
                    '}';
        }
    }

    public static class StrmStatSampling {
        private long min;
        private long max;
        private double mean;
        private double p50;
        private double p75;
        private double p95;

        public StrmStatSampling() {
        }

        public StrmStatSampling(long min, long max, double mean, double p50, double p75, double p95) {
            this.min = min;
            this.max = max;
            this.mean = mean;
            this.p50 = p50;
            this.p75 = p75;
            this.p95 = p95;
        }

        public long getMin() {
            return min;
        }

        public void setMin(long min) {
            this.min = min;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public double getMean() {
            return mean;
        }

        public void setMean(double mean) {
            this.mean = mean;
        }

        public double getP50() {
            return p50;
        }

        public void setP50(double p50) {
            this.p50 = p50;
        }

        public double getP75() {
            return p75;
        }

        public void setP75(double p75) {
            this.p75 = p75;
        }

        public double getP95() {
            return p95;
        }

        public void setP95(double p95) {
            this.p95 = p95;
        }

        @Override
        public String toString() {
            return "StrmStatSampling{" +
                    "min=" + min +
                    ", max=" + max +
                    ", mean=" + mean +
                    ", p50=" + p50 +
                    ", p75=" + p75 +
                    ", p95=" + p95 +
                    '}';
        }
    }

    public static class StrmServerStat {
        private String version;
        private long startupTime;
        private Double systemLoadAverage; // null for not available
        private Double procCpuLoad; // null for not available
        private Double sysCpuLoad; // null for not available
        private MemoryUsage heapMemoryUsage;
        private MemoryUsage nonHeapMemoryUsage;
        private int threadCount;
        private int deadLockThreads;

//        private StrmStatSampling avProcessDelay;
        private StrmStatSampling audioProcessDelay;
        private StrmStatSampling videoProcessDelay;
        private StrmStatSampling flvAvProcessDelay;

        private static Double[] cpuLoads(MBeanServer server) {
            try {
                ObjectName n = ObjectName.getInstance("java.lang:type=OperatingSystem");
                AttributeList list = server.getAttributes(n, new String[]{"ProcessCpuLoad", "SystemCpuLoad"});
                Double[] r = new Double[2];
                for (int i = 0; i < list.size(); i++) {
                    Attribute att = (Attribute) list.get(i);
                    switch (att.getName()) {
                        case "ProcessCpuLoad":
                            double v = (Double) att.getValue();
                            if (v >= 0)
                                r[0] = Math.round(v * 1000) / 10d;
                            break;

                        case "SystemCpuLoad":
                            v = (Double) att.getValue();
                            if (v >= 0)
                                r[1] = Math.round(v * 1000) / 10d;
                            break;
                    }
                }

                return r;
            } catch (MalformedObjectNameException | ReflectionException | InstanceNotFoundException e) {
                return null;
            }
        }

        public static StrmServerStat get() {
            StrmServerStat r = new StrmServerStat();
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            Double[] loads = cpuLoads(server);
            if (loads != null) {
                r.procCpuLoad = loads[0];
                r.sysCpuLoad = loads[1];
            }
            double d = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            if (d >= 0)
                r.systemLoadAverage = d;
            MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
            r.heapMemoryUsage = mem.getHeapMemoryUsage();
            r.nonHeapMemoryUsage = mem.getNonHeapMemoryUsage();
            ThreadMXBean t = ManagementFactory.getThreadMXBean();
            r.threadCount = t.getThreadCount();
            long[] arr = t.findDeadlockedThreads();
            if (arr != null)
                r.deadLockThreads = arr.length;
            else
                r.deadLockThreads = 0;

            return r;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public long getStartupTime() {
            return startupTime;
        }

        public void setStartupTime(long startupTime) {
            this.startupTime = startupTime;
        }

        public Double getProcCpuLoad() {
            return procCpuLoad;
        }

        public void setProcCpuLoad(Double procCpuLoad) {
            this.procCpuLoad = procCpuLoad;
        }

        public Double getSysCpuLoad() {
            return sysCpuLoad;
        }

        public void setSysCpuLoad(Double sysCpuLoad) {
            this.sysCpuLoad = sysCpuLoad;
        }

        public Double getSystemLoadAverage() {
            return systemLoadAverage;
        }

        public void setSystemLoadAverage(Double systemLoadAverage) {
            this.systemLoadAverage = systemLoadAverage;
        }

        public MemoryUsage getHeapMemoryUsage() {
            return heapMemoryUsage;
        }

        public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage) {
            this.heapMemoryUsage = heapMemoryUsage;
        }

        public MemoryUsage getNonHeapMemoryUsage() {
            return nonHeapMemoryUsage;
        }

        public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage) {
            this.nonHeapMemoryUsage = nonHeapMemoryUsage;
        }

        public int getThreadCount() {
            return threadCount;
        }

        public void setThreadCount(int threadCount) {
            this.threadCount = threadCount;
        }

        public int getDeadLockThreads() {
            return deadLockThreads;
        }

        public void setDeadLockThreads(int deadLockThreads) {
            this.deadLockThreads = deadLockThreads;
        }

//        public StrmStatSampling getAvProcessDelay() {
//            return avProcessDelay;
//        }

//        public void setAvProcessDelay(StrmStatSampling avProcessDelay) {
//            this.avProcessDelay = avProcessDelay;
//        }

        public StrmStatSampling getAudioProcessDelay() {
            return audioProcessDelay;
        }

        public void setAudioProcessDelay(StrmStatSampling audioProcessDelay) {
            this.audioProcessDelay = audioProcessDelay;
        }

        public StrmStatSampling getVideoProcessDelay() {
            return videoProcessDelay;
        }

        public void setVideoProcessDelay(StrmStatSampling videoProcessDelay) {
            this.videoProcessDelay = videoProcessDelay;
        }

        public StrmStatSampling getFlvAvProcessDelay() {
            return flvAvProcessDelay;
        }

        public void setFlvAvProcessDelay(StrmStatSampling flvAvProcessDelay) {
            this.flvAvProcessDelay = flvAvProcessDelay;
        }

        @Override
        public String toString() {
            return "StrmServerStat{" +
                    "version='" + version + '\'' +
                    ", startupTime='" + startupTime + '\'' +
                    ", systemLoadAverage=" + systemLoadAverage +
                    ", procCpuLoad=" + procCpuLoad +
                    ", sysCpuLoad=" + sysCpuLoad +
                    ", heapMemoryUsage=" + heapMemoryUsage +
                    ", nonHeapMemoryUsage=" + nonHeapMemoryUsage +
                    ", threadCount=" + threadCount +
                    ", deadLockThreads=" + deadLockThreads +
//                    ", avProcessDelay=" + avProcessDelay +
                    ", audioProcessDelay=" + audioProcessDelay +
                    ", videoProcessDelay=" + videoProcessDelay +
                    ", flvAvProcessDelay=" + flvAvProcessDelay +
                    '}';
        }
    }



    public static class StrmReportReq {
        private boolean withServerStat;

        public boolean isWithServerStat() {
            return withServerStat;
        }

        public void setWithServerStat(boolean withServerStat) {
            this.withServerStat = withServerStat;
        }

        @Override
        public String toString() {
            return "StrmReportReq{" +
                    "withServerStat=" + withServerStat +
                    '}';
        }
    }

    public static class QryServerStatReq {}

    public static class QryServerStatResult {
        private String instanceId;
        private String reportTime;
        private String error;

        private StrmServerStat serverStat;

        public QryServerStatResult() {
        }

        public QryServerStatResult(String instanceId, String reportTime, String error, StrmServerStat serverStat) {
            this.instanceId = instanceId;
            this.reportTime = reportTime;
            this.error = error;
            this.serverStat = serverStat;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getReportTime() {
            return reportTime;
        }

        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public StrmServerStat getServerStat() {
            return serverStat;
        }

        public void setServerStat(StrmServerStat serverStat) {
            this.serverStat = serverStat;
        }

        @Override
        public String toString() {
            return "QryServerStatResult{" +
                    "instanceId='" + instanceId + '\'' +
                    ", reportTime='" + reportTime + '\'' +
                    ", error='" + error + '\'' +
                    ", serverStat=" + serverStat +
                    '}';
        }
    }

    public static class ChannelReportResult {
        private String instanceId;
        private long reportTm;
        private String error;

        private StrmServerStat serverStat;
        private long recvFromTerm1Minute;
        private int channelCount;
        private ChannelStat[] channels;

        public ChannelReportResult() {
        }

        public ChannelReportResult(
                String instanceId,
                long reportTm,
                String error,
                StrmServerStat serverStat,
                long recvFromTerm1Minute,
                int channelCount,
                ChannelStat[] channels) {
            this.instanceId = instanceId;
            this.reportTm = reportTm;
            this.error = error;
            this.serverStat = serverStat;
            this.recvFromTerm1Minute = recvFromTerm1Minute;
            this.channelCount = channelCount;
            this.channels = channels;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public long getReportTm() {
            return reportTm;
        }

        public void setReportTm(long reportTm) {
            this.reportTm = reportTm;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public StrmServerStat getServerStat() {
            return serverStat;
        }

        public void setServerStat(StrmServerStat serverStat) {
            this.serverStat = serverStat;
        }

        public long getRecvFromTerm1Minute() {
            return recvFromTerm1Minute;
        }

        public void setRecvFromTerm1Minute(long recvFromTerm1Minute) {
            this.recvFromTerm1Minute = recvFromTerm1Minute;
        }

        public int getChannelCount() {
            return channelCount;
        }

        public void setChannelCount(int channelCount) {
            this.channelCount = channelCount;
        }

        public ChannelStat[] getChannels() {
            return channels;
        }

        public void setChannels(ChannelStat[] channels) {
            this.channels = channels;
        }

        @Override
        public String toString() {
            return "ChannelReportResult{" +
                    "instanceId='" + instanceId + '\'' +
                    ", reportTm=" + reportTm +
                    ", error='" + error + '\'' +
                    ", serverStat=" + serverStat +
                    ", recvFromTerm1Minute=" + recvFromTerm1Minute +
                    ", channelCount=" + channelCount +
                    ", channels=" + Arrays.toString(channels) +
                    '}';
        }
    }

    public static class StrmTraceEntry {
        private String simNo;
        private String startTraceTime;

        public StrmTraceEntry() {
        }

        public StrmTraceEntry(String simNo, String startTraceTime) {
            this.simNo = simNo;
            this.startTraceTime = startTraceTime;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public String getStartTraceTime() {
            return startTraceTime;
        }

        public void setStartTraceTime(String startTraceTime) {
            this.startTraceTime = startTraceTime;
        }

        @Override
        public String toString() {
            return "StrmTraceEntry{" +
                    "simNo='" + simNo + '\'' +
                    ", startTraceTime='" + startTraceTime + '\'' +
                    '}';
        }
    }

    public static class StreamingConfig {
        private int maxLivePlayTimeInSeconds;
        private String externalServerAddr;
//        private int govLiveStrmPort;
//        private int govReplayStrmPort;


        public int getMaxLivePlayTimeInSeconds() {
            return maxLivePlayTimeInSeconds;
        }

        public void setMaxLivePlayTimeInSeconds(int maxLivePlayTimeInSeconds) {
            this.maxLivePlayTimeInSeconds = maxLivePlayTimeInSeconds;
        }

        public String getExternalServerAddr() {
            return externalServerAddr;
        }

        public void setExternalServerAddr(String externalServerAddr) {
            this.externalServerAddr = externalServerAddr;
        }

//        public int getGovLiveStrmPort() {
//            return govLiveStrmPort;
//        }
//
//        public void setGovLiveStrmPort(int govLiveStrmPort) {
//            this.govLiveStrmPort = govLiveStrmPort;
//        }
//
//        public int getGovReplayStrmPort() {
//            return govReplayStrmPort;
//        }
//
//        public void setGovReplayStrmPort(int govReplayStrmPort) {
//            this.govReplayStrmPort = govReplayStrmPort;
//        }

        @Override
        public String toString() {
            return "StreamingConfig{" +
                    "maxLivePlayTimeInSeconds=" + maxLivePlayTimeInSeconds +
                    ", externalServerAddr='" + externalServerAddr + '\'' +
                    '}';
        }
    }

    public static class StrmMediaNotif {

        public static final String ACT__id = "id";
        public static final String ACT__strmReady = "strmReady";
        public static final String ACT__strmClosed = "strmClosed";
        public static final String ACT__qualityReport = "qr";
        public static final String ACT__seeking = "seeking";
        public static final String ACT__strmPaused = "strmPaused";
        public static final String ACT__strmResumed = "strmResumed";
        public static final String ACT__ctrlGot = "ctrlGot";

        public static final String TYP_none = "";
        public static final String TYP_live = "live";
        public static final String TYP_replay = "replay";

        public static final int CLOSE_CAUSE__clientReq = 1;
        public static final int CLOSE_CAUSE__termStrmClose = 2;
        public static final int CLOSE_CAUSE__connectStrmServerFailed = 3;
        public static final int CLOSE_CAUSE__exceptionCaught = 4;
        public static final int CLOSE_CAUSE__keepTimeout = 5;
        public static final int CLOSE_CAUSE__termDataTimeout = 6;
        public static final int CLOSE_CAUSE__badStrmFormat = 7;


        private String act;
        private String reqId;
        private String typ;
        private String servId;
        private String simNo;
        private short chan;
        private Short codeStream;
        private Byte lostRate;
        private String playUrl;
        private String wsUrl;
        private Integer closeCause;
        private String closeReason;
        private String mediaTyp;

        public StrmMediaNotif() {
        }

        public StrmMediaNotif(
                String act, String reqId, String typ, String servId, String simNo, short chan, Short codeStream,
                Byte lostRate, String playUrl, String wsUrl, Integer closeCause,
                String mediaTyp) {
            this.act = act;
            this.reqId = reqId;
            this.typ = typ;
            this.servId = servId;
            this.simNo = simNo;
            this.chan = chan;
            this.codeStream = codeStream;
            this.lostRate = lostRate;
            this.playUrl = playUrl;
            this.wsUrl = wsUrl;
            this.closeCause = closeCause;
            this.mediaTyp = mediaTyp;
        }

        public String getAct() {
            return act;
        }

        public void setAct(String act) {
            this.act = act;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        public void setTyp(boolean live) {
            if (live)
                typ = TYP_live;
            else
                typ = TYP_replay;
        }

        public String getServId() {
            return servId;
        }

        public void setServId(String servId) {
            this.servId = servId;
        }

        public String getSimNo() {
            return simNo;
        }

        public void setSimNo(String simNo) {
            this.simNo = simNo;
        }

        public short getChan() {
            return chan;
        }

        public void setChan(short chan) {
            this.chan = chan;
        }

        public Short getCodeStream() {
            return codeStream;
        }

        public void setCodeStream(Short codeStream) {
            this.codeStream = codeStream;
        }

        public Byte getLostRate() {
            return lostRate;
        }

        public void setLostRate(Byte lostRate) {
            this.lostRate = lostRate;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public String getWsUrl() {
            return wsUrl;
        }

        public void setWsUrl(String wsUrl) {
            this.wsUrl = wsUrl;
        }

        public Integer getCloseCause() {
            return closeCause;
        }

        public void setCloseCause(Integer closeCause) {
            this.closeCause = closeCause;
        }

        public String getCloseReason() {
            return closeReason;
        }

        public void setCloseReason(String closeReason) {
            this.closeReason = closeReason;
        }

        public static String closeCauseToText(int closeCause) {
            switch (closeCause) {
                case CLOSE_CAUSE__clientReq:
                    return "Client request close.";

                case CLOSE_CAUSE__connectStrmServerFailed:
                    return "Connect stream server failed.";

                case CLOSE_CAUSE__exceptionCaught:
                    return "Exception caught.";

                case CLOSE_CAUSE__keepTimeout:
                    return "Client keep timeout.";

                case CLOSE_CAUSE__termDataTimeout:
                    return "Terminal media data timeout.";

                case CLOSE_CAUSE__termStrmClose:
                    return "Terminal connection closed.";

                default:
                    return "Unknown";
            }
        }

        public void updateCloseReason() {
            if (closeReason != null)
                return;

            if (closeCause != null) {
                int cc = closeCause;
                if (cc != 0) {
                    switch (cc) {
                        case CLOSE_CAUSE__clientReq:
                            closeReason = "Client request close.";
                            break;

                        case CLOSE_CAUSE__connectStrmServerFailed:
                            closeReason = "Connect stream server failed.";
                            break;

                        case CLOSE_CAUSE__exceptionCaught:
                            closeReason = "Exception caught.";
                            break;

                        case CLOSE_CAUSE__keepTimeout:
                            closeReason = "Client keep timeout.";
                            break;

                        case CLOSE_CAUSE__termDataTimeout:
                            closeReason = "Terminal media data timeout.";
                            break;

                        case CLOSE_CAUSE__termStrmClose:
                            closeReason = "Terminal connection closed.";
                            break;

                        case CLOSE_CAUSE__badStrmFormat:
                            closeReason = "Bad stream format.";
                            break;

                        default:
                            closeReason = "unknown";
                            break;
                    }
                } else
                    closeReason = null;
            } else
                closeReason = null;
        }

        public String getMediaTyp() {
            return mediaTyp;
        }

        public void setMediaTyp(String mediaTyp) {
            this.mediaTyp = mediaTyp;
        }

        @Override
        public String toString() {
            return "StrmMediaNotif{" +
                    "act='" + act + '\'' +
                    ", reqId='" + reqId + '\'' +
                    ", typ='" + typ + '\'' +
                    ", servId='" + servId + '\'' +
                    ", simNo='" + simNo + '\'' +
                    ", chan=" + chan +
                    ", codeStream=" + codeStream +
                    ", lostRate=" + lostRate +
                    ", playUrl='" + playUrl + '\'' +
                    ", wsUrl='" + wsUrl + '\'' +
                    ", closeCause=" + closeCause +
                    ", closeReason='" + closeReason + '\'' +
                    ", mediaTyp='" + mediaTyp + '\'' +
                    '}';
        }
    }

    public static class DebugCountActorResult {
        private String requestId;
        private long count;
        private List<String> names;

        public DebugCountActorResult() {
        }

        public DebugCountActorResult(String requestId, long count) {
            this.requestId = requestId;
            this.count = count;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        public void inc() {
            count += 1;
        }

        public void addName(String name) {
            if (names == null) {
                names = new ArrayList<>();
            }

            names.add(name);
            inc();
        }

        public void sortNames() {
            if (names != null)
                names.sort(String::compareTo);
        }

        @Override
        public String toString() {
            return "DebugCountActorResult{" +
                    "requestId='" + requestId + '\'' +
                    ", count=" + count +
                    ", names=" + names +
                    '}';
        }
    }

}
