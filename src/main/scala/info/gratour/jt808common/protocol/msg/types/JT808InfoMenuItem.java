/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import com.lucendar.strm.common.types.Expose;

/**
 * JT/T 808 信息点播信息项
 */
@Expose
public class JT808InfoMenuItem implements Cloneable {

    private byte infoType;
    private String infoName;

    /**
     * 取信息类型
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
     * 取信息名称
     * @return 信息名称
     */
    public String getInfoName() {
        return infoName;
    }

    /**
     * 设置信息名称
     * @param infoName 信息名称
     */
    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    @Override
    public JT808InfoMenuItem clone() {
        try {
            return (JT808InfoMenuItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808InfoMenuItem{" +
                "infoType=" + infoType +
                ", infoName='" + infoName + '\'' +
                '}';
    }
}
