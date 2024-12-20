package info.gratour.jt808common.spi.model;

import com.google.gson.reflect.TypeToken;
import info.gratour.jt808common.AdasDialect;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt;

import java.lang.reflect.Type;
import java.util.StringJoiner;

public class Event {

    public static final Type TYPE = new TypeToken<Event>(){}.getType();

    public static final String MSG_ID__ONLINE = "ONLINE";
    public static final String MSG_ID__OFFLINE = "OFFLINE";

    public static final String MSG_ID__0100_TERM_REGISTER = "0100";
    public static final String MSG_ID__0200_LOCATION = "0200";
    public static final String MSG_ID__0704_BATCH_LOCATION = "0704";
    public static final String MSG_ID__0301_EVENT_REPORT = "0301";
    public static final String MSG_ID__0303_INFO_DEMAND = "0303";
    public static final String MSG_ID__0701_WAY_BILL = "0701";
    public static final String MSG_ID__0702_DRIVER_IDENTITY = "0702";
    public static final String MSG_ID__0705_CAN_DATA = "0705";
    public static final String MSG_ID__0800_MULTI_MEDIA_EVENT = "0800";
    public static final String MSG_ID__0801_MULTI_MEDIA_DATA = "0801";
    public static final String MSG_ID__0900_PASS_THROUGH_UL = "0900";
    public static final String MSG_ID__1005_PASSENGER_TRAFFIC = "1005";


    private String msgId;
    private String appId;
    private String simNo;
    private long recvTm;
    private String adasDialect;
    private String protoVer;
    private MQEventAddt addt;

    /**
     * jt808/jt1078 message id or `ONLINE` or `OFFLINE`
     *
     * @return message id of the event
     */
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    /**
     * String value of {@link info.gratour.jt808common.AdasDialect}. Indicates the event is received from
     * the `JT/T 808` end point with the adasDialect.
     *
     * @return adasDialect using by the `JT/T 808` end point.
     */
    public String getAdasDialect() {
        return adasDialect;
    }

    public void setAdasDialect(String adasDialect) {
        this.adasDialect = adasDialect;
    }

    public AdasDialect adasDialect() {
        return AdasDialect.valueOf(adasDialect);
    }

    /**
     * 协议版本号。对于JT808 协议，0 为 2011/2013版, 1 为 2019版.
     *
     * @return 协议版本号
     */
    public String getProtoVer() {
        return protoVer;
    }

    public void setProtoVer(String protoVer) {
        this.protoVer = protoVer;
    }

    public MQEventAddt getAddt() {
        return addt;
    }

    public void setAddt(MQEventAddt addt) {
        this.addt = addt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                .add("msgId='" + msgId + "'")
                .add("appId='" + appId + "'")
                .add("simNo='" + simNo + "'")
                .add("recvTm=" + recvTm)
                .add("adasDialect='" + adasDialect + "'")
                .add("protoVer='" + protoVer + "'")
                .add("addt=" + addt)
                .toString();
    }
}
