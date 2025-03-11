package com.lucendar.gnss.sdk.types;

import java.util.List;

/**
 * 服务运行统计
 * @param metrics 运行统计指标
 */
public record GnssServStat(List<Sampling> metrics) {
}
