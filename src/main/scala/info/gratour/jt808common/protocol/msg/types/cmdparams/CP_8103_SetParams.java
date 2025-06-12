/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.Map;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置参数(0x8103)命令参数
 */
@JTMsgId(JT808MsgConsts.SET_PARAMS_8103)
@Expose
public class CP_8103_SetParams implements JT808CmdParams {

    private Map<String, Object> params;

    /**
     * 获取参数集
     * @return 参数集
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * 设置参数集
     * @param params 参数集
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "CP_8103_SetParams{" +
                "params=" + params +
                '}';
    }

    @Override
    public CP_8103_SetParams clone() {
        try {
            return (CP_8103_SetParams) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
