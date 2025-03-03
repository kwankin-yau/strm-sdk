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
 * 单个存储媒体请求(0x8805)命令参数
 */
@JTMsgId(JT808MsgConsts.SINGLE_STORED_MEDIA_REQ_8805)
@Expose
public class CP_8805_SingleStoredMediaReq implements JT808CmdParams {

    private int mediaId;
    private byte deleteFlag;

    /**
     * 获取媒体ID
     * @return 媒体ID
     */
    public int getMediaId() {
        return mediaId;
    }

    /**
     * 设置媒体ID
     * @param mediaId 媒体ID
     */
    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 获取删除标志
     * @return 删除标志
     */
    public byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标志
     * @param deleteFlag 删除标志
     */
    public void setDeleteFlag(byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "CP_8805_SingleStoredMediaReq{" +
                "mediaId=" + mediaId +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    @Override
    public CP_8805_SingleStoredMediaReq clone() {
        try {
            return (CP_8805_SingleStoredMediaReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
