package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

/**
 * 流统计采样
 */
public class StrmStatSampling {
    private long min;
    private long max;
    private double mean;
    private double p50;
    private double p75;
    private double p95;

    /**
     * 构造函数
     */
    public StrmStatSampling() {
    }

    /**
     * 构造函数
     * @param min 最小值
     * @param max 最大值
     * @param mean 平均值
     * @param p50 50%分位数
     * @param p75 75%分位数
     * @param p95 95%分位数
     */
    public StrmStatSampling(long min, long max, double mean, double p50, double p75, double p95) {
        this.min = min;
        this.max = max;
        this.mean = mean;
        this.p50 = p50;
        this.p75 = p75;
        this.p95 = p95;
    }

    /**
     * 获取最小值
     * @return 最小值
     */
    public long getMin() {
        return min;
    }

    /**
     * 设置最小值
     * @param min 最小值
     */
    public void setMin(long min) {
        this.min = min;
    }

    /**
     * 获取最大值
     * @return 最大值
     */
    public long getMax() {
        return max;
    }

    /**
     * 设置最大值
     * @param max 最大值
     */
    public void setMax(long max) {
        this.max = max;
    }

    /**
     * 获取平均值
     * @return 平均值
     */
    public double getMean() {
        return mean;
    }

    /**
     * 设置平均值
     * @param mean 平均值
     */
    public void setMean(double mean) {
        this.mean = mean;
    }

    /**
     * 获取50%分位数
     * @return 50%分位数
     */
    public double getP50() {
        return p50;
    }

    /**
     * 设置50%分位数
     * @param p50 50%分位数
     */
    public void setP50(double p50) {
        this.p50 = p50;
    }

    /**
     * 获取75%分位数
     * @return 75%分位数
     */
    public double getP75() {
        return p75;
    }

    /**
     * 设置75%分位数
     * @param p75 75%分位数
     */
    public void setP75(double p75) {
        this.p75 = p75;
    }

    /**
     * 获取95%分位数
     * @return 95%分位数
     */
    public double getP95() {
        return p95;
    }

    /**
     * 设置95%分位数
     * @param p95 95%分位数
     */
    public void setP95(double p95) {
        this.p95 = p95;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmStatSampling.class.getSimpleName() + "[", "]")
                .add("min=" + min)
                .add("max=" + max)
                .add("mean=" + mean)
                .add("p50=" + p50)
                .add("p75=" + p75)
                .add("p95=" + p95)
                .toString();
    }
}
