package com.lucendar.strm.common.strm;

import com.lucendar.strm.common.StrmMsg;
import com.lucendar.strm.common.StrmMsgs;

import java.util.StringJoiner;

/**
 * 远程录像回放控制请求实体
 */
public class ReplayStrmCtrlReq implements StrmMsg, StrmCtrlReq {

    /**
     * 控制命令：开始回放。成功执行该命令后，服务端向客户端推送`act`为`resumed`的流媒体状态通知
     */
    public static final byte CTRL__PLAY = 0;

    /**
     * 控制命令：暂停回放。成功执行该命令后，服务端向客户端推送`act`为`paused`的流媒体状态通知
     */
    public static final byte CTRL__PAUSE = 1;

    /**
     * 控制命令：结束回放。成功执行该命令后，服务端向客户端推送`act`为`closed`的流媒体状态通知
     */
    public static final byte CTRL__STOP = 2;

    /**
     * 控制命令：快进回放
     */
    public static final byte CTRL__FAST_FORWARD = 3;

    /**
     * 控制命令：关键帧快退回放
     */
    public static final byte CTRL__KEY_FRAME_BACKWARD = 4;

    /**
     * 控制命令：拖动回放
     */
    public static final byte CTRL__SEEK = 5;

    /**
     * 控制命令：关键帧播放
     */
    public static final byte CTRL__KEY_FRAME_PLAY = 6;

    /**
     * 快进或快退倍数：(忽略、不可用)
     */
    public static final byte SPEED_FACTOR__IGNORED = 0;

    /**
     * 快进或快退倍数：1倍
     */
    public static final byte SPEED_FACTOR__1x = 1;

    /**
     * 快进或快退倍数：2倍
     */
    public static final byte SPEED_FACTOR__2x = 2;

    /**
     * 快进或快退倍数：4倍
     */
    public static final byte SPEED_FACTOR__4x = 3;

    /**
     * 快进或快退倍数：8倍
     */
    public static final byte SPEED_FACTOR__8x = 4;

    /**
     * 快进或快退倍数：16倍
     */
    public static final byte SPEED_FACTOR__16x = 5;


    private String reqId;
    private byte ctrl;
    private Byte factor;
    private long time;
    private ServerHint strmServerHint;

    /**
     * 无参构造函数
     */
    public ReplayStrmCtrlReq() {
    }

    /**
     * 全参构造函数
     *
     * @param reqId          远程录像回放请求ID
     * @param ctrl           控制命令，为 CTRL__xxxx 系列常量之一
     * @param factor         快进或快退倍数，为 SPEED_FACTOR__xxxx 系列常量之一
     * @param time           拖动回放的时间点，注意，此属性为Epoch millis-seconds，仅当 `ctrl` 为 CTRL__SEEK 时有意义
     * @param strmServerHint Stream server hint, 内部使用
     */
    public ReplayStrmCtrlReq(String reqId, byte ctrl, Byte factor, long time, ServerHint strmServerHint) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.factor = factor;
        this.time = time;
        this.strmServerHint = strmServerHint;
    }


    /**
     * 构造函数
     *
     * @param reqId  远程录像回放请求ID
     * @param ctrl   控制命令，为 CTRL__xxxx 系列常量之一
     * @param factor 快进或快退倍数代码，为 SPEED_FACTOR__xxxx 系列常量之一
     * @param time   拖动回放的时间点，注意，此属性为Epoch millis-seconds，仅当 `ctrl` 为 CTRL__SEEK 时有意义
     */
    public ReplayStrmCtrlReq(String reqId, byte ctrl, Byte factor, long time) {
        this.reqId = reqId;
        this.ctrl = ctrl;
        this.factor = factor;
        this.time = time;
    }

    @Override
    public boolean isLive() {
        return false;
    }

    /**
     * 取远程录像回放请求ID
     *
     * @return 远程录像回放请求ID
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置远程录像回放请求ID
     *
     * @param reqId 远程录像回放请求ID
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 取控制命令，值域为 CTRL__xxxx 系列常量之一
     *
     * @return 控制命令
     */
    public byte getCtrl() {
        return ctrl;
    }

    /**
     * 设置控制命令
     *
     * @param ctrl 控制命令，值域为 CTRL__xxxx 系列常量之一
     */
    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 取快进或快退倍数代码，为 SPEED_FACTOR__xxxx 系列常量之一
     *
     * @return 快进或快退倍数代码
     */
    public Byte getFactor() {
        return factor;
    }

    /**
     * 设置快进或快退倍数代码
     *
     * @param factor 快进或快退倍数代码，为 SPEED_FACTOR__xxxx 系列常量之一
     */
    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    /**
     * 取拖动回放的时间点
     *
     * @return 拖动回放的时间点，epoch millis-seconds，仅当 `ctrl` 为 CTRL__SEEK 时有意义
     */
    public long getTime() {
        return time;
    }

    /**
     * 设置拖动回放的时间点
     *
     * @param time 拖动回放的时间点，epoch millis，仅当 `ctrl` 为 CTRL__SEEK 时有意义
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Get stream server hint. For internal use only.
     *
     * @return Stream server hint.
     */
    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    /**
     * Set stream server hint. For internal use only.
     *
     * @param strmServerHint Stream server hint.
     */
    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReplayStrmCtrlReq.class.getSimpleName() + "[", "]")
                .add("reqId='" + reqId + "'")
                .add("ctrl=" + ctrl)
                .add("factor=" + factor)
                .add("time=" + time)
                .add("strmServerHint=" + strmServerHint)
                .toString();
    }

    @Override
    public int msgId() {
        return StrmMsgs.STRM_MSG__ReplayStrmCtrlReq;
    }
}
