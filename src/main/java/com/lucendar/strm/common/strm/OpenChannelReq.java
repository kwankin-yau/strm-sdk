package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

import static com.lucendar.strm.common.StreamingApi.CHANNEL_TYPE__LIVE;
import static com.lucendar.strm.common.StreamingApi.CHANNEL_TYPE__REPLAY;
import static com.lucendar.strm.common.StreamingApi.PROTO__HLS;
import static com.lucendar.strm.common.StreamingApi.PROTO__HTTP_FLV;
import static com.lucendar.strm.common.StreamingApi.PROTO__RTMP;
import static com.lucendar.strm.common.StreamingApi.encodeStreamName;
import static com.lucendar.strm.common.StreamingApi.isValidReqId;
import static com.lucendar.strm.common.StreamingApi.isValidSimNo;

public class OpenChannelReq implements StrmMsg {

    public static final int DATA_TYPE__AV = 0;
    public static final int DATA_TYPE__VIDEO = 1;
    public static final int DATA_TYPE__TALK = 2;
    public static final int DATA_TYPE__LISTEN = 3;
    public static final int DATA_TYPE__BROADCAST = 4;

    public static final byte LIVE_CODE_STREAM__PRIMARY = 0;
    public static final byte LIVE_CODE_STREAM__SUB = 1;

    public static final byte REPLAY_MEDIA_TYPE__AV = 0;
    public static final byte REPLAY_MEDIA_TYPE__AUDIO = 1;
    public static final byte REPLAY_MEDIA_TYPE__VIDEO = 2;
    public static final byte REPLAY_MEDIA_TYPE__AUDIO_OR_VIDEO = 3;

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

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__OpenChannelReq;
    }

    public static class RtspSource {
        private String url;
        private String username;
        private String password;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", RtspSource.class.getSimpleName() + "[", "]")
                    .add("url='" + url + "'")
                    .add("username='" + username + "'")
                    .add("password='" + password + "'")
                    .toString();
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
    private String uriScheme;
    private Integer talkSendProtoVer;
    private AudioConfig2 audioCfg;
    private RtspSource rtspSrc;


    public OpenChannelReq() {
    }

    public OpenChannelReq(String reqId, String callback, StrmUserInfo user, String typ, String simNo, short channelId,
                          byte proto, byte connIdx, String clientData, int dataTyp, byte codeStrm,
                          boolean recordOnServer, Integer keepInterval, String uriScheme, Integer talkSendProtoVer,
                          AudioConfig2 audioCfg,
                          RtspSource rtspSrc) {
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
        this.uriScheme = uriScheme;
        this.talkSendProtoVer = talkSendProtoVer;
        this.audioCfg = audioCfg;
        this.rtspSrc = rtspSrc;
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

    public boolean isReplay() {
        return CHANNEL_TYPE__REPLAY.equals(typ);
    }

    public String streamName() {
        return encodeStreamName(simNo, channelId, isLive());
    }

    /**
     * Return requested data type (for live) or media type (for replay) of the channel.
     * <ul>
     *     <li>For live channel, then value domain of the fields is one of `DATA_TYPE__XXXX`.</li>
     *     <li>For replay channel, then value domain of the fields is one of `REPLAY_MEDIA_TYPE__XXX`.</li>
     * </ul>
     *
     * @return data type (for live) or media type (for replay) of the channel
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

    public String getUriScheme() {
        return uriScheme;
    }

    public void setUriScheme(String uriScheme) {
        this.uriScheme = uriScheme;
    }

    public UriScheme uriScheme(UriScheme defaultValue) {
        if (this.uriScheme == null)
            return defaultValue;
        else
            return UriScheme.of(this.uriScheme);
    }

    public Integer getTalkSendProtoVer() {
        return talkSendProtoVer;
    }

    public void setTalkSendProtoVer(Integer talkSendProtoVer) {
        this.talkSendProtoVer = talkSendProtoVer;
    }

    public RtspSource getRtspSrc() {
        return rtspSrc;
    }

    public void setRtspSrc(RtspSource rtspSrc) {
        this.rtspSrc = rtspSrc;
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

        String token = user.getToken();
        if (token == null || token.isEmpty())
            return "user.token";

        if (typ == null)
            return "typ";

        boolean live = isLive();
        if (!live && !isReplay())
            return "typ";

        if (!isValidSimNo(simNo))
            return "simNo";

        if (live) {
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
        } else {
            switch (dataTyp) {
                case REPLAY_MEDIA_TYPE__AV:
                case REPLAY_MEDIA_TYPE__AUDIO:
                case REPLAY_MEDIA_TYPE__VIDEO:
                case REPLAY_MEDIA_TYPE__AUDIO_OR_VIDEO:
                    break;

                default:
                    return "dataTyp";
            }
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

        if (uriScheme != null) {
            if (!UriScheme.isValid(uriScheme))
                return "uriScheme";
        }

        if (audioCfg != null) {
            if (!AudioConfig2.isValidSampleRate(audioCfg.getSampleRate()))
                return "audioCfg.sampleRate";

            if (!AudioConfig2.isValidChannels(audioCfg.getChannels()))
                return "audioCfg.channels";
        }

        if (rtspSrc != null) {
            if (rtspSrc.url == null)
                return "rtspSrc.url";
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
        return new StringJoiner(", ", OpenChannelReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("callback='" + callback + "'")
                .add("user=" + user)
                .add("typ='" + typ + "'")
                .add("simNo='" + simNo + "'")
                .add("channelId=" + channelId)
                .add("proto=" + proto)
                .add("connIdx=" + connIdx)
                .add("clientData='" + clientData + "'")
                .add("dataTyp=" + dataTyp)
                .add("codeStrm=" + codeStrm)
                .add("recordOnServer=" + recordOnServer)
                .add("keepInterval=" + keepInterval)
                .add("uriScheme='" + uriScheme + "'")
                .add("talkSendProtoVer=" + talkSendProtoVer)
                .add("rtspSrc=" + rtspSrc)
                .toString();
    }
}
