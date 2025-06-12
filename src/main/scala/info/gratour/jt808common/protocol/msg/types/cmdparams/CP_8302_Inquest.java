/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.Arrays;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808InquestCandidateItem;
import info.gratour.jtcommon.JTMsgId;

/**
 * 提问下发(0x8302)命令参数
 */
@JTMsgId(JT808MsgConsts.INQUEST_8302)
@Expose
public class CP_8302_Inquest implements JT808CmdParams {
    private byte flags;
    private String question;
    private JT808InquestCandidateItem[] candidates;

    /**
     * 获取标志位
     * @return 标志位
     */
    public byte getFlags() {
        return flags;
    }

    /**
     * 设置标志位
     * @param flags 标志位
     */
    public void setFlags(byte flags) {
        this.flags = flags;
    }

    /**
     * 获取问题
     * @return 问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问题
     * @param question 问题
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取候选答案列表
     * @return 候选答案列表
     */
    public JT808InquestCandidateItem[] getCandidates() {
        return candidates;
    }

    /**
     * 设置候选答案列表
     * @param candidates 候选答案列表
     */
    public void setCandidates(JT808InquestCandidateItem[] candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "CP_8302_Inquest{" +
                "flags=" + flags +
                ", question='" + question + '\'' +
                ", candidates=" + Arrays.toString(candidates) +
                '}';
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_8302_Inquest source) {
        this.flags = source.flags;
        this.question = source.question;
        if (source.candidates != null) {
            this.candidates = new JT808InquestCandidateItem[source.candidates.length];
            for (int i = 0; i < this.candidates.length; i++)
                this.candidates[i] = source.candidates[i].clone();
        } else
            this.candidates = null;
    }

    @Override
    public CP_8302_Inquest clone() {
        CP_8302_Inquest r = new CP_8302_Inquest();
        r.assignFrom(this);
        return r;
    }
}
