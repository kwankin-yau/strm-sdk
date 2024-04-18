/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import info.gratour.jt808common.spi.model.Event;

public interface MQEventAddt {

    String MSG_ID__ONLINE = Event.MSG_ID__ONLINE;
    String MSG_ID__OFFLINE = Event.MSG_ID__OFFLINE;

    String MSG_ID__0100_TERM_REGISTER = Event.MSG_ID__0100_TERM_REGISTER;
    String MSG_ID__0200_LOCATION = Event.MSG_ID__0200_LOCATION;
    String MSG_ID__0704_BATCH_LOCATION = Event.MSG_ID__0704_BATCH_LOCATION;
    String MSG_ID__0301_EVENT_REPORT = Event.MSG_ID__0301_EVENT_REPORT;
    String MSG_ID__0303_INFO_DEMAND = Event.MSG_ID__0303_INFO_DEMAND;
    String MSG_ID__0701_WAY_BILL = Event.MSG_ID__0701_WAY_BILL;
    String MSG_ID__0702_DRIVER_IDENTITY = Event.MSG_ID__0702_DRIVER_IDENTITY;
    String MSG_ID__0705_CAN_DATA = Event.MSG_ID__0705_CAN_DATA;
    String MSG_ID__0800_MULTI_MEDIA_EVENT = Event.MSG_ID__0800_MULTI_MEDIA_EVENT;
    String MSG_ID__0801_MULTI_MEDIA_DATA = Event.MSG_ID__0801_MULTI_MEDIA_DATA;
    String MSG_ID__0900_PASS_THROUGH_UL = Event.MSG_ID__0900_PASS_THROUGH_UL;
    String MSG_ID__1005_PASSENGER_TRAFFIC = Event.MSG_ID__1005_PASSENGER_TRAFFIC;
}
