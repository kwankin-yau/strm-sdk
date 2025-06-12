/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 驾驶员身份记录
 */
@Expose
public class Vtdr_CardEvent implements Cloneable {

    /**
     * 登录
     */ 
    public static final int TYP_LOGIN = 1;

    /**
     * 登出
     */
    public static final int TYP_LOGOUT = 2;

    private String time;
    private String licenseNo;
    private byte typ;

    /**
     * 取事件时间, yyyy-MM-dd HH:mm:ss
     * @return 事件时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置事件时间, yyyy-MM-dd HH:mm:ss
     * @param time 事件时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 取驾驶证号
     * @return 驾驶证号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 设置驾驶证号
     * @param licenseNo 驾驶证号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * 取事件类型，为 {@link #TYP_LOGIN} 或 {@link #TYP_LOGOUT}
     * @return 事件类型
     */
    public byte getTyp() {
        return typ;
    }

    /**
     * 设置事件类型，为 {@link #TYP_LOGIN} 或 {@link #TYP_LOGOUT}
     * @param typ 事件类型
     */
    public void setTyp(byte typ) {
        this.typ = typ;
    }

    @Override
    public Vtdr_CardEvent clone() {
        try {
            return (Vtdr_CardEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_CardEvent.class.getSimpleName() + "[", "]")
                .add("time='" + time + "'")
                .add("licenseNo='" + licenseNo + "'")
                .add("typ=" + typ)
                .toString();
    }
}
