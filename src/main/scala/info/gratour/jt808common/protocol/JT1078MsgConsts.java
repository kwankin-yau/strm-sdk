/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol;

/**
 * JT1078 消息常量
 */
public class JT1078MsgConsts {

    /**
     * 查询音视频属性消息ID
     */
    public static final int QRY_AV_ATTRS_9003 = 0x9003;

    /**
     * 查询音视频属性消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID__QRY_AV_ATTRS_9003 = "9003";


    /**
     * 查询音视频属性应答消息ID
     */
    public static final int QRY_AV_ATTRS_ACK_1003 = 0x1003;

    /**
     * 查询音视频属性应答消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID__QRY_AV_ATTRS_ACK_1003 = "1003";

    /**
     * 乘客流量消息ID
     */
    public static final int PASSENGER_TRAFFIC_1005 = 0x1005;

    /**
     * 乘客流量消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID__PASSENGER_TRAFFIC_1005 = "1005";

    /**
     * 实时音视频请求消息ID
     */ 
    public static final int LIVE_AV_REQ_9101 = 0x9101;

    /**
     * 实时音视频请求消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_LIVE_AV_REQ_9101 = "9101";

    /**
     * 实时音视频控制消息ID
     */
    public static final int LIVE_AV_CTRL_9102 = 0x9102;

    /**
     * 实时音视频控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_LIVE_AV_CTRL_9102 = "9102";

    /**
     * 实时音视频状态消息ID
     */
    public static final int LIVE_AV_STATUS_9105 = 0x9105;

    /**
     * 实时音视频状态消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_LIVE_AV_STATUS_9105 = "9105";

    /**
     * 查询音视频资源消息ID
     */
    public static final int QRY_AV_RES_9205 = 0x9205;

    /**
     * 查询音视频资源消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_QRY_AV_RES_9205 = "9205";

    /**
     * 查询音视频资源应答消息ID
     */
    public static final int QRY_AV_RES_ACK_1205 = 0x1205;

    /**
     * 查询音视频资源应答消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_QRY_AV_RES_ACK_1205 = "1205";

    /**
     * 音视频回放请求消息ID
     */
    public static final int REPLAY_AV_REQ_9201 = 0x9201;

    /**
     * 音视频回放请求消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_REPLAY_AV_REQ_9201 = "9201";


    /**
     * 音视频回放控制消息ID
     */
    public static final int REPLAY_AV_CTRL_9202 = 0x9202;

    /**
     * 音视频回放控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_REPLAY_AV_CTRL_9202 = "9202";

    /**
     * 音视频上传请求消息ID
     */
    public static final int AV_UPLOAD_REQ_9206 = 0x9206;

    /**
     * 音视频上传请求消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_AV_UPLOAD_REQ_9206 = "9206";

    /**
     * 音视频上传完成消息ID
     */
    public static final int AV_UPLOAD_COMPLETED_1206 = 0x1206;

    /**
     * 音视频上传完成消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_AV_UPLOAD_COMPLETED_1206 = "1206";

    /**
     * 音视频上传控制消息ID
     */
    public static final int AV_UPLOAD_CTRL_9207 = 0x9207;

    /**
     * 音视频上传控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_AV_UPLOAD_CTRL_9207 = "9207";


    /**
     * 云台转动消息ID
     */
    public static final int PTZ_TURN_9301 = 0x9301;

    /**
     * 云台转动消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_PTZ_TURN_9301 = "9301";

    /**
     * 云台焦距调整控制消息ID
     */
    public static final int PTZ_FOCUSING_9302 = 0x9302;

    /**
     * 云台焦距调整控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_PTZ_FOCUSING_9302 = "9302";

    /**
     * 云台光圈调整控制消息ID
     */
    public static final int PTZ_IRIS_CTRL_9303 = 0x9303;

    /**
     * 云台光圈调整控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_PTZ_IRIS_CTRL_9303 = "9303";

    /**
     * 云台雨刮器控制消息ID
     */
    public static final int PTZ_WIPER_CTRL_9304 = 0x9304;

    /**
     * 云台雨刮器控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_PTZ_WIPER_CTRL_9304 = "9304";

    /**
     * 云台红外补光灯控制消息ID
     */
    public static final int PTZ_FILL_LIGHT_CTRL_9305 = 0x9305;

    /**
     * 云台红外补光灯控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_PTZ_FILL_LIGHT_CTRL_9305 = "9305";

    /**
     * 云台变倍调整控制消息ID
     */
    public static final int PTZ_ZOOM_CTRL_9306 = 0x9306;

    /**
     * 云台变倍调整控制消息ID的HEX字符串
     */
    public static final String HEX_MSG_ID_PTZ_ZOOM_CTRL_9306 = "9306";
    
}
