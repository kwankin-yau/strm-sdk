/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jtcommon.JTConsts;

/**
 * 应答参数接口
 */
@Expose
public interface JT808AckParams {

    /**
     * 转换为 JSON 字符串（紧凑）
     * @return JSON 字符串
     */
    default String toJson() {
        return JTConsts.GSON().toJson(this);
    }

    /**
     * 转换为带换行缩进的 JSON 字符串
     * @return 带换行缩进的 JSON 字符串
     */
    default String toJsonPretty() {
        return JTConsts.GSON_PRETTY().toJson(this);
    }

    /**
     * 克隆此对象
     * @return 克隆对象
     */
    JT808AckParams clone();
}
