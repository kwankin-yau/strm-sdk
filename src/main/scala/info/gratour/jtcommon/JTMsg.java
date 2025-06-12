/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtcommon;

/**
 * JT标准 消息的基本接口  
 */
public interface JTMsg {

    /**
     * 取消息ID
     * @return 消息ID
     */
    int jtMsgId();

    /**
     * 取消息ID的HEX字符串
     * @return 消息ID的HEX字符串
     */
    default String jtMsgIdToHex() {
        return JTUtils.msgIdToHex(jtMsgId());
    }

}
