package com.lucendar.gnss.sdk.evtsrc;

/**
 * GNSS事件类型
 */
public enum GnssEventType {


    /**
     * 终端命令, (TermCmdStateChanged)
     */
    cmd,

    /**
     * 音视频上传, (AvUploadNotif)
     */
    av_upload,

    /**
     * 流媒体, (StrmMediaNotif)
     */
    strm;

    /**
     * 尝试从字符串解析事件类型
     * @param eventType 事件类型字符串
     * @return 事件类型, null 表示解析失败
     */
    public static GnssEventType tryParse(String eventType) {
        switch (eventType) {
            case "cmd":
                return cmd;

            case "av_upload":
                return av_upload;

            case "strm":
                return strm;

            default:
                return null;
        }
    }
}
