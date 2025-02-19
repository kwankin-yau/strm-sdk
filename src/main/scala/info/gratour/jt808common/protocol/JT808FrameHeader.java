package info.gratour.jt808common.protocol;

import info.gratour.jtcommon.JTUtils;

/**
 * JT808 帧头
 */
public class JT808FrameHeader {

    private int msgId;
    private int attr;
    private byte protoVer;
    private String simNo;
    private int seqNo;
    private FrameSplitInfo splitInfo;

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
    public String msgIdHex() {
        return JTUtils.msgIdToHex(msgId);
    }

    /**
     * 取消息属性
     * @return 消息属性
     */
    public int getAttr() {
        return attr;
    }

    /**
     * 设置消息属性
     * @param attr 消息属性
     */
    public void setAttr(int attr) {
        this.attr = attr;
    }

    /**
     * 取协议版本。0：2013版；1：2019版
     * @return 协议版本
     */
    public byte getProtoVer() {
        return protoVer;
    }

    /**
     * 设置协议版本
     * @param protoVer 协议版本
     */
    public void setProtoVer(byte protoVer) {
        this.protoVer = protoVer;
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
     * 取消息流水号
     * @return 消息流水号
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * 设置消息流水号
     * @param seqNo 消息流水号
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * 是否分包
     * @return 是否分包
     */
    public boolean isSplit() {
        return splitInfo != null;
    }

    /**
     * 取分包信息
     * @return 分包信息
     */
    public FrameSplitInfo getSplitInfo() {
        return splitInfo;
    }

    /**
     * 设置分包信息
     * @param splitInfo 分包信息
     */
    public void setSplitInfo(FrameSplitInfo splitInfo) {
        this.splitInfo = splitInfo;
    }

    @Override
    public String toString() {
        return "JT808FrameHeader{" +
                "msgId=" + JTUtils.msgIdToHex(msgId) +
                ", attr=" + JTUtils.intToHex(attr, 4) +
                ", protoVer=" + protoVer +
                ", simNo='" + simNo + '\'' +
                ", seqNo=" + seqNo +
                ", splitInfo=" + splitInfo +
                '}';
    }
}
