/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 录像文件上传控制指令参数
 */
@JTMsgId(JT1078MsgConsts.AV_UPLOAD_CTRL_9207)
@Expose
public class CP_9207_AvUploadCtrl implements JT808CmdParams {

    /**
     * 暂停
     */
    public static final byte CTRL__PAUSE = 0;

    /**
     * 恢复
     */
    public static final byte CTRL__RESUME = 1;

    /**
     * 取消
     */
    public static final byte CTRL__CANCEL = 2;

    /**
     * The cmdId of the originate av upload cmd(9206). Used by application, JT1078 message codec does not use this
     * property.
     */
    private String origCmdId;

    /**
     * The JT808 message seqNo of the originate av upload cmd(9206).
     */
    private int origSeqNo;

    private byte ctrl;

    /**
     * 取原始录像上传的指令的ID。此属性由服务程序使用，JT1078消息编码器不使用此属性。
     * @return 原始录像上传的指令的ID。
     */
    public String getOrigCmdId() {
        return origCmdId;
    }

    /**
     * 设置原始录像上传的指令的ID。此属性由服务程序使用，JT1078消息编码器不使用此属性。
     * @param origCmdId 原始录像上传的指令的ID。
     */
    public void setOrigCmdId(String origCmdId) {
        this.origCmdId = origCmdId;
    }

    /**
     * 取原始录像上传的指令的JT808消息流水号。
     * @return 原始录像上传的指令的JT808消息流水号。
     */
    public int getOrigSeqNo() {
        return origSeqNo;
    }

    /**
     * 设置原始录像上传的指令的JT808消息流水号。
     * @param origSeqNo 原始录像上传的指令的JT808消息流水号。
     */
    public void setOrigSeqNo(int origSeqNo) {
        this.origSeqNo = origSeqNo;
    }

    /**
     * 取上传控制
     * @return 上传控制
     */
    public byte getCtrl() {
        return ctrl;
    }

    /**
     * 设置上传控制
     * @param ctrl 上传控制
     */
    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * 取原始录像上传的指令的ID。
     * @return 原始录像上传的指令的ID。
     */
    public String id() {
        return origCmdId;
    }

    /**
     * 设置原始录像上传的指令的ID。
     * @param value 原始录像上传的指令的ID。
     */
    public void id(String value) {
        this.origCmdId = value;
    }

    /**
     * 取原始录像上传的指令的JT808消息流水号。
     * @return 原始录像上传的指令的JT808消息流水号。
     */
    public int origSeqNo() {
        return origSeqNo;
    }

    /**
     * 设置原始录像上传的指令的JT808消息流水号。
     * @param value 原始录像上传的指令的JT808消息流水号。
     */
    public void origSeqNo(int value) {
        this.origSeqNo = value;
    }

    /**
     * 取上传控制
     * @return 上传控制
     */
    public int ctrl() {
        return ctrl;
    }

    /**
     * 设置上传控制
     * @param value 上传控制
     */
    public void ctrl(int value) {
        this.ctrl = (byte) value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9207_AvUploadCtrl.class.getSimpleName() + "[", "]")
                .add("origCmdId='" + origCmdId + "'")
                .add("origSeqNo=" + origSeqNo)
                .add("ctrl=" + ctrl)
                .toString();
    }

    @Override
    public CP_9207_AvUploadCtrl clone() {
        try {
            return (CP_9207_AvUploadCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
