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
 * 采集行驶速度记录应答数据(08H)
 */
@Expose
public class JT808Vtdr_SpdRecords_08 implements JT808VtdrDataBlock {

    private List<Vtdr_SpdRec> spdRecords;

    /**
     * 取行驶速度记录列表
     * @return 行驶速度记录列表
     */
    public List<Vtdr_SpdRec> getSpdRecords() {
        return spdRecords;
    }

    /**
     * 设置行驶速度记录列表
     * @param spdRecords 行驶速度记录列表
     */
    public void setSpdRecords(List<Vtdr_SpdRec> spdRecords) {
        this.spdRecords = spdRecords;
    }

    /**
     * 添加行驶速度记录
     * @param spdRec 行驶速度记录
     */
    public void addSpdRec(Vtdr_SpdRec spdRec) {
        if (this.spdRecords == null)
            this.spdRecords = new ArrayList<>();

        this.spdRecords.add(spdRec);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808Vtdr_SpdRecords_08 source) {
        if (source.spdRecords != null) {
            this.spdRecords = new ArrayList<>();

            for (Vtdr_SpdRec e : source.spdRecords)
                this.spdRecords.add(e.clone());
        } else
            this.spdRecords = null;
    }

    @Override
    public JT808Vtdr_SpdRecords_08 clone() {
        JT808Vtdr_SpdRecords_08 r = new JT808Vtdr_SpdRecords_08();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_SpdRecords_08.class.getSimpleName() + "[", "]")
                .add("spdRecords=" + spdRecords)
                .toString();
    }
}
