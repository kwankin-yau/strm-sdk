/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

/**
 * 信息点播事件(0x0303)
 */
public class MQEventAddt_0303_InfoDemand implements MQEventAddt {
    private byte infoType;
    private byte ctrlType;

    /**
     * 获取信息类型
     * @return 信息类型
     */
    public byte getInfoType() {
        return infoType;
    }

    /**
     * 设置信息类型
     * @param infoType 信息类型
     */
    public void setInfoType(byte infoType) {
        this.infoType = infoType;
    }

    /**
     * 获取控制类型
     * @return 控制类型。0x00: 订阅，0x01: 取消订阅
     */
    public byte getCtrlType() {
        return ctrlType;
    }

    /**
     * 设置控制类型
     * @param ctrlType 控制类型。0x00: 订阅，0x01: 取消订阅
     */
    public void setCtrlType(byte ctrlType) {
        this.ctrlType = ctrlType;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0303_InfoDemand{" +
                "infoType=" + infoType +
                ", ctrlType=" + ctrlType +
                '}';
    }
}
