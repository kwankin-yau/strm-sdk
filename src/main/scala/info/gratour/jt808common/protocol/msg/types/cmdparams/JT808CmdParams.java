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

@Expose
public interface JT808CmdParams extends Cloneable {

    default String toJson() {
        return JTConsts.GSON().toJson(this);
    }

    default String toJsonPretty() {
        return JTConsts.GSON_PRETTY().toJson(this);
    }

    JT808CmdParams clone();
}
