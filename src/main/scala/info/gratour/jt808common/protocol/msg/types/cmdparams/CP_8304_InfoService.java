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
 * 信息服务(0x8304)命令参数
 */
@JTMsgId(JT808MsgConsts.INFO_SERVICE_8304)
@Expose
public class CP_8304_InfoService implements JT808CmdParams {

    private byte infoType;
    private String info;

    /**
     * 获取信息类型
     * @return 信息类型
     */
    public byte getInfoType() {
        return infoType;
    }

    /**
     * 设置信息类型
     * @param infoType 信息类型
     */
    public void setInfoType(byte infoType) {
        this.infoType = infoType;
    }

    /**
     * 获取信息
     * @return 信息
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置信息
     * @param info 信息
     */
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CP_8304_InfoService{" +
                "infoType=" + infoType +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public CP_8304_InfoService clone() {
        try {
            return (CP_8304_InfoService) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
