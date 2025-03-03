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
import info.gratour.jt808common.protocol.msg.types.JT808PhoneBookEntry;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置电话簿(0x8401)命令参数
 */
@JTMsgId(JT808MsgConsts.SET_UP_PHONE_BOOK_8401)
@Expose
public class CP_8401_SetUpPhoneBook implements JT808CmdParams {

    private byte action;
    private JT808PhoneBookEntry[] entries;

    /**
     * 获取操作类型
     * @return 操作类型
     */
    public byte getAction() {
        return action;
    }

    /**
     * 设置操作类型
     * @param action 操作类型
     */
    public void setAction(byte action) {
        this.action = action;
    }

    /**
     * 获取电话簿条目列表
     * @return 电话簿条目列表
     */
    public JT808PhoneBookEntry[] getEntries() {
        return entries;
    }

    /**
     * 设置电话簿条目列表
     * @param entries 电话簿条目列表
     */
    public void setEntries(JT808PhoneBookEntry[] entries) {
        this.entries = entries;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_8401_SetUpPhoneBook source) {
        this.action = source.action;
        if (source.entries != null) {
            this.entries = new JT808PhoneBookEntry[source.entries.length];
            for (int i = 0; i < this.entries.length; i++) {
                this.entries[i] = source.entries[i].clone();
            }
        } else
            this.entries = null;
    }

    @Override
    public CP_8401_SetUpPhoneBook clone() {
        CP_8401_SetUpPhoneBook r = new CP_8401_SetUpPhoneBook();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "CP_8401_SetUpPhoneBook{" +
                "action=" + action +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }
}
