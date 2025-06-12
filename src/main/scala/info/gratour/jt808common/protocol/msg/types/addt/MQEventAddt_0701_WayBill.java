/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

/**
 * 电子运单上报事件(0x0701)
 */
public class MQEventAddt_0701_WayBill implements MQEventAddt {

    private String content;

    /**
     * 获取电子运单内容
     * @return 电子运单内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置电子运单内容
     * @param content 电子运单内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0701_WayBill{" +
                "content='" + content + '\'' +
                '}';
    }
}
