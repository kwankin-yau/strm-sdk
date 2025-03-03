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

import com.lucendar.strm.common.types.Expose;

/**
 * 速度与状态日志
 */
@Expose
public class Vtdr_LogRec implements Cloneable {

    private byte spdState;
    private String startTime;
    private String endTime;
    private List<Vtdr_SpdLogEntry> spdLogEntries;

    /**
     * 取速度与状态, 0x01: 正常, 0x02: 异常
     * @return 速度与状态
     */
    public byte getSpdState() {
        return spdState;
    }

    /**
     * 设置速度与状态
     * @param spdState 速度与状态
     */
    public void setSpdState(byte spdState) {
        this.spdState = spdState;
    }

    /**
     * 取状态判断的开始时间, yyyy-MM-dd HH:mm:ss
     * @return 状态判断的开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置状态判断的开始时间, yyyy-MM-dd HH:mm:ss
     * @param startTime 状态判断的开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取状态判断的结束时间, yyyy-MM-dd HH:mm:ss
     * @return 状态判断的结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置状态判断的结束时间, yyyy-MM-dd HH:mm:ss
     * @param endTime 状态判断的结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取速度与状态日志条目列表
     * @return 速度与状态日志条目列表
     */
    public List<Vtdr_SpdLogEntry> getSpdLogEntries() {
        return spdLogEntries;
    }

    /**
     * 设置速度与状态日志条目列表
     * @param spdLogEntries 速度与状态日志条目列表
     */
    public void setSpdLogEntries(List<Vtdr_SpdLogEntry> spdLogEntries) {
        this.spdLogEntries = spdLogEntries;
    }

    /**
     * 添加速度与状态日志条目
     * @param entry 速度与状态日志条目
     */
    public void addSpdLogEntry(Vtdr_SpdLogEntry entry) {
        if (this.spdLogEntries == null)
            this.spdLogEntries = new ArrayList<>();

        this.spdLogEntries.add(entry);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_LogRec source) {
        this.spdState = source.spdState;
        this.startTime = source.startTime;
        this.endTime = source.endTime;

        if (source.spdLogEntries != null) {
            this.spdLogEntries = new ArrayList<>();

            for (Vtdr_SpdLogEntry e : source.spdLogEntries)
                this.spdLogEntries.add(e.clone());
        } else
            this.spdLogEntries = null;
    }

    @Override
    public Vtdr_LogRec clone() {
        try {
            return (Vtdr_LogRec) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_LogRec.class.getSimpleName() + "[", "]")
                .add("spdState=" + spdState)
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("spdLogEntries=" + spdLogEntries)
                .toString();
    }
}
