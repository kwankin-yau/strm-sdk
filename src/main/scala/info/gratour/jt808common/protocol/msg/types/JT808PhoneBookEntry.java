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
 * JT/T 808 电话簿条目
 */
@Expose
public class JT808PhoneBookEntry implements Cloneable {

    private byte typ;
    private String phoneNo;
    private String contacts;

    /**
     * 取类型, 0x01: 呼入, 0x02: 呼出, 0x03: 呼入/呼出
     * @return 类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置类型, 0x01: 呼入, 0x02: 呼出, 0x03: 呼入/呼出
     * @param typ 类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    /**
     * 取电话号码
     * @return 电话号码
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置电话号码
     * @param phoneNo 电话号码
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 取联系人
     * @return 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public JT808PhoneBookEntry clone() {
        try {
            return (JT808PhoneBookEntry) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808PhoneBookEntry{" +
                "typ=" + typ +
                ", phoneNo='" + phoneNo + '\'' +
                ", contacts='" + contacts + '\'' +
                '}';
    }
}
