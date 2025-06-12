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
import info.gratour.jtcommon.JTMsgId;

/**
 * 拍照应答参数(0x0805)
 */
@JTMsgId(JT808MsgConsts.TAKE_PHOTO_ACK_0805)
@Expose
public class JT808AckParams_0805_TakePhotoAck implements JT808AckParams, Cloneable {

    private byte result;
    private long[] mediaIds;

    /**
     * 获取结果
     * @return 结果
     */
    public byte getResult() {
        return result;
    }

    /**
     * 设置结果
     * @param result 结果
     */
    public void setResult(byte result) {
        this.result = result;
    }

    /**
     * 获取媒体 ID 列表
     * @return 媒体 ID 列表
     */
    public long[] getMediaIds() {
        return mediaIds;
    }

    /**
     * 设置媒体 ID 列表
     * @param mediaIds 媒体 ID 列表
     */
    public void setMediaIds(long[] mediaIds) {
        this.mediaIds = mediaIds;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0805_TakePhotoAck{" +
                "result=" + result +
                ", mediaIds=" + Arrays.toString(mediaIds) +
                '}';
    }

    @Override
    public JT808AckParams_0805_TakePhotoAck clone() {
        try {
            return  (JT808AckParams_0805_TakePhotoAck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
