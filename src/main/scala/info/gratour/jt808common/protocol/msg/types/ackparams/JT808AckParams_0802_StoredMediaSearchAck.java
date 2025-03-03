/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import java.util.Arrays;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808MediaInfo;
import info.gratour.jtcommon.JTMsgId;

/**
 * 存储媒体检索应答参数(0x0802)
 */
@JTMsgId(JT808MsgConsts.STORED_MEDIA_SEARCH_ACK_0802)
@Expose
public class JT808AckParams_0802_StoredMediaSearchAck implements JT808AckParams, Cloneable {

    private JT808MediaInfo[] mediaInfos;

    /**
     * 获取媒体信息列表
     * @return 媒体信息列表
     */
    public JT808MediaInfo[] getMediaInfos() {
        return mediaInfos;
    }

    /**
     * 设置媒体信息列表
     * @param mediaInfos 媒体信息列表
     */
    public void setMediaInfos(JT808MediaInfo[] mediaInfos) {
        this.mediaInfos = mediaInfos;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808AckParams_0802_StoredMediaSearchAck source) {
        if (source.mediaInfos != null) {
            this.mediaInfos = new JT808MediaInfo[source.mediaInfos.length];
            for (int i = 0; i < this.mediaInfos.length; i++) {
                this.mediaInfos[i] = source.mediaInfos[i].clone();
            }
        } else
            this.mediaInfos = null;
    }

    @Override
    public JT808AckParams_0802_StoredMediaSearchAck clone() {
        JT808AckParams_0802_StoredMediaSearchAck r = new JT808AckParams_0802_StoredMediaSearchAck();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0802_StoredMediaSearchAck{" +
                "mediaInfos=" + Arrays.toString(mediaInfos) +
                '}';
    }
}
