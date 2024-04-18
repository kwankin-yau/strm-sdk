/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.msgtransform;

public interface TerminalCmdToMsgTransformerRegistry {

    TerminalCmdToMsgTransformer get(int msgId);
}
