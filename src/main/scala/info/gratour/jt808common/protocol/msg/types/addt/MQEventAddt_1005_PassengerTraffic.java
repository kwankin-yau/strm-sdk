/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

/**
 * 乘客流量事件(0x1005)
 */
public class MQEventAddt_1005_PassengerTraffic implements MQEventAddt {

    private long startTime;
    private long endTime;
    private int getOnCount;
    private int getOffCount;

    /**
     * 获取开始时间
     * @return 开始时间
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     * @return 结束时间
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取上车人数
     * @return 上车人数
     */
    public int getGetOnCount() {
        return getOnCount;
    }

    /**
     * 设置上车人数
     * @param getOnCount 上车人数
     */
    public void setGetOnCount(int getOnCount) {
        this.getOnCount = getOnCount;
    }

    /**
     * 获取下车人数
     * @return 下车人数
     */
    public int getGetOffCount() {
        return getOffCount;
    }

    /**
     * 设置下车人数
     * @param getOffCount 下车人数
     */
    public void setGetOffCount(int getOffCount) {
        this.getOffCount = getOffCount;
    }

    @Override
    public String toString() {
        return "MQEventAddt_1005_PassengerTraffic{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", getOnCount=" + getOnCount +
                ", getOffCount=" + getOffCount +
                '}';
    }
}
