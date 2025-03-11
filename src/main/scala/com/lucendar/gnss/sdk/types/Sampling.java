package com.lucendar.gnss.sdk.types;

/**
 * 采样数据记录
 * 
 * @param name 名称
 * @param min 最小值
 * @param max 最大值
 * @param mean 平均值
 * @param p50 50%分位数
 * @param p75 75%分位数
 * @param p95 95%分位数
 */
public record Sampling(String name, long min, long max, double mean, double p50, double p75, double p95) {
}
