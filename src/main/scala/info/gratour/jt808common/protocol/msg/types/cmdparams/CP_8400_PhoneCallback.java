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
 * 电话回拨(0x8400)命令参数
 */
@JTMsgId(JT808MsgConsts.PHONE_CALLBACK_8400)
@Expose
public class CP_8400_PhoneCallback implements JT808CmdParams {

    /**
     * 操作类型：通话
     */
    public static final int ACTION__TALK = 0;

    /**
     * 操作类型：监听
     */
    public static final int ACTION__LISTEN = 1;

    private byte action;
    private String phoneNo;

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
     * 获取电话号码
     * @return 电话号码
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置电话号码
     * @param phoneNo 电话号码
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "CP_8400_PhoneCallback{" +
                "action=" + action +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public CP_8400_PhoneCallback clone() {
        try {
            return (CP_8400_PhoneCallback) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
