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
 * 删除矩形区域(0x8603)命令参数
 */
@JTMsgId(JT808MsgConsts.DEL_RECT_REGION_8603)
@Expose
public class CP_8603_DelRectRegion implements JT808CmdParams {

    private int[] regionIds;

    /**
     * 获取矩形区域ID列表
     * @return 矩形区域ID列表
     */
    public int[] getRegionIds() {
        return regionIds;
    }

    /**
     * 设置矩形区域ID列表
     * @param regionIds 矩形区域ID列表
     */
    public void setRegionIds(int[] regionIds) {
        this.regionIds = regionIds;
    }

    @Override
    public String toString() {
        return "CP_8603_DelRectRegion{" +
                "regionIds=" + Arrays.toString(regionIds) +
                '}';
    }

    @Override
    public CP_8603_DelRectRegion clone() {
        try {
            return (CP_8603_DelRectRegion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
