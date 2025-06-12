package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

import com.lucendar.strm.common.StreamingApi;
import static com.lucendar.strm.common.StreamingApi.CHANNEL_TYPE__LIVE;
import static com.lucendar.strm.common.StreamingApi.CHANNEL_TYPE__REPLAY;
import static com.lucendar.strm.common.StreamingApi.STRM_FORMAT__FLV;
import static com.lucendar.strm.common.StreamingApi.STRM_FORMAT__HLS;
import static com.lucendar.strm.common.StreamingApi.STRM_FORMAT__RTMP;
import static com.lucendar.strm.common.StreamingApi.STRM_FORMAT__RTSP;
import static com.lucendar.strm.common.StreamingApi.STRM_SUB_FORMAT__FMP4;
import static com.lucendar.strm.common.StreamingApi.STRM_SUB_FORMAT__MPEGTS;
import static com.lucendar.strm.common.StreamingApi.encodeStreamName;
import static com.lucendar.strm.common.StreamingApi.isValidReqId;
import static com.lucendar.strm.common.StreamingApi.isValidSimNo;
import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

/**
 * 打开流请求
 */
public class OpenStrmReq implements StrmMsg {

    /**
     * 流类型: 实时流
     */
    public static final String STRM_TYPE__LIVE = "live";

    /**
     * 流类型: 回放流
     */
    public static final String STRM_TYPE__REPLAY = "replay";

    /**
     * 数据类型: 音视频
     */
    public static final int DATA_TYPE__AV = 0;

    /**
     * 数据类型: 视频
     */
    public static final int DATA_TYPE__VIDEO = 1;

    /**
     * 数据类型: 对讲
     */
    public static final int DATA_TYPE__TALK = 2;

    /**
     * 数据类型: 监听
     */
    public static final int DATA_TYPE__LISTEN = 3;

    /**
     * 数据类型: 广播
     */
    public static final int DATA_TYPE__BROADCAST = 4;


    /**
     * 码流类型: 主码流
     */
    public static final byte LIVE_CODE_STREAM__PRIMARY = 0;

    /**
     * 码流类型: 子码流
     */
    public static final byte LIVE_CODE_STREAM__SUB = 1;

    /**
     * 媒体类型: 音视频
     */
    public static final byte REPLAY_MEDIA_TYPE__AV = 0;

    /**
     * 媒体类型: 音频
     */
    public static final byte REPLAY_MEDIA_TYPE__AUDIO = 1;

    /**
     * 媒体类型: 视频
     */
    public static final byte REPLAY_MEDIA_TYPE__VIDEO = 2;

    /**
     * 媒体类型: 音频或视频
     */
    public static final byte REPLAY_MEDIA_TYPE__AUDIO_OR_VIDEO = 3;

    /**
     * 码流类型: 任意
     */
    public static final byte REPLAY_CODE_STREAM__ANY = 0;

    /**
     * 码流类型: 主码流
     */
    public static final byte REPLAY_CODE_STREAM__PRIMARY = 1;

    /**
     * 码流类型: 子码流
     */
    public static final byte REPLAY_CODE_STREAM__SUB = 2;

    /**
     * 存储类型: 任意
     */
    public static final byte REPLAY_STORAGE_TYPE__ANY = 0;

    /**
     * 存储类型: 主码流
     */
    public static final byte REPLAY_STORAGE_TYPE__PRIMARY = 1;

    /**
     * 存储类型: 备份
     */
    public static final byte REPLAY_STORAGE_TYPE__BACKUP = 2;

    /**
     * 最小保持间隔: 15秒
     */
    public static final int MIN_KEEP_INTERVAL = 15;

    /**
     * 最大保持间隔: 600秒
     */
    public static final int MAX_KEEP_INTERVAL = 600;

    /**
     * 默认保持间隔(FLV): 20秒
     */
    public static final int DEFAULT_INTERVAL__FLV = 20;

    /**
     * 最大保持间隔(FLV): 30分钟
     */
    public static final int MAX_INTERVAL__FLV = 30 * 60;

    /**
     * 默认保持间隔(HLS): 20秒
     */
    public static final int DEFAULT_INTERVAL__HLS = 20;

    /**
     * 最大保持间隔(HLS): 30分钟
     */
    public static final int MAX_INTERVAL__HLS = 30 * 60;

    /*
     * TRACE_MODE__XXXX: The trace mode which user requested on this stream play request.
     */

    /**
     * 跟踪模式：0 - 禁用(DISABLED mode. DO NOT trace)
     */
    public static final int TRACE_MODE__DISABLED = 0;

    /**
     * 跟踪模式：1 - 简单(SIMPLE mode. This mode only effect `strm-proxy` or `micro-gnss` service.)
     */
    public static final int TRACE_MODE__SIMPLE = 1;

    /**
     * 跟踪模式：2 - 高级(ADVANCED mode. This mode only effect `strm-proxy` or `micro-gnss` service.)
     */
    public static final int TRACE_MODE__ADVANCED = 2;

    /**
     * 跟踪模式：3 - 完全(FULL mode. In this mode, the stream media service will record the media channel traffic to database, include
     * data receive from terminal and send to terminal.)
     */
    public static final int TRACE_MODE__FULL = 3;

    /**
     * 数据类型是否包含服务器音频
     * @param dataType 数据类型
     * @return 是否包含服务器音频
     */
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

    /**
     * RTSP源
     */
    public static class RtspSource {
        private String url;
        private String user;
        private String pwd;

        /**
         * 获取RTSP源的URL
         * @return RTSP源的URL
         */
        public String getUrl() {
            return url;
        }

        /**
         * 设置RTSP源的URL
         * @param url RTSP源的URL
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * 获取RTSP源的访问用户名
         * @return RTSP源的访问用户名
         */
        public String getUser() {
            return user;
        }

        /**
         * 设置RTSP源的访问用户名
         * @param user RTSP源的访问用户名
         */
        public void setUser(String user) {
            this.user = user;
        }

        /**
         * 获取RTSP源的访问密码
         * @return RTSP源的访问密码
         */
        public String getPwd() {
            return pwd;
        }

        /**
         * 设置RTSP源的访问密码
         * @param pwd RTSP源的访问密码
         */
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

    private String appId;
    private String reqId;
    private String cb;
    private StrmUserInfo user;
    private String typ;
    private String simNo;
    private short chanId;
    private byte fmt;
    private String subFmt;
    private byte connIdx;
    private String clientData;
    private int dataTyp;
    private byte codeStrm;
    private boolean exclusive;
    private boolean record;
    private Boolean detectMediaTyp;
    private Integer keepIntv;
    private String scheme;
//    private Integer talkSendProtoVer;
    private AudioConfig inputAudioCfg;
    private AudioConfig audioCfg;
    private RtspSource rtspSrc;
    private String timedToken;
    private Integer trace;

    /**
     * 构造函数
     */
    public OpenStrmReq() {
    }

    /**
     * 构造函数
     * @param appId 应用ID
     * @param reqId 请求ID
     * @param cb 回调函数
     * @param user 用户信息
     * @param typ 类型
     * @param simNo 终端识别号
     * @param chanId 通道ID
     * @param fmt 格式，为 `StreamingApi.STRM_FORMAT__xxx` 常量之一 
     * @param subFmt 子格式，为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一
     * @param connIdx 连接索引
     * @param clientData 客户端数据
     * @param dataTyp 数据类型
     * @param codeStrm 码流类型
     * @param exclusive 是否独占
     * @param record 是否记录
     * @param detectMediaTyp 是否检测媒体类型
     * @param keepIntv 保持间隔
     * @param scheme 方案
     * @param inputAudioCfg 输入音频配置
     * @param audioCfg 音频配置
     * @param rtspSrc RTSP源
     * @param timedToken 时间令牌
     * @param trace 跟踪模式
     */
    public OpenStrmReq(
            String appId,
            String reqId,
            String cb,
            StrmUserInfo user,
            String typ,
            String simNo,
            short chanId,
            byte fmt,
            String subFmt,
            byte connIdx,
            String clientData,
            int dataTyp,
            byte codeStrm,
            boolean exclusive,
            boolean record,
            Boolean detectMediaTyp,
            Integer keepIntv,
            String scheme,
            AudioConfig inputAudioCfg,
            AudioConfig audioCfg,
            RtspSource rtspSrc,
            String timedToken,
            Integer trace) {
        this.reqId = reqId;
        this.cb = cb;
        this.user = user;
        this.typ = typ;
        this.simNo = simNo;
        this.chanId = chanId;
        this.fmt = fmt;
        this.subFmt = subFmt;
        this.connIdx = connIdx;
        this.clientData = clientData;
        this.dataTyp = dataTyp;
        this.codeStrm = codeStrm;
        this.exclusive = exclusive;
        this.record = record;
        this.detectMediaTyp = detectMediaTyp;
        this.keepIntv = keepIntv;
        this.scheme = scheme;
//        this.talkSendProtoVer = talkSendProtoVer;
        this.inputAudioCfg = inputAudioCfg;
        this.audioCfg = audioCfg;
        this.rtspSrc = rtspSrc;
        this.timedToken = timedToken;
        this.trace = trace;
    }

    /**
     * 获取应用ID
     * @return 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取请求ID
     * @return 请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求ID
     * @param reqId 请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 获取通知回调地址
     * @return 通知回调地址
     */
    public String getCb() {
        return cb;
    }

    /**
     * 设置通知回调地址
     * @param cb 通知回调地址
     */
    public void setCb(String cb) {
        this.cb = cb;
    }

    /**
     * 获取用户信息
     * @return 用户信息
     */
    public StrmUserInfo getUser() {
        return user;
    }

    /**
     * 设置用户信息
     * @param user 用户信息
     */
    public void setUser(StrmUserInfo user) {
        this.user = user;
    }

    /**
     * 获取流类型，为 `STRM_TYPE__LIVE` 或 `STRM_TYPE__REPLAY`
     * @return 流类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置流类型, 为 `STRM_TYPE__LIVE` 或 `STRM_TYPE__REPLAY`
     * @param typ 流类型
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 获取通道ID
     * @return 通道ID
     */
    public short getChanId() {
        return chanId;
    }

    /**
     * 设置通道ID
     * @param chanId 通道ID
     */
    public void setChanId(short chanId) {
        this.chanId = chanId;
    }

    /**
     * 获取格式, 为 `StreamingApi.STRM_FORMAT__xxx` 常量之一
     * @return 格式
     */
    public byte getFmt() {
        return fmt;
    }

    /**
     * 设置格式, 为 `StreamingApi.STRM_FORMAT__xxx` 常量之一
     * @param fmt 格式
     */
    public void setFmt(byte fmt) {
        this.fmt = fmt;
    }

    /**
     * 获取子格式, 为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一
     * @return 子格式
     */
    public String getSubFmt() {
        return subFmt;
    }

    /**
     * 设置子格式, 为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一
     * @param subFmt 子格式
     */
    public void setSubFmt(String subFmt) {
        this.subFmt = subFmt;
    }

    /**
     * 获取子格式, 为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一。
     * 如果子格式为空, 则返回 `STRM_SUB_FORMAT__FMP4`
     * @return 子格式
     */
    public String subFmtDef() {
        if (subFmt == null)
            return STRM_SUB_FORMAT__FMP4;
        else
            return subFmt;
    }

    /**
     * 获取子格式, 为 `StreamingApi.STRM_SUB_FORMAT__xxx` 常量之一。
     * @param defaultMpeg2Ts 是否默认返回 `STRM_SUB_FORMAT__MPEGTS`
     * @return 子格式
     */
    public String subFmtDef(boolean defaultMpeg2Ts) {
        if (subFmt == null) {
            if (defaultMpeg2Ts)
                return STRM_SUB_FORMAT__MPEGTS;
            else
                return STRM_SUB_FORMAT__FMP4;
        } else
            return subFmt;
    }

    /**
     * 获取连接索引
     * @return 连接索引
     */
    public byte getConnIdx() {
        return connIdx;
    }

    /**
     * 设置连接索引
     * @param connIdx 连接索引
     */
    public void setConnIdx(byte connIdx) {
        this.connIdx = connIdx;
    }

    /**
     * 获取客户端数据
     * @return 客户端数据
     */
    public String getClientData() {
        return clientData;
    }

    /**
     * 设置客户端数据，由调用者设置，用于记录调用者的上下文信息
     * @param clientData 客户端数据
     */
    public void setClientData(String clientData) {
        this.clientData = clientData;
    }

    /**
     * 判断是否为实时流
     * @return 是否为实时流
     */
    public boolean isLive() {
        return CHANNEL_TYPE__LIVE.equals(typ);
    }

    /**
     * 判断是否为对讲流
     * @return 是否为对讲流
     */
    public boolean isTalk() {
        return isLive() && dataTyp == DATA_TYPE__TALK;
    }

    /**
     * 判断是否为回放流
     * @return 是否为回放流
     */
    public boolean isReplay() {
        return CHANNEL_TYPE__REPLAY.equals(typ);
    }

    /**
     * 获取流名称
     * @return 流名称
     */
    public String streamName() {
        return encodeStreamName(simNo, chanId, isLive(), isTalk());
    }

    /**
     * 返回请求的数据类型（当请求流类型为实时流时）或媒体类型（当请求流类型为回放流时）。
     * <ul>
     *     <li>对于实时流请求，数据类型为 `DATA_TYPE__XXXX`。</li>
     *     <li>对于回放流请求，媒体类型为 `REPLAY_MEDIA_TYPE__XXX`(不包括 `REPLAY_MEDIA_TYPE__AUDIO_OR_VIDEO`).</li>
     * </ul>
     *
     * @return 数据类型（当请求流类型为实时流时）或媒体类型（当请求流类型为回放流时）
     */
    public int getDataTyp() {
        return dataTyp;
    }

    /**
     * 设置数据类型
     * @param dataTyp 数据类型
     */
    public void setDataTyp(int dataTyp) {
        this.dataTyp = dataTyp;
    }

    /**
     * 获取码流类型
     * @return 码流类型
     */
    public byte getCodeStrm() {
        return codeStrm;
    }

    /**
     * 设置码流类型
     * @param codeStrm 码流类型
     */
    public void setCodeStrm(byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    /**
     * 判断是否独占打开流
     * @return 是否独占打开流
     */
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * 设置是否独占打开流
     * @param exclusive 是否独占打开流
     */
    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * 取是否在播放的同时存储到服务器上
     * @return 是否在播放的同时存储到服务器上
     */
    public boolean isRecord() {
        return record;
    }

    /**
     * 设置是否在播放的同时存储到服务器上
     * @param record 是否在播放的同时存储到服务器上
     */
    public void setRecord(boolean record) {
        this.record = record;
    }

    /**
     * 获取是否检测媒体类型
     * @return 是否检测媒体类型
     * @deprecated 已废弃，服务端总是检测媒体类型
     */
    public Boolean getDetectMediaTyp() {
        return detectMediaTyp;
    }

    /**
     * 设置是否检测媒体类型
     * @param detectMediaTyp 是否检测媒体类型
     * @deprecated 已废弃，服务端总是检测媒体类型
     */
    public void setDetectMediaTyp(Boolean detectMediaTyp) {
        this.detectMediaTyp = detectMediaTyp;
    }

    /**
     * 获取保持间隔, 单位为秒
     * @return 保持间隔
     */
    public Integer getKeepIntv() {
        return keepIntv;
    }

    /**
     * 设置保持间隔, 单位为秒
     * @param keepIntv 保持间隔
     */
    public void setKeepIntv(Integer keepIntv) {
        this.keepIntv = keepIntv;
    }

    /**
     * 获取url的scheme（协议）
     * @return url的scheme
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * 设置url的scheme（协议）
     * @param scheme url的scheme
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * 获取url的scheme（协议）
     * @param defaultValue 默认值
     * @return url的scheme
     */
    public UriScheme uriScheme(UriScheme defaultValue) {
        if (this.scheme == null)
            return defaultValue;
        else
            return UriScheme.of(this.scheme);
    }

//    public Integer getTalkSendProtoVer() {
//        return talkSendProtoVer;
//    }

//    public void setTalkSendProtoVer(Integer talkSendProtoVer) {
//        this.talkSendProtoVer = talkSendProtoVer;
//    }

    /**
     * 获取输入音频配置
     * @return 输入音频配置
     */
    public AudioConfig getInputAudioCfg() {
        return inputAudioCfg;
    }

    /**
     * 设置输入音频配置
     * @param inputAudioCfg 输入音频配置
     */
    public void setInputAudioCfg(AudioConfig inputAudioCfg) {
        this.inputAudioCfg = inputAudioCfg;
    }

    /**
     * 获取输出音频配置
     * @return 输出音频配置
     */
    public AudioConfig getAudioCfg() {
        return audioCfg;
    }

    /**
     * 设置输出音频配置
     * @param audioCfg 输出音频配置
     */
    public void setAudioCfg(AudioConfig audioCfg) {
        this.audioCfg = audioCfg;
    }

    /**
     * 获取RTSP源
     * @return RTSP源
     */
    public RtspSource getRtspSrc() {
        return rtspSrc;
    }

    /**
     * 设置RTSP源
     * @param rtspSrc RTSP源
     */
    public void setRtspSrc(RtspSource rtspSrc) {
        this.rtspSrc = rtspSrc;
    }

    /**
     * 获取时间令牌
     * @return 时间令牌
     */
    public String getTimedToken() {
        return timedToken;
    }

    /**
     * 设置时间令牌
     * @param timedToken 时间令牌
     */
    public void setTimedToken(String timedToken) {
        this.timedToken = timedToken;
    }

    /**
     * 获取跟踪模式
     * @return 跟踪模式
     */
    public Integer getTrace() {
        return trace;
    }

    /**
     * 设置跟踪模式
     * @param trace 跟踪模式
     */
    public void setTrace(Integer trace) {
        this.trace = trace;
    }

    /**
     * 获取应用ID，如果为空，则返回默认应用ID
     * @return 应用ID
     */
    public String appIdDef() {
        if (appId != null)
            return appId;
        else
            return StreamingApi.DEFAULT_APP_ID;
    }

    /**
     * 获取跟踪模式，如果为空，则返回默认跟踪模式(禁止跟踪)
     * @return 跟踪模式
     */
    public int traceDef() {
        if (trace != null)
            return trace;
        else
            return TRACE_MODE__DISABLED;
    }

    /**
     * 验证请求参数
     * @return 错误信息，如果无错误，则返回null
     */
    public String validate() {
        if (reqId != null) {
            if (!isValidReqId(reqId))
                return "reqId";
        }

        normalizeAppId();

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

        switch (fmt) {
            case STRM_FORMAT__HLS:
//                if (keepIntv != null) {
//                    if (keepIntv < MIN_INTERVAL__HLS || keepIntv > MAX_INTERVAL__HLS)
//                        return "keepIntv";
//                }
                break;

            case STRM_FORMAT__FLV:
//                if (keepIntv != null) {
//                    if (keepIntv < MIN_INTERVAL__FLV || keepIntv > MAX_INTERVAL__FLV)
//                        return "keepIntv";
//                }
                break;

            case STRM_FORMAT__RTSP:
                break;

            case STRM_FORMAT__RTMP:
                break;

            default:
                return "fmt";
        }

        if (subFmt != null) {
            switch (subFmt) {
                case STRM_SUB_FORMAT__FMP4:
                case STRM_SUB_FORMAT__MPEGTS:
                    if (fmt != STRM_FORMAT__HLS)
                        return "subFmt";
                    break;
            }
        }

        if (scheme != null) {
            if (!UriScheme.isValid(scheme))
                return "scheme";
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

        if (trace != null) {
            switch (trace.intValue()) {
                case TRACE_MODE__DISABLED:
                case TRACE_MODE__SIMPLE:
                case TRACE_MODE__ADVANCED:
                case TRACE_MODE__FULL:
                    break;

                default:
                    return "trace";
            }
        }

        return null;
    }

    /**
     * 获取默认保持间隔
     * @param proto 协议
     * @return 默认保持间隔
     */
    public static int defaultKeepInterval(int proto) {
        switch (proto) {
            case STRM_FORMAT__FLV:
                return DEFAULT_INTERVAL__FLV;

            case STRM_FORMAT__HLS:
                return DEFAULT_INTERVAL__HLS;

            case STRM_FORMAT__RTMP:
                return 0;

            case STRM_FORMAT__RTSP:
                return 0;

            default:
                throw new RuntimeException("Invalid parameter: `proto`.");
        }
    }

    /**
     * 规范化应用ID
     */
    public void normalizeAppId() {
        if (this.appId == null)
            this.appId = StreamingApi.DEFAULT_APP_ID;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OpenStrmReq.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("reqId='" + reqId + "'")
                .add("cb='" + cb + "'")
                .add("user=" + user)
                .add("typ='" + typ + "'")
                .add("simNo='" + simNo + "'")
                .add("chanId=" + chanId)
                .add("fmt=" + fmt)
                .add("subFmt='" + subFmt + "'")
                .add("connIdx=" + connIdx)
                .add("clientData='" + clientData + "'")
                .add("dataTyp=" + dataTyp)
                .add("codeStrm=" + codeStrm)
                .add("exclusive=" + exclusive)
                .add("record=" + record)
                .add("detectMediaTyp=" + detectMediaTyp)
                .add("keepIntv=" + keepIntv)
                .add("scheme='" + scheme + "'")
//                .add("talkSendProtoVer=" + talkSendProtoVer)
                .add("inputAudioCfg=" + inputAudioCfg)
                .add("audioCfg=" + audioCfg)
                .add("rtspSrc=" + rtspSrc)
                .add("timedToken='" + timedToken + "'")
                .add("trace=" + trace)
                .toString();
    }
}
