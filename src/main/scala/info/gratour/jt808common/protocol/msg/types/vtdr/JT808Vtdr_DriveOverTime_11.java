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
 * 超速行驶记录应答数据 (11H)
 */
@Expose
public class JT808Vtdr_DriveOverTime_11 implements JT808VtdrDataBlock {
    private List<Vtdr_DriveOverTimeEntry> driveOverTimes;

    /**
     * 取超速行驶记录列表
     * @return 超速行驶记录列表
     */
    public List<Vtdr_DriveOverTimeEntry> getDriveOverTimes() {
        return driveOverTimes;
    }

    /**
     * 设置超速行驶记录列表
     * @param driveOverTimes 超速行驶记录列表
     */
    public void setDriveOverTimes(List<Vtdr_DriveOverTimeEntry> driveOverTimes) {
        this.driveOverTimes = driveOverTimes;
    }

    /**
     * 添加超速行驶记录
     * @param driveOverTimeEntry 超速行驶记录
     */
    public void addDriveOverTimeEntry(Vtdr_DriveOverTimeEntry driveOverTimeEntry) {
        if (this.driveOverTimes == null)
            this.driveOverTimes = new ArrayList<>();

        this.driveOverTimes.add(driveOverTimeEntry);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808Vtdr_DriveOverTime_11 source) {
        if (source.driveOverTimes != null) {
            this.driveOverTimes = new ArrayList<>();

            for (Vtdr_DriveOverTimeEntry e : source.driveOverTimes)
                this.driveOverTimes.add(e.clone());
        } else
            this.driveOverTimes = null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_DriveOverTime_11.class.getSimpleName() + "[", "]")
                .add("driveOverTimes=" + driveOverTimes)
                .toString();
    }

    @Override
    public JT808Vtdr_DriveOverTime_11 clone() {
        JT808Vtdr_DriveOverTime_11 r = new JT808Vtdr_DriveOverTime_11();
        r.assignFrom(this);
        return r;
    }
}
