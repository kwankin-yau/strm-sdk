/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.checkerframework.checker.nullness.qual.NonNull;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT1078AvRes;
import info.gratour.jtcommon.JTMsgId;

/**
 * 查询音视频资源列表指令应答参数
 */
@JTMsgId(JT1078MsgConsts.QRY_AV_RES_ACK_1205)
@Expose
public class JT1078AckParams_1205_QryAvResAck implements JT808AckParams, Cloneable {

    private JT1078AvRes[] resList;

    /**
     * 取音视频资源列表
     * @return 音视频资源列表
     */
    @NonNull
    public JT1078AvRes[] getResList() {
        return resList;
    }

    /**
     * 设置音视频资源列表
     * @param resList 音视频资源列表
     */
    public void setResList(@NonNull JT1078AvRes[] resList) {
        this.resList = resList;
    }

    /**
     * 设置音视频资源列表
     * @param resList 音视频资源列表
     */
    public void setResList(List<JT1078AvRes> resList) {
        if (resList != null)
            this.resList = resList.toArray(new JT1078AvRes[0]);
        else
            this.resList = null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078AckParams_1205_QryAvResAck.class.getSimpleName() + "[", "]")
                .add("resList=" + Arrays.toString(resList))
                .toString();
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT1078AckParams_1205_QryAvResAck source) {
        if (source.resList != null) {
            resList = new JT1078AvRes[source.resList.length];
            for (int i = 0; i < source.resList.length; i++) {
                resList[i] = source.resList[i].clone();
            }
        } else
            resList = null;
    }

    @Override
    public JT1078AckParams_1205_QryAvResAck clone() {
        JT1078AckParams_1205_QryAvResAck r = new JT1078AckParams_1205_QryAvResAck();
        r.assignFrom(this);
        return r;
    }
}
