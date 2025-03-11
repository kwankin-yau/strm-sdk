/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.db;

/**
 * Sequence 定义
 */
public class SeqValues {

    /**
     * Sequence配置
     * @param seqName Sequence 名称
     * @param incr 步进，每次取新的 sequence 值后，下一个 sequence 值的增量
     */
    public record SeqValueConfig(String seqName, int incr){}

    /**
     * 轨迹ID sequence
     */
    public static final String SEQ_TRK_ID = "s_trk_id";

    /**
     * 报警ID sequence
     */
    public static final String SEQ_ALM_ID = "s_alm_id";

    /**
     * 轨迹ID sequence 配置
     */
    public static final SeqValueConfig TrkIdConfig = new SeqValueConfig(SEQ_TRK_ID, 100000);

    /**
     * 报警ID sequence 配置
     */
    public static final SeqValueConfig AlmIdConfig = new SeqValueConfig(SEQ_ALM_ID, 15000);

}
