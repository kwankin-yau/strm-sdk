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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTm1() {
        return tm1;
    }

    public void setTm1(long tm1) {
        this.tm1 = tm1;
    }

    public long getTm0() {
        return tm0;
    }

    public void setTm0(long tm0) {
        this.tm0 = tm0;
    }

    public long getRecvTm0() {
        return recvTm0;
    }

    public void setRecvTm0(long recvTm0) {
        this.recvTm0 = recvTm0;
    }

    public double getLng0() {
        return lng0;
    }

    public void setLng0(double lng0) {
        this.lng0 = lng0;
    }

    public double getLat0() {
        return lat0;
    }

    public void setLat0(double lat0) {
        this.lat0 = lat0;
    }

    public float getSpd0() {
        return spd0;
    }

    public void setSpd0(float spd0) {
        this.spd0 = spd0;
    }

    public Float getRecSpd0() {
        return recSpd0;
    }

    public void setRecSpd0(Float recSpd0) {
        this.recSpd0 = recSpd0;
    }

    public short getAlt0() {
        return alt0;
    }

    public void setAlt0(short alt0) {
        this.alt0 = alt0;
    }

    public short getDir0() {
        return dir0;
    }

    public void setDir0(short dir0) {
        this.dir0 = dir0;
    }

    public TrkAddt getAddt0() {
        return addt0;
    }

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
