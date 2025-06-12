/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import com.lucendar.strm.common.types.Expose;

/**
 * 采集记录仪数据块接口
 */
@Expose
public interface JT808VtdrDataBlock extends Cloneable {

    /**
     * 克隆
     * @return 克隆对象
     */
    JT808VtdrDataBlock clone();
}
