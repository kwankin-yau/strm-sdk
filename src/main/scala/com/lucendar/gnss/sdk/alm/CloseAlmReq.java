package com.lucendar.gnss.sdk.alm;

import com.lucendar.gnss.sdk.GnssConsts;
import info.gratour.jt808common.protocol.msg.types.trk.TrkAddt;

import java.util.StringJoiner;

/**
 * 关闭报警请求
 */
public class CloseAlmReq {

    private String id;
    private long tm1;

    private long tm0;
    private long recvTm0;
    private double lng0;
    private double lat0;
    private float spd0;
    private Float recSpd0;
    private short alt0;
    private short dir0;
    private TrkAddt addt0;

    /**
     * 取所要关闭的报警的ID
     * @return 所要关闭的报警的ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置所要关闭的报警的ID
     * @param id 所要关闭的报警的ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取报警发生时间，epoch millis
     * @return 报警发生时间，epoch millis
     */
    public long getTm1() {
        return tm1;
    }

    /**
     * 设置报警发生时间，epoch millis
     * @param tm1 报警发生时间，epoch millis
     */
    public void setTm1(long tm1) {
        this.tm1 = tm1;
    }

    /**
     * 取报警结束时间，epoch millis
     * @return 报警结束时间，epoch millis
     */
    public long getTm0() {
        return tm0;
    }

    /**
     * 设置报警结束时间，epoch millis
     * @param tm0 报警结束时间，epoch millis
     */
    public void setTm0(long tm0) {
        this.tm0 = tm0;
    }

    /**
     * 取报警结束的系统接收时间, epoch millis
     * @return 报警结束的系统接收时间, epoch millis
     */
    public long getRecvTm0() {
        return recvTm0;
    }

    /**
     * 设置报警结束的系统接收时间, epoch millis
     * @param recvTm0 报警结束的系统接收时间, epoch millis
     */
    public void setRecvTm0(long recvTm0) {
        this.recvTm0 = recvTm0;
    }

    /**
     * 取报警结束时的经度
     * @return 报警结束时的经度
     */
    public double getLng0() {
        return lng0;
    }

    /**
     * 设置报警结束时的经度
     * @param lng0 报警结束时的经度
     */
    public void setLng0(double lng0) {
        this.lng0 = lng0;
    }

    /**
     * 取报警结束时的纬度
     * @return 报警结束时的纬度
     */
    public double getLat0() {
        return lat0;
    }

    /**
     * 设置报警结束时的纬度
     * @param lat0 报警结束时的纬度
     */
    public void setLat0(double lat0) {
        this.lat0 = lat0;
    }

    /**
     * 取报警结束时的速度，km/h
     * @return 报警结束时的速度，km/h
     */
    public float getSpd0() {
        return spd0;
    }

    /**
     * 设置报警结束时的速度，km/h
     * @param spd0 报警结束时的速度，km/h
     */
    public void setSpd0(float spd0) {
        this.spd0 = spd0;
    }

    /**
     * 取报警结束时的行驶记录仪速度, km/h
     * @return 报警结束时的行驶记录仪速度, km/h
     */
    public Float getRecSpd0() {
        return recSpd0;
    }

    /**
     * 设置报警结束时的行驶记录仪速度, km/h
     * @param recSpd0 报警结束时的行驶记录仪速度, km/h
     */
    public void setRecSpd0(Float recSpd0) {
        this.recSpd0 = recSpd0;
    }

    /**
     * 取报警结束时的海拔，米
     * @return 报警结束时的海拔，米
     */
    public short getAlt0() {
        return alt0;
    }

    /**
     * 设置报警结束时的海拔，米
     * @param alt0 报警结束时的海拔，米
     */
    public void setAlt0(short alt0) {
        this.alt0 = alt0;
    }

    /**
     * 取报警结束时的方向, 0-359
     * @return 报警结束时的方向, 0-359
     */
    public short getDir0() {
        return dir0;
    }

    /**
     * 设置报警结束时的方向, 0-359
     * @param dir0 报警结束时的方向, 0-359
     */
    public void setDir0(short dir0) {
        this.dir0 = dir0;
    }

    /**
     * 取报警结束时的报警附加信息。结构暂定与轨迹附加信息相同，但只有与当前报警类型相关的属性。
     * @return 报警结束时的报警附加信息
     */
    public TrkAddt getAddt0() {
        return addt0;
    }

    /**
     * 设置报警结束时的报警附加信息。结构暂定与轨迹附加信息相同，但只有与当前报警类型相关的属性。
     * @param addt0 报警结束时的报警附加信息。
     */
    public void setAddt0(TrkAddt addt0) {
        this.addt0 = addt0;
    }

    /**
     * 将 addt0 转换成 JSON 字符串
     * @return 代表 addt0 的 JSON 字符串，如果 addt0 为 null ，则返回 null
     */
    public String addt0ToJson() {
        if (addt0 != null)
            return GnssConsts.GSON.toJson(addt0);
        else
            return null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CloseAlmReq.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("tm1=" + tm1)
                .add("tm0=" + tm0)
                .add("recvTm0=" + recvTm0)
                .add("lng0=" + lng0)
                .add("lat0=" + lat0)
                .add("spd0=" + spd0)
                .add("recSpd0=" + recSpd0)
                .add("alt0=" + alt0)
                .add("dir0=" + dir0)
                .add("addt0=" + addt0)
                .toString();
    }
}
