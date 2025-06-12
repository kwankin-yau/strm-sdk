/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

/**
 * 事件上报事件(0x0301)
 */
public class MQEventAddt_0301_EventReport implements MQEventAddt {

    private short eventId;

    /**
     * 获取事件 ID
     * @return 事件 ID
     */
    public short getEventId() {
        return eventId;
    }

    /**
     * 设置事件 ID
     * @param eventId 事件 ID
     */
    public void setEventId(short eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0301_EventReport{" +
                "eventId=" + eventId +
                '}';
    }
}
