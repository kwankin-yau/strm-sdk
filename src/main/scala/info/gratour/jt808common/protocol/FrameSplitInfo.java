package info.gratour.jt808common.protocol;

/**
 * 帧分片信息
 */
public class FrameSplitInfo {

    private int totalPacket;
    private int packetSeqNo;

    /**
     * 获取总包数
     * @return 总包数
     */
    public int getTotalPacket() {
        return totalPacket;
    }

    /**
     * 设置总包数
     * @param totalPacket 总包数
     */
    public void setTotalPacket(int totalPacket) {
        this.totalPacket = totalPacket;
    }

    /**
     * 获取包序号
     * @return 包序号
     */
    public int getPacketSeqNo() {
        return packetSeqNo;
    }

    /**
     * 设置包序号
     * @param packetSeqNo 包序号
     */
    public void setPacketSeqNo(int packetSeqNo) {
        this.packetSeqNo = packetSeqNo;
    }

    @Override
    public String toString() {
        return "FrameSplitInfo{" +
                "totalPacket=" + totalPacket +
                ", packetSeqNo=" + packetSeqNo +
                '}';
    }
}
