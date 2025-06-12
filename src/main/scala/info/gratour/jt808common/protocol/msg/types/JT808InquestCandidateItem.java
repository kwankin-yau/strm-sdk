/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import com.lucendar.strm.common.types.Expose;

/**
 * JT/T 808 提问下发候选答案项
 */
@Expose
public class JT808InquestCandidateItem implements Cloneable {

    private short candidateId;
    private String candidate;

    /**
     * 取候选答案 ID
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

    /**
     * 取候选答案
     * @return 候选答案
     */
    public String getCandidate() {
        return candidate;
    }

    /**
     * 设置候选答案
     * @param candidate 候选答案
     */
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    @Override
    public JT808InquestCandidateItem clone() {
        try {
            return (JT808InquestCandidateItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808MsgInquestCandidateItem{" +
                "candidateId=" + candidateId +
                ", candidate='" + candidate + '\'' +
                '}';
    }
}
