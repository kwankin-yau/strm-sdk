package com.lucendar.gnss.sdk.gateway;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 重置轨迹计数器请求
 */
public class ResetTrkCounterReq {

    private String[] simNos;

    /**
     * 构造函数
     */
    public ResetTrkCounterReq() {
    }

    /**
     * 构造函数
     * @param simNos 终端识别号
     */
    public ResetTrkCounterReq(String[] simNos) {
        this.simNos = simNos;
    }

    /**
     * 获取终端识别号
     * @return 终端识别号
     */
    public String[] getSimNos() {
        return simNos;
    }

    /**
     * 设置终端识别号
     * @param simNos 终端识别号
     */
    public void setSimNos(String[] simNos) {
        this.simNos = simNos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResetTrkCounterReq.class.getSimpleName() + "[", "]")
                .add("simNos=" + Arrays.toString(simNos))
                .toString();
    }
}
