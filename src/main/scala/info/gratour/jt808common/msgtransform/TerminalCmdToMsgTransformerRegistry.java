/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.msgtransform;

/**
 * 终端命令/消息转换器注册表
 */
public interface TerminalCmdToMsgTransformerRegistry {

    /**
     * 获取终端命令/消息转换器
     * @param msgId 消息 ID
     * @return 终端命令/消息转换器
     */
    TerminalCmdToMsgTransformer get(int msgId);
}
