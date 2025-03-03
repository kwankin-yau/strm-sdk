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
 * 采集状态信号配置应答数据(06H)
 */
@Expose
public class JT808Vtdr_StatusSignalConfig_06 implements JT808VtdrDataBlock {

    private String dateTime;
    private List<Vtdr_Status> status;

    /**
     * 取记录仪时间, yyyy-MM-dd HH:mm:ss
     * @return 记录仪时间
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 设置记录仪时间, yyyy-MM-dd HH:mm:ss
     * @param dateTime 记录仪时间
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 取状态信号配置列表
     * @return 状态信号配置列表
     */
    public List<Vtdr_Status> getStatus() {
        return status;
    }

    /**
     * 设置状态信号配置列表
     * @param status 状态信号配置列表
     */
    public void setStatus(List<Vtdr_Status> status) {
        this.status = status;
    }

    /**
     * 取是否有状态信号配置
     * @return 是否有状态信号配置
     */ 
    public boolean hasStatus() {
        return status != null && !status.isEmpty();
    }

    /**
     * 添加状态信号配置
     * @param status 状态信号配置
     */
    public void addStatus(Vtdr_Status status) {
        if (this.status == null)
            this.status = new ArrayList<>();

        this.status.add(status);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808Vtdr_StatusSignalConfig_06 source) {
        this.dateTime = source.dateTime;
        if (source.status != null) {
            this.status = new ArrayList<>();

            for (Vtdr_Status e : source.status)
                this.status.add(e.clone());
        } else
            this.status = null;
    }

    @Override
    public JT808Vtdr_StatusSignalConfig_06 clone() {
        JT808Vtdr_StatusSignalConfig_06 r = new JT808Vtdr_StatusSignalConfig_06();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_StatusSignalConfig_06.class.getSimpleName() + "[", "]")
                .add("dateTime='" + dateTime + "'")
                .add("status=" + status)
                .toString();
    }
}
