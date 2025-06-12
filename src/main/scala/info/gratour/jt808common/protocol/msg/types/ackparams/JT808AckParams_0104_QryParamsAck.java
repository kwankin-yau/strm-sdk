/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import java.util.HashMap;
import java.util.Map;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询参数应答参数(0x0104)
 */
@JTMsgId(JT808MsgConsts.QRY_PARAMS_ACK_0104)
@Expose
public class JT808AckParams_0104_QryParamsAck implements JT808AckParams, Cloneable {



    private Map<String, Object> params = new HashMap<>();

    /**
     * 获取参数
     * @return 参数
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * 设置参数
     * @param params 参数
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0104_QryParamsAck{" +
                "params=" + params +
                '}';
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808AckParams_0104_QryParamsAck source) {
        if (source.params != null) {
            this.params = new HashMap<>();
            this.params.putAll(source.params);
        } else
            this.params = null;
    }

    @Override
    public JT808AckParams_0104_QryParamsAck clone() {
        JT808AckParams_0104_QryParamsAck r = new JT808AckParams_0104_QryParamsAck();
        r.assignFrom(this);
        return r;
    }
}
