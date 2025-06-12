/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 行驶记录仪状态信号名称集合
 */
@Expose
public class Vtdr_StatusSignalNames {

    private List<String> bitDesc;

    /**
     * 取状态信号名称列表
     * @return 状态信号名称列表
     */
    public List<String> getBitDesc() {
        return bitDesc;
    }

    /**
     * 设置状态信号名称列表
     * @param bitDesc 状态信号名称列表
     */
    public void setBitDesc(List<String> bitDesc) {
        this.bitDesc = bitDesc;
    }

    /**
     * 添加状态信号名称
     * @param bitDesc 状态信号名称
     */
    public void addBitDesc(String bitDesc) {
        if (this.bitDesc == null)
            this.bitDesc = new ArrayList<>();

        this.bitDesc.add(bitDesc);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_StatusSignalNames.class.getSimpleName() + "[", "]")
                .add("bitDesc=" + bitDesc)
                .toString();
    }
}
