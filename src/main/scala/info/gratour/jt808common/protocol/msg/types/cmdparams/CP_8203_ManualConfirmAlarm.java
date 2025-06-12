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
 * 人工确认报警(0x8203)命令参数
 */
@JTMsgId(JT808MsgConsts.MANUAL_CONFIRM_ALARM_8203)
@Expose
public class CP_8203_ManualConfirmAlarm implements JT808CmdParams {

    private int ackSeqNo;
    private int confirmAlarmTypes;

    /**
     * 获取确认序号
     * @return 确认序号
     */
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置确认序号
     * @param ackSeqNo 确认序号
     */
    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 获取确认报警类型
     * @return 确认报警类型
     */
    public int getConfirmAlarmTypes() {
        return confirmAlarmTypes;
    }

    /**
     * 设置确认报警类型
     * @param confirmAlarmTypes 确认报警类型
     */
    public void setConfirmAlarmTypes(int confirmAlarmTypes) {
        this.confirmAlarmTypes = confirmAlarmTypes;
    }

    @Override
    public String toString() {
        return "CP_8203_ManualConfirmAlarm{" +
                "ackSeqNo=" + ackSeqNo +
                ", confirmAlarmTypes=" + confirmAlarmTypes +
                '}';
    }

    @Override
    public CP_8203_ManualConfirmAlarm clone() {
        try {
            return (CP_8203_ManualConfirmAlarm) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
