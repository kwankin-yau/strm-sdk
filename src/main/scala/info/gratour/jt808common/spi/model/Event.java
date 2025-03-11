package info.gratour.jt808common.spi.model;

import java.lang.reflect.Type;
import java.util.StringJoiner;

import com.google.gson.reflect.TypeToken;

import info.gratour.jt808common.AdasDialect;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt;

/**
 * 终端数据上传事件
 */
public class Event {

    /**
     * 类型对象，用于 GSON 序列化/反序列化
     */
    public static final Type TYPE = new TypeToken<Event>(){}.getType();

    /**
     * 在线事件消息ID
     */
    public static final String MSG_ID__ONLINE = "ONLINE";

    /**
     * 离线事件消息ID
     */
    public static final String MSG_ID__OFFLINE = "OFFLINE";

    /**
     * 终端注册消息ID
     */ 
    public static final String MSG_ID__0100_TERM_REGISTER = "0100";

    /**
     * 位置消息ID
     */
    public static final String MSG_ID__0200_LOCATION = "0200";

    /**
     * 批量位置消息ID
     */
    public static final String MSG_ID__0704_BATCH_LOCATION = "0704";

    /**
     * 事件报告消息ID
     */
    public static final String MSG_ID__0301_EVENT_REPORT = "0301";

    /**
     * 信息服务请求消息ID
     */
    public static final String MSG_ID__0303_INFO_DEMAND = "0303";

    /**
     * 电子运单消息ID
     */
    public static final String MSG_ID__0701_WAY_BILL = "0701";

    /**
     * 驾驶员身份信息消息ID
     */
    public static final String MSG_ID__0702_DRIVER_IDENTITY = "0702";

    /**
     * 车辆CAN数据消息ID
     */
    public static final String MSG_ID__0705_CAN_DATA = "0705";

    /**
     * 多媒体事件消息ID
     */
    public static final String MSG_ID__0800_MULTI_MEDIA_EVENT = "0800";

    /**
     * 多媒体数据消息ID
     */
    public static final String MSG_ID__0801_MULTI_MEDIA_DATA = "0801";

    /**
     * 透传上行消息ID
     */
    public static final String MSG_ID__0900_PASS_THROUGH_UL = "0900";

    /**
     * 乘客流量消息ID
     */
    public static final String MSG_ID__1005_PASSENGER_TRAFFIC = "1005";

    /**
     * 驾驶员身份信息消息ID
     */
    public static final String MSG_ID__1006_DRIVER_IDENTITY = "1006";

    private String msgId;
    private String appId;
    private String simNo;
    private long recvTm;
    private String adasDialect;
    private String protoVer;
    private MQEventAddt addt;

    /**
     * 获取消息ID
     *
     * @return 消息ID, 或者 `ONLINE` 或 `OFFLINE`
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置消息ID
     * @param msgId 消息ID
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * 获取AppId
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置AppId
     * @param appId AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 获取接收时间, epoch-millis
     * @return 接收时间
     */
    public long getRecvTm() {
        return recvTm;
    }

    /**
     * 设置接收时间
     * @param recvTm 接收时间
     */
    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    /**
     * 获取ADAS方言，为 AdasDialect 的 name() 值
     * @return ADAS方言
     */
    public String getAdasDialect() {
        return adasDialect;
    }

    /**
     * 设置ADAS方言
     * @param adasDialect ADAS方言
     */
    public void setAdasDialect(String adasDialect) {
        this.adasDialect = adasDialect;
    }

    /**
     * 获取ADAS方言
     * @return ADAS方言
     */
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

    /**
     * 设置协议版本号
     * @param protoVer 协议版本号
     */
    public void setProtoVer(String protoVer) {
        this.protoVer = protoVer;
    }

    /**
     * 获取附加数据
     * @return 附加数据
     */
    public MQEventAddt getAddt() {
        return addt;
    }

    /**
     * 设置附加数据
     * @param addt 附加数据
     */
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
