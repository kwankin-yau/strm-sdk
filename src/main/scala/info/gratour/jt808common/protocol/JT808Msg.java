package info.gratour.jt808common.protocol;

import java.util.Map;
import java.util.StringJoiner;

import info.gratour.jtcommon.JTMsg;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

/**
 * JT808 消息
 */ 
public class JT808Msg implements JTMsg {

    private int msgId;
    private String simNo;
    private int seqNo;
    private Map<String, Object> headers;

    /**
     * 构造函数
     */
    public JT808Msg() {
        msgId = jtMsgId();
    }

    /**
     * 构造函数
     * @param header 消息头
     */
    public JT808Msg(JT808FrameHeader header) {
        this.msgId = header.getMsgId();
        this.simNo = header.getSimNo();
        this.seqNo = header.getSeqNo();
    }

    /**
     * 取消息ID
     * @return 消息ID
     */
    @Override
    public int jtMsgId() {
        return getClass().getAnnotation(JTMsgId.class).value();
    }

    /**
     * 取消息ID
     * @return 消息ID
     */
    public int getMsgId() {
        return msgId;
    }

    /**
     * 设置消息ID
     * @param msgId 消息ID
     */
    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    /**
     * 取消息ID的HEX字符串
     * @return 消息ID的HEX字符串
     */
    public String msgIdToHex() {
        return JTUtils.msgIdToHex(msgId);
    }

    /**
     * 取终端识别号
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
     * 取消息序号
     * @return 消息序号
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * 设置消息序号
     * @param seqNo 消息序号
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * 取消息头。消息头用于存储消息的附加信息，如消息的来源、目的、时间戳等。
     * @return 消息头
     */
    public Map<String, Object> getHeaders() {
        return headers;
    }

    /**
     * 设置消息头。消息头用于存储消息的附加信息，如消息的来源、目的、时间戳等。
     * @param headers 消息头
     */
    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    /**
     * 将消息转换为字符串
     * @param joiner 字符串连接器
     * @return 字符串连接器
     */
    public StringJoiner toString(StringJoiner joiner) {
        joiner.add("msgId=" + JTUtils.msgIdToHex(msgId))
                .add("simNo='" + simNo + "'")
                .add("seqNo=" + seqNo)
                .add("headers=" + headers);

        return joiner;
    }

    @Override
    public String toString() {
        return toString(new StringJoiner(", ", JT808Msg.class.getSimpleName() + "[", "]")).toString();
    }
}
