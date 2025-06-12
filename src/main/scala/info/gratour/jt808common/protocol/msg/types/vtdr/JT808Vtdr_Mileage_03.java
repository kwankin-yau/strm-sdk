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
 * 采集累计行驶里程信息应答数据(03H)
 */
@Expose
public class JT808Vtdr_Mileage_03 implements JT808VtdrDataBlock {

    private String dateTime;
    private String installTime;
    private float initMile;
    private float mile;

    /**
     * 取记录仪时间, yyyy-MM-dd HH:mm:ss
     * @return 记录仪时间
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 设置记录仪时间, yyyy-MM-dd HH:mm:ss
     * @param dateTime 记录仪时间
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 取安装时间, yyyy-MM-dd HH:mm:ss
     * @return 安装时间
     */
    public String getInstallTime() {
        return installTime;
    }

    /**
     * 设置安装时间, yyyy-MM-dd HH:mm:ss
     * @param installTime 安装时间
     */
    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    /**
     * 取初始里程, 单位: km
     * @return 初始里程
     */
    public float getInitMile() {
        return initMile;
    }

    /**
     * 设置初始里程, 单位: km
     * @param initMile 初始里程
     */
    public void setInitMile(float initMile) {
        this.initMile = initMile;
    }

    /**
     * 取累计里程, 单位: km
     * @return 累计里程
     */
    public float getMile() {
        return mile;
    }

    /**
     * 设置累计里程, 单位: km
     * @param mile 累计里程
     */
    public void setMile(float mile) {
        this.mile = mile;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_Mileage_03.class.getSimpleName() + "[", "]")
                .add("dateTime='" + dateTime + "'")
                .add("installTime='" + installTime + "'")
                .add("initMile=" + initMile)
                .add("mile=" + mile)
                .toString();
    }

    @Override
    public JT808Vtdr_Mileage_03 clone() {
        try {
            return (JT808Vtdr_Mileage_03) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
