/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.Arrays;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 删除路线(0x8607)命令参数
 */
@JTMsgId(JT808MsgConsts.DEL_ROUTE_8607)
@Expose
public class CP_8607_DelRoute implements JT808CmdParams {

    private int[] routeIds;

    /**
     * 获取路线ID列表
     * @return 路线ID列表
     */
    public int[] getRouteIds() {
        return routeIds;
    }

    /**
     * 设置路线ID列表
     * @param routeIds 路线ID列表
     */
    public void setRouteIds(int[] routeIds) {
        this.routeIds = routeIds;
    }

    @Override
    public CP_8607_DelRoute clone() {
        try {
            return (CP_8607_DelRoute) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "CP_8607_DelRoute{" +
                "routeIds=" + Arrays.toString(routeIds) +
                '}';
    }
}
