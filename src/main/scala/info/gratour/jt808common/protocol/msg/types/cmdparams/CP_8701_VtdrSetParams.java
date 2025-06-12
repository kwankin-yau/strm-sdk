/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VtdrDataBlock;
import info.gratour.jtcommon.JTMsgId;

/**
 * 车辆行驶记录仪参数设置(0x8701)命令参数
 */
@JTMsgId(JT808MsgConsts.VTDR_SET_PARAMS_8701)
@Expose
public class CP_8701_VtdrSetParams implements JT808CmdParams {

    private byte cmd;
    private JT808VtdrDataBlock dataBlock;

    /**
     * 获取命令
     * @return 命令
     */
    public byte getCmd() {
        return cmd;
    }

    /**
     * 设置命令
     * @param cmd 命令
     */
    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    /**
     * 获取数据块
     * @return 数据块
     */
    public JT808VtdrDataBlock getDataBlock() {
        return dataBlock;
    }

    /**
     * 设置数据块
     * @param dataBlock 数据块
     */
    public void setDataBlock(JT808VtdrDataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_8701_VtdrSetParams source) {
        this.cmd = source.cmd;
        this.dataBlock = source.dataBlock != null ? source.dataBlock.clone() : null;
    }

    @Override
    public CP_8701_VtdrSetParams clone() {
        CP_8701_VtdrSetParams r = new CP_8701_VtdrSetParams();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_8701_VtdrSetParams.class.getSimpleName() + "[", "]")
                .add("cmd=" + cmd)
                .add("dataBlock=" + dataBlock)
                .toString();
    }
}
