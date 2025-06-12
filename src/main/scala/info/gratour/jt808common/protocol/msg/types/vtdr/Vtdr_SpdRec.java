/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 行驶速度记录
 */
public class Vtdr_SpdRec implements Cloneable {

    private String startTime;
    private List<Vtdr_SpdAndStatus> spdAndStatus;

    /**
     * 取开始时间, yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间, yyyy-MM-dd HH:mm:ss
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取速度与状态列表
     * @return 速度与状态列表
     */
    public List<Vtdr_SpdAndStatus> getSpdAndStatus() {
        return spdAndStatus;
    }

    /**
     * 设置速度与状态列表
     * @param spdAndStatus 速度与状态列表
     */
    public void setSpdAndStatus(List<Vtdr_SpdAndStatus> spdAndStatus) {
        this.spdAndStatus = spdAndStatus;
    }

    /**
     * 添加速度与状态
     * @param spdAndStatus 速度与状态
     */
    public void addSpdAndStatus(Vtdr_SpdAndStatus spdAndStatus) {
        if (this.spdAndStatus == null)
            this.spdAndStatus = new ArrayList<>();

        this.spdAndStatus.add(spdAndStatus);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_SpdRec source) {
        this.startTime = source.startTime;
        if (source.spdAndStatus != null) {
            this.spdAndStatus = new ArrayList<>();

            for (Vtdr_SpdAndStatus e : source.spdAndStatus)
                this.spdAndStatus.add(e.clone());
        } else
            this.spdAndStatus = null;
    }

    @Override
    public Vtdr_SpdRec clone() {
        Vtdr_SpdRec r = new Vtdr_SpdRec();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_SpdRec.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("spdAndStatus=" + spdAndStatus)
                .toString();
    }
}
