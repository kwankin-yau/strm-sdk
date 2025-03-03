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
 * 采集记录仪参数修改记录应答数据(14H)
 */
@Expose
public class JT808Vtdr_RevEvents_14 implements JT808VtdrDataBlock {

    private List<Vtdr_RevEvent> revEvents;

    /**
     * 取参数修改事件记录列表
     * @return 参数修改事件记录列表
     */
    public List<Vtdr_RevEvent> getRevEvents() {
        return revEvents;
    }

    /**
     * 设置参数修改事件记录列表
     * @param revEvents 参数修改事件记录列表
     */
    public void setRevEvents(List<Vtdr_RevEvent> revEvents) {
        this.revEvents = revEvents;
    }

    /**
     * 添加参数修改事件记录
     * @param event 参数修改事件记录
     */
    public void addRevEvent(Vtdr_RevEvent event) {
        if (this.revEvents == null)
            this.revEvents = new ArrayList<>();

        this.revEvents.add(event);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(JT808Vtdr_RevEvents_14 source) {
        if (source.revEvents != null) {
            this.revEvents = new ArrayList<>();
            for (Vtdr_RevEvent e : source.revEvents)
                this.revEvents.add(e.clone());
        } else
            this.revEvents = null;
    }

    @Override
    public JT808Vtdr_RevEvents_14 clone() {
        JT808Vtdr_RevEvents_14 r = new JT808Vtdr_RevEvents_14();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_RevEvents_14.class.getSimpleName() + "[", "]")
                .add("revEvents=" + revEvents)
                .toString();
    }
}
