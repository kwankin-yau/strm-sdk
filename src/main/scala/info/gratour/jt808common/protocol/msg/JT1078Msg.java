/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;

/**
 * JT1078 消息
 */
public class JT1078Msg extends JT808Msg {

    /**
     * 构造函数
     */
    public JT1078Msg() {
    }

    /**
     * 构造函数
     * @param header 消息头
     */
    public JT1078Msg(JT808FrameHeader header) {
        super(header);
    }
}
