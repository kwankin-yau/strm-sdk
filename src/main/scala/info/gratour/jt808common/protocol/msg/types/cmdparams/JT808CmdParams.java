/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jtcommon.JTConsts;

/**
 * JT808命令参数接口
 */
@Expose
public interface JT808CmdParams extends Cloneable {

    /**
     * 将命令参数转换为JSON字符串
     * @return JSON字符串
     */
    default String toJson() {
        return JTConsts.GSON().toJson(this);
    }

    /**
     * 将命令参数转换为美观的JSON字符串
     * @return 美观的JSON字符串
     */
    default String toJsonPretty() {
        return JTConsts.GSON_PRETTY().toJson(this);
    }

    /**
     * 克隆命令参数
     * @return 克隆的命令参数
     */
    JT808CmdParams clone();
}
