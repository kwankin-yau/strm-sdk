/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItemWithType;
import info.gratour.jtcommon.JTMsgId;

/**
 * ADAS报警附件文件项完成消息 (0x1212)
 */
@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_1212)
public class JTAdasMsg_1212_FileItemCompleted extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_1212;

    /**
     * 构造函数
     */
    public JTAdasMsg_1212_FileItemCompleted() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JTAdasMsg_1212_FileItemCompleted(JT808FrameHeader header) {
        super(header);
    }

    private AlmAttFileItemWithType item;

    /**
     * 获取文件项
     * @return 文件项
     */
    public AlmAttFileItemWithType getItem() {
        return item;
    }

    /**
     * 设置文件项
     * @param item 文件项
     */
    public void setItem(AlmAttFileItemWithType item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "JTAdasMsg_1212_FileItemCompleted{" +
                "item=" + item +
                '}';
    }
}
