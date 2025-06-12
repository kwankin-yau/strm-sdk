/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.msgtransform;

import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.spi.model.TermCmd;

/**
 * 终端命令/消息转换器
 */
public interface TerminalCmdToMsgTransformer {

    /**
     * 转换终端命令为消息
     * @param cmd 终端命令
     * @return 消息
     */
    JT808Msg toMsg(TermCmd cmd);
}
