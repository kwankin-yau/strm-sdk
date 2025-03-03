/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 提问应答应答参数(0x0302)
 */
@JTMsgId(JT808MsgConsts.INQUEST_ANSWER_0302)
@Expose
public class JT808AckParams_0302_InquestAnswer implements JT808AckParams, Cloneable {

    private short candidateId;

    /**
     * 获取候选答案 ID
     * @return 候选答案 ID
     */
    public short getCandidateId() {
        return candidateId;
    }

    /**
     * 设置候选答案 ID
     * @param candidateId 候选答案 ID
     */
    public void setCandidateId(short candidateId) {
        this.candidateId = candidateId;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0302_InquestAnswer{" +
                "candidateId=" + candidateId +
                '}';
    }

    @Override
    public JT808AckParams_0302_InquestAnswer clone() {
        try {
            return  (JT808AckParams_0302_InquestAnswer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
