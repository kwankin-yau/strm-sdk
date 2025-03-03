/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.Arrays;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808EventSetupItem;
import info.gratour.jtcommon.JTMsgId;

/**
 * 设置事件(0x8301)命令参数
 */
@JTMsgId(JT808MsgConsts.SET_UP_EVENT_8301)
@Expose
public class CP_8301_SetUpEvent implements JT808CmdParams {

    private byte typ;
    private JT808EventSetupItem[] events;

    /**
     * 获取操作类型
     * @return 操作类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置操作类型
     * @param typ 操作类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 获取事件项列表
     * @return 事件项列表
     */
    public JT808EventSetupItem[] getEvents() {
        return events;
    }

    /**
     * 设置事件项列表
     * @param events 事件项列表
     */
    public void setEvents(JT808EventSetupItem[] events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "CP_8301_SetUpEvent{" +
                "typ=" + typ +
                ", events=" + Arrays.toString(events) +
                '}';
    }

    @Override
    public CP_8301_SetUpEvent clone() {
        try {
            return (CP_8301_SetUpEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
