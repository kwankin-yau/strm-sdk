/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.protocol.msg.types.trk;

import info.gratour.jt808common.AdasDialect;

/**
 * ADAS报警附加信息
 */
public abstract class AdasAddt {

    private final AdasDialect adasDialect;

    /**
     * 构造函数
     *
     * @param adasDialect ADAS 方言
     */
    public AdasAddt(AdasDialect adasDialect) {
        this.adasDialect = adasDialect;
    }

    /**
     * 取附加信息所执行的 ADAS 方言
     *
     * @return 附加信息所执行的 ADAS 方言
     */
    public AdasDialect getAdasDialect() {
        return adasDialect;
    }
}
