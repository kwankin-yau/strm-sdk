/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 音频记录控制(0x8804)命令参数
 */
@JTMsgId(JT808MsgConsts.AUDIO_RECORD_CTRL_8804)
@Expose
public class CP_8804_AudioRecordCtrl implements JT808CmdParams {

    private byte action;
    private int recordTime;
    private byte saveFlag;
    private byte sampleFrequency;

    /**
     * 获取动作
     * @return 动作
     */
    public byte getAction() {
        return action;
    }

    /**
     * 设置动作
     * @param action 动作
     */
    public void setAction(byte action) {
        this.action = action;
    }

    /**
     * 获取录音时长
     * @return 录音时长
     */
    public int getRecordTime() {
        return recordTime;
    }

    /**
     * 设置录音时长
     * @param recordTime 录音时长
     */
    public void setRecordTime(int recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 获取保存标志
     * @return 保存标志
     */
    public byte getSaveFlag() {
        return saveFlag;
    }

    /**
     * 设置保存标志
     * @param saveFlag 保存标志
     */
    public void setSaveFlag(byte saveFlag) {
        this.saveFlag = saveFlag;
    }

    /**
     * 获取采样频率
     * @return 采样频率
     */
    public byte getSampleFrequency() {
        return sampleFrequency;
    }

    /**
     * 设置采样频率
     * @param sampleFrequency 采样频率
     */
    public void setSampleFrequency(byte sampleFrequency) {
        this.sampleFrequency = sampleFrequency;
    }

    @Override
    public String toString() {
        return "CP_8804_AudioRecordCtrl{" +
                "action=" + action +
                ", recordTime=" + recordTime +
                ", saveFlag=" + saveFlag +
                ", sampleFrequency=" + sampleFrequency +
                '}';
    }

    @Override
    public CP_8804_AudioRecordCtrl clone() {
        try {
            return (CP_8804_AudioRecordCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
