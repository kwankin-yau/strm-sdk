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
 * 采集记录仪外部供电记录应答数据(13H)
 */
@Expose
public class JT808Vtdr_PowerEvents_13 implements JT808VtdrDataBlock {
    private List<Vtdr_PowerEvent> powerEvents;

    /**
     * 取外部供电记录列表
     * @return 外部供电记录列表
     */
    public List<Vtdr_PowerEvent> getPowerEvents() {
        return powerEvents;
    }

    /**
     * 设置外部供电记录列表
     * @param powerEvents 外部供电记录列表
     */
    public void setPowerEvents(List<Vtdr_PowerEvent> powerEvents) {
        this.powerEvents = powerEvents;
    }

    /**
     * 添加外部供电记录
     * @param powerEvent 外部供电记录
     */
    public void addPowerEvent(Vtdr_PowerEvent powerEvent) {
        if (this.powerEvents == null)
            this.powerEvents = new ArrayList<>();

        this.powerEvents.add(powerEvent);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808Vtdr_PowerEvents_13 source) {
        if (source.powerEvents != null) {
            this.powerEvents = new ArrayList<>();
            for (Vtdr_PowerEvent e : source.powerEvents)
                this.powerEvents.add(e.clone());
        } else
            this.powerEvents = null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_PowerEvents_13.class.getSimpleName() + "[", "]")
                .add("powerEvents=" + powerEvents)
                .toString();
    }

    @Override
    public JT808Vtdr_PowerEvents_13 clone() {
        JT808Vtdr_PowerEvents_13 r = new JT808Vtdr_PowerEvents_13();
        r.assignFrom(this);
        return r;
    }
}
