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
 * 采集当前驾驶员信息应答数据(01H)
 */
@Expose
public class JT808Vtdr_DriverInfo_01 implements JT808VtdrDataBlock {

    private String licenseNo;

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

    @Override
    public JT808Vtdr_DriverInfo_01 clone() {
        try {
            return (JT808Vtdr_DriverInfo_01) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_DriverInfo_01.class.getSimpleName() + "[", "]")
                .add("licenseNo='" + licenseNo + "'")
                .toString();
    }
}
