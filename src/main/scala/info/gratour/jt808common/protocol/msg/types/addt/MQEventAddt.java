/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import info.gratour.jt808common.spi.model.Event;

/**
 * 事件附加信息
 */
public interface MQEventAddt {

    /**
     * 在线事件消息 ID
     */
    String MSG_ID__ONLINE = Event.MSG_ID__ONLINE;

    /**
     * 离线事件消息 ID
     */
    String MSG_ID__OFFLINE = Event.MSG_ID__OFFLINE;

    /**
     * 终端注册事件消息 ID
     */
    String MSG_ID__0100_TERM_REGISTER = Event.MSG_ID__0100_TERM_REGISTER;

    /**
     * 位置事件消息 ID
     */
    String MSG_ID__0200_LOCATION = Event.MSG_ID__0200_LOCATION;

    /**
     * 批量位置事件消息 ID
     */
    String MSG_ID__0704_BATCH_LOCATION = Event.MSG_ID__0704_BATCH_LOCATION;

    /**
     * 事件报告消息 ID
     */
    String MSG_ID__0301_EVENT_REPORT = Event.MSG_ID__0301_EVENT_REPORT;

    /**
     * 信息服务请求消息 ID
     */
    String MSG_ID__0303_INFO_DEMAND = Event.MSG_ID__0303_INFO_DEMAND;

    /**
     * 电子运单上报事件消息 ID
     */
    String MSG_ID__0701_WAY_BILL = Event.MSG_ID__0701_WAY_BILL;

    /**
     * 驾驶员身份事件消息 ID
     */
    String MSG_ID__0702_DRIVER_IDENTITY = Event.MSG_ID__0702_DRIVER_IDENTITY;

    /**
     * CAN 数据事件消息 ID
     */
    String MSG_ID__0705_CAN_DATA = Event.MSG_ID__0705_CAN_DATA;

    /**
     * 多媒体事件消息 ID
     */
    String MSG_ID__0800_MULTI_MEDIA_EVENT = Event.MSG_ID__0800_MULTI_MEDIA_EVENT;

    /**
     * 多媒体数据事件消息 ID
     */
    String MSG_ID__0801_MULTI_MEDIA_DATA = Event.MSG_ID__0801_MULTI_MEDIA_DATA;

    /**
     * 透传上行事件消息 ID
     */
    String MSG_ID__0900_PASS_THROUGH_UL = Event.MSG_ID__0900_PASS_THROUGH_UL;

    /**
     * 乘客流量事件消息 ID
     */
    String MSG_ID__1005_PASSENGER_TRAFFIC = Event.MSG_ID__1005_PASSENGER_TRAFFIC;
}
