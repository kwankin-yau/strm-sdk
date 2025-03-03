package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 升级结果消息 (0x0108)
 */
@JTMsgId(JT808MsgConsts.UPGRADE_RESULT_0108)
public class JT808Msg_0108_UpgradeResult extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.UPGRADE_RESULT_0108;

    /**
     * 构造函数
     */
    public JT808Msg_0108_UpgradeResult() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * 
     * @param header 帧头
     */
    public JT808Msg_0108_UpgradeResult(JT808FrameHeader header) {
        super(header);
    }

    private byte upgradeType;
    private byte result;

    /**
     * 获取升级类型
     * 
     * @return 升级类型
     */
    public byte getUpgradeType() {
        return upgradeType;
    }

    /**
     * 设置升级类型
     * 
     * @param upgradeType 升级类型
     */
    public void setUpgradeType(byte upgradeType) {
        this.upgradeType = upgradeType;
    }

    /**
     * 获取升级结果
     * 
     * @return 升级结果
     */
    public byte getResult() {
        return result;
    }

    /**
     * 设置升级结果
     * 
     * @param result 升级结果
     */
    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT808Msg_0108_UpgradeResult{" +
                "upgradeType=" + upgradeType +
                ", result=" + result +
                "} " + super.toString();
    }
}
