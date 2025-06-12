/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

/**
 * 特殊报警视频参数(0x0079)
 */
public class TP_0079_SpecialAlarmVideoParams {
    private byte videoStoreQuota;
    private short recordDuration;
    private byte tagTime;

    /**
     * 取视频存储配额
     * @return 视频存储配额
     */
    public byte getVideoStoreQuota() {
        return videoStoreQuota;
    }

    /**
     * 设置视频存储配额
     * @param videoStoreQuota 视频存储配额
     */
    public void setVideoStoreQuota(byte videoStoreQuota) {
        this.videoStoreQuota = videoStoreQuota;
    }

    /**
     * 取录像时长，分钟
     * @return 录像时长
     */
    public short getRecordDuration() {
        return recordDuration;
    }

    /**
     * 设置录像时长，分钟
     * @param recordDuration 录像时长
     */
    public void setRecordDuration(short recordDuration) {
        this.recordDuration = recordDuration;
    }

    /**
     * 取特殊报警发生前进行标记的录像时间，分钟
     * @return 标记时间
     */
    public byte getTagTime() {
        return tagTime;
    }

    /**
     * 设置特殊报警发生前进行标记的录像时间，分钟
     * @param tagTime 标记时间
     */
    public void setTagTime(byte tagTime) {
        this.tagTime = tagTime;
    }

    @Override
    public String toString() {
        return "TP_0079_SpecialAlarmVideoParams{" +
                "videoStoreQuota=" + videoStoreQuota +
                ", recordDuration=" + recordDuration +
                ", tagTime=" + tagTime +
                '}';
    }
}
