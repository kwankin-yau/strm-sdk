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

public class OpenStrmReq implements StrmMsg {

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

    public static final int MIN_KEEP_INTERVAL = 15;
    public static final int MAX_KEEP_INTERVAL = 600;

    public static final int DEFAULT_INTERVAL__FLV = 20;
    public static final int MAX_INTERVAL__FLV = 30 * 60;

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
        return StrmMsgs.STRM_MSG__OpenStrmReq;
    }

    public static class RtspSource {
        private String url;
        private String user;
        private String pwd;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", RtspSource.class.getSimpleName() + "[", "]")
                    .add("url='" + url + "'")
                    .add("user='" + user + "'")
                    .add("pwd='" + pwd + "'")
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RtspSource that = (RtspSource) o;

            if (url != null ? !url.equals(that.url) : that.url != null) return false;
            if (user != null ? !user.equals(that.user) : that.user != null) return false;
            return pwd != null ? pwd.equals(that.pwd) : that.pwd == null;
        }

        @Override
        public int hashCode() {
            int result = url != null ? url.hashCode() : 0;
            result = 31 * result + (user != null ? user.hashCode() : 0);
            result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
            return result;
        }
    }

    private String reqId;
    private String callback;
    private StrmUserInfo user;
    private String typ;
    private String simNo;
    private short chanId;
    private byte proto;
    private byte connIdx;
    private String clientData;
    private int dataTyp;
    private byte codeStrm;
    private boolean exclusive;
    private boolean record;
    private Boolean detectMediaTyp;
    private Integer keepIntv;
    private String uriScheme;
    private Integer talkSendProtoVer;
    private AudioConfig audioCfg;
    private RtspSource rtspSrc;
    private String timedToken;


    public OpenStrmReq() {
    }

    public OpenStrmReq(String reqId, String callback, StrmUserInfo user, String typ, String simNo, short chanId,
                       byte proto, byte connIdx, String clientData, int dataTyp, byte codeStrm,
                       boolean exclusive, boolean record,
                       Boolean detectMediaTyp,
                       Integer keepIntv, String uriScheme, Integer talkSendProtoVer,
                       AudioConfig audioCfg,
                       RtspSource rtspSrc,
                       String timedToken) {
        this.reqId = reqId;
        this.callback = callback;
        this.user = user;
        this.typ = typ;
        this.simNo = simNo;
        this.chanId = chanId;
        this.proto = proto;
        this.connIdx = connIdx;
        this.clientData = clientData;
        this.dataTyp = dataTyp;
        this.codeStrm = codeStrm;
        this.exclusive = exclusive;
        this.record = record;
        this.detectMediaTyp = detectMediaTyp;
        this.keepIntv = keepIntv;
        this.uriScheme = uriScheme;
        this.talkSendProtoVer = talkSendProtoVer;
        this.audioCfg = audioCfg;
        this.rtspSrc = rtspSrc;
        this.timedToken = timedToken;
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

    public short getChanId() {
        return chanId;
    }

    public void setChanId(short chanId) {
        this.chanId = chanId;
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
        return encodeStreamName(simNo, chanId, isLive());
    }

    /**
     * Return requested data type (for live) or media type (for replay) of the channel.
     * <ul>
     *     <li>For live channel, then value domain of the fields is one of `DATA_TYPE__XXXX`.</li>
     *     <li>For replay channel, then value domain of the fields is one of `REPLAY_MEDIA_TYPE__XXX`(exclude `REPLAY_MEDIA_TYPE__AUDIO_OR_VIDEO`).</li>
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

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean isRecord() {
        return record;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    public Integer getKeepIntv() {
        return keepIntv;
    }

    public void setKeepIntv(Integer keepIntv) {
        this.keepIntv = keepIntv;
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

    public AudioConfig getAudioCfg() {
        return audioCfg;
    }

    public void setAudioCfg(AudioConfig audioCfg) {
        this.audioCfg = audioCfg;
    }

    public RtspSource getRtspSrc() {
        return rtspSrc;
    }

    public void setRtspSrc(RtspSource rtspSrc) {
        this.rtspSrc = rtspSrc;
    }

    public String getTimedToken() {
        return timedToken;
    }

    public void setTimedToken(String timedToken) {
        this.timedToken = timedToken;
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
//                if (keepIntv != null) {
//                    if (keepIntv < MIN_INTERVAL__HLS || keepIntv > MAX_INTERVAL__HLS)
//                        return "keepIntv";
//                }
                break;

            case PROTO__HTTP_FLV:
//                if (keepIntv != null) {
//                    if (keepIntv < MIN_INTERVAL__FLV || keepIntv > MAX_INTERVAL__FLV)
//                        return "keepIntv";
//                }
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
            if (!AudioConfig.isValidSampleRate(audioCfg.getSampleRate()))
                return "audioCfg.sampleRate";

            if (!AudioConfig.isValidChannels(audioCfg.getChannels()))
                return "audioCfg.channels";
        }

        if (rtspSrc != null) {
            if (rtspSrc.url == null)
                return "rtspSrc.url";
        }

        if (keepIntv != null) {
            if (keepIntv < MIN_KEEP_INTERVAL || keepIntv > MAX_KEEP_INTERVAL)
                return "keepIntv";
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
        return new StringJoiner(", ", OpenStrmReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("callback='" + callback + "'")
                .add("user=" + user)
                .add("typ='" + typ + "'")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("proto=" + proto)
                .add("connIdx=" + connIdx)
                .add("clientData='" + clientData + "'")
                .add("dataTyp=" + dataTyp)
                .add("codeStrm=" + codeStrm)
                .add("exclusive=" + exclusive)
                .add("record=" + record)
                .add("detectMediaTyp=" + detectMediaTyp)
                .add("keepIntv=" + keepIntv)
                .add("uriScheme='" + uriScheme + "'")
                .add("talkSendProtoVer=" + talkSendProtoVer)
                .add("audioCfg=" + audioCfg)
                .add("rtspSrc=" + rtspSrc)
                .add("timedToken='" + timedToken + "'")
                .toString();
    }
}
