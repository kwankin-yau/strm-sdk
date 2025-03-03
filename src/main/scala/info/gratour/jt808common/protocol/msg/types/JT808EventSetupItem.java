/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import com.lucendar.strm.common.types.Expose;

/**
 * JT/T 808 事件设置项
 */
@Expose
public class JT808EventSetupItem {

    private byte evtId;
    private String evtContent;

    /**
     * 取事件 ID
     * @return 事件 ID
     */
    public byte getEvtId() {
        return evtId;
    }

    /**
     * 设置事件 ID
     * @param evtId 事件 ID
     */
    public void setEvtId(byte evtId) {
        this.evtId = evtId;
    }

    /**
     * 取事件内容
     * @return 事件内容
     */
    public String getEvtContent() {
        return evtContent;
    }

    /**
     * 设置事件内容
     * @param evtContent 事件内容
     */
    public void setEvtContent(String evtContent) {
        this.evtContent = evtContent;
    }

    @Override
    public String toString() {
        return "JT808EventSetupItem{" +
                "evtId=" + evtId +
                ", evtContent='" + evtContent + '\'' +
                '}';
    }
}
