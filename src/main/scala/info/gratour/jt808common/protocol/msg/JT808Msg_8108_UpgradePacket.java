package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 升级包消息(0x8108)
 */
@JTMsgId(JT808MsgConsts.UPGRADE_PACKET_8108)
public class JT808Msg_8108_UpgradePacket extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.UPGRADE_PACKET_8108;

    /**
     * 构造函数
     */
    public JT808Msg_8108_UpgradePacket() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_8108_UpgradePacket(JT808FrameHeader header) {
        super(header);
    }

    private int upgradeType;
    private String factoryId;
    private String version;
    private byte[] data;

    /**
     * 获取升级类型
     * 
     * @return 升级类型
     */
    public int getUpgradeType() {
        return upgradeType;
    }

    /**
     * 设置升级类型
     * 
     * @param upgradeType 升级类型
     */
    public void setUpgradeType(int upgradeType) {
        this.upgradeType = upgradeType;
    }

    /**
     * 获取厂家ID
     * 
     * @return 厂家ID
     */
    public String getFactoryId() {
        return factoryId;
    }

    /**
     * 设置厂家ID
     * 
     * @param factoryId 厂家ID
     */
    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    /**
     * 获取版本
     * 
     * @return 版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本
     * 
     * @param version 版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取数据
     * 
     * @return 数据
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 设置数据
     * 
     * @param data 数据
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT808Msg_8108_UpgradePacket{" +
                "upgradeType=" + upgradeType +
                ", factoryId='" + factoryId + '\'' +
                ", version='" + version + '\'' +
                "} " + super.toString();
    }
}
