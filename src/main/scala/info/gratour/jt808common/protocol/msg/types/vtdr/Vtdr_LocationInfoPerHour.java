/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 位置与速度信息列表
 */
@Expose
public class Vtdr_LocationInfoPerHour implements Cloneable {

    private String startTime;
    private List<Vtdr_LocationAndSpd> locationAndSpd;

    /**
     * 取开始时间, yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间, yyyy-MM-dd HH:mm:ss
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取位置与速度信息列表
     * @return 位置与速度信息列表
     */
    public List<Vtdr_LocationAndSpd> getLocationAndSpd() {
        return locationAndSpd;
    }

    /**
     * 设置位置与速度信息列表
     * @param locationAndSpd 位置与速度信息列表
     */
    public void setLocationAndSpd(List<Vtdr_LocationAndSpd> locationAndSpd) {
        this.locationAndSpd = locationAndSpd;
    }

    /**
     * 添加位置与速度信息
     * @param locationAndSpd 位置与速度信息
     */
    public void addLcoationAndSpd(Vtdr_LocationAndSpd locationAndSpd) {
        if (this.locationAndSpd == null)
            this.locationAndSpd = new ArrayList<>();

        this.locationAndSpd.add(locationAndSpd);
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(Vtdr_LocationInfoPerHour source) {
        this.startTime = source.startTime;
        if (source.locationAndSpd != null) {
            this.locationAndSpd = new ArrayList<>();
            for (Vtdr_LocationAndSpd e : source.locationAndSpd)
                this.locationAndSpd.add(e.clone());
        } else
            this.locationAndSpd = null;
    }

    @Override
    public Vtdr_LocationInfoPerHour clone() {
        Vtdr_LocationInfoPerHour r = new Vtdr_LocationInfoPerHour();
        r.assignFrom(this);
        return  r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_LocationInfoPerHour.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("locationAndSpd=" + locationAndSpd)
                .toString();
    }
}
