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
 * 采集事故疑点记录应答数据(10H)
 */
@Expose
public class JT808Vtdr_AccidentPoints_10 implements JT808VtdrDataBlock {

    private List<Vtdr_AccidentPoint> accidentPoints;

    /**
     * 取事故疑点记录
     * @return 事故疑点记录
     */
    public List<Vtdr_AccidentPoint> getAccidentPoints() {
        return accidentPoints;
    }

    /**
     * 设置事故疑点记录
     * @param accidentPoints 事故疑点记录
     */
    public void setAccidentPoints(List<Vtdr_AccidentPoint> accidentPoints) {
        this.accidentPoints = accidentPoints;
    }

    /**
     * 添加事故疑点记录
     * @param accidentPoint 事故疑点记录
     */
    public void addAccidentPoint(Vtdr_AccidentPoint accidentPoint) {
        if (this.accidentPoints == null)
            this.accidentPoints = new ArrayList<>();

        this.accidentPoints.add(accidentPoint);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808Vtdr_AccidentPoints_10 source) {
        if (source.accidentPoints != null) {
            this.accidentPoints = new ArrayList<>();

            for (Vtdr_AccidentPoint p : source.accidentPoints) {
                this.accidentPoints.add(p.clone());
            }
        } else
            this.accidentPoints = null;
    }

    @Override
    public JT808Vtdr_AccidentPoints_10 clone() {
        JT808Vtdr_AccidentPoints_10 r = new JT808Vtdr_AccidentPoints_10();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_AccidentPoints_10.class.getSimpleName() + "[", "]")
                .add("accidentPoints=" + accidentPoints)
                .toString();
    }
}
