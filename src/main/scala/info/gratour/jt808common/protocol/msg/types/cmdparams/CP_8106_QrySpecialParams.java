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
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询特殊参数(0x8106)命令参数
 */
@JTMsgId(JT808MsgConsts.QRY_SPECIAL_PARAMS_8106)
@Expose
public class CP_8106_QrySpecialParams implements JT808CmdParams {

    private String[] paramIds;

    /**
     * 获取参数ID列表
     * @return 参数ID列表
     */
    public String[] getParamIds() {
        return paramIds;
    }

    /**
     * 设置参数ID列表
     * @param paramIds 参数ID列表
     */
    public void setParamIds(String[] paramIds) {
        this.paramIds = paramIds;
    }

    @Override
    public String toString() {
        return "CP_8106_QrySpecialParams{" +
                "paramIds=" + Arrays.toString(paramIds) +
                '}';
    }

    @Override
    public CP_8106_QrySpecialParams clone() {
        try {
            return (CP_8106_QrySpecialParams) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
